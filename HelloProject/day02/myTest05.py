# 랜덤 함수를 호출하여 0.5보다 크면 홀 아니면 짝을 출력하시오 #
from random import random
random = random()
if (random > 0.5):
    print("{}: 홀".format(random))
else:
    print("{}: 짝".format(random))