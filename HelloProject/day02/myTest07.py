# 홀짝을 선택하세요
from random import random
random = random()
myChoice = input("홀/짝을 선택하세요: ")
comChoice = ""
if(random > 0.5):
    comChoice = "홀"
else:
    comChoice = "짝"
    
if(myChoice == comChoice):
    print("승리")
else:
    print("패배")