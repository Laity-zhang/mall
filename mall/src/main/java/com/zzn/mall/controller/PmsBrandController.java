package com.zzn.mall.controller;

import com.zzn.mall.common.api.CommonPage;
import com.zzn.mall.common.api.CommonResult;
import com.zzn.mall.mbg.model.PmsBrand;
import com.zzn.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @ClassName PmsBrandController
 * @Author zhangzhaonian
 * @Description 品牌管理
 * @CreateTime 2022/4/1-23:23
 **/


@Api(tags = "PmsBrandController",description = "商品品牌管理")
@RestController
@RequestMapping(value = "/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("获取所有的品牌列表")
    @GetMapping("/listAll")
    public CommonResult<List<PmsBrand>> getBrandList(){
        List<PmsBrand> listAllBrand = pmsBrandService.listAllBrand();
        return CommonResult.success(listAllBrand);
    }

    @ApiOperation("添加品牌")
    @PostMapping("/addBrand")
    public CommonResult addBrand(@Valid @RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int a = pmsBrandService.crateBrand(pmsBrand);
        if (a == 1){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("addBrand success:{}",pmsBrand);
        }else{
            commonResult = CommonResult.failed("添加品牌失败！");
            LOGGER.debug("addBrand failed:{}",pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("更新品牌信息")
    @PostMapping("/updateBrand/{id}")
    public CommonResult updateBrand(@PathVariable("id") Long id,@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int a = pmsBrandService.updateBrand(id, pmsBrand);
        if (a == 1){
            commonResult = CommonResult.success("更新品牌信息成功!");
            LOGGER.debug("updateBrand success==>id:{},pmsBran:{}",pmsBrand,pmsBrand);
        }else {
            commonResult = CommonResult.failed("更新品牌信息失败!");
            LOGGER.debug("updateBrand failed==>id:{},pmsBrand:{}",id,pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("删除品牌信息")
    @GetMapping("/deleteBrand/{id}")
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        CommonResult commonResult;
        int a = pmsBrandService.deleteBrand(id);
        if (a == 1){
            commonResult = CommonResult.success("删除商品信息成功!");
            LOGGER.debug("deleteBrand success==>id:{}",id);
        }else{
            commonResult = CommonResult.failed("删除商品信息失败！");
            LOGGER.debug("deleteBrand failed==>id:{}",id);
        }
        return commonResult;
    }

    @ApiOperation("分页查询品牌信息")
    @GetMapping("/listByPageHelper")
    public CommonResult<CommonPage<PmsBrand>> getBranListByPageHelper(@RequestParam(value = "pageNum",defaultValue = "1") @ApiParam("页码") Integer pageNum,
                                                            @RequestParam(value = "pageSize",defaultValue = "3") @ApiParam("每页数量") Integer pageSize){
        List<PmsBrand> brandList = pmsBrandService.listBrand(pageNum, pageSize);
        CommonResult<CommonPage<PmsBrand>> commonResult = CommonResult.success(CommonPage.restPage(brandList));
        return commonResult;
    }

    @ApiOperation("根据id获取品牌信息")
    @GetMapping("/getBrandById/{id}")
    public CommonResult<PmsBrand> getBrandById(@PathVariable(value = "id") Long id){
        PmsBrand pmsBrand = pmsBrandService.getBrand(id);
        CommonResult<PmsBrand> commonResult = CommonResult.success(pmsBrand);
        return commonResult;
    }

}
