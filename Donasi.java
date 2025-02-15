/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bdluts;

/**
 *
 * @author HP
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Donasi extends javax.swing.JFrame {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/ruang_donasi";
    String user = "postgres";
    String password = "vinaa";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    /**
     * Creates new form Donasi
     */
    public Donasi() {
        initComponents();
        tampil();
        idDonaturComboBox();
        txtidrek.setText("REK001");
        txtidrek.setEditable(false);
    }

    

    private void idDonaturComboBox() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ruang_donasi", "postgres", "vinaa");
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Donatur";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                idDonaturComboBox.addItem(rs.getString("id_donatur"));
            }
        } catch (Exception e) {
            e.printStackTrace(); // menampilkan stacktrace error
            // atau
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void tampil() {

        try {
            // TODO code application logi
            Class.forName(driver);
            String sql = "SELECT * FROM Donasi";
            conn = DriverManager.getConnection(koneksi, user, password);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {

                String search = tfSearch.getText();
                ResultSet rs = stmt.executeQuery(sql);
                this.table.setModel(DbUtils.resultSetToTableModel(rs));

                while (rs.next()) {
                    System.out.println(
                            String.valueOf(rs.getObject(1)) + " "
                            + String.valueOf(rs.getObject(2)) + " "
                            + String.valueOf(rs.getObject(3)) + " "
                            + String.valueOf(rs.getObject(4)) + " "
                            + String.valueOf(rs.getObject(5))
                    );
                }
                conn.close();

            }
            stmt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Donasi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Donasi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IdDonasiField = new javax.swing.JTextField();
        btnedit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnkembali = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        tglDonasiField = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        tfSearch = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idDonaturComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnhapus = new javax.swing.JButton();
        NominalField = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnreset = new javax.swing.JButton();
        btnCari = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtidrek = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IdDonasiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IdDonasiFieldActionPerformed(evt);
            }
        });

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("DATA DONASI");

        btnkembali.setText("Kembali");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });

        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });

        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });
        tfSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSearchKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("ID REKENING");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("JUMLAH DONASI");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("ID DONASI");

        idDonaturComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                idDonaturComboBoxItemStateChanged(evt);
            }
        });
        idDonaturComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idDonaturComboBoxActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        NominalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NominalFieldActionPerformed(evt);
            }
        });

        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("TANGGAL DONASI");

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        btnCari.setText("Cari");
        btnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCariActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("ID DONATUR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCari)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnreset)
                            .addComponent(btntambah))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnedit)
                            .addComponent(btnkembali))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnhapus)
                            .addComponent(btnkeluar)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel6))
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(tglDonasiField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(NominalField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtidrek, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(idDonaturComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(IdDonasiField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(295, 295, 295)
                    .addComponent(jLabel1)
                    .addContainerGap(498, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCari, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel3)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(IdDonasiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(idDonaturComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtidrek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NominalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tglDonasiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton1))))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnhapus)
                            .addComponent(btntambah)
                            .addComponent(btnedit))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnreset)
                            .addComponent(btnkembali)
                            .addComponent(btnkeluar)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel1)
                    .addContainerGap(373, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IdDonasiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IdDonasiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IdDonasiFieldActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false);

            String sql = "UPDATE Donasi SET jumlah_donasi  = ?, tanggal_donasi = ? WHERE id_donasi = ?";
            pstmt = conn.prepareStatement(sql);
            try {
                double jumlah_donasi = Double.parseDouble(NominalField.getText());
                pstmt.setDouble(1, jumlah_donasi);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Nilai nominal tidak valid");
                return; // Hentikan eksekusi jika nilai tidak valid
            }
            String dateString = tglDonasiField.getText();
            java.sql.Date dateValue = java.sql.Date.valueOf(dateString);
            pstmt.setDate(2, dateValue);
            pstmt.setString(3, IdDonasiField.getText());

            int k = pstmt.executeUpdate();

            if (k > 0) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Update Berhasil");
            } else {
                JOptionPane.showMessageDialog(null, "Update Gagal");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Update Data Gagal: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException closeEx) {
                JOptionPane.showMessageDialog(null, "Close Gagal: " + closeEx.getMessage());
            }
        }

        tampil();
    }//GEN-LAST:event_btneditActionPerformed

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
        this.dispose();
        RuangDonasi frame = new RuangDonasi();
        frame.setVisible(true);
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        tanggal();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void tanggal() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(Calendar.getInstance().getTime());
        tglDonasiField.setText(currentDate);

    }
    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSearchActionPerformed

    private void tfSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSearchKeyReleased
        // TODO add your handling code here:
        tampil();
    }//GEN-LAST:event_tfSearchKeyReleased

    private void idDonaturComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_idDonaturComboBoxItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_idDonaturComboBoxItemStateChanged

    private void idDonaturComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idDonaturComboBoxActionPerformed

    }//GEN-LAST:event_idDonaturComboBoxActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            String id_donasi = table.getValueAt(selectedRow, 0).toString();
            String id_donatur = table.getValueAt(selectedRow, 1).toString();
            String id_rekening = table.getValueAt(selectedRow, 2).toString();
            String jumlah_donasi = table.getValueAt(selectedRow, 3).toString();
            String tanggal_donasi = table.getValueAt(selectedRow, 4).toString();

            IdDonasiField.setText(id_donasi);
            idDonaturComboBox.setSelectedItem(id_donatur);
            txtidrek.setText(id_rekening);
            NominalField.setText(jumlah_donasi);
            tglDonasiField.setText(tanggal_donasi);

        }
    }//GEN-LAST:event_tableMouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false);

            String sql = "DELETE FROM Donasi WHERE id_donasi = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, IdDonasiField.getText());

            int k = pstmt.executeUpdate();

            if (k > 0) {
                conn.commit();
                JOptionPane.showMessageDialog(null, "Delete Berhasil");
            } else {
                JOptionPane.showMessageDialog(null, "Delete Gagal");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Penghapusan Data Gagal: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Driver tidak ditemukan: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException closeEx) {
                JOptionPane.showMessageDialog(null, "Close Gagal: " + closeEx.getMessage());
            }
        }

        tampil();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void NominalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NominalFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NominalFieldActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed

         try {
        conn.setAutoCommit(false); // Disable auto-commit for transaction

        // SQL statement for inserting into DONASI table
        String sqlDonasi = "INSERT INTO DONASI (ID_DONASI, ID_DONATUR, JUMLAH_DONASI, ID_REKENING, TANGGAL_DONASI) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmtDonasi = conn.prepareStatement(sqlDonasi)) {
            // Get input values from ComboBox and TextFields
            String idDonasi = IdDonasiField.getText();
            String selectedDonatur = (String) idDonaturComboBox.getSelectedItem(); // From ComboBox
            double jumlahDonasi = Double.parseDouble(NominalField.getText());
            String idRekening = txtidrek.getText();
            String dateString = tglDonasiField.getText();
            java.sql.Date dateValue = java.sql.Date.valueOf(dateString);

            // Set parameters for DONASI insert
            pstmtDonasi.setString(1, idDonasi);
            pstmtDonasi.setString(2, selectedDonatur);
            pstmtDonasi.setDouble(3, jumlahDonasi);
            pstmtDonasi.setString(4, idRekening);
            pstmtDonasi.setDate(5, dateValue);

            // Execute DONASI insert
            pstmtDonasi.executeUpdate();

            conn.commit(); // Commit transaction
            JOptionPane.showMessageDialog(null, "Donasi berhasil ditambahkan!");
        } catch (SQLException ex) {
            conn.rollback(); // Rollback if there is an error
            JOptionPane.showMessageDialog(null, "Transaksi donasi dibatalkan: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Format jumlah donasi tidak valid: " + ex.getMessage());
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Kesalahan koneksi database: " + ex.getMessage());
    } finally {
         closeResources(pstmt, conn);
        }
    
    tampil(); // Tampilkan data terbaru

    }//GEN-LAST:event_btntambahActionPerformed

