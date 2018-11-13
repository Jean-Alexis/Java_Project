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
        this.talk("Je suis le banquier, que puis-je faire pour vous ?");
    }
    
    @Override
    public String toString(){
        return this.getNom()+" "+this.getPrenom()+" "+this.getSurnom()+" "+this.getAge()+" "+this.getPosition()+" "+this.getArme()+" "+this.getForce()+" "+this.getArgent();
    }
    
    public void accorderPret(Civil civil, int argent){   // cette fonction créer de la valeur (elle ne ponctionne pas l'argent du banquier mais rajoute qd meme au civil
        //les verifications de position, sante etc ont deja ete faite lors de l'appel demanderPret() dans Civil
        if( this.estBraque==true){
            
            this.talk("Nous nous sommes fait braque, nous ne pouvons rien faire pour vous.");
        }
        
        else{
            if(argent>= civil.getArgent()*0.45){ // si on demande plus de 45% de ce qu'on a
                this.talk("Desole Monsieur "+civil.getNom()+" vous demandez trop par rapport a ce que vous avez deja.");
            }
            else{
                this.talk("Monsieur "+civil.getNom()+", apres étude de votre cas, je suis heureux de vous annoncer la possibilite de faire un pret de "+argent+"€.");
                System.out.println("L'argent de "+civil.getPrenom()+" passe de "+civil.getArgent()+" à "+(civil.getArgent()+argent));
                civil.setArgent(civil.getArgent()+argent);
            }
            
        }
    }
    
    
     //interface
    @Override
    public void seFaitBraquer(Brigand brigand){
        this.setEstBraque(true);
        this.talk("Vous ne vous en sortirez pas comme ca ! Ma banque c'est ma vie !");
        System.out.println("L'argent de "+this.getPrenom()+" passe de "+ this.getArgent() +" a 0.");
        this.setArgent(0);
        this.depression();
    }
    
   
    @Override
    public void depression(){
        if(this.getSante()==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
        }
        else{
            this.talk("Vous savez, en ce moment ca va vraiment pas tiptop, j'avais vraiment pas besoin de ça, vraiment...ma banque c'est ma raison d'etre");
        }     
    }
    
    @Override
    public void videReserveAlcool(){
        int chance = 1 + (int)(Math.random() * ((100 - 1) + 1));
        if(estBraque==true){
            if(this.getSante()==false){
                System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
            }
            else if(this.getPosition()!= Position.BAR){
                System.out.println("Le personnage doit se trouver au bar pour se saouler");
            }
            else{
                this.talk("Apres tout, une ptite bouteille ca n'a jamais fait de mal a personne, c'est la Banque qui paye !!");
                if (chance>50){ //50% de chance de faire une depression
                    this.depression();
                }
            }
        }
            
        else{
            this.talk("LA boisson c'est termine pour moi je ne touche plus à ca.");
            if (chance>80){ //20% de chance de faire une depression
                this.depression();
            }
        }  
    }
    
}
