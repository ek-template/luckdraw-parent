/*
 * @(#)con.cloud.food 2020-01-04 14:48
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.cloud.food;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

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
public class TestController extends BaseJunitTest {

    @Test
    public void test() {
        String result = restTemplate.getForObject("http://luckdraw-service/v1/service/hello?name=RestTemplate调用实现", String.class);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void list() {
        String result = restTemplate.getForObject("http://luckdraw-service/v1/service/list", String.class);
        System.out.println(result);
    }
}
