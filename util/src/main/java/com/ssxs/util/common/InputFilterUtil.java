/**
 *
 */
package com.ssxs.util.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 过滤输入：例如emoji表情等的工具类
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project: ssxingshou-base-component
 * copyright: SSXINGSHOU TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2016/4/21 14:48
 * modifyTime:
 * modifyBy:
 */
public final class InputFilterUtil {

    static Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
            Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

    /**
     * @param source
     * @return
     */
    public static CharSequence filterEmoji(CharSequence source) {
        Matcher emojiMatcher = emoji.matcher(source);
        if (emojiMatcher.find()) {
            return "";
        }
        return null;
    }

}
