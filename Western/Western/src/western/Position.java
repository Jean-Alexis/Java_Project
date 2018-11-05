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
public enum Position {
    MAISON("Maison"),
    BAR("Bar"),
    DESERT("Desert"),
    BANQUE("Banque"),
    RUE("Rue"),
    CAMPEMENT("Campement"),
    PRISON("Prison");

    private String position;
    
    private Position(String position){
        this.position = position;
    }
    
    
    @Override
    public String toString(){
    	return (position);
    }


}

