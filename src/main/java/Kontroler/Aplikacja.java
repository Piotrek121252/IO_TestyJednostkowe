package Kontroler;

import Model.Bilety.Bilet;
import Model.Bilety.BiletLotniczy;
import Model.Bilety.BiletParkingowy;
import Model.Bilety.TypBiletu;
import Model.Lot;
import Model.Rezerwacja.PotwierdzenieZamowienia;
import Model.Rezerwacja.SystemPlatnosci;
import Model.Rezerwacja.WynikPlatnosci;
import Model.Rezerwacja.Zamowienie;
import Model.SystemLogowania;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Aplikacja {
    public static void main(String[] args){
        Aplikacja app = new Aplikacja();
        app.zarzadzanieLotami();
        app.rezerwujBilety(123, 2);
    }
    private ArrayList<Lot> katalogLotow = new ArrayList<>();
    private SystemLogowania sesjaUzytkownika = new SystemLogowania();
    private ArrayList<PotwierdzenieZamowienia> historiaZamowien = new ArrayList<>();
    private Zamowienie realizowaneZamowienie;

    public Aplikacja(){}
    public void setKatalog(List<Lot> kat){}
    public void wyswietlKatalog(){}
    public void rezerwujBilety(int nr_lotu, int iloscBiletow){
        Lot znalezionyLot = wyszukajLot(nr_lotu);
        if (znalezionyLot != null && katalogLotow.indexOf(znalezionyLot) != -1){
            int iloscWolnychMiejsc = znalezionyLot.getIloscWolnychMiejsc();
            if (iloscWolnychMiejsc >= iloscBiletow){
                ArrayList<Bilet> zamowioneBilety = new ArrayList<>();
                for (int i = 0; i < iloscBiletow; i++){
                    BiletLotniczy biletLotniczy = new BiletLotniczy(22.5F, "Czlowiek ", String.valueOf(i),
                            "11223344556", TypBiletu.LOTNICZY, new Date(), "22 pod oknem",
                            "Wroclaw", "Moskwa", String.valueOf(nr_lotu), "Ryanair");
                    zamowioneBilety.add(biletLotniczy);
                    boolean czyBiletParkingowy = true;
                    if (czyBiletParkingowy){
                        BiletParkingowy biletPark = new BiletParkingowy(22.5F, "Czlowiek ", String.valueOf(i),
                                "11223344556", TypBiletu.PARKINGOWY,"DWASDXD", new Date(), new Date(225, 10, 20), '0');
                        zamowioneBilety.add(biletPark);
                    }
                }
                //to dla testów:
                for (Bilet b:zamowioneBilety) {
                    System.out.println(b.toString());
                }

                realizowaneZamowienie = new Zamowienie(zamowioneBilety);
                SystemPlatnosci systemPlatnosci = new SystemPlatnosci();
                float obliczonaKwota = realizowaneZamowienie.obliczCalkowitaKwote();
                boolean czyPlatnoscKarta = systemPlatnosci.platnoscKarta;
                realizowaneZamowienie.zrealizujZamowienie(obliczonaKwota, true, "21938018403");
                WynikPlatnosci wynikPlatnosci = systemPlatnosci.przetworzeniePlatnosci(obliczonaKwota, true);

                PotwierdzenieZamowienia potwierdzenieZamowienia =
                        realizowaneZamowienie.wygenerujPotwierdzenie(wynikPlatnosci, obliczonaKwota);

                if(potwierdzenieZamowienia != null){
                    String zawartoscPotwierdzenia = potwierdzenieZamowienia.wyswietlZawartosc();
                    int idPotwierdzenia = potwierdzenieZamowienia.getIdPotwierdzenia();
                    wyswietlPotwierdzenie(idPotwierdzenia, zawartoscPotwierdzenia);
                    historiaZamowien.add(potwierdzenieZamowienia);
                    System.out.println("Udalo sie dokonac zamowienia");
                }
                else{
                    wyswietlBlad("Nie udalo sie wygenerowac potwierdzenia");
                }
            }
        }

    }
    private Lot wyszukajLot(int nrLotu){
        //na potrzeby testow
        return katalogLotow.get(0);
    }
    public void wyswietlPotwierdzenie(int idPotwierdzenia, String zawartoscPotwierdzenia){}
    public void zarzadzanieLotami(){
        int bledneProby = 0;
        boolean Zalogowany = false;
        while(bledneProby < 3 && !Zalogowany){
            //na potrzeby testow
            System.out.println("Podaj login i haslo");
            String login = "login";
            String haslo = "haslo";
            //
            Zalogowany = sesjaUzytkownika.zaloguj(login, haslo);
            if (!Zalogowany){
                wyswietlBlad("bledne logowanie");
                bledneProby++;
                if(bledneProby == 3){
                    return;
                }
            }
        }
        String Username = sesjaUzytkownika.getUsername();
        int choice;
        do {
            wyswietlMenuZarzadzania(Username);
            //na potrzeby testow
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            //
            if (choice == 1) {
                String[] informacjeOLocie = new String[]{"123", "Wroclaw", "Moskwa"}; //dane na potrzeby testow
                boolean czyPoprawneDane = sprawdzPoprawnoscDanychLot(informacjeOLocie);
                if (czyPoprawneDane) {
                    Lot utworzony = new Lot(informacjeOLocie);
                    katalogLotow.add(utworzony);
                    //wyswietlenie lotów na potrzeby testow
                    for (Lot l : katalogLotow) {
                        System.out.println(l.toString());
                    }
                    //
                }
                ;
            } else if (choice == 2) {
                String parametrWyszukiwania = "123"; // na potrzeby testu
                ArrayList<Lot> lotyDoWyswietlenia = wyszukajLotParametr(parametrWyszukiwania);
                wyswietlListeLotow(lotyDoWyswietlenia);
            } else if (choice == 3) {
                boolean bladEdycji = edytujLot(123, "123", "123"); // dane na potrzeby testow
                if (bladEdycji){
                    wyswietlBlad("Nie udalo sie edytowac lotu");
                }
            }
            else{

            }
        } while (choice != 0);
        if(choice == 0){
            sesjaUzytkownika.wyloguj();
        }
    }
    private void wyswietlMenuZarzadzania(String loggedAs){
        System.out.println("0 - wyloguj, 1 - dodaj lot, 2 - wyszukaj lot, 3 - edytuj lot");
    }
    private boolean sprawdzPoprawnoscDanychLot(String[] informacjeDoWeryfikacji){return true;}
    private ArrayList<Lot> wyszukajLotParametr(String parametrWyszukiwania){
        if (!katalogLotow.isEmpty()){
            return katalogLotow;
        }
        return null;}
    private boolean dodajLot(String[] dane){return false;} //chyba niepotrzebne?
    private void wyswietlListeLotow(ArrayList<Lot> lotyDoWyswietlenia){
        for (Lot l: lotyDoWyswietlenia) {
            System.out.println(l.toString());
        }
    }
    private boolean edytujLot(int nrLotu, String parametr, String wartosc){return true;}
    private void wyswietlBlad(String komunikat){}
}
