import java.io.IOException;
import java.util.Arrays;

public class Placar extends java.lang.Object
{
	int pontuacaoTotal = 0;
	private int[] pontuacaoParcial; //Array para determinar a pontuação do jogador em cada uma das 10 casas possíveis
	private final int FREE = -1337; //Constante para determinar se determinada casa do placar já foi selecionada ou não
	public Placar()
	{
		pontuacaoParcial = new int[10];
		for(int i = 0; i < 10; i++) pontuacaoParcial[i] = FREE;
	}

	public void add(int posicao, int[] dados) throws java.lang.IllegalArgumentException
	{
		//Checando se a posição é válida e se está desocupada
		if(posicao < 1 || posicao > 10) throw new IllegalArgumentException("Posição Inválida amigão");
		if(pontuacaoParcial[posicao - 1] != FREE) throw new IllegalArgumentException("Posição Ocupada amigão");

		int i;
		int[] freq = new int[6]; //Array para determinar a frequencia de cada uma das 6 faces de um dado de 6 faces
		pontuacaoParcial[posicao - 1] = 0;

		if(posicao <= 6) 
		{
			for(i = 0; i < 5; i++) 
			{
				if(dados[i] == posicao) pontuacaoParcial[posicao - 1] += posicao;
			}
		}
		else if(posicao == 7)
		{
			for(i = 0; i < 5; i++) freq[dados[i] - 1]+=1;
			Arrays.sort(freq);
			if(freq[4] == 2 && freq[5] == 3) pontuacaoParcial[posicao - 1] = 15;
			else pontuacaoParcial[posicao - 1] = 0;
		}
		else if(posicao == 8)
		{
			for(i = 0; i < 5; i++) freq[dados[i] - 1]+=1;
			if(freq[0] == 1 && freq[1] == 1 && freq[2] == 1 && freq[3] == 1 && freq[4] == 1)
				pontuacaoParcial[posicao - 1] = 20;
			else if(freq[1] == 1 && freq[2] == 1 && freq[3] == 1 && freq[4] == 1 && freq[5] == 1)
				pontuacaoParcial[posicao - 1] = 20;
			else pontuacaoParcial[posicao - 1] = 0;
		}
		else if(posicao == 9)
		{
			for(i = 0; i < 5; i++) freq[dados[i] - 1]+=1;
			if(freq[0] >= 4 || freq[1] >= 4 || freq[2] >= 4 || freq[3] >= 4 || freq[4] >= 4 || freq[5] >= 4)
				pontuacaoParcial[posicao - 1] = 30;
			else pontuacaoParcial[posicao - 1] = 0;
		}
		else if(posicao == 10)
		{
			for(i = 0; i < 5; i++) freq[dados[i] - 1]+=1;
			if(freq[0] == 5 || freq[1] == 5 || freq[2] == 5 || freq[3] == 5 || freq[4] == 5 || freq[5] == 5)
				pontuacaoParcial[posicao - 1] = 40;
			else pontuacaoParcial[posicao - 1] = 0;
		}
	}

	public int getScore()
	{
		for(int i = 0; i < 10; i++) 
			if(pontuacaoParcial[i] != FREE) pontuacaoTotal += pontuacaoParcial[i];
		return pontuacaoTotal;
	}

	//Nesse método, o placar é desenhado horizontalmente, checando sempre os digitos de cada casa para sempre manter o alinhamento
	@Override
	public java.lang.String toString()
	{
		//Representação de um placa vazio
		//
		//"(1)    |   (7)    |   (4) \n";
		//"--------------------------\n";
		//"(2)    |   (8)    |   (5) \n";
		//"--------------------------\n";
		//"(3)    |   (9)    |   (6) \n";
		//"--------------------------\n";
		//"       |   (10)   |       \n";
		//"       +----------+       \n";

		String placar;
		if(pontuacaoParcial[0] == FREE) placar = "(1)    |";
		else placar = pontuacaoParcial[0] + "      |";

		if(pontuacaoParcial[6] == FREE) placar += "   (7)    |";
		else placar += "   " + pontuacaoParcial[6] + "     |";

		if(pontuacaoParcial[3] == FREE) placar += "   (4) \n";
		else 
		{
			if((pontuacaoParcial[3] / 10) == 0) placar += "   " + pontuacaoParcial[3] + "   \n";
			else placar += "   " + pontuacaoParcial[3] + "  \n";
		}
		placar += "--------------------------\n";

		if(pontuacaoParcial[1] == FREE) placar += "(2)    |";
		else 
		{
			if((pontuacaoParcial[1]) / 10 == 0) placar += pontuacaoParcial[1] + "      |";
			else placar += pontuacaoParcial[1] + "     |";
		}

		if(pontuacaoParcial[7] == FREE) placar += "   (8)    |";
		else placar += "   " + pontuacaoParcial[7] + "     |";

		if(pontuacaoParcial[4] == FREE) placar += "   (5) \n";
		else 
		{
			if((pontuacaoParcial[4] / 10) == 0) placar += "   " + pontuacaoParcial[4] + "   \n";
			else placar += "   " + pontuacaoParcial[4] + "  \n";
		}
		placar += "--------------------------\n";

		if(pontuacaoParcial[2] == FREE) placar += "(3)    |";
		else 
		{
			if((pontuacaoParcial[2]) / 10 == 0) placar += pontuacaoParcial[2] + "      |";
			else placar += pontuacaoParcial[2] + "     |";
		}

		if(pontuacaoParcial[8] == FREE) placar += "   (9)    |";
		else placar += "   " + pontuacaoParcial[8] + "     |";

		if(pontuacaoParcial[5] == FREE) placar += "   (6) \n";
		else 
		{
			if((pontuacaoParcial[5] / 10) == 0) placar += "   " + pontuacaoParcial[5] + "   \n";
			else placar += "   " + pontuacaoParcial[5] + "  \n";
		}
		placar += "--------------------------\n";

		if(pontuacaoParcial[9] == FREE) placar += "       |   (10)   |       \n";
		else placar += "       |   " + pontuacaoParcial[9] + "     |       \n";
		placar +="       +----------+       \n";

		return placar;
	}
}
