package erenmurat;

import java.util.ArrayList;
import java.util.List;

public class Reprezentiatie {
    private final String dataSpectacol;
    private final String oraSpectacol;
    private int numarBilete;
    private final List<String> locuri;
    private final double pretBilte;
    private final List<Cumparator> cumparatori;

    public Reprezentiatie(String dataSpectacol, String oraSpectacol, int numarBilete, double pretBilte) {
        this.dataSpectacol = dataSpectacol;
        this.oraSpectacol = oraSpectacol;
        this.numarBilete = numarBilete;
        this.pretBilte = pretBilte;
        this.cumparatori = new ArrayList<>();
        this.locuri = new ArrayList<>();
        for (int loc = 1; loc < numarBilete + 1; loc++)
            locuri.add("Pozitia " + loc);
    }

    public void adaugaCumparator(String name, String phoneNo, Bilet bilet) {
        //daca exitsa doar ii adauga un bilet nou
        for (Cumparator client : cumparatori) {
            if (client.name.equals(name)) {
                client.attachNewTicket(bilet);
                return;
            }
        }
        //altfel adauga clientul cu tot cu bilet
        cumparatori.add(new Cumparator(name, phoneNo, bilet));
    }

    public void scadeNumarBilet(int numarBilete) {
        this.numarBilete -= numarBilete;
    }

    public double getPretBilete() {
        return pretBilte;
    }

    public List<String> getLocuri() {
        return locuri;
    }

    public String candEsteSiLocuri() {
        if (numarBilete >= 0)
            return oraSpectacol + "    " + dataSpectacol + "    bilete ramase: " + numarBilete;
        return null;
    }

    public String candEste() {
        if (numarBilete >= 0)
            return oraSpectacol + "    " + dataSpectacol;
        return null;
    }
}
