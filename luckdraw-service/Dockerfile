FROM java:8-jre-alpine
MAINTAINER https://blog.csdn.net/qierkang
LABEL description="https://www.qekang.com/：luckdraw-parent-在线抽奖Luck"
ADD luckdraw-service/target/luckdraw-service-1.0-SNAPSHOT.jar /luckdraw-service.jar
ENV PORT 9001
CMD java -jar /luckdraw-service.jar -p $PORT