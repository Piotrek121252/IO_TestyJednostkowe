package Model.Rezerwacja;

import Model.Bilety.Bilet;
import Model.Bilety.BiletLotniczy;
import Model.Bilety.BiletParkingowy;
import Model.Bilety.TypBiletu;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


import java.util.ArrayList;
import java.util.List;

public class Zamowienie {
    private List<Bilet> zamowioneBilety;
    private SystemPlatnosci systemPlatnosci;
    
    public Zamowienie(ArrayList<Bilet> zamowioneBilety)
    {
        this.zamowioneBilety = zamowioneBilety;
    }
    
    public PotwierdzenieZamowienia wygenerujPotwierdzenie(WynikPlatnosci wynikPlatnosci, float kwota){return null;}
    
    public float obliczCalkowitaKwote(){
        float calkowitaKwota = 0.0f;
        for(Bilet bilet : zamowioneBilety) {
            calkowitaKwota += obliczKwoteZaBilet(bilet);
        }
        return calkowitaKwota;
    }
    public PotwierdzenieZamowienia zrealizujZamowienie(float kwota, boolean czyPlatnoscKarta, String nrKontaBank){
        this.systemPlatnosci = new SystemPlatnosci(kwota, czyPlatnoscKarta, nrKontaBank);
        WynikPlatnosci wynikPlatnosci = systemPlatnosci.przetworzeniePlatnosci();
        
        if(wynikPlatnosci == WynikPlatnosci.BLAD_KARTA)
            return null;
        else {
            boolean do_oplacenia;
        
        do_oplacenia = wynikPlatnosci != WynikPlatnosci.OPLACONA_KARTA;
        //Trzeba jakoś te idPotwierdzenia zmienić
        return new PotwierdzenieZamowienia(zamowioneBilety, kwota, do_oplacenia, nrKontaBank, LocalDate.now(), 1);
        }
        
    }
    
    private float obliczKwoteZaBilet(Bilet bilet) {
        float podstawowaCena = bilet.getCena();
        float dodatkowaCena = 0.0f;
        
        if (bilet.getTyp() == TypBiletu.LOTNICZY) {
            dodatkowaCena = switch (((BiletLotniczy)bilet).getRodzajBagazu()) {
                case NORMALNY -> 20.0f;
                case DOPLATA -> 30.0f;
                default -> 0.0f;
            };
        } else if(bilet.getTyp() == TypBiletu.PARKINGOWY) {
            long iloscDni = ChronoUnit.DAYS.between(((BiletParkingowy)bilet).getDataRozpoczecia(), ((BiletParkingowy)bilet).getDataZakonczenia());
             
            dodatkowaCena = switch (((BiletParkingowy)bilet).getStrefa()) {
                case 'A' -> iloscDni * 40.0f;
                case 'B' -> iloscDni * 30.0f;
                case 'C' -> iloscDni * 20.0f;
                default -> iloscDni * 10.0f;
            };
        
    }
    return podstawowaCena + dodatkowaCena;
}
}