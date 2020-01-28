/*
 * @(#)com.cloud.food.controller 2020-01-04 11:41
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
import com.cloud.luck.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping(value = {"/v1/feign/api"}, method = {RequestMethod.GET, RequestMethod.POST}, consumes = {"*/*"}, produces = {"application/json"})
public class TestController {

    @Autowired
    TestService testService;

    /**
     * Description: [ FeignClient 入口调用 ]
     *
     * @param
     * @return java.lang.String
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020-01-04 14:39
     * <p>File:  </p>
     */
    @GetMapping("/test")
    public BaseResponse test() {
        String result = testService.hello("FeignClient调用实现");
        return BaseResponse.success(result);
    }

}
