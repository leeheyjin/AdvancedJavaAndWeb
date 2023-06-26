# 로또만들기
from random import random
arr = list(range(1, 45+1))
for i in range(1000):
    r = int(random() * 9)
    a = arr[0]
    arr[0] = arr[r]
    arr[r] = a
print(arr[0:6])