/**
 * Data Structure and Algorithm Analysis
 * @author Duoc Nguyen
 * Models a AVLTree class for performance test(without printing balance messages)
 * @param <Integer> This class is of type Integer
 */
public class AVLTree2<Integer>
{
	private BinaryNode<Integer> root;

	public AVLTree2()
	{
		root = null;
	}

	/**
	 * Gets the root of the AVL tree
	 * @return the root
	 */
	public BinaryNode<Integer> getRoot()
	{
		return root;
	}

	/**
	 * Gets the height of the AVL tree
	 * @return the height or -1 if null;
	 */
	public int height()
	{
		return height(root);
	}

	/**
	 * Recursively finds the height of a starting node
	 * @param node	Starting node
	 * @return	The height
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
	 * Checks if the tree contains the target integer
	 * @param k	The target integer
	 * @return	True if tree contains the integer else false
	 */
	public boolean contains(int k)
	{
		return search(k) != null;
	}
	
	/**
	 * Search for the target integer from the root
	 * @param k	The target integer
	 * @return	The node containing the integer
	 */
	public BinaryNode<Integer> search(int k)
	{
		return search(root,k);
	}

	/**
	 * Recursively search for the target integer with a starting node
	 * @param node	The starting node
	 * @param k	The target integer
	 * @return	The node containing the integer or null
	 */
	public BinaryNode<Integer> search(BinaryNode<Integer> node, int k)
	{
		while(node != null)
		{
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
		return null;
	}

	/**
	 * Insert an integer to the tree
	 * @param n	the value to insert
	 */
	public void add(int n)
	{
		root = add(root, n);
	}

	/**
	 * Recursively insert an integer to the tree
	 * @param Node	the node to start the insertion
	 * @param toAdd	The integer to insert
	 * @return	The node of which the insertion occurs
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
		return balance(node);
	}

	/**
	 * Remove an integer from the tree
	 * @param toDelete	The integer to remove
	 */
	public void delete(int toDelete)
	{
		root = delete(root, toDelete);
	}

	/**
	 * Recursively removes an integer from the tree
	 * @param node	The starting node to check to remove
	 * @param toDelete	The integer to delete
	 * @return	The removed node
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
				return balance(node.getRight());
			}
			else if(node.getRight() == null)
			{
				return balance(node.getLeft());
			}
			else
			{
				node.setData(max(node.getLeft())); //gets the rightmost node of the left subtree
				node.setLeft(delete(node.getLeft(), (int)node.getData())); //delete the rightmost node of the left subtree
			}
		}
		return balance(node);
	}
	
	/**
	 * Finds the maximum integer of a subtree
	 * @param node	The starting node
	 * @return	The maximum integer
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
	 * Balances the AVL tree after each insertion and deletion
	 * @param node	The starting node to check balance
	 * @return	The node to do rotation to balance
	 */
	private BinaryNode<Integer> balance(BinaryNode<Integer> node)
	{
		if(node == null)
		{
			return null;
		}
		if(height(node.getLeft()) - height(node.getRight()) > 1)
		{
			if(height(node.getLeft().getRight()) >= height(node.getLeft().getRight()))
			{
				//System.out.println("Single Right Rotation: " + node.getData());
				node = singleRightRotation(node);
			}
			else
			{
				//System.out.println("Double Left-Right Rotation: " + node.getData());
				node = doubleLeftRightRotation(node);
			}
		}
		else if(height(node.getRight()) - height(node.getLeft()) > 1)
		{
			if(height(node.getRight().getRight()) >= height(node.getRight().getLeft()))
			{
				//System.out.println("Single Left Rotation: " + node.getData());
				node = singleLeftRotation(node);
			}
			else
			{
				//System.out.println("Double Right-left Rotation: " + node.getData());
				node = doubleRightLeftRotation(node);
			}
		}
		node.setHeight(Math.max(height(node.getLeft()), height(node.getRight()))  + 1);
		return node;
	}

	/**
	 * Single right rotation
	 * @param k2	The node to rotate
	 * @return	The successor node
	 */
	private BinaryNode<Integer> singleRightRotation(BinaryNode<Integer> k2)
	{
		BinaryNode<Integer> k1 = k2.getLeft();
		k2.setLeft(k1.getRight());
		k1.setRight(k2);
		k2.setHeight(Math.max(height(k2.getLeft()), height(k2.getRight())) + 1);
		k1.setHeight(Math.max(height(k1.getLeft()), k2.getHeight()) + 1);
		return k1;
	}

	/**
	 * Single left rotation
	 * @param k1	The node to rotate
	 * @return	The successor node
	 */
	private BinaryNode<Integer> singleLeftRotation(BinaryNode<Integer> k1)
	{
		BinaryNode<Integer> k2 = k1.getRight();
		k1.setRight(k2.getLeft());
		k2.setLeft(k1);
		k1.setHeight(Math.max(height(k1.getLeft()), height(k1.getRight())) + 1);
		k2.setHeight(Math.max(height(k2.getRight()), k1.getHeight()) + 1);
		return k2;
	}

	/**
	 * Double left right rotation
	 * @param k3	The node to rotate
	 * @return	The successor node
	 */
	private BinaryNode<Integer> doubleLeftRightRotation(BinaryNode<Integer> k3)
	{
		k3.setLeft(singleLeftRotation(k3.getLeft()));
		return singleRightRotation(k3);
	}

	/**
	 * Double right left rotation
	 * @param k1	The node to rotate
	 * @return	The successor node
	 */
	private BinaryNode<Integer> doubleRightLeftRotation(BinaryNode<Integer> k1)
	{
		k1.setRight(singleRightRotation(k1.getRight()));
		return singleLeftRotation(k1);
	}
	
	/**
	 * Checks to see if the tree is empty
	 * @return
	 */
	public boolean isEmpty()
	{
		return root == null;
	}
}
