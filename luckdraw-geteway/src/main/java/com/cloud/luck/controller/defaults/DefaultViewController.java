/*
 * @(#)com.cloud.food.controller 2020-01-06 16:13
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.cloud.luck.controller.defaults;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in $ $
 * @Title $.java
 * <p>Description: [ 默认欢迎页面！ ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Controller
public class DefaultViewController {

    /**
     * Description: [ 项目启动默认页面 ]
     *
     * @param
     * @return java.lang.String
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020-01-06 19:28
     * <p>File:  </p>
     */
    @RequestMapping("/default")
    public String index() {
        return "default";
    }

    /**
     * Description: [ 项目手动抛异常500 ]
     *
     * @param
     * @return java.lang.String
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020-01-06 19:28
     * <p>File:  </p>
     */
    @RequestMapping("/exception")
    public String exceptionTest() {
        int i = 1 / 0;
        return "default";
    }
}