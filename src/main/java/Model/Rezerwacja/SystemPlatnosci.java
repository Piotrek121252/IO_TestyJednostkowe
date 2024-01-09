package Model.Rezerwacja;

public class SystemPlatnosci {
    private float kwota;
    public boolean platnoscKarta;

    public SystemPlatnosci(){
    };

    public WynikPlatnosci przetworzeniePlatnosci(float kwota, boolean czyPlatnoscKarta){
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
    };
    public boolean autoryzacjaBanku(){return false;}
    private boolean czyPlatnoscKarta(){return platnoscKarta;}
    public void wygenerujPotwierdzenie(){}
}

