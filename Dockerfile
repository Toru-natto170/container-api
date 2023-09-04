FROM gradle:8.3.0-jdk-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM adoptopenjdk/openjdk11:ubi

EXPOSE 9000

RUN mkdir /opt/app
ENV TZ Asia/Tokyo

COPY --from=build /home/gradle/src/build/libs/*.jar /opt/app/container-api.jar

ENTRYPOINT ["java", "-jar","/opt/app/container-api.jar"]