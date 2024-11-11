#삼각형의 조건을 만족하는지, 만족하면 어떤 삼각형인지 출력하는 알고리즘


while True:
  lines = list(map(int,input().split()))
  a,b,c = sorted(lines)

  if a ==0 and b==0 and c==0:
    break

  if a+b>c:
    if a==b==c:
      print("Equilateral")
    elif a==b or b==c or a==c:
      print("Isosceles")
    else:
      print("Scalene")
  else:
    print("Invalid")

