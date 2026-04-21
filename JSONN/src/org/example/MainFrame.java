package org.example;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final CardLayout cardLayout = new CardLayout();
    private final JPanel mainPanel;

    public MainFrame() {
        this.mainPanel = new JPanel(this.cardLayout);

        FormPanel formPanel = new FormPanel(this);
        ViewPanel viewPanel = new ViewPanel(this);

        this.mainPanel.add(formPanel, "FORM");
        this.mainPanel.add(viewPanel, "VIEW");

        this.add(this.mainPanel);
        this.setTitle("User Profile");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void showCard(String name) {
        this.cardLayout.show(this.mainPanel, name);
    }
}
