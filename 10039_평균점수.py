score_list = [0]*5
sum = 0
for i in range(5):
  score_list[i] = int(input())
  if score_list[i] < 40:
    score_list[i] = 40
  sum += score_list[i]

print(sum//5)
