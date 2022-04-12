# LeetCode Exercise Records
## Categories
> __Algorithms__
* [Backtracking](#backtracking)
* [Binary Search](#binary-search)
* [Bit Manipulation](#bit-manipulation)
* [Breadth First Search](#breadth-first-search)
* [Depth First Search](#depth-first-search)
* [Dynamic Programming](#dynamic-programming)
* [Sliding Window](#sliding-window)
* [Two Pointers](#two-pointers)


> __Data Structures__
* [Arrays](#arrays)
* [Binary Tree](#binary-tree)
* [Hash Map](#hash-map)
* [Linked List](#linked-list)
* [Segment Tree](#segment-tree)
* [Set](#set)
* [String](#string)


## Summary
| ID  |                                       Problem                                        | Difficulty | Beat (Time) |        Note         |
|:---:|:------------------------------------------------------------------------------------:|:----------:|:-----------:|:-------------------:|
|  1  |                              [Two Sum](src/TwoSum.java)                              |    Easy    |   99.38%    |       HashMap       |
|  3  | [Longest Substring Without Repeating Characters](src/LengthOfLongestSubstring.java)  |   Medium   |    100%     |     Set? + 滑动窗口     |
| 19  |            [Remove Nth Node From End of List](src/RemoveNthFromEnd.java)             |   Medium   |    100%     |     Stack, 双指针      |
| 21  |                [Merge Two Sorted Lists](src/MergeTwoSortedLists.java)                |    Easy    |    100%     |      Recursion      |
| 35  |               [Search Insert Position](src/SearchInsertPosition.java)                |    Easy    |    100%     |         BS          |
| 46  |                        [Permutations](src/Permutations.java)                         |   Medium   |    100%     |         回溯          |
| 53  |                       [Maximum Subarray](src/MaxSubarray.java)                       |    Easy    |    100%     |     贪心, DP, 线段树     |
| 69  |                               [Sqrt(x)](src/Sqrt.java)                               |    Easy    |    100%     |   Math, 牛顿迭代, BS    |
| 70  |                      [Climbing Stairs](src/ClimbingStairs.java)                      |    Easy    |    100%     |   DP, Math, Memo    |
| 77  |                        [Combinations](src/Combinations.java)                         |   Medium   |   99.99%    |       回溯, 字典序       |
| 88  |                   [Merge Sorted Array](src/MergeSortedArray.java)                    |    Easy    |    100%     |         双指针         |
| 116 |     [Populating Next Right Pointers in Each Node](src/PopNextRightPointers.java)     |   Medium   |    100%     |        层序遍历         |
| 121 |           [Best Time to Buy and Sell Stock](src/BestTimeBuySellStock.java)           |    Easy    |    100%     |         DP          |
| 167 |               [Two Sum II - Input Array is Sorted](src/TwoSumII.java)                |   Medium   |    100%     |       BS, 双指针       |
| 189 |                         [Rotate Array](src/RotateArray.java)                         |   Medium   |    100%     |    Math, Reverse    |
| 206 |                  [Reverse Linked List](src/ReverseLinkedList.java)                   |    Easy    |    100%     |      Recursion      |
| 217 |                   [Contains Duplicate](src/ContainsDuplicate.java)                   |    Easy    |   99.08%    |         Set         |
| 278 |                    [First Bad Version](src/FirstBadVersion.java)                     |    Easy    |   99.95%    |         BS          |
| 283 |                           [Move Zeros](src/MoveZeros.java)                           |    Easy    |    100%     |        双指针?         |
| 344 |                       [Reverse String](src/ReverseString.java)                       |    Easy    |    100%     |         双指针         |
| 349 |              [Intersection of Two Arrays](src/IntersectTwoArrays.java)               |    Easy    |   93.84%    |   Set, Sort + 双指针   |
| 350 |            [Intersection of Two Arrays II](src/IntersectTwoArraysII.java)            |    Easy    |   89.79%    | HashMap, Sort + 双指针 |
| 367 |                 [Valid Perfect Square](src/ValidPerfectSquare.java)                  |    Easy    |    100%     |        类似 69        |
| 374 |                  [Guess Number Higher or Lower](src/GuessNum.java)                   |    Easy    |    100%     |         BS          |
| 441 |                       [Arranging Coins](src/ArrangeCoins.java)                       |    Easy    |   97.93%    |      Math, BS       |
| 542 |                         [01 Matrix](src/ZeroOneMatrix.java)                          |   Medium   |   98.95%    |       DP, BFS       |
| 557 |          [Reverse Words in a String III](src/ReverseWordsInStringIII.java)           |    Easy    |    100%     |         双指针         |
| 567 |                [Permutation in String](src/PermutationInString.java)                 |   Medium   |    100%     |      滑动窗口, 双指针      |
| 617 |                [Merge Two Binary Trees](src/MergeTwoBinaryTrees.java)                |    Easy    |    100%     |      DFS, BFS       |
| 695 |                    [Max Area of Island](src/MaxAreaOfIsland.java)                    |   Medium   |    100%     |      DFS, BFS       |
| 704 |                        [Binary Search](src/BinarySearch.java)                        |    Easy    |    100%     |         BS          |
| 733 |                           [Flood Fill](src/FloodFill.java)                           |    Easy    |    100%     |      DFS, BFS       |
| 744 | [Find Smallest Letter Greater Than Target](src/SmallestLetterGreaterThanTarget.java) |    Easy    |    100%     |         BS          |
| 784 |              [Letter Case Permutation](src/LetterCasePermutation.java)               |   Medium   |    100%     |       回溯, Bit       |
| 876 |                 [Middle of the Linked List](src/MiddleLinkList.java)                 |    Easy    |    100%     |         双指针         |
| 977 |               [Squares of a Sorted Array](src/SquaresSortedArray.java)               |    Easy    |    100%     |         双指针         |
| 994 |                      [Rotting Oranges](src/RottingOranges.java)                      |   Medium   |    100%     |         BFS         |
##### Total: 37


## Arrays
| ID  |                              Problem                              | Difficulty | Beat (Time) |        Note         |
|:---:|:-----------------------------------------------------------------:|:----------:|:-----------:|:-------------------:|
|  1  |                    [Two Sum](src/TwoSum.java)                     |    Easy    |   99.38%    |       HashMap       |
| 46  |               [Permutations](src/Permutations.java)               |   Medium   |    100%     |         回溯          |
| 53  |             [Maximum Subarray](src/MaxSubarray.java)              |    Easy    |    100%     |     贪心, DP, 线段树     |
| 77  |               [Combinations](src/Combinations.java)               |   Medium   |   99.99%    |       回溯, 字典序       |
| 88  |          [Merge Sorted Array](src/MergeSortedArray.java)          |    Easy    |    100%     |         双指针         |
| 121 | [Best Time to Buy and Sell Stock](src/BestTimeBuySellStock.java)  |    Easy    |    100%     |         DP          |
| 167 |      [Two Sum II - Input Array is Sorted](src/TwoSumII.java)      |   Medium   |    100%     |       BS, 双指针       |
| 189 |               [Rotate Array](src/RotateArray.java)                |   Medium   |    100%     |    Math, Reverse    |
| 283 |                 [Move Zeros](src/MoveZeros.java)                  |    Easy    |    100%     |        双指针?         |
| 344 |             [Reverse String](src/ReverseString.java)              |    Easy    |    100%     |         双指针         |
| 349 |     [Intersection of Two Arrays](src/IntersectTwoArrays.java)     |    Easy    |   93.84%    |   Set, Sort + 双指针   |
| 350 |  [Intersection of Two Arrays II](src/IntersectTwoArraysII.java)   |    Easy    |   89.79%    | HashMap, Sort + 双指针 |
| 557 | [Reverse Words in a String III](src/ReverseWordsInStringIII.java) |    Easy    |    100%     |         双指针         |
| 977 |     [Squares of a Sorted Array](src/SquaresSortedArray.java)      |    Easy    |    100%     |         双指针         |


## Backtracking
| ID  |                          Problem                          | Difficulty | Beat (Time) |  Note   |
|:---:|:---------------------------------------------------------:|:----------:|:-----------:|:-------:|
| 46  |           [Permutations](src/Permutations.java)           |   Medium   |    100%     |   回溯    |
| 77  |           [Combinations](src/Combinations.java)           |   Medium   |   99.99%    | 回溯, 字典序 |
| 784 | [Letter Case Permutation](src/LetterCasePermutation.java) |   Medium   |    100%     | 回溯, Bit |


## Binary Search
| ID  |                                       Problem                                        | Difficulty | Beat (Time) |      Note      |
|:---:|:------------------------------------------------------------------------------------:|:----------:|:-----------:|:--------------:|
| 35  |               [Search Insert Position](src/SearchInsertPosition.java)                |    Easy    |    100%     |       BS       |
| 69  |                               [Sqrt(x)](src/Sqrt.java)                               |    Easy    |    100%     | Math, 牛顿迭代, BS |
| 167 |               [Two Sum II - Input Array is Sorted](src/TwoSumII.java)                |   Medium   |    100%     |    BS, 双指针     |
| 217 |                   [Contains Duplicate](src/ContainsDuplicate.java)                   |    Easy    |   99.08%    |      Set       |
| 278 |                    [First Bad Version](src/FirstBadVersion.java)                     |    Easy    |   99.95%    |       BS       |
| 367 |                 [Valid Perfect Square](src/ValidPerfectSquare.java)                  |    Easy    |    100%     |     类似 69      |
| 374 |                  [Guess Number Higher or Lower](src/GuessNum.java)                   |    Easy    |    100%     |       BS       |
| 441 |                       [Arranging Coins](src/ArrangeCoins.java)                       |    Easy    |   97.93%    |    Math, BS    |
| 704 |                        [Binary Search](src/BinarySearch.java)                        |    Easy    |    100%     |       BS       |
| 744 | [Find Smallest Letter Greater Than Target](src/SmallestLetterGreaterThanTarget.java) |    Easy    |    100%     |       BS       |


## Binary Tree
| ID  |                                   Problem                                    | Difficulty | Beat (Time) |   Note   |
|:---:|:----------------------------------------------------------------------------:|:----------:|:-----------:|:--------:|
| 116 | [Populating Next Right Pointers in Each Node](src/PopNextRightPointers.java) |   Medium   |    100%     |   层序遍历   |
| 617 |            [Merge Two Binary Trees](src/MergeTwoBinaryTrees.java)            |    Easy    |    100%     | DFS, BFS |


## Bit Manipulation
| ID  |                          Problem                          | Difficulty | Beat (Time) |  Note   |
|:---:|:---------------------------------------------------------:|:----------:|:-----------:|:-------:|
| 784 | [Letter Case Permutation](src/LetterCasePermutation.java) |   Medium   |    100%     | 回溯, Bit |


## Breadth First Search
| ID  |                  Problem                   | Difficulty | Beat (Time) |  Note   |
|:---:|:------------------------------------------:|:----------:|:-----------:|:-------:|
| 542 |    [01 Matrix](src/ZeroOneMatrix.java)     |   Medium   |   98.95%    | DP, BFS |
| 994 | [Rotting Oranges](src/RottingOranges.java) |   Medium   |    100%     |   BFS   |


## Depth First Search
| ID  |                        Problem                         | Difficulty | Beat (Time) |   Note   |
|:---:|:------------------------------------------------------:|:----------:|:-----------:|:--------:|
| 733 |            [Flood Fill](src/FloodFill.java)            |    Easy    |    100%     | DFS, BFS |
| 617 | [Merge Two Binary Trees](src/MergeTwoBinaryTrees.java) |    Easy    |    100%     | DFS, BFS |
| 695 |     [Max Area of Island](src/MaxAreaOfIsland.java)     |   Medium   |    100%     | DFS, BFS |


## Dynamic Programming
| ID  |                             Problem                              | Difficulty | Beat (Time) |      Note      |
|:---:|:----------------------------------------------------------------:|:----------:|:-----------:|:--------------:|
| 53  |             [Maximum Subarray](src/MaxSubarray.java)             |    Easy    |    100%     |  贪心, DP, 线段树   |
| 70  |            [Climbing Stairs](src/ClimbingStairs.java)            |    Easy    |    100%     | DP, Math, Memo |
| 121 | [Best Time to Buy and Sell Stock](src/BestTimeBuySellStock.java) |    Easy    |    100%     |       DP       |
| 542 |               [01 Matrix](src/ZeroOneMatrix.java)                |   Medium   |   98.95%    |    DP, BFS     |


## Hash Map
| ID  |                            Problem                             | Difficulty | Beat (Time) |        Note         |
|:---:|:--------------------------------------------------------------:|:----------:|:-----------:|:-------------------:|
|  1  |                   [Two Sum](src/TwoSum.java)                   |    Easy    |   99.38%    |       HashMap       |
| 350 | [Intersection of Two Arrays II](src/IntersectTwoArraysII.java) |    Easy    |   89.79%    | HashMap, Sort + 双指针 |


## Linked List
| ID  |                            Problem                            | Difficulty | Beat (Time) |    Note    |
|:---:|:-------------------------------------------------------------:|:----------:|:-----------:|:----------:|
| 19  | [Remove Nth Node From End of List](src/RemoveNthFromEnd.java) |   Medium   |    100%     | Stack, 双指针 |
| 21  |    [Merge Two Sorted Lists](src/MergeTwoSortedLists.java)     |    Easy    |    100%     | Recursion  |
| 206 |       [Reverse Linked List](src/ReverseLinkedList.java)       |    Easy    |    100%     | Recursion  |
| 876 |     [Middle of the Linked List](src/MiddleLinkList.java)      |    Easy    |    100%     |    双指针     |


## Segment Tree
| ID  |                 Problem                  | Difficulty | Beat (Time) |    Note     |
|:---:|:----------------------------------------:|:----------:|:-----------:|:-----------:|
| 53  | [Maximum Subarray](src/MaxSubarray.java) |    Easy    |    100%     | 贪心, DP, 线段树 |


## Set
| ID  |                          Problem                          | Difficulty | Beat (Time) |      Note       |
|:---:|:---------------------------------------------------------:|:----------:|:-----------:|:---------------:|
| 217 |     [Contains Duplicate](src/ContainsDuplicate.java)      |    Easy    |   99.08%    |       Set       |
| 349 | [Intersection of Two Arrays](src/IntersectTwoArrays.java) |    Easy    |   93.84%    | Set, Sort + 双指针 |


## Sliding Window
| ID  |                                       Problem                                       | Difficulty | Beat (Time) |    Note     |
|:---:|:-----------------------------------------------------------------------------------:|:----------:|:-----------:|:-----------:|
|  3  | [Longest Substring Without Repeating Characters](src/LengthOfLongestSubstring.java) |   Medium   |    100%     | Set? + 滑动窗口 |
| 567 |                [Permutation in String](src/PermutationInString.java)                |   Medium   |    100%     |  滑动窗口，双指针   |


## String
| ID  |                          Problem                          | Difficulty | Beat (Time) |  Note   |
|:---:|:---------------------------------------------------------:|:----------:|:-----------:|:-------:|
| 46  |           [Permutations](src/Permutations.java)           |   Medium   |    100%     |   回溯    |
| 784 | [Letter Case Permutation](src/LetterCasePermutation.java) |   Medium   |    100%     | 回溯, Bit |


## Two Pointers
| ID  |                              Problem                              | Difficulty | Beat (Time) |        Note         |
|:---:|:-----------------------------------------------------------------:|:----------:|:-----------:|:-------------------:|
| 19  |   [Remove Nth Node From End of List](src/RemoveNthFromEnd.java)   |   Medium   |    100%     |     Stack, 双指针      |
| 88  |          [Merge Sorted Array](src/MergeSortedArray.java)          |    Easy    |    100%     |         双指针         |
| 167 |      [Two Sum II - Input Array is Sorted](src/TwoSumII.java)      |   Medium   |    100%     |       BS, 双指针       |
| 283 |                 [Move Zeros](src/MoveZeros.java)                  |    Easy    |    100%     |        双指针?         |
| 344 |             [Reverse String](src/ReverseString.java)              |    Easy    |    100%     |         双指针         |
| 349 |     [Intersection of Two Arrays](src/IntersectTwoArrays.java)     |    Easy    |   93.84%    |   Set, Sort + 双指针   |
| 350 |  [Intersection of Two Arrays II](src/IntersectTwoArraysII.java)   |    Easy    |   89.79%    | HashMap, Sort + 双指针 |
| 557 | [Reverse Words in a String III](src/ReverseWordsInStringIII.java) |    Easy    |    100%     |         双指针         |
| 876 |       [Middle of the Linked List](src/MiddleLinkList.java)        |    Easy    |    100%     |         双指针         |
| 977 |     [Squares of a Sorted Array](src/SquaresSortedArray.java)      |    Easy    |    100%     |         双指针         |

