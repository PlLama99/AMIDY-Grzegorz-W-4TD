import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TaskTableModel extends AbstractTableModel {

    private List<Task> tasks;
    private String[] kolumny = {"Nazwa", "Status", "Priorytet"};

    public TaskTableModel(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int getRowCount() { return tasks.size(); }

    @Override
    public int getColumnCount() { return kolumny.length; }

    @Override
    public String getColumnName(int column) { return kolumny[column]; }

    @Override
    public Object getValueAt(int row, int col) {
        Task t = tasks.get(row);
        switch (col) {
            case 0: return t.getNazwa();
            case 1: return t.isUkonczone();
            case 2: return t.getPriorytet();
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 1; // tylko checkbox (Status)
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 1) {
            tasks.get(row).setUkonczone((Boolean) value);
            fireTableRowsUpdated(row, row);
        }
    }

    public void addTask(Task t) {
        tasks.add(t);
        fireTableDataChanged();
    }

    public void removeTask(int row) {
        if (row >= 0 && row < tasks.size()) {
            tasks.remove(row);
            fireTableDataChanged();
        }
    }
}
