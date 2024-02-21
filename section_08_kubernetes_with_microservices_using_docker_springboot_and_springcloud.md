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

## 225. Step 13 - Understanding Kubernetes Architecture - 

***

## 226. Installing Gcloud

***

## 227. Installing Kubectl

***

## 228. Link for the Next Lecture

***

## 229. Step 14 - Setup Currency Exchange & Conversion

***

## 230. Step 15 - Container images for Exchange & Currency Conversion

***

## 241. Step 26 - Configuring Liveness and Readiness Probes for

***

## 242. Step 27- Autoscaling Microservices with Kubernetes

***

## 243. Step 28 - Delete Kubernetes Cluster Thank You!

***

## 244. How can you help?

***
