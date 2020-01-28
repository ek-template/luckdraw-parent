/*
 * @(#)com.cloud.food.service 2020-01-05 00:26
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.cloud.luck.service;

import com.cloud.luck.result.BaseResponse;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional(rollbackFor = Exception.class)
public interface ITestService {

    /**
     * Description: [ 服务进行测试 ]
     *
     * @param
     * @return com.cloud.luck.result.BaseResponse
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 22:11
     * <p>File:  </p>
     */
    BaseResponse getList();
}
