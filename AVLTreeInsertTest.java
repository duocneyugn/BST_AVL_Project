import java.util.Random;
/**
 * Data Structure and Algorithm Analysis
 * @author Duoc Nguyen
 * Models an AVL tree insertion and deletion test
 */
public class AVLTreeInsertTest 
{

	public static void main(String[] arg)
	{
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
				printer.print("Adding: " + d);
			}
		}
	}
}
