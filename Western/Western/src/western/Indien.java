/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package western;

/**
 *
 * @author Robin
 */
public class Indien extends Homme {
    private int plumes;
    
    //l'indien spawn automatiquement au campement et ne peut pas se déplacer
    public Indien( String pNom, String pPrenom, String pSurnom, int pAge, String pArme, int pForce,boolean pSante, int pPlumes) {
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pSante);
        if(pPlumes<1 || pPlumes >20){
            System.out.println("Le nombre de plumes doit être compris entre 1 et 20");
        }
        else{ this.plumes=pPlumes;}
        this.setPosition(Position.CAMPEMENT);
        sePresenter();
        
    }

    public int getPlumes(){return this.plumes;}
    

    @Override
    public void sePresenter() {
        super.sePresenter();
        talk("Tous les matins je brosse mes plumes ! "+this.getPlumes()+" plumes à brosser tous les jours, ça prend du temps !\n");
    }
    
}
