import javax.swing.*;

public class drugi extends JFrame {
    private JPanel mainPanel; 
    private JButton submitButton;
    private JTextField TextField;
    private JTextField textField2;
    private JLabel cos;


    public drugi() {
        setContentPane(mainPanel);
        setTitle("Moja Aplikacja");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);

        TextField.setText("Waga");
        textField2.setText("wzrost");

        submitButton.addActionListener(e -> {
            double waga = Double.parseDouble(TextField.getText());
            double wzrost = Double.parseDouble(textField2.getText());
            double wynik = waga / (wzrost * wzrost);

            cos.setText(String.valueOf(wynik));
        }
            );


    }

    public static void main(String[] args) {
        new drugi();
    }
}