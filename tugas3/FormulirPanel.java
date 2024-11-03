package PrakProm2_223040039.pertemuan6;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class FormulirPanel extends JPanel {
    private JTextField namaField, emailField, teleponField;
    private JTextArea alamatArea;
    private JRadioButton priaRadio, wanitaRadio;
    private JCheckBox syaratCheckBox;
    private JComboBox<String> kategoriComboBox;
    private JList<String> alatList;
    private JSlider pengalamanSlider;
    private DefaultTableModel tabelModel;
    private JTable dataTable;
    private int idDefault = 1;

    public FormulirPanel() {
        setLayout(new GridLayout(0, 2, 10, 10));

        namaField = new JTextField(15);
        namaField.setPreferredSize(new Dimension(100, 25));

        emailField = new JTextField(15);
        emailField.setPreferredSize(new Dimension(100, 25));

        teleponField = new JTextField(15);
        teleponField.setPreferredSize(new Dimension(100, 25));

        alamatArea = new JTextArea(3, 15);
        alamatArea.setLineWrap(true);
        alamatArea.setWrapStyleWord(true);
        JScrollPane alamatScrollPane = new JScrollPane(alamatArea);
        alamatScrollPane.setPreferredSize(new Dimension(100, 50));

        priaRadio = new JRadioButton("Pria");
        wanitaRadio = new JRadioButton("Wanita");
        ButtonGroup kelompokGender = new ButtonGroup();
        kelompokGender.add(priaRadio);
        kelompokGender.add(wanitaRadio);

        syaratCheckBox = new JCheckBox("Saya menyetujui syarat dan ketentuan");

        String[] kategori = {"Potret", "Landscape", "Satwa Liar", "Olahraga", "Makro"};
        kategoriComboBox = new JComboBox<>(kategori);

        String[] alat = {"DSLR", "Mirrorless", "Smartphone", "Drone"};
        alatList = new JList<>(alat);
        alatList.setVisibleRowCount(2);
        JScrollPane alatScrollPane = new JScrollPane(alatList);
        alatScrollPane.setPreferredSize(new Dimension(100, 50));

        pengalamanSlider = new JSlider(0, 10, 5);
        pengalamanSlider.setMajorTickSpacing(1);
        pengalamanSlider.setPaintTicks(true);
        pengalamanSlider.setPaintLabels(true);
        pengalamanSlider.setPreferredSize(new Dimension(150, 50));

        tabelModel = new DefaultTableModel(new String[]{"ID", "Nama", "Email", "Telepon", "Gender", "Kategori", "Pengalaman"}, 0);
        dataTable = new JTable(tabelModel);
        dataTable.setPreferredScrollableViewportSize(new Dimension(500, 100));

        add(new JLabel("Nama:"));
        add(namaField);
        add(new JLabel("Email:"));
        add(emailField);
        add(new JLabel("Telepon:"));
        add(teleponField);
        add(new JLabel("Alamat:"));
        add(alamatScrollPane);
        add(new JLabel("Jenis Kelamin:"));

        JPanel panelGender = new JPanel();
        panelGender.add(priaRadio);
        panelGender.add(wanitaRadio);
        add(panelGender);

        add(new JLabel("Kategori:"));
        add(kategoriComboBox);
        add(new JLabel("Alat yang Digunakan:"));
        add(alatScrollPane);

        add(new JLabel("Tingkat Pengalaman (0-10):"));
        add(pengalamanSlider);

        add(syaratCheckBox);
    }

    public JTable getDataTable() {
        return dataTable;
    }

    public void tambahData(String nama, String email, String telepon, String gender, String kategori, int pengalaman) {
        tabelModel.addRow(new Object[]{idDefault++, nama, email, telepon, gender, kategori, pengalaman});
    }

    public JTextField getNamaField() { return namaField; }
    public JTextField getEmailField() { return emailField; }
    public JTextField getTeleponField() { return teleponField; }
    public int getId() { return idDefault; }
    public JRadioButton getPriaRadio() { return priaRadio; }
    public JRadioButton getWanitaRadio() { return wanitaRadio; }
    public JCheckBox getSyaratCheckBox() { return syaratCheckBox; }
    public JComboBox<String> getKategoriComboBox() { return kategoriComboBox; }
    public JSlider getPengalamanSlider() { return pengalamanSlider; }
}
