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
    
    /**
     * constructeur avec tous les champs du constructeur homme
     * @param pNom
     * @param pPrenom
     * @param pSurnom
     * @param pPosition
     * @param pAge
     * @param pArme
     * @param pForce
     * @param pArgent 
     */
    public Civil(String pNom, String pPrenom, String pSurnom,Position pPosition, int pAge,String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pPosition, pAge, pArme, pForce);
        try{
            if(pArgent<0){
                throw new Exception("argent négatif");
            }
            else{
                this.argent=pArgent;
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        
    }

    /**
     * Constructeur Civil sans position
     * @param pNom
     * @param pPrenom
     * @param pSurnom
     * @param pAge
     * @param pArme
     * @param pForce
     * @param pArgent 
     */
    public Civil(String pNom, String pPrenom, String pSurnom, int pAge, String pArme, int pForce, int pArgent ){
        super(pNom, pPrenom, pSurnom, pAge, pArme, pForce);
        try{
            if(pArgent<0){
                throw new Exception("argent négatif");
            }
            else{
                this.argent=pArgent;
            }
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
       
    /**
     * Methode permettant à un personnage de se déplacer
     * @param position Paramètre correspondant à la position où le personnage se déplace
     */
    public void seDeplacer(Position position){
        
        if(this.getSante()==false){
            System.out.println("Le personnage est déjà mort, il ne peut se déplacer !");
        }
        else if (this.getPosition().equals(position)){
            System.out.println(this.getPrenom()+" se trouve déjà à "+position);
        }
        else{
            if(this instanceof Brigand){ //si le brigang est en prison il ne peut pas se déplacer
                if((this.getPosition()==Position.PRISON) && (((Brigand)this).getIsInJail()==true)){
                    String far = "Le brigand "+this.getPrenom()+" est en prison, il ne peut pas se déplacer.";
                    System.out.println(far);
                    ecrireFichier(far);
                    this.talk("LAISSEZ MOI SOOOORTIR !!");
                }
                else{
                    String far = this.getPrenom()+" se deplace de "+this.getPosition()+" a "+position;
                    System.out.println(far);
                    ecrireFichier(far);
                    super.setPosition(position);
                }
            }

            else{
                String far = this.getPrenom()+" se déplace de "+this.getPosition()+" à "+position;
                System.out.println(far);
                ecrireFichier(far);
                super.setPosition(position);
            }
        }
    }
    
    /**
     * Methode permettant à un personnage de donner de l'argent à un autre
     * @param civil Paramètre correspondant à la personne à qui est destinée l'argent
     * @param argent Paramètre correspondant à la somme donnée
     */
    public void donnerArgent(Civil civil, int argent){
        if(this.getSante()==false || civil.getSante()==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
        }
        else if (this.getPosition()!=(civil.getPosition())){
            System.out.println("Les personnages doivent se trouver au même endroit pour intérragir");
        }
        else if(this.equals(civil)){
            System.out.println(this.getPrenom()+" ne peut se donner de l'argent à lui même.");
        }
        else if(argent<0){
            System.out.println("Vous ne pouvez donner une somme d'argent négative.");
        }
        else{
            if(argent<=this.getArgent()){
                this.talk("Tennez, voilà "+ argent+"€.");
                String far = "L'argent de "+civil.getPrenom()+" passe de "+civil.getArgent()+" à "+(civil.getArgent()+argent);
                System.out.println(far);
                ecrireFichier(far);
                String far2 = "L'argent de "+ this.getPrenom() +" passe de "+this.getArgent()+" à "+(this.getArgent()-argent);
                System.out.println(far2);
                ecrireFichier(far2);
                this.setArgent(this.getArgent()-argent);
                civil.setArgent(civil.getArgent()+argent);
            }
            else{
                System.out.println(this.getPrenom()+" n'a pas assez d'argent pour donner "+argent+"€.");
            }   
        }
    }
    
    /**
     * Methode permettant à un personnage de demander un prêt à un banquier
     * @param banquier Paramètre correspondant au banquier à qui nous demandons le prêt
     * @param argent  Paramètre correspondant à la somme demandée en prêt
     */
    public void demanderPret(Banquier banquier, int argent){
        if(this.getSante()==false || banquier.getSante()==false){
            System.out.println("Un des personnages est déjà mort, ils ne peuvent intérragir !");
        }
        else if (this.getPosition()!=(banquier.getPosition())){
            System.out.println("Les personnages doivent se trouver au même endroit pour intérragir");
        }
        else if(this.equals(banquier)){
            System.out.println(this.getPrenom()+" ne peut se demander un prêt à lui même.");
        }
        else if(argent<0){
            System.out.println("Vous ne pouvez demander une somme d'argent négative.");
        }
        else{
           this.talk("Bonjour banquier "+banquier.getNom()+" serait-il possible de faire un prêt de "+argent+"€ ?");
           banquier.accorderPret(this, argent);
        }
    }
    
    /**
     * Mutateur d'argent
     * @param argent 
     */
    protected void setArgent(int argent){ this.argent=argent;}
    /**
     * Accesseur d'argent
     * @return 
     */
    public int getArgent(){ return this.argent;}
}
