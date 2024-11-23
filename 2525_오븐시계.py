A,B = map(int,input().split())
C = int(input())

hour = A
minute = B + C
if minute >= 60:
  hour += minute // 60
  minute %= 60
  if hour >= 24:
    hour -= 24

print(f"{hour} {minute}")