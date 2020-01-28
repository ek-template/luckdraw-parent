/*
 * @(#)com.cloud.luck.service 2020/1/21 21:45
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.cloud.luck.service;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in $ $
 * @Title $.java
 * <p>Description: [ 网关 Feign] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@FeignClient(value = "luckdraw-service/v1/service/", url = "http://192.168.8.100:9001/v1/service/", configuration = LuckService.MultipartSupportConfig.class)
public interface LuckService {

    /**
     * Description: [ 内定人员新增 ]
     *
     * @param
     * @param no
     * @param name
     * @param phone
     * @return java.lang.String
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 22:11
     * <p>File:  </p>
     */
    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    String addPerson(@RequestParam(value = "no") String no, @RequestParam(value = "name") String name, @RequestParam(value = "phone") String phone);

    /**
     * Description: [ 查询所有已存在人员 ]
     *
     * @param
     * @return java.lang.String
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 22:11
     * <p>File:  </p>
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    String getAll();

    /**
     * Description: [ 获取内定人员 ]
     *
     * @param
     * @return java.lang.String
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 22:11
     * <p>File:  </p>
     */
    @RequestMapping(value = "/getWinning", method = RequestMethod.GET)
    String getWinning();

    /**
     * Description: [ 新增内定人员 ]
     *
     * @param
     * @param phone
     * @return java.lang.String
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 22:11
     * <p>File:  </p>
     */
    @RequestMapping(value = "/setWinning", method = RequestMethod.POST)
    String setWinning(@RequestParam(value = "phone") String phone);

    /**
     * Description: [ 删除内定人员 ]
     *
     * @param
     * @param phone
     * @return java.lang.String
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 22:11
     * <p>File:  </p>
     */
    @RequestMapping(value = "/delWinning", method = RequestMethod.POST)
    String delWinning(@RequestParam(value = "phone") String phone);

    /**
     * Description: [ TODO ]
     *
     * @param
     * @param file
     * @return java.lang.String
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 22:11
     * <p>File:  </p>
     */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String upload(@RequestPart(value = "file", required = false) MultipartFile file);

    @Configuration
    class MultipartSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}
