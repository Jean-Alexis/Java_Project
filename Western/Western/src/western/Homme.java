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
public abstract class Homme extends Humain {
    private String arme;
    private int force;
    private boolean sante;
    
    public Homme(String pNom, String pPrenom, String pSurnom, int pAge, String pArme, int pForce, boolean pSante )
    {
        super(pNom, pPrenom, pSurnom, pAge);
        this.arme=pArme;
        this.force=pForce;
        this.sante=pSante;
        //sePresenter();
    }
    
    @Override
    public void sePresenter() {
        super.sePresenter();
        talk(" Ca c'est bien un prénom de bonhomme ! En plus de ça, j'ai une "+arme+", pas mal comme arme hein ! Regarde, j'ai "+ force + " de force, pas mal hein !");
    }

    public void annoncerArme(){
        talk("Attention ! Je suis en possession d'un "+this.arme);
    }

    public int getForce(){
        return this.force;
    }
    
    public void setForce(String nom){
        this.nom=nom;
    }
    public void tirer(Homme personnage)

    
    
    
}
