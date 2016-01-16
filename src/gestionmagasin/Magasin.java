package gestionmagasin;


public class Magasin{
	/** DECLAREZ LES VARIABLES MEMBRES ICI **///OK
	private Produit[] mTabProduit;
	private int mNbProduits, mMaxCapacite;
	private String mNom;
	/**
	* Constructeur de la classe Magasin
	* @param pNom le nom du magasin
	* @param pMaxCapacite la capacite maximale du magasin
	*/
	public Magasin(String pNom, int pMaxCapacite){//OK
		mNom = pNom;
		mMaxCapacite = pMaxCapacite;
		mTabProduit = new Produit[mMaxCapacite];
		mNbProduits = 0;
	}
	/**
	* Fonction qui retourne une representation sous forme de String du magasin
	* Conseil: utilisez la fonction toString de la classe Produit
	* @return String la representation sous forme de chaine de caractere du magasin
	*/
	public String toString(){
		String representation = "";
		for(int i = 0; i<mNbProduits; i++){
			representation+=mTabProduit[i].toString()+"\n";
		}
		return representation;
	}
	/**
	* Fonction permettant de trouver l'index d'un produit dans le tableau de produit du magasin. 
	* La recherche se fait selon le numero d'identification du produit a trouver
	* Conseil: cette fonction est utilisee par beaucoup d'autres fonctions de cette classe, alors prenez la peine
	* 			de bien la debugger.
	* @param pId le numero d'identification du produit a chercher
	* @return int l'index du produit avec le numero d'identification id, -1 si le produit n'est pas dans le 
	*			  magasin
	*/
	public int findProduit(int pId){//OK
		for(int i = 0; i<mNbProduits; i++){
			if(mTabProduit[i].getIdentification() == pId){
				return i;
			}
		}
		return -1;
	}
	/**
	* Fonction permettant de retrouver le nom d'un produit selon son numero d'identification
	* Cette fonction est utilisée par l'option 'f' du menu propose dans GestionMagasin.java
	* Conseil: utilisez la fonction findProduit(int id). 
	* @param id le numero d'identification du produit a chercher
	* @return String le nom du produit a chercher. Cette fonction retourne la chaine de caracter vide "" si 
	* 		  le produit n'est pas present dans le magasin.
	*/
	public String getNomProduit(int id){//OK
		String nom;
		if(findProduit(id)==-1){
			return "";
		}
		else{
			nom = mTabProduit[findProduit(id)].getNom();
		}
		return nom;
	}
	/**
	* Fonction permettant d'ajouter un nouveau produit dans le magasin
	* Si un produit deja dans le magasin a le meme numero d'identification que le nouveau produit a ajouter, 
	* on n'ajoute pas de produit. Si le magasin est rempli, on n'ajoute pas le produit non plus
	* Conseil: Pensez a utiliser la fonction findProduit
	* @param pNom le nom du nouveau produit
	* @param pPrix le prix du nouveau produit
	* @param pId le numero d'identification du nouveau produit
	* @return boolean indique si l'ajout du nouveau produit a ete fait ou non
	* 
	*/
	public boolean addProduit(String pNom, float pPrix, int pId){//OK
		for(int i = 0; i<mNbProduits; i++){
			if(mTabProduit[i].getIdentification() == pId){
				return false;
			}
			else if(i == mMaxCapacite){
				return false;
			}
		}
		mTabProduit[mNbProduits] = new Produit(pNom, pPrix, pId);
		mNbProduits++;
		return true;
	}
	/**
	* Retire un produit ayant le numero d'identification pId. Si ce numero d'identification
	* n'est pas dans le magasin, on ne retire pas le produit.
	* Conseil: Utilisez la fonction findProduit 
	* @param pId le numero d'identification du produit a retirer du magasin
	* @return boolean indique si le produit a ete retire ou non.
	*/
	public boolean removeProduit(int pId){//OK
		if(findProduit(pId)==-1){
			return false;
		}
		else{
			for(int i = findProduit(pId); i<mNbProduits; i++){
				mTabProduit[i] = mTabProduit[i+1];
			}
			mNbProduits--;
		}
		return true;
	}
}