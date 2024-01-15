package Model.Bilety;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BiletParkingowy extends Bilet {
    private String nrRejestracyjny;
    private LocalDate dataRozpoczecia;
    private LocalDate dataZakonczenia;
    private char strefa;

    public BiletParkingowy(float cena, String imie, String nazwisko, String pesel, TypBiletu typ,
                           String nrRejestracyjny, LocalDate dataRozpoczecia, LocalDate dataZakonczenia,
                           char strefa) {
        super(cena, imie, nazwisko, pesel, typ);
        this.nrRejestracyjny = nrRejestracyjny;
        this.dataRozpoczecia = dataRozpoczecia;
        this.dataZakonczenia = dataZakonczenia;
        this.strefa = strefa;
    }

    public String wypiszInformacje(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("\n %s\n %s\n %s\n %s\n %s\n %s\n %s\n %s\n %s",
                "Cena: " + this.getCena(),"Typ Biletu: " + this.getTyp(), "Imie: " + this.getImie(),"Nazwisko" + this.getNazwisko(),"Pesel: " + this.getPesel(),
                "Nr rejestracyjny: " + nrRejestracyjny,
                "Data rozpoczęcia: " + dataRozpoczecia.format(formatter),
                "Data zakończenia: " + dataZakonczenia.format(formatter),
                "Strefa: " + strefa);
    }
    public String getNrRejestracyjny(){return nrRejestracyjny;}
    public LocalDate getDataRozpoczecia(){return dataRozpoczecia;}
    public LocalDate getDataZakonczenia(){return dataZakonczenia;}
    public char getStrefa(){return strefa;}
}
