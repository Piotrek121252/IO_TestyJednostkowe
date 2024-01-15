package Model.Rezerwacja;

import java.util.ArrayList;

public class SystemPlatnosci {
    private float kwota;
    private boolean czyPlatnoscKarta;
    private String nrKontaBank;
    private ArrayList<String> listaNrZablokowanychKont;

    public SystemPlatnosci(float kwota, boolean czyPlatnoscKarta, String nrKontaBank){
        this.kwota = kwota;
        this.czyPlatnoscKarta = czyPlatnoscKarta;
        this.nrKontaBank = nrKontaBank;
        listaNrZablokowanychKont = new ArrayList<String>() {
            {
                add("123456789");
                add("987654321");
                add("555555555");
            }  
        };
    }

    public WynikPlatnosci przetworzeniePlatnosci(){
        
        boolean platnoscUdana = autoryzacjaBanku();
        if(czyPlatnoscKarta){
            if (platnoscUdana){
                return WynikPlatnosci.OPLACONA_KARTA;
            }
            else {
                return WynikPlatnosci.BLAD_KARTA;
            }
        }else {
            return WynikPlatnosci.DO_OPLACENIA;
        }
    }
    
    // Sprawdza czy konto nie jest na czarnej liście
    private boolean autoryzacjaBanku(){
        for (String nrKonta : listaNrZablokowanychKont) {
            if (nrKonta.equals(nrKontaBank)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean czyPlatnoscKarta(){return czyPlatnoscKarta;}
}

