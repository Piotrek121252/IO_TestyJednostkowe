package Model.Rezerwacja;

import Model.Bilety.Bilet;

import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    private List<Bilet> zamowioneBilety = new ArrayList<>();
    private SystemPlatnosci systemPlatnosci;

    public PotwierdzenieZamowienia wygenerujPotwierdzenie(WynikPlatnosci wynikPlatnosci, float kwota){return null;}
    public Zamowienie(ArrayList<Bilet> zamowioneBilety){}
    public float obliczCalkowitaKwote(){return 0.0f;}
    public PotwierdzenieZamowienia zrealizujZamowienie(float kwota, boolean czyPlatnoscKarta, String nrKontaBank){
        return null;
    }
}
