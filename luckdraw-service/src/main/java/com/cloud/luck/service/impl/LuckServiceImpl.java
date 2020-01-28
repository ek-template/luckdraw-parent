/*
 * @(#)com.cloud.luck.service.impl 2020/1/20 18:35
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Blog：https://www.qekang.com
 * Copyright (c) 2019-2020 Shanghai
 * All rights reserved.

 * This software is the confidential and proprietary information of
 * You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement
 */
package com.cloud.luck.service.impl;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.cloud.luck.model.Persons;
import com.cloud.luck.result.BaseResponse;
import com.cloud.luck.service.ILuckService;
import com.cloud.luck.service.IRedisService;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Service
public class LuckServiceImpl implements ILuckService {

    @Autowired
    private IRedisService redisService;

    @Override
    public BaseResponse addPerson(Persons persons) {
        // 查询手机号是否存在
        if (redisService.getMapExists(Persons.PERSON, persons.getPhone())) {
            return BaseResponse.error("手机号已存在，无需重复添加！");
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put(persons.getPhone(), persons);
            redisService.setMap(Persons.PERSON, map);
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse getAll() {
        return BaseResponse.success(redisService.getMap(Persons.PERSON).values());
    }

    @Override
    public BaseResponse upload(MultipartFile file) {
        try {
            redisService.delete(Persons.PERSON);
            ImportParams importParams = new ImportParams();
            List<Persons> objectList = ExcelImportUtil.importExcel(file.getInputStream(), Persons.class, importParams);
            Map<String, Object> map = Maps.newHashMap();
            objectList.stream().forEach(o -> {
                String phone = o.getPhone();
                if (StringUtils.isNotBlank(phone)) {
                    map.put(phone, o);
                }
            });
            redisService.setMap(Persons.PERSON, map);
        } catch (Exception e) {
            return BaseResponse.error();
        }
        return BaseResponse.success();
    }

    @Override
    public BaseResponse getWinning() {
        return BaseResponse.success(redisService.getMap(Persons.ND).values());
    }

    @Override
    public BaseResponse setWinning(String phone) {
        if (redisService.getMapExists(Persons.PERSON, phone)) {
            Map<String, Object> map = new HashMap<>();
            Persons persons = new Persons();
            persons.setPhone(phone);
            map.put(phone, persons);
            redisService.setMap(Persons.ND, map);
        }
        return getWinning();
    }

    @Override
    public BaseResponse delWinning(String phone) {
        redisService.deleteMap(Persons.ND, phone);
        return BaseResponse.success();
    }
}
