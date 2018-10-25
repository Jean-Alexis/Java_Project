/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package western;

import java.util.ArrayList;

/**
 *
 * @author Robin
 */
public class Western {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        ArrayList< Homme > cimmetiere = new ArrayList<>(); // tableau de personnes mortes
        
        Indien robin =new Indien("Ghys","Robin","Beau-goss",20,"Tokarev",3,true,19);
        Indien JA =new Indien("Hermel","JA","dieu",21,"pistolet",7,true,17);
        //Dame robinne = new Dame("Ghyse","Robinne",20,"bleu");
        
        JA.annoncerArme();
        robin.annoncerArme();
        
        //JA.tirer(robin);
        
        if (JA.tirer(robin)== true){
            cimmetiere.add(robin);
        }
        else {
            cimmetiere.add(JA);
        }
        
        JA.tirer(robin);
    }

}   

