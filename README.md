# mybatiss


## mysql 5.7

```sh

docker run -di --name web1992_mysql -p 33306:3306 -e MYSQL_ROOT_PASSWORD=root mysql:5.7

docker exec -it web1992_mysql /bin/bash

mysql -u root -p
```