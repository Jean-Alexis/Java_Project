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
    - on peut ajouter des type Boisson à la carte du Barman
    - La fonction combat ne marche que pour certaines combinaisons de persos
      (ex un invien ne tire que sur cowboy/brigand, un barman ne tire sur personne mais se défend).
    - Un civil qui commande peut commander(et payer en meme temps) sa boisson, 
      tout dépend de si toutes les conditions pour qu'il puissent boire soient remplies.
    - les personnages Civils peuvent se donner de l'argent.

    
    #######################################################################################*/
    
    static ArrayList< Homme > cimmetiere = new ArrayList<>(); // tableau de personnes mortes
     
    public static void main(String[] args) {
        
        //création de la carte du barman
        Boisson leffe = new Boisson("Leffe", 0, 3);
        Boisson wisky = new Boisson("Wisky", 10, 8);
        Boisson cognac = new Boisson("cognac", 10, 8);
        Boisson rhum = new Boisson("Rhum", 10, 8);
         
        //Création des personnages
        Indien robin = new Indien("Ghys","Robin","Beau-goss",-5,"Tokarev",5,19);
        Indien ja = new Indien("Hermel","JA","dieu",21,"pistolet",9,4);
        Indien leo = new Indien("denden","Leo","MichelT", 21, "pistolet a eau",5, 3);
        
        Dame robinne = new Dame("Ghyse","Robinne", "BellaCiao",20,"bleu");
        
        Cowboy rody = new Cowboy("Allen","Rody", "Le Gentil", Position.CAMPEMENT, 30, "44.magnum", 6, 40);

        Cowboy bill = new Cowboy("Clinton","Bill", "le prez",70, "revolver", 4, 200);

        
        Brigand joe = new Brigand("Dalton","Joe", "le Petit",Position.PRISON,35, "revolver", 6, 400);
        
        Barman bob= new Barman("Sauler","Bob","Bobby", 25, "fourchette", 0, 1500,"Piano");
        bob.ajouterBoisson(leffe);   bob.ajouterBoisson(wisky);    bob.ajouterBoisson(cognac);   bob.ajouterBoisson(rhum);
        
        Banquier cresus= new Banquier("Roschild","Crésus","richou", 38, "papier", 0, 200);
        
        Sherif dave = new Sherif("Moloss", "Dave", "le kid", 52, "flingue", 7, 300);
        System.out.println("");
        
        
        
        // ZONE DE TEST
       
       // leo.seDeplacer(Position.RUE);
        //newCowboy("robert","paro" , "dede", 0, "arme", 3, 40);
        //help(robin);
        //System.out.println(rody);
        joe.braquer(bob);
        bob.annoncerPosition();
        joe.seDeplacer(Position.BAR);
        joe.braquer(bob);
        joe.seDeplacer(Position.BANQUE);
        joe.demanderPret(cresus, 200);
        joe.braquer(cresus);
        joe.seDeplacer(Position.MAISON);
        joe.kidnapper(robinne);
        robinne.annoncerPosition();
        bill.seDeplacer(Position.RUE);
        bill.PayerBoisson(bob, 3);
        bill.seDeplacer(Position.BAR);
        bill.demanderBoisson(bob, wisky);
        bill.demanderBoisson(bob, wisky);
        dave.seDeplacer(Position.BAR);
        bill.demanderCarte(dave);
        robin.annoncerArme();
        robin.negocier(joe);
        joe.seDeplacer(Position.CAMPEMENT);
        cresus.seDeplacer(Position.CAMPEMENT);
        joe.negocier(cresus);
        joe.negocier(robin);
        joe.negocier(joe);
        bob.negocier(joe);
           


        
        
        /*
        
        joe.kidnapper(robinne);
        joe.seDeplacer(Position.MAISON);
        joe.kidnapper(robinne);
        robinne.seFaireLiberer(joe);
        joe.kidnapper(robinne);
        
        rody.setPosition(Position.DESERT);
        rody.sauverDame(robinne);
        rody.seDeplacer(Position.BAR);
       
        rody.demanderCarte(bob);
        rody.seDeplacer(Position.BAR);
        rody.demanderCarte(bob);
        rody.demanderBoisson(bob, leffe);
        rody.demanderBoisson(bob, cognac);
        
        bill.demanderBoisson(bob, cognac);
        //rody.PayerBoisson(bob, 30);
       
        combat(ja, leo);
        combat(ja, robin);
        combat(robin,leo);
        afficherCimmetiere();
        jesusDeNazareth(leo);
        afficherCimmetiere();
         
        woody.negocier(robin);
        bill.negocier(ja);
        bill.seDeplacer(Position.CAMPEMENT);
        bill.negocier(ja);
        
        */
        
    }
    
    public static void afficherCimmetiere (){
        System.out.println("Liste des personnes au cimmetiere :");
        for (int i = 0; i <cimmetiere.size(); i++) {
            System.out.println(cimmetiere.get(i).getPrenom()+"\n");
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
    
    public static Dame newDame(String nom, String prenom, String surnom, int age, String couleur){
        return (new Dame(nom,prenom, surnom,age,couleur));
    }
    public static Cowboy newCowboy(String nom, String prenom, String surnom, int age, String arme, int force, int argent ){
        return (new Cowboy(nom,prenom, surnom,age,arme,force,argent));
    }
    
     
    //fonction aide pour rappeler les commande disponibles sur un personnage
    public static void help(Humain humain){
        System.out.println("Commandes disponibles pour "+humain.getPrenom()+" :");
        if ((humain instanceof Indien)){
            System.out.println("sePresenter()\nannoncerArme()\ntirer(Homme)\nnegocier(Homme)\n");
        }
        else if ((humain instanceof Barman)){  
            System.out.println("sePresenter()\nannoncerArme()\nseDeplacer(Position)\ndonnerArgent(Civil,Argent)\ndemanderPret(Banquier,argent)\n"
                    +"ajouterBoisson(Boisson)\npresenterCarte()\njouerInstrument()\n");    
        }   
        else if ((humain instanceof Dame)){  
            System.out.println("sePresenter()\n");    
        }
        else if ((humain instanceof Brigand)){  
            System.out.println("sePresenter()\nannoncerArme()\ntirer(Homme)\nnegocier(Homme)\nseDeplacer(Position)\ndonnerArgent(Civil,Argent)\ndemanderPret(Banquier,argent)\n"
                    +"demanderBoisson(civil, boisson)\npayerBoisson(Civil,argent)\ndemanderCarte(Civil)\nkidnapper(Humain)\nechapper()\nbraquer(Civil)\n");    
        }
        else if ((humain instanceof Sherif)){  
            System.out.println("sePresenter()\nannoncerArme()\ntirer(Homme)\nseDeplacer(Position)\ndonnerArgent(Civil,Argent)\ndemanderPret(Banquier,argent)\n"
                    +"demanderBoisson(civil, boisson)\npayerBoisson(Civil,argent)\ndemanderCarte(Civil)\nemprisonner()\nliberer(Homme)\nrecompenser(Civil)\n");    
        }
        else if ((humain instanceof Cowboy)){  
            System.out.println("sePresenter()\nannoncerArme()\ntirer(Homme)\nseDeplacer(Position)\ndonnerArgent(Civil,Argent)\ndemanderPret(Banquier,argent)\n"
                    +"demanderBoisson(civil, boisson)\npayerBoisson(Civil,argent)\ndemanderCarte(Civil)\nsauverDame(Humain)\n");    
        }
        else if ((humain instanceof Banquier)){  
            System.out.println("sePresenter()\nannoncerArme())\nseDeplacer(Position)\ndonnerArgent(Civil,Argent)\ndemanderPret(Banquier,argent)\n"
                    +"demanderBoisson(civil, boisson)\npayerBoisson(Civil,argent)\ndemanderCarte(Civil)\naccorderPret(\n");    
        }
        else{
            System.out.println("Erreur de saisie type de personnage.");
        }
    }
   
    

}   

