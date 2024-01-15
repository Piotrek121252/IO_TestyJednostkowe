package Model.Rezerwacja;

import Model.Bilety.*;
import Model.Rezerwacja.PotwierdzenieZamowienia;
import Model.Rezerwacja.SystemPlatnosci;
import Model.Rezerwacja.WynikPlatnosci;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZamowienieTest {

    private Zamowienie zamowienie;
    private ArrayList<Bilet> bilety;

    @BeforeEach
    void setUp() {
        bilety = new ArrayList<>();
        
        //Dodanie Biletu lotniczego z normalnym Bagażem
        bilety.add(new BiletLotniczy(100.0f, "Jan", "Kowalski", "123456789", TypBiletu.LOTNICZY,
                LocalDate.of(2022, 1, 15), "1A", "Lotnisko A", "Lotnisko B", "012", "Linie_Lotnicze A", RodzajBagazu.NORMALNY));

        // Adding a BiletParkingowy with strefa 'A'
        bilety.add(new BiletParkingowy(50.0f, "Jan", "Kowalski", "123456789", TypBiletu.PARKINGOWY,
                "DLU_939421", LocalDate.of(2022, 1, 15), LocalDate.of(2022, 1, 18), 'A'));

        zamowienie = new Zamowienie(bilety);
    }

    @Test
    void testObliczCalkowitaKwote() {
        // Obliczenia:
        // BiletLotniczy: 100.0 + 20.0 (NORMALNY RodzajBagazu) = 120.0
        // BiletParkingowy: 50.0 (base) + 3 * 40.0 (3 dni w strefie 'A') = 170.0
        // Suma: 120.0 + 170.0 = 290.0
        float oczekiwanaWartosc = 290.0f;
        assertEquals(oczekiwanaWartosc, zamowienie.obliczCalkowitaKwote());
    }
    //To jest tylko Przykładem trzeba dodać inne bilety i sprawdzić czy się zgadza.
    //Narazie jest ta sama kwota.
    @Test
    void testObliczCalkowitaKwotePodstawoweWartosci() {
        // Obliczenia:
        // BiletLotniczy: 100.0 (base) + 0.0 = 100.0
        // BiletParkingowy: 50.0 (base) + 3 * 10.0 = 50.0
        // Suma: 100.0 + 50.0 = 150.0
        float oczekiwanaWartosc = 290.0f;
        assertEquals(oczekiwanaWartosc, zamowienie.obliczCalkowitaKwote());
    }

    @Test
    void testZrealizujZamowienieBrakPotwierdzenia() {
    //Płatność nie powinna się udać ze względu na podany numer i funkcja powinna zwrócić null    
        Assertions.assertNull(zamowienie.zrealizujZamowienie(290.0f, true, "123456789" ));
        
    }
    
    @Test
    void testZrealizujZamowienieDoOplacenia() {
    //Płatność nie powinna się udać ze względu na podany numer i funkcja powinna zwrócić null 
        PotwierdzenieZamowienia oczekiwanePotwierdzenie = new PotwierdzenieZamowienia(bilety, 290.0f, false, "132465879", LocalDate.now(), 1);
        System.out.println(oczekiwanePotwierdzenie.wyswietlZawartosc());
        Assertions.assertEquals(oczekiwanePotwierdzenie.wyswietlZawartosc(), zamowienie.zrealizujZamowienie(290.0f, true, "132465879" ).wyswietlZawartosc());
        
    }
}
