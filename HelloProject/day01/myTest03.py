# 당신이 좋아하는 수를 입력하세요 -> 5 #
favNo = input("좋아하는 수를 입력하세요: ")
# 당신이 좋아하는 수 5는 홀수 입니다. #
if int(favNo) % 2 == 0: 
    print("당신이 좋아하는 수 ",favNo,"은(는) 짝수입니다.")
    
else:
    print("당신이 좋아하는 수 ",favNo,"은(는) 홀수입니다.")