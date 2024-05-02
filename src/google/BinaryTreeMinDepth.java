public class BinaryTreeMinDepth {
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

    int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        traverseTree(root, 1);
        return minDepth;
    }

    private void traverseTree(TreeNode node, int depth) {
        if(depth > minDepth) {
            return;
        }

        if(node.left == null && node.right == null) {
            if(depth < minDepth) {
                minDepth = depth;
                return;
            }
        }

        if(node.left!= null) {
            traverseTree(node.left, depth + 1);
        }

        if(node.right!= null) {
            traverseTree(node.right, depth + 1);
        }
    }
}
