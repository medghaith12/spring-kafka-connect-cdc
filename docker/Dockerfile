FROM confluentinc/cp-kafka-connect:7.4.0


USER root
RUN yum install unzip -y

COPY jar/*.jar /etc/kafka-connect/jars

# confluentinc-kafka-connect-elasticsearch
ADD mongodb-kafka-connect-mongodb-1.11.2.zip /tmp/mongodb-kafka-connect-mongodb.zip
RUN unzip /tmp/mongodb-kafka-connect-mongodb.zip -d /usr/share/java && rm /tmp/mongodb-kafka-connect-mongodb.zip

# confluentinc-kafka-connect-jdbc
ADD confluentinc-kafka-connect-jdbc-10.7.4.zip /tmp/confluentinc-kafka-connect-jdbc.zip
RUN unzip /tmp/confluentinc-kafka-connect-jdbc.zip -d /usr/share/java && rm /tmp/confluentinc-kafka-connect-jdbc.zip
