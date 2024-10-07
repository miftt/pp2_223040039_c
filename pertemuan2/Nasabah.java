package pertemuan2;

import java.awt.event.*;
import javax.swing.*;
import java.util.Date;

public class Nasabah extends JFrame {

    public Nasabah() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Form Pendaftaran Nasabah Bank");

        JLabel labelInput = new JLabel("Nama");
        labelInput.setBounds(15, 10, 350, 10);

        JTextField textField = new JTextField();
        textField.setBounds(15, 30, 350, 30);

        JLabel labelInput2 = new JLabel("Nomor HP");
        labelInput2.setBounds(15, 80, 350, 10);

        JTextField textField2 = new JTextField();
        textField2.setBounds(15, 100, 350, 30);

        JLabel labelRadio = new JLabel("Jenis Kelamin");
        labelRadio.setBounds(15, 130, 350, 10);

        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        radioButton1.setBounds(15, 145, 100, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(150, 145, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // CheckBox WNA
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 180, 350, 30);

        JLabel labelTabungan = new JLabel("Jenis Tabungan");
        labelTabungan.setBounds(15, 210, 350, 10);

        String[] jenisTabungan = {"Simpanan Pelajar", "Deposito", "Giro", "Tabungan Haji"};
        JList<String> listTabungan = new JList<>(jenisTabungan);
        listTabungan.setBounds(15, 230, 350, 80);
        listTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JLabel labelFrekuensi = new JLabel("Frekuensi Transaksi/Bulan");
        labelFrekuensi.setBounds(15, 320, 350, 10);

        JSlider sliderTransaksi = new JSlider(1, 100, 1);
        sliderTransaksi.setBounds(15, 340, 350, 50);
        sliderTransaksi.setMajorTickSpacing(20);
        sliderTransaksi.setMinorTickSpacing(5);
        sliderTransaksi.setPaintTicks(true);
        sliderTransaksi.setPaintLabels(true);

        JLabel labelTglLahir = new JLabel("Tanggal Lahir");
        labelTglLahir.setBounds(15, 400, 350, 10);

        JSpinner spinnerTglLahir = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerTglLahir, "dd/MM/yyyy");
        spinnerTglLahir.setEditor(editor);
        spinnerTglLahir.setBounds(15, 420, 350, 30);

        JLabel labelPassword = new JLabel("Password");
        labelPassword.setBounds(15, 460, 350, 10);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(15, 480, 350, 30);

        JLabel labelConfirmPassword = new JLabel("Konfirmasi Password");
        labelConfirmPassword.setBounds(15, 520, 350, 10);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 540, 350, 30);

        JTextArea txtOutput = new JTextArea();
        txtOutput.setBounds(15, 580, 350, 100);
        txtOutput.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(txtOutput);
        scrollPane.setBounds(15, 580, 350, 100);

        JButton button = new JButton("Simpan");
        button.setBounds(15, 690, 100, 40);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mendapatkan input dari form
                String nama = textField.getText();
                String nohp = textField2.getText();
                String jenisKelamin = radioButton1.isSelected() ? radioButton1.getText() : radioButton2.getText();
                String WNA = checkBox.isSelected() ? "Ya" : "Tidak";
                String jenisTabunganTerpilih = listTabungan.getSelectedValue();
                int frekuensiTransaksi = sliderTransaksi.getValue();
                Date tglLahir = (Date) spinnerTglLahir.getValue();

                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (password.equals(confirmPassword)) {
                    txtOutput.setText("");
                    txtOutput.append("Nama: " + nama + "\n");
                    txtOutput.append("Nomor HP: " + nohp + "\n");
                    txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
                    txtOutput.append("WNA: " + WNA + "\n");
                    txtOutput.append("Jenis Tabungan: " + jenisTabunganTerpilih + "\n");
                    txtOutput.append("Frekuensi Transaksi: " + frekuensiTransaksi + "\n");
                    txtOutput.append("Tanggal Lahir: " + tglLahir + "\n");
                    txtOutput.append("===========================\n");

                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Password dan Konfirmasi Password tidak cocok!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                passwordField.setText("");
                confirmPasswordField.setText("");
            }
        });

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem menuReset = new JMenuItem("Reset");
        menuReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                textField2.setText("");
                passwordField.setText("");
                confirmPasswordField.setText("");
                txtOutput.setText("");
                sliderTransaksi.setValue(1);
                spinnerTglLahir.setValue(new Date());
                listTabungan.clearSelection();
            }
        });

        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(menuReset);
        menu.add(menuExit);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        this.add(button);
        this.add(textField);
        this.add(textField2);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(labelInput2);
        this.add(labelInput);
        this.add(labelTabungan);
        this.add(listTabungan);
        this.add(labelFrekuensi);
        this.add(sliderTransaksi);
        this.add(labelTglLahir);
        this.add(spinnerTglLahir);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(scrollPane);
        this.add(checkBox);

        this.setSize(400, 800);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Nasabah h = new Nasabah();
                h.setVisible(true);
            }
        });
    }
}
