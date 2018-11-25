/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package western;

import java.io.FileWriter;

/**
 *
 * @author Robin
 */
public abstract class Humain {
    private String nom;
    private String prenom;
    private String surnom;
    private Position position;
    private int age;
    
    
    /**
     * Constructeur Humain avec tous les champs renseignés et une Position
     * @param pNom
     * @param pPrenom
     * @param pSurnom
     * @param pPosition
     * @param pAge 
     */
    public Humain (String pNom, String pPrenom, String pSurnom, Position pPosition, int pAge) {
        
        this.nom=pNom;
        this.prenom=pPrenom;
        this.surnom=pSurnom;
        try{
            if(pAge<0){
                throw new Exception("age negatif");
            }
            else{
                this.age=pAge;
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
            
        this.position=pPosition;  
         
    }
    /**
     * constructeur sans position -> position spawn = RUE
     * @param pNom
     * @param pPrenom
     * @param pSurnom
     * @param pAge 
     */
    public Humain (String pNom, String pPrenom,String pSurnom, int pAge){
        this.nom=pNom;
        this.prenom=pPrenom;
        this.surnom=pSurnom;
        try{
            if(pAge<0){
                throw new Exception("age negatif");
            }
            else{
                this.age=pAge;
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        this.position=Position.RUE;
    }
    
    
    /**
     * Accesseur de nom
     * @return 
     */
    public String getNom(){return this.nom;}
    
    /**
     * Accesseur de prenom
     * @return 
     */
    public String getPrenom(){return this.prenom;}
    
    /**
     * Mutateur de prenom
     * @param prenom 
     */
    public void setPrenom(String prenom){this.prenom=prenom;}
  
    /**
     * Accesseur de surnom
     * @return 
     */
    public String getSurnom(){return this.surnom;}
    
    /**
     * Mutateur de surnom
     * @param surnom 
     */
    public void setSurnom(String surnom){this.surnom=surnom;}
    
    /**
     * Accesseur d'âge
     * @return 
     */
    public int getAge(){return this.age;}
    
    /**
     * Mutateur d'âge
     * @param age 
     */
    public void setAge(int age){this.age=age;}
    
    //protected car on ne peut faire se déplacer un indien
    
    /**
     * Accesseur de Position
     * @return 
     */
    public Position getPosition(){return this.position;}
    
    /**
     * Mutateur de position
     * @param position 
     */
    protected void setPosition(Position position){this.position=position;}
    
    
    //Methodes inhérentes à la classe humain
    
    /**
     * Methode de présentation
     */
    public void sePresenter(){
        talk("Hey, salut, je suis "+ prenom +" "+ nom +", mais tu peux aussi m'appeler " + 
                prenom + " THE " + surnom+ "!! Alors, regarde mon beau visage, pas mal pour quelqu'un de " + age +" ans, hein !!");   
        
    }
    
    /**
     * Prends un String en paramètre et l'affiche correctement dans la console lorsqu'un personnage parle
     * @param parole 
     */
    public void talk(String parole){
        System.out.println(this.prenom+" "+this.nom+" : "+parole+"");
        ecrireFichier(this.getPrenom()+ ": "+parole+"\n");
    }
    
    /**
     * Methode permettant de prendre un String en argument et de l'écrire dans un fichier .txt
     * @param args 
     */
    public static void ecrireFichier(String args){

        try{

        FileWriter fw = new FileWriter("src/tmp.txt",true);
        fw.write(args);
        fw.close();
            }
       catch(Exception e)
       {
        System.err.println("ok");
       }

    }
}

