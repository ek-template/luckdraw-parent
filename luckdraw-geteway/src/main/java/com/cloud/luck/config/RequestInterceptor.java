package com.cloud.luck.config;

import cn.hutool.json.JSONUtil;
import com.cloud.luck.result.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in 2020/1/28 18:03
 * @Title RequestInterceptor.java
 * <p>Description: [ 验证所有请求权限 ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@Slf4j
@Component
public class RequestInterceptor extends HandlerInterceptorAdapter {

    private static final int PERMOPEN = 1;
    /**
     * @Fields urls : TODO[ 设置白名单用户 ]
     */
    private static String[] url = {""};
    public List<String> urlList = Arrays.asList(url);

    public static void main(String[] args) {
        List<String> urlList = Arrays.asList(url);
        System.out.println(urlList.contains("html"));
    }

    @PostConstruct
    private void init() {
        try {
            log.info("武汉加油：🤙拦截器启动🤙 状态：【{}】", PERMOPEN == 1 ? "关闭" : "开启");
        } catch (Exception e) {
            log.info("#拦截器启动异常 > {}", e.getMessage());
        }
    }

    private void responseNoPerm(HttpServletRequest request, HttpServletResponse response) {
        try {
            PrintWriter out = null;
            response.setContentType("application/json;charset=UTF-8");
            out = response.getWriter();
            out.print(JSONUtil.parseObj(BaseResponse.errorNoPerm()));
            out.flush();
        } catch (IOException e) {
            log.error("#系统异常 - {}", e.getMessage());
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            //拦截器 开关
            if (PERMOPEN == 0) {
                return true;
            }
            String requestUri = request.getRequestURI();
            if (urlList.contains(requestUri)) {
                //判断白名单是否存在合法url
                return true;
            }
            String token = request.getHeader("token");
            // 由于前端在addToken时候没用存到后端缓存 这里就不做判断
            if (StringUtils.isBlank(token)) {
                this.responseNoPerm(request, response);
                return false;
            }
        } catch (Exception e) {
            log.error("#系统异常 - {}", e.getMessage());
        }
        return true;
    }

}
