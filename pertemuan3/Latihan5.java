import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Latihan5 extends JFrame {
    private boolean checkedWNA;

    public Latihan5() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel judul = new JLabel("Form Biodata", JLabel.CENTER);
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Nama : ");
        JTextField nameField = new JTextField(15);
        JLabel nohpLabel = new JLabel("Nomor HP : ");
        JTextField nohpField = new JTextField(15);
        JLabel jenisKelaminLabel = new JLabel("Jenis Kelamin :");
        JRadioButton priaRadioButton = new JRadioButton("Pria");
        JRadioButton wanitaRadioButton = new JRadioButton("Wanita");
        ButtonGroup bg = new ButtonGroup();
        bg.add(priaRadioButton);
        bg.add(wanitaRadioButton);
        JCheckBox checkWNA = new JCheckBox("Warga Negara Asing");
        JTextArea resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false); // Menambahkan agar area teks tidak dapat diedit

        JButton simpan = new JButton("Simpan");
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Menyusun komponen dengan GridBagLayout
        gbc.gridx = 0; gbc.gridy = 0; panel.add(judul, gbc);
        gbc.gridx = 0; gbc.gridy = 1; panel.add(nameLabel, gbc);
        gbc.gridx = 0; gbc.gridy = 2; panel.add(nameField, gbc);
        gbc.gridx = 0; gbc.gridy = 3; panel.add(nohpLabel, gbc);
        gbc.gridx = 0; gbc.gridy = 4; panel.add(nohpField, gbc);
        gbc.gridx = 1; gbc.gridy = 0; panel.add(jenisKelaminLabel, gbc);
        gbc.gridx = 1; gbc.gridy = 1; panel.add(priaRadioButton, gbc);
        gbc.gridx = 1; gbc.gridy = 2; panel.add(wanitaRadioButton, gbc);
        gbc.gridx = 1; gbc.gridy = 3; panel.add(checkWNA, gbc);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2; panel.add(simpan, gbc);

        controlPanel.add(panel);
        this.setLayout(new BorderLayout());
        this.add(judul, BorderLayout.NORTH);
        this.add(controlPanel, BorderLayout.CENTER);
        this.add(resultArea, BorderLayout.SOUTH);
        this.setSize(400, 400);

        // Listener untuk checkbox WNA
        checkWNA.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkedWNA = e.getStateChange() == ItemEvent.SELECTED;
            }
        });

        // Action listener untuk tombol simpan
        simpan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = nameField.getText();
                String nohp = nohpField.getText();
                String jenisKelamin = priaRadioButton.isSelected() ? 
                    priaRadioButton.getText() : 
                    wanitaRadioButton.isSelected() ? 
                    wanitaRadioButton.getText() : 
                    "Belum Dipilih";

                String statusWNA = checkedWNA ? "Positif" : "Negatif";

                String msg = "Nama: " + nama + "\n" +
                             "Nomor HP: " + nohp + "\n" +
                             "Jenis Kelamin: " + jenisKelamin + "\n" +
                             "Status WNA: " + statusWNA + "\n";
                resultArea.setText(msg);
            }
        });
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Latihan5 latihan5 = new Latihan5();
                latihan5.setVisible(true);
            }
        });
    }
}
