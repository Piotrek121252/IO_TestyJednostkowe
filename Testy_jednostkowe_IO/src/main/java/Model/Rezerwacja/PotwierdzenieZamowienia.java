package Model.Rezerwacja;

import Model.Bilety.Bilet;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class PotwierdzenieZamowienia {
    private List<Bilet> oplacone_bilety = new ArrayList<>();
    private float kwota;
    private boolean do_oplacenia;
    private String nrKontaBank;
    private LocalDate dataWygenerowania;
    private int idPotwierdzenia;

    public PotwierdzenieZamowienia(List<Bilet> oplacone_bilety, float kwota, boolean do_oplacenia, String nrKontaBank, LocalDate dataWygenerowania, int idPotwierdzenia){
        this.oplacone_bilety = oplacone_bilety;
        this.kwota = kwota;
        this.do_oplacenia = do_oplacenia;
        this.nrKontaBank = nrKontaBank;
        this.dataWygenerowania = dataWygenerowania;
        this.idPotwierdzenia = idPotwierdzenia;
    }
    public String wyswietlZawartosc(){
        StringBuilder zawartosc = new StringBuilder();
        zawartosc.append("Potwierdzenie zamówienia ID: ").append(idPotwierdzenia).append("\n");
        zawartosc.append("Data wygenerowania: ").append(dataWygenerowania).append("\n");
        zawartosc.append("Nr konta bankowego: ").append(nrKontaBank).append("\n");
        zawartosc.append("Kwota: ").append(kwota).append("\n");
        zawartosc.append("Do opłacenia: ").append(do_oplacenia).append("\n");
        zawartosc.append("Opłacone bilety: \n");

        for (Bilet bilet : oplacone_bilety) {
            zawartosc.append(bilet.wypiszInformacje()).append("\n");
        }

        return zawartosc.toString();
    }
    public int getIdPotwierdzenia(){return idPotwierdzenia;}
}
