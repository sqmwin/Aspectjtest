[TOC]

---

# 4. Spring与Dao

## 4.1 Spring与JDBC模板

### 4.1.1 导 入jar包

1.  Spring的JDBC包
2.  Spring的事务包

### 4.1.2     搭建测试环境

1.	**定义实体类 User**
2.	**定义数据库及表**
3.	**定义 IUserDao**
4.	**初步定义 UserDaoImpl**
5.	**定义 IUserService**
6.	**定义 UserServiceImpl**
7.	**定义测试类 MyTest**

### 4.1.3 数据源的配置

#### Spring 默认的数据源 DriverManagerDataSource

#### DBCP数据源BasicDataSource

#### C3P0 数据源ComboPooledDataSource

### 4.1.4 从属性文件读取数据库连接信息