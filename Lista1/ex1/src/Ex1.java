import java.io.IOException;

public class Ex1 
{
	public static void main(String args[]) throws IOException 
	{
		double x; //number to calculate square root
		double thought; //first thought of square root
		double error; //parameter to calculate errorr
		double sqrt; //real square root

		System.out.println("Value of X: ");
		x = EntradaTeclado.leDouble();
		System.out.println("First thought: ");
		thought= EntradaTeclado.leDouble();
		sqrt = 0.0; error = 0.0;
		do 
		{
			sqrt = (thought + (x / thought)) / 2;
			error = thought - sqrt;
			thought = sqrt;
		}while(error >= 0.00000001);
		System.out.println("Square root of " + x + " is " + sqrt);
	}
}
