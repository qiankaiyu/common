FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=${JAVA_OPTS}
COPY build/libs/demo-0.0.1.jar demo.jar
EXPOSE 3000
# ENTRYPOINT exec java $JAVA_OPTS -jar configserver.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar demo.jar
# 然后build镜像
# docker build -t demo/test .
# 最后运行镜像
# docker run -p 8080:8080 demo/test
