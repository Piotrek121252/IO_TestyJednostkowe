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
    public TypBiletu getTyp(){return null;};
    public float getCena(){return 0.0f;}
    public String getImie(){return null;}
    public String getNazwisko(){return null;}
    public String getPesel(){return null;}
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

