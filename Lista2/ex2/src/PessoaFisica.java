import java.io.IOException;

public class PessoaFisica
{
	private String name;
	private String birth;
	private double cpf;

	public void setName(String n){ name = n; }
	public String getName(){ return name; }

	public void setBirth(String b){ birth = b; }
	public String getBirth(){ return birth; }

	public void setCpf(double c){ cpf = c; }
	public double getCpf(){ return cpf; }
}
