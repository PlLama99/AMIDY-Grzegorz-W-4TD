import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            List<Product> lista = new ArrayList<>();
            lista.add(new Product("Hleb", 4.50, 13));
            lista.add(new Product("Maśelo", 8.20, 67));
            lista.add(new Product("Milk", 3.00, 60));

            ProductTableModel model = new ProductTableModel(lista);

            JTable tabela = new JTable(model);
            JScrollPane scroll = new JScrollPane(tabela);

            JFrame frame = new JFrame("Lista produktów");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.add(scroll);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
