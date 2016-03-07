import java.util.Random;
/**
 * Data Structure and Algorithms Analysis
 * @author Duoc Nguyen
 * Models a performance test among BST and AVL tree
 */
public class PerformaceTest 
{
	public static void main(String[] arg)
	{
		Random generator = new Random();
		long start = 0;
		long stop = 0;
		BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
		AVLTree2<Integer> AVLTree = new AVLTree2<Integer>();
		
		//Testing for time efficiency of trees inserting 
		int n = 10000;
		int[] randomN = new int[n];
		for(int i = 0; i < n; i++)
		{
			randomN[i] = 10 + generator.nextInt(n);
		}
		start = System.currentTimeMillis();
		for(int i = 0; i < n; i++)
		{
			BST.add(randomN[i]);
		}
		stop = System.currentTimeMillis();

		System.out.print("Time duration to add " + n + " random integers to BST: ");
		System.out.println(stop - start + " Millis");

		start = System.currentTimeMillis();
		for(int i = 0; i < n; i++)
		{
			AVLTree.add(randomN[i]);
		}
		stop = System.currentTimeMillis();

		System.out.print("Time duration to add " + n + " same random integers to AVL Tree: ");
		System.out.println(stop - start + " Millis");

		//Testing for time efficiency of trees searching
		int k = 100000;
		int[] randomK = new int[k];
		
		for(int i = 0; i < k; i++)
		{
			randomK[i] = 10 + generator.nextInt(k);
		}
		start = System.currentTimeMillis();
		for(int i = 0; i < k; i++)
		{
			BST.contains(randomK[i]);
		}
		stop = System.currentTimeMillis();

		System.out.print("Time duration to search " + k + " random k integers of " + n + "-node BST: ");
		System.out.println(stop - start + " Millis");

		start = System.currentTimeMillis();
		for(int i = 0; i < k; i++)
		{
			AVLTree.contains(randomK[i]);
		}
		stop = System.currentTimeMillis();

		System.out.print("Time duration to search " + k + " same random K integers to same " + n + "-node AVL Tree: ");
		System.out.println(stop - start + " Millis");
	}
}
