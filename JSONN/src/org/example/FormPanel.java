package org.example;

import javax.swing.*;

public class FormPanel extends JPanel {
    public FormPanel(MainFrame frame) {
        JTextField firstName = new JTextField(15);
        JTextField lastName = new JTextField(15);
        JTextField email = new JTextField(15);
        JButton saveBtn = new JButton("Zapisz i dalej");

        this.add(new JLabel("Imię"));
        this.add(firstName);
        this.add(new JLabel("Nazwisko"));
        this.add(lastName);
        this.add(new JLabel("Email"));
        this.add(email);
        this.add(saveBtn);

        saveBtn.addActionListener(e -> {
            UserProfile profile = new UserProfile(firstName.getText(), lastName.getText(), email.getText());
            StorageManager.save(profile);
            frame.showCard("VIEW");
        });
    }
}