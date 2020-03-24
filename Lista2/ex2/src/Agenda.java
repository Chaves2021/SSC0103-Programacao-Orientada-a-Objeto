import java.io.IOException;
import java.util.ArrayList;

public class Agenda
{
	public static void main(String [] args)
	{
		ArrayList<PessoaFisica> pf = new ArrayList<PessoaFisica>();
		ArrayList<PessoaJuridica> pj = new ArrayList<PessoaJuridica>();
		int option = 0;
		do
		{
			System.out.println("##############################################");
			System.out.println("1- Show registers");
			System.out.println("2- Enter a register");
			System.out.println("3- Edit a register");
			System.out.println("4- Remove a register");
			System.out.println("5- Quit");
			System.out.println("##############################################");
			while(true)
			{
				try
				{
					option = EntradaTeclado.leInt();
					break;
				}catch(Exception e)
				{
					System.out.println("Invalid input");
				}
			}
			switch(option)
			{
				case 1:
					infoRegisters(pf, pj);
					break;
				case 2:
					addRegister(pf, pj);
					break;
				case 3:
					//editRegister(pf, pj);
					break;
				case 4:
					//removeRegister(pf, pj);
					break;
				case 5:
					break;
				default:
					System.out.println("Invalid input");
			}
		}while(option != 5);
	}
	public static void infoRegisters(ArrayList<PessoaFisica> pf, 
							ArrayList<PessoaJuridica> pj)
	{
		int i;
		for(i = 0; i < pf.size(); i++)
		{
			System.out.println("############### FISICAL PERSON ###############");
			System.out.println("Name: " + pf.get(i).getName());
			System.out.println("Birth: " + pf.get(i).getBirth());
			System.out.println("CPF: " + pf.get(i).getCpf());
			System.out.println("##############################################");
			System.out.print("\n");
		}
		for(i = 0; i < pj.size(); i++)
		{
			System.out.println("################ LEGAL PERSON ################");
			System.out.println("Name: " + pj.get(i).getName());
			System.out.println("Address: " + pj.get(i).getAddress());
			System.out.println("CNPJ: " + pj.get(i).getCnpj());
			System.out.println("##############################################");
			System.out.print("\n");
		}
	}
	public static void addRegister(ArrayList<PessoaFisica> pf, 
							ArrayList<PessoaJuridica> pj)
	{
		System.out.println("##############################################");
		System.out.println("1- Fisical Person");
		System.out.println("2- Legal Person");
		System.out.println("##############################################");
		int option = 0;
		while(true)
		{
			try
			{
				option = EntradaTeclado.leInt();
				break;
			}catch(Exception e)
			{
				System.out.println("Invalid input");
			}
		}
		switch(option)
		{
			case 1:
				do
				{
					try
					{
						PessoaFisica f = new PessoaFisica();
						System.out.println("Name: ");
						String n = EntradaTeclado.leString();
						f.setName(n);
						System.out.println("Birth: ");
						String b = EntradaTeclado.leString();
						f.setBirth(b);
						System.out.println("CPF: ");
						double c = EntradaTeclado.leDouble();
						f.setCpf(c);
						pf.add(f);
						break;
					}catch(Exception e)
					{
						System.out.println("\nInvalid input\n");
					}
				}while(true);
				break;
			case 2:
				do
				{
					try
					{
						PessoaJuridica j = new PessoaJuridica();
						System.out.println("Name: ");
						String n = EntradaTeclado.leString();
						j.setName(n);
						System.out.println("Address: ");
						String a = EntradaTeclado.leString();
						j.setAddress(a);
						System.out.println("CNPJ: ");
						double c = EntradaTeclado.leDouble();
						j.setCnpj(c);
						pj.add(j);
						break;
					}catch(Exception e)
					{
						System.out.println("\nInvalid input\n");
					}
				}while(true);
				break;
			default:
				System.out.println("Invalid input");
		}
	}
}

