package com.zzn.mall.controller;

import com.zzn.mall.common.api.CommonResult;
import com.zzn.mall.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UmsMemberController
 * @Author zhangzhaonian
 * @Description 会员注册管理controller
 * @CreateTime 2022/4/6-22:13
 **/

@Api(tags = "UmsMemberController", description = "会员注册管理")
@RestController
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("获取验证码")
    @GetMapping("/getAuthCode")
    public CommonResult getAuthCode(@RequestParam String telephone){
        CommonResult commonResult = umsMemberService.generateAuthCode(telephone);
        return commonResult;
    }

    @ApiOperation("判断验证码是否正确")
    @PostMapping("/verifyAuthCode")
    public CommonResult verifyAuthCode(@RequestParam String telephone,
                                       @RequestParam String authCode){
        CommonResult commonResult = umsMemberService.verifyAuthCode(telephone, authCode);
        return commonResult;
    }
}
