### docker commands<br>

1. docker --version<br>
2. docker image ls <br>
3. docker container ls <br>
4. docker ps <br>
5. docker ps -a <br>
6. docker build -t yuaunlim3/appname:v1.0.0 . <br>
7. docker run -d -p 8080:4000 yuaunlim3/appname:v1.0.0 <br>
8. docker stop <first 4 characters of container id> <br>
9. docker rm <first 4 characters of container id> <br>
10. docker rmi <image id> <br>
11. docker system prune <br>


### railway
1. railway login --browserless (in project root , login to railway)
2. railway link(in project root , link to railway environment to deploy)
3. railway up(deploying app)
