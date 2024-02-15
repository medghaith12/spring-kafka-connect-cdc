docker exec -t kafka-cdc-zookeeper-1 kafka-topics --create --bootstrap-server kafka:9092 --replication-factor 1 --partitions 5 --topic postgres-cdc-products-productsproduct
