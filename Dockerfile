FROM tomcat:7.0.108-jdk8-openjdk
LABEL maintainer="Flavien ANNAIX, Maxime DAZIN"
RUN apt update -y
RUN apt-get install maven -y
RUN apt-get install git -y
RUN apt-get install libmariadb-java -y
RUN mkdir /data
RUN git clone https://github.com/Flav1-ann/MyResto.git /data/springboot
WORKDIR /data/springboot
RUN mvn clean package install
WORKDIR /data/springboot/target
RUN java -jar demo-springboot-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["catalina.sh", "run"]