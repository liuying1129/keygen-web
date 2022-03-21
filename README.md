前后端分离架构

前端文件夹keygen-frontend，开发期该文件夹放在哪里都可以。就算前端文件夹放在后端文件夹中，后端打包时也不会将前端打包进去。

## 前端部署步骤（非Docker方法） 

1、安装nginx 

2、将keygen-frontend复制到/opt。实际上复制到哪里都可以，nginx.conf中配置该路径即可 

3、配置nginx.conf（将nginx.conf复制到nginx的conf目录中） 

4、启动nginx服务 

5、访问http://IP:PORT。因为nginx中端口设置为80，故可省略端口，访问http://IP即可 

## 前端部署步骤（Docker方法） 

1、创建Dockerfile文件，内容如下 

FROM nginx 

#COPY目的地是基础镜像nginx内文件系统的目录

COPY keygen-frontend /opt/keygen-frontend 

COPY default-nginx-docker.conf /etc/nginx/conf.d/default.conf 

2、构建镜像image 

#最后的点(.)表示基于当前目录的Dockerfile构建镜像

docker build --tag liuying1129/keygen-frontend-image . 

3、运行镜像（获得容器） 

docker run -d -p 80:80 --restart=always --name keygen-frontend-container liuying1129/keygen-frontend-image 

## 后端部署（用Docker部署springboot项目） 

1、创建Dockerfile文件，内容如下 

FROM java:8 

ADD keygen-web.jar keygen-web.jar 

ENTRYPOINT ["java","-jar","keygen-web.jar"] 

2、构建镜像image 

docker build --tag liuying1129/keygen-web-image . 

3、运行镜像（获得容器） 

docker run -d -p 8085:8085 --restart=always --name keygen-web-container liuying1129/keygen-web-image 

