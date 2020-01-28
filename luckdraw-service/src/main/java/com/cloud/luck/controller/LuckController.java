/*
 * @(#)com.cloud.luck.controller.defaults 2020/1/20 18:31
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.cloud.luck.controller;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.cloud.luck.model.Persons;
import com.cloud.luck.result.BaseResponse;
import com.cloud.luck.service.ILuckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in $ $
 * @Title $.java
 * <p>Description: [ 服务提供者入口 ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@RestController
@RequestMapping(value = {"/v1/service"}, method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"*/*"}, produces = {"application/json"})
public class LuckController {

    private static final Log log = LogFactory.get();

    @Autowired
    private ILuckService luckService;

    @RequestMapping("/addPerson")
    public BaseResponse addPerson(Persons persons) {
        try {
            log.info("#内定人员新增 > {}", persons);
            return luckService.addPerson(persons);
        } catch (Exception e) {
            log.info("#内定人员新增 异常 > {}", persons, e.getMessage());
            return BaseResponse.error(e.getMessage());
        }
    }

    @PostMapping("/getAll")
    public BaseResponse getAll() {
        try {
            log.info("#查询所有已存在人员");
            return luckService.getAll();
        } catch (Exception e) {
            log.info("#查询所有已存在人员 异常 > {}", e.getMessage());
            return BaseResponse.error(e.getMessage());
        }
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BaseResponse upload(@RequestPart(value = "file") MultipartFile file) {
        try {
            log.info("#初始化上传人员名单 > {}", file);
            return luckService.upload(file);
        } catch (Exception e) {
            log.info("#初始化上传人员名单 异常 > {}", file);
            return BaseResponse.error(e.getMessage());
        }
    }

    @PostMapping("/getWinning")
    public BaseResponse getWinning() {
        try {
            log.info("#获取内定人员");
            return luckService.getWinning();
        } catch (Exception e) {
            log.info("#获取内定人员 异常 > {}", e.getMessage());
            return BaseResponse.error(e.getMessage());
        }
    }

    @PostMapping("/setWinning")
    public BaseResponse setWinning(String phone) {
        try {
            log.info("#新增内定人员 > {}", phone);
            return luckService.setWinning(phone);
        } catch (Exception e) {
            log.info("#新增内定人员 异常 > {}", phone);
            return BaseResponse.error(e.getMessage());
        }
    }

    @PostMapping("/delWinning")
    public BaseResponse delWinning(String phone) {
        try {
            log.info("#删除内定人员 > {}", phone);
            return luckService.delWinning(phone);
        } catch (Exception e) {
            log.info("#删除内定人员 异常 > {}", phone);
            return BaseResponse.error(e.getMessage());
        }
    }

}
