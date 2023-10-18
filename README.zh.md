# 自主迷宫探索器-AME-

AME是一款基于Arduino的机器人，它可以导航一个9x9的迷宫，使用YOLOv8训练的模型识别宝藏，并将发现的结果实时更新到基于Tomcat的网站。

## 环境配置

本项目需要以下环境配置：

### Python 库

```bash
pip install opencv_contrib_python==4.6.0.66
pip install opencv_python==4.6.0.66
pip install pyserial==3.5
pip install ultralytics==8.0.136
pip install Pillow==10.1.0
```

### 其他软件

- TOMCAT
- Arduino IDE
- MySQL
- Eclipse

## 安装和使用方法

### 第零步：安装项目所需要的硬件和软件

### 第一步：组装小车和设置ESP32-CAM

按照Tele文件夹内的代码对小车进行组装以及接线，之后对ESP32-CAM进行wifi的基础设置。然后连接蓝牙JDY31模块并在for_computer代码中修改对应的端口等配置文件内容。并且根据E-commerce文件夹中的代码建立本地服务器与网站。

### 第二步：连接小车和运行Python脚本

打开TOMCAT服务器，登录本地网站，并且运行Python脚本与小车进行建立连接。

### 第三步：调试或运行小车

将小车放入迷宫进行调试或者运行。

### 第四步：检查运行结果

在TOMCAT网站中检查运行的结果，确认运行成果。

## 贡献

欢迎任何形式的贡献！

## 许可证

本项目采用 Apache-2.0 license。