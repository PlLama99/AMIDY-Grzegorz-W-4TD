import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class MainApp extends JFrame {

    private static final String CONFIG_FILE = "config.properties";
    private static final String THEME_KEY = "theme";

    public MainApp() {
        setTitle("Professional Settings Manager");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createMenu();
        createUI();
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu viewMenu = new JMenu("Widok");

        JMenuItem lightMode = new JMenuItem("Light Mode");
        JMenuItem darkMode = new JMenuItem("Dark Mode");

        lightMode.addActionListener(e -> changeTheme("light"));
        darkMode.addActionListener(e -> changeTheme("dark"));

        viewMenu.add(lightMode);
        viewMenu.add(darkMode);

        menuBar.add(viewMenu);
        setJMenuBar(menuBar);
    }

    private void createUI() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel();
        JTextField textField = new JTextField(15);
        JButton button = new JButton("Kliknij");
        JCheckBox checkBox = new JCheckBox("Akceptuję");

        topPanel.add(textField);
        topPanel.add(button);
        topPanel.add(checkBox);

        String[] columns = {"ID","Name","Age"};
        Object[][] data = {
                {1,"Anna",23},
                {2,"Jan",30},
                {3,"Kasia",27}
        };

        JTable table = new JTable(new DefaultTableModel(data,columns));
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(topPanel,BorderLayout.NORTH);
        panel.add(scrollPane,BorderLayout.CENTER);

        add(panel);
    }

    private void changeTheme(String theme) {
        try {

            if(theme.equals("dark")){
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }

            SwingUtilities.updateComponentTreeUI(this);

            saveTheme(theme);

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private static void saveTheme(String theme){
        try{
            Properties props = new Properties();
            props.setProperty(THEME_KEY, theme);

            FileOutputStream fos = new FileOutputStream(CONFIG_FILE);
            props.store(fos, "Application Settings");
            fos.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static String loadTheme(){
        try{
            Properties props = new Properties();

            FileInputStream fis = new FileInputStream(CONFIG_FILE);
            props.load(fis);
            fis.close();

            return props.getProperty(THEME_KEY,"light");

        }catch(Exception e){
            return "light";
        }
    }

    public static void main(String[] args) {

        try{

            String theme = loadTheme();

            if(theme.equals("dark")){
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }

        }catch(Exception e){
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new MainApp().setVisible(true);
        });
    }
}