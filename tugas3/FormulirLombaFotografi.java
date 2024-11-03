package PrakProm2_223040039.pertemuan6;
import javax.swing.*;
import java.awt.*;

public class FormulirLombaFotografi extends JFrame {

    public FormulirLombaFotografi() {
        setTitle("Formulir Pendaftaran Lomba Fotografi");
        setSize(700, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        FormulirPanel panelFormulir = new FormulirPanel();
        JScrollPane scrollPane = new JScrollPane(panelFormulir);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        TombolPanel panelTombol = new TombolPanel(panelFormulir);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(panelTombol, BorderLayout.SOUTH);
        add(new JScrollPane(panelFormulir.getDataTable()), BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormulirLombaFotografi().setVisible(true));
    }
}
