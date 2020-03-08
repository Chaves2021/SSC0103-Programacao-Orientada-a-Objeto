import java.io.IOException;

public class Ex8
{
	public static void main(String [] args)
	{
		double x0; //first thought
		int loopIterations = 0; //loop counter
		double x1; //it's the next x
		double fx; //it's equivalent to f(x)
		boolean isRoot = false; //check if the X found is sufficient to be a root
		do
		{
			//Check if the input is within the conditions 
			try
			{
				System.out.println("Input a first thought");
				x0 = EntradaTeclado.leDouble();
				break;
			}catch(Exception e)
			{
				System.out.println("Input a valid number");
			}
		}while(true);
		do
		{
			x1 = x0 - (((Math.pow(x0,3)) - (Math.pow(x0,2)) - (13 * x0) + 8) /
								((3 * (Math.pow(x0,2))) - (2 * x0) -13));
			fx = (Math.pow(x1,3)) - (Math.pow(x1,2)) - (13 * x1) + 8;
			if(Math.abs(fx) < 0.0000001) isRoot = true;
			else x0 = x1;
			loopIterations++;
		}while(isRoot == false);
		System.out.println("The root is: " + x1);
		System.out.println("And the number of iterations is: " + loopIterations);
	}
}
