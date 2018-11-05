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
public class Barman extends Civil implements SestFaitFaucher{
    
    private String instrument;
    private ArrayList<Boisson> stock = new ArrayList();
    boolean estBraque;
    
    //constructeur avec tous les champs renseignés
    public Barman(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, int pArgent, String pInstrument ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce, pArgent);
        this.instrument=pInstrument;
        this.estBraque=false;
        sePresenter();
    }
    //constructeur sans position
    public Barman(String pNom, String pPrenom, String pSurnom, int pAge,String pArme, int pForce, int pArgent, String pInstrument ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pArgent);
        this.instrument=pInstrument;
        this.estBraque=false;
        super.setPosition(Position.BAR);
        sePresenter();
    }
    
    public String getInstrument(){return this.instrument;}
    
    public void setEstBraque(boolean estBraque){ this.estBraque=estBraque;}
    public boolean getEstBraque(){ return this.estBraque;}
    
    @Override
    public void sePresenter() {
        super.sePresenter();
        talk("Je suis un des meilleurs barman de la région, en plus de ça je suis musicien et joue du "+this.getInstrument()+"\n");
    }
    
    @Override
    public String toString(){
        return this.getNom()+" "+this.getPrenom()+" "+this.getSurnom()+" "+this.getAge()+" "+this.getPosition()+" "+this.getArme()+" "+this.getForce()+" "+this.getArgent()+" "+this.instrument;
    }
    
    public void ajouterBoisson(Boisson boisson){
        this.stock.add(boisson);
    }
    
    public void jouerInstrument(){
        System.out.println("Le barman "+this.getPrenom()+" se met à jouer du "+this.getInstrument()+" de façon divine !");
    }
    
    protected void presenterCarte(){
        
        System.out.println("Voici la carte des boissons :");
        for(int i=0; i<this.stock.size();i++){
            System.out.println(stock.get(i).getType()+" au prix de "+stock.get(i).getPrix()+"€");
        }
        System.out.println("");
    }
    
    protected boolean donnerBoisson(Boisson boisson){
        
        if (boisson.getQuantite()>0){
            this.talk("Vous avez de la chance, il m'en reste "+boisson.getQuantite());
            this.talk("Et voici votre boisson, un bon "+ boisson.getType()+", ça vous fera "+ boisson.getPrix()+"€" );
            boisson.setQuantite(boisson.getQuantite()-1);
            return true;
        }
        else{
            this.talk("Je n'ai plus de "+boisson.getType()+" voulez-vous autre chose ?");
            return false;
        }
    }
    
    //interface
    @Override
    public void seFaitBraquer(Brigand brigand){
        this.setEstBraque(true);
        this.talk("Vous ne vous en sortirez pas comme ça ! Mon bar c'est ma vie !");
        System.out.println("L'argent de "+this.getPrenom()+" passe de "+ this.getArgent() +" à 0.");
        this.setArgent(0);
        this.depression();
        
    }
    
    @Override
    public void depression(){
        
    }
    
    @Override
    public void videReserveAlcool(){
        
    }
 
}
