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
    
    /**
     * Constructeur Indien avec position initiale au Campement
     * @param pNom
     * @param pPrenom
     * @param pSurnom
     * @param pAge
     * @param pArme
     * @param pForce
     * @param pPlumes 
     */
    public Indien( String pNom, String pPrenom, String pSurnom, int pAge, String pArme, int pForce, int pPlumes) {
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce);
        if(pPlumes<1 || pPlumes >20){
            System.out.println("Le nombre de plumes doit être compris entre 1 et 20");
        }
        else{ this.plumes=pPlumes;}
        this.setPosition(Position.CAMPEMENT);
        sePresenter();
        
    }

    /**
     * Accesseur du nombre de plumes
     * @return 
     */
    public int getPlumes(){return this.plumes;}
    

    /**
     * Se présenter mis à jour Indien
     */
    @Override
    public void sePresenter() {
        super.sePresenter();
        this.talk("Tous les matins je brosse mes plumes ! "+this.getPlumes()+" plumes a brosser tous les jours, ça prend du temps !\n");
    }
    /**
     * Afficher les caractéristiques de l'Indien
     * @return 
     */
    @Override
    public String toString(){
        return this.getNom()+" "+this.getPrenom()+" "+this.getSurnom()+" "+this.getAge()+" "+this.getPosition()+" "+this.getArme()+" "+this.getForce()+" "+this.getPlumes();
    }
}

