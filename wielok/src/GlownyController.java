import javax.swing.*;

public class GlownyController {

    private GlownyView view;
    private UzytkownikModel model;

    public GlownyController(GlownyView view, UzytkownikModel model) {
        this.view = view;
        this.model = model;

        initListeners();
    }

    private void initListeners() {

        view.loginButton.addActionListener(e -> {

            String login = view.loginField.getText();
            String haslo = new String(view.passField.getPassword());

            view.loginButton.setEnabled(false);
            view.ustawStatus("Trwa weryfikacja danych...");

            new SwingWorker<Boolean, Void>() {

                @Override
                protected Boolean doInBackground() throws Exception {
                    return model.walidujLogowanie(login, haslo);
                }

                @Override
                protected void done() {
                    try {
                        boolean wynik = get();

                        if (wynik) {
                            view.ustawStatus("Logowanie pomyślne!");
                        } else {
                            view.ustawStatus("Błędny login lub hasło!");
                        }

                    } catch (Exception ex) {
                        view.ustawStatus("Błąd: " + ex.getMessage());
                    }

                    view.loginButton.setEnabled(true);
                }

            }.execute();
        });
    }
}
