package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 *
 * @author (Mohamed SABRA)
 * @version (v1.0)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        // traiter le cas <=0        
        //Q2.1
        if (taille <= 0) {
            taille = PileI.CAPACITE_PAR_DEFAUT;
        }
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(0);
    }

    public void empiler(Object o) throws PilePleineException {
        //Q2.1
        if (estPleine()) {
            throw new PilePleineException();
        }
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        //Q2.1
        if (estVide()) {
            throw new PileVideException();
        }
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        //Q2.1
        if (estVide()) {
            throw new PileVideException();
        }
        return this.zone[this.ptr - 1];
    }

    public int capacite() {
        //Q2.1
        return this.zone.length;
    }

    public int taille() {
        //Q2.1
        return this.ptr;
    }

    public boolean estVide() {
        //Q2.1
        return ptr == 0;
    }

    public boolean estPleine() {
        //Q2.1
        return ptr == zone.length;

    }

    public boolean equals(Object o) {
        //La méthode equals teste l'égalité de deux Piles :
        //Deux piles sont égales si elles ont 
        //la même taille, 
        //même capacité, 
        //et les éléments contenus identiques.

        if (o == null) {
            return false;
        }
        if (o == this)
			return true;

        if (!(o instanceof Pile)) {
            return false;
        }
        if (this.taille() != ((Pile) o).taille()) {
            return false;
        }
        if (this.capacite() != ((Pile) o).capacite()) {
            return false;
        }

        if (this.hashCode() != ((Pile) o).hashCode()) {
            return false;
        }

        for (int i = 0; i < this.taille()-1; i++) {
            if (this.zone[i] != null) {

                if (!(this.zone[i].equals(((Pile) o).zone[i]))) {
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

    public String toString() {
        //Q2.1
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
