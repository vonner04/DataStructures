public class BinarySearchTree{
    TreeNode root;

     public class TreeNode {
        int val;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {      
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void rotate(TreeNode x){
        if(x.parent == null){ //x is the root
            return;
        }

        TreeNode p = x.parent;
        TreeNode g = p.parent;

        if(p.left == x){                            /**************** x is a left child. ****************/
            p.left = x.right;                       //1) right child of node x is left child of parent p.
            if(x.right != null) x.right.parent = p; //2) update parent of right child of node x.
            x.right = p;                            //3) right child of node x is its parent
        } else {                                    /**************** x is a right child. ****************/
            p.right = x.left;                       //1) left child of node x is right child of parent p.
            if(x.left != null) x.left.parent = p;   //2) update parent of left child of node x.
            x.left = p;                             //3) left child of node x is its parent
        }                                           /**************** updating parents of x and p ****************/  
        x.parent = g;                               //update parent of node x.
        p.parent = x;                               //update parent of node p.  
        if(g != null){                              //if node p is not the root.
            if(g.left == p){                        //if node p is a left child.
                g.left = x;                         //node x is the new left child of node g.
            } else {                                //if node p is a right child.
                g.right = x;                        //node x is the new right child of node g.
            }
        } else {                                    //if node p is the root.
            root = x;                               //node x is the new root.
        }

    }

}