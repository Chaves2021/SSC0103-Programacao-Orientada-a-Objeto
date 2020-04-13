import java.io.IOException;
import java.util.Calendar;

public class Random
{
	//Parametros para geração de número randomico
	private long p = 2147483648L;
	private long m = 843314861;
	private long a = 453816693;

	//Essa é a semente
	private long xi;
	public void setSemente(int semente){ this.xi = semente; }

	public double getRand()
	{
		xi = (a + m * xi) % p;
		//Castando xi (long) para double
		double d = xi;
		return d / p;
	}

	public int getIntRand(int max)
	{
		double d = getRand() * max;
		return (int) d;
	}
	public Random()
	{
		//Seed estava dando overflow e ao dividir por 10 problema foi resolvido
		xi = Calendar.getInstance().getTimeInMillis() / 10;
	}
}
