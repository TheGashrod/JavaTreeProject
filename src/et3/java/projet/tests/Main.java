package et3.java.projet.tests;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import et3.java.projet.association.*;
import et3.java.projet.comptabilite.EcritureComptable;
import et3.java.projet.comptabilite.LivreComptable;
import et3.java.projet.municipalite.*;
import et3.java.projet.data.*;
import et3.java.projet.outils.*;

public class Main {

	public static void main(String[] args) throws Exception 
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
		
		Membre membre1 = new Membre("Doe", "John", "1 rue du bois, Paris", true, new Date(1998, 02, 12));
		Membre membre2 = new Membre("Doe", "Jane", "1 rue du bois, Paris", false, new Date(1999, 07, 03));
		

		
		// Inscription de membres 
		association.inscriptionMembre(membre1);
		association.inscriptionMembre(membre2);
		
		
		
		// Tous les membres payent leur cotisation
		for (Membre membre : association.getMembres().values()) {
			membre.payerCotisation(2021);
		}
		
//		// Afficher l'historique des transactions impliquant le membre
//		LivreComptable livreMembre1 = membre1.getHistorique();
//		System.out.println(livreMembre1);
		
		
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("1. Inscription d’un nouveau membre et désinscription d’un membre existant.");
		System.out.println("Liste des membres de l'associations : ");
		System.out.println(association.getMembres().values());
		
		System.out.println("Inscription d'un membre...");
		System.out.println();
		
		Membre membre3 = new Membre("Smith", "Paul", "24 avenue de la coline, Bordeaux", false, new Date(2000, 05, 29));
		association.inscriptionMembre(membre3);
		
		System.out.println("Liste des membres de l'associations : ");
		System.out.println(association.getMembres().values());
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("2. Recette de la cotisation d’un membre.");
		System.out.println("Livre Comptable de l'association : ");
		System.out.println(association.genererRapportActivite());
		
		System.out.println("Paiement de la cotisation par le membre...");
		System.out.println();
		
		// Vérifier que le membre a bien payé sa cotisation
		System.out.println("Cotisation payée ? : "+membre3.isCotisationPayee(2021));
		membre3.payerCotisation(2021);
		System.out.println("Cotisation payée ? : "+membre3.isCotisationPayee(2021));
		
		System.out.println("Livre Comptable de l'association : ");
		System.out.println(association.genererRapportActivite());
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("3. Paiement d’une facture reçue.");
		
		Facture facture = new Facture(123456);
		System.out.println("Paiement de la facture :"+facture);
		
		Externe edf = new Externe("EDF", "1 rue de la Paix, Paris", new TypeCompteExterne("Fournisseur electricite", true));
		
		System.out.println("Pour le compte de"+edf);
		association.getLivreComptable().ajouterEcritureComptable(new EcritureComptable(facture, edf, new Date(), 100), true);
		
		System.out.println("Livre Comptable de l'association : ");
		System.out.println(association.genererRapportActivite());
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("4. Ajout d’un nouveau donateur et suppression d’un donateur existant.");
		
		System.out.println("Liste Donateurs :");
		System.out.println(association.getExternes().values());
		
		Externe donateur = new Externe("Mairie", "Paris 14ème", new TypeCompteExterne("Mairie", true));
		System.out.println("Nouveau donateur : "+donateur);
		association.inscriptionExterne(donateur);
		
		System.out.println("Liste Donateurs :");
		System.out.println(association.getExternes().values());
		
		System.out.println("\n Suppression du donateur : "+donateur);
		association.desinscriptionExterne(donateur);
		
		System.out.println("Liste Donateurs :");
		System.out.println(association.getExternes().values());
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("5. Ajout d’une programmation de visite d’arbre remarquable et réception d’un compte-rendu pour une visite programmée.");
				
		System.out.println("Liste Visites :");
		System.out.println(association.getVisites().values());
		
		System.out.println("Liste des arbres remarquables triée par ancienneté de leur dernière visite : ");
		System.out.println(municipalite.getArbresRemarquablesOrderByVisite(association));
		
