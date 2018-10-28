/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package western;

import java.util.ArrayList;

/**
 *
 * @author Robin JA
 */
public class Western {

    /**
     * @param args the command line arguments
     */
    
    /*######################   DOC   ########################################################
    
    - Echelle de force: 1 à 9             1-tres faible      4-moyenne      9-invincible.
    - On peut initier un combat avec combat(perso1,perso2), c'est le perso1 qui l'initie.
    - a l'issue d'un combat, la personne tuée va au cimmetiere, on peut voir les personnes 
      au cimmetiere avec afficherCimmetiere().
    - On peut faire renaitre un perso avec jesusDeNazareth(perso).
    - un personnage créé dans position spawn dans la RUE.
    - Le nombre de plumes d'un indien varie entre 1 et 20, son pouvoir d'augmentation de force est
      fonction de son nombre de plumes (+1 force si plume <13, +2 sinon), il y a 30% de chance que la négociation echoue.
    
    #######################################################################################*/
    
    static ArrayList< Homme > cimmetiere = new ArrayList<>(); // tableau de personnes mortes
    
    public static void main(String[] args) {
        
        //Création des personnages
        Indien robin =new Indien("Ghys","Robin","Beau-goss",20,"Tokarev",5,true,19);
        Indien ja =new Indien("Hermel","JA","dieu",21,"pistolet",9,true,4);
        Indien leo = new Indien("denden","Leo","MichelT", 21, "pistolet a eau",5, true, 3);
        Dame robinne = new Dame("Ghyse","Robinne", "BellaCiao",20,"bleu");
        Cowboy woody = new Cowboy("Allen","Woody", "Le Gentil", Position.CAMPEMENT, 30, "44.magnum", 6, true, 2000);
        Cowboy bill = new Cowboy("Clinton","Bill", "le prez", 70, "revolver", 4, true, 200);
        
        Barman bob= new Barman("Sauler","Bob","Bobby", Position.BAR, 25, "fourchette", 0, true, 1500,"Piano");
        bob.ajouterBoisson(new Boisson("Leffe", 10, 3));
        bob.ajouterBoisson(new Boisson("Wisky", 10, 8));
        
        System.out.println("");
           
        ja.negocier(woody);
        
        
        woody.negocier(robin);
        bill.negocier(ja);
        bill.seDeplacer(Position.CAMPEMENT);
        bill.negocier(ja);
        
     
        
        
        /*
        combat(ja, leo);
        combat(ja, robin);
        combat(robin,leo);
        afficherCimmetiere();
        jesusDeNazareth(leo);
        afficherCimmetiere();
        */
        
       
    }
    
    public static void afficherCimmetiere (){
        System.out.println("personnes mortes :");
        for (int i = 0; i <cimmetiere.size(); i++) {
            System.out.println(cimmetiere.get(i).getPrenom());
        }
    }
    
    public static void combat (Homme homme1,Homme homme2){
        int combat = homme1.tirer(homme2);
        if (combat==1){cimmetiere.add(homme2);}
        else if(combat==0){cimmetiere.add(homme1);}
    }
    
    public static void jesusDeNazareth (Homme homme){
        System.out.println(homme.getPrenom()+" renait de ses cendres.");
        homme.setSante(true);
        for(int i=0;i<cimmetiere.size();i++) {
            if(cimmetiere.get(i).equals(homme)) {
                cimmetiere.remove(i);
            }
        }
    }
    

}   

