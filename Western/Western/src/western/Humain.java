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
    
    
    //constructeur avec tous les champs renseignés
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
    //constructeur sans position -> position spawn = RUE
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
    
    
    //mutateurs et accesseurs
    public String getNom(){return this.nom;}
    
    public String getPrenom(){return this.prenom;}
    public void setPrenom(String prenom){this.prenom=prenom;}
  
    public String getSurnom(){return this.surnom;}
    public void setSurnom(String surnom){this.surnom=surnom;}
    
    public int getAge(){return this.age;}
    public void setAge(int age){this.age=age;}
    
    //protected car on ne peut faire se déplacer un indien
    public Position getPosition(){return this.position;}
    protected void setPosition(Position position){this.position=position;}
    
    
    //fonction inhérentes à la classe humain
    public void sePresenter(){
        talk("Hey, salut, je suis "+ prenom +" "+ nom +", mais tu peux aussi m'appeler " + 
                prenom + " THE " + surnom+ "!! Alors, regarde mon beau visage, pas mal pour quelqu'un de " + age +" ans, hein !!");   
        
    }
    
    public void talk(String parole){
        System.out.println(this.prenom+" "+this.nom+" : "+parole+"\n");
        ecrireFichier(this.getPrenom()+ ": "+parole+"\n");
    }
    
    public static void ecrireFichier(String args){

        try{

        FileWriter fw = new FileWriter("C:/Users/Robin/Desktop/tmp.txt",true);
        fw.write(args);
        fw.close();
            }
       catch(Exception e)
       {
        System.err.println("ok");
       }

    }
}

