package com.zzn.mall.service;

import com.zzn.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @ClassName PmsBrandService
 * @Author zhangzhaonian
 * @Description TODO
 * @CreateTime 2022/4/1-23:24
 **/

public interface PmsBrandService {

    /**
     * 查询全部的品牌
     * @return
     */
    List<PmsBrand> listAllBrand();

    /**
     * 创建品牌
     * @param pmsBrand
     * @return
     */
    int crateBrand(PmsBrand pmsBrand);

    /**
     * 更新品牌信息
     * @param id
     * @param pmsBrand
     * @return
     */
    int updateBrand(Long id,PmsBrand pmsBrand);

    /**
     * 删除品牌
     * @param id
     * @return
     */
    int deleteBrand(Long id);

    /**
     * 分页查询品牌
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<PmsBrand> listBrand(int pageNum,int pageSize);

    /**
     * 根据id获取品牌信息
     * @param id
     * @return
     */
    PmsBrand getBrand(Long id);
}
