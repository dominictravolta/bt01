/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.ui;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.util.Optional;
import static java.util.Optional.ofNullable;
import static org.addin.learns.bt01.controller.PembayaranController.BELUM_LUNAS;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import org.addin.learns.bt01.controller.PembayaranController;
import org.addin.learns.bt01.domain.Booking;
import org.addin.learns.bt01.domain.Pembayaran;
import org.addin.learns.bt01.domain.RegisMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 *
 * @author eroot
 */
@Component
public class FormSewaLapangan extends javax.swing.JFrame {

    @Autowired
    private MenuUtama menuUtama;

    @Autowired
    private PembayaranController controller;
    
    private Booking selectedBooking;
    
    private Boolean saving = false;

    /**
     * Creates new form from_sewalapangan
     */
    public FormSewaLapangan() {
        initComponents();
        addSelectionListenerForTableBooking();
    }
    
    private void addSelectionListenerForTableBooking() {
        ListSelectionModel selectionModel = tableBooking.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = tableBooking.getSelectedRow();
                final TableModel tableModel = tableBooking.getModel();
                if (selectedRow > -1 && tableModel.getRowCount() > 0) {
                    Long selectedBookingId = (Long) tableModel.getValueAt(selectedRow, 0);
                    if (selectedBookingId != null) {
                        new SwingWorker<Booking, Void>() {
                            @Override
                            protected Booking doInBackground() throws Exception {
                                return controller.getOneById(selectedBookingId);
                            }

                            @Override
                            protected void done() {
                                try {
                                    Booking booking = get();
                                    selectedBooking = booking;
                                    setFieldsWith(selectedBooking);
                                } catch (InterruptedException | ExecutionException ex) {
                                    Logger.getLogger(FormSewaLapangan.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                        }.execute();
                    }
                } else {
                    selectedBooking = null;
                }
            }
        });
    }
    
