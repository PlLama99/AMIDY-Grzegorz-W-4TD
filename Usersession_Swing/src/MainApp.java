import javax.swing.*;
import java.awt.*;

class Session {
    private static String currentUser = null;

    public static void login(String user) { currentUser =user; }
    public static void logout() { currentUser = null; }
    public static String getCurrentUser() { return currentUser; }
    public static boolean isLoggedIn() { return currentUser != null; }
}

public class MainApp extends JFrame {
    private JLabel statusLabel;

    public MainApp() {
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        statusLabel = new JLabel("Niezalogowany");
        JButton loginBtn = new JButton("Logowanie");

        loginBtn.addActionListener(e -> {
            LoginDialog dialog = new LoginDialog(this);
            dialog.setVisible(true);

            refreshUI();
        });

        add(statusLabel);
        add(loginBtn);
        setLocationRelativeTo(null);
    }

    private void refreshUI() {
        if (Session.isLoggedIn()) {
            statusLabel.setText("Zalogowano jako: " + Session.getCurrentUser());
            getContentPane().setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));
    }
}

class LoginDialog extends JDialog {
    private JTextField loginField = new JTextField(15);
    private JButton submitBtn = new JButton("Zaloguj");

    public LoginDialog(JFrame parent) {
        super(parent, "Logowanie", true);
        setLayout(new FlowLayout());

        add(new JLabel("Użytkownik:"));
        add(loginField);
        add(submitBtn);

        submitBtn.addActionListener(e -> {
            String input = loginField.getText();

            if (!input.isEmpty()) {
                Session.login(input);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Wpisz");
            }
        });

        pack();
        setLocationRelativeTo(parent);
    }
}