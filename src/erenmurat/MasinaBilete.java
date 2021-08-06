package erenmurat;

import java.util.List;

public class MasinaBilete {
    private static List<Spectacol> spectacole;

    public static void main(String[] args) throws Exception {
        //citim spectacolele din fisier csv
        spectacole = CititorSpectacoleCsv.citesteSpectacole("text.txt");
        //deschidem prima fereastra "VerificaDisponibilitati"
        new VerificaDisponibilitati(spectacole);

    }
}