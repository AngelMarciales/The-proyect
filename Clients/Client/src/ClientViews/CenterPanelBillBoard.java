package ClientViews;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class CenterPanelBillBoard extends JPanel {

    private Tarjeta[] tarjetaVacia;

    private CardLayout cl;

    public CenterPanelBillBoard() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        this.setLayout(new CardLayout());
        cl = (CardLayout) this.getLayout();
        tarjetaVacia = new Tarjeta[15];
    }

    public void addTarjet(String[] routes, String[] names){
        for (int i = 0; i <= tarjetaVacia.length; i++) {
            if(i < routes.length){
                tarjetaVacia[i] = new Tarjeta();
                tarjetaVacia[i].setIcon(routes[i]);
                add(tarjetaVacia[i], names[i]);
            }
        }

    }

    public void show(String a) {
        cl.show(this, a);
    }
}
