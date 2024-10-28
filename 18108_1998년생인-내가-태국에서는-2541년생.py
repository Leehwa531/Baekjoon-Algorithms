# 불기 연도를 서기 연도로 바꿔주는 알고리즘
buddhist_year = int(input())
gregorian_year = buddhist_year - 543 # 불기에서 543을 빼면 서기 연도
print(gregorian_year)