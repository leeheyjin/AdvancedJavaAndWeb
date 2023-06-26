#출력할 구구단을 입력하세요
num = input("출력할 구구단을 입력하세요: ")
result = 0;
for i in range(1, 10):
    print("{} * {} = {}".format(num, i, int(num) * i))
    