import java.awt.*;
import javax.swing.*;

public class EkranLogowania extends JFrame {

    public EkranLogowania() {
        super("Ekran logowania");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));


        JPanel panelGlowny = new JPanel();
        panelGlowny.setLayout(new GridLayout(2, 2, 5, 5));

        panelGlowny.add(new JLabel("Nick:"));
        JTextField poleUzytkownik = new JTextField(15);
        panelGlowny.add(poleUzytkownik);

        panelGlowny.add(new JLabel("Hasło:"));
        JPasswordField poleHaslo = new JPasswordField(15);
        panelGlowny.add(poleHaslo);


        JPanel panelPrzyciski = new JPanel();
        panelPrzyciski.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton btnZaloguj = new JButton("Zaloguj");
        JButton btnAnuluj = new JButton("Anuluj");

        panelPrzyciski.add(btnZaloguj);
        panelPrzyciski.add(btnAnuluj);


        add(panelGlowny, BorderLayout.CENTER);
        add(panelPrzyciski, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EkranLogowania());
    }
}
