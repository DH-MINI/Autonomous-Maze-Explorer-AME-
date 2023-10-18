# Autonomous-Maze-Explorer-AME-

AME is an Arduino-based robot that navigates a 9x9 maze, identifies treasures using a YOLOv8-trained model, and communicates findings to a Tomcat-based website for real-time updates.

## Environment Setup

This project requires the following environment setup:

### Python Libraries

```bash
pip install opencv_contrib_python==4.6.0.66
pip install opencv_python==4.6.0.66
pip install pyserial==3.5
pip install ultralytics==8.0.136
pip install Pillow==10.1.0
```

### Other Software

- TOMCAT
- Arduino IDE
- MySQL
- Eclipse

## Installation and Usage

### Step 0: Install the necessary hardware and software for the project

### Step 1: Assemble the car and set up ESP32-CAM

Follow the code in the Tele folder to assemble and wire the car, then set up the basic settings for ESP32-CAM. Then connect the JDY31 Bluetooth module and modify the corresponding port in the for_computer code and other configuration file content. Also, establish a local server and website according to the code in the E-commerce folder.

### Step 2: Connect the car and run Python script

Open the TOMCAT server, log in to the local website, and run Python script to establish a connection with the car.

### Step 3: Debug or run the car

Put the car into the maze for debugging or running.

### Step 4: Check running results

Check the running results on the TOMCAT website and confirm the running results.

## Contributing

Contributions of any kind are welcome!

## License

This project is licensed under Apache-2.0 license.

[English](README.md) | [中文](README.zh.md)
