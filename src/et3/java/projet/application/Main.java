package et3.java.projet.application;
//this is a test
import java.io.File;

import et3.java.projet.association.*;
import et3.java.projet.data.FileReader;

public class Main 
{
	/*TEST*/
	public static void main(String[] args) 
	{		
		if(args.length > 0)
		{
			File tempFile = new File(args[0]);
			
			if(tempFile.exists())
			{
				System.out.println("[Main] Reading the file " + args[0] + " ...");
						
				//We start by reading the CSV file
				FileReader.getDataFromCSVFile(args[0]);
				
				System.out.println("[Main] End of the file " + args[0] + ".");
			}
			else
			{
				System.out.println("[Main] No file " + args[0]);
			}
		}
		else
		{
			System.out.println("[Main] You should enter the CSV file path as a parameter.");
		}
		
//		
//		Association association = new Association();
//		
//		association.ajouterEcritureComptable(new EcritureComptable(new Facture(1234), new Externe("Mairie 14ème", "75014", new TypeDonateur("Mairie", true)), "27/05/2021", +12.5));
//		
//		System.out.println(association.livreComptableToString());
		
	}
}
