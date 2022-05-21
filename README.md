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
* [Queue](#queue)
* [Segment Tree](#segment-tree)
* [Set](#set)
* [Stack](#stack)
* [String](#string)


## Summary
|  ID  |                                         Problem                                         | Difficulty | Beat (Time) |        Note         |
|:----:|:---------------------------------------------------------------------------------------:|:----------:|:-----------:|:-------------------:|
|  1   |                               [Two Sum](src/TwoSum.java)                                |    Easy    |   99.38%    |       HashMap       |
|  3   |   [Longest Substring Without Repeating Characters](src/LengthOfLongestSubstring.java)   |   Medium   |    100%     |     Set? + 滑动窗口     |
|  19  |              [Remove Nth Node From End of List](src/RemoveNthFromEnd.java)              |   Medium   |    100%     |     Stack, 双指针      |
|  20  |                     [Valid Parentheses](src/ValidParentheses.java)                      |    Easy    |   98.84%    |        Stack        |
|  21  |                 [Merge Two Sorted Lists](src/MergeTwoSortedLists.java)                  |    Easy    |    100%     |         递归          |
|  34  | [Find First and Last Position of Element in Sorted Array](src/FirstLastPosInArray.java) |   Medium   |    100%     |         BS          |
|  35  |                 [Search Insert Position](src/SearchInsertPosition.java)                 |    Easy    |    100%     |         BS          |
|  36  |                          [Valid Sudoku](src/ValidSudoku.java)                           |   Medium   |   99.68%    |        Array        |
|  46  |                          [Permutations](src/Permutations.java)                          |   Medium   |    100%     |         回溯          |
|  53  |                        [Maximum Subarray](src/MaxSubarray.java)                         |    Easy    |    100%     |     贪心, DP, 线段树     |
|  69  |                                [Sqrt(x)](src/Sqrt.java)                                 |    Easy    |    100%     |   Math, 牛顿迭代, BS    |
|  70  |                       [Climbing Stairs](src/ClimbingStairs.java)                        |    Easy    |    100%     |   DP, Math, Memo    |
|  73  |                      [Set Matrix Zeroes](src/SetMatrixZeroes.java)                      |   Medium   |    100%     |        Array        |
|  77  |                          [Combinations](src/Combinations.java)                          |   Medium   |   99.99%    |       回溯, 字典序       |
|  83  |         [Remove Duplicates from Sorted List](src/RemoveDupsFromSortedList.java)         |    Easy    |    100%     |         遍历          |
|  88  |                     [Merge Sorted Array](src/MergeSortedArray.java)                     |    Easy    |    100%     |         双指针         |
|  94  |               [Binary Tree Inorder Traversal](src/BinaryTreeInorder.java)               |    Easy    |    100%     |        中序遍历         |
|  98  |                   [Validate Binary Search Tree](src/ValidateBST.java)                   |   Medium   |    100%     |      递归, 中序遍历       |
| 101  |                        [Symmetric Tree](src/SymmetricTree.java)                         |    Easy    |    100%     |       递归, 迭代        |
| 102  |           [Binary Tree Level Order Traversal](src/BinaryTreeLevelOrder.java)            |   Medium   |    100%     |        层序遍历         |
| 104  |              [Maximum Depth of Binary Tree](src/MaxDepthOfBinaryTree.java)              |    Easy    |    100%     |         DFS         |
| 112  |                              [Path Sum](src/PathSum.java)                               |    Easy    |    100%     |      DFS, BFS       |
| 116  |      [Populating Next Right Pointers in Each Node](src/PopNextRightPointers.java)       |   Medium   |    100%     |        层序遍历         |
| 118  |                      [Pascal's Triangle](src/PascalTriangle.java)                       |    Easy    |    100%     |         DP          |
| 120  |                              [Triangle](src/Triangle.java)                              |   Medium   |   96.09%    |         DP          |
| 121  |            [Best Time to Buy and Sell Stock](src/BestTimeBuySellStock.java)             |    Easy    |    100%     |         DP          |
| 136  |                         [Single Number](src/SingleNumber.java)                          |    Easy    |    100%     |         Bit         |
| 141  |                      [Linked List Cycle](src/LinkedListCycle.java)                      |    Easy    |    100%     |         双指针         |
| 144  |              [Binary Tree Preorder Traversal](src/BinaryTreePreorder.java)              |    Easy    |    100%     |        前序遍历         |
| 145  |             [Binary Tree Postorder Traversal](src/BinaryTreePostorder.java)             |    Easy    |    100%     |        后序遍历         |
| 167  |                 [Two Sum II - Input Array is Sorted](src/TwoSumII.java)                 |   Medium   |    100%     |       BS, 双指针       |
| 189  |                          [Rotate Array](src/RotateArray.java)                           |   Medium   |    100%     |    Math, Reverse    |
| 190  |                          [Reverse Bits](src/ReverseBits.java)                           |    Easy    |    100%     |       Bit, 分治       |
| 191  |                        [Number of 1 Bits](src/RotateArray.java)                         |    Easy    |    100%     |         Bit         |
| 198  |                          [House Robber](src/HouseRobber.java)                           |   Medium   |    100%     |         DP          |
| 203  |              [Remove Linked List Elements](src/RemoveLinkedListNodes.java)              |    Easy    |    100%     |         递归          |
| 206  |                    [Reverse Linked List](src/ReverseLinkedList.java)                    |    Easy    |    100%     |         递归          |
| 217  |                    [Contains Duplicate](src/ContainsDuplicate.java)                     |    Easy    |   99.08%    |         Set         |
| 226  |                     [Invert Binary Tree](src/InvertBinaryTree.java)                     |    Easy    |    100%     |       递归, 迭代        |
| 231  |                           [Power of Two](src/PowerOfTwo.java)                           |    Easy    |    100%     |         Bit         |
| 232  |                    [Implement Queue using Stacks](src/MyQueue.java)                     |    Easy    |    100%     |  Stack, Queue, 摊还   |
| 235  |           [Lowest Common Ancestor of a Binary Search Tree](src/LCAOfBST.java)           |    Easy    |    100%     |         递归          |
| 242  |                         [Valid Anagram](src/ValidAnagram.java)                          |    Easy    |    100%     |       HaspMap       |
| 278  |                      [First Bad Version](src/FirstBadVersion.java)                      |    Easy    |   99.95%    |         BS          |
| 283  |                            [Move Zeros](src/MoveZeros.java)                             |    Easy    |    100%     |        双指针?         |
| 344  |                        [Reverse String](src/ReverseString.java)                         |    Easy    |    100%     |         双指针         |
| 349  |                [Intersection of Two Arrays](src/IntersectTwoArrays.java)                |    Easy    |   93.84%    |   Set, Sort + 双指针   |
| 350  |             [Intersection of Two Arrays II](src/IntersectTwoArraysII.java)              |    Easy    |   89.79%    | HashMap, Sort + 双指针 |
| 367  |                   [Valid Perfect Square](src/ValidPerfectSquare.java)                   |    Easy    |    100%     |   Math, 牛顿迭代, BS    |
| 374  |                    [Guess Number Higher or Lower](src/GuessNum.java)                    |    Easy    |    100%     |         BS          |
| 383  |                           [Ransom Note](src/RansomNote.java)                            |    Easy    |   99.95%    |       HashMap       |
| 387  |             [First Unique Character in a String](src/FirstUniqueChar.java)              |    Easy    |   91.77%    |       HashMap       |
| 441  |                        [Arranging Coins](src/ArrangeCoins.java)                         |    Easy    |   97.93%    |      Math, BS       |
| 542  |                           [01 Matrix](src/ZeroOneMatrix.java)                           |   Medium   |   98.95%    |       DP, BFS       |
| 557  |            [Reverse Words in a String III](src/ReverseWordsInStringIII.java)            |    Easy    |    100%     |         双指针         |
| 566  |                      [Reshape the Matrix](src/ReshapeMatrix.java)                       |    Easy    |    100%     |  Flatten 2D Array   |
| 567  |                  [Permutation in String](src/PermutationInString.java)                  |   Medium   |    100%     |      滑动窗口, 双指针      |
| 617  |                 [Merge Two Binary Trees](src/MergeTwoBinaryTrees.java)                  |    Easy    |    100%     |      DFS, BFS       |
| 653  |                    [Two Sum IV - Input is a BST](src/TwoSumIV.java)                     |    Easy    |    100%     |      中序遍历, 双指针      |
| 695  |                     [Max Area of Island](src/MaxAreaOfIsland.java)                      |   Medium   |    100%     |      DFS, BFS       |
| 700  |                  [Search in a Binary Search Tree](src/SearchBST.java)                   |    Easy    |    100%     |       递归, 迭代        |
| 701  |               [Insert into a Binary Search Tree](src/InsertIntoBST.java)                |   Medium   |    100%     |       递归, 迭代        |
| 704  |                         [Binary Search](src/BinarySearch.java)                          |    Easy    |    100%     |         BS          |
| 733  |                            [Flood Fill](src/FloodFill.java)                             |    Easy    |    100%     |      DFS, BFS       |
| 744  |  [Find Smallest Letter Greater Than Target](src/SmallestLetterGreaterThanTarget.java)   |    Easy    |    100%     |         BS          |
| 784  |                [Letter Case Permutation](src/LetterCasePermutation.java)                |   Medium   |    100%     |       回溯, Bit       |
| 852  |           [Peak Index in a Mountain Array](src/PeakIndexInMountainArray.java)           |    Easy    |    100%     |         BS          |
| 876  |                  [Middle of the Linked List](src/MiddleLinkList.java)                   |    Easy    |    100%     |         双指针         |
| 977  |                [Squares of a Sorted Array](src/SquaresSortedArray.java)                 |    Easy    |    100%     |         双指针         |
| 994  |                       [Rotting Oranges](src/RottingOranges.java)                        |   Medium   |    100%     |         BFS         |
| 1385 |         [Find the Distance Value Between Two Arrays](src/FindTheDistValue.java)         |    Easy    |   91.78%    |         BS          |
##### Total: 71


## Arrays
| ID  |                               Problem                               | Difficulty | Beat (Time) |        Note         |
|:---:|:-------------------------------------------------------------------:|:----------:|:-----------:|:-------------------:|
|  1  |                     [Two Sum](src/TwoSum.java)                      |    Easy    |   99.38%    |       HashMap       |
| 36  |                [Valid Sudoku](src/ValidSudoku.java)                 |   Medium   |   99.68%    |        Array        |
| 46  |                [Permutations](src/Permutations.java)                |   Medium   |    100%     |         回溯          |
| 53  |              [Maximum Subarray](src/MaxSubarray.java)               |    Easy    |    100%     |     贪心, DP, 线段树     |
| 73  |            [Set Matrix Zeroes](src/SetMatrixZeroes.java)            |   Medium   |    100%     |        Array        |
| 77  |                [Combinations](src/Combinations.java)                |   Medium   |   99.99%    |       回溯, 字典序       |
| 88  |           [Merge Sorted Array](src/MergeSortedArray.java)           |    Easy    |    100%     |         双指针         |
| 121 |  [Best Time to Buy and Sell Stock](src/BestTimeBuySellStock.java)   |    Easy    |    100%     |         DP          |
| 167 |       [Two Sum II - Input Array is Sorted](src/TwoSumII.java)       |   Medium   |    100%     |       BS, 双指针       |
| 189 |                [Rotate Array](src/RotateArray.java)                 |   Medium   |    100%     |    Math, Reverse    |
| 283 |                  [Move Zeros](src/MoveZeros.java)                   |    Easy    |    100%     |        双指针?         |
| 344 |              [Reverse String](src/ReverseString.java)               |    Easy    |    100%     |         双指针         |
| 349 |      [Intersection of Two Arrays](src/IntersectTwoArrays.java)      |    Easy    |   93.84%    |   Set, Sort + 双指针   |
| 350 |   [Intersection of Two Arrays II](src/IntersectTwoArraysII.java)    |    Easy    |   89.79%    | HashMap, Sort + 双指针 |
| 557 |  [Reverse Words in a String III](src/ReverseWordsInStringIII.java)  |    Easy    |    100%     |         双指针         |
| 566 |            [Reshape the Matrix](src/ReshapeMatrix.java)             |    Easy    |    100%     |  Flatten 2D Array   |
| 852 | [Peak Index in a Mountain Array](src/PeakIndexInMountainArray.java) |    Easy    |    100%     |         BS          |
| 977 |      [Squares of a Sorted Array](src/SquaresSortedArray.java)       |    Easy    |    100%     |         双指针         |


## Backtracking
| ID  |                          Problem                          | Difficulty | Beat (Time) |  Note   |
|:---:|:---------------------------------------------------------:|:----------:|:-----------:|:-------:|
| 46  |           [Permutations](src/Permutations.java)           |   Medium   |    100%     |   回溯    |
| 77  |           [Combinations](src/Combinations.java)           |   Medium   |   99.99%    | 回溯, 字典序 |
| 784 | [Letter Case Permutation](src/LetterCasePermutation.java) |   Medium   |    100%     | 回溯, Bit |


## Binary Search
|  ID  |                                         Problem                                         | Difficulty | Beat (Time) |      Note      |
|:----:|:---------------------------------------------------------------------------------------:|:----------:|:-----------:|:--------------:|
|  34  | [Find First and Last Position of Element in Sorted Array](src/FirstLastPosInArray.java) |   Medium   |    100%     |       BS       |
|  35  |                 [Search Insert Position](src/SearchInsertPosition.java)                 |    Easy    |    100%     |       BS       |
|  69  |                                [Sqrt(x)](src/Sqrt.java)                                 |    Easy    |    100%     | Math, 牛顿迭代, BS |
| 167  |                 [Two Sum II - Input Array is Sorted](src/TwoSumII.java)                 |   Medium   |    100%     |    BS, 双指针     |
| 217  |                    [Contains Duplicate](src/ContainsDuplicate.java)                     |    Easy    |   99.08%    |      Set       |
| 278  |                      [First Bad Version](src/FirstBadVersion.java)                      |    Easy    |   99.95%    |       BS       |
| 367  |                   [Valid Perfect Square](src/ValidPerfectSquare.java)                   |    Easy    |    100%     | Math, 牛顿迭代, BS |
| 374  |                    [Guess Number Higher or Lower](src/GuessNum.java)                    |    Easy    |    100%     |       BS       |
| 441  |                        [Arranging Coins](src/ArrangeCoins.java)                         |    Easy    |   97.93%    |    Math, BS    |
| 704  |                         [Binary Search](src/BinarySearch.java)                          |    Easy    |    100%     |       BS       |
| 744  |  [Find Smallest Letter Greater Than Target](src/SmallestLetterGreaterThanTarget.java)   |    Easy    |    100%     |       BS       |
| 852  |           [Peak Index in a Mountain Array](src/PeakIndexInMountainArray.java)           |    Easy    |    100%     |       BS       |
| 1385 |         [Find the Distance Value Between Two Arrays](src/FindTheDistValue.java)         |    Easy    |   91.78%    |       BS       |


## Binary Tree
| ID  |                                   Problem                                    | Difficulty | Beat (Time) |   Note    |
|:---:|:----------------------------------------------------------------------------:|:----------:|:-----------:|:---------:|
| 94  |         [Binary Tree Inorder Traversal](src/BinaryTreeInorder.java)          |    Easy    |    100%     |   中序遍历    |
| 98  |             [Validate Binary Search Tree](src/ValidateBST.java)              |   Medium   |    100%     | 递归, 中序遍历  |
| 101 |                   [Symmetric Tree](src/SymmetricTree.java)                   |    Easy    |    100%     |   递归，迭代   |
| 102 |      [Binary Tree Level Order Traversal](src/BinaryTreeLevelOrder.java)      |   Medium   |    100%     |   层序遍历    |
| 104 |        [Maximum Depth of Binary Tree](src/MaxDepthOfBinaryTree.java)         |    Easy    |    100%     |    DFS    |
| 112 |                         [Path Sum](src/PathSum.java)                         |    Easy    |    100%     | DFS, BFS  |
| 116 | [Populating Next Right Pointers in Each Node](src/PopNextRightPointers.java) |   Medium   |    100%     |   层序遍历    |
| 144 |        [Binary Tree Preorder Traversal](src/BinaryTreePreorder.java)         |    Easy    |    100%     |   前序遍历    |
| 145 |       [Binary Tree Postorder Traversal](src/BinaryTreePostorder.java)        |    Easy    |    100%     |   后序遍历    |
| 226 |               [Invert Binary Tree](src/ContainsDuplicate.java)               |    Easy    |    100%     |  递归, 迭代   |
| 235 |     [Lowest Common Ancestor of a Binary Search Tree](src/LCAOfBST.java)      |    Easy    |    100%     |    递归     |
| 617 |            [Merge Two Binary Trees](src/MergeTwoBinaryTrees.java)            |    Easy    |    100%     | DFS, BFS  |
| 653 |               [Two Sum IV - Input is a BST](src/TwoSumIV.java)               |    Easy    |    100%     | 中序遍历, 双指针 |
| 700 |             [Search in a Binary Search Tree](src/SearchBST.java)             |    Easy    |    100%     |  递归, 迭代   |
| 701 |          [Insert into a Binary Search Tree](src/InsertIntoBST.java)          |   Medium   |    100%     |  递归, 迭代   |


## Bit Manipulation
| ID  |                          Problem                          | Difficulty | Beat (Time) |  Note   |
|:---:|:---------------------------------------------------------:|:----------:|:-----------:|:-------:|
| 136 |          [Single Number](src/SingleNumber.java)           |    Easy    |    100%     |   Bit   |
| 190 |           [Reverse Bits](src/ReverseBits.java)            |    Easy    |    100%     | Bit, 分治 |
| 191 |         [Number of 1 Bits](src/RotateArray.java)          |    Easy    |    100%     |   Bit   |
| 231 |            [Power of Two](src/PowerOfTwo.java)            |    Easy    |    100%     |   Bit   |
| 784 | [Letter Case Permutation](src/LetterCasePermutation.java) |   Medium   |    100%     | 回溯, Bit |


## Breadth First Search
| ID  |                  Problem                   | Difficulty | Beat (Time) |  Note   |
|:---:|:------------------------------------------:|:----------:|:-----------:|:-------:|
| 542 |    [01 Matrix](src/ZeroOneMatrix.java)     |   Medium   |   98.95%    | DP, BFS |
| 994 | [Rotting Oranges](src/RottingOranges.java) |   Medium   |    100%     |   BFS   |


## Depth First Search
| ID  |                            Problem                            | Difficulty | Beat (Time) |   Note   |
|:---:|:-------------------------------------------------------------:|:----------:|:-----------:|:--------:|
| 104 | [Maximum Depth of Binary Tree](src/MaxDepthOfBinaryTree.java) |    Easy    |    100%     |   DFS    |
| 112 |                 [Path Sum](src/PathSum.java)                  |    Easy    |    100%     | DFS, BFS |
| 617 |    [Merge Two Binary Trees](src/MergeTwoBinaryTrees.java)     |    Easy    |    100%     | DFS, BFS |
| 695 |        [Max Area of Island](src/MaxAreaOfIsland.java)         |   Medium   |    100%     | DFS, BFS |
| 733 |               [Flood Fill](src/FloodFill.java)                |    Easy    |    100%     | DFS, BFS |


## Dynamic Programming
| ID  |                             Problem                              | Difficulty | Beat (Time) |      Note      |
|:---:|:----------------------------------------------------------------:|:----------:|:-----------:|:--------------:|
| 53  |             [Maximum Subarray](src/MaxSubarray.java)             |    Easy    |    100%     |  贪心, DP, 线段树   |
| 70  |            [Climbing Stairs](src/ClimbingStairs.java)            |    Easy    |    100%     | DP, Math, Memo |
| 118 |           [Pascal's Triangle](src/PascalTriangle.java)           |    Easy    |    100%     |       DP       |
| 120 |                  [Triangle](src/Triangle.java)                   |   Medium   |   96.09%    |       DP       |
| 121 | [Best Time to Buy and Sell Stock](src/BestTimeBuySellStock.java) |    Easy    |    100%     |       DP       |
| 198 |               [House Robber](src/HouseRobber.java)               |   Medium   |    100%     |       DP       |
| 542 |               [01 Matrix](src/ZeroOneMatrix.java)                |   Medium   |   98.95%    |    DP, BFS     |


## Hash Map
| ID  |                            Problem                             | Difficulty | Beat (Time) |        Note         |
|:---:|:--------------------------------------------------------------:|:----------:|:-----------:|:-------------------:|
|  1  |                   [Two Sum](src/TwoSum.java)                   |    Easy    |   99.38%    |       HashMap       |
| 242 |             [Valid Anagram](src/ValidAnagram.java)             |    Easy    |    100%     |       HaspMap       |
| 350 | [Intersection of Two Arrays II](src/IntersectTwoArraysII.java) |    Easy    |   89.79%    | HashMap, Sort + 双指针 |
| 383 |               [Ransom Note](src/RansomNote.java)               |    Easy    |   99.95%    |       HashMap       |
| 387 | [First Unique Character in a String](src/FirstUniqueChar.java) |    Easy    |   91.77%    |       HashMap       |


## Linked List
| ID  |                                 Problem                                 | Difficulty | Beat (Time) |    Note    |
|:---:|:-----------------------------------------------------------------------:|:----------:|:-----------:|:----------:|
| 19  |      [Remove Nth Node From End of List](src/RemoveNthFromEnd.java)      |   Medium   |    100%     | Stack, 双指针 |
| 21  |         [Merge Two Sorted Lists](src/MergeTwoSortedLists.java)          |    Easy    |    100%     |     递归     |
| 83  | [Remove Duplicates from Sorted List](src/RemoveDupsFromSortedList.java) |    Easy    |    100%     |     遍历     |
| 141 |              [Linked List Cycle](src/LinkedListCycle.java)              |    Easy    |    100%     |    双指针     |
| 203 |      [Remove Linked List Elements](src/RemoveLinkedListNodes.java)      |    Easy    |    100%     |     递归     |
| 206 |            [Reverse Linked List](src/ReverseLinkedList.java)            |    Easy    |    100%     |     递归     |
| 876 |          [Middle of the Linked List](src/MiddleLinkList.java)           |    Easy    |    100%     |    双指针     |


## Queue
| ID  |                     Problem                      | Difficulty | Beat (Time) |       Note       |
|:---:|:------------------------------------------------:|:----------:|:-----------:|:----------------:|
| 232 | [Implement Queue using Stacks](src/MyQueue.java) |    Easy    |    100%     | Stack, Queue, 摊还 |


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


## Stack
| ID  |                    Problem                     | Difficulty | Beat (Time) | Note  |
|:---:|:----------------------------------------------:|:----------:|:-----------:|:-----:|
| 20  | [Valid Parentheses](src/ValidParentheses.java) |    Easy    |   98.84%    | Stack |


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
| 141 |           [Linked List Cycle](src/LinkedListCycle.java)           |    Easy    |    100%     |         双指针         |
| 167 |      [Two Sum II - Input Array is Sorted](src/TwoSumII.java)      |   Medium   |    100%     |       BS, 双指针       |
| 283 |                 [Move Zeros](src/MoveZeros.java)                  |    Easy    |    100%     |        双指针?         |
| 344 |             [Reverse String](src/ReverseString.java)              |    Easy    |    100%     |         双指针         |
| 349 |     [Intersection of Two Arrays](src/IntersectTwoArrays.java)     |    Easy    |   93.84%    |   Set, Sort + 双指针   |
| 350 |  [Intersection of Two Arrays II](src/IntersectTwoArraysII.java)   |    Easy    |   89.79%    | HashMap, Sort + 双指针 |
| 557 | [Reverse Words in a String III](src/ReverseWordsInStringIII.java) |    Easy    |    100%     |         双指针         |
| 653 |         [Two Sum IV - Input is a BST](src/TwoSumIV.java)          |    Easy    |    100%     |      中序遍历, 双指针      |
| 876 |       [Middle of the Linked List](src/MiddleLinkList.java)        |    Easy    |    100%     |         双指针         |
| 977 |     [Squares of a Sorted Array](src/SquaresSortedArray.java)      |    Easy    |    100%     |         双指针         |

