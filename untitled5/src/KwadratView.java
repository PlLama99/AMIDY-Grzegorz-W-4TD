import javax.swing.*;
import java.awt.event.ActionListener;

public class KwadratView extends JFrame {

    private JTextField liczbaField = new JTextField(10);
    private JButton obliczButton = new JButton("Oblicz");
    private JLabel wynikLabel = new JLabel("Wynik: -");

    public KwadratView() {
        super("Kalkulator Kwadratu (MVC)");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 150);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Liczba:"));
        panel.add(liczbaField);
        panel.add(obliczButton);
        panel.add(wynikLabel);

        this.add(panel);
    }

    public String getWprowadzonaLiczba() {
        return liczbaField.getText();
    }

    public void setWynik(String wynik) {
        wynikLabel.setText("Wynik: " + wynik);
    }

    public void addObliczListener(ActionListener listener) {
        obliczButton.addActionListener(listener);
    }
}
