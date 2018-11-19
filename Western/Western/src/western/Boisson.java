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
    
    /**
     * Constructeur d'une boisson
     * @param pType
     * @param pQuantite
     * @param pPrix 
     */
    public Boisson(String pType,int pQuantite,int pPrix){
        System.out.println("création d'une "+pType);
        this.type=pType;
        this.quantite=pQuantite;
        this.prix=pPrix;
    }
    /**
     * Accesseur du type de boisson
     * @return 
     */
    public String getType(){return this.type;}
    /**
     * Accesseur de la Quantité
     * @return 
     */
    public int getQuantite(){return this.quantite;}
    /**
     * Accesseur du Prix
     * @return 
     */
    public int getPrix(){return this.prix;}
    /**
     * Mutateur de la quantite
     * @param quantite 
     */
    public void setQuantite(int quantite){this.quantite=quantite;
    }
}
