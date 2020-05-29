import java.io.IOException;
import java.util.ArrayList;
public class Loja
{
	public static void main(String [] args) throws java.io.IOException
	{
		ArrayList<Produto> p = new ArrayList<Produto>();
		int option = 0;
		//Shows de Menu until user enter "5" to exit
		do
		{
			try
			{
				System.out.println("##############################################");
				System.out.println("1- Show Stock");
				System.out.println("2- Add Product");
				System.out.println("3- Search Product");
				System.out.println("4- Sell Product");
				System.out.println("5- Quit");
				System.out.println("##############################################");
				option = EntradaTeclado.leInt();
				switch(option)
				{
					case 1:
						infoStock(p);
						break;
					case 2:
						addProduct(p);
						break;
					case 3:
						searchProduct(p);
						break;
					case 4:
						sellProduct(p);
						break;
					case 5:
						break;
					default:
						System.out.println("\nInvalid input\n");
				}
			}
			catch(Exception e)
			{
				System.out.println("Invalid Input\n");
			}
		}while(option != 5);
	}

	//Print the option to show stock info by category or by product
	//Returns the option that the user chose
	public static int printInfoOptions() throws java.io.IOException
	{
		int option = 0;
		while(true)
		{
			try
			{
				System.out.println("##############################################");
				System.out.println("1- Category");
				System.out.println("2- Product");
				System.out.println("##############################################");

				option = EntradaTeclado.leInt();
				break;
			}catch(Exception e)
			{
				System.out.println("Invalid Input\n");
			}
		}
		return option;
	}

	//Print the option of Barcode or name
	public static int printOptions() throws java.io.IOException
	{
		System.out.println("##############################################");
		System.out.println("1- Barcode");
		System.out.println("2- Name");
		System.out.println("##############################################");

		int option = 0;
		option = EntradaTeclado.leInt();
		return option;
	}

	//Function to search by barcode or name an element of arraylist
	//Returns its index in the array
	public static int findIndex(ArrayList<Produto> p, int option) throws java.io.IOException
	{

		switch(option)
		{
			case 1:
				System.out.println("Barcode: ");
				int barcode = EntradaTeclado.leInt();
				for(int i = 0; i < p.size(); i++)
				{
					if(p.get(i).getBarcode() == barcode) return i;
				}
				break;
			case 2:
				System.out.println("Name: ");
				String name = EntradaTeclado.leString();
				for(int i = 0; i < p.size(); i++)
				{
					if(p.get(i).getName().equals(name)) return i;
				}
				break;
			default:
				System.out.println("\nInvalid Input\n");
		}
		return -1;
	}


	//Function to sell a product
	public static void sellProduct(ArrayList<Produto> p) throws java.io.IOException
	{
		//Here option is always 1, because you can only sell a product by its barcode
		int index = findIndex(p, 1);
		System.out.println("Quantity: ");
		int quantity = EntradaTeclado.leInt();
		if(index != -1) 
		{
			if(p.get(index) instanceof Livro)
			{
				Livro l = (Livro) p.get(index);
				int newQuantity = l.getQuantity() - quantity;
				if(newQuantity > 0) 
				{
					l.setQuantity(newQuantity);
					System.out.println("############### PRODUCT SOLD #################");
				}
				else if(newQuantity == 0) 
				{
					p.remove(index);
					System.out.println("############### PRODUCT SOLD #################");
				}
				else System.out.println("############ NOT ENOUGH STOCK ################");
			}
			else if(p.get(index) instanceof Cd)
			{
				Cd c = (Cd) p.get(index);
				int newQuantity = c.getQuantity() - quantity;
				if(newQuantity > 0) 
				{
					c.setQuantity(newQuantity);
					System.out.println("############### PRODUCT SOLD #################");
				}
				else if(newQuantity == 0) 
				{
					p.remove(index);
					System.out.println("############### PRODUCT SOLD #################");
				}
				else System.out.println("############ NOT ENOUGH STOCK ################");
			}
			else if(p.get(index) instanceof Dvd)
			{
				Dvd d = (Dvd) p.get(index);
				int newQuantity = d.getQuantity() - quantity;
				if(newQuantity > 0) 
				{
					d.setQuantity(newQuantity);
					System.out.println("############### PRODUCT SOLD #################");
				}
				else if(newQuantity == 0) 
				{
					p.remove(index);
					System.out.println("############### PRODUCT SOLD #################");
				}
				else System.out.println("############ NOT ENOUGH STOCK ################");
			}

		}
		else System.out.println("################### NOT FOUND ################");

	}

	//Function to display info of a particular Product or Category
	public static void searchProduct(ArrayList<Produto> p) throws java.io.IOException
	{
		int option = printOptions();
		int index = findIndex(p, option);
		if(index != -1)
		{
			Produto pr = p.get(index);
			System.out.println("Name: " + pr.getName());
			if(pr instanceof Dvd)
			{
				Dvd d = new Dvd();
				System.out.println("Category: DVD");
				System.out.println("Quantity: " + d.getQuantity());
			}
			else if(pr instanceof Cd)
			{
				Cd c = new Cd();
				System.out.println("Category: CD");
				System.out.println("Quantity: " + c.getQuantity());
			}
			else if(pr instanceof Livro)
			{
				Livro l = new Livro();
				System.out.println("Category: Book");
				System.out.println("Quantity: " + l.getQuantity());
			}
		}
		else System.out.println("################### NOT FOUND ################");
	}

