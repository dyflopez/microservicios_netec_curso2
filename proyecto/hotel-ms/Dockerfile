#la imagen base
FROM openjdk:11-jdk-slim
#Carpeta de trabajo dentro de la imagen
#donde vamos a copiar nuestro JAR
WORKDIR /app
RUN mkdir ./logs
#Copiar desde nuestra carperta a el contenedor
#el punto hace referencia a la carpeta destino que es /app
COPY ./target/hotel-ms-0.0.1-SNAPSHOT.jar .
#se modifica para poder ser construido por el composer

#Variables de ambiente
ENV PORT 9090
#puerto donde se ejecutara la imagen
EXPOSE $PORT

#Puntos de entrada , para ejecutar comandos
#no se ejecuta cuando se crea la imagen
ENTRYPOINT ["java", "-jar", "hotel-ms-0.0.1-SNAPSHOT.jar"]