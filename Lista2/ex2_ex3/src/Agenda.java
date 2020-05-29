import java.io.IOException;
import java.util.ArrayList;

public class Agenda
{
	public static void main(String [] args)
	{
		ArrayList<Pessoa> p = new ArrayList<Pessoa>();
		int option = 0;
		do
		{
			System.out.println("##############################################");
			System.out.println("1- Show registers");
			System.out.println("2- Enter a register");
			System.out.println("3- Search a register");
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
					System.out.println("\nInvalid input\n");
				}
			}
			switch(option)
			{
				case 1:
					infoRegisters(p);
					break;
				case 2:
					addRegister(p);
					break;
				case 3:
					searchRegister(p);
					break;
				case 4:
					removeRegister(p);
					break;
				case 5:
					break;
				default:
					System.out.println("\nInvalid input\n");
			}
		}while(option != 5);
	}

	public static int printOptions()
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
				System.out.println("\nInvalid input\n");
			}
		}
		return option;
	}

	public static int findIndex(ArrayList<Pessoa> p, int option)
	{

		switch(option)
		{
			case 1:
				do
				{
					try
					{
						System.out.println("CPF: ");
						int search = EntradaTeclado.leInt();
						PessoaFisica pf = new PessoaFisica();
						for(int i = 0; i < p.size(); i++)
						{
							if(p.get(i) instanceof PessoaFisica)
							{
								pf = (PessoaFisica) p.get(i);
								if(pf.getCpf() == search)
									return i;
							}
						}
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
						System.out.println("CNPJ: ");
						int search = EntradaTeclado.leInt();
						PessoaJuridica pj = new PessoaJuridica();
						for(int i = 0; i < p.size(); i++)
						{
							if(p.get(i) instanceof PessoaJuridica)
							{
								pj = (PessoaJuridica) p.get(i);
								if(pj.getCnpj() == search)
									return i;
							}
						}
						break;
					}catch(Exception e)
					{
						System.out.println("\nInvalid input\n");
					}
				}while(true);
				break;
			default:
				System.out.println("\nNot Found\n");
		}
		return -1;
	}

	public static void removeRegister(ArrayList<Pessoa> p)
	{
		int option = printOptions();
		int index = findIndex(p, option);
		if(index != -1) 
		{
			p.remove(index);
			System.out.println("############## REGISTER REMOVED ##############");
		}
		else System.out.println("################### NOT FOUND ################");

	}

	public static void searchRegister(ArrayList<Pessoa> p)
	{
		int option = printOptions();
		int index = findIndex(p, option);
		if(index != -1 && option == 1)
		{
			Pessoa pe = p.get(index);
			System.out.println("############### FISICAL PERSON ###############");
			System.out.println("Name: " + pe.getName());
			System.out.println("Address: " + pe.getAddress());
			System.out.println("Email: " + pe.getEmail());
			PessoaFisica auxPf = (PessoaFisica) pe;
			System.out.println("CPF: " + auxPf.getCpf());
			System.out.println("Birth: " + auxPf.getBirth());
			System.out.println("Marital Status: " + auxPf.getES());
			System.out.println("##############################################");
		}
		else if(index != -1 && option == 2)
		{
			Pessoa pe = p.get(index);
			System.out.println("################ LEGAL PERSON ################");
			System.out.println("Name: " + pe.getName());
			System.out.println("Address: " + pe.getAddress());
			System.out.println("Email: " + pe.getEmail());
			PessoaJuridica auxPj = (PessoaJuridica) pe;
			System.out.println("CNPJ: " + auxPj.getCnpj());
			System.out.println("Corporate Name: " + auxPj.getRazaoSocial());
			System.out.println("State Registration: " + auxPj.getIE());
			System.out.println("##############################################");
		}
		else System.out.println("################### NOT FOUND ################");

	}

	public static void bubbleSort(ArrayList<Pessoa> p)
	{
		int i, j;
		boolean doSort = true;
		int index;
		Pessoa pAux = new Pessoa();

		PessoaFisica pf0 = new PessoaFisica();
		PessoaFisica pf1 = new PessoaFisica();

		PessoaJuridica pj0 = new PessoaJuridica();
		PessoaJuridica pj1 = new PessoaJuridica();
		//First put all the PessoaFisica before PessoaJuridica
		for(i = p.size() - 1; i >= 1 && doSort == true; i--)
		{
			doSort = false;
			for(j = 0; j < i; j++)
			{
				if((p.get(j) instanceof PessoaJuridica) == true && 
						(p.get(j+1) instanceof PessoaFisica) == true)
				{
					pAux = p.get(j);
					p.remove(j);
					p.add(j+1, pAux);
					doSort = true;
				}
			}
		}
		//Now order by cpf PessoaFisica
		doSort = true;
		for(i = p.size() - 1; i >= 1 && doSort == true; i--)
		{
			doSort = false;
			for(j = 0; j < i; j++)
			{
				if((p.get(j) instanceof PessoaFisica) == true && 
							(p.get(j+1) instanceof PessoaFisica) == true)
				{
					pf0 = (PessoaFisica) p.get(j);
					pf1 = (PessoaFisica) p.get(j+1);
					if(pf0.getCpf() > pf1.getCpf())
					{
						pAux = p.get(j);
						p.remove(j);
						p.add(j+1, pAux);
						doSort = true;
					}
				}
			}
		}
		//Now order by cnpj PessoaJuridica
		doSort = true;
		for(i = p.size() - 1; i >= 1 && doSort == true; i--)
		{
			doSort = false;
			for(j = 0; j < i; j++)
			{
				if((p.get(j) instanceof PessoaJuridica) == true && 
							(p.get(j+1) instanceof PessoaJuridica) == true)
				{
					pj0 = (PessoaJuridica) p.get(j);
					pj1 = (PessoaJuridica) p.get(j+1);
					if(pj0.getCnpj() > pj1.getCnpj())
					{
						pAux = p.get(j);
						p.remove(j);
						p.add(j+1, pAux);
						doSort = true;
					}
				}
			}
		}

	}

	public static void infoRegisters(ArrayList<Pessoa> p) {
		int i;
		PessoaFisica auxPf = new PessoaFisica();
		PessoaJuridica auxPj = new PessoaJuridica();

		for(Pessoa pe : p)
		{
			if((pe instanceof PessoaFisica) == true)
			{
				System.out.println("############### FISICAL PERSON ###############");
				System.out.println("Name: " + pe.getName());
				System.out.println("Address: " + pe.getAddress());
				System.out.println("Email: " + pe.getEmail());
				auxPf = (PessoaFisica) pe;
				System.out.println("CPF: " + auxPf.getCpf());
				System.out.println("Birth: " + auxPf.getBirth());
				System.out.println("Marital Status: " + auxPf.getES());
			}
			else if((pe instanceof PessoaJuridica) == true)
			{
				System.out.println("################ LEGAL PERSON ################");
				System.out.println("Name: " + pe.getName());
				System.out.println("Address: " + pe.getAddress());
				System.out.println("Email: " + pe.getEmail());
				auxPj = (PessoaJuridica) pe;
				System.out.println("CNPJ: " + auxPj.getCnpj());
				System.out.println("Corporate Name: " + auxPj.getRazaoSocial());
				System.out.println("State Registration: " + auxPj.getIE());
			}
			System.out.println("##############################################");
		}
		System.out.print("\n");
	}

	public static void addRegister(ArrayList<Pessoa> p)
	{
		int option = printOptions();
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

						System.out.println("Email: ");
						String e = EntradaTeclado.leString();
						f.setEmail(e);

						System.out.println("Birth: ");
						String b = EntradaTeclado.leString();
						f.setBirth(b);

						System.out.println("CPF: ");
						double c = EntradaTeclado.leDouble();
						f.setCpf(c);

						System.out.println("Address: ");
						String add = EntradaTeclado.leString();
						f.setAddress(add);

						System.out.println("Marital Status: ");
						String es = EntradaTeclado.leString();
						f.setES(es);

						p.add(f);
						bubbleSort(p);
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

						System.out.println("Email: ");
						String e = EntradaTeclado.leString();
						j.setEmail(e);

						System.out.println("Address: ");
						String a = EntradaTeclado.leString();
						j.setAddress(a);

						System.out.println("CNPJ: ");
						double c = EntradaTeclado.leDouble();
						j.setCnpj(c);

						System.out.println("Corporate Name: ");
						String rs = EntradaTeclado.leString();
						j.setRazaoSocial(rs);

						System.out.println("State Register: ");
						String ie = EntradaTeclado.leString();
						j.setIE(ie);

						p.add(j);
						bubbleSort(p);
						break;
					}catch(Exception e)
					{
						System.out.println("\nInvalid Input: \n");
					}
				}while(true);
				break;
			default:
				System.out.println("Invalid input");
		}
	}
}

