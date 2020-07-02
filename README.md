# spring-with-kafka
Simple Kafka Implementation using Spring Cloud Stream on Spring Boot Application

<h2>What's new</h2>
<ul>
  <li>Change of Message <b>Content-type</b> to <b>application/json</b> in application.yml</li>
  <li>New <b>User class</b> for message type</li>
  <li><b>Dockerfile</b> to build application into Docker Image</li>
  <li><b>docker-compose.yaml</b> file to create all services include Kafka and Zookeeper</li>
  <li><b>Spring-MongoDB</b> Application as New Consumer of Kafka Topics</li>
</ul>

<h2>How To Start This Project</h2>
<ol type="1">
  <li>Install Apache Kafka and Follow Instruction untill Zookeeper and Kafka Up and Running</li>
  <li>Install MongoDB</li>
  <li>Follow Instruction README.md from every service available in this project</li>
</ol>

<h2>Docker Build</h2>
<p>You can build this project as docker container by following this steps</p>
<p>
  cd spring-kafka<br>
  docker build --tag spring-kafka:latest .
</p><hr>
<p>
  cd ../spring-mongo<br>
  docker build --tag spring-mongo:latest .
</p><hr>
<p>
  cd ../<br>
  docker-compose up -d
</p>

<h2>Notes</h2>
<p>Feel free to fork or pull request this repo, if you have some improvement to this code
Thanks, GibsonAlfard</p>