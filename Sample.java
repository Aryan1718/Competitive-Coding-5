// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
# Definition for a binary tree node.
# class TreeNode(object): //T.C-> O(N) , S.C-> O(N/2)
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def largestValues(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[int]
        """
        result = []

        if root == None: return result
        queue = deque()

        queue.append(root)

        while len(queue) != 0:
            size = len(queue)
            max_val = -999999999999

            for i in range(size):
                curr = queue.popleft()
                max_val = max(max_val,curr.val)

                if curr.left != None:
                    queue.append(curr.left)
                if curr.right != None:
                    queue.append(curr.right)
            result.append(max_val)
        return result

class Solution(object):
    def isValidSudoku(self, board): //T.C->O(1),S.C->O(1)
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        
        row = [set() for _ in range(9)]
        col = [set() for _ in range(9)]
        grid = [[set() for _ in range(3)] for _ in range(3)]

        for i in range(9):
            for j in range(9):

                if board[i][j] == '.':
                    continue
                value = board[i][j]
                g_idxR = i // 3
                g_idxC = j // 3 
                if value in row[i] or value in col[j] or value in grid[g_idxR][g_idxC]:
                    return False
                row[i].add(value)
                col[j].add(value)
                grid[g_idxR][g_idxC].add(value)
        return True