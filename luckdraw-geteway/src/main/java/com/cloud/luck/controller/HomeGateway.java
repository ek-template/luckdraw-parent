package com.cloud.luck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in 2020/1/28 20:34
 * @Title HomeGateway.java
 * <p>Description: [ TODO ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Controller
public class HomeGateway {

    @RequestMapping({"/", "index.html", "index"})
    public String toIndex() {
        return "index";
    }

    @RequestMapping({"/manage.html", "manage"})
    public String toManage() {
        return "manage";
    }

    @RequestMapping({"/result.html", "result"})
    public String toResult() {
        return "result";
    }
}
