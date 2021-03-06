# SoftwareEngineeringProject
Andriod端app开发(springboot)  
## Git使用规范
1.分支说明  
·master分支：稳定的开发分支，切忌直接向master分支提交未完成代码  
·新建分支：请根据开发需求自行创建分支，开发完成后合并注意处理冲突  
2.提交说明  
·请使用sourcetree版本管理工具，不要直接在github上逐文件提交  
·提交时写明变更情况  
## 代码规范
类名、变量及数据库开发一切规范遵照《阿里JAVA开发手册2019》，以便合作开发  
## 开发过程
1.遵循软件工程开发原则，整个过程采用scrum+xp敏捷开发  
2.迭代周期为两周，增量开发（每次增加用户可感知的功能）  
3.采用微服务架构，根据事务划分不同模块，彼此独立  
4.各模块事务先自己进行单元测试，最后集成代码统一进行交付测试，预留足够时间代码重构--单元测试+重构+持续集成  
5.每周开会回顾、布置新任务，可根据项目进度变动，会议文档合作共享，小组成员可随时更新个人进度  
## 注意事项
1.开发涉及多个同学的公共部分时多进行交流  
2.请遵循Git使用规范，代码规范  
3.根据项目进度开会，每次开会记录会议纪要，开会提前通知  
4.以上说明均为参考规范，可就事论事，并非强制要求  
##项目特色
1.平台部署：后端部署在阿里云ECS服务器（接口可访问如：http://139.196.36.97:8080/sbDemo/v2/booklist-management/booklistlists）
          数据库部署在阿里云RDS云服务器
          前端Android
2.微服务架构：6个微服务，彼此独立，高内聚低耦合
3.开发工具：Swaggerui自动生成API文档（http://139.196.36.97:8080/sbDemo/swagger-ui.html）
                使用DeepCode等代码扫描工具，定期对源码进行扫描与重构
4.定期迭代开发
