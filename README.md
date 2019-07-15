# mybatiss

> demo for [mybstis](http://www.mybatis.org/mybatis-3/)

## mysql 5.7

> Use docker run mysql
> 最好使用 5.7 的版本的，8.0 版本问题很多

```sh

docker run -di --name web1992_mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql:5.7

docker exec -it web1992_mysql /bin/bash

mysql -u root -p
```