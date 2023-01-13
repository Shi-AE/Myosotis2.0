package com.guat.myosotis.util;

import java.sql.Time;
import java.sql.Timestamp;

/**
 * 字符串和时间转换工具类(针对基础前端控件)
 *
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public class StringDataUtil {
    private StringDataUtil() {
    }

    /**
     * 字符串转时间戳（YY-MM-DD HH:MM:SS）
     *
     * @param time 时间戳字符串
     * @return 时间戳
     */
    public static Timestamp stringToTimestamp(String time) {
        StringBuilder stringBuilder = new StringBuilder(time);
        stringBuilder
                .delete(10, 11)
                .insert(10, " ")
                .append(":00");
        return Timestamp.valueOf(stringBuilder.toString());
    }

    /**
     * 字符串转时间（HH:MM:SS）
     *
     * @param time 时间字符串
     * @return 时间
     */
    public static Time stringToTime(String time) {
        StringBuilder stringBuilder = new StringBuilder(time);
        stringBuilder.append(":00");
        return Time.valueOf(stringBuilder.toString());
    }
}
