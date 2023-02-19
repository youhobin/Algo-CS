### SUM, MAX, MIN

---

#### 1. 가장 비싼 상품 구하기

MAX 사용ㅇ해도 되지만, 가격을 내림차순 정렬하고 1개 가져와도 됨.
```
SELECT MAX(PRICE)
FROM PRODUCT
```

```
SELECT PRICE as 'MAX_PRICE' FROM PRODUCT
ORDER BY PRICE desc limit 1
```

---

#### 식품분류별 가장 비싼 식품의 정보 조회하기

```
SELECT CATEGORY, PRICE as max_price, PRODUCT_NAME FROM FOOD_PRODUCT
where CATEGORY in ('과자', '국', '김치', '식용유') 
and price in (select max(price) from food_product group by category)
group by category
having max(price)
order by price desc
```
