package geco;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class LoginGeneratorTest extends TestCase {

    LoginGenerator lg;
    LoginService loginService;
    String prenom1 = "Paul";
    String prenom2 = "John";
    String prenom3 = "Jean";
    String nom1 = "Durand";
    String nom2 = "Ralling";
    String nom3 = "Rolling";
    String nom4 = "Dùrand";


    @Before
    protected void setUp(){
        loginService = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        lg = new LoginGenerator(loginService);
    }

    @Test
    public void testGenerateLoginForNomAndPrenom() {

        System.out.println("DEBUT DES TESTS SUR LA GENERATION DE LOGINS\n");
        setUp();
        assertEquals("Les logins générés ne correspondent pas à ceux attendus", "PDUR", lg.generateLoginForNomAndPrenom(nom1, prenom1));
        assertEquals("Mauvaise incrémentation logins identiques", "JRAL2", lg.generateLoginForNomAndPrenom(nom2, prenom2));
        assertEquals("Mauvaise incrémentation 1 logins identiques ", "JROL1", lg.generateLoginForNomAndPrenom(nom3, prenom3));
        assertEquals("Mauvaise correction des accents ", "PDUR1", lg.generateLoginForNomAndPrenom(nom4, prenom1));
        assertEquals("Nom court donne lieu à un bug", "PDU", lg.generateLoginForNomAndPrenom("Du", "Paul"));


        System.out.println("FIN DES TESTS SUR LES LOGINS EXISTANTS\n");

    }



}
