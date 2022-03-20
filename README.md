前后端分离架构

前端文件夹keygen-frontend，开发期该文件夹放在哪里都可以。就算前端文件夹放在后端文件夹中，后端打包时也不会将前端打包进去。

## 前端部署步骤（非Docker方法） 

1、安装nginx 

2、将supplies-manage-frontend复制到/opt。实际上复制到哪里都可以，nginx.conf中配置该路径即可 

3、配置nginx.conf（将nginx.conf复制到nginx的conf目录中） 

4、启动nginx服务 

5、访问http://IP:PORT。因为nginx中端口设置为80，故可省略端口，访问http://IP即可 

## 后端部署（用Docker部署springboot项目） 

1、创建Dockerfile文件，内容如下 

FROM java:8 

ADD keygen-web.jar keygen-web.jar 

ENTRYPOINT ["java","-jar","keygen-web.jar"] 

2、构建镜像image 

#最后的点(.)表示基于当前目录的Dockerfile构建镜像

docker build -t keygen-web-image . 

3、查看镜像 

docker images 

4、运行镜像（获得容器） 

docker run -d -p 8085:8085 --restart=always --name keygen-web-container keygen-web-image 

5、查看运行中的container 

docker ps 

6、查看所有container 

docker ps -a

7、停止container 

docker stop 容器名 

8、运行container 

docker start 容器名 

9、删除container 

docker rm 容器名 

10、删除image 

docker rmi 镜像名 

11、在运行的容器中执行命令（进入运行中的容器） 

docker exec -it keygen-web-container /bin/bash

