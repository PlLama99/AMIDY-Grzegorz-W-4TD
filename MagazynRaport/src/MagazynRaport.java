import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.*;

public class MagazynRaport extends JFrame {

    private JTable table;

    public MagazynRaport() {

        setTitle("System Raportowania Magazynowego");
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createUI();
    }

    private void createUI() {

        String[] columns = {"ID", "Nazwa Produktu", "Ilość", "Cena"};

        Object[][] data = {
                {"1", "Laptop", "10", "3500"},
                {"2", "Myszka", "50", "80"},
                {"3", "Klawiatura", "30", "150"},
                {"4", "Monitor", "15", "900"}
        };

        table = new JTable(new DefaultTableModel(data, columns));

        JButton exportButton = new JButton("Generuj Raport PDF");
        exportButton.addActionListener(e -> exportToPDF());

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(exportButton, BorderLayout.SOUTH);
    }

    private void exportToPDF() {

        JFileChooser chooser = new JFileChooser();
        int state = chooser.showSaveDialog(this);

        if(state == JFileChooser.APPROVE_OPTION){

            Document document = new Document();

            try{

                PdfWriter.getInstance(document,
                        new FileOutputStream(chooser.getSelectedFile() + ".pdf"));

                document.open();

                BaseFont bf = BaseFont.createFont(
                        "C:/Windows/Fonts/arial.ttf",
                        BaseFont.IDENTITY_H,
                        BaseFont.EMBEDDED);

                com.itextpdf.text.Font titleFont =
                        new com.itextpdf.text.Font(bf,16, com.itextpdf.text.Font.BOLD);

                com.itextpdf.text.Font tableFont =
                        new com.itextpdf.text.Font(bf,12);

                String date = LocalDate.now()
                        .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                Paragraph title = new Paragraph(
                        "Raport magazynowy - " + date,
                        titleFont);

                title.setAlignment(Element.ALIGN_CENTER);
                title.setSpacingAfter(20);

                document.add(title);

                PdfPTable pdfTable = new PdfPTable(table.getColumnCount());
                pdfTable.setWidthPercentage(100);

                for(int i=0;i<table.getColumnCount();i++){

                    PdfPCell cell = new PdfPCell(
                            new Phrase(table.getColumnName(i), tableFont));

                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                    pdfTable.addCell(cell);
                }

                for(int row=0; row<table.getRowCount(); row++){

                    for(int col=0; col<table.getColumnCount(); col++){

                        PdfPCell cell = new PdfPCell(
                                new Phrase(
                                        table.getValueAt(row,col).toString(),
                                        tableFont));

                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);

                        pdfTable.addCell(cell);
                    }
                }

                document.add(pdfTable);

                JOptionPane.showMessageDialog(this,"Raport PDF");

            }
            catch(Exception ex){
                ex.printStackTrace();
            }
            finally{
                document.close();
            }
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new MagazynRaport().setVisible(true);
        });
    }
}