    private void setFieldsWith(Booking book) {
        BigDecimal bookingFee = selectedBooking.getDp();
        AtomicLong durationInMinutes = new AtomicLong();
        BigDecimal potonganMember = BigDecimal.valueOf(20000);
        BigDecimal tarifPerMenit = BigDecimal.valueOf(1000);

        final Optional<LocalTime> jamMulaiOptional = ofNullable(book.getJamMulai());
        txtfJamMulai.setText(jamMulaiOptional.map(LocalTime::toString).orElse(""));
        final Optional<LocalTime> jamSelesaiOptional = ofNullable(book.getJamSelesai());
        txtfJamSelesai.setText(jamSelesaiOptional.map(LocalTime::toString).orElse(""));
        jamSelesaiOptional.ifPresent((t) -> {
            durationInMinutes.set(MINUTES.between(jamMulaiOptional.orElse(LocalTime.now()), t));
            txtfDurasi.setText(durationInMinutes + " min");
        });
        RegisMember member = book.getMember();

        BigDecimal jumlahTagihan = tarifPerMenit.multiply(BigDecimal.valueOf(durationInMinutes.longValue())).subtract(bookingFee);

        if(member != null) {
            jumlahTagihan = jumlahTagihan.subtract(potonganMember);
        }

        txtfHarusDibayar.setText(jumlahTagihan.toString());
        txtfKodeLapangan.setText(book.getKodeLapangan());
        txtfNamaPenyewa.setText(book.getMember() == null ? book.getNamaPenyewa() : book.getMember().getNama());
        txtfNoBooking.setText(book.getNoBooking());
        txtfStatusMember.setText(book.getMember() == null ? "Tidak" : "Ya");
        txtfStatusPembayaran.setText(book.getStatusPembayaran());
        txtfTgl.setText(book.getTglSewa().format(DateTimeFormatter.ISO_DATE));
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
        jLabel3 = new javax.swing.JLabel();
        txtfNoBooking = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtfNamaPenyewa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtfTgl = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtfStatusMember = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtfKodeLapangan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtfJamMulai = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtfJamSelesai = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtfDurasi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtfStatusPembayaran = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtfHarusDibayar = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtfNoTransaksi = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableBooking = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txtfCariBooking = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePembayaran = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txtfCariPembayaran = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("No Booking");

        txtfNoBooking.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Tgl");

        txtfNamaPenyewa.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Status Member");

        txtfTgl.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Nama Penyewa");

        txtfStatusMember.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Kode Lapangan");

        txtfKodeLapangan.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Jam Mulai");

        txtfJamMulai.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("s/d");

        txtfJamSelesai.setEditable(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Durasi");

        txtfDurasi.setEditable(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Status Pembayaran");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Harus Dibayar");

        txtfHarusDibayar.setEditable(false);

        btnPrint.setText("Print");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel2.setText("No Transaksi");

        txtfNoTransaksi.setEditable(false);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))))
                                .addComponent(jLabel7)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtfJamMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel13)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtfJamSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtfDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtfStatusPembayaran)
                                    .addComponent(txtfHarusDibayar)
                                    .addComponent(txtfKodeLapangan)
                                    .addComponent(txtfNamaPenyewa)
                                    .addComponent(txtfStatusMember)
                                    .addComponent(txtfTgl)
                                    .addComponent(txtfNoBooking)
                                    .addComponent(txtfNoTransaksi))))
                        .addGap(0, 43, Short.MAX_VALUE))))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnPrint, btnReset});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfNoTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfNoBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfStatusMember, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfNamaPenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfKodeLapangan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtfJamMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtfJamSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14)
                        .addComponent(txtfDurasi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfStatusPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfHarusDibayar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset))
                .addGap(33, 33, 33))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnPrint, btnReset});

        tableBooking.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableBooking);

        jLabel15.setText("Cari");

        txtfCariBooking.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfCariBookingKeyTyped(evt);
            }
        });

        jLabel1.setText("Data booking");

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jLabel8.setText("Data Pembayran Lapangan");

        tablePembayaran.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablePembayaran);

        jLabel16.setText("Cari");

        txtfCariPembayaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfCariPembayaranKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfCariBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 637, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtfCariPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfCariBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfCariPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        menuUtama.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        clearForm();
        refreshBookingList();
        refreshPembayaranList();
    }//GEN-LAST:event_formWindowOpened

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String noTransaksi = txtfNoTransaksi.getText();
        String harusDibayar = txtfHarusDibayar.getText();
