# luckdraw-parent

[![coverage](https://img.shields.io/badge/项目创建&贡献者-尔康-blueviolet.svg)](https://www.qekang.com)[![coverage](https://img.shields.io/badge/blog-important.svg)](https://www.qekang.com)[![coverage](https://img.shields.io/badge/link-996.icu-red.svg)](https://996.icu)[![coverage](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE)


>如果你要问我为什么写这个项目，故事要从一只蝠蝠说起.....

<h3 style="color:red">不要再吃野味了！没有买卖就没有杀害</h3>
#项目背景 
<h4>后台：Spring Cloud +Nacos+Config 前端：Vue</h4>
- 本项目是随机抽奖系统，可在线实时修改中奖人员名单、内定人员，人数无限制，支持execl上传员工进行抽奖

##页面效果：

<center >
<a href="https://tva1.sinaimg.cn/large/006tNbRwgy1gbcqhk7ln6j31fv0u04qq.jpg" target="_blank">
<img src="https://tva1.sinaimg.cn/large/006tNbRwgy1gbcqhk7ln6j31fv0u04qq.jpg" width = "250" height = "200"/></a>
<a href="https://tva1.sinaimg.cn/large/006tNbRwgy1gbcqq8oeb4j317z0u0b29.jpg" target="_blank">
<img src="https://tva1.sinaimg.cn/large/006tNbRwgy1gbcqq8oeb4j317z0u0b29.jpg"  width = "250" height = "200" /></a>
<a href="https://tva1.sinaimg.cn/large/006tNbRwgy1gbcqqf9yj9j319y0u04qp.jpg" target="_blank">
<img src="https://tva1.sinaimg.cn/large/006tNbRwgy1gbcqqf9yj9j319y0u04qp.jpg"  width = "250" height = "200" /></a>
</center>

#### Nacos RPC框架：

Nacos 致力于帮助您发现、配置和管理微服务。Nacos 提供了一组简单易用的特性集，帮助您快速实现动态服务发现、服务配置、服务元数据及流量管理。

- 官网地址😀：https://nacos.io/zh-cn/index.html
- 我的博客😃：https://www.qekang.com
- 项目搭建者😄：qierkang
- **公益调试Nacos😁：https://nacos.qekang.com/nacos 账号/密码：nacos**
- **公益调试Sentinel😆：https://sentinel.qekang.com 账号/密码：sentinel**

## 模块说明

- luckdraw-gateway：Cloud网关服务消费者😅
- luckdraw-service：Cloud 服务提供者😂
- luckdraw-model：Cloud模型实体☺️
- luckdraw-utils：Cloud公共工具包😇
- 项目启动顺序：先启动服务提供者ServiceApplication 然后在启动网关GatewayApplication

## 已包含的组件

**Nacos**

阿里巴巴开源产品，一个更易于构建云原生应用的动态服务发现、配置管理和服务管理平台。

**Nacos-Config**

阿里巴巴开源产品，使用Nacos作为配置中心。

**[Hutool](https://www.hutool.cn/docs/) - JAVA工具类库**

Hutool是一个小而全的Java工具类库，通过静态方法封装，降低相关API的学习成本，提高工作效率，使Java拥有函数式语言般的优雅，让Java语言也可以“甜甜的”。



## Docker部署方式

- 制作服务镜像
```docker build -t luckdraw-service .```

- 制作网关镜像
```docker build -t luckdraw-geteway .```

- 启动服务
``` docker run -d --name luckdraw-service --restart always -e PORT=9001 -p 9001:9001 qierkang/luckdraw-service```

- 启动网关
``` docker run -d --name luckdraw-geteway --restart always -e PORT=8090 -p 8090:8090 qierkang/luckdraw-geteway```

## 一键部署方式

- 启动服务
``` docker run -d --name luckdraw-service --restart always -e PORT=9001 -p 9001:9001 qierkang/luckdraw-service```

- 启动网关
``` docker run -d --name luckdraw-geteway --restart always -e PORT=8090 -p 8090:8090 qierkang/luckdraw-geteway```

## Feedback

+ GitHub issue: https://github.com/ek-template/luckdraw-parent/issues
+ Gitee issue: https://gitee.com/ek-template/luckdraw-parent/issues
+ Builder:qierkang E-mail:xyqierkang@163.com Wechat:qekang