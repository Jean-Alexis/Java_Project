/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package western;

/**
 *
 * @author Robin
 */
public abstract class Humain {
    private String Nom;
    private String Prenom;
    private String Nickname;
    private int Age;
    
    
    
    public Humain (String pNom, String pPrenom, String pNickname, int pAge)
    {
        this.Nom=pNom;
        this.Prenom=pPrenom;
        this.Nickname=pNickname;
        this.Age=pAge;
        
       
    }
    
    public String getNom()
    {
        return Nom;
    }
    
    public String getPrenom()
    {
        return Prenom;
    }
    
    public String getSurnom()
    {
        return Nickname;
    }
    public int getAge()
    {
        return Age;
    }
    
    public void setNom(String nom)
    {
        this.Nom=nom;
    }
    
    public void setPrenom(String prenom)
    {
        this.Prenom=prenom;
    }
    
    public void setSurnom(String surnom)
    {
        this.Nickname=surnom;
    }
    
    public void setAge(int age)
    {
        this.Age=age;
    }
    
    public void sePresenter()
    {
        System.out.println("Hey, salut toi, je suis "+ Prenom +" "+ Nom +", mais tu peux aussi m'appeler " + Prenom + " THE " + Nickname+ "!!");
        System.out.println("Alors pas mal pour quelqu'un qui a " + Age +" ans, hein !!");
    }
    
}

