## 210. Step 00 - Docker, Kubernetes and Microservices - Made for each

***

## 211. Step 01 - Getting Started with Docker, Kubernetes and Google

***

## 212. Step 02 - Creating Google Cloud Account

***

## 213. Step 03 - Creating Kubernetes Cluster with Google Kubernetes

***

## 214. Step 04 - Review Kubernetes Cluster and Learn Few Fun Facts

***

## 215. Step 05 - Deploy Your First Spring Boot Application

***

## 216. Command executed in this section

***

## 217. Step 06 - Quick Look at K8s Concepts - Pods, ReplicaSet, Deployment, Service

```
$ kubectl get events

$ kubectl get pods
$ kubectl get replicatset
$ kubectl get deployment
$ kubectl get service
```

* K8s uses single responsibility principle

### Features
* Declarative
* Easy Scaling
* Load Balancing
* Self Healing
* Zero Downtime Deployments

***

## 218. Step 07 - Understanding Pods in Kubernetes

* `Node[Pod1{C1, C2, ...}, Pod2{C1, C2, ...}, ...]`
* Multiple containers within a Pod share the Pod resources and communicate with each other using `localhost`
* Each pod has a unique IP address

```
$ kubectl get pods -o wide
$ kubectl explain pods
$ kubectl get pods
$ kubectl describe pod NAME
```

### Namespaces
* Provide ISOLATION for parts for cluster from other parts of cluster
* Suppose, DEV & QA environments are running inside the same cluster
* How can we separate the resources of DEV & QA environments
* Solution: Create namespaces

### Labels, Selectors
* Tie a Pod with ReplicaSet or Service 

### Annotation
* Meta information about a Pod

***

## 219. Step 08 - Understanding ReplicaSets in K8s

```
$ kubectl get replicasets
$ kubectl get replicaset
$ kubectl get rs

$ kubectl get    pods -o wide
$ kubectl delete pods NAME
```

### Scale
```
$ kubectl scale deployment NAME --replicas=3
```

```
$ kubectl get events --sort-by=.metadata.crationTimestamp

$ kubectl explain replicaset
```

***

## 220. Step 09 - Understanding Deployment in K8s

```
$ kubectl get rs
$ kubectl get rs -o wide
```

```
$ kubectl set image deployment hello-world-rest-api hello-world-rest-api:DUMMY_IMAGE:TEST

$ kubectl get rs -o wide
$ kubectl get pods


$ kubectl get events --sort-by=.metadata.creationTimestamp
```

```
$ kubectl set image deployment hello-world-rest-api hello-world-rest-api:0.0.2.RELEASE

$ kubectl get pods
$ kubectl get rs

$ kubectl get events --sort-by=.metadata.creationTimestamp
```

***

## 221. Step 10 - Quick Review of K8s Concepts - Pods, Replica Sets & Deployment 

* Deployment ensure that a release upgrade from V1 to V2 happens without a hitch

***

## 222. Technology Change is an `Opportunity`

* Boost Employability
    * Be proficient with latest technologies
* Foster Creativity
    * New technologies inspire unique approaches to tasks 
* Enhance Problem-Solving
    * New tools / methodologies offer innovative solutions to complex problems 
* Prepare for the Future
    * Understanding emerging technologies sets you up for the long-term success

***

## 223. Step 11 - Understanding Services in K8s

```
$ kubectl get pods
$ kubectl get pods -o wide
$ kubectl delete pod <POD_NAME>

```
* Each Pod has a unique IP address
* A service basically allows your application to receive traffic through a permanent lifetime IP address.

```
$ kubectl expose deployment hello-world-rest-api --type=LoadBalancer --port=8080
$ kubectl get services
```

* ClusterIP service can only be access from inside the clueter. It doesn't have an EXTERNAL-IP
***

## 224. Step 12 - Quick Review of `GKE` on Google Cloud Console

***

