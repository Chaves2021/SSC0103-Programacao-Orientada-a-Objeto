import java.io.IOException;

public class PessoaJuridica extends Pessoa
{
	private double cnpj;
	private String razaoSocial;
	private String IE;		//inscrição estadual

	public void setCnpj(double c){ cnpj = c; }
	public double getCnpj(){ return cnpj; }

	public void setRazaoSocial(String razaoSocial){ this.razaoSocial = razaoSocial; }
	public String getRazaoSocial(){ return razaoSocial; }

	public void setIE(String IE){ this.IE = IE; }
	public String getIE(){ return IE; }

}
