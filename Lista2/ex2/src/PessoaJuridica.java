import java.io.IOException;

public class PessoaJuridica
{
	private String name;
	private String address;
	private double cnpj;

	public void setName(String n){ name = n; }
	public String getName(){ return name; }

	public void setAddress(String a){ address = a; }
	public String getAddress(){ return address; }

	public void setCnpj(double c){ cnpj = c; }
	public double getCnpj(){ return cnpj; }
}
