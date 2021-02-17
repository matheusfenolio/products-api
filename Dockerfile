from openjdk

workdir /app

copy target/productManagement-0.0.1-SNAPSHOT.jar /app/productManagement.jar

entrypoint ["java", "-jar", "productManagement.jar"]
