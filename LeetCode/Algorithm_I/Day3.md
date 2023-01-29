### Day 3

---

#### 283. Move Zeroes `java`

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int pointer = 0;
        //0이 아닌 값을 앞으로 이동
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pointer++] = nums[i];
            }
        }
        // pointer 인덱스부터 0으로 교환
        while(pointer < nums.length) {
            nums[pointer++] = 0;
        }
    }
}
```

---

#### 167. Two Sum II - Input Array Is Sorted 

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
    // 정렬된 배열이기 때문에 배열의 맨 앞과 뒤의 값을 더해 target과 비교한다.
        int firstIndex = 0;
        int secondIndex = numbers.length - 1;
        while(numbers[firstIndex] + numbers[secondIndex] != target) {
            if (numbers[firstIndex] + numbers[secondIndex] > target) {
                secondIndex--;
            } else{
                firstIndex++;
            }
        }
        return new int[]{firstIndex + 1, secondIndex + 1};
    }
}
```
