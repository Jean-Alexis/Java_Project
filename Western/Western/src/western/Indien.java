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
    
    public Indien( String pNom, String pPrenom, String pSurnom, int pAge, String pArme, int pForce,boolean pSante, int pPlumes) {
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pSante);
        this.plumes=pPlumes; 
        
    }
    
    @Override
    public void sePresenter() {
        super.sePresenter();
        talk("Tous les matins je brosse mes plumes ! "+plumes+" plumes à brosser tous les jours, ça prend du temps !");
    }
    
}
