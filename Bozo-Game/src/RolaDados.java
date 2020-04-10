import java.io.IOException

public class RolaDados
{
	private int n_dados, i;
	private Dado[] dados;
	private int[] faces;

	public RolaDados(int n)
	{
		this.n_dados = n;
		dados = new Dados[n_dados];
		faces = new int[n_dados];
	}

	public int[] rolar()
	{
		for(i = 0; i < n_dados; i++) 
		{
			dados[i].rolar();
			faces[i] = dados[i].lado;
			return faces;
		}
	}

	public int[] rolar(boolean[] quais)
	{
		for(i = 0; i < n_dados; i++)
		{
			if(quais[i] == true) 
			{
				dados[i].rolar();
				faces[i] = dados[i].lado;
			}
		}
		return faces;
	}

	public int[] rolar(java.lang.String s)
	{
		String[] rolagem = s.split(" ");
		for(String a : rolagem)
		{
			switch(a)
			{
				case "1":
					dados[0].rolar();
					faces[0] = dados[0].lado;
					break;
				case "2":
					dados[1].rolar();
					faces[1] = dados[1].lado;
					break;
				case "3":
					dados[2].rolar();
					faces[2] = dados[2].lado;
					break;
				case "4":
					dados[3].rolar();
					faces[3] = dados[3].lado;
					break;
				case "5":
					dados[4].rolar();
					faces[4] = dados[4].lado;
					break;
				case "6":
					dados[5].rolar();
					faces[5] = dados[5].lado;
					break;
				default:
					break;
			}
		}
		return faces;
	}

	@Override
	//TODO
	//Pesquisar sobre "Java Stream"
	public java.lang.String toString()
	{
	}
}
