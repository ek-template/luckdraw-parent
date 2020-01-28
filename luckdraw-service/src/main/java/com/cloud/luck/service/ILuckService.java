/*
 * @(#)com.cloud.luck.service 2020/1/20 18:34
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.cloud.luck.service;

import com.cloud.luck.model.Persons;
import com.cloud.luck.result.BaseResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in $ $
 * @Title $.java
 * <p>Description: [ 抽奖系统核心服务 ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Transactional(rollbackFor = Exception.class)
public interface ILuckService {

    /**
     * Description: [ 内定人员新增 ]
     *
     * @param
     * @param persons
     * @return com.cloud.luck.result.BaseResponse
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 17:54
     * <p>File:  </p>
     */
    BaseResponse addPerson(Persons persons);

    /**
     * Description: [ 查询所有已存在人员 ]
     *
     * @param
     * @return com.cloud.luck.result.BaseResponse
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 17:54
     * <p>File:  </p>
     */
    BaseResponse getAll();

    /**
     * Description: [ 初始化上传人员名单 ]
     *
     * @param
     * @param file
     * @return com.cloud.luck.result.BaseResponse
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 17:54
     * <p>File:  </p>
     */
    BaseResponse upload(MultipartFile file);

    /**
     * Description: [ 获取内定人员 ]
     *
     * @param
     * @return com.cloud.luck.result.BaseResponse
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 17:54
     * <p>File:  </p>
     */
    BaseResponse getWinning();

    /**
     * Description: [ 新增内定人员 ]
     *
     * @param
     * @param phone
     * @return com.cloud.luck.result.BaseResponse
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 17:55
     * <p>File:  </p>
     */
    BaseResponse setWinning(String phone);

    /**
     * Description: [ 删除内定人员 ]
     *
     * @param
     * @param phone
     * @return com.cloud.luck.result.BaseResponse
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020/1/28 17:55
     * <p>File:  </p>
     */
    BaseResponse delWinning(String phone);
}
