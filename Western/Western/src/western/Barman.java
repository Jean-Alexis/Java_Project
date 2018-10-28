/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package western;

import java.util.ArrayList;

/**
 *
 * @author JA
 */
public class Barman extends Civil{
    
    private String instrument;
    private ArrayList<Boisson> stock = new ArrayList();
    boolean estBraque;
    
    public Barman(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, boolean pSante, int pArgent, String pInstrument ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce, pSante, pArgent);
        this.instrument=pInstrument;
        this.estBraque=false;
        sePresenter();
    }
    
    public String getInstrument(){return this.instrument;}
    
    @Override
    public void sePresenter() {
        super.sePresenter();
        talk("Je suis un des meilleurs barman de la région, en plus de ça je suis musicien et joue du "+this.getInstrument());
    }
    
    public void ajouterBoisson(Boisson boisson){
        this.stock.add(boisson);
    }
    
    public void jouerInstrument(){
        System.out.println("Le barman "+this.getPrenom()+" se met à jouer du "+this.getInstrument()+" de façon divine !");
    }
 
}
