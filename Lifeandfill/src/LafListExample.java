import javax.swing.*;

public class LafListExample {

    public static void main(String[] args) {

        // wypisanie dostępnych Look and Feel
        UIManager.LookAndFeelInfo[] looks = UIManager.getInstalledLookAndFeels();

        System.out.println("Dostępne style Look and Feel:");

        for (UIManager.LookAndFeelInfo laf : looks) {
            System.out.println("Nazwa: " + laf.getName());
            System.out.println("Klasa: " + laf.getClassName());
            System.out.println("---------------------");
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Ćwiczenie 1");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300,200);

            frame.add(new JButton("Przykładowy przycisk"));

            frame.setVisible(true);
        });
    }
}