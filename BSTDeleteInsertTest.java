import java.util.Random;
/**
 * Data Structure and Algorithms Analysis
 * @author Duoc Nguyen
 * Models a BST insertion and deletion printing test
 */
public class BSTDeleteInsertTest
{
	public static void main(String[] arg)
	{
		Random generator = new Random();
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		//Print a tree with height 5
		while(tree.height() != 5)
		{
			int d = 10 + generator.nextInt(99); //random number from 10 - 99;
			tree.add(d);
		}
		TreePrinter printer = new TreePrinter(tree);
		printer.print("BST of height 5");
		
		//Repeatedly delete the roots of tree
		while(!tree.isEmpty())
		{
			int root = (int)tree.getRoot().getData();
			tree.delete((int)tree.getRoot().getData());
			printer.print("Deleted root: " + root);
		}
	}
}
