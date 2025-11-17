import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TaskManager extends JFrame {

    public TaskManager() {
        setTitle("Menedzer Zadań");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ArrayList<Task> lista = new ArrayList<>();
        TaskTableModel model = new TaskTableModel(lista);

        JTable tabela = new JTable(model);

        tabela.getColumnModel().getColumn(1).setCellRenderer(new StatusRenderer());
        tabela.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        tabela.getColumnModel().getColumn(2).setCellRenderer(new PriorityRenderer());

        JScrollPane scrollPane = new JScrollPane(tabela);

        JPanel lewyPanel = new JPanel();
        lewyPanel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton dodajBtn = new JButton("Dodaj Zadanie");
        JButton usunBtn = new JButton("Usuń Wybrane");

        lewyPanel.add(dodajBtn);
        lewyPanel.add(usunBtn);

        dodajBtn.addActionListener(e -> {
            String nazwa = JOptionPane.showInputDialog(this, "Nazwa zadania:");
            if (nazwa == null || nazwa.isEmpty()) return;

            Object[] priorytety = {"Niski", "Normalny", "Wysoki"};
            String priorytet = (String) JOptionPane.showInputDialog(
                    this,
                    "Wybierz priorytet:",
                    "Priorytet",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    priorytety,
                    "Normalny"
            );

            if (priorytet != null) {
                model.addTask(new Task(nazwa, false, priorytet));
            }
        });

        usunBtn.addActionListener(e -> {
            int row = tabela.getSelectedRow();
            if (row == -1) return;
            model.removeTask(row);
        });

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, lewyPanel, scrollPane);
        split.setDividerLocation(150);

        add(split);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TaskManager().setVisible(true));
    }
}
