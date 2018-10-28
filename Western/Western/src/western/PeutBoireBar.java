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
public class PeutBoireBar extends Civil{
    
    //constructeur avec tous les champs du constructeur civil
    public PeutBoireBar(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, boolean pSante, int pArgent ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce, pSante, pArgent);
        super.sePresenter();
    }
    
    //constructeur sans position
    public PeutBoireBar(String pNom, String pPrenom, String pSurnom, int pAge,String pArme, int pForce, boolean pSante, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pSante, pArgent);
        super.sePresenter();
    }
    
    public void demanderBoisson(Civil barman){
        
       if(barman instanceof Barman){
           
       }
      
    }
    
    public void PayerBoisson(Civil barman){
        
        if(barman instanceof Barman){
        }
    }
    
    
}
