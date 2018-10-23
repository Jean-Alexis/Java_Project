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
    private String nom;
    private String prenom;
    private String nickname;
    private int age;
    
    
    
    public Humain (String pNom, String pPrenom, String pNickname, int pAge)
    {
        this.nom=pNom;
        this.prenom=pPrenom;
        this.nickname=pNickname;
        this.age=pAge;
        
       
    }
    
    public String getNom()
    {
        return nom;
    }
    
    public String getPrenom()
    {
        return prenom;
    }
    
    public String getSurnom()
    {
        return nickname;
    }
    public int getAge()
    {
        return age;
    }
    
    public void setNom(String nom)
    {
        this.nom=nom;
    }
    
    public void setPrenom(String prenom)
    {
        this.prenom=prenom;
    }
    
    public void setSurnom(String surnom)
    {
        this.nickname=surnom;
    }
    
    public void setAge(int age)
    {
        this.age=age;
    }
    
    public void sePresenter()
    {
        
        talk(("Hey, salut, je suis "+ prenom +" "+ nom +", mais tu peux aussi m'appeler " + prenom + " THE " + nickname+ "!! Alors, regarde mon beau visage, pas mal pour quelqu'un de " + age +" ans, hein !!"));
        
    }
    
    public void talk(String parole){
        System.out.println(this.prenom+" "+this.nom+" : "+parole);
    }
}

