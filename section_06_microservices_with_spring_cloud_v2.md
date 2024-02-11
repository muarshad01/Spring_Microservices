## 132. What's NEW in V2?

* `Spring Cloud LoadBalancer` (earlier `Ribbon`)
* `Spring Cloud Gateway` (earlier `Zuul`)
* `Resilience4j` (earlier `Hystrix`)
* Containerize Microservices
    * Docker & Docker Compose
* Kubernetes
    * Orchestrate Microservices with Kubernetes

***

## 133. Recommended

* Spring Boot 3
* [Git Code](https://github.com/in28minutes/spring-microservices-v3)

***

## 134. Have you already completed V1?

***

## 135. Course Downloads

* [Microservices with Spring Boot and Spring Cloud - Resources](https://www.in28minutes.com/resources-microservices-course)

***

## 136. Step 01 - Setting up Limits Microservice - V2

* Limits Microservice -> Spring-Cloud-Config-Server -> Local-Git Repo

* https://start.spring.io
    * com.in28minutes.microservices
    * `limits-service`

* Dependencies
    * Web (RESTfu, Spring MVC, Apache Tomcat)
    * DevTools (Fast application restarts)
    * Actuator (Monitor and manage your application)
    * Config Client (Connects with Spring-Cloud-Config-Server) 

### Connect Config-Client to pring-Cloud-Congi-Server
* Edit `application.properties`
    * spring.config.import=optional:configserver:http://localhost:8888
    * Notice, `optional`

***

## 137 - Code Backup Files

### Two Recommended Activities

* Activity - 1: 
    * Explore other backups for this section (Steps 08,10,13,15,21,25,29, final) 
        * https://github.com/in28minutes/spring-microservices-v3/tree/main/03.microservices
* Activity - 2: 
    * Get Familiar with the structure of Step-by-Step changes file 
    * https://github.com/in28minutes/spring-microservices-v3/blob/main/03.microservices/01-step-by-step-changes/readme.md#step-01

***

## 138. Step 02 - Creating a hard-coded limits-service - V2

* `@RestController`
* `@GetMapping("/limits")`

***

## 139. Step 03 - Enhance limits-service - Get configuration from application props

* Edit `application.properties`
```
spring.application.name=limits-service
spring.config.import=optional:configserver:http://localhost:8888

limits-service.minimum=3
limits-service.maximum=997
```

* `@Component`
* `@ConfigurationProperties("limits-service")`

***

## 140. Step 04 - Setting up Spring-Cloud-Config-Server - V2

* https://start.spring.io/
    * Group: com.in28minutes.microservices
    * Atrifact: spring-cloud-config-server
    * Description: Centralized Configuration Server
* Dependencies
    * Spring Boot DevTools
    * Config Server

* Edit `application.properties`
```
spring.application.name=spring-cloud-config-server
server.prot=8888
```

***

## 141. Step 05 - Installing Git and Creating Local-Git Repository - V2

```
$ git --version
````

```
$ mkdir -p ~/Desktop/in28minutes/git/spring-microservice-v2
$ cd       ~/Desktop/in28minutes/git/spring-microservice-v2
$ mkdir git-localconfig-repo
$ cd    git-localconfig-repo
$ git init
$ ls -a
```

```
$ touch limits-service.properties

limits-service.minimum=4
limits-service.maximum=996
```

```
$ git add *
* git commit -m "adding limits-service.properties"
```

* http://localhost:8888/limits-service/default

***

## 142. Debugging problems with Spring-Cloud-Config-Server - V2

* https://github.com/in28minutes/spring-microservices-v3/blob/main/03.microservices/01-step-by-step-changes/readme.md#spring-cloud-config-server---steps-01-to-08

***

## 143. Step 06 - Connect Spring-Cloud-Config-Server to Local-Git

* `@EnableConfigServer`

***

## 144. Step 07 - Connect Limits-Service to Spring-Cloud-Config-Server - V2

* https://localhost:8888/limits-service/default


* Edit `application.properties` of limits-service
    * spring.profiles.active=dev
    * spring.cloud.config.profile=dev

***

## 145. What should I do when I face a challenge

* Take a walk of take a nap!

***

## 146. Step 08 - Configuring Profiles for Limits-Service - V2

***

## 147. Debugging Guide for Microservices V2 + Docker

* [Debugging Guide - Microservices - V2](https://github.com/in28minutes/spring-microservices-v2/blob/main/03.microservices/01-step-by-step-changes/microservices-v2-1.md)

***
***

## 148. Step 09 - Introduction to Currency Conversion & Exchange

* Currency Exchange Microservice
    * http://localhost:8000/currency-exchange/from/USD/to/INR

* Currency Conversion Microservice
    * http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
  
***

## 149. Step 10 - Setting up Currency Exchange Microservice - V2

* http://start.spring.io
    * Group:com.in28minutes.microservices
    * Artifact: currency-exchange-service
* Dependencies
    * Spring Web
    * Spring Boot DevTools
    * Spring Boot Actuator
    * Config Client

* Edit `application.properties`
    * spring.application.name=currency-exchange
    * server.port=8000

***

## 150. URL and Response Structure for Currency Exchange Service

* http://localhost:8000/currency-exchange/from/USD/to/INR

***

## 151. Step 11 - Create a simple hard coded currency exchange

* `@PathVariable`

***

## 152. Step 12 - Setting up Dynamic Port in the Response - V2

* Currency Conversion Microservice
    * Load Balancer
        * Naming Server
        * Currency Exchange - Instance 1 (8000)
        * Currency Exchange - Instance 2 (8001)
        * Currency Exchange - Instance 3 (8002)


```java
@Autowired
private Environment environment;

CurrencyExchange currencyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
String port = environment.getProperty("local.server.port");
currencyExchange.setEnvironment(port);
```

***

## 153. Step 13 - Configure JPA and Initialized Data - V2

* Use in-memory database `H2`
* Use JPA to talk to `H2`

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
</dependency>
```

* Edit `application.properties`
```
spring.jpa.defer-datasource-initialization=true

spring.jpa.show-sql=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
```

* `@Entity`
* `@Id`

```
insert into currency_exchange(id,currency_from,currency_to,conversion_multiple,environment)
values (1001,'USD','INR',65,'');
insert into currency_exchange(id,currency_from,currency_to,conversion_multiple,environment)
values (1002,'EUR','INR',75,'');
insert into currency_exchange(id,currency_from,currency_to,conversion_multiple,environment)
values (1003,'AUD','INR',25,'');
```
***

## 154. Code backup

### Help for Debugging Problems:
* Here's the code backup at the end of Step 13: 
    * https://github.com/in28minutes/spring-microservices-v3/blob/main/03.microservices/step13.md

* Step by Step changes are detailed here: 
    * https://github.com/in28minutes/spring-microservices-v3/blob/main/03.microservices/01-step-by-step-changes/readme.md#step-13

***

## 155. Create a JPA Repository - V2

* ...

***

## 156. How to take care of yourselves

***

## 157. Step 15 - Setting up Currency Conversion Microservice - V2

* Edit `application.properties`
```xml
spring.config.import=optional:configserver:http://localhost:888
spring.application.name=currency-conversion
server.port=8100
```

***

## 158. URL and Response Structure for Currency Conversion Service

* http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10

***

## 159 - Step 16 - Creating a service for currency conversion - V2

***

## 160. Step 17 - Invokign Currency Exchange from Currency Conversion

***

## 161. Step 18 - Using Feign REST Client for Service Invocation - V2

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

* `@EnableFeignClients`
* `@FeignClient(name = "currency-exchange", url="localhost:8000")`

***

## 162. Step 19 - Understand Naming Server and Setting up Eureka

* Project Metadata
    * com.in28minutes.microservices
    * naming-server
* Dependencies
    * Spring Boot DevTools
    * Spring Boot Actuator
    * Eureka Server

* `@EnableEurekaServer`

```
spring.application.name=naming-server
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```
***

## 163. Debugging Problems with Eureka - V2

### Complete Debugging Guide

* https://github.com/in28minutes/spring-microservices-v3/blob/main/03.microservices/01-step-by-step-changes/readme.md#eureka---step-19-to-21

***

## 164. Step 20 - Connect Currency Conversion & Currency Exchange

* Edit `application.properties`
    * eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka

***

## 165. All Work and No Play Make Adan and Eve Dull Kids

***

## 166. Course Update

***

## 167. Step 21 - QuickStart by Importing Microservices

***

## 168 - Step 22 - Load Balancing with Eureka, Feign & Spring Cloud

***

## 169. Step 22 - Setting up Spring Cloud API Gateway

* Project Metadata
    * com.in28minutes.microservices
    * api-gateway
* Dependencies
    * Spring Boot DevTools
    * Spring Boot Actuator
    * Eureka Discovery Client
    * Gateway

```
spring.application.name=api-gateway
server.port=8765
```

***

## 170. URLs for next Lecture

```
- http://localhost:8765/currency-exchange/from/USD/to/INR

- http://localhost:8765/currency-conversion/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10

- http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10
```

***

## 171. Step 23 - Enabling Discovery Locator with Eureka for Spring

* Edit `application.properties`
    * spring.cloud.gateway.discovery.locator.enabled=true
    * spring.cloud.gateway.discovery.locator.lowerCaseServiceId=true

***

## 172. Debugging Problems with Spring Cloud Gateway - V2

### Complete Debugging Guide
* https://github.com/in28minutes/spring-microservices-v3/blob/main/03.microservices/01-step-by-step-changes/readme.md#spring-cloud-api-gateway---step-22-to-step-25

***

## 173. Step 24 - Exploring Routes with Spring Cloud Gateway

***

## 174. Step 25 - Implementing Spring Cloud Gateway Logging Filter

* Simple, yet effective way to route to APIs
* Provide cross cutting concerns:
    * Security
    * Monitoring/metrics
* Built on top of Spring WebFlux (Reactive Approach)
* Features:
    * Match routes on any request attribute
    * Define Predicates and Filters
    * Integrates with Spring Cloud Discovery Client (Load Balancing)
    * Path Rewriting

***

## 175. Step 26 - Getting started with Circuit Breaker - Resilience4j

* Questions:
    * Can we return fallback-response if a service is down?
    * Can we retry requests in case of temporary failures?
    * Can we implement a Circuit-Breaker-pattern to reduce load?
    * Can we implement rate-limiting?

***

## 176. Do not skip

***

## 177. Step 27 - Playing with Resilience4j - Retry and Fallback

* `@Retry(name="default", fallbackMethod="hardcodedResponse")`

```
resilience4j.retry.instances.sample-api.maxRetryAttempts=5
resilience4j.retry.instances.sample-api.waitDuration=1s
resilience4j.retry.instances.sample-api.enableExponentialBackoff=true
```

***

## 178. Step 28 - Playing with Circuit Breaker Features of Resilience4j

* `@CircuitBreaker(name="default", fallbackMethod="hardcodedResponse")`

* `watch -n 0.1 http://localhost:8000/sample-api`

***

## 179. Step 29 - Exploring Rate Limiting and BulkHead Features of

* Edit `application.properties`
```
resilience.ratelimiter.instance.default.limitForPeriod=2
resilience.ratelimiter.instance.default.limitRefreshPeriod=10s
```

***

## 180. How to be producctive - 3 Tips

***