## 225. Step 13 - Understanding K8s Architecture - Master Node and Worker Nodes
* Cluster
    * Master Node(s)
        * API Server (`kube-apiserver`)
        * Distributed Database (`etcd`)
        * Scheduler (`kube-scheduler`)
        * Controller Manager (`kube-controller-manager`)
    * Worker Node(s)
        * Node Agent (`kubelet`)
        * Networking Component (`kube-proxy`)
        * Container Runtime (`docker`)
        * PODS

```
$ kubectl get componentstatuses
```

***

## 226. Installing Gcloud

***

## 227. Installing Kubectl

***

## 228. Link for the Next Lecture

* https://github.com/in28minutes/spring-microservices-v3/tree/main/05.kubernetes

***

## 229. Step 14 - Setup Currency Exchange & Conversion


***

## 230. Step 15 - Container images for Exchange & Currency Conversion

* Run as -> Maven Build 
```
Goals: spring-boot:build-image -DskipTests
```

```
$ docker login
$ docker push in28min/mmv2-currency-exchange-service:0.0.11-SNAPSHOP
$ docker push in28min/mmv2-currency-conversion-service:0.0.11-SNAPSHOP
```

***

## 231. Step 16 - Deploy Microservices to K8s & Understand Service Discovery

```
$ kubectl version

$ kubect create deployment currency-exchange --image=in28min/mmv2-currency-exchange-service:0.0.11-SNAPSHOP
$ kubectl expose deployment currency-exchange --type=LoadBalancer --port=8000
$ kubectl get sve
$ kubectl get services
$ kubectl get pods
$ kubectl get replicaset
```
***

## 232. Step 17 - Creating Declarative Configuration K8s YAML for Microsercies

```
$ cd /in28Minutes/git/spring-microservices-v3/05.kubernetes/currency-exchange-service
$ kubectl get deployment currency-exchange -o yaml >> deployment.yaml
$ kubectl get service    currency-exchange -o yaml >>    service.yaml

$ kubectl apply -f deployment.yaml
```

```
$ watch curl ....
```
***

## 233. Step 18 - Clean up K8s YAML for Microservices

***

## 234. Step 19 - Enable Logging and Tracing APIs in Google Cloud Platform

***

## 235. Step 20 - Deploying Microservices using K8s YAML Configuration

```
$ kubectl delete all -l app=currency-exchange
$ kubectl delete all -l app=currency-conversion
```

```
$ kubectl get all
$ kubectl apply -f deployment.yaml
$ kubectl get service --watch
```
***

## 236. Step 21 - Playing with K8s Declarative YAML Configuration

```
$ kubectl get all
$ kubectl apply -f deployment.yaml
$ kubectl get service --watch
```

***

## 237. Step 22 - Creating Environment Variables to enable Microservice Communication

***

## 238. Step 23 - Understanding Centralized Configuration in K8s - Config Maps

```
$ kubectl crete configmap currency-conversion --from-literal=CURRENCY_EXCHANGE=http://currency-exchange

$ kubectl get configmap currency-conversion
$ kubectl get configmap currency-conversion -o yaml >> configmap.yaml
```
***

## 239. Step 24 - Exploring Centralized Logging and Monitoring in GKE

***

## 240. Step 25 - Exploring Microservices Deployments with K8s

```
$ kubectl rollout history deployment currency-conversion
$ kubectl rollout history deployment currency-exchange
$ kubectl rollout undo deployment currency-exchange --to-revision=1 deployment.apps/currency-exchange rolled back
```

***

## 241. Step 26 - Configuring Liveness and Readiness Probes for Microservices with K8s

* Spring Boot Actuator
    * `/health/readiness`
    * `/health/liveness`

***

## 242. Step 27- Autoscaling Microservices with K8s

```
$ kubectl scale deployment currency-exchange --replicas=2
$ kubectl autoscale deployment currency-exchange --min=1 max=2 --cpu-percent=5
```

```
$ kubectl get hps   # horizontal podautoscaler
```

```
$ kubectl top pods
$ kubectl top nodes
```

***

## 243. Step 28 - Delete K8s Cluster Thank You!

***

## 244. How can you help?

***

* WebServices -> RESTful WebServices -> SpringCloud -> Microservices

***
