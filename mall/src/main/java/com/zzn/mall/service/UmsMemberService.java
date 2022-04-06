package com.zzn.mall.service;

import com.zzn.mall.common.api.CommonResult;

/**
 * @ClassName umsMemberService
 * @Author zhangzhaonian
 * @Description 会员管理Service
 * @CreateTime 2022/4/6-21:54
 **/

public interface UmsMemberService {

    /**
     * 生成验证码
     * @param telephone
     * @return
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号是否匹配
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone,String authCode);
}
