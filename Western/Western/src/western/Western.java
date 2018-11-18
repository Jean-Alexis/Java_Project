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
    
    /*##############----DOCUMENTATION----#######################################
 
Generalites : 
- help(humain) 
- un personnage ne peut pas interragir s'il ne se trouve pas au meme endroit que l'autre personnage 
- un personnage ne peut interragir avec lui-meme 
- un personnage doit etre vivant pour faire une action 
- la force d'un personnage se trouve entre 0-10, 9 correspond a l'invicibilité 
- un combat entre deux personnages se fait avec la fonction combat(homme, homme) 
- a l'issue d'un combat, la personne tuee va au cimmetiere, on peut voir les personnes  
  au cimmetiere avec afficherCimmetiere(). 
- On peut faire renaitre un perso avec jesusDeNazareth(perso). 
- un personnage cree sans position spawn dans la RUE. 
- Un civil qui commande peut commander(et payer en meme temps) sa boisson,  
  tout depend de si toutes les conditions pour qu'il puissent boire soient remplies. 
- les personnages Civils peuvent se donner de l'argent. 
- un personnage ne peut negocier avec un autre qu'une seule fois 
- Tous les personnages peuvent annoncer leur position 
 
 
Le barman : 
 
Il possede nom, prenom, surnom, age, position, arme, force, argent, 
stock de boissons, instrument. 
Sa position de base est le BAR 
Il peut se presenter, se deplacer, il ne sait pas tirer ni negocier 
Il peut donner de l'argent et faire un pret au banquier 
Il peut ajouter des boissons a son stock, presenter sa carte, donner une boisson, jouer un instrument 
il peut se faire braquer et perdre tout son argent, dans ce cas il peut vider sa reserve d'alcool et a plus  
de chance de faire une depression 
Il peut decider de vider sa reserve d'alcool et a une faible chance de faire une depression 
 
L'indien : 
 
Il possede nom, prenom, surnom, age, position, arme, force, argent, plumes 
Sa postion est le CAMPEMENT 
Il peut se presenter, il reste au campement, il ne peut tirer que que cowboy ou brigand, il ne peut initier une negociation 
Le nombre de plumes d'un indien varie entre 1 et 20, son pouvoir d'augmentation de force est 
fonction de son nombre de plumes (+1 force si plume <13, +2 sinon), il y a 30% de chance que la negociation echoue. 
 
La Dame : 
 
Elle possede un nom, prenom, surnom, arge, position, couleur de robe 
Sa poisiton de base est la MAISON 
Elle peut se presenter, se faire enlever par un brigand, se faire liberer par un homme, et se faire sauver par un 
cowboy ou sherif 
 
Le Brigand : 
 
Il possede nom, prenom, surnom, age, position, arme, force, argent 
Sa position de base est le DESERT 
Il peut se presenter, se deplacer, il peut tirer sur n'importe quel homme 
il peut donner demander un pret au banquier, il peut donner de l'argent a un civil 
il peut demander la carte au barman, commander/payer une boisson 
il peut negocier une seule fois, avec un indien pour augmenter sa force, ou un sherif (il ira en prison) 
Il peut kidnapper une dame, braquer un banquier ou barman (recupere 30% du butin), se faire 
emprisonner par le sherif (va en prison), peut s'echapper de prison (se retrouve a RUE) 
 
Le Banquier : 
 
Il possede nom, prenom, surnom, age, position, arme, force, argent 
Sa position de base est la BANQUE 
Il peut se presenter, se deplacer, il ne sait pas tirer ni negocier 
il peut accorder un pret a un civil (sous certaines conditions) 
il peut donner demander un pret au banquier, il peut donner de l'argent a un civil 
il peut demander la carte au barman, commander/payer une boisson 
il peut se faire braquer et perdre tout son argent, dans ce cas il peut vider sa reserve d'alcool et a plus  
de chance de faire une depression 
Il peut decider de vider sa reserve d'alcool et a une faible chance de faire une depression 
 
Le sherif : 
 
Il possede nom, prenom, surnom, age, position, arme, force, argent 
Sa position de base est la PRISON 
Il peut se presenter, se deplacer, il ne peut tirer que sur un brigand, il ne sait pas n?gocier 
il peut donner demander un pret au banquier, il peut donner de l'argent a un civil 
il peut demander la carte au barman, commander/payer une boisson 
Il peut emprisonner un brigand 
 
Le cowboy : 
 
Il possede nom, prenom, surnom, age, position, arme, force, argent 
Sa position de base est la RUE 
Il peut se presenter, se deplacer, il ne peut tirer que sur un brigand, il peut negocier avec l'indien pour augmenter sa force 
il peut donner demander un pret au banquier, il peut donner de l'argent a un civil 
il peut demander la carte au barman, commander/payer une boisson 
Il peut sauver une Dame 
    
 #######################################################################################*/
    
    static ArrayList< Homme > cimmetiere = new ArrayList<>(); // tableau de personnes mortes
     
    public static void main(String[] args) {
        
        //création de la carte du barman
        Boisson leffe = new Boisson("Leffe", 0, 3);
        Boisson wisky = new Boisson("Wisky", 10, 8);
        Boisson cognac = new Boisson("cognac", 10, 8);
        Boisson rhum = new Boisson("Rhum", 10, 8);
         
        //Création des personnages
        Indien robin = new Indien("Ghys","Robin","Beau-goss",5,"Tokarev",5,19);
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
        
        
        joe.seDeplacer(Position.MAISON);
        joe.kidnapper(robinne);
        rody.seDeplacer(Position.DESERT);
        joe.annoncerArme();
        combat(rody, joe);
        rody.sauverDame(robinne);
        afficherCimmetiere();
        
        /*
       
        
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

