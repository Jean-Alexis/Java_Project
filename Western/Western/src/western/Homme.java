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
    
    //constructeur avec tout les champs du constructeur Humain
    public Homme(String pNom, String pPrenom, String pSurnom, Position pPosition, int pAge, String pArme, int pForce, boolean pSante ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge);
        this.arme=pArme;
        this.force=pForce;
        this.sante=pSante;
        this.aNegocie=false;
        
    }
    //constructeur sans position
    public Homme(String pNom, String pPrenom,String pSurnom, int pAge, String pArme, int pForce, boolean pSante) {
        super(pNom, pPrenom, pSurnom, pAge);
        this.arme = pArme;
        this.force = pForce;
        this.sante = pSante;
        this.aNegocie= false;
        
    }
    
    
    @Override
    public void sePresenter() {
        super.sePresenter();
        talk("Ca c'est bien un prénom de bonhomme ! En plus de ça, j'ai une "+
                arme+", pas mal comme arme hein ! Regarde, j'ai "+ force + " de force, pas mal hein !");
    }

    public void annoncerArme(){
        talk("Attention ! Je suis en possession d'un " + this.arme);
    }

    public int getForce(){return this.force;}
    
    public void setForce(int force){
        if((force<0) || (force>10)){
            System.out.println("valeur de force invalide");
        }
        else{this.force=force;}
    }
    
    public String getArme(){return this.arme;}
    
    public boolean getSante(){return this.sante;}
    public void setSante(boolean sante){this.sante=sante;}

    public boolean getANegocie(){return this.aNegocie;}
    public void setANegocie(boolean aNegocie){this.aNegocie=aNegocie;}
    
    
    // Tirer sur on personnage (un homme contre un homme), retourne vrai si le tireur gagne
    public int tirer(Homme personnage){
        if(this.sante==false || personnage.sante==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent se tirer dessus !");
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

                if (personnage instanceof Indien){ //si on tire sur un indien

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
            if(vainqueurPersonnage==true){
                System.out.println(this.getPrenom()+" a voulu tirer sur "+personnage.getPrenom()+ ", qui s'est défendu," +
                    " à l'issue du combat "+this.getPrenom()+" est mort !"); 
                this.setSante(false);
            }
            else if(vainqueurTireur==true){
                System.out.println(this.getPrenom()+" a voulu tirer sur "+personnage.getPrenom()+ ", qui s'est défendu," +
                    " à l'issue du combat "+personnage.getPrenom()+" est mort !");  
                personnage.setSante(false);
            }
            return ((vainqueurTireur==true)? 1 :0);
        }
        
    }// fin Tirer

    //négocier entre deux hommes, tout dépend de la catégorie qui négocie
    public void negocier(Homme homme){

    	//############ COWBOY NEGOCIE ##########################################
        if(this instanceof Cowboy){   //si celui qui negocie est un cowboy

            if(homme instanceof Indien){ // si celui avec le cowboy negocie est un indien
                if (this.getANegocie()==true || homme.getANegocie()==true){ 
                    System.out.println("Un des personnage a déjà atteint son nombre de negocations maximal");
                }
                else{
                    if(this.getPosition()!=Position.CAMPEMENT){
                        System.out.println("Le cowboy "+this.getPrenom()+" doit aller au campement pour négocier avec l'Indien "+ homme.getPrenom());
                    }
                    else{
                    	homme.setANegocie(true);
                    	this.setANegocie(true);
                        System.out.println("L'indien "+homme.getPrenom()+
                            " va tenter une dance de la pluie pour augmenter la force de "+this.getPrenom()+ " !"); 
                        int chance = 1 + (int)(Math.random() * ((100 - 1) + 1));
                        if (chance<=30){  // 30 % de chance d'échouer
                            System.out.println("Malheursement, la danse a échouée.");
                       	}
                        else if (chance>30){
                            int ajoutForce=0;
                            if( ((Indien)homme).getPlumes()>13 ){
                                ajoutForce=2;
                            }
                            else if( ((Indien)homme).getPlumes()<=13){
                                ajoutForce=1;
                            }
                            System.out.println("Succès ! La force de "+this.getPrenom()+" passe de "+
                                    this.getForce()+" à "+(this.getForce()+ajoutForce));
                            this.setForce(this.getForce()+ajoutForce);
                        }
                    }                    
                }
            } 

        }//#################fin c'est le cowboy qui negocie #######################

    }//fin neggocier

} // fin classe humain
