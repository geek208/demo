# ......
FROM java:8

# .............
VOLUME /tmp

#ADD microservice-discovery-eureka-0.0.1-SNAPSHOT.jar /app.jar
#ADD target/xmall-order-1.0-SNAPSHOT app.jar
ADD target/pay-1.0.jar app.jar

#ADD ./thirdPartyComponent/pinpoint-agent.zip pinpoint-agent.zip
COPY pinpoint-agent /pinpoint-agent

# 运行命令  解压pinpoint以来的agent包
#RUN cd /  && unzip pinpoint-agent.zip
RUN bash -c 'touch /app.jar'

# ..8761..
EXPOSE 9093

# ............
#ENTRYPOINT ["java","-Dserver.port=9091","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-javaagent:/pinpoint-agent/pinpoint-bootstrap-1.8.4.jar","-Dpinpoint.agentId=comsumer-pinpoint-id","-Dpinpoint.applicationName=comsumer-pinpoint-name","-jar","/consumer.jar"]

ENTRYPOINT ["java","-Dserver.port=9093","-Djava.security.egd=file:/dev/./urandom","-javaagent:/pinpoint-agent/pinpoint-bootstrap-1.8.4.jar","-Dpinpoint.agentId=pay","-Dpinpoint.applicationName=pay","-jar","/app.jar"]


