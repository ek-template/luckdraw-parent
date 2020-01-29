FROM java:8-jre-alpine
MAINTAINER https://blog.csdn.net/qierkang
LABEL description="https://www.qekang.com/：luckdraw-service-在线抽奖服务提供"
ADD target/luckdraw-service-1.0-SNAPSHOT.jar /luckdraw-service.jar
ENV PORT 9002
CMD java -jar /luckdraw-service.jar -p $PORT