# LeetCode Exercise Records
## Categories
> Algorithms
* [Binary Search](#binary-search)
* [Sliding Window](#sliding-window)
* [Two Pointers](#two-pointers)


> Data Structures
* [Arrays](#arrays)
* [Hash Map](#hash-map)
* [Linked List](#linked-list)
* [Set](#set)


## Summary
| Number |                                       Problem                                        | Difficulty | Beat (Time) |        Note         |
|:------:|:------------------------------------------------------------------------------------:|:----------:|:-----------:|:-------------------:|
|   3    | [Longest Substring Without Repeating Characters](src/LengthOfLongestSubstring.java)  |   Medium   |    100%     |     Set? + 滑动窗口     |
|   19   |            [Remove Nth Node From End of List](src/RemoveNthFromEnd.java)             |   Medium   |    100%     |     Stack, 双指针      |
|   35   |               [Search Insert Position](src/SearchInsertPosition.java)                |    Easy    |    100%     |         BS          |
|   69   |                               [Sqrt(x)](src/Sqrt.java)                               |    Easy    |    100%     |   Math, 牛顿迭代, BS    |
|  167   |               [Two Sum II - Input Array is Sorted](src/TwoSumII.java)                |   Medium   |    100%     |       BS, 双指针       |
|  189   |                         [Rotate Array](src/RotateArray.java)                         |   Medium   |    100%     |    Math, Reverse    |
|  278   |                    [First Bad Version](src/FirstBadVersion.java)                     |    Easy    |   99.95%    |         BS          |
|  283   |                           [Move Zeros](src/MoveZeros.java)                           |    Easy    |    100%     |        双指针?         |
|  344   |                       [Reverse String](src/ReverseString.java)                       |    Easy    |    100%     |         双指针         |
|  349   |              [Intersection of Two Arrays](src/IntersectTwoArrays.java)               |    Easy    |   93.84%    |   Set, Sort + 双指针   |
|  350   |            [Intersection of Two Arrays II](src/IntersectTwoArraysII.java)            |    Easy    |   89.79%    | HashMap, Sort + 双指针 |
|  367   |                 [Valid Perfect Square](src/ValidPerfectSquare.java)                  |    Easy    |    100%     |        类似 69        |
|  374   |                  [Guess Number Higher or Lower](src/GuessNum.java)                   |    Easy    |    100%     |         BS          |
|  441   |                       [Arranging Coins](src/ArrangeCoins.java)                       |    Easy    |   97.93%    |      Math, BS       |
|  557   |          [Reverse Words in a String III](src/ReverseWordsInStringIII.java)           |    Easy    |    100%     |         双指针         |
|  567   |                [Permutation in String](src/PermutationInString.java)                 |   Medium   |    100%     |      滑动窗口, 双指针      |
|  704   |                        [Binary Search](src/BinarySearch.java)                        |    Easy    |    100%     |         BS          |
|  744   | [Find Smallest Letter Greater Than Target](src/SmallestLetterGreaterThanTarget.java) |    Easy    |    100%     |         BS          |
|  876   |                 [Middle of the Linked List](src/MiddleLinkList.java)                 |    Easy    |    100%     |         双指针         |
|  977   |               [Squares of a Sorted Array](src/SquaresSortedArray.java)               |    Easy    |    100%     |         双指针         |
##### Total: 20


## Arrays
| Number |                              Problem                              | Difficulty | Beat (Time) |        Note         |
|:------:|:-----------------------------------------------------------------:|:----------:|:-----------:|:-------------------:|
|  167   |      [Two Sum II - Input Array is Sorted](src/TwoSumII.java)      |   Medium   |    100%     |       BS, 双指针       |
|  189   |               [Rotate Array](src/RotateArray.java)                |   Medium   |    100%     |    Math, Reverse    |
|  283   |                 [Move Zeros](src/MoveZeros.java)                  |    Easy    |    100%     |        双指针?         |
|  344   |             [Reverse String](src/ReverseString.java)              |    Easy    |    100%     |         双指针         |
|  349   |     [Intersection of Two Arrays](src/IntersectTwoArrays.java)     |    Easy    |   93.84%    |   Set, Sort + 双指针   |
|  350   |  [Intersection of Two Arrays II](src/IntersectTwoArraysII.java)   |    Easy    |   89.79%    | HashMap, Sort + 双指针 |
|  557   | [Reverse Words in a String III](src/ReverseWordsInStringIII.java) |    Easy    |    100%     |         双指针         |
|  977   |     [Squares of a Sorted Array](src/SquaresSortedArray.java)      |    Easy    |    100%     |         双指针         |


## Binary Search
| Number |                                       Problem                                        | Difficulty | Beat (Time) |      Note      |
|:------:|:------------------------------------------------------------------------------------:|:----------:|:-----------:|:--------------:|
|   35   |               [Search Insert Position](src/SearchInsertPosition.java)                |    Easy    |    100%     |       BS       |
|   69   |                               [Sqrt(x)](src/Sqrt.java)                               |    Easy    |    100%     | Math, 牛顿迭代, BS |
|  167   |               [Two Sum II - Input Array is Sorted](src/TwoSumII.java)                |   Medium   |    100%     |    BS, 双指针     |
|  278   |                    [First Bad Version](src/FirstBadVersion.java)                     |    Easy    |   99.95%    |       BS       |
|  367   |                 [Valid Perfect Square](src/ValidPerfectSquare.java)                  |    Easy    |    100%     |     类似 69      |
|  374   |                  [Guess Number Higher or Lower](src/GuessNum.java)                   |    Easy    |    100%     |       BS       |
|  441   |                       [Arranging Coins](src/ArrangeCoins.java)                       |    Easy    |   97.93%    |    Math, BS    |
|  704   |                        [Binary Search](src/BinarySearch.java)                        |    Easy    |    100%     |       BS       |
|  744   | [Find Smallest Letter Greater Than Target](src/SmallestLetterGreaterThanTarget.java) |    Easy    |    100%     |       BS       |


## Hash Map
| Number |                              Problem                              | Difficulty | Beat (Time) |        Note         |
|:------:|:-----------------------------------------------------------------:|:----------:|:-----------:|:-------------------:|
|  350   |  [Intersection of Two Arrays II](src/IntersectTwoArraysII.java)   |    Easy    |   89.79%    | HashMap, Sort + 双指针 |


## Linked List
| Number |                            Problem                            | Difficulty | Beat (Time) |    Note    |
|:------:|:-------------------------------------------------------------:|:----------:|:-----------:|:----------:|
|   19   | [Remove Nth Node From End of List](src/RemoveNthFromEnd.java) |   Medium   |    100%     | Stack, 双指针 |
|  876   |     [Middle of the Linked List](src/MiddleLinkList.java)      |    Easy    |    100%     |    双指针     |


## Set
| Number |                          Problem                          | Difficulty | Beat (Time) |      Note       |
|:------:|:---------------------------------------------------------:|:----------:|:-----------:|:---------------:|
|  349   | [Intersection of Two Arrays](src/IntersectTwoArrays.java) |    Easy    |   93.84%    | Set, Sort + 双指针 |


## Sliding Window
| Number |                                       Problem                                       | Difficulty | Beat (Time) |    Note     |
|:------:|:-----------------------------------------------------------------------------------:|:----------:|:-----------:|:-----------:|
|   3    | [Longest Substring Without Repeating Characters](src/LengthOfLongestSubstring.java) |   Medium   |    100%     | Set? + 滑动窗口 |
|  567   |                [Permutation in String](src/PermutationInString.java)                |   Medium   |    100%     |  滑动窗口，双指针   |


## Two Pointers
| Number |                              Problem                              | Difficulty | Beat (Time) |        Note         |
|:------:|:-----------------------------------------------------------------:|:----------:|:-----------:|:-------------------:|
|   19   |   [Remove Nth Node From End of List](src/RemoveNthFromEnd.java)   |   Medium   |    100%     |     Stack, 双指针      |
|  167   |      [Two Sum II - Input Array is Sorted](src/TwoSumII.java)      |   Medium   |    100%     |       BS, 双指针       |
|  283   |                 [Move Zeros](src/MoveZeros.java)                  |    Easy    |    100%     |        双指针?         |
|  344   |             [Reverse String](src/ReverseString.java)              |    Easy    |    100%     |         双指针         |
|  349   |     [Intersection of Two Arrays](src/IntersectTwoArrays.java)     |    Easy    |   93.84%    |   Set, Sort + 双指针   |
|  350   |  [Intersection of Two Arrays II](src/IntersectTwoArraysII.java)   |    Easy    |   89.79%    | HashMap, Sort + 双指针 |
|  557   | [Reverse Words in a String III](src/ReverseWordsInStringIII.java) |    Easy    |    100%     |         双指针         |
|  876   |       [Middle of the Linked List](src/MiddleLinkList.java)        |    Easy    |    100%     |         双指针         |
|  977   |     [Squares of a Sorted Array](src/SquaresSortedArray.java)      |    Easy    |    100%     |         双指针         |

