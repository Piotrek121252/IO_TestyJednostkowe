package Model;

import java.util.Date;

public class Lot {
    private int nrLotu;
    private int iloscMiejsc;
    private int iloscWolnychMiejsc;
    private String lotniskoPoczatkowe;
    private String lotniskoDocelowe;
    private Date dataWylotu;
    private String przewoznik;
    private float cenaZaMiejsce;

    public Lot(int nrLotu, int iloscMiejsc, int iloscWolnychMiejsc, String lotniskoPoczatkowe,
               String lotniskoDocelowe, Date dataWylotu, String przewoznik, float cenaZaMiejsce){
    }
    public Lot(String[] informacjeOLocie){
        this.nrLotu = Integer.parseInt(informacjeOLocie[0]);
        this.lotniskoPoczatkowe = informacjeOLocie[1];
        this.lotniskoDocelowe = informacjeOLocie[2];
    }
    public int getNrLotu(){return nrLotu;}
    public int getIloscMiejsc(){return iloscMiejsc;}
    public int getIloscWolnychMiejsc(){return 120;}
    public String getLotniskoPoczatkowe(){return lotniskoPoczatkowe;}
    public String getLotniskoDocelowe(){return lotniskoDocelowe;}
    public Date getDataWylotu(){return dataWylotu;}
    public String getPrzewoznik(){return przewoznik;}
    public float getCenaZaMiejsce(){return cenaZaMiejsce;}

    @Override
    public String toString() {//metoda na potrzeby testow
        return "Lot{" +
                "nr=" + nrLotu +
                ", lotnisko poczatkowe='" + lotniskoPoczatkowe + '\'' +
                ", lotnisko docelowe='" + lotniskoDocelowe + '\'' +
                '}';
    }
}
