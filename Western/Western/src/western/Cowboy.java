/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package western;

import java.util.ArrayList;
/**
 *
 * @author robin JA
 */
public class Cowboy extends PeutBoireBar {
    
    /**
     * Constructeur d'un cowboy avec une position précise
     * @param pNom
     * @param pPrenom
     * @param pSurnom
     * @param pPosition
     * @param pAge
     * @param pArme
     * @param pForce
     * @param pArgent 
     */
    public Cowboy(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce, pArgent);
        sePresenter();
    }
    
    /**
     * Constructeur d'un cowboy sans position précise
     * @param pNom
     * @param pPrenom
     * @param pSurnom
     * @param pAge
     * @param pArme
     * @param pForce
     * @param pArgent 
     */
    public Cowboy(String pNom, String pPrenom, String pSurnom, int pAge,String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pArgent);
        sePresenter();
    }
    
    /**
     * Methode permettant au cowboy de se présenter
     */
    @Override
    public void sePresenter() {
        super.sePresenter();
        talk("Cowboy, plus rapide que moi, y'a pas.\n");
    }
    
    /**
     * Methode permettant d'afficher les informations d'un cowboy
     * @return 
     */
    @Override
    public String toString(){
        return this.getNom()+" "+this.getPrenom()+" "+this.getSurnom()+" "+this.getAge()+" "+this.getPosition()+" "+this.getArme()+" "+this.getForce()+" "+this.getArgent();
    }
    
    /**
     * Methode permettant au cowboy de sauver la dame si celle-ci a été kidnapée
     * @param dame Paramètre indiquant le nom de la Dame que l'on sauve
     */
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
