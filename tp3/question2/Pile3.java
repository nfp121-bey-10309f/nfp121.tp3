package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 *
 * @author (Mohamed SABRA)
 * @version (v1.0)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
    //Q2.2
    private int capacite;

    public Pile3() {
        this(0);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // Q2.2
        if (taille <= 0) {
            taille = PileI.CAPACITE_PAR_DEFAUT;
        }

        capacite = taille;

        v = new Vector();
    }

    public void empiler(Object o) throws PilePleineException {
        //Q2.2
        if (estPleine()) {
            throw new PilePleineException();
        }
        v.add(o);
    }

    public Object depiler() throws PileVideException {
        //Q2.2
        if (estVide()) {
            throw new PileVideException();
        }
        Object o = v.lastElement();
        v.remove(v.lastElement());
        return o;

    }

    public Object sommet() throws PileVideException {
        //Q2.2
        return v.lastElement();
    }

    public int taille() {
        //Q2.2
        return v.size();
    }

    public int capacite() {
        //Q2.2
        return this.capacite;
    }

    public boolean estVide() {
        //Q2.2
        return v.isEmpty();
    }

    public boolean estPleine() {
        //Q2.2
        return this.capacite == v.size();
    }

    public String toString() {
        //Q2.2        
        StringBuffer sb = new StringBuffer("[");
        for (int i = v.size()-1; i >= 0; i--) {
            sb.append(v.elementAt(i).toString());
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();

    }

    public boolean equals(Object o) {
        //Q2.2
        if (o == null) {
            return false;
        }
        
        if (o == this)
			return true;

        if (!(o instanceof Pile3)) {
            return false;
        }
        if (this.taille() != ((Pile3) o).taille()) {
            return false;
        }
        if (this.capacite() != ((Pile3) o).capacite()) {
            return false;
        }

        if (this.hashCode() != ((Pile3) o).hashCode()) {
            return false;
        }
        
        // si les elements sont identiques a la meme position
        for (int i = 0; i <= this.taille() - 1; i++) {
            if (this.v.elementAt(i) != null) {

                if (!(this.v.elementAt(i).equals(((Pile3) o).v.elementAt(i)))) {
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

}
