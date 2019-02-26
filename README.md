# Chzu-CollegeTalent

## 接口主机地址
```
http://118.184.219.170:9001/
```

##### 1、登录接口——学生企业统一使用此接口
```
/login.do   POST
参数：
    email       String      邮箱地址
    password    String      md5字符串
    
示例：
    /login.do?email=huolifu@eruik.com&password=#####
    
响应：(注：type是身份的标识，1/企业，2/学生)

```

##### 2、学生注册
```
/students/register.do   POST
参数：
    name                String  名称
    sex                 String  性别
    grade               String  年级
    major               String  专业
    employment          Integer 是否就业    1/已就业，0/未就业
    employmentCompany   String  就业公司[选填]
    employmentCity      String  就业城市[选填]
    phone               String  联系电话
    wechat              String  微信账号[选填]
    qq                  String  QQ账号[选填]
    email               String  邮箱地址
    password            String  密码md5
```

##### 3、获取学生信息
```
/students/get           GET
参数：
    id      Integer     学生id

示例：
    /students/get?id=1
    
响应：

```

##### 4、修改学生登录密码
```
/students/updatePassword    POST
参数：
    id              Integer     学生id
    password        String      新密码md5
    oldpassword     String      老密码md5

示例：
    /students/updatePassword?id=1&password=###&oldpassword=##

响应：


```

##### 5、修改学生信息
```
/students/update    POST
参数：
    id                  Integer 学生id
    name                String  名称
    sex                 String  性别
    grade               String  年级
    major               String  专业
    employment          Integer 是否就业    1/已就业，0/未就业
    employmentCompany   String  就业公司[选填]
    employmentCity      String  就业城市[选填]
    phone               String  联系电话
    wechat              String  微信账号[选填]
    qq                  String  QQ账号[选填]


```

##### 6、企业注册
```
/company/register.do   POST
参数：
    name                String  名称
    contact             String  联系人
    address             String  联系地址
    serviceTrade        String  服务行业
    phone               String  联系电话
    email               String  邮箱地址
    password            String  密码md5
```

##### 7、获取企业信息
```
/company/get           GET
参数：
    id      Integer     学生id

示例：
    /company/get?id=1
    
响应：

```

##### 8、修改企业登录密码
```
/company/updatePassword    POST
参数：
    id              Integer     企业id
    password        String      新密码md5
    oldpassword     String      老密码md5

示例：
    /company/updatePassword?id=1&password=###&oldpassword=##

响应：


```

##### 9、修改企业信息
```
/company/update    POST
参数：
    id                  Integer 企业id
    name                String  名称
    contact             String  联系人
    address             String  联系地址
    serviceTrade        String  服务行业
    phone               String  联系电话


```

##### 10、获取问卷列表
```
/questionnaire/list    POST
参数：
    pageNum             Integer 页数[选填]/默认1
    pageSize            Integer 大小[选填]/默认10

```

##### 11、获取问卷信息
```
/questionnaire/get      GET
参数：
    id                  Integer 问卷id

```

##### 12、获取问卷列表及其题目信息
```
/questionnaire/listWithSubject    GET
参数：
    无

```

##### 13、提交问卷信息
```
/questionnaire/addWithSubjest    POST
参数：


```

