/*
 * @(#)com.cloud.food.controller 2020-01-04 11:27
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.cloud.luck.controller.defaults;

import com.cloud.luck.result.BaseResponse;
import com.cloud.luck.service.ITestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in $ $
 * @Title $.java
 * <p>Description: [ TODO ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:   </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */

@Slf4j
@RestController
@RequestMapping(value = {"/v1/service"}, method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"*/*"}, produces = {"application/json"})
public class TestController {

    @Autowired
    private ITestService testService;

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        log.info("invoked name = " + name);
        return "hello " + name;
    }

    @GetMapping("/list")
    public BaseResponse list() {
        try {
            log.info("#get list");
            return testService.getList();
        } catch (Exception e) {
            log.error("查询列表  异常:", e);
            return BaseResponse.error("查询列表 异常" + e.getMessage());
        }
    }

}