//        String statusBayar = txtfStatusPembayaran.getText();
        String statusBayar = "LUNAS";
        saveNewPembayaran(selectedBooking, noTransaksi, harusDibayar, statusBayar);
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearForm();
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtfCariBookingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfCariBookingKeyTyped
        refreshBookingList();
    }//GEN-LAST:event_txtfCariBookingKeyTyped

    private void txtfCariPembayaranKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfCariPembayaranKeyTyped
        refreshPembayaranList();
    }//GEN-LAST:event_txtfCariPembayaranKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableBooking;
    private javax.swing.JTable tablePembayaran;
    private javax.swing.JTextField txtfCariBooking;
    private javax.swing.JTextField txtfCariPembayaran;
    private javax.swing.JTextField txtfDurasi;
    private javax.swing.JTextField txtfHarusDibayar;
    private javax.swing.JTextField txtfJamMulai;
    private javax.swing.JTextField txtfJamSelesai;
    private javax.swing.JTextField txtfKodeLapangan;
    private javax.swing.JTextField txtfNamaPenyewa;
    private javax.swing.JTextField txtfNoBooking;
    private javax.swing.JTextField txtfNoTransaksi;
    private javax.swing.JTextField txtfStatusMember;
    private javax.swing.JTextField txtfStatusPembayaran;
    private javax.swing.JTextField txtfTgl;
    // End of variables declaration//GEN-END:variables

    private void clearForm() {
        tableBooking.clearSelection();
        selectedBooking = null;
        txtfDurasi.setText("");
        txtfHarusDibayar.setText("");
        txtfJamMulai.setText("");
        txtfJamSelesai.setText("");
        txtfKodeLapangan.setText("");
        txtfNamaPenyewa.setText("");
        txtfNoBooking.setText("");
        txtfStatusMember.setText("");
        txtfStatusPembayaran.setText("");
        txtfTgl.setText("");
        refreshNextNoTransaksi();
    }
    
    private void refreshBookingList() {

        String keyword = txtfCariBooking.getText();

        new SwingWorker<Page<Booking>, Void>() {
            @Override
            protected Page<Booking> doInBackground() throws Exception {
                if (stringIsNotBlank(keyword)) {
                    return controller.findAllBookingByNoBookingAndStatusPembayaran("%" + keyword + "%", BELUM_LUNAS,  Pageable.unpaged());
                }
                return controller.findAllBookingByStatusPembayaran(BELUM_LUNAS, Pageable.unpaged());
            }

            @Override
            protected void done() {
                try {
                    Page<Booking> bookings = get();
                    updateTableBookingModel(bookings);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(FormBooking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
    }

    private boolean stringIsNotBlank(String keyword) {
        return keyword != null && !keyword.isBlank();
    }

    private void updateTableBookingModel(Page<Booking> bookings) {
        TableModel tableModel = TableModelUtils.createTableModelForBooking(bookings);
        tableBooking.setModel(tableModel);
    }

    private void refreshPembayaranList() {
        String keyword = txtfCariPembayaran.getText();

        new SwingWorker<Page<Pembayaran>, Void>() {
            @Override
            protected Page<Pembayaran> doInBackground() throws Exception {
                if (stringIsNotBlank(keyword)) {
                    return controller.findAllPembayaranByNoTransaksi("%" + keyword + "%", Pageable.unpaged());
                }
                return controller.findAllPembayaran(Pageable.unpaged());
            }

            @Override
            protected void done() {
                try {
                    Page<Pembayaran> bookings = get();
                    updateTablePembayaranModel(bookings);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(FormBooking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
    }

    private void updateTablePembayaranModel(Page<Pembayaran> pembayarans) {
        TableModel tableModel = TableModelUtils.createTableModelForPembayaran(pembayarans);
        tablePembayaran.setModel(tableModel);
    }

    private void saveNewPembayaran(Booking selectedBooking, String noTransaksi, String harusDibayar, String statusBayar) {
        selectedBooking.setStatusPembayaran(statusBayar);
        Pembayaran bayaran = new Pembayaran()
                .withBooking(selectedBooking)
                .withNoTransaksi(noTransaksi)
                .withHarusBayar(fromStringToBigDec(harusDibayar));
        saving = true;
        btnSimpan.setEnabled(false);
        new SwingWorker<Pembayaran, Void>() {
            @Override
            protected Pembayaran doInBackground() throws Exception {
                return controller.save(bayaran, selectedBooking);
            }

            @Override
            protected void done() {
                try {
                    Pembayaran pembayaran = get();
                    clearForm();
                    refreshBookingList();
                    refreshPembayaranList();
                    saving = false;
                    btnSimpan.setEnabled(true);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(FormSewaLapangan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
    }

    private BigDecimal fromStringToBigDec(String harusDibayar) {
        return harusDibayar != null && !harusDibayar.isBlank() ? new BigDecimal(harusDibayar) : null;
    }

    private void refreshNextNoTransaksi() {
        btnSimpan.setEnabled(false);
        new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                return controller.findNextNoTransaksi();
            }

            @Override
            protected void done() {
                try {
                    String nextNoTransaksi = get();
                    txtfNoTransaksi.setText(nextNoTransaksi);
                    btnSimpan.setEnabled(true);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(FormBooking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }.execute();
    }
}
