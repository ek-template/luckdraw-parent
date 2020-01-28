package com.cloud.luck.model;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in 2020/1/28 18:33
 * @Title Persons.java
 * <p>Description: [ TODO ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Data
@ExcelTarget("Entity")
public class Persons implements Serializable {

    public static final String PERSON = "PERSON:ALL";     // 人员缓存key

    public static final String ND = "PERSON:ND";     // 内定

    @Excel(name = "工号")
    private String no;

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "手机号")
    private String phone;

}
