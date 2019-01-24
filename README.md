# Metric Converter using gRPC

This project provides a service that converts quantities from one metric to another using [gRPC](https://grpc.io/docs/).
The various metrics supported currently are:

- cm_to_inches <br/>
- inches_to_cm <br/>
- km_to_miles <br/>
-  miles_to_km <br/>
- celcius_to_fah <br/>
- fah_to_celcius <br/>
- mt_to_ft <br/>
- ft_to_mt <br/>
- lbs_to_gms <br/>
- gms_to_lbs <br/>

<hr>

### Setup and Run
* Open Terminal and run the following commands <br/>
```
git https://github.com/krishnadwypayan/MetricConverter.git
cd Assignment2
./gradlew clean build
``` 

* Next, run the server program - src/main.java/com/example/grpc/GrpcServer.java <br/>
* Finally, run the client program - src/main.java/com/example/grpc/GrpcClient.java <br/>
* Input appropriate values for metric conversion.

<hr>

### Resources
 1. [gRPC](https://grpc.io/docs/)
 2. [gRPC-java](https://grpc.io/docs/tutorials/basic/java.html)
 3. Youtube video : [gRPC 101 for Java Developers](https://www.youtube.com/watch?v=DU-q5kOf2Rc)

