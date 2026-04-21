import javax.swing.*;

public class SimpleTest extends JFrame {
    private JPanel mainPanel;
    private JButton submitButton;
    private JLabel myLabel;


    public SimpleTest() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

        submitButton.addActionListener(e -> myLabel.setText("Witaj w Swing"));

        submitButton.addActionListener(e -> {
            System.out.println("Kliknięto przycisk");
        });
    }

    public static void main(String[] args) {
        new SimpleTest();
    }
}