import java.io.IOException;

public class RolaDados
{
	private int n_dados, i;
	private Dado[] dados;
	private int[] faces;

	///Construtor inicializando variáveis da classe
	public RolaDados(int n)
	{
		this.n_dados = n;
		dados = new Dado[n_dados];
		faces = new int[n_dados];
		for(int i = 0; i < n_dados; i++)
		{
			dados[i] = new Dado();
		}
	}

	public int[] rolar()
	{
		for(int i = 0; i < n_dados; i++) 
		{
			dados[i].rolar();
			faces[i] = dados[i].getLado();
		}
		return faces;
	}

	public int[] rolar(boolean[] quais)
	{
		for(int i = 0; i < n_dados; i++)
		{
			if(quais[i] == true) 
			{
				dados[i].rolar();
				faces[i] = dados[i].getLado();
			}
		}
		return faces;
	}

	//A partir da JDK 8, é possível fazer switch case com strings, e assim não é necessário nenhum cast para esse método
	public int[] rolar(java.lang.String s)
	{
		String[] rolagem = s.split(" ");
		for(String a : rolagem)
		{
			switch(a)
			{
				case "1":
					dados[0].rolar();
					faces[0] = dados[0].getLado();
					break;
				case "2":
					dados[1].rolar();
					faces[1] = dados[1].getLado();
					break;
				case "3":
					dados[2].rolar();
					faces[2] = dados[2].getLado();
					break;
				case "4":
					dados[3].rolar();
					faces[3] = dados[3].getLado();
					break;
				case "5":
					dados[4].rolar();
					faces[4] = dados[4].getLado();
					break;
				default:
					break;
			}
		}
		return faces;
	}

	//Pegando as substrings dos dados para poder printa-los horizontalmente
	@Override
	public java.lang.String toString()
	{
		String s = "";
		for(int i = 0; i < 5; i++)
		{
			s += dados[0].toString().substring(i*8,(i+1)*8-1) + " ";
		        s += dados[1].toString().substring(i*8,(i+1)*8-1) + " ";
	                s += dados[2].toString().substring(i*8,(i+1)*8-1) + " ";
                        s += dados[3].toString().substring(i*8,(i+1)*8-1) + " ";
			s += dados[4].toString().substring(i*8,(i+1)*8-1) + " \n";
		}
		return s;
	}
}
