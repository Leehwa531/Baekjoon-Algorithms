#주어진 단어의 알파벳 개수를 대소문자 구분해서 출력

from collections import Counter

# 입력받기
word = input().strip().lower()

# 빈도 세기
count = Counter(word)

#가장 많이 사용된 알파벳 빈도수 찾기
max_count = max(count.values())

#가장 많이 사용된 알파벳이 여러 개 있는지 확인
most_common = [key for key, value in count.items() if value == max_count]

if len(most_common) > 1:
  print("?")
else:
  print(most_common[0].upper())