import java.io.IOException
import java.util.Arrays;

public class Placar extends java.lang.Object
{
	private int[] pontuacaoParcial;
	private int final FREE = -1337;
	public Placar()
	{
		pontuacaoParcial = new int[10];
		for(int i = 0; i < 10; i++) pontuacaoParcial[i] = FREE;
	}

	//TODO
	//Revisar código, fiz com muito sono
	public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException
	{
		if(posicao < 1 || posicao > 10) throw new IllegalArgumentException("Posição Inválida amigão");
		if(pontuacaoParcial[posicao - 1] != FREE) throw new IllegalArgumentException("Posição Ocupada amigão");

		int[] freq = new int[6];
		pontuacaoParcial[posicao - 1] = 0;

		if(posicao <= 6) 
			for(int i = 0; i < 5; i++) 
				if(dado[i] == posicao) pontuacaoParcial[posicao - 1] += posicao;
		else if(posicao == 7)
		{
			for(int i = 0; i < 5; i++) freq[dado[i] - 1]++;
			Arrays.sort(freq);
			if(freq[3] == 2 && freq[4] == 3) pontuacaoParcial[posicao - 1] = 15;
			else pontuacaoParcial[posicao - 1] = 0;
		}
		else if(posicao == 8)
		{
			for(int i = 0; i < 5; i++) freq[dado[i] - 1]++;
			Arrays.sort(freq);
			if(freq[0] == 1 && freq[1] == 1 && freq[2] == 1 && freq[3] == 1 && freq[4] == 1)
				pontuacaoParcial[posicao - 1] = 20;
			else if(freq[1] == 1 && freq[2] == 1 && freq[3] == 1 && freq[4] == 1 && freq[5] == 1)
			else pontuacaoParcial[posicao - 1] = 0;
		}
		else if(posicao == 9)
		{
			for(int i = 0; i < 5; i++) freq[dado[i] - 1]++;
			//TODO
			//acho que é desne esse array sort
			Arrays.sort(freq);
			if(freq[0] == 4 || freq[1] == 4 || freq[2] == 4 || freq[3] == 4 || freq[4] == 4 || freq[5] == 4)
				pontuacaoParcial[posicao - 1] = 30;
			else pontuacaoParcial[posicao - 1] = 0;
		}
		else if(posicao == 10)
		{
			for(int i = 0; i < 5; i++) freq[dado[i] - 1]++;
			//TODO
			//acho que é desne esse array sort
			Arrays.sort(freq);
			if(freq[0] == 5 || freq[1] == 5 || freq[2] == 5 || freq[3] == 5 || freq[4] == 5 || freq[5] == 5)
				pontuacaoParcial[posicao - 1] = 40;
			else pontuacaoParcial[posicao - 1] = 0;
		}
	}

	public int getEscore()
	{
	}

	@Override
	public java.lang.String toString()
	{
	}
}
