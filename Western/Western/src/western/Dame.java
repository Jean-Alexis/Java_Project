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
public class Dame extends Humain {
    private String couleurRobe; 
    private boolean estKidnappee;
   

    //contructeur sans position -> de base spawn dans la maison
    public Dame(String pNom, String pPrenom, String pSurnom, int pAge, String pCouleurRobe){
    	super(pNom, pPrenom, pSurnom, pAge);
    	this.couleurRobe=pCouleurRobe;
        this.estKidnappee= false;
    	super.setPosition(Position.MAISON);
    	sePresenter();

    }
    //constructeur avec position
    public Dame(String pNom, String pPrenom,String pSurnom, int pAge,Position pPosition, String pCouleurRobe){
    	super(pNom, pPrenom,pSurnom, pPosition, pAge);
        this.estKidnappee=false;
    	this.couleurRobe=pCouleurRobe;
    	sePresenter();
    }
    
    @Override
    public void sePresenter(){
        super.sePresenter();
        talk("Je n'ai pas d'armes, mais moi au moins, j'ai une magnifique robe "+ this.couleurRobe);
    }
    
    @Override
    public String toString(){
        return this.getNom()+" "+this.getPrenom()+" "+this.getSurnom()+" "+this.getAge()+" "+this.getPosition()+" "+this.couleurRobe;
    }
    
    public void setEstKidnappee(boolean estKidnappee){this.estKidnappee=estKidnappee;}
    public boolean getEstKidnappee(){return this.estKidnappee;}
    
    public void seFaireEnlever (Homme brigand){
        if(brigand.getSante()==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
        }
        else if(this.getPosition()!= brigand.getPosition()){
            System.out.println("Les personnages doivent se trouver au même endroit pour intérragir");
        }
        else{
            if (brigand instanceof Brigand){
                this.estKidnappee = true;
                brigand.setPosition(Position.DESERT);
                this.setPosition(brigand.getPosition()); //la dame se retrouve au desert
                this.talk("A L'aiiiide, on me kidnappe !!");
                String far = "Dame "+this.getPrenom()+" est enlevee jusqu'au désert par "+ brigand.getPrenom()+"\n";
                System.out.println(far);
                ecrireFichier(far);
            }
            else{
                System.out.println("Il n'y qu'un brigand qui peut enlever une dame !");
            }
        }
    }
    
    public void seFaireLiberer (Homme homme){
        
        if(homme.getSante()==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
        }
        else if(this.getPosition()!= homme.getPosition()){
            System.out.println("Les personnages doivent se trouver au même endroit pour intérragir");
        }
        else{
            if (homme instanceof Brigand){
                System.out.println("Le brigand "+homme.getPrenom()+" ne va quand même pas libérer "+this.getPrenom());
            }
            else{
                this.talk("Oh, quel heros, "+homme.getPrenom()+" a reussi à me liberer de cette ordure, je ne l'en remercierai jamais assez");
                super.setPosition(Position.MAISON);
                System.out.println(this.getPrenom()+" retourne à sa maison.\n");
            }
        }   
    }
    
    public void annoncerPosition(){
        talk("Ou suis-je ? Je suis actuellement ici : "+this.getPosition());
    }    
    
    
}

