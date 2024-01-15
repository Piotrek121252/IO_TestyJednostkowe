package Model.Bilety;

public abstract class Bilet {
    private float cena;
    private String imie;
    private String nazwisko;
    private String pesel;
    private TypBiletu typ;

    public Bilet(float cena, String imie, String nazwisko, String pesel, TypBiletu typ){
        this.cena = cena;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.typ = typ;
    }
    public TypBiletu getTyp(){return typ;};
    public float getCena(){return cena;}
    public String getImie(){return imie;}
    public String getNazwisko(){return nazwisko;}
    public String getPesel(){return pesel;}
    public abstract String wypiszInformacje();

    @Override
    public String toString() {
        return "Bilet{" +
                "cena= " + cena + " zl" +
                ", typ biletu ='" + typ.toString() + '\'' +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                '}';
    }
}

