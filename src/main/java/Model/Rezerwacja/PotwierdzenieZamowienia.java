package Model.Rezerwacja;

import Model.Bilety.Bilet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PotwierdzenieZamowienia {
    private List<Bilet> oplacone_bilety = new ArrayList<>();
    private boolean do_oplacenia;
    private float kwota;
    private String nrKontaBank;
    private Date dataWygenerowania;
    private int idPotwierdzenia;

    public PotwierdzenieZamowienia(List<Bilet> oplacone_bilety, float kwota, boolean doOplacenia, String nrKontaBank,
                                   Date dataWygenerowania, int idPotwierdzenia){}
    public String wyswietlZawartosc(){return nrKontaBank;}
    public int getIdPotwierdzenia(){return 0;}
}
