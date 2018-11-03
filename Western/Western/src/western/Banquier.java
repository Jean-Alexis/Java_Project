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
public class Banquier extends PeutBoireBar implements SestFaitFaucher{
    
    private boolean estBraque;
    
     //constructeur avec tous les champs du constructeur civil
    public Banquier(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, int pArgent){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce, pArgent);
        this.estBraque=false;
        sePresenter();
    }
    
    //constructeur sans position
    public Banquier(String pNom, String pPrenom, String pSurnom, int pAge,String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce, pArgent);
        super.setPosition(Position.BANQUE);
        this.estBraque=false;
        sePresenter();
    }
    
    public void setEstBraque(boolean estBraque){ this.estBraque=estBraque;}
    public boolean getEstBraque(){ return this.estBraque;}
    
    @Override
    public void sePresenter() {
        super.sePresenter();
        talk("Je suis le banquier, que puis-je faire pour vous ?\n");
    }
    
    @Override
    public String toString(){
        return this.getNom()+" "+this.getPrenom()+" "+this.getSurnom()+" "+this.getAge()+" "+this.getPosition()+" "+this.getArme()+" "+this.getForce()+" "+this.getArgent();
    }
    
    public void accorderPret(Civil civil, int argent){   // cette fonction créer de la valeur (elle ne ponctionne pas l'argent du banquier mais rajoute qd meme au civil
        //les verifications de position, sante etc ont deja ete faite lors de l'appel demanderPret() dans Civil
        if( this.estBraque==true){
            System.out.println("Nous nous sommes fait braqué, nous ne pouvons rien faire pour vous.");
        }
        
        else{
            if(argent>= civil.getArgent()*0.45){ // si on demande plus de 45% de ce qu'on a
                this.talk("Désolé Monsieur "+civil.getNom()+" vous demandez trop par rapport à ce que vous avez déjà.");
            }
            else{
                this.talk("Monsieur "+civil.getNom()+", après étude de votre cas, je suis heureux de vous annoncer la possibilité de faire un prêt de "+argent+"€.");
                System.out.println("L'argent de "+civil.getPrenom()+" passe de "+civil.getArgent()+" à "+(civil.getArgent()+argent));
                civil.setArgent(civil.getArgent()+argent);
            }
            
        }
    }
    
    
     //interface
    @Override
    public void seFaitBraquer(Brigand brigand){
        this.setEstBraque(true);
        this.talk("Vous ne vous en sortirez pas comme ça ! Ma banque c'est ma vie !");
        System.out.println("L'argent de "+this.getPrenom()+" passe de "+ this.getArgent() +" à 0.");
        this.setArgent(0);
        this.depression();
        
    }
    
   
    @Override
    public void depression(){
        
    }
    
    @Override
    public void videReserveAlcool(){
        
    }
    
}
