# 1~9 중 중복없이 섞어서 세개의 수를 출력 #
from random import random, shuffle
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
# shuffle(arr)
# for i in range(0, 3):
#     print(arr[i])
for i in range(99):
    r = int(random() * 9)
    a = arr[0]
    arr[0] = arr[r]
    arr[r] = a
print(arr) 