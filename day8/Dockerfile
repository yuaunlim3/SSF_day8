FROM openjdk:23-jdk-oracle AS builder

ARG COMPILE_DIR=/compiledir 

WORKDIR ${COMPILE_DIR}

# Copy Maven wrapper and pom.xml
COPY ./mvnw . 
COPY .mvn .mvn
COPY pom.xml .

# Copy the source code into the container
COPY src src

RUN chmod a+x ./mvnw && ./mvnw package -Dmaven.test.skip=true 

ENV SERVER_PORT=4000


# Expose the port your application will run on
EXPOSE ${SERVER_PORT}


FROM openjdk:23-jdk-oracle

ARG WORK_DIR=/app

WORKDIR  ${WORK_DIR}

COPY --from=builder /compiledir/target/day8-0.0.1-SNAPSHOT.jar day8.jar

ENV SERVER_PORT=4000

# Expose the port your application will run on
EXPOSE ${SERVER_PORT}


ENTRYPOINT ["java", "-jar", "day8.jar"]