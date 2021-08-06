package erenmurat;

import java.util.ArrayList;
import java.util.List;


public class Cumparator {
    String name;
    String phoneNo;
    List<Bilet> bilets;

    //constructor
    public Cumparator(String name, String phoneNo, Bilet bilet) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.bilets = new ArrayList<>();
        this.bilets.add(bilet);
    }

    public void attachNewTicket(Bilet bilet) {
        bilets.add(bilet);
    }
}
