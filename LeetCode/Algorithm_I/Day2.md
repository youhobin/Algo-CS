### Day 2

---

#### 977. Squares of a Sorted Array `java`

- my solution (not use two pointer)
```java
class Solution {
    public int[] sortedSquares(int[] nums) {
        return Arrays.stream(nums)
                .map(num -> num * num)
                .sorted()
                .toArray();
    }
}
```

- use two pointer
```java
class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
```

---

#### 189. Rotate Array
```java
class Solution {
	public void rotate(int[] nums, int k) {
        //k가 nums의 길이와 같으면 그대로이므로
        k %= nums.length;
        
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
```
