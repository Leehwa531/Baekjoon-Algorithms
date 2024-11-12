
def is_acceptable(password):
  vowels = {'a','e','i','o','u'}

  # 조건 1 : 모음 하나 이상 포함
  has_vowel = any(char in vowels for char in password)
  if not has_vowel:
    return False
  
  # 조건 2 : 모음 또는 자음이 3번 연속으로 오면 안 된다.
  vowel_count, consonant_count = 0,0
  for char in password:
    if char in vowels:
      vowel_count += 1
      consonant_count = 0
    else:
      consonant_count += 1
      vowel_count = 0
    if vowel_count == 3 or consonant_count == 3:
      return False
  
  # 조건 3 : 같은 글자가 연속 2번 x, 단 e,o는 허용
  for i in range(1, len(password)):
    if password[i] == password[i - 1] and password[i] not in ('e', 'o'):
      return False
    
  return True

while True:
  password = input().strip()
  if password == 'end':
    break
  if is_acceptable(password):
    print(f"<{password}> is acceptable.")
  else:
    print(f"<{password} is not acceptable")