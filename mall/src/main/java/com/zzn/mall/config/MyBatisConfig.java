package com.zzn.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyBatisConfig
 * @Author zhangzhaonian
 * @Description TODO
 * @CreateTime 2022/4/1-22:45
 **/

@Configuration
@MapperScan("com.zzn.mall.mbg.mapper")
public class MyBatisConfig {

}
