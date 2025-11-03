import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularzWeryfikacji extends JFrame {

    private JTextField poleWiek;
    private JCheckBox checkboxRegulamin;
    private JButton przyciskZatwierdz;

    public FormularzWeryfikacji() {
        super("Formularz Weryfikacji");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(350, 150);

        JLabel etykietaWiek = new JLabel("Podaj wiek:");
        poleWiek = new JTextField(6);
        checkboxRegulamin = new JCheckBox("Akceptuję regulamin");
        przyciskZatwierdz = new JButton("Zatwierdź");

        przyciskZatwierdz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tekstWiek = poleWiek.getText();
                boolean zaakceptowano = checkboxRegulamin.isSelected();

                try {
                    int wiek = Integer.parseInt(tekstWiek);

                    if (wiek >= 18 && wiek <= 120 && zaakceptowano) {
                        JOptionPane.showMessageDialog(FormularzWeryfikacji.this,
                                "pomyślne",
                                "Sukces",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(FormularzWeryfikacji.this,
                                "Wymagany wiek 18+ (i mniej niż 120) i akceptacja regulaminu",
                                "Błąd",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FormularzWeryfikacji.this,
                            "Wprowadź poprawny wiek",
                            "Błąd danych",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        this.add(etykietaWiek);
        this.add(poleWiek);
        this.add(checkboxRegulamin);
        this.add(przyciskZatwierdz);

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormularzWeryfikacji::new);
    }
}
