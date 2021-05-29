package et3.java.projet.tests;

import java.util.Date;

import et3.java.projet.association.*;
import et3.java.projet.municipalite.*;
import et3.java.projet.data.*;

public class Main {

	public static void main(String[] args) 
	{		
//		if(args.length > 0)
//		{
//			File tempFile = new File(args[0]);
//			
//			if(tempFile.exists())
//			{
//				System.out.println("[Main] Reading the file " + args[0] + " ...");
//						
//				//We start by reading the CSV file
//				FileReader.getDataFromCSVFile(args[0]);
//				
//				System.out.println("[Main] End of the file " + args[0] + ".");
//			}
//			else
//			{
//				System.out.println("[Main] No file " + args[0]);
//			}
//		}
//		else
//		{
//			System.out.println("[Main] You should enter the CSV file path as a parameter.");
//		}
		
		
		Association association = new Association();
		
		association.insciptionMembre(new Membre("Doe", "John", "1 rue du bois, Paris", false, new Date(1998, 02, 12)));
		
		association.getMembres().get(0).payerCotisation(2021);
		
		System.out.println(association.livreComptableToString());
		
	}

}
