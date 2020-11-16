package geco;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LoginGeneratorTest extends TestCase {

    LoginGenerator lg;
    LoginService ls;
    private String[] logins;
    String prenom1 = "Paul";
    String prenom2 = "Pierre";
    String nom1 = "Dupont";
    String nom2 = "Dupard";
    String prenom3 = "étienne";


    @Before
    protected void setUp(){
        logins = new String[] {"tonyFication", "bruh333", "marcoLeDéglingo", "tonySuka", "Obama"};
        ls = new LoginService(logins);
        lg = new LoginGenerator(ls);
    }

    @Test
    public void testGenerateLoginForNomAndPrenom() {

        System.out.println("DEBUT DES TESTS SUR LA GENERATION DE LOGINS\n");
        setUp();
        assertEquals("Les logins générés ne correspondent pas à ceux attendus", "PDUP", lg.generateLoginForNomAndPrenom(nom1, prenom1));
        assertEquals("Les logins générés ne correspondent pas à ceux attendus", "PDUP1", lg.generateLoginForNomAndPrenom(nom2, prenom2));
        assertEquals("L'accent n'a pas correctement été retiré", "EDUP", lg.generateLoginForNomAndPrenom(nom1, prenom3));


        System.out.println("FIN DES TESTS SUR LES LOGINS EXISTANTS\n");

    }



}
