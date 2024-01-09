package Model.Bilety;

import java.util.Date;

public class BiletParkingowy extends Bilet {
    private String nrRejestracyjny;
    private Date dataRozpoczecia;
    private Date dataZakonczenia;
    private char strefa;

    public BiletParkingowy(float cena, String imie, String nazwisko, String pesel, TypBiletu typ,
                           String nrRejestracyjny, Date dataRozpoczecia, Date dataZakonczenia,
                           char strefa) {
        super(cena, imie, nazwisko, pesel, typ);
        this.nrRejestracyjny = nrRejestracyjny;
        this.dataRozpoczecia = dataRozpoczecia;
        this.dataZakonczenia = dataZakonczenia;
        this.strefa = strefa;
    }

    public String wypiszInformacje(){
        return null;
    }
    public String getNrRejestracyjny(){return nrRejestracyjny;}
    public Date getDataRozpoczecia(){return dataRozpoczecia;}
    public Date getDataZakonczenia(){return dataZakonczenia;}
    public char getStrefa(){return strefa;}
}
