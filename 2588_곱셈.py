# [세자리 수 * 세자리 수]의 각 자리 수 곱셈 과정과 결과를 출력하는 알고리즘
num1 = int(input())
num2 = int(input())

N100=int(num2/100)
N10=int(num2%100/10)
N1=int(num2%10)

print(num1*N1)
print(num1*N10)
print(num1*N100)
print(num1*num2)