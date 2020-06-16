package question2;

/**
 * Classe-test Pile2Test.
 *
 * @author (Mohamed SABRA)
 * @version (v1.0)
 *
 * Les classes-test sont document�es ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html et sont
 * bas�es sur le document � 2002 Robert A. Ballance intitul� �JUnit: Unit
 * Testing Framework�.
 *
 * Les objets Test (et TestSuite) sont associ�s aux classes � tester par la
 * simple relation yyyTest (e.g. qu'un Test de la classe Name.java se nommera
 * NameTest.java); les deux se retrouvent dans le m�me paquetage. Les
 * "engagements" (anglais : "fixture") forment un ensemble de conditions qui
 * sont vraies pour chaque m�thode Test � ex�cuter. Il peut y avoir plus d'une
 * m�thode Test dans une classe Test; leur ensemble forme un objet TestSuite.
 * BlueJ d�couvrira automatiquement (par introspection) les m�thodes Test de
 * votre classe Test et g�n�rera la TestSuite cons�quente. Chaque appel d'une
 * m�thode Test sera pr�c�d� d'un appel de setUp(), qui r�alise les engagements,
 * et suivi d'un appel � tearDown(), qui les d�truit.
 */
public class Pile2Test extends junit.framework.TestCase {
    // D�finissez ici les variables d'instance n�cessaires � vos engagements;
    // Vous pouvez �galement les saisir automatiquement du pr�sentoir
    // � l'aide du menu contextuel "Pr�sentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du pr�sentoir (les objets sans constructeur, comme int, float, etc.).

    /**
     * Constructeur de la classe-test Pile2Test
     */
    private Pile2 p1;
    private Pile2 p2;
    private Pile2 p3;

    public Pile2Test() {
    }

    /**
     * Met en place les engagements.
     *
     * M�thode appel�e avant chaque appel de m�thode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        p1 = new Pile2();
        p2 = new Pile2();
        p3 = new Pile2(2);
    }

    /**
     * Supprime les engagements
     *
     * M�thode appel�e apr�s chaque appel de m�thode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        // Lib�rez ici les ressources engag�es par setUp()
        p1 = null;
        p2 = null;
        p3 = null;
        assertNull(p1);
        assertNull(p2);
        assertNull(p3);

    }

    public void test_Pile_capacite() {
        assertEquals(PileI.CAPACITE_PAR_DEFAUT, p1.capacite());
        assertEquals(2, p3.capacite());

    }

    public void test_Pile_estPleine() throws Exception {
        PileI p = new Pile2(3);
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PilePleineException);
        }
    }

    public void test_Pile_sommet() throws Exception {
        PileI p = new Pile2(3);
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        assertEquals(" sommet ", new Integer(3), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ", new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }

    public void test_Pile_estVide() throws Exception {
        PileI p = new Pile2(3);
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question1.PileVideException);
        }

        p.empiler(4);
        assertEquals(false, p.estVide());
    }

    public void test_Pile_toString() throws Exception {
        PileI pile1 = new Pile2(3);
        assertEquals("toString", "[]", pile1.toString());
        pile1.empiler(4);
        assertEquals("toString", "[4]", pile1.toString());
        pile1.empiler(5);
        assertEquals("toString", "[5, 4]", pile1.toString());
        pile1.empiler(3);
        assertEquals("toString", "[3, 5, 4]", pile1.toString());

    }

    public void test_Pile_TailleNegative() {
        PileI p = new question2.Pile(-3);
        assertEquals(p.CAPACITE_PAR_DEFAUT, p.capacite());

    }

    public void test_Pile_equals() throws Exception {

        p1.empiler("a");
        p1.empiler(2);
        p1.empiler("c");

        p2.empiler("a");
        p2.empiler(2);
        p2.empiler("c");

        assertTrue("equals ", p1.equals(p2));
        assertTrue("equals", p2.equals(p1));
        assertTrue("equals", p1.equals(p1));

        p2.empiler(1);
        assertFalse("equals ", p1.equals(p2));

    }

    /**
     * Il ne vous reste plus qu'� d�finir une ou plusieurs m�thodes de test. Ces
     * m�thodes doivent v�rifier les r�sultats attendus � l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient d�buter par
     * "test". Vous pouvez �baucher le corps gr�ce au menu contextuel
     * "Enregistrer une m�thode de test".
     */
}
