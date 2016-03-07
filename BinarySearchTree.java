/**
 * Data Structure and Algorithm Analysis
 * @author Duoc Nguyen
 * Models a BST class
 * @param <Integer> This class is of type Integer
 */
public class BinarySearchTree<Integer>
{
	private BinaryNode<Integer> root;
	
	/**
	 * Constructs a BST
	 */
	public BinarySearchTree()
	{
		root = null;
	}
	
	/**
	 * Gets the root of the BST
	 * @return the root
	 */
	public BinaryNode<Integer> getRoot()
	{
		return root;
	}
	
	/**
	 * Gets the height of the BST
	 * @return the height or -1 if null;
	 */
	public int height()
	{
		return height(root);
	}
	
	/**
	 * Gets the height of a node
	 * @param node The node to get the height 
	 * @return The height of the node
	 */
	public int height(BinaryNode<Integer> node)
	{
		if(node == null)
		{
			return -1;
		}
		else
		{
			return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
		}
	}
	
	/**
	 * Check if the tree contains the target integer
	 * @param k	The target integer
	 * @return	Tree if the tree contains the integer else false
	 */
	public boolean contains(int k)
	{
		return search(k) != null;
	}
	
	/**
	 * Searches the tree for the target integer
	 * @param k	The target integer
	 * @return	The node with the integer
	 */
	public BinaryNode<Integer> search(int k)
	{
		return search(root,k);
	}
	
	/**
	 * Recursively searches for the target integer with a starting node
	 * @param node	The starting node
	 * @param k	The target integer
	 * @return	The node with the target integer
	 */
	public BinaryNode<Integer> search(BinaryNode<Integer> node, int k)
	{
		if(node == null)
		{
			return null;
		}
		if(k - (int)node.getData() < 0)
		{
			return search(node.getLeft(), k);
		}
		else if(k - (int)node.getData() > 0)
		{
			return search(node.getRight(), k);
		}
		else
		{
			return node;
		}
	}
	
	/**
	 * Inserts an integer to the  tree
	 * @param n The integer to insert
	 */
	public void add(int n)
	{
		root = add(root, n);
	}
	
	/**
	 * Recursively adds an integer into the tree starting at a node
	 * @param node	Starting node to add 
	 * @param toAdd	The integer to add to the tree
	 * @return
	 */
	public BinaryNode<Integer> add(BinaryNode<Integer> node, int toAdd)
	{
		if(node == null)
		{
			return new BinaryNode<Integer>(toAdd);
		}
		if(toAdd - (int)node.getData() <= 0)
		{
			node.setLeft(add(node.getLeft(), toAdd));
		}
		else
		{
			node.setRight(add(node.getRight(), toAdd));
		}
		return node;
	}
	
	/**
	 * Removes an integer from the tree
	 * @param toDelete	The integer to be removed
	 */
	public void delete(int toDelete)
	{
		root = delete(root, toDelete);
	}
	
	/**
	 * Recursively removes an integer from the tree starting at a node
	 * @param node	Starting node to remove
	 * @param toDelete	The integer to delete from tree
	 * @return	The removed node or null.
	 */
	public BinaryNode<Integer> delete(BinaryNode<Integer> node, int toDelete)
	{
		if(node == null)
		{
			return null;
		}
		if(toDelete - (int)node.getData() < 0)
		{
			node.setLeft(delete(node.getLeft(), toDelete));
		}
		else if(toDelete - (int)node.getData() > 0)
		{
			node.setRight(delete(node.getRight(), toDelete));
		}
		else
		{
			if(node.getLeft() == null)
			{
				return node.getRight();
			}
			else if(node.getRight() == null)
			{
				return node.getLeft();
			}
			else
			{
				node.setData(max(node.getLeft())); //gets the rightmost node of the left subtree
				node.setLeft(delete(node.getLeft(), (int)node.getData())); //delete the rightmost node of the left subtree
			}
		}
		return node;
	}
	
	/**
	 * Finds the largest integer starting form a node 
	 * @param node	The starting node
	 * @return	The largest integer
	 */
	private int max(BinaryNode<Integer> node)
	{
		while(node.getRight() != null)
		{
			node = node.getRight();
		}
		return (int)node.getData();
	}
	
	/**
	 * Checks if the tree is empty
	 * @return true if empty else false. 
	 */
	public boolean isEmpty()
	{
		return root == null;
	}
}
