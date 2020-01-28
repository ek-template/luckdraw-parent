FROM java:8-jre-alpine
MAINTAINER https://blog.csdn.net/qierkang
LABEL description="https://www.qekang.com/：luckdraw-geteway-在线抽奖网关服务"
ADD target/luckdraw-geteway-1.0-SNAPSHOT.jar /luckdraw-geteway.jar
ENV PORT 8090
CMD java -jar /luckdraw-geteway.jar -p $PORT