import java.io.IOException

public class RolaDados
{
	private int n_dados, i;
	private Dado[] dados;

	public RolaDados(int n)
	{
		this.n_dados = n;
		dados = new Dados[n_dados];
	}

	public int[] rolar()
	{
		int[] faces = new int[n_dados];
		for(i = 0; i < n_dados; i++) 
		{
			dados[i].rolar();
			faces[i] = dados[i].lado;
			return faces;
		}
	}

	public int[] rolar(boolean[] quais)
	{
	}

	public int[] rolar(java.lang.String s)
	{
	}

	@Override
	public java.lang.String toString()
	{
	}
}
