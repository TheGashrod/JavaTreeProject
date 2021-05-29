package et3.java.projet.application;
//this is a test
import java.io.File;

import et3.java.projet.association.*;
import et3.java.projet.data.FileReader;
import et3.java.projet.municipalite.Municipalite;
import et3.java.projet.outils.*;

public class Main 
{
	/*TEST*/
	public static void main(String[] args) 
	{	
		Municipalite municipalite = new Municipalite();
		if(args.length > 0)
		{
			File tempFile = new File(args[0]);
			
			if(tempFile.exists())
			{
				System.out.println("[Main] Reading the file " + args[0] + " ...");
						
				//We start by reading the CSV file
				FileReader.getDataFromCSVFile(args[0], municipalite);
				
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
		
		

		//test que municipalite contient bien une liste avec tous les arbres
		System.out.println(municipalite.listeArbretoString());
		
		// test comparable date
//		Date t1 = new Date(2000, 07, 12);
//		Date t2 = new Date(2000, 07, 13);
////		
//		System.out.println(t2.compareTo(t1));
		
//		

//		Association association = new Association();
//		
//		association.ajouterEcritureComptable(new EcritureComptable(new Facture(1234), new Externe("Mairie 14ème", "75014", new TypeDonateur("Mairie", true)), "27/05/2021", +12.5));
//		
//		System.out.println(association.livreComptableToString());
		
	}
}
