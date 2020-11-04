# ORACLE11g安装

## 1.下载解压

[ORACLE下载地址](https://www.oracle.com/database/technologies/oracle-database-software-downloads.html#19c "oracle")

![image-20191224191146554](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224191146554.png)

**将两个压缩包解压并合在一起**

## 2. 关闭杀毒软件和防火墙

![image-20191224192045216](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224192045216.png)

## 3. 安装

![image-20191224192123469](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224192123469.png)

**点击setup.exe 会出现小黑窗口和以下界面**

![image-20191224192303681](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224192303681.png)

![image-20191224192555342](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224192555342.png)

![image-20191224192635692](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224192635692.png)

![image-20191224192655235](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224192655235.png)

![image-20191224193559224](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224193559224.png)

![image-20191224193733716](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224193733716.png)

**点击完成，等待安装**

![image-20191224205645995](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224205645995.png)

**可点击此处解锁用户和设置密码**

![image-20191224205855657](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224205855657.png)

**不设置的话（sys、system）默认为之前设置的口令**

***

## 4.PLSQL Developer安装

一直next

最后打开tool->Preferences做以下设置



![image-20191224210446530](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224210446530.png)



**普通用户选normal 管理员选sysdba**

![image-20191224211016097](ORACLE11g%E5%AE%89%E8%A3%85.assets/image-20191224211016097.png)



## 5.创建Oracle表空间

### a.查询表空间的存储目录 

```plsql
SELECT * FROM Dba_Data_Files ddf
```

![image-20200204163645143](ORACLE11g安装.assets/image-20200204163645143.png)

### b.创建表空间：

```plsql
Create tablespace xxx
logging
datafile 'D:\ORACLE\ORADATA\ORCL\xxx.dbf'
size 50m
autoextend on
next 50m maxsize 2048m
extent management local;
```



### c.创建用户：

```plsql
Create user yyy identified by zzz default tablespace xxx temporary tablespace temp;
```

注意：以上yyy--创建的用户名，zzz--用户的密码，xxx为第1步创建的表空间名称

### d.为用户授权：

```plsql
grant connect,resource,dba to yyy;
```

**DBA: 拥有全部特权，是系统最高权限，只有DBA才可以创建数据库结构。
RESOURCE:拥有Resource权限的用户只可以创建实体，不可以创建数据库结构。
CONNECT:拥有Connect权限的用户只可以登录Oracle，不可以创建实体，不可以创建数据库结构。
对于普通用户：授予connect, resource权限。**

### e.修改表空间大小

```plsql
alter database datafile 'd:\app\administrator\oradata\orcl\xxx.dbf' autoextend on next 50m maxsize unlimited;
```

###  f.删除用户 表空间

```  plsql
DROP USER yyy CASCADE
DROP TABLESPACE xxx INCLUDING CONTENTS AND DATAFILES;
```



## 6.Oracle使用数据泵导入/导出数据（expdp/impdp）

### 1. A电脑上的操作（expdp数据导出）

a. 使用管理员登录

b. 创建目录路径：输入命令：create directory data_dir as 'E:\ora\data' ;

```plsql
*   data_dir为路径名称，可自命名，E:\ora\data为数据库导出文件存放路径（路径必须存在）
	使用命令：select * from dba_directories可查询用户创建目录
```

c. 为oracle用户授予访问数据目录的权限

``` plsql
*   Grant read,write on directory data_dir to dbuser;
	dbuser为要导出的账户名
```

d. 导入导出操作授权

```plsql   
grant exp_full_database,imp_full_database to dbuser;
```

e. 数据导出，在cmd中执行命令

``` bash
expdp dbuser/123456@orcl 
schemas=dbuser 
dumpfile=expdp.dmp 
directory=data_dir 
logfile=expdp.log
expdp [用户名]/[密码]@[服务名]
schemas=[用户名]
dumpfile=[导出数据库文件（可自命名）]
directory=[目录名]
logfile=[日志文件文件名（可自命名）]
注意：命令结束不需要加“;”
```

### 2. B电脑上的操作（impdp 数据导入）

a. 创建用户，表空间，授权

b. 使用管理员登录

c.  创建目录路径：输入命令：create directory data_dir as 'E:\ora\data' ;

``` plsql
*	data_dir为路径名称，可自命名，E:\ora\data为数据库导出文件存放路径（路径必须存在）
	使用命令：select * from dba_directories可查询用户创建目录
```

d. 为oracle用户授予访问数据目录的权限，输入命令：Grant read,write on directory data_dir to xxx;

e. 导入导出操作授权，输入命令：grant exp_full_database,imp_full_database to xxx;

f.  将从A电脑中E:\ora\data目录下的.dmp数据泵导出文件拷贝至B电脑创建的目录（E:\ora\data）中

g. 数据导入, 在cmd执行命令

```bash
impdp user/123456@orcl 
REMAP_SCHEMA = dbuser:user 
table_exists_action = replace 
directory=data_dir dumpfile=expdp.dmp logfile=expdp.log
impdp [用户名]/[密码]@[服务名]
REMAP_SCHEMA=[源用户名1]:[目标用户名2]
table_exists_action=replace /存在的表动作(覆盖)/
directory=[目录名]
dumpfile=[.dmp文件名]
logfile=[.log文件名]
```

## 7.恢复表数据操作
```plsql
查看时间节点是否存在被删除的数据
select * from CHKPT_FILE as of timestamp to_timestamp('2020-06-25 13:30:00','yyyy-MM-dd hh24:mi:ss')
 --开启行移动功能 
alter table CHKPT_FILE enable row movement
 --恢复表数据
flashback table CHKPT_FILE to timestamp to_timestamp('2020-06-25 13:33:00','yyyy-mm-dd hh24:mi:ss')
 --关闭行移动功能 ( 千万别忘记 )
alter table CHKPT_FILE disable row movement

恢复表操作
select 'flashback table '||a.original_name||' to before drop;' from 
recyclebin a where a.operation = 'DROP' and a.type='TABLE';
```

