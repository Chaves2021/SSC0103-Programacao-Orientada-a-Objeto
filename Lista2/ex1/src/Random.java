import java.io.IOException;
import java.util.Calendar;

public class Random
{
	//Parameters to random number generator
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;

	//This is the seed
	//It is going to be replaced by the time using the calendar function
	private long xi = 1023;

	public double getRand()
	{
		xi = (a + m * xi) % p;
		//Casting xi (long) to double
		double d = xi;
		return d / p;
	}

	public int getIntRand(int max)
	{
		double d = getRand() * max;
		return (int) d;
	}
	//This i a constructor
	public Random()
	{
		xi = Calendar.getInstance().getTimeInMillis();
	}
}
