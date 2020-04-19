FROM openjdk:11
VOLUME /tmp
COPY ./hrm/hrm-web/target/hrm.jar hrm.jar
ENTRYPOINT ["java","-jar","/hrm.jar", "&"]