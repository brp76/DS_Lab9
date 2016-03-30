import java.util.*;
import java.io.*;    

/**
 * Time how long it takes to sort an array of numbers.
 * 
 * @author Charles Hoot
 * @version 4.0
 */


public class TimeSort
{

	public static void main(String args[])
	{
		System.out.println("What size arrays should be sorted?");
		int size = getInt("Please enter an integer value greater than or equal to 0");

		System.out.println("How many arrays should be sorted (number of trials)?");
		int trials = getInt("Please enter an integer value greater than or equal to 0");

		System.out.println("What seed should be used for the random number generator?");
		int seed = getInt("Please enter an integer value greater than or equal to 0");

		final double MSECperSEC = 1000;

		// ADD A DECLARATION FOR THE VARIABLE quickSort500Ticks HERE


		long createTicks = timeArrayCreation(size, trials, seed);

		long quickSortTicks = timeBasicQuickSort(size, trials, seed) - createTicks;
		if(quickSortTicks < 0)
		{
			System.out.println("Warning: Array creation dominated");
			quickSortTicks = 0;
		}
		System.out.println("The time for basic quick sort was " + ((double)quickSortTicks)/trials/MSECperSEC + " seconds");
		System.out.println();
		
		
		// Version 2
		long ver2QuickSortTicks = timeVersion2QuickSort(size, trials, seed) - createTicks;
        if(ver2QuickSortTicks < 0)
        {
            System.out.println("Warning: Array creation dominated");
            ver2QuickSortTicks = 0;
        }
        System.out.println("The time for version 2 quick sort was " + ((double)ver2QuickSortTicks)/trials/MSECperSEC + " seconds");
        System.out.println("The time relative to basic quick sort is " + ((double)ver2QuickSortTicks)/quickSortTicks);
        
        
        // Version 3
        long ver3QuickSortTicks = timeVersion3QuickSort(size, trials, seed) - createTicks;
        if(ver3QuickSortTicks < 0)
        {
            System.out.println("Warning: Array creation dominated");
            ver3QuickSortTicks = 0;
        }
        System.out.println("The time for version 3 quick sort was " + ((double)ver3QuickSortTicks)/trials/MSECperSEC + " seconds");
        System.out.println("The time relative to basic quick sort is " + ((double)ver3QuickSortTicks)/quickSortTicks);
		
        
		/*** IGNORE ***/
		/*
		for (int i = 10; i<=200; i += 10) {
			System.out.println("---------- minSize = "+i+" ----------");
			SortArray.setQuickSortMinimumSize(i);
			long ver2QuickSortTicks = timeVersion2QuickSort(size, trials, seed) - createTicks;
			if(ver2QuickSortTicks < 0)
			{
				System.out.println("Warning: Array creation dominated");
				ver2QuickSortTicks = 0;
			}
			System.out.println("The time for version 2 quick sort was " + ((double)ver2QuickSortTicks)/trials/MSECperSEC + " seconds");
			System.out.println("The time relative to basic quick sort is " + ((double)ver2QuickSortTicks)/quickSortTicks);
		}*/

		/*
            long insertSortTicks = timeInsertionSort(size, trials, seed) - createTicks;
            if(insertSortTicks < 0)
            {
                System.out.println("Warning: Array creation dominated");
                insertSortTicks = 0;
            }
            System.out.println("The time for insertion sort was " + ((double)insertSortTicks)/trials/MSECperSEC + " seconds");
            System.out.println("The time relative to basic quick sort is " + ((double)insertSortTicks)/quickSortTicks);
            System.out.println();
		 */

		/*
            long mergeSortTicks = timeMergeSort(size, trials, seed) - createTicks;
            if(mergeSortTicks < 0)
            {
                System.out.println("Warning: Array creation dominated");
                mergeSortTicks = 0;
            }
            System.out.println("The time for merge sort was " + ((double)mergeSortTicks)/trials/MSECperSEC + " seconds");
            System.out.println("The time relative to basic quick sort is " + ((double)mergeSortTicks)/quickSortTicks);
		 */
		// MAKE MODIFICATIONS HERE TO TIME THE DIFFERENT ALGORITHMS        






	}

