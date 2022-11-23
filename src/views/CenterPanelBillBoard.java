package views;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class CenterPanelBillBoard extends JPanel {

    private TarjetaVacia tarjetaVacia;
    private TarjetaThor tarjetaThor;
    private TarjetaMinions tarjetaMinions;
    private TarjetaLightYear tarjetaLightYear;
    private TarjetaTelefonoNegro tarjetaTelefonoNegro;
    private TarjetaTopGun tarjetaTopGun;
    private CardLayout cl;

    public CenterPanelBillBoard() {
        initComponents();
    }

    public void initComponents() {
        this.setBackground(Color.WHITE);
        this.setLayout(new CardLayout());
        cl = (CardLayout) this.getLayout();
        tarjetaVacia = new TarjetaVacia();
        tarjetaThor = new TarjetaThor();
        tarjetaMinions = new TarjetaMinions();
        tarjetaLightYear = new TarjetaLightYear();
        tarjetaTelefonoNegro = new TarjetaTelefonoNegro();
        tarjetaTopGun = new TarjetaTopGun();

        add(tarjetaVacia);
        add(tarjetaThor, "Thor: Amor y Trueno");
        add(tarjetaMinions, "Minions 2: Nace un Villano");
        add(tarjetaLightYear, "Ligthyear");
        add(tarjetaTelefonoNegro, "El Telefono Negro");
        add(tarjetaTopGun, "Top Gun Maverik");
    }

    public void show(String a) {
        cl.show(this, a);
    }
}
