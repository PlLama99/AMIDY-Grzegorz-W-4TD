
import java.awt.*;
import javax.swing.*;

public class FlowLayoutDemo extends JFrame {
    public FlowLayoutDemo() {
        super("FlowLayout Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        for (int i = 1; i <= 8; i++) {
            add(new JButton("Przycisk " + i));
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutDemo();
    }
}
