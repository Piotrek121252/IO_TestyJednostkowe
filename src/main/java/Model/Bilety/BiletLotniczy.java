package Model.Bilety;

import java.util.Date;

public class BiletLotniczy extends Bilet {
    public Date dataWylotu;
    public String miejsceWSamolocie;
    public String lotniskoPoczatkowe;
    public String lotniskoDocelowe;
    public int nrLotu;
    public String przewoznik;
    public RodzajBagazu rodzajBagazu;

    public BiletLotniczy(float cena, String imie, String nazwisko, String pesel, TypBiletu typ,
                      Date data_wylotu, String miejsceWSamolocie, String lotniskoPocz,
                      String lotniskoDocelowe, String nrLotu, String przewoznik) {
        super(cena, imie, nazwisko, pesel, typ);
        this.dataWylotu = data_wylotu;
        this.miejsceWSamolocie = miejsceWSamolocie;
        this.lotniskoPoczatkowe = lotniskoPocz;
        this.lotniskoDocelowe = lotniskoDocelowe;
        this.nrLotu = Integer.parseInt(nrLotu);
        this.przewoznik = przewoznik;

    }

    public Date getDataWylotu(){return dataWylotu;}
    public String getMiejsceWSamolocie(){return miejsceWSamolocie;}
    public String getLotniskoPoczatkowe() {return lotniskoPoczatkowe;}
    public String getLotniskoDocelowe(){return lotniskoDocelowe;}
    public int getNrLotu(){return nrLotu;}
    public String getPrzewoznik(){return przewoznik;}
    public String wypiszInformacje(){
        return null;
    }
    public RodzajBagazu getRodzajBagazu(){return rodzajBagazu;}

}
