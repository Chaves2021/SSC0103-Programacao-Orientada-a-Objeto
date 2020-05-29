import java.io.IOException;

public class PessoaFisica extends Pessoa
{
	private double cpf;
	private String ES;	//Estado Civil
	private String birth;

	public void setCpf(double cpf){ this.cpf = cpf; }
	public double getCpf(){ return cpf; }

	public void setES(String ES){ this.ES = ES; }
	public String getES(){ return ES; }

	public void setBirth(String birth){ this.birth = birth; }
	public String getBirth(){ return birth; }
}
