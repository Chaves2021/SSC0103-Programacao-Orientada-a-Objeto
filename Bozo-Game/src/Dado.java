import java.io.IOException

public class Dado extends java.lang.Object
{
	private int n_lados;
	private int lado;

	public int getLado() { return this.lado}

	public Dado() { this.n_lados = 6; }

	public Dado(int n) { this.n_lados = n; }

	public int rolar()
	{
		Random random = new Random();
		lado = random.getIntRand(n_lados) + 1;
	}

	@Override
	public java.lang.String toString()
	{
		String dado = "+-----+\n";
		switch(this.lado)
		{
			case 1:
				dado += "|     |\n";
				dado += "|  *  |\n";
				dado += "|     |\n";
				break;
			case 2:
				dado += "|    *|\n";
				dado += "|     |\n";
				dado += "|*    |\n";
				break;
			case 3:
				dado += "|    *|\n";
				dado += "|  *  |\n";
				dado += "|*    |\n";
				break;
			case 4:
				dado += "|*   *|\n";
				dado += "|     |\n";
				dado += "|*   *|\n";
				break;
			case 5:
				dado += "|*   *|\n";
				dado += "|  *  |\n";
				dado += "|*   *|\n";
				break;
			case 6:
				dado += "|*   *|\n";
				dado += "|*   *|\n";
				dado += "|*   *|\n";
				break;
			default:
				System.out.println("Só funciona com dados de 6 lados amigão");

		}
		dado += "+-----+\n";
		return dado;
	}

}
