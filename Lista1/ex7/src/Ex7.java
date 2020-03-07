import java.io.IOException;

public class Ex7
{
	public static void main(String [] args)
	{
		double a = 0, b = 0; //range borders
		double c; //medium value between a and b and possible root
		double fa, fb, fc; //equivalents to f(a), f(b) and f(c)
		boolean isDifferent = false; //boolean to check if a and b have different signals
		int loopIterations = 0; //loop counter
		do
		{
			//Check if the input is within the conditions 
			try
			{
				System.out.println("Input a: ");
				a = EntradaTeclado.leDouble();
				System.out.println("Input b: ");
				b = EntradaTeclado.leDouble();
				fa = (Math.pow(a,3)) - (Math.pow(a,2)) - (13 * a) + 8;
				fb = (Math.pow(b,3)) - (Math.pow(b,2)) - (13 * b) + 8;
				if(a != b || fa * fb < 0) isDifferent = true;
			}catch(Exception e)
			{
				System.out.println("Input a valid number");
			}
		}while(isDifferent == false);
		do
		{
			c = (a + b) / 2;
			fc = (Math.pow(c,3)) - (Math.pow(c,2)) - (13 * c) + 8;
			fa = (Math.pow(a,3)) - (Math.pow(a,2)) - (13 * a) + 8;
			fb = (Math.pow(b,3)) - (Math.pow(b,2)) - (13 * b) + 8;
			if(fc * fa > 0) a = c;
			else b = c;
			loopIterations++;
		}while(Math.abs(a - b) >= 0.0000001 && fc != 0);
		System.out.println("The root is: " + c);
		System.out.println("And the number of iterations is: " + loopIterations);
	}
}
