package com.zzn.mall.common.api;

/**
 * @ClassName IErrorCode
 * @Author zhangzhaonian
 * @Description 封装API的错误码
 * @CreateTime 2022/4/1-23:02
 **/


public interface IErrorCode {

    long getCode();

    String getMessage();
}
