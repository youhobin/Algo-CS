### Select

---

#### 1. 평균 일일 대여 요금 구하기

round 반올림, as로 컬럼 이름 변경. 
```
SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE
From CAR_RENTAL_COMPANY_CAR 
WHERE CAR_TYPE = "SUV"
```

---

#### 2. 3월에 태어난 여성 회원 목록 출력하기

date_format은 (날짜, 형식). like는 부분일치 검색. %는 모든글자. -는 한글자 
```
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH,'%Y-%m-%d') as DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE DATE_OF_BIRTH LIKE '%-03-%' AND GENDER = 'W'  AND TLNO IS NOT NULL 
ORDER BY MEMBER_ID;
```
