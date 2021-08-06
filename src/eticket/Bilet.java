package eticket;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Bilet extends JFrame {
    JPanel container;
    JButton printeaza;

    JLabel subtitlu;
    JLabel labelSpectacol;
    JLabel labelCandEste;
    JLabel labelPret;
    JLabel labelLocuriSelectate;

    public Bilet(String spectacol, double pret, List<String> locuriSelectate, String candEste) {

        //initializam componentele
        container = new JPanel(new GridLayout(6,1));
        subtitlu = new JLabel("Bilet/Abonament", SwingConstants.CENTER);
        labelSpectacol = new JLabel("Spectacol: " + spectacol, SwingConstants.CENTER);
        labelCandEste = new JLabel("Data si ora: " + candEste,  SwingConstants.CENTER);
        labelPret = new JLabel("Pret " + pret+ "LEI", SwingConstants.CENTER);
        labelLocuriSelectate = new JLabel("Locuri: " + StringDinLista(locuriSelectate),  SwingConstants.CENTER);
        printeaza = new JButton("Printeaza");

        container.add(subtitlu);
        container.add(labelSpectacol);
        container.add(labelCandEste);
        container.add(labelPret);
        container.add(labelLocuriSelectate);
        container.add(printeaza);

        add(container);
        setTitle("Bilet/Abonament");
        setVisible(true);
        setSize(480,270);
    }

    private String StringDinLista(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(", ");
        }
        return sb.toString();
    }
}
