/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo2;

/**
 *
 * @author USER
 */
import java.sql.ResultSet;
import java.sql.Statement; 
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FrmBarang extends javax.swing.JFrame {
    koneksi k;
        Statement statement;
        ResultSet resultSet;
        int pil;
    /**
     * Creates new form FrmBarang
     */
    public FrmBarang() {
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
        String sql_insert  = "insert into barang values ('"+mKodeBarang.getText()+"','"+mNamaBarang.getText()+"','"+mHargaBeli.getText()+"','"+mHargaJual.getText()+"','"+mStokBarang.getText()+"','"+mStokMinBarang.getText()+"')";
     try {
        statement.executeUpdate(sql_insert);
     } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
      
      private void koreksiData(){
        String sql_edit  = "update barang set namabarang='"+mNamaBarang.getText()+"', hargabeli='"+mHargaBeli.getText()+"', hargajual='"+mHargaJual.getText()+"', stokbarang='"+mStokBarang.getText()+"', stokminbarang='"+mStokMinBarang.getText()+"' where kodebarang='"+mKodeBarang.getText()+"'";
        try {
        statement.executeUpdate(sql_edit);
    } catch (Exception e) {
    JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
      
      
      
      private void hapusData(){
        String sql_delete  = "delete from barang where kodebarang='"+mKodeBarang.getText()+"'";
        try  {
            statement.executeUpdate(sql_delete);
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
    }
}
      
      
      private void bersih(){ 
        mKodeBarang.setText(null); 
        mNamaBarang.setText(null); 
        mHargaBeli.setText(null); 
        mHargaJual.setText(null); 
        mStokBarang.setText(null); 
        mStokMinBarang.setText(null);
    }
    
        
      
      
    private void setTombol(boolean xTambah,boolean xKoreksi,boolean xHapus, boolean xSimpan,boolean xBatal,boolean xKeluar){ 
        BtnTambah.setEnabled(xTambah);
        BtnKoreksi.setEnabled(xKoreksi);
        BtnHapus.setEnabled(xHapus); 
        BtnSimpan.setEnabled(xSimpan);
        BtnBatal.setEnabled(xBatal); 
        BtnKeluar.setEnabled(xKeluar);
    }

    private void setEdit(boolean yKode,boolean yNama,boolean yBeli,boolean yJual,boolean yStok,boolean yStokMin){ 
        mKodeBarang.setEnabled(yKode);
        mNamaBarang.setEnabled(yNama); 
        mHargaBeli.setEnabled(yBeli); 
        mHargaJual.setEnabled(yJual); 
        mStokBarang.setEnabled(yStok); 
        mStokMinBarang.setEnabled(yStokMin);
}
      
    
    
    
    
    
    private void tampilTabel(){
     Object header[]={"Kode","Nama","Harga Beli","Harga jual","Stok Barang","Stok Min Barang"};
     DefaultTableModel modelBarang = new DefaultTableModel(null,header)
     {
    @Override
    // Membuat jTable read only
    public boolean isCellEditable(int row, int column)
    {
        return false;
    }
}; 
     tabelBarang.setModel(modelBarang);
     int baris = tabelBarang.getRowCount(); 
     for (int i = 0; i < baris; i++) {
     modelBarang.removeRow(i);
}
     String sql_select = "select * from barang";
try {
    statement = k.con.createStatement();
    resultSet = statement.executeQuery(sql_select);

    
    while(resultSet.next()){
    String kode = resultSet.getString(1); 
    String nama = resultSet.getString(2); 
    String hargabeli = resultSet.getString(3);
    String hargajual = resultSet.getString(4); 
    String stokbarang = resultSet.getString(5);
    String stokminbarang = resultSet.getString(6);
    String kolom[] = {kode,nama,hargabeli,hargajual,stokbarang,stokminbarang};
    modelBarang.addRow(kolom);
    }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mKodeBarang = new javax.swing.JTextField();
        mNamaBarang = new javax.swing.JTextField();
        mHargaBeli = new javax.swing.JTextField();
        mHargaJual = new javax.swing.JTextField();
        mStokBarang = new javax.swing.JTextField();
        mStokMinBarang = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        BtnTambah = new javax.swing.JButton();
        BtnKoreksi = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        BtnSimpan = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();
        BtnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(".: PENDATAAN BARANG :.");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Kode");

        jLabel2.setText("Nama");

        jLabel3.setText("Harga Beli");

        jLabel4.setText("Harga Jual");

        jLabel5.setText("Stok Barang");

        jLabel6.setText("Stok Min Barang");

        mKodeBarang.setEnabled(false);
        mKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKodeBarangActionPerformed(evt);
            }
        });

        mNamaBarang.setEnabled(false);
        mNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNamaBarangActionPerformed(evt);
            }
        });

        mHargaBeli.setEnabled(false);

        mHargaJual.setEnabled(false);

        mStokBarang.setEnabled(false);

        mStokMinBarang.setEnabled(false);
        mStokMinBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mStokMinBarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(mHargaJual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addComponent(mHargaBeli, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(mStokMinBarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                        .addComponent(mStokBarang, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(mStokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(mStokMinBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(241, 241, 241))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnTambah)
                    .addComponent(BtnKoreksi)
                    .addComponent(BtnHapus)
                    .addComponent(BtnSimpan)
                    .addComponent(BtnBatal)
                    .addComponent(BtnKeluar))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mNamaBarangActionPerformed

    private void mStokMinBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mStokMinBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mStokMinBarangActionPerformed

    private void BtnKoreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKoreksiActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        pil = 2;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false); 
        mKodeBarang.requestFocus();
    }//GEN-LAST:event_BtnKoreksiActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // TODO add your handling code here:
         pil = 1;
        setTombol(false, false, false, false, true, false); 
        setEdit(true, false, false, false, false, false); 
        mKodeBarang.requestFocus();
    }//GEN-LAST:event_BtnTambahActionPerformed

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

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
         if (pil==2 || pil==3){
             mKodeBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(),0).toString());
             mNamaBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(),1).toString());
             mHargaBeli.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(),2).toString());
             mHargaJual.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(),3).toString());
             mStokBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(),4).toString());
             mStokMinBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(),5).toString());
         }
         
          if (pil == 2) {
            setEdit(false, true, true, true, true, true); BtnSimpan.setEnabled(true); mNamaBarang.requestFocus();
         }
         if (pil == 3) {
             mKodeBarang.setEnabled(false);
         int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?", "Penghapusan Data", JOptionPane.YES_NO_OPTION);
         if (opsi == JOptionPane.YES_OPTION){
             hapusData();
         }
             tampilTabel();
             setTombol(true, true, true, false, false, true); setEdit(false, false, false, false, false, false); bersih();
          pil=5;
              BtnTambah.requestFocus();
         }
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // TODO add your handling code here:
        pil = 3;
        setTombol(false, false, false, false, true, false); 
        setEdit(true, false, false, false, false, false); 
        mKodeBarang.requestFocus();
    }//GEN-LAST:event_BtnHapusActionPerformed

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

    private void mKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKodeBarangActionPerformed
        // TODO add your handling code here:
        if (mKodeBarang.getText().isEmpty()){ JOptionPane.showMessageDialog(null, "Kode Barang masih kosong...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
                mKodeBarang.requestFocus();
                } else {
                // Button Tambah
                if (pil==1){
                String sql_select = "select * from barang where kodebarang='"+mKodeBarang.getText()+"'";
                try {
                statement = k.con.createStatement();
                resultSet = statement.executeQuery(sql_select);
                int baris=0;
                while (resultSet.next()){
                baris = resultSet.getRow();
                }
                if (baris==0){
                setEdit(false, true, true, true, true, true); BtnSimpan.setEnabled(true); mNamaBarang.requestFocus();
                } else {
                JOptionPane.showMessageDialog(null, "Kode Barang sudah ada...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
                mKodeBarang.requestFocus();
                }
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                }
                }  // Akhir Button Tambah
                // Button Koreksi
                if (pil==2){
                String sql_select = "select * from barang where kodebarang='"+mKodeBarang.getText()+"'";
                try {
                statement = k.con.createStatement();
                resultSet = statement.executeQuery(sql_select);
                if (resultSet.next()){ mNamaBarang.setText(resultSet.getString(2)); mHargaBeli.setText(resultSet.getString(3)); mHargaJual.setText(resultSet.getString(4)); mStokBarang.setText(resultSet.getString(5)); mStokMinBarang.setText(resultSet.getString(6));
                setEdit(false, true, true, true, true, true); BtnSimpan.setEnabled(true); mNamaBarang.requestFocus();
                } else {
                JOptionPane.showMessageDialog(null, "Kode  Barang tidak diketemukan...",
                "Kesalahan",JOptionPane.ERROR_MESSAGE);
                   mKodeBarang.requestFocus();
                }
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                }
                } // Akhir Button Koreksi
                // Button Hapus
                if (pil==3){
                String sql_select = "select * from barang where kodebarang='"+mKodeBarang.getText()+"'";
                try {
                statement = k.con.createStatement();
                resultSet = statement.executeQuery(sql_select);
                if (resultSet.next()){ mNamaBarang.setText(resultSet.getString(2)); mHargaJual.setText(resultSet.getString(3)); mHargaBeli.setText(resultSet.getString(4)); mStokBarang.setText(resultSet.getString(5)); mStokMinBarang.setText(resultSet.getString(6)); setEdit(false, false, false, false, false, false);
                int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?", "Penghapusan Data", JOptionPane.YES_NO_OPTION);
                if (opsi == JOptionPane.YES_OPTION){
                hapusData();
                }
                tampilTabel();
                setTombol(true, true, true, false, false, true);
                    setEdit(false, false, false, false, false, false);
                    bersih(); pil=5; BtnTambah.requestFocus();
                    } else {
                    JOptionPane.showMessageDialog(null, "Kode Barang tidak diketemukan...",
                    "Kesalahan",JOptionPane.ERROR_MESSAGE);
                    mKodeBarang.requestFocus();
                    }
                    } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    } // Akhir Button Hapus
        }
    }//GEN-LAST:event_mKodeBarangActionPerformed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
        // Membuat form maksimal
        FrmBarang maks = new FrmBarang();
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
    private javax.swing.JTextField mHargaBeli;
    private javax.swing.JTextField mHargaJual;
    private javax.swing.JTextField mKodeBarang;
    private javax.swing.JTextField mNamaBarang;
    private javax.swing.JTextField mStokBarang;
    private javax.swing.JTextField mStokMinBarang;
    private javax.swing.JTable tabelBarang;
    // End of variables declaration//GEN-END:variables
}
