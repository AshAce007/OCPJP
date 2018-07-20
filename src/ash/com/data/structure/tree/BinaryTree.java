package ash.com.data.structure.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.SortedMap;
import java.util.Queue;

public class BinaryTree {
	
	
	// creating node
	class Node {
		int value;
		Node left;
		Node right;
		
		Node(int value) {
			this.value = value;
			right = null;
			left = null;
		}
	}
	
	Node root;
	
	// adding node recursively to a tree
	private Node addRecursive(Node current, int value) {
		if(current == null) {
			return new Node(value);
		}
		
		if(value < current.value) {
			current.left = addRecursive(current.left, value);
		} else if (value > current.value) {
			current.right = addRecursive(current.right, value);
		} else {
			return current;
		}
		return current;
	}
	
	public void add(int value) {
		root = addRecursive(root, value);
	}
		
	// finding a tree element
	private boolean containsRecursiveSearch(Node current, int value) {
		if (current == null) {
			return false;
		}
		
		if(value == current.value) {
			return true;
		}
		
		return (value < current.value) ? containsRecursiveSearch(
				current.left, value) : containsRecursiveSearch(current.right,
				value);
	}
	
	private boolean hasElement(int value) {
		return containsRecursiveSearch(root, value);
	}
	
	//DFS (inorder)
	public void traverseInOrder(Node node) {
		if(node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value);
			traverseInOrder(node.right);
		}
	}
	
	//DFS (preorder)
	public void traversePreOrder(Node node) {
		if(node != null) {
			System.out.print(" " + node.value);
			traversePreOrder(node.left);
			traversePreOrder(node.right);
		}
	}
	
		//DFS (postorder)
		public void traversePostOrder(Node node) {
			if(node != null) {
				traversePreOrder(node.left);
				traversePreOrder(node.right);
				System.out.print(" " + node.value);
			}
		}
	
		//BFS or levelTraverse
		public void traverseLabelOrder() {
			if (root == null) { return; }
			
			Queue<Node> nodes = new LinkedList<>();
			nodes.add(root);
			
			while(!nodes.isEmpty()) {
				Node node = nodes.remove();
				
				System.out.print(" " + node.value);
				
				if(node.left != null) {
					nodes.add(node.left);
				}
				
				if(node.right != null) {
					nodes.add(node.right);
				}
			}
		}
		
		
		//Deleting an Element
		
		private Node deleteRecursive(Node current, int value) {
			if(current == null) {
				return null;
			}
			
			if(value == current.value) {
				current = null;
			}
			
			
			
			if (value < current.value) {
				current.left = deleteRecursive(current.left, value);
			}
			
			current.right = deleteRecursive(current.right, value);
			
			return current;
		}
		
		
	
	// Executable
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.add(6);
	    binaryTree.add(4);
	    binaryTree.add(8);
	    binaryTree.add(3);
	    binaryTree.add(5);
	    binaryTree.add(7);
	    binaryTree.add(9);
		
		System.out.println("has element 11 : " + binaryTree.hasElement(11));
	
		System.out.print("in order DFS : ");
		binaryTree.traverseInOrder(binaryTree.root);
		System.out.println();
		
		System.out.print("pre order DFS : ");
		binaryTree.traversePreOrder(binaryTree.root);
		System.out.println();
		
		System.out.print("post order DFS : ");
		binaryTree.traversePostOrder(binaryTree.root);
		System.out.println();
		
		System.out.print("BFS : ");
		binaryTree.traverseLabelOrder();
		System.out.println();
		
		
		
		
	}
}
