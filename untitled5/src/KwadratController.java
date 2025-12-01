import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class KwadratController {

    private KwadratModel model;
    private KwadratView view;

    public KwadratController(KwadratModel model, KwadratView view) {
        this.model = model;
        this.view = view;

        this.view.addObliczListener(new ObliczListener());
    }

    class ObliczListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String tekst = view.getWprowadzonaLiczba();
                int liczba = Integer.parseInt(tekst);

                int wynik = model.obliczKwadrat(liczba);

                view.setWynik(String.valueOf(wynik));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(
                        null,
                        "Błąd: Wprowadź poprawną liczbę całkowitą!",
                        "Nieprawidłowe dane",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
}
