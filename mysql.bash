docker run -d \
  --name spring-mysql \
  -e MYSQL_USER=spring \
  -e MYSQL_PASSWORD=spring \
  -e MYSQL_ROOT_PASSWORD=spring \
  -e MYSQL_DATABASE=spring \
  -p 3306:3306 \
  -v mydb:/etc/mysql/conf.d \
  mysql
