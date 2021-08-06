package erenmurat;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ListaReprezentatii extends JFrame {
    private final DefaultListModel<String> model;
    private JList<String> listaReprezentatii;
    private JPanel container;
    private JButton rezervaBilete;
    private JLabel subtitlu;
    private Map<Integer, Reprezentiatie> mapRepInt;

    public ListaReprezentatii (Spectacol spectacol) {
        //initializam componente
        model = new DefaultListModel<>();
        mapRepInt = new HashMap<>();
        subtitlu = new JLabel("Reprezentatii disponibile pentru " + spectacol.getNume(), SwingConstants.CENTER);
        rezervaBilete = new JButton("Rezerva bilete");

        // lista de reprezentatii la care mai exista bilete
        int i = 0;
        for (Reprezentiatie reprezentiatie : spectacol.getReprezentatii()) {
            // afisez in lista doar reprezentatiile la care mai sunt bilete disponibile
            if (reprezentiatie.candEsteSiLocuri() != null)
                model.addElement(reprezentiatie.candEsteSiLocuri());
                //pentru a stii cate reprezentatii au ramas cu bilet si sa fie usor accesibile dupa indice
                mapRepInt.put(i++, reprezentiatie);
        }
        listaReprezentatii = new JList<>(model);
        //setam modul de selectare in lista
        listaReprezentatii.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //butonul pentru trecere in fereastra de rezervare bilete
        rezervaBilete.addActionListener(e -> {
            if (listaReprezentatii.getSelectedIndex() == -1)
                JOptionPane.showMessageDialog(container, "Nicio reprezentatie selectata");
            else {
                Reprezentiatie reprezentiatieAleasa = mapRepInt.get(listaReprezentatii.getSelectedIndex());
                dispose();
                new RezervareBilet(reprezentiatieAleasa, spectacol.getNume());
            }
        });

        //creem containerul si adaugam componentele pe el
        container = new JPanel(new GridLayout(3, 1));
        container.add(subtitlu);
        container.add(listaReprezentatii);
        container.add(rezervaBilete);
        add(container);
        setTitle("Reprezentatii disponibile");
        setSize(300, 250);
        setVisible(true);
    }
}
