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
public class Boisson {
    private String type;
    private int quantite;
    private int prix;
    
    public Boisson(String pType,int pQuantite,int pPrix){
        System.out.println("création d'une "+pType);
        this.type=pType;
        this.quantite=pQuantite;
        this.prix=pPrix;
    }
    
    public String getType(){return this.type;}
    public int getQuantite(){return this.quantite;}
    public int getPrix(){return this.prix;}
    
    public void setQuantite(int quantite){
        this.quantite=quantite;
    }
}
