FROM openjdk:8-jdk-alpine
LABEL maintainer="Flavien ANNAIX, Maxime DAZIN"
RUN apt update -y
RUN apt-get install maven -y
RUN apt-get install git -y
RUN apt-get install libmariadb-java -y
RUN mkdir /data
RUN git clone https://github.com/Flav1-ann/springboot /data/springboot
WORKDIR /data/springboot
RUN mvn clean package install
WORKDIR /data/springboot/target
EXPOSE 8080
CMD ["catalina.sh", "run"]