package geco;


import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class LoginServiceTest extends TestCase {

    private String[] logins;
    LoginService ls;

    @Before
    protected void setUp(){
        logins = new String[] {"tonyFication", "bruh333", "marcoLeDéglingo", "tonySuka", "Obama"};
        ls = new LoginService(logins);


    }

    @Test
    public void testLoginsExistants() {

        System.out.println("DEBUT DES TESTS SUR LES LOGINS EXISTANTS\n");
        setUp();
        for (int i = 0; i < 5; i++){
            assertEquals("Ces logins sont censés déjà exister", true, ls.loginExists(logins[i]));
        }


        System.out.println("FIN DES TESTS SUR LES LOGINS EXISTANTS\n");

    }

    @Test
    public void testAddLogin(){

        System.out.println("DEBUT DES TESTS SUR L'AJOUT D'UN LOGIN\n");
        setUp();
        ls.addLogin("Ougabouga2898");
        assertEquals("Ce login doit être ajouté", true, ls.loginExists("Ougabouga2898"));


        System.out.println("FIN DES TESTS SUR L'AJOUT D'UN LOGIN\n");
    }

    public void testfindAllLoginsStartingWith(){

        System.out.println("DEBUT DES TESTS SUR LA RECHERCHE DE LOGIN\n");
        setUp();
        ArrayList<String> loginsPrefixes = new ArrayList<String>();
        loginsPrefixes.add("tonyFication");
        loginsPrefixes.add("tonySuka");

        assertArrayEquals("Erreur : pas assez de tony trouvés.", loginsPrefixes.toArray(), ls.findAllLoginsStartingWith("tony").toArray());


        System.out.println("FIN DES TESTS SUR LA RECHERCHE DE LOGIN\n");
    }

}
