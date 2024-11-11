#돌 N개가 주어질 때 두사람이 1 or 3개의 돌을 가져갈 수 있을 때 최선의 수를 두면 이기는 사람은?

total_stone= int(input())

if total_stone%2==1:
  print("SK")
else:
  print("CY")