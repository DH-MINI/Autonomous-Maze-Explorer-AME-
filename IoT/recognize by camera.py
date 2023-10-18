import cv2
from ultralytics import YOLO
from pathlib import Path

if __name__ == '__main__':
    # 加载模型

    # path = "D:/DB/best.pt"
    path = "best.pt"
    model = YOLO(path)  # 加载预训练模型（建议用于训练）



    # 使用模型
    # model.train(data='test.yaml', epochs=3)  # 训练模型
    # metrics = model.val()  # 在验证集上评估模型性能
    # results = model("https://ultralytics.com/images/bus.jpg")  # 对图像进行预测
    # results = model.predict('https://ultralytics.com/images/bus.jpg', save=True,conf=0.5) # device=0 by default, conf:置信度阈值
    # success = model.export(format="onnx")

    cap = cv2.VideoCapture(0)

    # Loop through the video frames
    while cap.isOpened():
        # Read a frame from the video
        success, frame = cap.read()

        if success:
            # Run YOLOv8 inference on the frame
            results = model(frame)

            # Visualize the results on the frame
            annotated_frame = results[0].plot()

            # Display the annotated frame
            cv2.imshow("YOLOv8 Inference", annotated_frame)

            # Break the loop if 'q' is pressed
            if cv2.waitKey(1) & 0xFF == ord("q"):
                break
        else:
            # Break the loop if the end of the video is reached
            break

    # Release the video capture object and close the display window
    cap.release()
    cv2.destroyAllWindows()