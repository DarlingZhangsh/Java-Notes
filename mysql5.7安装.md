# mysql5.7安装

## zip解压版

#### 1. 下载

<img src="mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222171222.png" style="zoom:80%;" />

![image-20191222171759473](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222171759473.png)

*官网下载速度慢，可以到国内开源镜像下载*

#### 2. 解压

 解压安装包，根据自己的喜好选择路径，我L的完整路径为：D:\MySQL\mysql-5.7.28

#### 3.  配置环境变量 

**新增环境变量**

![image-20191222173217933](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222173217933.png) 

**在path中添加**

![image-20191222173346852](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222173346852.png)

#### 4. 创建my.ini文件

**在D:\MySQL\mysql-5.7.28目录下新建my.ini文件**

```
[mysqld]
port = 3306
# MySQL程序安装目录
basedir=D:\MySQL\mysql-5.7.28
# 数据库文件存放地址
datadir=D:\MySQL\mysql-5.7.28\Data 
# 最大连接数
max_connections=200
character-set-server=utf8
# 数据库默认使用引擎
default-storage-engine=INNODB
[mysql]
# mysql客户端默认的字符集，5.7才有的，5.6以及之前的版本没有default-character-set属性
default-character-set=utf8
```

#### 5.   以 *管理员* 身份打开cmd命令窗口，将目录切换到MySQL的安装目录的bin目录下 

![image-20191222174650430](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222174650430.png)

#### 6. 安装服务进程

**在控制台输入**

```
mysqld -install
或者
mysqld -install MySQL57 

（加上“MySQL57”表示自定义服务名称为MySQL57，不写的话默认服务名是MySql）
```

等待片刻，出现 **Service successfully installed** 提示，说明安装成功。

***

这时按“win + R” 打开运行，输入“services.msc”，点击确定打开服务列表就能看到名为MySQL（或MySQL57 ）的服务

#### 7.  执行以下语句进行MySQL的初始化 

`  mysqld --initialize-insecure --user=mysql `

***

 执行完这条命令后，MySQL会自建一个data文件夹，并且建好默认数据库，登录的用户名为root，密码为空 

####  8.执行以下命令以启动mysql服务 

` net start mysql `

####  9.启动MySQL之后，root用户的密码为空，设置密码，命令如下： 

```
mysqladmin -u root -p password 新密码
Enter password: 旧密码
```

 **需要输入旧密码时，由于旧密码为空，所以直接回车即可** 

####  10.安装完毕

在cmd窗口输入以下命令登录

`mysql -uroot -p`

#### 11.卸载

***

**以管理员的身份运行cmd，使用命令net stop mysql(你的mysql服务名)，停止服务**

**使用命令mysqld –remove mysql服务名 卸载服务**

**将安装文件夹删除**

 **Win+R打开运行，输入regedit，清除注册表**

>  清除注册表中的该MySQL服务，有几个地方: 
> a.HKEY_LOCAL_MACHINE\SYSTEM\ControlSet001\Services\Eventlog\Application\MySQL目录删除 
> b.HKEY_LOCAL_MACHINE\SYSTEM\ControlSet002\Services\Eventlog\Application\MySQL目录删除 
> c.HKEY_LOCAL_MACHINE\SYSTEM\CurrentControlSet\Services\Eventlog\Application\MySQL目录删除 
> 注册表中的ControlSet001、ControlSet002不一定是001和002，可能是ControlSet005、006之类，删除的时候都删除就可以

## msi安装版

#### 1.选择安装类型

![image-20191222190438468](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222190438468.png)

![image-20191222190259661](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222190259661.png)

![image-20191222190543586](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222190543586.png)

#### 2. 选择安装的位置 MySQL安装位置 和数据存放位置 

![image-20191222190700412](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222190700412.png)

#### 3. 点击Next --> Execute – > Next 

![image-20191222191046815](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222191046815.png)

![image-20191222190919617](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222190919617.png)

![image-20191222191134504](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222191134504.png)

![image-20191222191201739](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222191201739.png)

![image-20191222191228373](mysql5.7%E5%AE%89%E8%A3%85.assets/image-20191222191228373.png)

#### 4.其余选择默认

