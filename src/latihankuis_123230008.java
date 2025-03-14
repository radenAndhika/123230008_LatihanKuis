import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class latihankuis_123230008 {
    private static final String USERNAME_TETAP = "123230008";
    private static final String PASSWORD_TETAP = "ifkelasg";
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(latihankuis_123230008::buatLoginGUI);
    }
    
    private static void buatLoginGUI() {
        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(3, 2, 5, 5));
        
        JLabel labelUsername = new JLabel("Username:");
        JTextField fieldUsername = new JTextField();
        JLabel labelPassword = new JLabel("Password:");
        JPasswordField fieldPassword = new JPasswordField();
        JButton tombolLogin = new JButton("Login");
        
        frame.add(labelUsername);
        frame.add(fieldUsername);
        frame.add(labelPassword);
        frame.add(fieldPassword);
        frame.add(new JLabel());
        frame.add(tombolLogin);
        
        tombolLogin.addActionListener(e -> {
            String username = fieldUsername.getText();
            String password = new String(fieldPassword.getPassword());
            
            if (username.equals(USERNAME_TETAP) && password.equals(PASSWORD_TETAP)) {
                frame.dispose();
                buatGUIUtama();
            } else {
                JOptionPane.showMessageDialog(frame, "Login gagal! Periksa username dan password.");
            }
        });
        
        frame.setVisible(true);
    }
    
    private static void buatGUIUtama() {
        JFrame frame = new JFrame("Input Data Mahasiswa");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel labelNama = new JLabel("Nama Mahasiswa:");
        JTextField fieldNama = new JTextField();
        JLabel labelNIM = new JLabel("NIM:");
        JTextField fieldNIM = new JTextField();
        JLabel labelNilaiTugas = new JLabel("Nilai Tugas:");
        JTextField fieldNilaiTugas = new JTextField();
        JLabel labelNilaiQuiz = new JLabel("Nilai Quiz:");
        JTextField fieldNilaiQuiz = new JTextField();
        
        JRadioButton tombolTeori = new JRadioButton("Kelas Teori", true);
        JRadioButton tombolPraktikum = new JRadioButton("Kelas Praktikum");
        ButtonGroup grupKelas = new ButtonGroup();
        grupKelas.add(tombolTeori);
        grupKelas.add(tombolPraktikum);
        
        String[] daftarMataKuliah = {"PBO", "SCPK", "Algo Lanjut"};
        JComboBox<String> comboMataKuliah = new JComboBox<>(daftarMataKuliah);
        
        JButton tombolSubmit = new JButton("Submit");
        JButton tombolLogout = new JButton("Logout");
        
        gbc.gridx = 0; gbc.gridy = 0; frame.add(labelNama, gbc);
        gbc.gridx = 1; gbc.gridy = 0; frame.add(fieldNama, gbc);
        gbc.gridx = 0; gbc.gridy = 1; frame.add(labelNIM, gbc);
        gbc.gridx = 1; gbc.gridy = 1; frame.add(fieldNIM, gbc);
        gbc.gridx = 0; gbc.gridy = 2; frame.add(labelNilaiTugas, gbc);
        gbc.gridx = 1; gbc.gridy = 2; frame.add(fieldNilaiTugas, gbc);
        gbc.gridx = 0; gbc.gridy = 3; frame.add(labelNilaiQuiz, gbc);
        gbc.gridx = 1; gbc.gridy = 3; frame.add(fieldNilaiQuiz, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4; frame.add(new JLabel("Pilih Kelas:"), gbc);
        gbc.gridx = 1; gbc.gridy = 4; frame.add(tombolTeori, gbc);
        gbc.gridx = 1; gbc.gridy = 5; frame.add(tombolPraktikum, gbc);
        
        gbc.gridx = 0; gbc.gridy = 6; frame.add(new JLabel("Mata Kuliah:"), gbc);
        gbc.gridx = 1; gbc.gridy = 6; frame.add(comboMataKuliah, gbc);
        
        gbc.gridx = 0; gbc.gridy = 7; frame.add(tombolSubmit, gbc);
        gbc.gridx = 1; gbc.gridy = 7; frame.add(tombolLogout, gbc);
        
        tombolSubmit.addActionListener(e -> {
            try {
                double nilaiTugas = Double.parseDouble(fieldNilaiTugas.getText());
                double nilaiQuiz = Double.parseDouble(fieldNilaiQuiz.getText());
                double totalNilai = tombolTeori.isSelected() ? (0.3 * nilaiTugas) + (0.7 * nilaiQuiz) : (0.7 * nilaiTugas) + (0.3 * nilaiQuiz);
                String hasil = (totalNilai >= 85) ? "PASS" : "NOT PASS";
                
                JOptionPane.showMessageDialog(frame, "Nama: " + fieldNama.getText() + "\n"
                    + "NIM: " + fieldNIM.getText() + "\n"
                    + "Kelas: " + (tombolTeori.isSelected() ? "Teori" : "Praktikum") + "\n"
                    + "Mata Kuliah: " + comboMataKuliah.getSelectedItem() + "\n"
                    + "Total Nilai: " + totalNilai + "\n"
                    + "Status: " + hasil);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Masukkan angka yang valid untuk nilai.");
            }
        });
        
        tombolLogout.addActionListener(e -> {
            int konfirmasi = JOptionPane.showConfirmDialog(frame, "Apakah Anda yakin ingin logout?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (konfirmasi == JOptionPane.YES_OPTION) {
                frame.dispose();
                buatLoginGUI();
            }
        });
        
        frame.setVisible(true);
    }
}
