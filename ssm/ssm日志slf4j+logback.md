1. 排除commons-logging

   ```java
   <exclusions>
       <exclusion>
       <artifactId>commons-logging</artifactId>
       <groupId>commons-logging</groupId>
       </exclusion>
   </exclusions>
   ```

   

2. 引入依赖

   ```java
   		<log4j.version>1.2.17</log4j.version>
           <slf4j.version>1.7.6</slf4j.version>
           <logback.version>1.2.3</logback.version>
           <jcl.over.slf4j>1.7.25</jcl.over.slf4j>
           <jul.to.slf4j>1.7.25</jul.to.slf4j>
   			
   			
   			
   			<!-- 日志 -->
               <dependency>
                   <groupId>log4j</groupId>
                   <artifactId>log4j</artifactId>
                   <version>${log4j.version}</version>
               </dependency>
               <dependency>
                   <groupId>org.slf4j</groupId>
                   <artifactId>slf4j-log4j12</artifactId>
                   <version>${slf4j.version}</version>
               </dependency>
               <dependency>
                   <groupId>org.slf4j</groupId>
                   <artifactId>slf4j-api</artifactId>
                   <version>${slf4j.version}</version>
               </dependency>
               <dependency>
                   <groupId>ch.qos.logback</groupId>
                   <artifactId>logback-classic</artifactId>
                   <version>${logback.version}</version>
               </dependency>
               <dependency>
                   <groupId>org.slf4j</groupId>
                   <artifactId>jcl-over-slf4j</artifactId><!-- 替换commons-logging-->
                   <version>${jcl.over.slf4j}</version>
               </dependency>
               <dependency>
                   <groupId>org.slf4j</groupId>
                   <artifactId>jul-to-slf4j</artifactId><!-- 替换java.util.logging-->
                   <version>${jul.to.slf4j}</version>
               </dependency>
   ```

   

3. 添加 logback.xml

   ````xml
   <?xml version="1.0" encoding="UTF-8"?>
   <configuration>
   	<appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
   		<encoder>
   			<pattern>%-4relative [%thread] %-5level %logger{35} - %msg %n</pattern>
   		</encoder>
   	</appender>
   
   	<root level="DEBUG">
   		<appender-ref ref="STDOUT" />
   	</root>
   
   </configuration>
   ````

   