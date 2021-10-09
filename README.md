# SAPMall

## 项目背景:

* 随着在线支付的风潮,现在基本所有系统都要一套支付流程,所以我着手于开发这样一套通用型的支付系统,只提供对外接口,从而实现所有的系统都可以接入该支付系统,通过该支付系统去实现支付流程,实现了原系统的业务流程与支付流程的解耦合
* 同时,当前电商项目比较热门,其涉及高并发等企业级问题,所以我着手开发一个电商系统,着手于实现高并发的解决,同时与支付系统进行对接,实现企业级的电商购物流程+支付流程的完整业务

## 项目核心功能流程:

![image-20211008090721422](F:\acer\ProjectForWork\sapmall\doc\mdImage\image-20211008090721422.png)

![image-20211008090835187](F:\acer\ProjectForWork\sapmall\doc\mdImage\image-20211008090835187.png)



## 项目整体感知

![image-20211008083533695](F:\acer\ProjectForWork\sapmall\doc\mdImage\image-20211008083533695.png)



## 数据库设计

* 数据库表关系设计:

  ![02-数据库表设计](F:\acer\ProjectForWork\sapmall\doc\mdImage\02-数据库表设计.jpg)

* 数据库表结构:

![03-用户表](F:\acer\ProjectForWork\sapmall\doc\mdImage\03-用户表.jpg)

**在产品表中，价格用decimal类型。decimal（20，2）表示最大整数位支持18位，小数位2位。**
**decimal:数字型，128bit，不存在精度损失，常用于银行帐目计算**

![04-分类表](F:\acer\ProjectForWork\sapmall\doc\mdImage\04-分类表.jpg)

![05-产品表](F:\acer\ProjectForWork\sapmall\doc\mdImage\05-产品表.jpg)

![06-订单表](F:\acer\ProjectForWork\sapmall\doc\mdImage\06-订单表.jpg)

![07-订单表](F:\acer\ProjectForWork\sapmall\doc\mdImage\07-订单表.jpg)

![09-收货地址表](F:\acer\ProjectForWork\sapmall\doc\mdImage\09-收货地址表.jpg)![08-订单明细表](F:\acer\ProjectForWork\sapmall\doc\mdImage\08-订单明细表.jpg)

* 索引设计: 

  ​	***设置索引的原因:  对于经常查询且很少修改的字段, 加以索引,加快条件查询的效率***

![10-索引设计](F:\acer\ProjectForWork\sapmall\doc\mdImage\10-索引设计-1633653584311.jpg)

* 时间戳的设计: 

  一直对时间戳这个概念比较模糊，相信有很多朋友也都会误认为：时间戳是一个时间字段，每次增加数据时，填入当前的时间值。其实这误导了很多朋友。
  **时间戳：数据库中自动生成的唯一二进制数字，与时间和日期无关的， 通常用作给表行加版本戳的机制。存储大小为 8个字节。**
  **每个数据库都有一个计数器，当对数据库中包含 timestamp 列的表执行插入或更新操作时，该计数器值就会增加。该计数器是数据库时间戳。这可以跟踪数据库内的相对时间，而不是时钟相关联的实际时间。一个表只能有一个 timestamp 列。每次修改或插入包含 timestamp 列的行时，就会在 timestamp 列中插入增量数据库时间戳值**。这一属性使 timestamp 列不适合作为键使用，尤其是不能作为主键使用。对行的任何更新都会更改 timestamp 值，从而更改键值。如果该列属于主键，那么旧的键值将无效，进而引用该旧值的外键也将不再有效。如果该表在动态游标中引用，则所有更新均会更改游标中行的位置。如果该列属于索引键，则对数据行的所有更新还将导致索引更新。
  使用某一行中的 timestamp 列可以很容易地确定该行中的任何值自上次读取以后是否发生了更改。如果对行进行了更改，就会更新该时间戳值。如果没有对行进行更改，则该时间戳值将与以前读取该行时的时间戳值一致。若要返回数据库的当前时间戳值，请使用 @@DBTS。
  在控制并发时起到作用：
  **用户A/B同时打开某条记录开始编辑，保存是可以判断时间戳，因为记录每次被更新时，系统都会自动维护时间戳，所以如果保存时发现取出来的时间戳与数据库中的时间戳如果不相等，说明在这个过程中记录被更新过，这样的话可以防止别人的更新被覆盖.**

![11-时间戳设计](F:\acer\ProjectForWork\sapmall\doc\mdImage\11-时间戳设计.jpg)



* 数据库建立:

![12-数据库建立](F:\acer\ProjectForWork\sapmall\doc\mdImage\12-数据库建立.jpg)



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



## Dao层: 使用MyBatis-generator生成

* dao层架构:

  ![image-20211008203503970](F:\acer\ProjectForWork\sapmall\doc\mdImage\image-20211008203503970.png)

* 配置mapper文件位置: application.yml

  ```yml
  # 配置mapper文件所在位置
  mybatis:
    mapper-locations: classpath:mappers/*.xml
  ```

* Application类上加上扫描包注解@MapperScan

  ```java
  @SpringBootApplication
  @MapperScan("com.mlming.springboot.dao")
  public class SapmallApplication {
      public static void main(String[] args) {
          SpringApplication.run(SapmallApplication.class, args);
      }
  }
  ```

* **开发推荐: 给每一个dao层接口对应一个测试类,单独测试里面各个方法**

  实现方式: 在每个dao层接口,右键->goto->Test 从而创建对应测试类

  **注意: 由于在SpringBoot环境下,所以必须加上@RunWith(SpringRunner.class),@SpringBootTest注解**













































# sapmall
