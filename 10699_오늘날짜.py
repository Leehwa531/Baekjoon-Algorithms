from datetime import datetime, timezone

# 현재 UTC+0 날짜 가져오기
utc_today = datetime.now(timezone.utc).date()

# 출력
print(utc_today)