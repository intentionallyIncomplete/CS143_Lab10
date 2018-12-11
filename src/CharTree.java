import java.io.*;
import java.util.*;

/**
 * Class invariant: This code for a binary tree satisfies the
 * binary search tree storage rule.
 * CSSSKL 162
 * @author Ian Bryan 
 * @version Dec 10th, 2018.
 * */
public class CharTree {

	/*Inner class Node, 2 references(pointers), one data element
	 * The only reason this inner class is static is that it is used in 
	 * the static methods insertInSubtree , isInSubtree , and 
	 * showElementsInSubtree. This class should have more methods. 
	 * This is just a sample of possible methods.
	 */
	private static class TreeNode {
		private char data;
		private TreeNode rightLink, leftLink;

		// Parametrized constructor to build a node
		public TreeNode(char newData, TreeNode newLeftLink, TreeNode newRightLink) {
			// complete the constructor
			data = newData;
			leftLink = newLeftLink;
			rightLink = newRightLink;
		}
	}           //End of TreeNode inner class

	// The first node of the tree, called root
	private TreeNode root;

	// Default constructor to build the CharTree
	public CharTree( ) {
		root = null;
	}

	// Utility methods for CharTree:
	public void add(char item) {
		root = insertInSubtree(item, root);
	}


	public boolean contains(char item) {
		return isInSubtree(item, root);
	}

	public void showElements( ) {
		showElementsInSubtree(root);
	}

	/**
	 * Returns the root node of a tree that is the tree with root node
	 * subTreeRoot, but with a new node added that contains item.
	 * */
	private static TreeNode insertInSubtree(char item, TreeNode subTreeRoot) {
		if (subTreeRoot == null)
			return new TreeNode(item, null, null);
		else if (item < subTreeRoot.data) {
			subTreeRoot.leftLink = insertInSubtree(item, subTreeRoot.leftLink);
			return subTreeRoot;
		}
		else {         //item >= subTreeRoot.data
			subTreeRoot.rightLink = insertInSubtree(item, subTreeRoot.rightLink);
			return subTreeRoot;
		}
	}

	/**
	 * @param item
	 * @param subTreeRoot
	 * @return - Makes two recursive calls with a basecase that the subtree root is null (end of tree).
	 */
	private static boolean isInSubtree(char item, TreeNode subTreeRoot) {
		if(subTreeRoot == null) {
			return false;
		}else if(subTreeRoot.data == item) {
			return true;
		}else if(item < subTreeRoot.data) {
			insertInSubtree(item, subTreeRoot.leftLink);
			return false;
		}else {
			isInSubtree(item,subTreeRoot.rightLink);
			return false;
		}
	}

	private static void showElementsInSubtree(TreeNode subTreeRoot) { //Uses inorder traversal.
		if (subTreeRoot != null) {

			showElementsInSubtree(subTreeRoot.leftLink);
			System.out.print(subTreeRoot.data + " ");
			showElementsInSubtree(subTreeRoot.rightLink);
		}                    //else do nothing. Empty tree has nothing to display.
	}

        }
        
     private static void showElementsInSubtree(TreeNode subTreeRoot) { //Uses inorder traversal.
         if (subTreeRoot != null) {
             
	public static void main(String[] args) {
		CharTree tree = new CharTree();
		tree.add('c');
		tree.add('a');
		tree.add('t');
		tree.add('s');
		showElementsInSubtree(tree.root);

		//System.out.println(tree.toString()); //inorder prints a c t
		//System.out.println(tree.countNodes());
		//System.out.println(tree.getDepth());
		//System.out.println(tree.contains('c'));
		//System.out.println(tree.getParent('a')); //can be tricky	
	}
}
