package com.guat.myosotis.exceptions;

/**
 * 管理员账号错误异常
 * @author A.E.
 * @version 1.0
 * @since 1.0
 */
public class AccountErrException extends Exception{
    public AccountErrException() {
    }

    public AccountErrException(String message) {
        super(message);
    }
}
