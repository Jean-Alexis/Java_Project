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
    public Brigand(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, boolean pSante, int pArgent ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce, pSante, pArgent);
        this.isInJail=false;
        sePresenter();
    }
    
    //constructeur sans position
    public Brigand(String pNom, String pPrenom, String pSurnom, int pAge,String pArme, int pForce, boolean pSante, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pSante, pArgent);
        this.isInJail=false;
        super.setPosition(Position.DESERT);
        sePresenter();
    }
    
    @Override
    public void sePresenter() {
        super.sePresenter();
        talk("Je suis le Brigand le plus recherché de l'Ouest, ma tête est mise à prix pour 5000€.\n");
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
      
 
}
