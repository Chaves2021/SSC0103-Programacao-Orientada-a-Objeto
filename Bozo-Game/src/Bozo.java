import java.io.IOException;
public class Bozo
{
	public static void main(String[] args) throws java.io.IOException
	{
		int[] faces;
		RolaDados rd = new RolaDados(5);
		Placar placar = new Placar();
		String rolarAgain;
		int posicao;
		for(int i = 1; i <= 10; i++)
		{
			System.out.println(placar.toString());
			System.out.println("****** Rodada " + i);
			System.out.println("Pressione ENTER para lançar os dados");
			EntradaTeclado.leString();
			faces = rd.rolar();
			System.out.println(rd.toString());

			System.out.println("Digite os número de dados que quiser TROCAR. Separados por espaços");
			rolarAgain = EntradaTeclado.leString();
			faces = rd.rolar(rolarAgain);
			System.out.println(rd.toString());

			System.out.println("Digite os número de dados que quiser TROCAR. Separados por espaços");
			rolarAgain = EntradaTeclado.leString();
			faces = rd.rolar(rolarAgain);
			System.out.println(rd.toString());

			System.out.println("\n\n\n" + placar.toString());
			System.out.print("Escolha a posição que quer ocupar com essa jogada ===> ");
			posicao = EntradaTeclado.leInt();
			placar.add(posicao, faces);
		}
		System.out.println("\n\n\n" + placar.toString());
		System.out.println("**************************************");
		System.out.println("***");
		System.out.println("*** Seu escore final foi: "+ placar.getScore());
		System.out.println("***");
		System.out.println("**************************************");
	}
}
