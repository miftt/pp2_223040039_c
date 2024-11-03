package PrakProm2_223040039.pertemuan6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TombolPanel extends JPanel {
    private JButton tombolSubmit;

    public TombolPanel(FormulirPanel panelFormulir) {
        tombolSubmit = new JButton("Kirim");

        tombolSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!panelFormulir.getSyaratCheckBox().isSelected()) {
                    JOptionPane.showMessageDialog(null, "Anda harus menyetujui syarat dan ketentuan.");
                    return;
                }

                String nama = panelFormulir.getNamaField().getText();
                String email = panelFormulir.getEmailField().getText();
                String telepon = panelFormulir.getTeleponField().getText();
                String gender = panelFormulir.getPriaRadio().isSelected() ? "Pria" : panelFormulir.getWanitaRadio().isSelected() ? "Wanita" : "";
                String kategori = (String) panelFormulir.getKategoriComboBox().getSelectedItem();
                int pengalaman = panelFormulir.getPengalamanSlider().getValue();
                int id = panelFormulir.getId();
                if (nama.isEmpty() || email.isEmpty() || telepon.isEmpty() || gender.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Harap lengkapi semua bidang yang diperlukan.");
                } else {
                    panelFormulir.tambahData(nama, email, telepon, gender, kategori, pengalaman);
                    JOptionPane.showMessageDialog(null, "Pendaftaran berhasil!");
                }
            }
        });

        add(tombolSubmit);
    }
}
