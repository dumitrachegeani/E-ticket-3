package erenmurat;

import java.util.ArrayList;
import java.util.List;

public class Spectacol {
    private final String nume;
    private final List<Reprezentiatie> reprezentatii;

    public Spectacol(String nume) {
        this.nume = nume;
        this.reprezentatii = new ArrayList<>();
    }

    public String getNume() {
        return nume;
    }

    public List<Reprezentiatie> getReprezentatii() {
        return reprezentatii;
    }

    public Spectacol adaugaReprezentatie(String dataSpectacol, String oraSpectacol, int numarBilete, double pretBilte) {
        reprezentatii.add(new Reprezentiatie(dataSpectacol, oraSpectacol, numarBilete, pretBilte));
        return this;
    }
}
