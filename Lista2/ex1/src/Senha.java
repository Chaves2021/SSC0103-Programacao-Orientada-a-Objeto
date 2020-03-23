import java.io.IOException;

public class Senha
{
	public static void main(String [] args)
	{
		boolean bool = false;
		int max = 0;
		int password = 0;
		int guess = 0;
		int counter = 0;
		while(bool != true)
		{
			try
			{
				System.out.println("Enter the max range of the password");
				max = EntradaTeclado.leInt();
				System.out.println("Enter your guess");
				guess = EntradaTeclado.leInt();
				counter++;
				bool = true;
			}catch(Exception e)
			{
				System.out.println("\nInvalid Input\n");
			}
		}
		Random random = new Random();
		password = random.getIntRand(max);
		while(guess != password)
		{
			System.out.println("You got the wrong password. Try Again!!");
			bool = false;
			while(bool != true)
			{
				try
				{
					guess = EntradaTeclado.leInt();
					counter++;
					bool = true;
				}catch(Exception e)
				{
					System.out.println("\nInvalid input\n");
				}
			}
		}
		System.out.println("You got the right password. Congrats!!");
		System.out.println("You just tried " + counter + " times");
	}
}
