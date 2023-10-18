# Autonomous-Maze-Explorer-AME-

AME is an Arduino-based robot that navigates a 3x3 maze, identifies treasures using a YOLOv8-trained model, and communicates findings to a Tomcat-based website for real-time updates.

## Tree
```
.
├── E-commerce
│   ├── build
│   │   └── classes
│   └── src
│       └── main
├── IoT
│   ├── GUI.py
│   ├── best.pt
│   ├── recognize by camera.py
│   ├── recognize.py
│   └── requirements.txt
├── LICENSE
├── Meeting_records
│   └── 会议记录MeetingRecord_20230928195542.pdf
├── README.md
├── README.zh.md
└── Tele
    ├── for_computer
    │   ├── config.ini
    │   ├── full_process_script.py
    │   └── requirements.txt
    ├── for_esp32-cam
    │   ├── esp32-cam_arduino
    │   └── esp32-cam_arduino.ino
    └── for_mega2560
        └── mega2560_arduino.ino
```

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

![1](https://github.com/DH-MINI/Autonomous-Maze-Explorer-AME-/assets/92455708/f48e4d23-c6ea-4d82-a47e-fa535ada8c14)
<img width="818" alt="flow_chart" src="https://github.com/DH-MINI/Autonomous-Maze-Explorer-AME-/assets/92455708/ae3cbed5-1b05-4a41-879e-b9aeb6ca1ac4">

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
