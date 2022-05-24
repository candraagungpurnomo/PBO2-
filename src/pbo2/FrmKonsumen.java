/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo2;


import java.sql.ResultSet;
import java.sql.Statement; 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class FrmKonsumen extends javax.swing.JFrame {
        koneksi k;
        Statement statement;
        ResultSet resultSet;
        int pil;

    /**
     * Creates new form FrmKonsumen
     */
    public FrmKonsumen() {
        initComponents();
        k = new koneksi();
        tampilIcon();
        tampilTabel();

    }

    
     private void tampilIcon(){
     BtnTambah.setIcon(new ImageIcon("./assets/Add_16x16.png")); 
     BtnKoreksi.setIcon(new ImageIcon("./assets/Edit_16x16.png")); 
     BtnHapus.setIcon(new ImageIcon("./assets/Delete_16x16.png")); 
     BtnSimpan.setIcon(new ImageIcon("./assets/Save_16x16.png")); 
     BtnBatal.setIcon(new ImageIcon("./assets/Cancel_16x16.png")); 
     BtnKeluar.setIcon(new ImageIcon("./assets/LogOut_16x16.png"));
     
     }

     
     private void simpanData(){
        String sql_insert  = "insert into konsumen values ('"+mKodeKonsumen.getText()+"','"+mNamaKonsumen.getText()+"','"+mAlamatKonsumen.getText()+"','"+mKotaKonsumen.getText()+"','"+mTelpKonsumen.getText()+"','"+mHPKonsumen.getText()+"')";
     try {
        statement.executeUpdate(sql_insert);
     } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}

    private void koreksiData(){
        String sql_edit  = "update konsumen set namakonsumen='"+mNamaKonsumen.getText()+"', alamatkonsumen='"+mAlamatKonsumen.getText()+"', kotakonsumen='"+mKotaKonsumen.getText()+"', telpkonsumen='"+ mTelpKonsumen.getText()+"', hpkonsumen='"+mHPKonsumen.getText()+"' where kodekonsumen='"+mKodeKonsumen.getText()+"'";
        try {
        statement.executeUpdate(sql_edit);
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
     
     
      private void hapusData(){
        String sql_delete  = "delete from konsumen where kodekonsumen='"+mKodeKonsumen.getText()+"'";
        try  {
            statement.executeUpdate(sql_delete);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
    
    
    private void bersih(){ 
        mKodeKonsumen.setText(null); 
        mNamaKonsumen.setText(null); 
        mAlamatKonsumen.setText(null); 
        mKotaKonsumen.setText(null); 
        mTelpKonsumen.setText(null); 
        mHPKonsumen.setText(null);
    }
    
    
    private void setTombol(boolean xTambah,boolean xKoreksi,boolean xHapus, boolean xSimpan,boolean xBatal,boolean xKeluar){ 
        BtnTambah.setEnabled(xTambah);
        BtnKoreksi.setEnabled(xKoreksi);
        BtnHapus.setEnabled(xHapus); 
        BtnSimpan.setEnabled(xSimpan);
        BtnBatal.setEnabled(xBatal); 
        BtnKeluar.setEnabled(xKeluar);
    }

    private void setEdit(boolean yKode,boolean yNama,boolean yAlamat,boolean yKota,boolean yTelp,boolean yHP){ 
        mKodeKonsumen.setEnabled(yKode);
        mNamaKonsumen.setEnabled(yNama); 
        mAlamatKonsumen.setEnabled(yAlamat); 
        mKotaKonsumen.setEnabled(yKota); 
        mTelpKonsumen.setEnabled(yTelp); 
        mHPKonsumen.setEnabled(yHP);
}

    
     
     private void tampilTabel(){
     Object header[]={"Kode","Nama","Alamat","Kota","Telp.","HP"};
     DefaultTableModel modelKonsumen = new DefaultTableModel(null,header)
     {
    @Override
    // Membuat jTable read only
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
}; 
     tabelKonsumen.setModel(modelKonsumen);
     int baris = tabelKonsumen.getRowCount(); 
     for (int i = 0; i < baris; i++) {
     modelKonsumen.removeRow(i);
}
     String sql_select = "select * from konsumen";
try {
    statement = k.con.createStatement();
    resultSet = statement.executeQuery(sql_select);

    
    while(resultSet.next()){
    String kode = resultSet.getString(1); 
    String nama = resultSet.getString(2); 
    String alamat = resultSet.getString(3);
    String kota = resultSet.getString(4); 
    String telp = resultSet.getString(5);
    String hp = resultSet.getString(6);
    String kolom[] = {kode,nama,alamat,kota,telp,hp};
    modelKonsumen.addRow(kolom);
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
}
     }
     
     
     private void tabelKonsumenMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    if (pil==2 || pil==3){
    mKodeKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(),0).toString());
    mNamaKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(),1).toString());
    mAlamatKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(),2).toString());
    mKotaKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(),3).toString());
    mTelpKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(),4).toString());


    mHPKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(),5).toString());
    }
    if (pil == 2) {
    setEdit(false, true, true, true, true, true); BtnSimpan.setEnabled(true); mNamaKonsumen.requestFocus();
    }
    if (pil == 3) {
    mKodeKonsumen.setEnabled(false);
    int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?", "Penghapusan Data", JOptionPane.YES_NO_OPTION);
    if (opsi == JOptionPane.YES_OPTION){
        hapusData();
    }
        tampilTabel();
        setTombol(true, true, true, false, false, true); setEdit(false, false, false, false, false, false); bersih();
    pil=5;
    BtnTambah.requestFocus();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mKodeKonsumen = new javax.swing.JTextField();
        mNamaKonsumen = new javax.swing.JTextField();
        mAlamatKonsumen = new javax.swing.JTextField();
        mKotaKonsumen = new javax.swing.JTextField();
        mTelpKonsumen = new javax.swing.JTextField();
        mHPKonsumen = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKonsumen = new javax.swing.JTable();
        BtnTambah = new javax.swing.JButton();
        BtnKoreksi = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnSimpan = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();
        BtnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".: PENDATAAN KONSUMEN:.");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Kode");

        jLabel2.setText("Nama");

        jLabel3.setText("Telp");

        jLabel4.setText("Kota");

        jLabel5.setText("Alamat");

        jLabel6.setText("HP.");

        mKodeKonsumen.setEnabled(false);
        mKodeKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKodeKonsumenActionPerformed(evt);
            }
        });

        mNamaKonsumen.setEnabled(false);

        mAlamatKonsumen.setEnabled(false);

        mKotaKonsumen.setEnabled(false);

        mTelpKonsumen.setEnabled(false);

        mHPKonsumen.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mKodeKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mNamaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mAlamatKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(mTelpKonsumen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                        .addComponent(mKotaKonsumen, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(mHPKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mKodeKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mNamaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(mAlamatKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mKotaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(mTelpKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(mHPKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        tabelKonsumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama", "Alamat", "Kota", "Telp", "HP"
            }
        ));
        jScrollPane1.setViewportView(tabelKonsumen);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        BtnTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo2/assets/Add_16x16.png"))); // NOI18N
        BtnTambah.setText("Tambah");
        BtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahActionPerformed(evt);
            }
        });

        BtnKoreksi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo2/assets/Edit_16x16.png"))); // NOI18N
        BtnKoreksi.setText("Koreksi");
        BtnKoreksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKoreksiActionPerformed(evt);
            }
        });

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo2/assets/Delete_16x16.png"))); // NOI18N
        BtnHapus.setText("Hapus");
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo2/assets/Save_16x16.png"))); // NOI18N
        BtnSimpan.setText("Simpan");
        BtnSimpan.setEnabled(false);
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo2/assets/Cancel_16x16.png"))); // NOI18N
        BtnBatal.setText("Batal");
        BtnBatal.setEnabled(false);
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pbo2/assets/Keluar_16x16.png"))); // NOI18N
        BtnKeluar.setText("Keluar");
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(BtnTambah)
                        .addGap(18, 18, 18)
                        .addComponent(BtnKoreksi)
                        .addGap(18, 18, 18)
                        .addComponent(BtnHapus)
                        .addGap(18, 18, 18)
                        .addComponent(BtnSimpan)
                        .addGap(18, 18, 18)
                        .addComponent(BtnBatal)
                        .addGap(18, 18, 18)
                        .addComponent(BtnKeluar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTambah)
                    .addComponent(BtnKoreksi)
                    .addComponent(BtnHapus)
                    .addComponent(BtnSimpan)
                    .addComponent(BtnBatal)
                    .addComponent(BtnKeluar))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnKoreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKoreksiActionPerformed
        // TODO add your handling code here:
        pil = 2;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false); 
        mKodeKonsumen.requestFocus();

    }//GEN-LAST:event_BtnKoreksiActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // TODO add your handling code here:
        pil = 1;
        setTombol(false, false, false, false, true, false); 
        setEdit(true, false, false, false, false, false); 
        mKodeKonsumen.requestFocus();

    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // TODO add your handling code here:
        pil = 3;
        setTombol(false, false, false, false, true, false); 
        setEdit(true, false, false, false, false, false); 
        mKodeKonsumen.requestFocus();

    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
        if (pil==1){
            simpanData();
        } else if (pil==2){
            koreksiData();
        }
            tampilTabel();
            pil = 4;
        setTombol(true, true, true, false, false, true); 
        setEdit(false, false, false, false, false, false); bersih();
        BtnTambah.requestFocus();
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        // TODO add your handling code here:
        if (pil==3){
        BtnSimpan.setText("Simpan");
        }
        pil = 5;
        setTombol(true, true, true, false, false, true);
        setEdit(false, false, false, false, false, false);
        bersih();
        BtnTambah.requestFocus();

    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        // TODO add your handling code here:
       this.dispose();

    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void mKodeKonsumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKodeKonsumenActionPerformed
        // TODO add your handling code here:
        if (mKodeKonsumen.getText().isEmpty()){ JOptionPane.showMessageDialog(null, "Kode Konsumen masih kosong...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
                mKodeKonsumen.requestFocus();
                } else {
                // Button Tambah
                if (pil==1){
                String sql_select = "select * from konsumen where kodekonsumen='"+mKodeKonsumen.getText()+"'";
                try {
                statement = k.con.createStatement();
                resultSet = statement.executeQuery(sql_select);
                int baris=0;
                while (resultSet.next()){
                baris = resultSet.getRow();
                }
                if (baris==0){
                setEdit(false, true, true, true, true, true); BtnSimpan.setEnabled(true); mNamaKonsumen.requestFocus();
                } else {
                JOptionPane.showMessageDialog(null, "Kode Konsumen sudah ada...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
                mKodeKonsumen.requestFocus();
                }
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                }
                }  // Akhir Button Tambah
                // Button Koreksi
                if (pil==2){
                String sql_select = "select * from konsumen where kodekonsumen='"+mKodeKonsumen.getText()+"'";
                try {
                statement = k.con.createStatement();
                resultSet = statement.executeQuery(sql_select);
                if (resultSet.next()){ mNamaKonsumen.setText(resultSet.getString(2)); mAlamatKonsumen.setText(resultSet.getString(3)); mKotaKonsumen.setText(resultSet.getString(4)); mTelpKonsumen.setText(resultSet.getString(5)); mHPKonsumen.setText(resultSet.getString(6));
                setEdit(false, true, true, true, true, true); BtnSimpan.setEnabled(true); mNamaKonsumen.requestFocus();
                } else {
                JOptionPane.showMessageDialog(null, "Kode Konsumen tidak diketemukan...",
                "Kesalahan",JOptionPane.ERROR_MESSAGE);
                   mKodeKonsumen.requestFocus();
                }
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                }
                } // Akhir Button Koreksi
                // Button Hapus
                if (pil==3){
                String sql_select = "select * from konsumen where kodekonsumen='"+mKodeKonsumen.getText()+"'";
                try {
                statement = k.con.createStatement();
                resultSet = statement.executeQuery(sql_select);
                if (resultSet.next()){ mNamaKonsumen.setText(resultSet.getString(2)); mAlamatKonsumen.setText(resultSet.getString(3)); mKotaKonsumen.setText(resultSet.getString(4)); mTelpKonsumen.setText(resultSet.getString(5)); mHPKonsumen.setText(resultSet.getString(6)); setEdit(false, false, false, false, false, false);
                int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?", "Penghapusan Data", JOptionPane.YES_NO_OPTION);
                if (opsi == JOptionPane.YES_OPTION){
                hapusData();
                }
                tampilTabel();
                setTombol(true, true, true, false, false, true);
                    setEdit(false, false, false, false, false, false);
                    bersih(); pil=5; BtnTambah.requestFocus();
                    } else {
                    JOptionPane.showMessageDialog(null, "Kode Konsumen tidak diketemukan...",
                    "Kesalahan",JOptionPane.ERROR_MESSAGE);
                    mKodeKonsumen.requestFocus();
                    }
                    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    } // Akhir Button Hapus
        }
    

        
        
        

    }//GEN-LAST:event_mKodeKonsumenActionPerformed

        


  

   
    
    
    
    

    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(FrmKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        



        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
        // Membuat form maksimal
        FrmKonsumen maks = new FrmKonsumen();
        maks.setExtendedState(JFrame.MAXIMIZED_BOTH);
        maks.setVisible(true);
        }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBatal;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnKeluar;
    private javax.swing.JButton BtnKoreksi;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mAlamatKonsumen;
    private javax.swing.JTextField mHPKonsumen;
    private javax.swing.JTextField mKodeKonsumen;
    private javax.swing.JTextField mKotaKonsumen;
    private javax.swing.JTextField mNamaKonsumen;
    private javax.swing.JTextField mTelpKonsumen;
    private javax.swing.JTable tabelKonsumen;
    // End of variables declaration//GEN-END:variables
}