private void closeResources(PreparedStatement pstmt, Connection conn) {
    try {
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Kesalahan saat menutup koneksi: " + ex.getMessage());
    }
}
    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        IdDonasiField.setText("");
        idDonaturComboBox.setSelectedItem("");
        txtidrek.setText("");
        NominalField.setText("");
        tglDonasiField.setText("");
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCariActionPerformed
        String keyword = tfSearch.getText();  // Mengambil kata kunci dari txtSearch
        searchData(keyword);  // Memanggil method searchData dengan kata kunci
    }//GEN-LAST:event_btnCariActionPerformed

    private void searchData(String keyword) {
        try {
            // Koneksi ke database
            String sql = "SELECT * FROM Donasi WHERE id_Donasi LIKE ? OR id_donatur LIKE ? ";
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false);  // Mulai transaksi

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");

            // Menjalankan query dan mendapatkan hasil
            ResultSet rs = pstmt.executeQuery();

            // Menggunakan DbUtils untuk menampilkan hasil di tabel
            table.setModel(DbUtils.resultSetToTableModel(rs));

            // Menutup koneksi
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error saat mencari data: " + ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Donasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Donasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Donasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Donasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Donasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IdDonasiField;
    private javax.swing.JTextField NominalField;
    private javax.swing.JButton btnCari;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnkembali;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btntambah;
    private javax.swing.JComboBox<String> idDonaturComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tglDonasiField;
    private javax.swing.JTextField txtidrek;
    // End of variables declaration//GEN-END:variables
}
