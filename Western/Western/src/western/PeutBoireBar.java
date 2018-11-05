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
public class PeutBoireBar extends Civil{
    
    //constructeur avec tous les champs du constructeur civil
    public PeutBoireBar(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce, pArgent);
    }
    
    //constructeur sans position
    public PeutBoireBar(String pNom, String pPrenom, String pSurnom, int pAge,String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pArgent);
    }
    
    public void demanderCarte(Civil barman){
        
        if(this.getSante()==false || barman.getSante()==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
        }
        else if(this.getPosition()!=barman.getPosition()){
            System.out.println("Les personnages doivent se trouver au même endroit pour intérragir");
        }
        else{
            if(barman instanceof Barman){
                ((Barman) barman).presenterCarte();
            }
            else System.out.println("Desole vieux, je ne suis pas un barman");
        }
    }
    
    
    public void demanderBoisson(Civil barman, Boisson boisson){
 
        if(this.getSante()==false || barman.getSante()==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
        }
        else if( (this.getPosition()!=barman.getPosition()) || (this.getPosition()!= Position.BAR) ){
            System.out.println("Les deux personnages doivent se trouver au BAR pour demander une boisson");
        }
        else{
            if(barman instanceof Barman){ //on vérifie qu'on commande bien au barman
                if(this.getArgent()>=boisson.getPrix()){ // si on a assez d'argent
                    this.talk("Un "+boisson.getType()+" siou'plaît m'sieur !");
                    boolean peutDonner=((Barman) barman).donnerBoisson(boisson);
                    
                    if(peutDonner==true){ //si quantité suffisante
                        this.PayerBoisson(barman, boisson.getPrix());
                    }
                    else{
                        this.talk("Ah ! c'est plus ce que c'était ce bar ! je vais regarder.");
                    }
                }
                else { // si pas assez d'argent
                    System.out.println(this.getPrenom()+" n'a pas assez d'argent pour commander un "+boisson.getType()); 
                }
            }
            else{ //si on essaye de commander à un autre personnage qu'un barman
                System.out.println("Vous ne pouvez commander une boisson qu'au Barman.");
            }
        }
    }
    
    public void PayerBoisson(Civil barman, int argent){
        
        if(barman instanceof Barman){
            this.donnerArgent(barman, argent);
        }
        else{
            System.out.println(this.getPrenom()+" ne peut payer sa boisson qu'au barman");
        }
      
    }
    
    
}
