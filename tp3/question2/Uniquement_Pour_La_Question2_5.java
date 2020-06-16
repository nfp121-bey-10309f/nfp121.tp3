package question2;

public class Uniquement_Pour_La_Question2_5 extends junit.framework.TestCase{
    public void test_equals_question2_5() throws Exception{
        // sélection de la zone commentée ci-dessous, puis F7 sous bluej, si vous adoptez la méthode equals de Q2.5
        
        
        //When a hashcode() comparison returns false, the equals() method must also return false. 
        //If the hashcode is different, then the objects are definitely not equal.
        
        
        //When the hashcode comparison returns true     The equals() method should return true OR FALSE. so we can't only use the Hashcode
        
        // Details
        //https://www.javaworld.com/article/3305792/comparing-java-objects-with-equals-and-hashcode.html
        
        
        
        //Pour la deuxieme methode 
         /*public boolean equals(Object o) {
         /*    return this.toString().equals(o.toString());
        } 
            What if the we have an Object of type String ="1",
            And another Object of type Integer = 1,
            both will evaluate to 1 in the toString function
            
            Therefore, it's not enough to use the toString() function to check equality.
        */
        
        
        // PileI p  = new Pile(4);
        // PileI p1 = new Pile(6);
        // PileI p2 = new Pile2(6);
        // PileI p3 = new Pile3(6);
        // PileI p4 = new Pile4(6);

        // assertFalse(p.equals(p1));
        // assertTrue(p1.equals(p2) && p2.equals(p1)); // etc ...
        // assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
        // assertTrue(p2.equals(p3) && p3.equals(p4) && p2.equals(p4));// etc ...

        // p1.empiler(3);p1.empiler(33);p2.empiler(3);p2.empiler(33);p3.empiler(3);p3.empiler(33);p4.empiler(3);p4.empiler(33);
        // assertTrue(p1.equals(p2) && p2.equals(p1)); // etc ...
        // assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
        // assertTrue(p2.equals(p3) && p3.equals(p4) && p2.equals(p4));

        // p1.empiler(4);p1.empiler(44);p2.empiler(4);p2.empiler(44);
        // assertTrue(p1.equals(p2) && p2.equals(p1)); // etc ...
        // assertTrue(p1.equals(p2) && !p2.equals(p3) && !p1.equals(p3));
        // assertTrue(!p2.equals(p3) && p3.equals(p4) && !p2.equals(p4));

        // p3.empiler(4);p3.empiler(44);p4.empiler(4);p4.empiler(44);
        // assertTrue(p1.equals(p2) && p2.equals(p1)); // etc ...
        // assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
        // assertTrue(p2.equals(p3) && p3.equals(p4) && p2.equals(p4));

        // p1.depiler();p2.depiler();
        // assertTrue(p1.equals(p2) && p2.equals(p1)); // etc ...
        // assertTrue(p1.equals(p2) && !p2.equals(p3) && !p1.equals(p3));
        // assertTrue(!p2.equals(p3) && p3.equals(p4) && !p2.equals(p4));

        // p3.depiler();p4.depiler();
        // assertTrue(p1.equals(p2) && p2.equals(p1)); // etc ...
        // assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
        // assertTrue(p2.equals(p3) && p3.equals(p4) && p2.equals(p4));

        // p1.depiler();p2.depiler();p3.depiler();p4.depiler();
        // assertTrue(p1.equals(p2) && p2.equals(p1)); // etc ...
        // assertTrue(p1.equals(p2) && p2.equals(p3) && p1.equals(p3));
        // assertTrue(p2.equals(p3) && p3.equals(p4) && p2.equals(p4));
    }
}
