mvn clean
mvn package
mvn package -DskipTests

docker build -t img_ms_email:V1 .
#docker run -d -p 8080:8080 --name ms-bank-v1 -e DB_HOST=host.docker.internal:3306 img_ms_bank:V1
#para crear la imagenes con el archivo de configuraciones
docker run -d -p 8081:8081  --env-file .env --name ms-email-v1  img_ms_email:V1
docker logs -f #idContenedor o nombre del contenedor  (ms-bank-v1)
docker logs -f ms-bank-v1
#Ejecutar Docker-compouse
docker compose up -d
#eliminar
docker compose down
docker compose down  -v
#DockerHUB

https://hub.docker.com/repositories/daniel0223