	public static void infoStock(ArrayList<Produto> p) throws java.io.IOException
	{
		int option = printInfoOptions();
		switch(option)
		{
			case 1:
				//First print all the Books
				System.out.println("################## BOOKS ####################");
				for(Produto pr : p)
				{
					if(pr instanceof Livro)
					{
						System.out.println("Barcode: " + pr.getBarcode());
						System.out.println("Name: " + pr.getName());
						Livro l = new Livro();
						System.out.println("Category: Book");
						System.out.println("Quantity: " + l.getQuantity());
					}
					System.out.println("##############################################");
				}
				//Second print all the CDs
				System.out.println("################## CDs #######################");
				for(Produto pr : p)
				{
					if(pr instanceof Cd)
					{
						System.out.println("Barcode: " + pr.getBarcode());
						System.out.println("Name: " + pr.getName());
						Cd c = new Cd();
						System.out.println("Category: CD");
						System.out.println("Quantity: " + c.getQuantity());
					}
					System.out.println("##############################################");
				}
				//Third print all the DVDs
				System.out.println("################## DVDs ######################");
				for(Produto pr : p)
				{
					if(pr instanceof Dvd)
					{
						System.out.println("Barcode: " + pr.getBarcode());
						System.out.println("Name: " + pr.getName());
						Dvd d = new Dvd();
						System.out.println("Category: DVD");
						System.out.println("Quantity: " + d.getQuantity());
					}
					System.out.println("##############################################");
				}
				break;
			case 2:
				for(Produto pr : p)
				{
					System.out.println("Barcode: " + pr.getBarcode());
					System.out.println("Name: " + pr.getName());
					if(pr instanceof Dvd)
					{
						Dvd d = new Dvd();
						System.out.println("Category: DVD");
						System.out.println("Quantity: " + d.getQuantity());
					}
					else if(pr instanceof Cd)
					{
						Cd c = new Cd();
						System.out.println("Category: CD");
						System.out.println("Quantity: " + c.getQuantity());
					}
					else if(pr instanceof Livro)
					{
						Livro l = new Livro();
						System.out.println("Category: Book");
						System.out.println("Quantity: " + l.getQuantity());
					}
					System.out.println("##############################################");
				}
				break;
			default:
				System.out.println("Invalid Option");
		}
	}

	//This function is for an specific case to complement the add function
	//Here you already have the barcode
	//In the other function, the barcode is asked inside it, and cannot be retrivied, losing content
	public static int findIndexAdd(ArrayList<Produto> p, int barcode)
	{

		for(int i = 0; i < p.size(); i++)
		{
			if(p.get(i).getBarcode() == barcode) return i;
		}
		return -1;
	}

	//Function to add a product
	//If the barcode already exists, it will give an option to add more itens that have this barcode 
	public static void addProduct(ArrayList<Produto> p) throws java.io.IOException
	{
		int barcode;
		int index;
		while(true)
		{
			try{
				System.out.println("Barcode: ");
				barcode = EntradaTeclado.leInt();
				break;
			}catch(Exception e)
			{
				System.out.println("Invalid input\n");
			}
		}
		index = findIndexAdd(p, barcode);
		//If product already exists
		if(index != -1)
		{
			int quantity;
			while(true)
			{
				try{
					System.out.println("Product already exists! How many products would you like to add?");
					quantity = EntradaTeclado.leInt();
					break;
				}catch(Exception e)
				{
					System.out.println("Invalid Input");
				}
			}
			if(p.get(index) instanceof Livro)
			{
				Livro l = (Livro) p.get(index);
				l.setQuantity(l.getQuantity() + quantity);
			}
			if(p.get(index) instanceof Cd)
			{
				Cd c = (Cd) p.get(index);
				c.setQuantity(c.getQuantity() + quantity);
			}
			if(p.get(index) instanceof Dvd)
			{
				Dvd d = (Dvd) p.get(index);
				d.setQuantity(d.getQuantity() + quantity);
			}
		}
		//if product does not exists
		else
		{
			String name;
			int quantity;
			String category; 
			while(true)
			{
				try
				{
					System.out.println("Name: ");
					name = EntradaTeclado.leString();
					System.out.println("Quantity: ");
					quantity = EntradaTeclado.leInt();
					System.out.println("Category: (Book, DVD or CD)");
					category = EntradaTeclado.leString();
					break;
				}catch(Exception e)
				{
					System.out.println("Invalid Input\n");
				}
			}
			//Switch with strings can be done since jdk 8
			category = category.toUpperCase();
			switch(category)
			{
				case "BOOK":
					Livro l = new Livro();
					l.setName(name);
					l.setQuantity(quantity);
					p.add(l);
					System.out.println("Product added :)");
					break;
				case "DVD":
					Dvd d = new Dvd();
					d.setName(name);
					d.setQuantity(quantity);
					p.add(d);
					System.out.println("Product added :)");
					break;
				case "CD":
					Cd c = new Cd();
					c.setName(name);
					c.setQuantity(quantity);
					p.add(c);
					System.out.println("Product added :)");
					break;
				default:
					System.out.println("Invalid Category");
			}
		}

	}
}
