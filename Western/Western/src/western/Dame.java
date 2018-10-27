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
    public Dame(String pNom, String pPrenom, String pSurnom, int pAge, String pCouleurRobe){
    	super(pNom, pPrenom, pSurnom, pAge);
    	this.couleurRobe=pCouleurRobe;
        this.estKidnappee= false;
    	super.setPosition(Position.MAISON);
    	sePresenter();

    }
    //constructeur avec position
    public Dame(String pNom, String pPrenom,String pSurnom, int pAge,Position pPosition, String pCouleurRobe){
    	super(pNom, pPrenom,pSurnom, pPosition, pAge);
        this.estKidnappee=false;
    	this.couleurRobe=pCouleurRobe;
    	sePresenter();
    }
    
    @Override
    public void sePresenter()
    {
        super.sePresenter();
        talk("Je n'ai pas d'armes, mais moi au moins, j'ai une magnifique robe"+ this.couleurRobe);
    }
    
    public void seFaireEnlever (Homme brigand){
    	this.estKidnappee = true;
    	//Je pense qu'ici, en plus de dire qu'elle est kidnapée, on change enplus sa position en mettant la même que celle du brigand
    }
    
    public void seFaireLiberer (Homme homme)
    {
        System.out.println("Oh, quel heros, "+homme.getPrenom()+"a reussi à me libérer de cette ordure, je l'en remercierai jamais assez");
        super.setPosition(Position.MAISON);
    }
    
    
}

