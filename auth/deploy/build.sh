#!/usr/bin/env bash
#定义变量
API_NAME="pay"
API_VERSION="0.0.1-SNAPSHOT"
TAG=dev-$(date +%m%d%H%M)-${BUILD_NUMBER}

#如果下面需要将镜像推送到镜像仓库，那么此处的镜像名称需要带上镜像仓库地址
#IMAGE_NAME="192.168.1.114:9090/harry/$API_NAME:$TAG"
IMAGE_NAME="10.0.0.74/apm/$API_NAME:$TAG"

#进入target目录复制Dockerfile文件
#cd $WORKSPACE/$API_NAME/target/docker

#构建docker镜像
docker build -t $IMAGE_NAME .

#登录Harbor镜像仓库（此处的仓库地址需要与上面IMAGE_NAME的仓库地址保持一致否则推送denied）
docker login -u admin -p 12345  10.0.0.74


#推送docker镜像到Harbor镜像仓库
docker push $IMAGE_NAME

#将部署文件发送到k8s服务器
echo hello $API_NAME workspace $WORKSPACE
cd $WORKSPACE/deploy
scp template/k8s-demo.yaml ./$API_NAME.yaml
sed -i "s@latest@$TAG@g" $API_NAME.yaml
sed -i "s@dockertest@$API_NAME@g" $API_NAME.yaml

sed -i "s@latest@$TAG@g" deploy.sh
sed -i "s@dockertest@$API_NAME@g" deploy.sh
#sed -i "s@pinpoint-id@$API_NAME@g" ../Dockerfile
#sed -i "s@pinpoint-name@$API_NAME@g" ../Dockerfile

scp $API_NAME.yaml deploy.sh 10.0.0.148:/tmp