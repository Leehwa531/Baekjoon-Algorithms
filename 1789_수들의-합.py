def disit_count(S):
  i = 1
  count = 0
  while S != 0:
    if S < i*2+1:
      i = S
      S -= i
      count+=1
    else:
      S -= i
      count +=1
      i +=1
  return count


S = int(input())

print(disit_count(S))