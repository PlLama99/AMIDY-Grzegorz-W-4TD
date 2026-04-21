package org.example;

import javax.swing.*;

public class ViewPanel extends JPanel {
    private final JLabel nameLabel = new JLabel();
    private final JLabel emailLabel = new JLabel();

    public ViewPanel(MainFrame frame) {
        JButton backBtn = new JButton("Powrót");
        this.add(this.nameLabel);
        this.add(this.emailLabel);
        this.add(backBtn);

        backBtn.addActionListener(e -> frame.showCard("FORM"));
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        if (aFlag) {
            UserProfile p = StorageManager.load();
            if (p != null) {
                this.nameLabel.setText(p.getFirstName() + " " + p.getLastName());
                this.emailLabel.setText(p.getEmail());
            }
        }
    }
}