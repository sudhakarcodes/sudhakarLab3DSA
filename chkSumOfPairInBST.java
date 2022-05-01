package sumPairInBST;

import java.util.*;

	// Binary Tree Node
	class Node {
	 
	    int data;
	    Node left, right;
	 
	    Node(int d)
	    {
	        data = d;
	        left = right = null;
	    }
	}
	 
	class BinarySearchTree {
	 
	    // Root of BST
	    Node root;
	 
	    // Constructor
	    BinarySearchTree()
	    {
	        root = null;
	    }
	 
	    // Inorder traversal of BST
	    void inorder()
	    {
	        inorderUtil(this.root);
	    }
	 
	    // Method for inorder traversal of BST
	    
	    void inorderUtil(Node node)
	    {
	        if (node == null)
	            return;
	 
	        inorderUtil(node.left);
	        System.out.print(node.data + " ");
	        inorderUtil(node.right);
	    }
	 
	    // method calling insertRec()
	    
	    void insert(int key)
	    {
	        root = insertRec(root, key);
	    }
	 
	    /* Recursive method to insert a new key in BST */
	    
	    Node insertRec(Node root, int data)
	    {
	 
	        /* If the tree is empty, return a new node */
	        if (root == null) {
	            root = new Node(data);
	            return root;
	        }
	 
	        /* Otherwise, recur down the tree */
	        if (data < root.data)
	            root.left = insertRec(root.left, data);
	        else if (data > root.data)
	            root.right = insertRec(root.right, data);
	 
	        return root;
	    }
	 
	    // Method that adds values of given BST into ArrayList and returns the ArrayList
	   
	    ArrayList<Integer> treeToList(Node node, ArrayList<Integer> list)
	    {
	        // Base Case
	        if (node == null)
	            return list;
	 
	        treeToList(node.left, list);
	        list.add(node.data);
	        treeToList(node.right, list);
	 
	        return list;
	    }
	 
	    // method to check for pair
	    
	    boolean isPairPresent(Node node, int target)
	    {
	        // This list a1 is passed as an argument
	        // in treeToList method
	        // which is later on filled by the values of BST
	        
	    	ArrayList<Integer> a1 = new ArrayList<>();
	 
	        // a2 list contains all the values of BST
	        // returned by treeToList method
	        
	    	ArrayList<Integer> a2 = treeToList(node, a1);
	 
	        int start = 0; // Starting index of a2
	 
	        int end = a2.size() - 1; // Ending index of a2
	 
	        while (start < end) {
	 
	            if (a2.get(start) + a2.get(end) == target) // Target Found!
	            {
	                System.out.println("Pair (" + a2.get(start) + " + " + a2.get(end) + " "
	                                   + ") is found to meet the required sum of " +  target);
	                return true;
	            }
	 
	            if (a2.get(start) + a2.get(end) > target) // decrements end
	            {
	                end--;
	            }
	 
	            if (a2.get(start) + a2.get(end) < target) // increments start
	            {
	                start++;
	            }
	        }
	 
	        System.out.println("No such values are found!");
	        return false;
	    }
	 
	    // Main Method
	    public static void main(String[] args)
	    {
	        BinarySearchTree tree = new BinarySearchTree();
	        /*
	                   40
	                /     \
	              20      60
	             / \     /  \
	            10  30  50  70    */
	        tree.insert(40);
	        tree.insert(20);
	        tree.insert(60);
	        tree.insert(10);
	        tree.insert(30);
	        tree.insert(50);
	        tree.insert(70);
	 
	        Scanner sc = new Scanner(System.in);
	        int sum;
	        System.out.println("Enter the Sum you need to find the pair: ");
	        sum = sc.nextInt();
	        
	        tree.isPairPresent(tree.root, sum);
	    }
}
	 
