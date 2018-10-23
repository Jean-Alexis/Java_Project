/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package western;

/**
 *
 * @author ISEN
 */
public class Dame extends Humain {
    private String couleurRobe; 
    private boolean estKidnappee;

    //contructeur sans position -> de base spawn dans la maison
    public Dame(String pNom, String pPrenom, int pAge, String pCouleurRobe){
    	super(pNom, pPrenom, pAge);
    	this.couleurRobe=pCouleurRobe;
    	this.position= Position.MAISON;

    	sePresenter();

    }
    //constructeur avec position
    public Dame(String pNom, String pPrenom, int pAge,Position pPosition, String pCouleurRobe){
    	super(pNom, pPrenom, pAge, pPosition);
    	this.couleurRobe=pCouleurRobe;

    	sePresenter();
    }
    

    public void seFaireEnlever (Brigand brigand){
    	
    }
}
