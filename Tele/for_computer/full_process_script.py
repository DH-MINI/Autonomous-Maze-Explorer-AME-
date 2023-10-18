# Import required modules
import serial  # For serial communication
import time  # For time-related functions
import cv2  # For image processing
import os  # For handling files and directories
import re  # For regular expressions
from pathlib import Path  # For handling file paths
from ultralytics import YOLO  # For YOLO model
from collections import Counter  # For counting elements in a list
import configparser  # For reading from a configuration file
import turtle  # For turtle graphics

# Read constants and variables from the configuration file
config = configparser.ConfigParser()
config.read("config.ini")
SERIAL_PORT = config.get("serial", "port")  # Serial port number
SERIAL_BAUDRATE = config.getint("serial", "baudrate")  # Baud rate
MODEL_PATH = config.get("model", "path")  # Model path
CAMERA_URL = config.get("camera", "url")  # Network camera address
IMAGE_PREFIX = config.get("image", "prefix")  # Image filename prefix
IMAGE_SUFFIX = config.get("image", "suffix")  # Image filename suffix
IMAGE_COUNT = config.getint("image", "count")  # Number of image recognitions

# Create a turtle object
t = turtle.Turtle()

# Set the speed and color of the turtle
t.speed(5)
t.color("blue")

print("Serial port: {}".format(SERIAL_PORT))
print("Baud rate: {}".format(SERIAL_BAUDRATE))
print("Camera: {}".format(CAMERA_URL))
print("Model path: {}".format(MODEL_PATH))
print("Number of image recognitions: {}".format(IMAGE_COUNT))
print("Image filename prefix: {}".format(IMAGE_PREFIX))
print("Image filename suffix: {}".format(IMAGE_SUFFIX))

if t:
    print("Turtle created successfully")

# Define a function to control the movement and drawing of the turtle based on a list of commands
def draw(commands):
    for command in commands:
        if command == "forward":
            t.forward(50)
        elif command == "back":
            t.backward(50)
        elif command == "right":
            t.right(15)
        elif command == "left":
            t.left(15)
        elif command == "stop":
            t.penup()
        else:
            pass

def main():
    try:
        ser = serial.Serial(SERIAL_PORT, SERIAL_BAUDRATE)  # Open the serial port
        current_time = time.strftime("%Y%m%d%H%M%S", time.localtime())  # Get the current time
        rfilename = "{}.txt".format(current_time)  # Concatenate the filename

        model = YOLO(MODEL_PATH)  # Load the model
        cap = cv2.VideoCapture(CAMERA_URL)  # Create a video capture object

        start_time = None  # Start time
        end_time = None  # End time
        results = []  # List of recognition results
        output = ""  # Output string

        folder_name = "imgs_" + format(current_time)  # Define the folder name
        os.mkdir(folder_name)  # Create the folder

        commands = []  # Define an empty list of commands

        pattern_start = re.compile(r"Start")
        pattern_end = re.compile(r"End")
        pattern_find = re.compile(r"Find")
        pattern_command = re.compile(r"(Forward|Back|Right|Left|Stop)")

        while True:
            if (n := ser.inWaiting()) > 0:
                data = ser.read(n).decode()

                match_command = pattern_command.search(data)
                if match_command:
                    command = match_command.group()
                    commands.append(command)
                    with open("Commonds.txt", "a") as f:
                        f.write(command + "\n")
                    print("Command added: " + command + "\n")

                match_start = pattern_start.search(data)
                if match_start and start_time is None:
                    start_time = int(time.strftime("%Y%m%d%H%M%S", time.localtime()))
                    print("Start time: " + str(start_time))

                match_find = pattern_find.search(data)
                if match_find:
                    print("Find done\n")
                    time.sleep(10)
                    for i, _ in enumerate(range(3)):
                        ret, frame = cap.read()
                        filename = "{}/{}{}.{}".format(folder_name, IMAGE_PREFIX, i, IMAGE_SUFFIX)
                        cv2.imwrite(filename, frame)
                        print(filename + " saved\n")
                        time.sleep(5)

                match_end = pattern_end.search(data)
                if match_end and end_time is None and start_time is not None:
                    end_time = int(time.strftime("%Y%m%d%H%M%S", time.localtime()))
                    print("End time: " + str(end_time))
                    commands.append(command)
                    with open("Commonds.txt", "a") as f:
                        f.write(command + "\n")
                    print("Command added: " + command + "\n")

                if start_time and end_time:
                    result = model.predict(folder_name, save=True, save_txt=True, classes=[0,1,2], conf=0.2)

                    output += "Start time: " + str(start_time) + "\n"
                    output += "End time: " + str(end_time) + "\n"
                    output += "Recognition results:\n"
                    for cls in [0,1,2]:
                        count = result.count(cls)
                        output += "Number of class " + str(cls) + ": " + str(count) + "\n"

                    draw(commands)
                    turtle.getscreen().getcanvas().postscript(file="turtle.jpg")

                    print(output)

    except Exception as e:
        print(e)

if __name__ == "__main__":
    main()
