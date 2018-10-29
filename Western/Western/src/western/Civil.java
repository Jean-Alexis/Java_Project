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
        this.argent=pArgent;
    }

    //constructeur sans position
    public Civil(String pNom, String pPrenom, String pSurnom, int pAge, String pArme, int pForce, boolean pSante, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pSante);
        this.argent=pArgent;
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
    
    protected void setArgent(int argent){ this.argent=argent;}
    public int getArgent(){ return this.argent;}
}
