import javax.swing.*;
import java.awt.*;

public class DynamicLafChange {

    private JFrame frame;

    public DynamicLafChange() {

        frame = new JFrame("Dynamiczna zmiana Look & Feel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,200);
        frame.setLayout(new FlowLayout());

        JComboBox<String> combo = new JComboBox<>();

        UIManager.LookAndFeelInfo[] lafs = UIManager.getInstalledLookAndFeels();

        for(UIManager.LookAndFeelInfo laf : lafs){
            combo.addItem(laf.getName());
        }

        combo.addActionListener(e -> {
            int index = combo.getSelectedIndex();

            try{
                UIManager.setLookAndFeel(lafs[index].getClassName());
                SwingUtilities.updateComponentTreeUI(frame);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        });

        frame.add(new JLabel("Wybierz styl:"));
        frame.add(combo);
        frame.add(new JButton("Przycisk"));
        frame.add(new JTextField("Pole tekstowe",10));

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DynamicLafChange::new);
    }
}