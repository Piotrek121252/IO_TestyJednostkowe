package Kontroler;

import Model.Lot;
import Model.Rezerwacja.PotwierdzenieZamowienia;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
class AplikacjaTest {

    static Stream<Arguments> stringProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"123", "Wroclaw", "Moskwa"})
        );
    }
        @ParameterizedTest
        @MethodSource("stringProvider")
    void zarzadzanieLotamiTest(String[] informacjeOLocie) {
        Aplikacja aplikacja = new Aplikacja();
        boolean czyPoprawneDane = aplikacja.sprawdzPoprawnoscDanychLot(informacjeOLocie);
        assertEquals(czyPoprawneDane, true);
        if (czyPoprawneDane) {
            Lot utworzony = new Lot(informacjeOLocie);
            assertEquals(utworzony.getLotniskoPoczatkowe(), "Wroclaw");
            assertEquals(utworzony.getLotniskoDocelowe(), "Moskwa");
            assertEquals(utworzony.getNrLotu(), 123);
            aplikacja.katalogLotow.add(utworzony);
        }
        assertFalse(aplikacja.katalogLotow.isEmpty());
        assertTrue(aplikacja.wyszukajLotParametr("123").size() == 1);
        assertTrue(aplikacja.edytujLot(123, "nrLotu", "231"));
        assertEquals(aplikacja.katalogLotow.get(0).getNrLotu(), 231);
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void rezerwujBiletyTest(String[] dane){
        Aplikacja aplikacja = new Aplikacja();
        aplikacja.katalogLotow.add(new Lot(dane));
        aplikacja.rezerwujBilety(123, 5);
        assertFalse(aplikacja.historiaZamowien.isEmpty());
    }


}
