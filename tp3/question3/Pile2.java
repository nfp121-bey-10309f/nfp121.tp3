package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T> {

    /**
     * par délégation : utilisation de la class Stack
     */
    private Stack<T> stk;
    /**
     * la capacité de la pile
     */
    private int capacite;

    /**
     * Création d'une pile.
     *
     * @param taille la "taille maximale" de la pile, doit être > 0
     */
    public Pile2(int taille) {
        if (taille <= 0) {
            taille = PileI.CAPACITE_PAR_DEFAUT;
        }
        this.capacite = taille;

        stk = new Stack<T>();
    }

    public Pile2() {
        this(0);
    }

    public void empiler(T o) throws PilePleineException {
        if (estPleine()) {
            throw new PilePleineException();
        } else {
            stk.push(o);
        }
    }

    public T depiler() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        } else {
            T t = stk.pop();
            return t;
        }
    }

    public T sommet() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        }
        return stk.peek();
    }

    public boolean estPleine() {
        return this.capacite == stk.size();

    }

    public boolean estVide() {
        return stk.isEmpty();
    }

    public int taille() {
        return stk.size();
    }

    public int capacite() {
        return this.capacite();
    }

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
        if (this.taille() != ((Pile2<T>) o).taille()) {
            return false;
        }
        if (this.capacite() != ((Pile2<T>) o).capacite()) {
            return false;
        }

        if (this.hashCode() != ((Pile2<T>) o).hashCode()) {
            return false;
        }
        
        // si les elements sont identiques a la meme position
        for (int i = 0; i <= this.taille() -1 ; i++) {
            if (this.stk.elementAt(i) != null) {
                if (!(this.stk.elementAt(i).equals(((Pile2<T>) o).stk.elementAt(i)))) {
                    return false;
                }
            }
        }
        return true;      
    }
    // recopier ici toutes les autres méthodes
    // qui ne sont pas modifiées en fonction
    // du type des éléments de la pile
} // Pile2
