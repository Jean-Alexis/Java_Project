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
    public void sePresenter(){
        super.sePresenter();
        talk("Je n'ai pas d'armes, mais moi au moins, j'ai une magnifique robe "+ this.couleurRobe+"\n");
    }
    
    public void seFaireEnlever (Homme brigand){
        if(brigand.getSante()==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
        }
        else if(this.getPosition()!= brigand.getPosition()){
            System.out.println("Les personnages doivent se trouver au même endroit pour intérragir");
        }
        else{
            this.estKidnappee = true;
        }
    	//Je pense qu'ici, en plus de dire qu'elle est kidnapée, on change enplus sa position en mettant la même que celle du brigand
    }
    
    public void seFaireLiberer (Homme homme){
        
        if(homme.getSante()==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
        }
        else if(this.getPosition()!= homme.getPosition()){
            System.out.println("Les personnages doivent se trouver au même endroit pour intérragir");
        }
        else{
            System.out.println("Oh, quel heros, "+homme.getPrenom()+"a reussi à me libérer de cette ordure, je ne l'en remercierai jamais assez");
            super.setPosition(Position.MAISON);
        }
    }
    
    
}

