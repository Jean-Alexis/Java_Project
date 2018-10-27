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
public class Civil extends Homme {
    private int argent;
    public Civil(String pNom, String pPrenom,Position pPosition, String pSurnom, int pAge, String pArme, int pForce, boolean pSante, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pSante);
        this.argent=pArgent;
    }
    
    public void seDeplacer(Position position)
    {
        super.setPosition(position);
    }
}
