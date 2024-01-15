package Model.Bilety;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class BiletLotniczy extends Bilet {
    public LocalDate dataWylotu;
    public String miejsceWSamolocie;
    public String lotniskoPoczatkowe;
    public String lotniskoDocelowe;
    public int nrLotu;
    public String przewoznik;
    public RodzajBagazu rodzajBagazu;

    public BiletLotniczy(float cena, String imie, String nazwisko, String pesel, TypBiletu typ,
                      LocalDate data_wylotu, String miejsceWSamolocie, String lotniskoPocz,
                      String lotniskoDocelowe, String nrLotu, String przewoznik, RodzajBagazu rodzajBagazu) {
        super(cena, imie, nazwisko, pesel, typ);
        this.dataWylotu = data_wylotu;
        this.miejsceWSamolocie = miejsceWSamolocie;
        this.lotniskoPoczatkowe = lotniskoPocz;
        this.lotniskoDocelowe = lotniskoDocelowe;
        this.nrLotu = Integer.parseInt(nrLotu);
        this.przewoznik = przewoznik;
        this.rodzajBagazu = rodzajBagazu;

    }

    public LocalDate getDataWylotu(){return dataWylotu;}
    public String getMiejsceWSamolocie(){return miejsceWSamolocie;}
    public String getLotniskoPoczatkowe() {return lotniskoPoczatkowe;}
    public String getLotniskoDocelowe(){return lotniskoDocelowe;}
    public int getNrLotu(){return nrLotu;}
    public String getPrzewoznik(){return przewoznik;}
    public String wypiszInformacje(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("\n %s\n %s\n %s\n %s\n %s\n %s\n %s\n %s\n %s\n %s",
                "Cena: " + this.getCena(),"Typ Biletu: " + this.getTyp(), "Imie: " + this.getImie(),"Nazwisko" + this.getNazwisko(),"Pesel: " + this.getPesel(),
                "Data wylotu: " + dataWylotu.format(formatter),
                "Miejsce w samolocie: " + miejsceWSamolocie,
                "Lotnisko początkowe: " + lotniskoPoczatkowe,
                "Lotnisko docelowe: " + lotniskoDocelowe,
                "Nr lotu: " + nrLotu,
                "Przewoźnik: " + przewoznik,
                "Rodzaj bagażu: " + rodzajBagazu);
    }
    public RodzajBagazu getRodzajBagazu(){return rodzajBagazu;}

}
