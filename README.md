# lmlys
A Chinese online shopping website
```
├─.idea
│  └─libraries
├─.mvn
│  └─wrapper
└─src
    ├─main
    │  ├─java
    │  │  └─team
    │  │      └─area237
    │  │          └─lmlys
    │  │              ├─controller    ---控制层，与前端进行交互
    │  │              ├─dao    ---一个Dao类定义一个接口，与数据库交互。
    │  │              ├─model  ---模型层
    │  │              │  ├─entity   ---实体类
    │  │              │  ├─request  ---请求相关类
    │  │              │  └─response ---响应相关类
    │  │              ├─security    ---Spring Security包
    │  │              ├─service     ---服务层,封装通用的业务逻辑，为业务层提供服务，与数据层交互
    │  │              │  └─impl     ---service接口的实现类
    │  │              └─utils       ---工具包
    │  └─resources
    │      ├─mybatis
    │      │  └─mapper    ---mybatis的mapper配置文件，cc负责
    │      └─sqlfile    ---sql源文件
    └─test
        └─java
            └─team
                └─area237
                    └─lmlys
```
##文档设计分工
- 老哥:网页原型设计与需求
- CC、Zy：需求
##Code分工
- 老哥：根据接口，实现service，并参与Dao层Code。
- CC：数据库，完成mapper。
- 大眼：前端
- Zy：controller和model的Code

##暂时未分工项目
- 测试
