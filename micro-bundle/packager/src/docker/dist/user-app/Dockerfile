FROM openjdk:8-jre-alpine

COPY ./app/start_cloud_app.sh /start_cloud_app.sh

COPY ./app/user_app.jar /user_app.jar

RUN chmod -R 755  /start_cloud_app.sh

ENTRYPOINT /start_cloud_app.sh


