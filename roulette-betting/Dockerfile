# ------------------------------------------------------------------------
#
# Imagen de microservicio - Telefonica
# 
# Directorio de ubicacion de todos los microservicio /opt/ms/<NOMBRE>
#
# docker build -f Dockerfile -t ms-comp-redis-rest-QA:1.0.0 .
#
# ------------------------------------------------------------------------

FROM openjdk:8
MAINTAINER devops@telefonica.com.ec

RUN mkdir -p /opt/ms/ms-comp-redis-rest

WORKDIR /opt/ms/ms-comp-redis-rest

# --------------------------------
# Copy scripts, packages & plugins
# --------------------------------
COPY target/ms-comp-redis-rest.jar /opt/ms/ms-comp-redis-rest/
#COPY application.properties /opt/ms/ms-comp-redis-rest

#-----------------------
# Expose container ports
# ----------------------
EXPOSE 8080

ENTRYPOINT java -jar /opt/ms/ms-comp-redis-rest/ms-comp-redis-rest.jar
