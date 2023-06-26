#가위바위보..발
from random import random
me = input("가위바위보 중 하나를 입력하세요: ")
random = random()
com = ""
if (random > 0):
    com = "가위"
elif (random > 0.33):
    com = "바위"
else:
    com = "보"
    
result = ""
if (me == com):
    print("무승부")
elif ((me == "가위" and com == "바위") or
      (me == "바위" and com == "보") or
      (me == "보" and com == "가위")):     
    print("컴 승리")
elif ((me == "가위" and com == "보") or
      (me == "바위" and com == "가위") or
      (me == "보" and com == "바위")): 
    print("나 승리")
    