/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import static javax.management.remote.JMXConnectorFactory.connect;
import static javax.management.remote.JMXConnectorFactory.connect;
import static javax.rmi.PortableRemoteObject.connect;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class FrmSupplier extends javax.swing.JFrame {

    /**
     * Creates new form FrmSupplier
     */
    koneksi k;
    Statement statement;
    ResultSet resultSet;
    int pil;


    public FrmSupplier() {
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
    private void tampilTabel(){
            Object
            header[]={"Kode","Nama Supplier","Alamat Supplier","Kota Supplier","Telp Supplier","Hp Supplier"};
            DefaultTableModel modelSupplier = new
            DefaultTableModel(null,header)
            {
            @Override
            // Membuat jTable read only
            public boolean isCellEditable(int row, int column)
            {
            return false;
            }
            };
            tabelSupplier.setModel(modelSupplier);
            int baris = tabelSupplier.getRowCount();
            for (int i = 0; i < baris; i++) {
            modelSupplier.removeRow(i);
            }
            String sql_select = "select * from supplier";
            try {
            statement = k.con.createStatement();
            resultSet = statement.executeQuery(sql_select);
            while(resultSet.next()){
            String kodeSupplier = resultSet.getString(1);
            String namaSupplier = resultSet.getString(2);
            String alamatSupplier = resultSet.getString(3);
            String kotaSupplier = resultSet.getString(4);
            String telpSupplier = resultSet.getString(5);
            String hpSupplier = resultSet.getString(6);
            String kolom[] = {kodeSupplier,namaSupplier,alamatSupplier,kotaSupplier,telpSupplier,hpSupplier};
            modelSupplier.addRow(kolom);
            }
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            }
}
    
    private void bersih(){
        mKodeSupplier.setText(null);
        mNamaSupplier.setText(null);
        mAlamatSupplier.setText(null);
        mKotaSupplier.setText(null);
        mTelpSupplier.setText(null);
        mHpSupplier.setText(null);
}
    
    private void setTombol(boolean xTambah,boolean
        xKoreksi,boolean xHapus,
        boolean xSimpan,boolean xBatal,boolean xKeluar){
        BtnTambah.setEnabled(xTambah);
        BtnKoreksi.setEnabled(xKoreksi);
        BtnHapus.setEnabled(xHapus);
        BtnSimpan.setEnabled(xSimpan);
        BtnBatal.setEnabled(xBatal);
        BtnKeluar.setEnabled(xKeluar);
}
    
    private void setEdit(boolean yKode,boolean yNama,boolean
        yAlamat,boolean yKota,
        boolean yTelp,boolean yHP){
        mKodeSupplier.setEnabled(yKode);
        mNamaSupplier.setEnabled(yNama);
        mAlamatSupplier.setEnabled(yAlamat);
        mKotaSupplier.setEnabled(yKota);
        mTelpSupplier.setEnabled(yTelp);
        mHpSupplier.setEnabled(yHP);
}
    
    private void simpanData(){
//        
//       
//        
//      kode    =   mKodeSupplier.getText();
//      namaBrg    =   mNamaSupplier.getText();
//      hrgBeli=Integer.parseInt(mHargaBeliSupplier.getText());
//      hrgJual=Integer.parseInt(mHargaJualSupplier.getText());
//      stokBrg=Integer.parseInt(mStockSupplier.getText());
//      stokMin=Integer.parseInt(mStokMinSupplier.getText());
      
  
    String sql_insert = "insert into supplier values ('"+mKodeSupplier.getText()+"','"+ mNamaSupplier.getText()+"','"+mAlamatSupplier.getText()+"','"+mKotaSupplier.getText() +"','"+mTelpSupplier.getText()+"','"+mHpSupplier.getText()+"')";
     try {
         
        statement.executeUpdate(sql_insert);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        }
}
     
     private void koreksiData(){
        String sql_edit = "update supplier set namasupplier='"+mNamaSupplier.getText()+"', alamatsupplier='"+mAlamatSupplier.getText()+"', kotasupplier='"+mKotaSupplier.getText()+ "', telpsupplier='"+ mTelpSupplier.getText()+"', hpsupplier='"+mHpSupplier.getText()+ "' where kodesupplier='"+mKodeSupplier.getText()+"'";
        try {
            statement.executeUpdate(sql_edit);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
}
     
private void hapusData(){
String sql_delete = "delete from supplier where kodesupplier='"+mKodeSupplier.getText()+"'";
try {
statement.executeUpdate(sql_delete);
} catch (Exception e) {
JOptionPane.showMessageDialog(null, e.getMessage());
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

        BtnBatal = new javax.swing.JButton();
        BtnKeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelSupplier = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mKodeSupplier = new javax.swing.JTextField();
        mNamaSupplier = new javax.swing.JTextField();
        mAlamatSupplier = new javax.swing.JTextField();
        mKotaSupplier = new javax.swing.JTextField();
        mTelpSupplier = new javax.swing.JTextField();
        mHpSupplier = new javax.swing.JTextField();
        BtnTambah = new javax.swing.JButton();
        BtnKoreksi = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnSimpan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(". :  PENDATAAN SUPPLIER : .");

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

        tabelSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Kode", "Nama", "Alamat", "Kota", "Telp.", "HP"
            }
        ));
        tabelSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelSupplier);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Kode Supplier");

        jLabel2.setText("Nama Supplier");

        jLabel3.setText("Alamat Supplier");

        jLabel4.setText("Kota Supplier");

        jLabel5.setText("Telp Supplier");

        jLabel6.setText("Hp Supplier");

        mKodeSupplier.setEnabled(false);
        mKodeSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKodeSupplierActionPerformed(evt);
            }
        });

        mNamaSupplier.setEnabled(false);

        mAlamatSupplier.setEnabled(false);

        mKotaSupplier.setEnabled(false);

        mTelpSupplier.setEnabled(false);

        mHpSupplier.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mAlamatSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mKotaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(mHpSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        .addComponent(mTelpSupplier, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mAlamatSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mKotaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(mTelpSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(mHpSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTambah)
                    .addComponent(BtnKoreksi)
                    .addComponent(BtnHapus)
                    .addComponent(BtnSimpan)
                    .addComponent(BtnBatal)
                    .addComponent(BtnKeluar))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void tabelSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSupplierMouseClicked
        // TODO add your handling code here:

        if (pil==2 || pil==3){
            mKodeSupplier.setText(tabelSupplier.getValueAt(tabelSupplier.getSelectedRow(), 0).toString());
            mNamaSupplier.setText(tabelSupplier.getValueAt(tabelSupplier.getSelectedRow(), 1).toString());
            mAlamatSupplier.setText(tabelSupplier.getValueAt(tabelSupplier.getSelectedRow(), 2).toString());
            mKotaSupplier.setText(tabelSupplier.getValueAt(tabelSupplier.getSelectedRow(), 3).toString());
            mTelpSupplier.setText(tabelSupplier.getValueAt(tabelSupplier.getSelectedRow(), 4).toString());
            mHpSupplier.setText(tabelSupplier.getValueAt(tabelSupplier.getSelectedRow(), 5).toString());
        }
        if (pil == 2) {
            setEdit(false, true, true, true, true, true);
            BtnSimpan.setEnabled(true);
            mNamaSupplier.requestFocus();
        }
        if (pil == 3) {
            mKodeSupplier.setEnabled(false);
            int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?", "Penghapusan Data",
                JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION){
                hapusData();
            }
            tampilTabel();
            setTombol(true, true, true, false, false, true);
            setEdit(false, false, false, false, false, false);
            bersih();
            pil=5;
            BtnTambah.requestFocus();
        }
    }//GEN-LAST:event_tabelSupplierMouseClicked

    private void mKodeSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKodeSupplierActionPerformed
        // TODO add your handling code here:

        if (mKodeSupplier.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kode Supplier masih kosong...","Kesalahan",JOptionPane.ERROR_MESSAGE);
            mKodeSupplier.requestFocus();
        } else {
            // Button Tambah
            if (pil==1){
                String sql_select = "select * from supplier where kodesupplier='"+mKodeSupplier.getText()+"'";
                try {
                    statement = k.con.createStatement();
                    resultSet = statement.executeQuery(sql_select);
                    int baris=0;
                    while (resultSet.next()){
                        baris = resultSet.getRow();
                    }
                    if (baris==0){
                        setEdit(false, true, true, true, true, true);
                        BtnSimpan.setEnabled(true);
                        mNamaSupplier.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Supplier sudah ada...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
                        mKodeSupplier.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                        e.getMessage());
                }
            } // Akhir Button Tambah
            // Button Koreksi
            if (pil==2){
                String sql_select = "select * from supplier where kodesupplier='"+mKodeSupplier.getText()+"'";
                try {
                    statement = k.con.createStatement();
                    resultSet = statement.executeQuery(sql_select);
                    if (resultSet.next()){
                        mNamaSupplier.setText(resultSet.getString(2));
                        mAlamatSupplier.setText(resultSet.getString(3));
                        mKotaSupplier.setText(resultSet.getString(4));
                        mTelpSupplier.setText(resultSet.getString(5));
                        mHpSupplier.setText(resultSet.getString(6));
                        setEdit(false, true, true, true, true, true);
                        BtnSimpan.setEnabled(true);
                        mNamaSupplier.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Supplier tidak diketemukan...","Kesalahan",JOptionPane.ERROR_MESSAGE);
                        mKodeSupplier.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                        e.getMessage());
                }
            } // Akhir Button Koreksi
            // Button Hapus
            if (pil==3){
                String sql_select = "select * from supplier where kodesupplier='"+mKodeSupplier.getText()+"'";
                try {
                    statement = k.con.createStatement();
                    resultSet = statement.executeQuery(sql_select);
                    if (resultSet.next()){
                        mNamaSupplier.setText(resultSet.getString(2));
                        mAlamatSupplier.setText(resultSet.getString(3));
                        mKotaSupplier.setText(resultSet.getString(4));
                        mTelpSupplier.setText(resultSet.getString(5));
                        mHpSupplier.setText(resultSet.getString(6));
                        setEdit(false, false, false, false, false,
                            false);
                        int opsi = JOptionPane.showConfirmDialog(null,
                            "Benarkah anda ingin menghapus data ini ?", "Penghapusan Data",
                            JOptionPane.YES_NO_OPTION);
                        if (opsi == JOptionPane.YES_OPTION){
                            hapusData();
                        }
                        tampilTabel();
                        setTombol(true, true, true, false, false,
                            true);
                        setEdit(false, false, false, false, false,
                            false);
                        bersih();
                        pil=5;
                        BtnTambah.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Supplier tidak diketemukan...","Kesalahan",JOptionPane.ERROR_MESSAGE);
                        mKodeSupplier.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                        e.getMessage());
                }
            } // Akhir Button Hapus
        }
    }//GEN-LAST:event_mKodeSupplierActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // TODO add your handling code here:
        pil = 1;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false);
        mKodeSupplier.requestFocus();
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnKoreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKoreksiActionPerformed
        // TODO add your handling code here:pil=2;

        pil=2;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false);
        mKodeSupplier.requestFocus();
    }//GEN-LAST:event_BtnKoreksiActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // TODO add your handling code here:

        pil = 3;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false);
        mKodeSupplier.requestFocus();
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:

        // TODO add your handling code here:
        if (pil==1){
            simpanData();
        } else if (pil==2){
            koreksiData();
        }
        tampilTabel();
        pil = 4;
        setTombol(true, true, true, false, false, true);
        setEdit(false, false, false, false, false, false);
        bersih();
        BtnTambah.requestFocus();
    }//GEN-LAST:event_BtnSimpanActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        // Membuat form maksimal
        FrmSupplier maks = new FrmSupplier();
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mAlamatSupplier;
    private javax.swing.JTextField mHpSupplier;
    private javax.swing.JTextField mKodeSupplier;
    private javax.swing.JTextField mKotaSupplier;
    private javax.swing.JTextField mNamaSupplier;
    private javax.swing.JTextField mTelpSupplier;
    private javax.swing.JTable tabelSupplier;
    // End of variables declaration//GEN-END:variables
}
