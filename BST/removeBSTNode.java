class removeBST {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;
        
        if (key < root.val){ //search for the key
            root.left = deleteNode(root.left, key);
        } else if (key > root.val){ //search for the key
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode minNode = findMin(root.right);
            minNode.left = root.left;
            return root.right;
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
}