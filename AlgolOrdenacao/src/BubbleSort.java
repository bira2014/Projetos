
public class BubbleSort {


	public static void main(String[] args)
	{
		int[] array =
		{ 8, 5, 3, 7, 2, 10, 1, 6, 4, 9 };
       
		System.out.println("*===================*");
		System.out.println("Antes:");
		imprimeArray(array);
		
		bubbleSort(array);
		System.out.println("\nDepois:");
		System.out.println("*===================*");
		imprimeArray(array);
	}

	private static void imprimeArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

	public static void bubbleSort(int[] array)
	{
		int n = array.length;
		boolean trocou = false;
		do
		{
			trocou = false;
			for (int i = 1; i < n; i++)
			{
				if (array[i - 1] > array[i])
				{
					int temp = array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
					trocou = true;
				}
			}
			n = n - 1;
		} while (trocou);

	}

}
