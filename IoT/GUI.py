import tkinter as tk
from PIL import Image, ImageTk
import os

from ultralytics import YOLO

# 假设图片所在的文件夹路径
image_folder = "E:/testImage"
image_paths = []
model = YOLO("D:/bestbest.pt")

# 获取图片文件夹中的所有图片路径
for filename in os.listdir(image_folder):
    if filename.endswith(".jpg") or filename.endswith(".png"):
        image_paths.append(os.path.join(image_folder, filename))

current_index = 0


# 导入YOLO库和相关函数
# 这里假设你已经有一个能够使用YOLO处理图像的函数，如yolo_process_image(image)

class GUI:
    def __init__(self, root):
        self.root = root
        self.root.title("YOLO图像处理")

        # 创建左侧图片显示区域
        self.original_frame = tk.Frame(self.root, width=400, height=400)
        self.original_frame.pack(side=tk.LEFT, padx=10, pady=10)
        self.original_label = tk.Label(self.original_frame)
        self.original_label.pack()

        # 创建右侧YOLO处理后的图像显示区域
        self.yolo_frame = tk.Frame(self.root, width=400, height=400)
        self.yolo_frame.pack(side=tk.LEFT, padx=10, pady=10)
        self.yolo_label = tk.Label(self.yolo_frame)
        self.yolo_label.pack()

        # 创建按钮区域
        self.button_frame = tk.Frame(self.root)
        self.button_frame.pack(side=tk.BOTTOM, pady=10)

        # 添加按钮用于切换图片
        self.prev_button = tk.Button(self.button_frame, text="上一张", command=self.show_previous_image)
        self.prev_button.pack(side=tk.LEFT, padx=5)
        self.next_button = tk.Button(self.button_frame, text="下一张", command=self.show_next_image)
        self.next_button.pack(side=tk.LEFT, padx=5)

        # 加载第一张图片
        self.load_image()

    def load_image(self):
        # 获取当前索引对应的图片路径
        image_path = image_paths[current_index]

        # 打开原始图像文件
        self.original_image = Image.open(image_path)

        # 调整图像大小以适应显示区域
        self.original_image = self.original_image.resize((400, 400), Image.LANCZOS)

        # 创建图像对象并显示在左侧标签中
        self.original_photo = ImageTk.PhotoImage(self.original_image)
        self.original_label.config(image=self.original_photo)

        # 对原始图像进行YOLO处理
        result = model.predict(image_path, conf=0.5, save=True)[0]

        name = result.path.split("\\")
        name = name[len(name) - 1]
        predict_dir = result.save_dir + "\\" + name

        self.processed_image = Image.open(predict_dir)
        #
        # 调整图像大小以适应显示区域
        self.processed_image = self.processed_image.resize((400, 400), Image.LANCZOS)

        # 创建图像对象并显示在右侧标签中
        self.processed_photo = ImageTk.PhotoImage(self.processed_image)
        self.yolo_label.config(image=self.processed_photo)

    def show_previous_image(self):
        global current_index
        if current_index > 0:
            current_index -= 1
            self.load_image()

    def show_next_image(self):
        global current_index
        if current_index < len(image_paths) - 1:
            current_index += 1
            self.load_image()


# 创建主窗口
root = tk.Tk()

# 创建GUI实例
gui = GUI(root)

# 运行主循环
root.mainloop()
