package question2;

import question1.PilePleineException;
import question1.PileVideException;
import java.util.LinkedList;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {

    /**
     * la liste des Maillons/Elements
     */
    //private Maillon stk;
    /**
     * la capacité de la pile
     */
    private int capacite;
    /**
     * le nombre
     */
    private int nombre;

    /**
     * Classe interne "statique" contenant chaque élément de la chaine c'est
     * une proposition, vous pouvez l'ignorer !
     */
    private LinkedList linkedlist = new LinkedList();
//    private static class Maillon implements Cloneable {
//
//        private Object element;
//        private Maillon suivant;
//
//        public Maillon(Object element, Maillon suivant) {
//            this.element = element;
//            this.suivant = suivant;
//        }
//
//        public Maillon suivant() {
//            return this.suivant;
//        }
//
//        public Object element() {
//            return this.element;
//        }
//
//        public Object clone() throws CloneNotSupportedException {
//            Maillon m = (Maillon) super.clone();
//            m.element = element;
//            return m;
//        }
//    }

    /**
     * Création d'une pile.
     *
     * @param taille la taille de la pile, la taille doit être > 0
     */
    public Pile4(int taille) {
        if (taille <= 0) {
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.linkedlist = new LinkedList();
        this.capacite = taille;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine()) {
            throw new PilePleineException();
        }
        //Q2.2
        linkedlist.push(o);
        nombre++;

    }

    public Object depiler() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        }
        //Q2.2
        nombre--;
        return linkedlist.pop();
    }

    public Object sommet() throws PileVideException {
        if (estVide()) {
            throw new PileVideException();
        }
        return linkedlist.peek();
    }

    /**
     * Effectue un test de l'état de la pile.
     *
     * @return vrai si la pile est vide, faux autrement
     */
    public boolean estVide() {
        return linkedlist.isEmpty(); //Q2.2
    }

    /**
     * Effectue un test de l'état de la pile.
     *
     * @return vrai si la pile est pleine, faux autrement
     */
    public boolean estPleine() {
        return linkedlist.size() == this.capacite; //Q2.2
    }

    /**
     * Retourne une représentation en String d'une pile, contenant la
     * représentation en String de chaque élément.
     *
     * @return une représentation en String d'une pile
     */
    public String toString() {

//        String s = "[";
//        // à compléter
//        return s + "]";
        //Q2.2
        return linkedlist.toString();
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }

        if (o instanceof Pile4) {
            // à compléter
            if (this.linkedlist.size() != ((Pile4) o).linkedlist.size()) {
                return false;
            }
            if (this.capacite != ((Pile4) o).capacite) {
                return false;
            }
            if (this.hashCode() != ((Pile4) o).hashCode()) {
                return false;
            }

            if (this.linkedlist.containsAll(((Pile4) o).linkedlist)) {
                return true;
            }
        }
        return false;
    }

    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}
