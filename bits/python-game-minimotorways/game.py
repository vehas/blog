import tkinter as tk
import pyautogui as pg
import PIL as pil
from PIL import ImageGrab, ImageOps, ImageOps, ImageDraw
import numpy as np 
import mss
import cv2
import time
from datetime import datetime

def make_window():
    root = tk.Tk()
    root.title("test")
    root.geometry("640x480+1280+535")
    root.attributes('-alpha', 0.5)
    # root.p
    root.mainloop()

# make_window()

def get_image(i = 0):
    x, y = 1280, 53
    box = (x, y, x + 640 , y + 480 )

    img = None
    with mss.mss() as sct:
        sct_img = sct.grab(box)
        img = pil.Image.frombytes("RGB", sct_img.size, sct_img.bgra, "raw", "BGRX")
    
    img_arr = np.array(img)
    img_draw = pil.ImageDraw.Draw(img)
    sx = 0
    sy = 100
    img_draw.line(((sx, sy), (sx+640, sy)))
    # img.show()
    # print(img_arr[100])
    return img_arr, img

def show_grid():
    pg.moveTo(x=1290, y=200, duration=0.5)
    pg.click()
    pg.dragTo(x=1290, y=200, duration=1, button="left")

def prepare_image():
    show_grid()
    return get_image()

