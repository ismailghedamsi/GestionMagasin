package gestionmagasin;
import java.util.*;

public class GestionMagasin{

	static Scanner sc = new Scanner(System.in); 
	public static void menu(){
		System.out.println("Choisissez parmi les options suivantes:");
		System.out.println("n : ajout d'un nouveau produit");
		System.out.println("f : afficher le nom d'un produit selon son numero d'indentification");
		System.out.println("d : effacer un produit de l'inventaire");
		System.out.println("q : quitter");
	}

	/**
	* Fonction appele lorsque l'option 'n' (nouveau produit) du menu est choisie. Puisque plusieurs lignes 
	* de code etaient associees a cette option, cela simplifiait et clarifiait le main de faire une fonction
	* pour cette option. 
	* @param mag , le magasin dans lequel on inserera le nouveau produit
	* @return void
	*/
	public static void createNouveauProduit(Magasin mag){
		String nomProduit;
		int idProduit;
		float prixProduit;
		
		System.out.println("Entrez le nom d'un nouveau produit: ");
		nomProduit = sc.next();

		System.out.println("Entrez le numero d'identification du produit : ");
		idProduit = sc.nextInt();
		
		System.out.println("Entrez le prix du produit : ");
		prixProduit = sc.nextFloat();
		boolean ajout = mag.addProduit(nomProduit, prixProduit, idProduit);
		//si l'inventaire du magasin est plein ou si le produit existe deja, il ne sera
		//pas ajoute au magasin et on affiche un message d'erreur
		if(!ajout)
			System.out.println("Impossible de creer le nouveau produit "+nomProduit);
		else{
			System.out.println("Produit ajoute ");
			System.out.println("*************************");
			System.out.println("Voici l'inventaire du magasin");
			System.out.println(mag);
			System.out.println("*************************\n\n\n");
		}
		
	
	}
	/**
	* Fonction main gerant le menu, et l'execution de chacune des options de ce dernier
	* @param args, les arguments a la ligne de commande (non utilise pour ce programme)
	* @return void
	*/
	public static void main(String[] args)
	{
		//creation d'un nouveau magasin
		Magasin mag = new Magasin("Dollarama", 500);
		
		
		char choix = 'n';
		int id;
		String nom;
		boolean ok;

		//on demande d'ajouter des nouveaux produits, jusqu'a ce que l'usager tape: "fin" 
		while(choix != 'q'){
			menu();
			choix = sc.next().charAt(0);
			switch(choix){
				case 'n'://nouveau produit
					createNouveauProduit(mag);
				break;
				case 'f'://trouve un produit selon son id et imprime son nom
					System.out.println("Entrez le numero d'identification du produit");
					id = sc.nextInt();
					nom = mag.getNomProduit(id);
					if(nom.length() == 0)
						System.out.println("Produit introuvable");
					else
						System.out.println("Le nom du produit: "+nom);
				break;
				case 'd': //retire un produit du magasin, selon son numero d'identification
					System.out.println("Entrez le numero d'identification du produit a retirer");
					id = sc.nextInt();
					ok = mag.removeProduit(id);
					if(ok)
						System.out.println("Le produit a ete retire");
					else
						System.out.println("Produit introuvable");
					System.out.println("Le magasin: ");
					System.out.println(mag);
					
				break;
				case 'q'://le programme se terminera
				break;
				default:
					System.out.println("Option invalide");
			}
		}
	}
}