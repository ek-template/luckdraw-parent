package com.cloud.luck;

import cn.hutool.core.date.DateUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.cloud.luck.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * *********************************************************
 *
 * @Author <a href="mailto:xyqierkang@163.com">qierkang</a>
 * Blog: https://www.qekang.com
 * @Title GatewayApplication.java
 * @Date Created in 2019-11-25 19:10
 * <p>Description: [ TODO ] </p>
 * <p>Copyright:    </p>
 * <p>Company:      </p>
 * <p>Department:   </p>
 * *********************************************************
 */
@EnableDiscoveryClient
// 网关项目不需要数据源，有些依赖 声明一下
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
public class GatewayApplication {

    private static final Log log = LogFactory.get();

    /**
     * null ：作用为在取不到对应配置值时，采用默认值null赋值
     */
    @Value("${luck.mes.name:#{null}}")
    private String title;

    @Autowired
    private TestConfig testConfig;

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

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