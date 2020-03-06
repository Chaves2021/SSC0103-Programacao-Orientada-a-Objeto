/*
	NOTE: Probably going by the end to the beggining was better, but i'm lazy :p
*/
import java.io.IOException;

public class Ex5
{
	public static void main(String [] args)
	{
		int i, j; //for counter
		int number = 0; //input number
		//1 isn't prime
		int last_prime = 2;
		boolean isPrime = false;
		while(true)
		{
			try
			{
				System.out.println("Enter a number: ");
				number = EntradaTeclado.leInt();
				break;
			}
			catch(Exception e)
			{
				System.out.println("Enter a valid number");
			}
		}
		if(number == 1) System.out.println("There is no prime before 1");
		else
		{
			for(i = 2; i < number; i++)
			{
				for(j = 2; j <= Math.sqrt(i); j++)
				{
					if(i % j == 0)
					{
						isPrime = false;
					}
				}
				if(isPrime)
				{
					last_prime = i;
					isPrime = false;
				}
				else isPrime = true;
			}
			System.out.println("The last prime before the number is: " + last_prime);
		}
	}
}
