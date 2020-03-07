import java.io.IOException;

public class Ex6
{
	public static void main(String [] args)
	{
		double number = 1;
		double lowestNumber = 0, highestNumber = 0;
		int counter = 0;
		while(number != 0)
		{
			try
			{
				System.out.println("Input a float number: ");
				number = EntradaTeclado.leDouble();
				if(counter == 0)
				{
					lowestNumber = highestNumber = number;
					counter++;
				}
				else
				{
					if(number < lowestNumber) lowestNumber = number;
					else if (number >=highestNumber) highestNumber = number;
				}
			}
			catch(Exception e)
			{
				System.out.println("Input a valid number");
			}
		};
		System.out.println("Highest number: " + highestNumber);
		System.out.println("Lowest number: " + lowestNumber);
	}
}
