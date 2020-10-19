/**
 *
 */
package com.ssxs.appmodel.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import com.ssxs.util.security.MD5PwdInputUtil;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 各种实体的抽象，包括对物理id，版本号，创建时间，修改时间，销毁时间
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/8/9 16:12
 * modifyTime:
 * modifyBy:
 */
public abstract class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 4785774977409879152L;

    /**
     * 实体唯一的标识符，用基本类型
     * Long 有一个坑，就是有长度限制，装箱类型，全部采用Equals进行比较
     * <p>
     * Long al=127l;
     * Long bl=127l;
     * System.out.println(al==bl);//true -128-127之间,同int
     * Long cl=128l;
     * Long dl=128l;
     * System.out.println(cl==dl);//false 不在-128-127之间,同int
     *
     */
    @TableId
    private Long id = 0L;
    /**
     * 实体或者对象的版本号，乐观锁，用基本类型<br>
     * 此处要注意，版本号的更新问题。
     */
    @Version
    private Long version = 1L;
    /**
     * 创建时间，直接使用jdk8的time api
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    /**
     * 修改时间，直接使用jdk8的time api
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modifyTime;
    /**
     * 销毁时间，物理上不删除，直接使用jdk8的time api
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime abolishTime;
    /**
     * 分表的后缀
     * 此处注解，使用的是mybatis-plus的注解
     */
    @TableField(exist = false)
    private String tableSuffix;
    /**
     * 逻辑删除，物理上不删除
     */
    @TableLogic
    @TableField(exist = false)
    private Integer deleted = 1;

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * @return
     * @version v1.0
     * @author Haixiang Dai
     * @createTime: 2013-5-17 上午11:31:53
     * @modifyTime:
     */
    public String encodeFiled() {
        StringBuilder originalFiled = getOriginalFiled();
        if (originalFiled != null) {
            return MD5PwdInputUtil.getEncryptedPwd(originalFiled.toString());
        }
        return null;
    }

    /**
     * @return
     * @version v1.0
     * @author Haixiang Dai
     * @createTime: 2013-5-17 上午11:34:36
     * @modifyTime:
     */
    public StringBuilder getOriginalFiled() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public LocalDateTime getAbolishTime() {
        return abolishTime;
    }

    public void setAbolishTime(LocalDateTime abolishTime) {
        this.abolishTime = abolishTime;
    }

    public String getTableSuffix() {
        return tableSuffix;
    }

    public void setTableSuffix(String tableSuffix) {
        this.tableSuffix = tableSuffix;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
}
