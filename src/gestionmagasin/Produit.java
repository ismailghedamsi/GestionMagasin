package gestionmagasin;
public class Produit{
	private String mNom;
	private float mPrix;
	private int mIdentification;
	
	public Produit(String pNom, float pPrix, int pIdentification){
		mNom = pNom;
		mPrix = pPrix;
		mIdentification = pIdentification;
	}
	public String getNom(){
		return mNom;
	}
	public float getPrix(){
		return mPrix;
	}
	public int getIdentification(){
		return mIdentification;
	}
	public String toString(){
		String representation = "";
		representation += mNom+":"+mIdentification+":"+mPrix;
		return representation;
	}
}