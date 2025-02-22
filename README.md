# JavaEE-Maven-demo

本项目是Java EE课程的demo项目，同学们可以以本项目为基础，设计以后实验课项目。

1. Jdk 8
2. Maven 3.6.0


1. 新建一个文件夹作为项目的根目录，并cd进入新建的文件夹。
2. git clone https://gitee.com/dgut-sai/JavaEE-Maven-demo.git
3. 输入码云的用户名与密码，即可下载本项目的源代码。

本项目配置了jetty maven插件和tomcat8 maven插件，可以使用他们之一运行项目。

1. cd 项目的根目录
2. mvn jetty:run  或  mvn tomcat8:run-war
3. 即可在浏览器打开首页，http://localhost:8080/test，或http://localhost:8080/test/hello
4. pom.xml文件里有详细的注释说明如果配置Maven。


1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request