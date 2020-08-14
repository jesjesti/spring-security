FROM openjdk:8-jre-alpine

COPY ./app/start_cloud_app.sh /start_cloud_app.sh

COPY ./app/comment_app.jar /comment_app.jar

RUN chmod -R 755  /start_cloud_app.sh

ENTRYPOINT /start_cloud_app.sh


