/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package western;

/**
 *
 * @author JA
 */
public class Brigand extends PeutBoireBar {
    
    private boolean isInJail;
    
    //constructeur avec tous les champs du constructeur civil
    public Brigand(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce, pArgent);
        this.isInJail=false;
        sePresenter();
    }
    
    //constructeur sans position
    public Brigand(String pNom, String pPrenom, String pSurnom, int pAge,String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pArgent);
        this.isInJail=false;
        super.setPosition(Position.DESERT);
        sePresenter();
    }
    
    @Override
    public void sePresenter() {
        super.sePresenter();
        talk("Je suis le Brigand le plus recherché de l'Ouest, ma tête est mise à prix pour 5000€.\n");
    }
    @Override
    public String toString(){
        return this.getNom()+" "+this.getPrenom()+" "+this.getSurnom()+" "+this.getAge()+" "+this.getPosition()+" "+this.getArme()+" "+this.getForce()+" "+this.getArgent();
    }
    
    
    public boolean getIsInJail(){return this.isInJail;}
    public void setIsInJail(boolean isInJail){this.isInJail=isInJail;}
    
    
    public void kidnapper(Humain personne){
        
        if(personne instanceof Dame){
            
            if(this.getSante()==false){
                System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
            }    
            else if(this.getPosition()!=personne.getPosition()){
                System.out.println("Les personnages doivent se trouver au même endroit pour intérragir");
            }
            else if( ((Dame) personne).getEstKidnappee()==true){
                System.out.println(personne.getPrenom()+" s'est déjà fait kidnappée.");
            }
            else{
                this.talk("Viens la ma jolie Dame "+personne.getPrenom()+" !");
                ((Dame) personne).seFaireEnlever(this);
            }
        }
        else{
            System.out.println("Le brigand n'est pas assez courageux pour kidnapper une personne autre qu'une Dame.");
        }  
    }
    
    public void braquer(Civil victime){
        
        if(this.getSante()==false || victime.getSante()==false){
                System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
        }    
        else if(this.getPosition()!=victime.getPosition()){
                System.out.println("Les personnages doivent se trouver au même endroit pour intérragir");
        }
        else{
            
            if (victime instanceof  Banquier){
                if(victime.getPosition()!=Position.BANQUE || this.getPosition()!=Position.BANQUE){
                    System.out.println("Les personnages doivent se trouver à la banque pour intéragir");
                }   
                else{
                    this.talk("Les mains en l'air "+victime.getPrenom()+" ceci est un braquage !");
                    System.out.println("Dans sa fuite, le brigand "+this.getPrenom()+" perd une partie de son butin.");
                    System.out.println("L'argent de "+this.getPrenom()+" passe de "+this.getArgent()+" à "+(this.getArgent()+ (int)(0.3*(victime.getArgent()))) );
                    this.setArgent(this.getArgent()+(int)(0.3*(victime.getArgent())) );  //brigand recupere 30% de son butin
                    ((Banquier) victime).seFaitBraquer(this);
      
                }
            }
            else if((victime instanceof Barman)){
                if(victime.getPosition()!=Position.BAR || this.getPosition()!=Position.BAR){
                    System.out.println("Les personnages doivent se trouver au bar pour intéragir");
                }
                else{
                    this.talk("Les mains en l'air "+victime.getPrenom()+" ceci est un braquage !");   
                    System.out.println("Dans sa fuite, le brigand "+this.getPrenom()+" perd une partie de son butin.");
                    System.out.println("L'argent de "+this.getPrenom()+" passe de "+this.getArgent()+" à "+(this.getArgent()+ (int)(0.3*(victime.getArgent()))) );
                    this.setArgent(this.getArgent()+(int)(0.3*(victime.getArgent())) );  //brigand recupere 30% de son butin
                    ((Barman) victime).seFaitBraquer(this);   
                }
            }
            else{
                System.out.println("Le brigand ne peut pas braquer une autre personne qu'un commerçant.");
            }
        }   
    } // fin braquer  
    
    public void seFaireEmprisonner(Sherif sherif){
        
        talk("Bien joué pour cette fois shérif "+sherif.getPrenom()+", mais je n'ai pas dit mon dernier mot !");
        this.setPosition(Position.PRISON);
        System.out.println(this.getPrenom()+" va en prison.");
      
    }
    
    public void echapper(){
        talk("Pas très malin ce shérif qui oublies les clefs sur la serrure, à moi la liberté !");
        this.setIsInJail(false);
        this.setPosition(Position.RUE);
        
    }
       
}
