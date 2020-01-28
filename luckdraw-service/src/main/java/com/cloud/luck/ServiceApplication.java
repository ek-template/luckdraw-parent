package com.cloud.luck;

import cn.hutool.core.date.DateUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.cloud.luck.config.TestConfig;
import com.cloud.luck.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
 * @Date Created in 2020-01-05 03:09
 * @Title ServiceApplication.java
 * <p>Description: [ 服务提供者启动类 ] </p>
 * <p>Blog: https://www.qekang.com</p>
 * <p>Inc:  </p>
 * <p>Copyright:    </p>
 * <p>Department: Product development </p>
 * *********************************************************
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceApplication {

    private static final Log log = LogFactory.get();

    @Value("${qierkang.title:}")
    private String title;

    @Autowired
    private TestConfig testConfig;

    @Autowired
    private IRedisService redisService;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ServiceApplication.class, args);
        WebServer webServer = ((AnnotationConfigServletWebServerApplicationContext) run).getWebServer();
        log.info("Startup success：http://127.0.0.1:{}", webServer.getPort());
    }

    /**
     * Description: [ restTemplate 调用方式 方便Junit测试 ]
     *
     * @param
     * @return org.springframework.web.client.RestTemplate
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020-01-05 03:12
     * <p>File:  </p>
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * Description: [ spring boot 启动初始化 ]
     *
     * @param
     * @return void
     * @Author <a href="mailto:xyqierkang@gmail.com">ErKang Qi</a>
     * @Date Created in 2020-01-05 03:13
     * <p>File:  </p>
     */
    @PostConstruct
    private void init() {
        try {
            log.info("#初始化配置中心 [{}]操作时间[{}]", title, DateUtil.now());
            log.info("#初始化YML [{}]操作时间[{}]", testConfig.getName(), DateUtil.now());
        } catch (Exception e) {
            log.error("#初始化配置错误！");
        }
    }

}