# SAPMall

## 项目背景:

* 随着在线支付的风潮,现在基本所有系统都要一套支付流程,所以我着手于开发这样一套通用型的支付系统,只提供对外接口,从而实现所有的系统都可以接入该支付系统,通过该支付系统去实现支付流程,实现了原系统的业务流程与支付流程的解耦合
* 同时,当前电商项目比较热门,其涉及高并发等企业级问题,所以我着手开发一个电商系统,着手于实现高并发的解决,同时与支付系统进行对接,实现企业级的电商购物流程+支付流程的完整业务

## 技术栈:

* SpringBoot  2.1.7

* MySQL 5.7

* MyBatis 2.1

* Redis

* RabbitMQ
  

## 依赖:

* pom.xml文件: 

```xml
<!-- web起步依赖 -->
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<!-- mysql依赖 -->
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
</dependency>
<!-- myBatis依赖 -->
<dependency>
  <groupId>org.mybatis.spring.boot</groupId>
  <artifactId>mybatis-spring-boot-starter</artifactId>
  <version>2.1.0</version>
</dependency>
<!-- lombok依赖 -->
<!-- 配合IDEA的lombok插件,可以通过@Data直接给实体类对象自动加上get,set,toString等方法,加快开发效率 -->
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
</dependency>
```










































# sapmall
