#벌집모양 집에서 몇개의 방을 통화해야 그 집에 도달하는지에 대한 알고리즘

num = int(input())
if num == 1:
  print(1)
else:
  level = 1
  count = 1
  while num > count:
    count += 6 * level
    level += 1
  print(level)
