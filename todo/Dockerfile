FROM openjdk:8 AS BUILD_IMAGE
ENV APP_HOME=/todo_app/
WORKDIR $APP_HOME
COPY build.gradle gradlew $APP_HOME/
COPY gradle $APP_HOME/gradle
COPY . .
RUN ./gradlew build

FROM openjdk:8-jre
WORKDIR /todo_app/
COPY --from=BUILD_IMAGE /todo_app/build/libs/todo_app.jar .
COPY --from=BUILD_IMAGE /todo_app/src/main/resources/todos.json .

EXPOSE 8080
CMD ["java","-jar","todo_app.jar"]