		System.out.println("Programmation visite : ");
		try {
			association.programmerVisite(new Visite(new Date(2021, 7, 30), municipalite.getArbre(112503)), membre3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Liste Visites de l'arbre :" + municipalite.getArbre(112503));
		System.out.println(association.getVisitesByArbre(municipalite.getArbre(112503)));
		
		System.out.println("Livre Comptable de l'association : ");
		System.out.println(association.genererRapportActivite());
		
		System.out.println("Ajout du compte rendu...");
		Visite visite = association.getVisitesByArbre(municipalite.getArbre(112503)).get(0);
		visite.setCompteRendu("Arbre en bon état génral");
		
		System.out.println(visite);
		
		System.out.println("Livre Comptable de l'association : ");
		System.out.println(association.genererRapportActivite());
		
		System.out.println("Modification du compte rendu...");
		visite.setCompteRendu("Arbre en bon état général");
		
		System.out.println(visite);
		
		System.out.println("Si le compte rendu est défini plusieurs fois la visite n'est défrayée qu'une seule fois");
		
		System.out.println("Livre Comptable de l'association : ");
		System.out.println(association.genererRapportActivite());
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("6. Vote d’un membre en faveur de la reconnaissance d’un arbre remarquable.");
		
		System.out.println("Liste des nominations du membre : "+membre1);
		System.out.println(membre1.getListeNominations());
		
		System.out.println("Nominations d'arbres par le membre");
		System.out.println(membre1.getListeNominations());
		
		membre1.nominerArbre(municipalite.getArbre(147441));
		membre1.nominerArbre(municipalite.getArbre(131050));
		membre1.nominerArbre(municipalite.getArbre(294889));
		membre1.nominerArbre(municipalite.getArbre(245713));
		membre1.nominerArbre(municipalite.getArbre(2031553));
		
		System.out.println("Liste des nominations du membre");
		System.out.println(membre1.getListeNominations());
		
		System.out.println("La nomination d'un 6ème arbre supprime le plus ancien choix");
		membre1.nominerArbre(municipalite.getArbre(212872));
		
		System.out.println("Liste des nominations du membre");
		System.out.println(membre1.getListeNominations());
		
		System.out.println("Nominations d'arbres par d'autres membres...");
		membre2.nominerArbre(municipalite.getArbre(212872));
		membre2.nominerArbre(municipalite.getArbre(294889));
		membre3.nominerArbre(municipalite.getArbre(194396));
		membre3.nominerArbre(municipalite.getArbre(213431));
		membre3.nominerArbre(municipalite.getArbre(132034));
		
		membre3.nominerArbre(municipalite.getArbre(212872));
		membre3.nominerArbre(municipalite.getArbre(131050));
		membre3.nominerArbre(municipalite.getArbre(194396));
		membre3.nominerArbre(municipalite.getArbre(251653));
		membre3.nominerArbre(municipalite.getArbre(227788));
		
		System.out.println("Liste des nominations du membre"+membre2);
		System.out.println(membre2.getListeNominations());
		
		System.out.println("Liste des nominations du membre"+membre3);
		System.out.println(membre3.getListeNominations());
		
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("7. Réception de notifications concernant la plantation ou l’abattage d’arbres ou la classification en arbre remarquable.");
		
		System.out.println("Liste des notifications : ");
		System.out.println(municipalite.getListeNotification());
		
		Float[] f = {48.906433f , 2.3493621f};
		Arbre arbre = new Arbre(911111187, "arbre", "domanialite", "ARRDT", "", "RUE ANDRE DANJON", 101001, "Noisetier de Byzance", "Corylus", "colurna","" ,
				 85, 10, "Adulte", false, f);
		
		System.out.println("Plantation nouvel arbre : "+arbre);
		try {
			municipalite.planterNouvelArbre(arbre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Liste des notifications : ");
		System.out.println(municipalite.getListeNotification());
		
		System.out.println("Classification de l'arbre en remarquable...");
		municipalite.classifierRemarquable(arbre);
		try {
			municipalite.abattreArbre(arbre);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Liste des notifications : ");
		System.out.println(municipalite.getListeNotification());
		
		System.out.println("Abattage de l'arbre");
		municipalite.abattreArbre(arbre);
		
		System.out.println("Liste des notifications : ");
		System.out.println(municipalite.getListeNotification());
		
		
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------");
		association.finExerciceBudgetaire(2021);
		
	}
	
}
