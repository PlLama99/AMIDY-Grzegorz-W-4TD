import javax.swing.*;

public class GlownyView extends JFrame {

    public JTextField loginField = new JTextField(15);
    public JPasswordField passField = new JPasswordField(15);
    public JButton loginButton = new JButton("Zaloguj");
    public JLabel statusLabel = new JLabel(" ");

    public GlownyView() {

        setTitle("Logowanie");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.add(new JLabel("Login:"));
        panel.add(loginField);

        panel.add(new JLabel("Hasło:"));
        panel.add(passField);

        panel.add(loginButton);
        panel.add(statusLabel);

        add(panel);
        setVisible(true);
    }

    public void ustawStatus(String text) {
        statusLabel.setText(text);
    }
}
