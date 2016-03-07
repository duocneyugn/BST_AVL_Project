import java.util.Random;
/**
 * Data Structure and Algorithm Analysis
 * @author Duoc Nguyen
 * Models an AVL tree deletion test
 */
public class AVLTreeDeleteTest 
{

	public static void main(String[] arg)
	{
		//random message for git test
		Random generator = new Random();
		AVLTree<Integer> tree = new AVLTree<>();
		AVLTreePrinter printer = new AVLTreePrinter(tree);
		int[] uniqueRandomInts = new int[35];
		//Generate an AVL tree with 35 binary nodes
		for(int i = 0; i < 35; i++)
		{
			int d = 10 + generator.nextInt(99); //random number from 10 - 99;
			//getting unique integers
			boolean found = false;
			for(int k: uniqueRandomInts)
			{
				if(k == d)
				{
					found = true;
				}
			}
			if(!found)
			{
				uniqueRandomInts[i] = d; //saves the random integer
				tree.add(d);
				printer = new AVLTreePrinter(tree);
			}
		}
		System.out.println("The above operations are printed when each insertion makes the tree unbalance");
		//Repeatedly delete the root of the tree
		while(!tree.isEmpty())
		{
			int root = (int)tree.getRoot().getData();
			tree.delete((int)tree.getRoot().getData());
			printer.print("Deleted root: " + root);

		}
	}
}
