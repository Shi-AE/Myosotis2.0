package com.guat.myosotis.exceptions;

/**
 * 手机号错误异常
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public class NumberErrException extends Exception{
    public NumberErrException() {
    }

    public NumberErrException(String message) {
        super(message);
    }
}
