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
public class Civil extends Homme {
    private int argent;
    
    //constructeur avec tous les champs du constructeur homme
    public Civil(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, boolean pSante, int pArgent ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce, pSante);
        if(pArgent<0){
            System.out.println("Vous avez entré une somme d'argent négative");
        }
        else{
            this.argent=pArgent;
        }
        
    }

    //constructeur sans position
    public Civil(String pNom, String pPrenom, String pSurnom, int pAge, String pArme, int pForce, boolean pSante, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pSante);
        if(pArgent<0){
            System.out.println("Vous avez entré une somme d'argent négative");
        }
        else{
            this.argent=pArgent;
        }
    }
    
    
    public void seDeplacer(Position position){
        
        if(this.getSante()==false){
            System.out.println("Le personnage est déjà mort, il ne peut se déplacer !");
        }
        else if (this.getPosition().equals(position)){
            System.out.println(this.getPrenom()+" se trouve déjà à "+position);
        }
        else{
            if(this instanceof Brigand){ //si le brigang est en prison il ne peut pas se déplacer
                if((this.getPosition()==Position.PRISON) && (((Brigand)this).getIsInJail()==true)){
                    System.out.println("Le brigand "+this.getPrenom()+" est en prison, il ne peut pas se déplacer.");
                    this.talk("LAISSEZ MOI SOOOORTIR !!");
                }
                else{
                    System.out.println(this.getPrenom()+" se déplace de "+this.getPosition()+" à "+position);
                    super.setPosition(position);
                }
            }

            else{
                System.out.println(this.getPrenom()+" se déplace de "+this.getPosition()+" à "+position);
                super.setPosition(position);
            }
        }
    }
    
    public void donnerArgent(Civil civil, int argent){
        if(this.getSante()==false || civil.getSante()==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
        }
        else if (this.getPosition()!=(civil.getPosition())){
            System.out.println("Les personnages doivent se trouver au même endroit pour intérragir");
        }
        else if(this.equals(civil)){
            System.out.println(this.getPrenom()+" ne peut se donner de l'argent à lui même.");
        }
        else if(argent<0){
            System.out.println("Vous ne pouvez donner une somme d'argent négative.");
        }
        else{
            if(argent<this.getArgent()){
                this.talk("Tiens, voilà "+ argent+"€, fais-en bon usage.");
                System.out.println("L'argent de "+civil.getPrenom()+" passe de "+civil.getArgent()+" à "+(civil.getArgent()+argent));
                System.out.println("L'argent de "+ this.getPrenom() +" passe de "+this.getArgent()+" à "+(this.getArgent()-argent));
                this.setArgent(this.getArgent()-argent);
                civil.setArgent(civil.getArgent()+argent);
            }
            else{
                System.out.println(this.getPrenom()+" n'a pas assez d'argent pour donner "+argent+"€.");
            }
            
        }
        
    }
    
    protected void setArgent(int argent){ this.argent=argent;}
    public int getArgent(){ return this.argent;}
}
