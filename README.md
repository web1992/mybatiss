# mybatiss

> demo for [mybstis](http://www.mybatis.org/mybatis-3/)

- [https://github.com/mybatis/spring](https://github.com/mybatis/spring)

## mysql 5.7

> Use docker run mysql
> 最好使用 5.7 的版本的，8.0 版本问题很多

```sh

docker run -di --name web1992_mysql -p 3306:3306 -v /Users/zl/Documents/dev/dockers/mysql/conf:/etc/mysql/conf.d -v /Users/zl/Documents/dev/dockers/mysql/data:/var/lib/mysql  -e MYSQL_ROOT_PASSWORD=root mysql:5.7

docker exec -it web1992_mysql /bin/bash

mysql -u root -p
```

## docker 

```sh

# 运行中的 docker
docker images ls

# 所有的 docker
docker container ls --all

docker stop 0039c4b71df5

docker start 0039c4b71df5

```