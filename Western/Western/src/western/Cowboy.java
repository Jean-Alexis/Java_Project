/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package western;

/**
 *
 * @author robin JA
 */
public class Cowboy extends PeutBoireBar {
   
    //constructeur avec tous les champs du constructeur civil
    public Cowboy(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, boolean pSante, int pArgent ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce, pSante, pArgent);
        sePresenter();
    }
    
    //constructeur sans position
    public Cowboy(String pNom, String pPrenom, String pSurnom, int pAge,String pArme, int pForce, boolean pSante, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pSante, pArgent);
        sePresenter();
    }
    
    @Override
    public void sePresenter() {
        super.sePresenter();
        talk("Cowboy, plus rapide que moi, y'a pas.\n");
    }
    
    public void sauverDame(Dame dame){
        if(this.getSante()==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
        }
        else if(this.getPosition()!= dame.getPosition()){
            System.out.println("Les personnages doivent se trouver au même endroit pour intérragir");
        }
        else{
            this.talk("Me voici dame "+dame.getPrenom()+"! Je viens vous sauver !");
            dame.seFaireLiberer(this);
        }
    }
    
}
