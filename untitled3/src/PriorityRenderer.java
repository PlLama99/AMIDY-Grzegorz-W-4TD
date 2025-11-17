import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class PriorityRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int col) {

        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

        String priorytet = (String) value;

        if (!isSelected) {
            if ("Wysoki".equals(priorytet)) {
                c.setBackground(Color.PINK);
            } else if ("Niski".equals(priorytet)) {

                c.setBackground(Color.GREEN);
            } else {
                c.setBackground(Color.WHITE);
            }
        }
        return c;
    }
}
