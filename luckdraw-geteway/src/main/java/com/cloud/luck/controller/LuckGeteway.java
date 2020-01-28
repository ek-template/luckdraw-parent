/*
 * @(#)com.cloud.luck.controller 2020/1/21 21:43
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.cloud.luck.controller;

import com.cloud.luck.service.LuckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in $ $
 * @Title $.java
 * <p>Description: [ 抽奖网关服务Api接口 ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */

@RestController
@RequestMapping(value = {"/v1/luck/api"}, method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"*/*"}, produces = {"application/json"})
public class LuckGeteway {

    @Autowired
    private LuckService luckService;

    @RequestMapping(value = "/addPerson")
    public String addPerson(String no, String name, String phone) {
        return luckService.addPerson(no, name, phone);
    }

    @RequestMapping("/getAll")
    public String getAll() {
        return luckService.getAll();
    }

    @RequestMapping("/getWinning")
    public String getWinning() {
        return luckService.getWinning();
    }

    @RequestMapping("/setWinning")
    public String setWinning(String phone) {
        return luckService.setWinning(phone);
    }

    @RequestMapping("/delWinning")
    public String delWinning(String phone) {
        return luckService.delWinning(phone);
    }

    @RequestMapping(value = "/upload")
    public String upload(@RequestPart(value = "file") MultipartFile file) {
        return luckService.upload(file);
    }
}
