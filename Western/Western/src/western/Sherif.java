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
    
    /**
     * Constructeur d'un shérif avec position précise
     * @param pNom
     * @param pPrenom
     * @param pSurnom
     * @param pPosition
     * @param pAge
     * @param pArme
     * @param pForce
     * @param pArgent 
     */
    public Sherif(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce, pArgent);
        sePresenter();
    }
    
    /**
     * COnstructeur d'un sherif sans position indiquée, il spawnera dans la prison
     * @param pNom
     * @param pPrenom
     * @param pSurnom
     * @param pAge
     * @param pArme
     * @param pForce
     * @param pArgent 
     */
    public Sherif(String pNom, String pPrenom, String pSurnom, int pAge,String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pArgent);
        super.setPosition(Position.PRISON);
        sePresenter();
    }
    
    /**
     * Methode permettant au sherif de se présenter
     */
    @Override
    public void sePresenter() {
        super.sePresenter();
        this.talk("Oyez, messieurs dames, votre sherif est arrive.");

    }
    
    /**
     * Methode permettant d'indiquer des informations sur un sherif
     * @return 
     */
    @Override
    public String toString(){
        return this.getNom()+" "+this.getPrenom()+" "+this.getSurnom()+" "+this.getAge()+" "+this.getPosition()+" "+this.getArme()+" "+this.getForce()+" "+this.getArgent();
    }
    
    /**
     * Methode permettant d'emprisonner un brigand
     * @param brigand Paramètre indiquant quel brigand se fait emprisonner
     */
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
