package et3.java.projet.tests;

import java.io.File;
import java.util.Map;

import et3.java.projet.association.*;
import et3.java.projet.comptabilite.LivreComptable;
import et3.java.projet.municipalite.*;
import et3.java.projet.data.*;
import et3.java.projet.outils.*;

public class Main {

	public static void main(String[] args) 
	{		
		Municipalite municipalite = new Municipalite();
		
		// Importation des arbres depuis le csv
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
		
		// Afficher la liste des arbres importés
//		System.out.println(municipalite.listeArbretoString());
		
		
		Association association = new Association();
		
		
		Membre membre1 = new Membre("Doe", "John", "1 rue du bois, Paris", false, new Date(1998, 02, 12));
		
		// Inscription de membres 
		association.inscriptionMembre(membre1);
		association.inscriptionMembre(new Membre("Doe", "Jane", "1 rue du bois, Paris", false, new Date(1999, 07, 03)));
		association.inscriptionMembre(new Membre("Smith", "Paul", "24 avenue de la coline, Bordeaux", false, new Date(2000, 05, 29)));
		
		
//		// Tous les membres payent leur cotisation
//		for (Membre membre : association.getMembres()) {
//			membre.payerCotisation(2021);
//		}
//		
		for(Map.Entry<Integer, Membre > mapMembres : association.getMembres().entrySet()) {
			mapMembres.getValue().payerCotisation(2021);
		}
		
		
		
		
		// Vérifier que le membre a bien payé sa cotisation
		System.out.println(membre1.isCotisationPayee(2020));
		membre1.payerCotisation(2020);
		System.out.println(membre1.isCotisationPayee(2020));
		
		// Afficher l'historique des transactions impliquant le membre
		LivreComptable livreMembre1 = membre1.getHistorique();
		System.out.println(livreMembre1);
		
		// Nominations d'arbres par le membre
		System.out.println(membre1.getListeNominations());
		
		membre1.nominerArbre(municipalite.getMapArbre().get(147441));
		membre1.nominerArbre(municipalite.getMapArbre().get(131050));
		membre1.nominerArbre(municipalite.getMapArbre().get(294889));
		membre1.nominerArbre(municipalite.getMapArbre().get(245713));
		membre1.nominerArbre(municipalite.getMapArbre().get(2031553));
		
		System.out.println(membre1.getListeNominations());
		
		// La nomination d'un 6ème arbre supprime le plus ancien choix
		membre1.nominerArbre(municipalite.getMapArbre().get(212872));
		
		System.out.println(membre1.getListeNominations());
		
		
		
		
		
		//System.out.println(association.genererRapportActivite());
		
	}
	
}
