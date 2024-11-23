def 소인수분해(N):
  i = 2
  while N != 1:
    if N % i == 0:
      N = N / i
      print(i)
    else:
      i+=1


N = int(input())
소인수분해(N)
