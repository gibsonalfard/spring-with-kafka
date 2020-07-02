# spring-with-kafka
Simple Kafka Implementation using Spring Cloud Stream on Spring Boot Application

<p>Original Tutorial From https://spring.io/guides/gs/accessing-data-mongodb/</p>
<p>How to Install Apache MongoDB, Follow Instruction on this link https://docs.mongodb.com/manual/installation/</p>

<h2>How To Start This Project</h2>
<ol type="1">
  <li>Open this project using your favorite Text Editor or IDE, i prefer using IntelliJ IDEA, because i'm using it when writing this code.</li>
  <li>Open application.yml and edit some of this configuration to fit your need</li>
  <ol type="a">
    <li><b>spring.data.mongodb.host</b>, is location of your MongoDB Server</li>
    <li><b>spring.data.mongodb.port</b>, is location of your MongoDB Port Access</li>
    <li><b>spring.data.mongodb.authentication-database</b>, is your MongoDB Authentication Database Name</li>
    <li><b>spring.data.mongodb.database</b>, is your MongoDB Database Name</li>
    <li><b>spring.data.mongodb.username</b>, is your MongoDB Username</li>
    <li><b>spring.data.mongodb.password</b>, is your MongoDB Password</li>

    <li><b>spring.cloud.stream.kafka.binder.brokers</b>, this is location of your Kafka (Default is localhost:9092)</li>
    <li><b>spring.cloud.stream.bindings.input.destination</b>, this is name of topic</li>
    <li><b>spring.cloud.stream.bindings.input.group</b>, this is name of you input group</li>
    <li><b>spring.cloud.stream.bindings.input.content-type</b>, this is datatype you want to subscribe</li>
  </ol>
  <li>Build application using <b>mvn clean install</b></li>
  <li>Run application using <b>mvn spring-boot:run</b></li>
</ol>

<h2>Notes</h2>
<p>Feel free to fork or pull request this repo, if you have some improvement to this code
Thanks, GibsonAlfard</p>