package com.freesky.tree;

/*
 * 百度百科 中序遍历
 * https://baike.baidu.com/item/%E4%B8%AD%E5%BA%8F%E9%81%8D%E5%8E%86/757281
 * 
 */
public class TreeNode {
	public int data;
	public TreeNode leftChild;
	public TreeNode rightChild;
	
	public TreeNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}


	public void setData(int data) {
		this.data = data;
	}


	public TreeNode getLeftChild() {
		return leftChild;
	}


	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}


	public TreeNode getRightChild() {
		return rightChild;
	}


	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	/**
	 * 中序遍历（LDR）是二叉树遍历的一种，也叫做中根遍历、中序周游。
	 * @param node
	 */
	public static void inOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		} else {
			inOrderTraversal(node.leftChild);
		}
		System.out.println(node.data);
		inOrderTraversal(node.rightChild);
	}
	
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(13);
		TreeNode left = new TreeNode(9);
		tree.setLeftChild(left);
		TreeNode left1 = new TreeNode(7);
		left.setLeftChild(left1);
		TreeNode left2 = new TreeNode(10);
		left.setRightChild(left2);
		
		TreeNode right = new TreeNode(16);
		tree.setRightChild(right);
		TreeNode right1 = new TreeNode(15);
		right.setLeftChild(right1);
		TreeNode right2 = new TreeNode(18);
		right.setRightChild(right2);
		
		inOrderTraversal(tree);
	}
}
