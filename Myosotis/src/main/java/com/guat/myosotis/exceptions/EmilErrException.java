package com.guat.myosotis.exceptions;

/**
 * 邮箱地址错误异常
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public class EmilErrException extends Exception{
    public EmilErrException() {
    }

    public EmilErrException(String message) {
        super(message);
    }
}
