/*
 * @(#)com.cloud.food.service.impl 2020-01-05 00:27
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.cloud.luck.service.impl;

import com.cloud.luck.result.BaseResponse;
import com.cloud.luck.service.ITestService;
import org.springframework.stereotype.Service;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in $ $
 * @Title $.java
 * <p>Description: [ 测试服务类 ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:   </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Service
public class TestServiceImpl implements ITestService {

    @Override
    public BaseResponse getList() {
        return BaseResponse.success();
    }


}
