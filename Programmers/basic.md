### 퀵정렬

```java
private static void quickSort(int[] a, int left, int right) {
    int pl = left;
    int pr = right;
    int m = sort3(a, pl, (pl + pr) / 2, pr); //pl, 중간값, pr 3개 정렬해서 가운데값 주기
    int x = a[m];	//피벗
    
    swap(a, m, right-1);
    pl++;
    pr -= 2;
    
    do{
    	while (a[pl] < x) pl++;
	while (a[pr] > x) pr--;
	if (pl <= pr) swap(a, pl++, pr--);
    } while(pl<=pr);
    
    if (left < pr) quickSort(a, left, pr);
    if (pl < right) quickSort(a, pl, right);
    
  }
```
