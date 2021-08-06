package erenmurat;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Plata extends JFrame {
    private JPanel container;
    private JButton plateste;
    private JLabel subtitlu;
    private JTextField textNume;
    private JTextField textTelefon;
    private JTextField textPret;

    private JLabel labelNume;
    private JLabel labelTelefon;
    private JLabel labelPret;

    public Plata(String spectacol, Reprezentiatie reprezentiatie, double pret, List<String> locuriSelectate) {
        //initializam campurile
        textNume = new HintTextField("Nume si prenume");
        textTelefon = new HintTextField("Numar de telefon");
        textPret = new HintTextField("Pret");

        labelNume = new JLabel("Nume si prenume: ");
        labelTelefon = new JLabel("Numar de telefon: ");
        labelPret = new JLabel("Introduceti suma");
        subtitlu = new JLabel("Trebuie sa platititi: " + pret + "LEI");

        //adaugam action listener pe buton (plateste)
        plateste = new JButton("Plateste");
        plateste.addActionListener(event -> {
            Double sumaPrimita;
            // in caz ca nu primit numar in acel text field
            try {
                sumaPrimita = Double.parseDouble(textPret.getText());
            }
            catch (NumberFormatException e) {
                sumaPrimita = null;
            }
            if ( sumatNenulaSiSuficienta(sumaPrimita, pret) ) {
                //aici elimin locurile ocupate din locurile disponibile
                reprezentiatie.getLocuri().removeAll(locuriSelectate);
                //scad numarul de bilete pentru aceasta reprezentatie
                reprezentiatie.scadeNumarBilet(locuriSelectate.size());
                //adaug cumparatorul in lista de cumparatori si afisez mesajul de confirmare al achizitiei
                JOptionPane.showMessageDialog(container, "Felicitari, ati achizitionat biletul/biletele cu succes");
                reprezentiatie.adaugaCumparator(textNume.getText(), textTelefon.getText(),
                        new Bilet(spectacol, pret, locuriSelectate, reprezentiatie.candEste()));
                dispose();
            }
        });

        // adaug componentele
        container = new JPanel(new GridLayout(4, 2));
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.add(labelNume);
        container.add(textNume);
        container.add(labelTelefon);
        container.add(textTelefon);
        container.add(labelPret);
        container.add(textPret);
        container.add(plateste);
        container.add(subtitlu);

        add(container);
        setTitle("Plata");
        setSize(400, 250);
        setVisible(true);
    }

    //metoda pentru a verifica suma data de cumparator
    private boolean sumatNenulaSiSuficienta(Double sumaPrimita, Double pret) {
        if (sumaPrimita == null) {
            JOptionPane.showMessageDialog(container, "Va rugam introduceti o suma valida");
            return false;
        }
        else if (sumaPrimita < pret) {
            JOptionPane.showMessageDialog(container, "Mai adaugati " + (pret-sumaPrimita) + " LEI");
            return false;
        }
        else if (sumaPrimita > pret) {
            JOptionPane.showMessageDialog(container, "Uitati restul dvs: " + (sumaPrimita - pret) + " LEI");
            return true;
        }
        return true;
    }
}
