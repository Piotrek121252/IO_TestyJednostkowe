package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SystemLogowaniaTest.class)
public class SystemLogowaniaTest implements TestExecutionExceptionHandler {

    private SystemLogowania systemLogowania;

    @BeforeEach
    void setUp() {
        systemLogowania = new SystemLogowania();
    }

    @Test
    void testZalogujPoprawneDanePracownik() {
        systemLogowania.zaloguj("user1", "password1");
        Assertions.assertTrue(systemLogowania.czyZalogowanyJakoPracownik());
        Assertions.assertEquals("user1", systemLogowania.getUsername());
    }
    
    @Test
    void testZalogujPoprawneDaneKlient() {
        systemLogowania.zaloguj("user3", "password3");
        Assertions.assertFalse(systemLogowania.czyZalogowanyJakoPracownik());
        Assertions.assertEquals("user3", systemLogowania.getUsername());
    }


    @Test
    void testZalogujNiepoprawneHaslo() {
        systemLogowania.zaloguj("user1", "incorrectPassword");
        Assertions.assertFalse(systemLogowania.czyZalogowany());
        Assertions.assertFalse(systemLogowania.czyZalogowanyJakoPracownik());
        Assertions.assertNull(systemLogowania.getUsername());
    }

    @ParameterizedTest
    @CsvSource({ "user1, password1", "user2, password2", "user4, password4" })
    void testZalogujParametryzowany(String login, String haslo) {
        systemLogowania.zaloguj(login, haslo);
        Assertions.assertTrue(systemLogowania.czyZalogowany());
        Assertions.assertTrue(systemLogowania.czyZalogowanyJakoPracownik());
        Assertions.assertEquals(login, systemLogowania.getUsername());
    }

    @Test
    void testWyloguj() {
        systemLogowania.zaloguj("user1", "password1");
        Assertions.assertTrue(systemLogowania.czyZalogowanyJakoPracownik());
        systemLogowania.wyloguj();
        Assertions.assertFalse(systemLogowania.czyZalogowanyJakoPracownik());
        Assertions.assertNull(systemLogowania.getUsername());
    }

    @Test
    void testZalogujExceptionHandling() {
        systemLogowania.zaloguj("InvalidUser", "wrongPassword");
        Assertions.assertFalse(systemLogowania.czyZalogowany());
        Assertions.assertFalse(systemLogowania.czyZalogowanyJakoPracownik());
        Assertions.assertNull(systemLogowania.getUsername());
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable)
            throws Throwable {
        if (throwable instanceof IllegalArgumentException) {
            System.out.println("Handling IllegalArgumentException: " + throwable.getMessage());
        } else {
            throw throwable;
        }
    }
}