package eticket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RezervareBilet extends JFrame {
    private JPanel container;
    private JLabel labelPret;
    private JButton calculeaza;
    private JButton adaugaInCos;
    private JList<String> locuriLibere;
    private DefaultListModel<String> model;
    private JScrollPane scrollContainer;
    private List<String> locuriSelectate;
    private double pretTotal;

    public RezervareBilet(Reprezentiatie reprezentiatie, String numeSpectacol) {
        // initializez componentele
        calculeaza = new JButton("Calculeaza pret");
        adaugaInCos = new JButton("Adauga in cos");
        labelPret = new JLabel();
        // elemente pentru lista
        model = new DefaultListModel<>();
        locuriLibere = new JList<>(model);
        locuriLibere.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        // pun in modelul listei locurile libere din reprezentatie
        for (String loc : reprezentiatie.getLocuri()) {
            model.addElement(loc);
        }
        scrollContainer = new JScrollPane(locuriLibere);

        // adaug action listener pe buton
        calculeaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculeazaPret(reprezentiatie);
            }
        });
        // adaug action listener pe buton
        adaugaInCos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculeazaPret(reprezentiatie);
                // acum mergem sa platim
                dispose();
                new Plata(numeSpectacol, reprezentiatie, pretTotal, locuriSelectate);
            }
        });
        // creem containerul si punem totul in el in ordine
        container = new JPanel(new GridLayout(2, 2));
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        container.add(scrollContainer);
        container.add(labelPret);
        container.add(calculeaza);
        container.add(adaugaInCos);

        add(container);
        setSize(500, 400);
        setTitle("Rezervare bilete");
        setVisible(true);
    }


    // calculeaza pretul biletelor si schimba textul labelului pret cu suma data
    private void calculeazaPret(Reprezentiatie reprezentiatie) {
        //iau locurile selectate si le scad din cele libere abia dupa ce primesc banii
        locuriSelectate = locuriLibere.getSelectedValuesList();
        pretTotal = locuriSelectate.size() * reprezentiatie.getPretBilete();
        //calulam pretul pentru biletele selectate si il afisam in label
        labelPret.setText("Pret total " + pretTotal + "LEI");
    }
}
