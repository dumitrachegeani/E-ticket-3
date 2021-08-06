package eticket;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Optional;

public class VerificaDisponibilitati extends JFrame {
    private JPanel container;
    private JTextField textSpectacol;
    private JButton butonCautare;
    private JLabel subtitlu;

    VerificaDisponibilitati(List<Spectacol> spectacole) {
        //initializez componentele
        butonCautare = new JButton("Verifica");
        textSpectacol = new HintTextField("Numele spectacolului");
        subtitlu = new JLabel("Scrieti mai jos numele spectacolului", JLabel.CENTER);

        //clasa interna de apasare pe buton (action listener)
        butonCautare.addActionListener(e -> {
            String spectacolCautat = textSpectacol.getText().trim();
            Optional<Spectacol> spectacolExistent = spectacole.stream()
                                        .filter(spectacol -> spectacol.getNume()
                                        .equals(spectacolCautat)).findFirst();
            //daca exista acest spectacol deschid fereastra de reprezentatii la care mai sunt locuri
            if (spectacolExistent.isPresent())
                new ListaReprezentatii(spectacolExistent.get());
            else
                JOptionPane.showMessageDialog(container,"Nu am gasit acest spectacol");
        });

        // adaug in container entitatile
        container = new JPanel();
        container.setLayout(new GridLayout(3, 1));
        container.add(subtitlu);
        container.add(textSpectacol);
        container.add(butonCautare);
        add(container);
        setTitle("Masina de bilete");
        setSize(300, 200);
        setVisible(true);
    }
}