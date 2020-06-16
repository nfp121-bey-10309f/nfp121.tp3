package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2 implements PileI {
    /** par delegation : utilisation de la class Stack */
    private Stack<Object> stk;

    /** la capacite de la pile */
    private int capacite;

    /**
     * Creation d'une pile.
     * 
     * @param taille
     *            la taille de la pile, la taille doit etre > 0
     */
    public Pile2(int taille) {
        // prevoir le cas <=0
        // a completer
        //Q2.2
        if (taille<=0) taille = PileI.CAPACITE_PAR_DEFAUT;
        stk = new Stack<Object>();
        this.capacite=taille;
    }

    // constructeur fourni
    public Pile2() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
        //Q2.2
        //stk.push(o); //increasing the size
         if (estPleine()) {
            throw new PilePleineException();
        }
         stk.push(o);
        //Pourquoi pas stk.addElement(o);
    }

    public Object depiler() throws PileVideException {
        // a completer
        //Q2.2
         if (estVide()) {
            throw new PileVideException();
        }
        return stk.pop();
    }

    public Object sommet() throws PileVideException {
        // a completer
        //Q2.2
        if (estVide()) {
            throw new PileVideException();
        }
        return stk.peek();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        // a completer
        //Q2.2
        return stk.isEmpty();
    }

    /**
     * Effectue un test de l'etat de la pile.
     * 
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        // a completer
        //Q2.2
        return this.capacite == stk.size();
    }

    /**
     * Retourne une representation en String d'une pile, contenant la
     * representation en String de chaque element.
     * 
     * @return une representation en String d'une pile
     */
    public String toString() {
       
        StringBuffer sb = new StringBuffer("[");
        for (int i = stk.size()-1; i >= 0; i--) {
            sb.append(stk.elementAt(i).toString());
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();


    }

    public boolean equals(Object o) {
        // a completer
        //Q2.2
        if (o == null) {
            return false;
        }
        
        if (o == this)
			return true;

        if (!(o instanceof Pile2)) {
            return false;
        }
        if (this.taille() != ((Pile2) o).taille()) {
            return false;
        }
        if (this.capacite() != ((Pile2) o).capacite()) {
            return false;
        }

        if (this.hashCode() != ((Pile2) o).hashCode()) {
            return false;
        }
        
        // si les elements sont identiques a la meme position
        for (int i = 0; i <= this.taille() -1 ; i++) {
            if (this.stk.elementAt(i) != null) {
                if (!(this.stk.elementAt(i).equals(((Pile2) o).stk.elementAt(i)))) {
                    return false;
                }
            }
        }
        return true;      
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    /**
     * Retourne le nombre d'element d'une pile.
     * 
     * @return le nombre d'element
     */
    public int taille() {
        // a completer
        //Q2.2
        return stk.size();
    }

    /**
     * Retourne la capacite de cette pile.
     * 
     * @return le nombre d'element
     */
    public int capacite() {
        // a completer
        //Q2.2
        return this.capacite; //the stack in Java is not fixed in size; can't use stk.capacity(), it gives 10
                                
    }

} // Pile2.java