	public static long timeArrayCreation(int size, int trials, int seed)
	{

		// Created the random number generator and set the seed so it will always
		// generate the same sequence
		Random generator = new Random(seed);

		Integer toSort[] = new Integer[size];

		Calendar start = Calendar.getInstance();

		for(int i = 0; i< trials; i++)
		{
			// fill the array
			for(int j=0; j<size; j++)
			{
				toSort[j] = new Integer(generator.nextInt());
			}
		}

		Calendar end = Calendar.getInstance();
		long diff = end.getTime().getTime() - start.getTime().getTime();

		return diff;
	}

	public static long timeInsertionSort(int size, int trials, int seed)
	{

		// Created the random number generator and set the seed so it will always
		// generate the same sequence
		Random generator = new Random(seed);

		Integer toSort[] = new Integer[size];

		Calendar start = Calendar.getInstance();

		for(int i = 0; i< trials; i++)
		{
			// fill the array
			for(int j=0; j<size; j++)
			{
				toSort[j] = new Integer(generator.nextInt());
			}
			SortArray.insertionSort(toSort, size);
		}

		Calendar end = Calendar.getInstance();
		long diff = end.getTime().getTime() - start.getTime().getTime();

		return diff;
	}

	public static long timeMergeSort(int size, int trials, int seed)
	{

		// Created the random number generator and set the seed so it will always
		// generate the same sequence
		Random generator = new Random(seed);

		Integer toSort[] = new Integer[size];

		Calendar start = Calendar.getInstance();

		for(int i = 0; i< trials; i++)
		{
			// fill the array
			for(int j=0; j<size; j++)
			{
				toSort[j] = new Integer(generator.nextInt());
			}
			SortArray.mergeSort(toSort, size);
		}

		Calendar end = Calendar.getInstance();
		long diff = end.getTime().getTime() - start.getTime().getTime();

		return diff;
	}


	public static long timeBasicQuickSort(int size, int trials, int seed)
	{

		// Created the random number generator and set the seed so it will always
		// generate the same sequence
		Random generator = new Random(seed);

		Integer toSort[] = new Integer[size];

		Calendar start = Calendar.getInstance();

		for(int i = 0; i< trials; i++)
		{
			// fill the array
			for(int j=0; j<size; j++)
			{
				toSort[j] = new Integer(generator.nextInt());
			}
			SortArray.basicQuickSort(toSort, size);
		}

		Calendar end = Calendar.getInstance();
		long diff = end.getTime().getTime() - start.getTime().getTime();

		return diff;
	}


	// ADD NEW TIMING METHODS HERE

	public static long timeVersion2QuickSort(int size, int trials, int seed)
	{

		// Created the random number generator and set the seed so it will always
		// generate the same sequence
		Random generator = new Random(seed);

		Integer toSort[] = new Integer[size];

		Calendar start = Calendar.getInstance();

		for(int i = 0; i< trials; i++)
		{
			// fill the array
			for(int j=0; j<size; j++)
			{
				toSort[j] = new Integer(generator.nextInt());
			}
			SortArray.version2QuickSort(toSort, size);
		}

		Calendar end = Calendar.getInstance();
		long diff = end.getTime().getTime() - start.getTime().getTime();

		return diff;
	}
	
	public static long timeVersion3QuickSort(int size, int trials, int seed)
	{

		// Created the random number generator and set the seed so it will always
		// generate the same sequence
		Random generator = new Random(seed);

		Integer toSort[] = new Integer[size];

		Calendar start = Calendar.getInstance();

		for(int i = 0; i< trials; i++)
		{
			// fill the array
			for(int j=0; j<size; j++)
			{
				toSort[j] = new Integer(generator.nextInt());
			}
			SortArray.version3QuickSort(toSort, size);
		}

		Calendar end = Calendar.getInstance();
		long diff = end.getTime().getTime() - start.getTime().getTime();

		return diff;
	}

	/**
	 * Get an integer value
	 *
	 * @return     an integer 
	 */
	private static int getInt(String rangePrompt)
	{
		Scanner input;
		int result = 10;        //default value is 10
		try
		{
			input = new Scanner(System.in);
			System.out.println(rangePrompt);
			result = input.nextInt();

		}
		catch(NumberFormatException e)
		{
			System.out.println("Could not convert input to an integer");
			System.out.println(e.getMessage());
			System.out.println("Will use 10 as the default value");
		}        
		catch(Exception e)
		{
			System.out.println("There was an error with System.in");
			System.out.println(e.getMessage());
			System.out.println("Will use 10 as the default value");
		}
		return result;

	}
}
