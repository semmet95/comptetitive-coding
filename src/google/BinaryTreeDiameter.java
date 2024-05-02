public class BinaryTreeDiameter {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getLongestChild(root);
        return maxDiameter;
    }

    private int getLongestChild(TreeNode node) {
        if(node.left == null && node.right == null) return 0;

        int leftLength, rightLength, diameter = 0;

        if(node.left == null) {
            leftLength = 0;
        } else {
            leftLength = getLongestChild(node.left) + 1;
            diameter += leftLength;
        }

        if(node.right == null) {
            rightLength = 0;
        } else {
            rightLength = getLongestChild(node.right) + 1;
            diameter += rightLength;
        }

        if(diameter > maxDiameter) {
            maxDiameter = diameter;
        }

        return Math.max(leftLength, rightLength);
    }
}
