## 181 - Step 00 - Match made in Heaven - Docker and Microservies

***

## 182. Step 01 - Installing Docker - Docker - V2

```
$ docker --version

Docker version 20.10.22, build 3a2c30b
```

```
$ docker run in28min/todo-rest-api-h2:1.0.0.RELEASE
```

***

## 183. Recommendation

***

## 184. Step 02 - Your First Docker Usecase - Deploy Spring Boot

***

## 185. Step 03 - Docker Concepts - Registry, Repository, Tag, Image

* Default Registry (`https://hub.docker.com/`)
    * Repository (`https://hub.docker.com/r/in28min/todo-rest-api-h2`)
        * Tag (`1.0.0.RELEASE`)

* `-p 5000:5000 => -p {HostPort}:{ContainerPort}`
```
$ docker run -p 5000:5000 in28min/todo-rest-api-h2:1.0.0.RELEASE
```
* http://localhost:5000/hello-world
* http://localhost:5000/hello-world-bean

* A Container is a running version of an image.

***

## 186. Step 04 - Playing with Docker Images and Containers

```
$ docker container ls -a

$ docker run -p 5000:5000 -d in28min/todo-rest-api-h2:1.0.0.RELEASE
$ docker logs -f <container ID>

$ docker run -p 5001:5000 -d in28min/todo-rest-api-h2:1.0.0.RELEASE
$ docker logs -f <container ID>

$ docker images
$ docker container stop <container ID>
$ docker run -p 5000:5000 -d in28min/todo-rest-api-h2:0.0.1-SNAPSHOT
```
***

## 187. Step 05 - Understanding Docker Architecture - Docker Client, Docker Engine

* Docker Client
    * Docker Daemon
        * Image Registry
        * Local Images
        * Containers

***

## 188. Step 06 - Why is Docker Popular

```
$ docker images
```

* You can give single image multiple Tags also

```
$ docker tag in28min/todo-rest-api-h2:1.0.0.RELEASE in28min/todo-rest-api-h2:latest
```

```
$ docker search mysql

$ docker pull mysql
```

```
$ docker image history <image ID>
$ docker image inspect <image ID>
```

```
$ docker image remove <image ID>
```
***

## 189. Step 07 - Playing with Docker Images

***

## 190. Step 08 - Playing with Docker Containers

```
$ docker container run -9 5000:5000                   in28min/todo-rest-api-h2:1.0.0.RELEASE
$ docker           run -9 5000:5000                   in28min/todo-rest-api-h2:1.0.0.RELEASE
$ docker           run -9 5000:5000 -d                in28min/todo-rest-api-h2:1.0.0.RELEASE
$ docker           run -9 5000:5000 -d restart=always in28min/todo-rest-api-h2:1.0.0.RELEASE
$ docker           run -9 5000:5000 -m 512m --cpu-quota 5000 -d restart=always in28min/todo-rest-api-h2:1.0.0.RELEASE
```
* `cpu-quota` is 100,000 so 5,000 (5%)

### Pause & Unpause
```
$ docker container   pause <container ID>
$ docker container unpause <container ID>

$ docker logs -f <container ID>

$ docker container inspect <container ID>
$ docker container ls -a
$ docker container prune

$ docker container stop <container ID>
$ docker container kill <container ID>


```
***

## 191. Step 09 - Playing with Docker Commands - stats, system

```
$ docker events
$ docker top        # Top processing running in a specific container
$ docker stats
$ docker run -p 5000:5000 -m 512m --cpu-quota 5000 -d restart=always in28min/todo-rest-api-h2:1.0.0.RELEASE
$ docker system df      # What resources are being managed by docker deamon
```

***

## 192. Why you should teach others

***

## 193. Step 10 - Introduction to Distributed Tracing

***

## 194. Step 11 - Launching `Zipkin` Container using Docker

***

## 195. Step 12 - Getting Started with Observability

***

## 196. Next Lecture - Configuration for Connecting Microservices with Zipkin

***

## 197. Step 12 - Connecting Currency Exchange Microservice with Zipkin

***

## 198. Step 13 - Connecting Currency Conversion Microservices & API

***

## 199. Link for Next Lecture

***

## 200. Step 14 - Getting Setup with Microservices for Creating Container

***

## 201. Step 15 - Creating Container Image for Currency Exchange

***

## 202. Step 16 - Getting Started with Docker Compose - Currency

***

## 203. Step 17 - Running Eureka Naming Server with Docker Compose

***

## 204. Step 18 - Running Currency Conversion Microservice with Docker

***

## 205. Step 19 - Running Spring Cloud API with Docker Compose

***

### 206. Debugging Problems with Docker Compose

***

## 207. Spring Boot 3 Update - Zipkin URL Configuration

***

## 208. Step 20 - Running Zipkin with Docker Compose

***

## 209. How to handle failures

***
