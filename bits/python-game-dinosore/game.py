# python play  chrome dinosore
# most of idea come from https://www.youtube.com/watch?v=xYymkeNh2lE

import tkinter as tk
import pyautogui as pg
import PIL as pil
from PIL import ImageGrab
from PIL import ImageOps
from PIL import Image
import numpy as np 
import mss
import cv2
import time
from datetime import datetime

# setup initial data
# old sum of image use for log only new image sum
old_sum = 0
# counting  number of dinosore jump
i = 0
# check duration between time
t = datetime.now()

# un relate to this project, example to show
# transparent window
# plan to make overlay debug but
# it did not happen
def make_window():
    root = tk.Tk()
    root.title("test")
    root.geometry("200x200")
    root.attributes('-alpha', 0.5)
    root.mainloop()

# to go dinosore  location
# munually locate position by
# click on postion and run
# pg.position()
def  goto_dinosore():
    size = pg.size()
    print(f"{size=}")
    pg.moveTo(1170, 352, 0.3)
    pg.click()
    pg.click()

# get  image size 25 by 25
# of obstrucal in front of  dinosore
def get_image(i):
    x, y = 1170, 352
    box = (x, y, x + 50 , y + 50 )

    img = None
    with mss.mss() as sct:
        sct_img = sct.grab(box)
        img = pil.Image.frombytes("RGB", sct_img.size, sct_img.bgra, "raw", "BGRX")
    
    img_arr = np.array(img)
    img_sum = img_arr.sum()

    # log changed sum 
    # sum is use for detect obstrucal
    global old_sum
    if img_sum != old_sum:
        with open("time.log", "a") as f:
            print(i, img_sum, file=f)
        old_sum = img_sum
    return  img, img_sum


# start by go to dinosore()
goto_dinosore()

# loop to find obstrucal and jump
while True:
    img, img_sum = get_image(i)

    # uncomment to see capture images
    # cv2.imshow("img", np.array(img))    
    # if cv2.waitKey(25) & 0xFF == ord("q"):
    #     cv2.destroyAllWindows()
    #     break

    # if detect a lot of white,
    # then jump, number manualy tune by hand
    obstructal_threshold = 275000
    if img_sum > obstructal_threshold:
        t2 = datetime.now()
        print("jump ",i , t2 - t)
        pg.keyDown('space')
        i = i + 1
        t = t2
