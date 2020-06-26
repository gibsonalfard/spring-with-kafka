# spring-with-kafka
Simple Kafka Implementation using Spring Cloud Stream on Spring Boot Application

<p>Original Tutorial From https://dzone.com/articles/kafka-with-spring-cloud-stream</p>
<p>How to Install Apache Kafka, Follow Instruction on this link https://kafka.apache.org/quickstart</p>
<p>Kafka container in this project using this image https://hub.docker.com/r/bitnami/kafka</p>

<h2>What's new</h2>
<ul>
  <li>Change of Message <b>Content-type</b> to <b>application/json</b> in application.yml</li>
  <li>New <b>User class</b> for message type</li>
  <li><b>Dockerfile</b> to build application into Docker Image</li>
  <li><b>docker-compose.yaml</b> file to create all services include Kafka and Zookeeper</li>
</ul>

<h2>How To Start This Project</h2>
<ol type="1">
  <li>Install Apache Kafka and Follow Instruction untill Zookeeper and Kafka Up and Running</li>
  <li>Open this project using your favorite Text Editor or IDE, i prefer using IntelliJ IDEA, because i'm using it when writing this code.</li>
  <li>Open application.yml and edit some of this configuration to fit your need</li>
  <ol type="a">
    <li><b>spring.cloud.stream.kafka.binder.brokers</b>, this is location of your Kafka (Default is localhost:9092)</li>
    <li><b>spring.cloud.stream.bindings.input.destination</b>, this is name of topic</li>
    <li><b>spring.cloud.stream.bindings.input.group</b>, this is name of you input group</li>
    <li><b>spring.cloud.stream.bindings.input.content-type</b>, this is datatype you want to publish</li>
    <li><b>spring.cloud.stream.bindings.output.destination</b>, this is name of topic</li>
    <li><b>spring.cloud.stream.bindings.output.group</b>, this is name of you output group</li>
    <li><b>spring.cloud.stream.bindings.output.content-type</b>, this is datatype you want to subscribe</li>
  </ol>
  <li>Build application using <b>mvn clean install</b></li>
  <li>Run application using <b>mvn spring-boot:run</b></li>
</ol>

<h2>Docker Build</h2>
<p>You can build this project as docker container by following this steps</p>
<ol>
  <li>Run this command to create Docker Image, <b>docker build --tag spring-kafka:latest .</b></li>
  <li>Run this command to create container for all services, <b>docker-compose up -d</b></li>
</ol>

<h2>Post Action</h2>
<p>You can send Message to Kafka using HTTP Request via cURL or Postman.</p>
<ul>
  <li>(POST)<b>localhost:8080/sendMessage/string</b> to send Message type String, with Body (Message)</li>
  <li>(POST)<b>localhost:8080/sendMessage/complex</b> to send Message type Chat, with Body (Message)</li>
  <li>(GET)<b>localhost:8080/sendMessage/example</b> to send Message type User, without body</li>
</ul>

<h2>Notes</h2>
<p>Feel free to fork or pull request this repo, if you have some improvement to this code
Thanks, GibsonAlfard</p>