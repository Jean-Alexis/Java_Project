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
    
    //constructeur avec tout les champs du constructeur Humain
    public Homme(String pNom, String pPrenom,Position pPosition, String pSurnom, int pAge, String pArme, int pForce, boolean pSante ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge);
        this.arme=pArme;
        this.force=pForce;
        this.sante=pSante;
        super.sePresenter();
    }
    //constructeur sans position
    public Homme(String pNom, String pPrenom,String pSurnom, int pAge, String pArme, int pForce, boolean pSante) {
        super(pNom, pPrenom, pSurnom, pAge);
        this.arme = pArme;
        this.force = pForce;
        this.sante = pSante;
        super.sePresenter();
    }
    
    
    @Override
    public void sePresenter() {
        super.sePresenter();
        talk(" Ca c'est bien un prénom de bonhomme ! En plus de ça, j'ai une "+
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
    
    
    // Tirer sur on personnage (un homme contre un homme), retourne vrai si le tireur gagne
    public boolean tirer(Homme personnage){
        if(this.sante==false || personnage.sante==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent se tirer dessus !");
            return false;
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
                        System.out.println("vainqueur Robin "+nombreAleatoirePersonnage+" >= "+ (10-personnage.getForce()) );
                        vainqueurPersonnage = true;

                    }

                    if ( nombreAleatoireTireur >= (10-this.getForce()) ){
                        System.out.println("vainqueur JA "+nombreAleatoireTireur+" >= "+ (10-this.getForce()) );
                        vainqueurTireur = true;

                    }


                    //if((vainqueurPersonnage==true && vainqueurTireur==true)|| (vainqueurPersonnage==false && vainqueurTireur== false) ){
                    if ( vainqueurPersonnage != vainqueurTireur){
                        flag=true;
                    }
                    else{
                        flag=false;
                    }
                }
            }
            if(vainqueurPersonnage==true){
                System.out.println(this.getPrenom()+" a voulu tirer sur "+personnage.getPrenom()+
                    ", à l'issue du combat "+this.getPrenom()+" est mort !"); 
                this.setSante(false);
            }
            else if(vainqueurTireur==true){
                System.out.println(this.getPrenom()+" a voulu tirer sur "+personnage.getPrenom()+
                    ", à l'issue du combat "+personnage.getPrenom()+" est mort !");  
                personnage.setSante(false);
            }
            return vainqueurTireur;
        }
        
    }// fin Tirer

} // fin classe humain
