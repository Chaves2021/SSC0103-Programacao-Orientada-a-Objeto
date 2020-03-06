import java.io.IOException;

public class Ex4
{
	public static void main(String [] args)
	{
		int integer; //Number to check if is prime
		int i; //for counter
		int first_divisor = 1;
		boolean isPrime = true; //boolean to check if the number is prime
		boolean isValid = false; //boolean to check if the input matches to its type
		while(true)
		{
			try
			{
				System.out.println("Digit a number");
				integer = EntradaTeclado.leInt();
				isValid = true;
				break;
			}catch(Exception e)
			{
				System.out.println("Digit a valid input");
				System.out.print("\n");
			}
		}
		for(i = 2; i <= Math.sqrt(integer) && isPrime; i++)
		{
			if(integer % i == 0) 
			{
				isPrime = false;
				first_divisor = i;
			}
		}
		if(isPrime) System.out.println(integer + " is prime");
		else System.out.println(integer + " isn't prime and the first divisor is: " + first_divisor);
	}
}
