import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class StoreSystem extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuSales, menuReports, menuUsers;
    private JLabel statusBarLabel;

    static class Session {
        static String login;
        static String role;
    }

    public StoreSystem() {
        showLoginDialog();
    }

    private void showLoginDialog() {
        JDialog loginDialog = new JDialog(this, "Logowanie", true);
        loginDialog.setLayout(new GridLayout(3, 2, 10, 10));

        JTextField loginField = new JTextField();
        JPasswordField passField = new JPasswordField();
        JButton loginBtn = new JButton("Zaloguj");

        loginDialog.add(new JLabel(" Login:")); loginDialog.add(loginField);
        loginDialog.add(new JLabel(" Hasło:")); loginDialog.add(passField);
        loginDialog.add(new JLabel("")); loginDialog.add(loginBtn);

        loginBtn.addActionListener(e -> {
            String login = loginField.getText();
            String pass = new String(passField.getPassword());

            if (login.equals("admin") && pass.equals("admin123")) {
                Session.login = "admin";
                Session.role = "Administrator";
                loginDialog.dispose();
                initMainGui();
            } else if (login.equals("user") && pass.equals("user123")) {
                Session.login = "user";
                Session.role = "Sprzedawca";
                loginDialog.dispose();
                initMainGui();
            } else {
                JOptionPane.showMessageDialog(loginDialog, "Błędne dane!");
            }
        });

        loginDialog.pack();
        loginDialog.setLocationRelativeTo(null);
        loginDialog.setVisible(true);
    }

    private void initMainGui() {
        setTitle("System Obsługi Sklepu");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        menuBar = new JMenuBar();
        menuSales = new JMenu("Sprzedaż");
        menuReports = new JMenu("Raporty");
        menuUsers = new JMenu("Zarządzanie");

        menuBar.add(menuSales);
        menuBar.add(menuReports);

        if (Session.role.equals("Administrator")) {
            menuBar.add(menuUsers);
        } else {
            menuReports.setEnabled(false);
        }

        setJMenuBar(menuBar);

        JPanel statusBar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusBar.setBorder(BorderFactory.createEtchedBorder());
        statusBarLabel = new JLabel("Zalogowano jako: " + Session.login + " | Rola: " + Session.role);
        statusBar.add(statusBarLabel);

        add(statusBar, BorderLayout.SOUTH);
        add(new JLabel("Witaj w systemie", SwingConstants.CENTER), BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StoreSystem::new);
    }
}
//własność Grzegorza Wawrzyniaka 4TD hasla tam wyzej są