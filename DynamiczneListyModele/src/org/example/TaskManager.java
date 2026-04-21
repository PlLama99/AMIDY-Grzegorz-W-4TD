package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TaskManager extends JFrame {
    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> list = new JList<>(model);
    JTextField field = new JTextField();
    JLabel label = new JLabel("Liczba zadan 0");

    public TaskManager() {
        setTitle("Menedzer Zadan");
        setSize(400, 400);
        setDefaultCloseOperation(3);
        setLayout(new BorderLayout());

        JButton addBtn = new JButton("Dodaj");
        addBtn.addActionListener(e -> dodaj());

        JPanel top = new JPanel(new BorderLayout());
        top.add(field, BorderLayout.CENTER);
        top.add(addBtn, BorderLayout.EAST);

        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int i = list.locationToIndex(e.getPoint());
                    if (i != -1) {
                        model.remove(i);
                        update();
                    }
                }
            }
        });

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(list), BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);

        setVisible(true);
    }

    void dodaj() {
        String txt = field.getText().trim();
        if (txt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Blad Puste pole");
        } else {
            model.addElement(txt);
            field.setText("");
            update();
        }
    }

    void update() {
        label.setText("Liczba zadan " + model.getSize());
    }

    public static void main(String[] args) {
        new TaskManager();
    }
}
