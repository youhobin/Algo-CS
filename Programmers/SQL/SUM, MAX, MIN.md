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
