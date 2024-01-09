package Model;

import java.util.ArrayList;
import java.util.HashMap;

public class SystemLogowania {
    private boolean zalogowanyJakoPracownik = false;
    private boolean zalogowany = false;
    private HashMap<String, String> bazaLoginow;
    private ArrayList<String> listaPracownikow;
    private String loggedAs;

    public SystemLogowania(){
        bazaLoginow = new HashMap<>();
        listaPracownikow = new ArrayList<>();

        bazaLoginow.put("user1", "password1");
        bazaLoginow.put("user2", "password2");
        bazaLoginow.put("user3", "password3");

        listaPracownikow.add("user1");
        listaPracownikow.add("user2");

    };
    public boolean zaloguj(String login, String haslo){
        return true;
    }
    public void wyloguj(){}
    public boolean czyZalogowanyJakoPracownik(){
        return false;
    }
    public String getUsername(){
        return loggedAs;
    }
}
