class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0; // Jeśli drzewo puste, głębokość = 0
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

public class TestMaxDepth {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, 
                new TreeNode(9), 
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
        );

        Solution solution = new Solution();
        System.out.println("Maksymalna głębokość drzewa: " + solution.maxDepth(root)); // Output: 3
    }
}
