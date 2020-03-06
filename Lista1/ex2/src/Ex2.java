import java.io.IOException;

public class Ex2
{
	public static void main(String [] args)
	{
		int n = 0; //input number
		int i, j; //for counter
		try
		{
			System.out.println("Input a number: ");
			n = EntradaTeclado.leInt();
		}catch(Exception e)
		{
			System.out.println("You must digit an integer");
		}
		for(i = n; i > 0; i--)
		{
			for(j = i; j > 0; j--)
			{
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}
