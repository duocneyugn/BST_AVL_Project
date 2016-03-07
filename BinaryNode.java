/**
 * Data Structure and Algorithm Analysis
 * @author Duoc Nguyen
 * Models a Binary Node class
 * @param <Integer> Type of the class
 */
public class BinaryNode<Integer>
	{
		private Object data;
		private BinaryNode<Integer> left;
		private BinaryNode<Integer> right;
		private int height;
		
		/**
		 * Construct a binary node
		 * @param data Data of node
		 * @param left The left child node
		 * @param right the right child node
		 */
		public BinaryNode(Object data, BinaryNode<Integer> left, BinaryNode<Integer> right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		/**
		 * Construct a binary node with no child node
		 * @param data Data of node
		 */
		public BinaryNode(Object data)
		{
			this(data, null, null);
		}
		
		/**
		 * Gets the left child node
		 * @return Left child node
		 */
		public BinaryNode<Integer> getLeft()
		{
			return left;
		}
		
		/**
		 * Gets the right child node
		 * @return	Right child node
		 */
		public BinaryNode<Integer> getRight()
		{
			return right;
		}
		
		/**
		 * Sets the data of the node
		 * @param o The data to be set
		 */
		public void setData(Object o)
		{
			data = o;
		}
		
		/**
		 * Gets the data of the node
		 * @return the data
		 */
		public Object getData()
		{
			return data;
		}

		/**
		 * Sets the node to be the left child node
		 * @param node The node to set as the left child node
		 */
		public void setLeft(BinaryNode<Integer> node)
		{
			left = node;
		}

		/**
		 * Sets the node to be the right child node
		 * @param node The node to set as the right child node
		 */
		public void setRight(BinaryNode<Integer> node)
		{
			right = node;
		}

		/**
		 * Sets the height
		 * @param n The height to be set
		 */
		public void setHeight(int n)
		{
			height = n;
		}

		/**
		 * Gets the height
		 * @return The height
		 */
		public int getHeight()
		{
			return height;
		}
	}