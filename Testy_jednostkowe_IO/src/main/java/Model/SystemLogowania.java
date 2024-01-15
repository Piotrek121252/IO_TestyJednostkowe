package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemLogowania {
    private boolean zalogowanyJakoPracownik = false;
    private boolean zalogowany = false;
    private HashMap<String, String> bazaLoginow;
    private ArrayList<String> listaPracownikow;
    private String loggedAs;

    public SystemLogowania() {
        bazaLoginow = new HashMap<>();
        listaPracownikow = new ArrayList<>();

        bazaLoginow.put("user1", "password1");
        bazaLoginow.put("user2", "password2");
        bazaLoginow.put("user3", "password3");
        bazaLoginow.put("user4", "password4");

        listaPracownikow.add("user1");
        listaPracownikow.add("user2");
        listaPracownikow.add("user4");
    }

    public void zaloguj(String login, String haslo) {
        if (bazaLoginow.containsKey(login) && bazaLoginow.get(login).equals(haslo)) {
            zalogowany = true;
            loggedAs = login;
            zalogowanyJakoPracownik = listaPracownikow.contains(login);
        } else {
            throw new IllegalArgumentException("Niepoprawne dane logowania");
        }
    }

    public void wyloguj() {
        zalogowany = false;
        zalogowanyJakoPracownik = false;
        loggedAs = null;
    }

    public boolean czyZalogowany() {
        return zalogowany;
    }
    
    public boolean czyZalogowanyJakoPracownik() {
        return zalogowanyJakoPracownik;
    }

    public String getUsername() {
        return loggedAs;
    }
}