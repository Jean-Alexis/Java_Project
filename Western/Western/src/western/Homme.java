/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package western;

/**
 *
 * @author Robin, Jean-Alexis
 */
public abstract class Homme extends Humain {
    private String arme;
    private int force;
    private boolean sante;
    private boolean aNegocie;
    
    
    /**
     * Constructeur Homme avec tout les champs du constructeur Humain
     * @param pNom
     * @param pPrenom
     * @param pSurnom
     * @param pPosition
     * @param pAge
     * @param pArme
     * @param pForce 
     */
    public Homme(String pNom, String pPrenom, String pSurnom, Position pPosition, int pAge, String pArme, int pForce ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge);
        this.sante=true;
        this.arme=pArme;
        try{
            if(pForce <0 || pForce>10){
                throw new Exception("La force d'un perso doit etre entre 0 et 10");
            }
            else{
               this.force=pForce;;
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
       
        this.aNegocie=false;
        
    }
    /**
     * Constructeur Homme sans position
     * @param pNom
     * @param pPrenom
     * @param pSurnom
     * @param pAge
     * @param pArme
     * @param pForce 
     */
    public Homme(String pNom, String pPrenom,String pSurnom, int pAge, String pArme, int pForce) {
        super(pNom, pPrenom, pSurnom, pAge);
        this.arme = pArme;
        try{
            if(pForce <0 || pForce>10){
                throw new Exception("La force d'un perso doit etre entre 0 et 10");
            }
            else{
               this.force=pForce;;
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        this.sante = true;
        this.aNegocie= false;
        
    }
    
    /**
     * Methode sePresenter mis à jour pour un homme
     */
    @Override
    public void sePresenter() {
        super.sePresenter();
        talk("Ca c'est bien un prenom de bonhomme ! En plus de ca, j'ai une "+
                arme+", pas mal comme arme hein ! Regarde, j'ai "+ force + " de force, pas mal hein !");
    }

    /**
     * Methode permettant d'annoncer l'arme de la personne concernée
     */
    public void annoncerArme(){
        if(this.sante==false){
            System.out.println("Eh oh je suis mort, je peux pas parler lol");
        }
        else { 
            talk("Attention ! Je suis en possession d'un " + this.arme);
            }
        
    }

    /**
     * Accesseur permettant de renvoyer la force
     * @return 
     */
    public int getForce(){return this.force;}
    
    /**
     * Mutateur permettant de modifier la force d'un homme
     * @param force 
     */
    public void setForce(int force){
        try{
            if(force <0 || force>10){
                throw new Exception("La force d'un perso doit etre entre 0 et 10");
            }
            else{
               this.force=force;;
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    /**
     * Accesseur d'Arme
     * @return 
     */
    public String getArme(){return this.arme;}
    
    /**
     * Accesseur de Sante
     * @return 
     */
    public boolean getSante(){return this.sante;}
    /**
     * Mutateur de sante
     * @param sante 
     */
    public void setSante(boolean sante){this.sante=sante;}

    /**
     * Acceseur du booleén aNegocie
     * @return 
     */
    public boolean getANegocie(){return this.aNegocie;}
    /**
     * Mutateur du booléen aNegocie
     * @param aNegocie 
     */
    public void setANegocie(boolean aNegocie){this.aNegocie=aNegocie;}
    
    
    /**
     * Methode permettant de tirer sur un personnage (un homme contre un homme)
     * @param personnage personnage correspond à la personne qui va se faire tirer dessus ;
     * @return Cette méthode retourne -1 si une erreur se produit lors de l'exécution de celle-ci; retourne 1 si celui-qui est à l'origine de l'appel de la fonction gagne ;
     * retourne 0 si celui-qui a "subi" l'attaque/si personnage remporte le combat.
     */
    public int tirer(Homme personnage){
        if(this.sante==false || personnage.sante==false){
            System.out.println("Un des personnages est deja mort, ils ne peuvent se tirer dessus !");
            return -1;
        }
        else if(this.getPosition()!= personnage.getPosition() ){
            System.out.println("Les deux personnages doivent se trouver au meme endroit pour se tirer dessus");
            return -1;
        }
        else if(this.equals(personnage)){
            System.out.println("Un personnage ne peut pas se tirer sur lui-meme");
            return -1;
        }
        else{
            boolean flag = false;
            boolean vainqueurTireur=false;
            boolean vainqueurPersonnage=false;

            int nombreAleatoirePersonnage;
            int nombreAleatoireTireur;

            while(flag == false) { // tant que les deux ont le meme score
                nombreAleatoirePersonnage = 1 + (int)(Math.random() * ((10 - 1) + 1)); //rnd entre 1 et 10
                nombreAleatoireTireur = 1 + (int)(Math.random() * ((10 - 1) + 1));
                vainqueurTireur = false;
                vainqueurPersonnage = false;
                
                if (this instanceof Indien){ // si le perso qui tire est un indien
                    if ((personnage instanceof Cowboy) || (personnage instanceof Brigand) ){ // il ne peut tirer que sur brigand ou cowboy

                        if ( nombreAleatoirePersonnage >= (10-personnage.getForce()) ){
                            vainqueurPersonnage = true;
                        }
                        if ( nombreAleatoireTireur >= (10-this.getForce()) ){
                            vainqueurTireur = true;
                        }
                        if ( vainqueurPersonnage == vainqueurTireur){
                            flag=false;
                        }
                        else{
                            flag=true;
                        }
                    }
                    else{
                        System.out.println("Un indien ne tire que sur un Cowboy ou un Brigand.");
                        flag=true;
                        return -1;
                    }
                } 
                
                else if (this instanceof Brigand){ //si on tire en tant que brigand sur un barman/banquier on gagne forcement           
                    if((this instanceof Barman) || (this instanceof Banquier)){
                        vainqueurTireur = true;
                        flag=true;   
                    }
                    else{ //le brigand peut tirer sur n'importe quel cow-boy, brigand, indien
                        if ( nombreAleatoirePersonnage >= (10-personnage.getForce()) ){
                            vainqueurPersonnage = true;
                        }
                        if ( nombreAleatoireTireur >= (10-this.getForce()) ){
                            vainqueurTireur = true;
                        }
                        if ( vainqueurPersonnage == vainqueurTireur){
                            flag=false;
                        }
                        else{
                            flag=true;
                        }
                    }
                }
                
                else if ((this instanceof Cowboy)||(this instanceof Sherif)){ // un cowboy ou sherif ne peut tirer que sur brigand
                    if(personnage instanceof Brigand){ // cowboy ne tire que sur brigand
                        if ( nombreAleatoirePersonnage >= (10-personnage.getForce()) ){
                        vainqueurPersonnage = true;
                        }
                        if ( nombreAleatoireTireur >= (10-this.getForce()) ){
                            vainqueurTireur = true;
                        }
                        if ( vainqueurPersonnage == vainqueurTireur){
                            flag=false;
                        }
                        else{
                            flag=true;
                        }
                    }
                    else{ //si cowboy tire sur autre que brigand
                        System.out.println("Un Cowboy/Sherif ne peut pas tirer sur les gentils !");
                        flag=true;
                        return -1;
                    } 
                }
                
                else if (this instanceof Barman || (this instanceof Banquier)){
                    System.out.println("Un barman/banquier n'est pas assez mechant pour tirer sur quelqu'un !");
                    flag=true;
                    return -1;
                }    
                
            } //fin du while
            
            
            if(vainqueurPersonnage==true){
                String far = this.getPrenom()+" a voulu tirer sur "+personnage.getPrenom()+ ", qui s'est defendu," +
                    " à l'issue du combat "+this.getPrenom()+" est mort !";
                System.out.println(far); 
                this.setSante(false);
                ecrireFichier(far);
            }
            else if(vainqueurTireur==true){
                String far = this.getPrenom()+" a voulu tirer sur "+personnage.getPrenom()+ ", qui s'est defendu," +
                    " à l'issue du combat "+personnage.getPrenom()+" est mort !";
                System.out.println(far);  
                personnage.setSante(false);
                ecrireFichier(far);
            }
            return ((vainqueurTireur==true)? 1 :0);
        }
        
    }// fin Tirer

    /**
     * Methode qui permet de négocier entre deux hommes, le résultat de cette négociation dépend de qui est à l'origine de la négociation ET vers qui il négocie
     * @param homme 
     */
    public void negocier(Homme homme){
        if(this.sante==false || homme.sante==false){
            System.out.println("Un des personnages est deja mort, ils ne peuvent negocier !");
        }
        else if(this.equals(homme))
        {System.out.println("Je suis pas schyzophrène ahhhh ! Je ne peux pas negocier avec moi meme !!");}
        
        else {

            //############ COWBOY NEGOCIE ##########################################
            if(this instanceof Cowboy){   //si celui qui negocie est un cowboy

                if(homme instanceof Indien){ // si celui avec le cowboy negocie est un indien
                    if (this.getANegocie()==true || homme.getANegocie()==true){ 
                        System.out.println("Un des personnage a deja atteint son nombre de negocations maximal");
                    }
                    else{  // si le perso n'a pas deja negocie
                        if(this.getPosition()!=Position.CAMPEMENT){
                            String far = "Le cowboy "+this.getPrenom()+" doit aller au campement pour négocier avec l'Indien "+ homme.getPrenom();
                            System.out.println(far);
                            ecrireFichier(far);
                        }
                        else{ //si le perso se trouve au meme endroit que l'indien
                            homme.setANegocie(true);
                            this.setANegocie(true);
                            String far = "L'indien "+homme.getPrenom()+
                                " va tenter une dance de la pluie pour augmenter la force de "+this.getPrenom()+ " !";
                            System.out.println(far); 
                            ecrireFichier(far);
                            int chance = 1 + (int)(Math.random() * ((100 - 1) + 1));
                            if (chance<=30){  // 30 % de chance d'échouer
                                System.out.println("Malheuresement, la danse a échouée.");
                            }
                            else if (chance>30){
                                int ajoutForce=0;
                                if( ((Indien)homme).getPlumes()>13 ){
                                    ajoutForce=2;
                                }
                                else if( ((Indien)homme).getPlumes()<=13){
                                    ajoutForce=1;
                                }
                                String far2 = "Succes ! La force de "+this.getPrenom()+" passe de "+
                                        this.getForce()+" à "+(this.getForce()+ajoutForce);
                                System.out.println(far2);
                                ecrireFichier(far2);
                                this.setForce(this.getForce()+ajoutForce);
                            }
                        }                    
                    }
                }
                if(homme instanceof Brigand){
                    if (this.getANegocie()==true || homme.getANegocie()==true){ 
                        System.out.println("Un des personnage a déjà atteint son nombre de negocations maximal");
                    }
                    else{  // si le perso n'a pas deja negocie
                        if(this.getPosition()!= homme.getPosition()){
                            System.out.println("Le cowboy "+this.getPrenom()+" doit rejoindre le brigand "+ homme.getPrenom());
                        }
                        else{
                            this.talk("Ohla "+homme.getPrenom()+" , ne tire pas, je veux discuter avec toi ! \n Ca fait bien des jours que je t'observe et je souhaiterai te rejoindre ! \n"
                                    + "Voler, Braquer, Enlever et semer la terreur ça m'interesse, je ne veux plus être un simple citoyen, je veux vivre comme un sauvage ! FAIS MOI DEVENIR UN BRIGAND !!");
                            String nom = this.getNom();
                            String prenom = this.getPrenom();
                            String prenom2 = this.getPrenom();
                            String surnom = this.getSurnom();
                            String arme = this.getArme();
                            int force = this.getForce();
                            int argent = 100;
                            int age = this.getAge();
                            
                            this.setSante(false);
                            
                            Brigand love = new Brigand(prenom,nom,surnom,age,arme,force,argent);
                            System.out.println("Voila, un nouveau brigand est né, pressé de faire des bêtises ! ");
                        }
                    }
                }//#################   fin c'est le cowboy qui negocie    #######################
                
            }
            
            if(this instanceof Brigand){
                if(homme instanceof Sherif){
                    System.out.println(homme.getPrenom()+", on va négocier min tchio");
                }
                if(homme instanceof Indien){ // si celui avec le cowboy negocie est un indien
                    if (this.getANegocie()==true || homme.getANegocie()==true){ 
                        System.out.println("Un des personnage a déjà atteint son nombre de negocations maximal");
                    }
                    else{  // si le perso n'a pas deja negocie
                        if(this.getPosition()!=Position.CAMPEMENT){
                            System.out.println("Le cowboy "+this.getPrenom()+" doit aller au campement pour negocier avec l'Indien "+ homme.getPrenom());
                        }
                        else{ //si le perso se trouve au meme endroit que l'indien
                            homme.setANegocie(true);
                            this.setANegocie(true);
                            String far = "L'indien "+homme.getPrenom()+
                                " va tenter une danse de la pluie pour augmenter la force de "+this.getPrenom()+ " ! \n\n";
                            System.out.println(far); 
                            ecrireFichier(far);
                            int chance = 1 + (int)(Math.random() * ((100 - 1) + 1));
                            if (chance<=30){  // 30 % de chance d'échouer
                                String far2 = "Malheureusement la danse a echouee \n\n";
                                System.out.println(far2);
                                ecrireFichier(far2);
                            }
                            else if (chance>30){
                                int ajoutForce=0;
                                if( ((Indien)homme).getPlumes()>13 ){
                                    ajoutForce=2;
                                }
                                else if( ((Indien)homme).getPlumes()<=13){
                                    ajoutForce=1;
                                }
                                String far3 = "Succes ! La force de "+this.getPrenom()+" passe de "+
                                        this.getForce()+" a "+(this.getForce()+ajoutForce)+"\n\n";
                                System.out.println(far3);
                                ecrireFichier(far3);
                                this.setForce(this.getForce()+ajoutForce);
                            }
                        }                    
                    }
                }                
                else this.talk("Je suis un brigand, la negociation, je connais pas sauf quand ma vie est en jeu, et toi, tu n'as pas l'air dangereux bougre d'ane !");
            }
            
        }//fin else si perso est mort
    }//fin neggocier
    
    
    /*
    cowboy négocie avec : indien FAIT 
                          brigand (fait mourir le cowboy actuel pour créer un brigand du meme nom, je sais pas encore comment faire)
    brigant négocie avec : Shérif (va en prison, faut pas l'pousser l'shérif)
    
    le reste on s'occupe pas 
    */
    public void annoncerPosition(){
        if(this.sante==false){
            System.out.println("Eh oh je suis mort, je peux pas parler lol");
        }
        else
        {
            this.talk("Ou suis-je ? Je suis actuellement ici : "+this.getPosition());;

                }
    }
} // fin classe humain
