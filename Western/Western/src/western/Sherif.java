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
public class Sherif extends PeutBoireBar{
    
    //constructeur avec tous les champs du constructeur civil
    public Sherif(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce, pArgent);
        sePresenter();
    }
    
    //constructeur sans position
    public Sherif(String pNom, String pPrenom, String pSurnom, int pAge,String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pArgent);
        super.setPosition(Position.PRISON);
        sePresenter();
    }
    
    @Override
    public void sePresenter() {
        super.sePresenter();
        this.talk("Oyez, messieurs dames, votre sherif est arrive.");

    }
    
    @Override
    public String toString(){
        return this.getNom()+" "+this.getPrenom()+" "+this.getSurnom()+" "+this.getAge()+" "+this.getPosition()+" "+this.getArme()+" "+this.getForce()+" "+this.getArgent();
    }
    
    public void emprisonner(Brigand brigand){
        if(this.getSante()==false || brigand.getSante()==false){
            System.out.println("Un des personnages est deja mort, ils ne peuvent interragir !");
        }    
        else if(this.getPosition()!=brigand.getPosition()){
            System.out.println("Les personnages doivent se trouver au même endroit pour intérragir");
        }
        else if (brigand.getIsInJail()== true){
            System.out.println("Le brigand "+this.getPrenom()+" est déjà en prison");
        }
        else{
            this.talk("Tu as assez fait de betises comme ça "+ brigand.getPrenom()+ " il est temps pour toi de faire un tour derriere les barreaux !");
            brigand.seFaireEmprisonner(this);
            brigand.setIsInJail(true);
        }
    }
    
}
