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
        sePresenter();
    }
    
    @Override
    public void sePresenter() {
        super.sePresenter();
        System.out.println("j'ai quand même "+plumes+" plumes, je suis beaucoup trop hype !! Un vrai indien sa mère");
    }
    
}
