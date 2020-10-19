/**
 *
 */
package com.ssxs.appmodel.domain.result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ssxs.appmodel.constant.UnknownErrorCodeConstant;
import org.apache.commons.text.TextStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 结果封装的基类，这样定义泛型，实现链式的方法使用，主要是在服务之间传递业务异常和系统异常，打印日志
 * 如果需要，可以根据具体的业务，进行result的扩展，以方便不同的应用
 * 也可以使用抽象一个vo对象，再使用modelResult
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2019/1/22 16:47
 * modifyTime:
 * modifyBy:
 */
@SuppressWarnings("rawtypes")
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 6793950765226349967L;
    private transient final Logger log = LoggerFactory.getLogger(getClass());
    private transient boolean loggedException = false;
    private transient boolean loggedWarn = false;
    /**
     * 给终端用户的错误提示, 可同时多个错误在一次交互中返回
     */
    private Map<String, String> errorList = new HashMap<>();
    /**
     * 给其他模块开发者的提示信息
     */
    private Collection<String> warnList = new HashSet<>();
    /**
     * 出错时的重要输入参数
     */
    private String inputParamWhereCatch;
    /**
     * 异常时的堆栈，可网络两端都log，加大异常的知晓机会
     */
    private String detailStack;

    public BaseResult() {
        loggedException = false;
        loggedWarn = false;
    }

    /**
     * 为false，表示一定是业务异常，返回业务异常信息
     * 为true，表示有可能发生系统异常，但业务请求的成功与否，视具体的接口定义/javadoc说明
     *
     * @return
     * @version v1.0
     * @author Haixiang Dai
     * @createTime: 2013-5-21 下午4:19:43
     * @modifyTime:
     */
    public boolean isSuccess() {
        // 系统异常信息
        if (!loggedException && detailStack != null) {
            log.error("{inputParamWhereCatch:'" + inputParamWhereCatch + "'}\r\n" + detailStack);
            loggedException = true;
        }

        // 给下游开发者的提示信息
        if (!loggedWarn && !warnList.isEmpty()) {
            log.warn("{warnList:" + warnList.toString() + "}");
            loggedWarn = true;
        }

        // 业务异常信息
        boolean isEmpty = errorList.isEmpty();
        if (!isEmpty) {
            for (Map.Entry<String, String> entry : errorList.entrySet()) {
                String msg = UnknownErrorCodeConstant.getMsg(entry.getKey());
                if (msg != null) {
                    entry.setValue(msg);
                }
            }
        }
        return isEmpty;
    }

    /**
     * 系统异常，返回系统异常信息
     *
     * @return
     */
    public boolean isSysFailure() {
        return loggedException;
    }

    /**
     * 业务异常，返回业务异常信息
     *
     * @return
     */
    public boolean isFailure() {
        return !isSuccess();
    }

    /**
     * 非测试调试状态下(线上)少用这个，线上可以不log业务主动发现的问题，如密码不对，这里的error是业务异常
     *
     * @return
     */
    public boolean isSuccessAndLogError() {
        boolean success = isSuccess();
        if (!success) {
            log.error("{errorList:'" + errorList.toString() + "'}");
        }
        return success;
    }

    /**
     * 先判断isSuccess()才能用，多重错误时可转用getErrorList()
     *
     * @return
     */
    public String getErrorMsg() {
        if (errorList.isEmpty()) {
            return "";
        }
        return errorList.values().iterator().next();
    }

    /**
     * 不适合时，可转用getErrorList()
     *
     * @param seperator
     * @param displayCount
     * @return
     */
    public String getErrorMsg(String seperator, int displayCount) {
        int count = 0;
        StringBuilder sb = new StringBuilder(60);
        for (String msg : errorList.values()) {
            sb.append(msg).append(seperator);
            count++;
            if (count > displayCount) {
                sb.append("还有" + (errorList.size() - displayCount) + "个错误信息未显示" + seperator);
                break;
            }
        }
        sb.delete(sb.length() - seperator.length(), sb.length());
        return sb.toString();
    }

    /**
     * 先判断isSuccess()才能用。
     *
     * @return
     */
    public String getErrorCode() {
        if (errorList.isEmpty()) {
            return "";
        }
        return errorList.keySet().iterator().next();
    }

    /**
     * 如果log出重要输入参数能有助事情的话，请选用带inputParamWhereCatch的方法
     *
     * @param errorCode 定义规范 errorCode 英文，不超过50长度，以“点”分隔，：“粗模块.细模块.错误意思"
     *                  <p>
     *                  errorCode规范详见 errorCode 英文，不超过50长度，以“点”分隔，：“粗模块.细模块.错误意思"
     * @param errorMsg
     * @return
     * @version v1.0
     * @author Haixiang Dai
     * @createTime: 2013-5-23 下午2:48:59
     * @modifyTime:
     */
    public <SubClass extends BaseResult> SubClass withError(String errorCode, String errorMsg) {
        errorList.put(errorCode, errorMsg);
        return (SubClass) this;
    }

    /**
     * @param errorCode 英文，不超过50长度，以“点”分隔，：“粗模块.细模块.错误意思"
     * @return
     * @version V1.0
     * @author Haixiang Dai <br>
     * @createTime: 2013-6-8 下午3:34:03
     * @modifyTime:
     */
    public <SubClass extends BaseResult> SubClass withError(String errorCode) {
        String msg = UnknownErrorCodeConstant.getMsg(errorCode);
        if (msg == null) {
            msg = "遇到错误[" + errorCode + "],请截屏后告知客服检查或自行重试";
        }
        errorList.put(errorCode, msg);
        return (SubClass) this;
    }

    /**
     * @param errorCode            英文，不超过50长度，以“点”分隔，：“粗模块.细模块.错误意思"
     * @param errorMsg
     * @param inputParamWhereCatch
     * @return
     * @version v1.0
     * @author Haixiang Dai
     * @createTime: 2013-5-23 下午2:48:57
     * @modifyTime:
     */
    public <SubClass extends BaseResult> SubClass withError(String errorCode, String errorMsg,
                                                            String inputParamWhereCatch) {
        errorList.put(errorCode, errorMsg);
        this.inputParamWhereCatch = inputParamWhereCatch;
        return (SubClass) this;
    }

    /**
     * 只会包含convert错误信息过去，所以命名toErrorResult()
     *
     * @param result
     * @return
     */
    public <SubClass extends BaseResult> SubClass toErrorResult(SubClass result) {
        result.setErrorList(errorList);
        result.setWarnList(warnList);
        result.setInputParamWhereCatch(inputParamWhereCatch);
        result.setDetailStack(detailStack);
        return result;
    }

    /**
     * @param inputParamWhereCatch
     * @param e
     * @return
     * @version V1.0
     * @author Haixiang Dai <br>
     * @createTime: 2013-6-8 下午3:06:07
     * @modifyTime:
     */
    public <SubClass extends BaseResult> SubClass withErrorAndLog(String inputParamWhereCatch, Throwable e) {
        return withErrorAndLog(UnknownErrorCodeConstant.exceptionCanRetry,
                UnknownErrorCodeConstant.getMsg(UnknownErrorCodeConstant.exceptionCanRetry), inputParamWhereCatch, e);
    }

    /**
     * @param errorCode            英文，不超过50长度，以“点”分隔，：“粗模块.细模块.错误意思"
     * @param inputParamWhereCatch
     * @param e
     * @return
     * @version v1.0
     * @author Haixiang Dai
     * @createTime: 2013-5-23 下午2:49:11
     * @modifyTime:
     */
    public <SubClass extends BaseResult> SubClass withErrorAndLog(String errorCode, String inputParamWhereCatch,
                                                                  Throwable e) {
        return withErrorAndLog(errorCode, UnknownErrorCodeConstant.getMsg(errorCode), inputParamWhereCatch, e);
    }

    /**
     * @param errorCode            英文，不超过50长度，以“点”分隔，：“粗模块.细模块.错误意思"
     * @param errorMsg
     * @param inputParamWhereCatch
     * @param e
     * @return
     * @version v1.0
     * @author Haixiang Dai
     * @createTime: 2013-5-23 下午2:49:13
     * @modifyTime:
     */
    public <SubClass extends BaseResult> SubClass withErrorAndLog(String errorCode, String errorMsg,
                                                                  String inputParamWhereCatch, Throwable e) {
        TextStringBuilder sb = new TextStringBuilder(1024);
        sb.append("{errorCode:'").append(errorCode).append("',errorMsg:'").append(errorMsg)
                .append("', inputParamWhereCatch:'").append(inputParamWhereCatch).append("'}");
        log.error(sb.toString(), e);
        withError(errorCode, errorMsg, inputParamWhereCatch);
        sb.clear();
        for (StackTraceElement line : e.getStackTrace()) {
            sb.append("\tat ").append(line);
        }
        this.detailStack = sb.toString();
        return (SubClass) this;
    }

    /**
     * @param msg
     * @param <SubClass>
     * @return
     */
    public <SubClass extends BaseResult> SubClass addWarn(String msg) {
        warnList.add(msg);
        return (SubClass) this;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

    public boolean isLoggedException() {
        return loggedException;
    }

    public void setLoggedException(boolean loggedException) {
        this.loggedException = loggedException;
    }

    public boolean isLoggedWarn() {
        return loggedWarn;
    }

    public void setLoggedWarn(boolean loggedWarn) {
        this.loggedWarn = loggedWarn;
    }

    public Map<String, String> getErrorList() {
        return errorList;
    }

    public void setErrorList(Map<String, String> errorList) {
        this.errorList = errorList;
    }

    public Collection<String> getWarnList() {
        return warnList;
    }

    public void setWarnList(Collection<String> warnList) {
        this.warnList = warnList;
    }

    public String getInputParamWhereCatch() {
        return inputParamWhereCatch;
    }

    public void setInputParamWhereCatch(String inputParamWhereCatch) {
        this.inputParamWhereCatch = inputParamWhereCatch;
    }

    public String getDetailStack() {
        return detailStack;
    }

    public void setDetailStack(String detailStack) {
        this.detailStack = detailStack;
    }
}
