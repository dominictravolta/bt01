/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.ui;

import java.awt.event.ItemEvent;
import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import static java.time.ZonedDateTime.ofInstant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingWorker;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import org.addin.learns.bt01.controller.BookingController;
import static org.addin.learns.bt01.controller.BookingController.bookingColumns;
import org.addin.learns.bt01.domain.Booking;
import org.addin.learns.bt01.domain.Lapangan;
import org.addin.learns.bt01.domain.RegisMember;
import org.addin.learns.bt01.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/**
 *
 * @author eroot
 */
@Component
public class FormBooking extends javax.swing.JFrame {

    private static final String COMB_SILAHKAN_PILIH_STR = "-- silahkan pilih --";

    @Autowired
    private MenuUtama menuUtama;

    @Autowired
    private BookingController bookingController;

    private Long selectedBookingId;

    private Long selectedMemberId;

    private Boolean saving = false;

    /**
     * Creates new form from_booking
     */
    public FormBooking() {
        initComponents();
        groupIsMemberRadioButtons();
        setinitialRadbMemberValue();
    }

    private void setinitialRadbMemberValue() {
        radbMemberTidak.setSelected(true);
    }

    private void groupIsMemberRadioButtons() {
        btngrIsMember.add(radbMemberYa);
        btngrIsMember.add(radbMemberTidak);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrIsMember = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtfTglHabis = new javax.swing.JTextField();
        txtfNamaPenyewa = new javax.swing.JTextField();
        txtfKodeMember = new javax.swing.JTextField();
        txtfNamaMember = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtfNoBooking = new javax.swing.JTextField();
        datcTglSewa = new com.toedter.calendar.JDateChooser();
        combKodeLapangan = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtfDp = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtfStatusPembayaran = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        spinJamMulai = new javax.swing.JSpinner();
        spinJamSelesai = new javax.swing.JSpinner();
        spinMinMulai = new javax.swing.JSpinner();
        spinMinSelesai = new javax.swing.JSpinner();
        radbMemberYa = new javax.swing.JRadioButton();
        radbMemberTidak = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        txtfCari = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        combKodeLapanganFilter = new javax.swing.JComboBox<>();
        btnKembali = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Booking Lapangan"));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("No Booking");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Tgl Sewa");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nama Penyewa");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Member ?");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Kode Member");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Nama Member");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Tgl Habis");

        txtfTglHabis.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Kode Lapangan");

        combKodeLapangan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "....", "Lp1", "Lp2", "Lp3" }));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("Jam Mulai");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Selsai");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("DP");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Status Pembayaran");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        radbMemberYa.setText("Ya");

        radbMemberTidak.setText("Tidak");
        radbMemberTidak.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radbMemberTidakItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel10))
                                    .addGap(40, 40, 40))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(69, 69, 69)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel6)))
                                .addGap(73, 73, 73)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtfTglHabis, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfStatusPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfDp, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfNamaPenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfNamaMember, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfKodeMember, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(datcTglSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfNoBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radbMemberYa)
                                .addGap(18, 18, 18)
                                .addComponent(radbMemberTidak))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(combKodeLapangan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(spinJamMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(spinJamSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(28, 28, 28)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(spinMinMulai, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                                        .addComponent(spinMinSelesai)))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfNoBooking, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(datcTglSewa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(radbMemberYa)
                    .addComponent(radbMemberTidak))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfKodeMember, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfNamaMember, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtfTglHabis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfNamaPenyewa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(combKodeLapangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(spinJamMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinMinMulai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinMinSelesai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(spinJamSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfDp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtfStatusPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

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
        jScrollPane1.setViewportView(table);

        jLabel15.setText("Cari");

        txtfCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfCariKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Kode Lapangan");

        combKodeLapanganFilter.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combKodeLapanganFilterItemStateChanged(evt);
            }
        });

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jLabel1.setText("Data Booking Lapangan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtfCari, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(combKodeLapanganFilter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(231, 231, 231))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(240, 240, 240))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtfCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combKodeLapanganFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        menuUtama.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        refreshBookingList();
        refreshLapanganList();
    }//GEN-LAST:event_formWindowOpened

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String noBooking = txtfNoBooking.getText();
        Date tglSewaDate = datcTglSewa.getDate();
        ZonedDateTime tglSewa = createZonedDateTimeFromDate(tglSewaDate);
        String namaPenyewa = txtfNamaPenyewa.getText();
        String selectedKodeLapangan = (String) combKodeLapangan.getSelectedItem();
        Integer jamMulaiHour = (Integer) spinJamMulai.getValue();
        Integer jamMulaiMin = (Integer) spinMinMulai.getValue();
        Integer jamSelesaiHour = (Integer) spinJamSelesai.getValue();
        Integer jamSelesaiMin = (Integer) spinMinSelesai.getValue();

        String dp = txtfDp.getText();
        String statusPembayaran = txtfStatusPembayaran.getText();

        saveNewBooking(noBooking, tglSewa, namaPenyewa, selectedKodeLapangan,
                jamMulaiHour, jamMulaiMin, jamSelesaiHour, jamSelesaiMin, dp, statusPembayaran, selectedMemberId);
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void saveNewBooking(String noBooking, ZonedDateTime tglSewa, String namaPenyewa,
            String selectedKodeLapangan, Integer jamMulaiHour, Integer jamMulaiMin,
            Integer jamSelesaiHour, Integer jamSelesaiMin, String dp, String statusPembayaran, Long memberId) {
        Booking booking = new Booking()
                .withNoBooking(noBooking)
                .withTglSewa(tglSewa)
                .withMember(ofNullable(memberId)
                        .map(m -> {
                            RegisMember rm = new RegisMember();
                            rm.setId(memberId);
                            return rm;
                        }).orElse(null)
                ).withNamaPenyewa(namaPenyewa)
                .withKodeLapangan(selectedKodeLapangan)
                .withJamMulai(LocalTime.of(jamMulaiHour, jamMulaiMin))
                .withJamSelesai(LocalTime.of(jamSelesaiHour, jamSelesaiMin))
                .withDp(new BigDecimal(dp))
                .withStatusPembayaran(statusPembayaran);

        saving = true;
        btnSimpan.setEnabled(false);
        new SwingWorker<Booking, Void>() {
            @Override
            protected Booking doInBackground() throws Exception {
                return bookingController.save(booking);
            }

            @Override
            protected void done() {
                try {
                    Booking savedBooking = get();
                    refreshBookingList();
                    clearForm();
                    saving = false;
                    btnSimpan.setEnabled(true);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(FormBooking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
    }

    private void clearForm() {
        txtfNoBooking.setText("");
        datcTglSewa.setDate(null);
        txtfNamaPenyewa.setText("");
        combKodeLapangan.setSelectedIndex(0);
        spinJamMulai.setValue(0);
        spinMinMulai.setValue(0);
        spinJamSelesai.setValue(0);
        spinMinSelesai.setValue(0);
        txtfDp.setText("");
        txtfStatusPembayaran.setText("");
    }

    private ZonedDateTime createZonedDateTimeFromDate(Date tglSewaDate) {
        ZonedDateTime tglSewa = null;
        if (tglSewaDate != null) {
            tglSewa = ofInstant(tglSewaDate.toInstant(), ZoneId.systemDefault());
        }
        return tglSewa;
    }

    private void radbMemberTidakItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radbMemberTidakItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            disableMemberInput();
            enableNonMemberInput();
        } else {
            enableMemberInput();
            disableNonMemberInput();
        }

    }//GEN-LAST:event_radbMemberTidakItemStateChanged

    private void txtfCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfCariKeyTyped
        if (!evt.isActionKey()) {
            refreshBookingList();
        }
    }//GEN-LAST:event_txtfCariKeyTyped

    private void combKodeLapanganFilterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combKodeLapanganFilterItemStateChanged
        refreshBookingList();
    }//GEN-LAST:event_combKodeLapanganFilterItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnSimpan;
    private javax.swing.ButtonGroup btngrIsMember;
    private javax.swing.JComboBox<String> combKodeLapangan;
    private javax.swing.JComboBox<String> combKodeLapanganFilter;
    private com.toedter.calendar.JDateChooser datcTglSewa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radbMemberTidak;
    private javax.swing.JRadioButton radbMemberYa;
    private javax.swing.JSpinner spinJamMulai;
    private javax.swing.JSpinner spinJamSelesai;
    private javax.swing.JSpinner spinMinMulai;
    private javax.swing.JSpinner spinMinSelesai;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtfCari;
    private javax.swing.JTextField txtfDp;
    private javax.swing.JTextField txtfKodeMember;
    private javax.swing.JTextField txtfNamaMember;
    private javax.swing.JTextField txtfNamaPenyewa;
    private javax.swing.JTextField txtfNoBooking;
    private javax.swing.JTextField txtfStatusPembayaran;
    private javax.swing.JTextField txtfTglHabis;
    // End of variables declaration//GEN-END:variables

    private void refreshBookingList() {

        String keyword = txtfCari.getText();
        String kodeLapanganFilterSelected = (String) combKodeLapanganFilter.getSelectedItem();

        new SwingWorker<Page<Booking>, Void>() {
            @Override
            protected Page<Booking> doInBackground() throws Exception {
                if (stringIsNotBlank(keyword) && kodeLapanganFilterIsSet(kodeLapanganFilterSelected)) {
                    return bookingController.findAllBookingByNoBookingAndKodeLapangan("%" + keyword + "%", kodeLapanganFilterSelected, Pageable.unpaged());
                } else if (stringIsNotBlank(keyword)) {
                    return bookingController.findAllBookingByNoBooking("%" + keyword + "%", Pageable.unpaged());
                } else if (kodeLapanganFilterIsSet(kodeLapanganFilterSelected)) {
                    return bookingController.findAllBookingByKodeLapangan(kodeLapanganFilterSelected, Pageable.unpaged());
                }
                return bookingController.findAllBooking(Pageable.unpaged());
            }

            @Override
            protected void done() {
                try {
                    Page<Booking> bookings = get();
                    updateTableModel(bookings);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(FormBooking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
    }

    private boolean kodeLapanganFilterIsSet(String kodeLapangan) {
        return kodeLapangan != null && !kodeLapangan.isBlank()
                && !kodeLapangan.equals(COMB_SILAHKAN_PILIH_STR);
    }

    private boolean stringIsNotBlank(String keyword) {
        return keyword != null && !keyword.isBlank();
    }

    private void updateTableModel(Page<Booking> bookings) {
        TableModel tableModel = createTableModelFor(bookings);
        table.setModel(tableModel);
    }

    private void refreshLapanganList() {
        new SwingWorker<Page<Lapangan>, Void>() {
            @Override
            protected Page<Lapangan> doInBackground() throws Exception {
                return bookingController.findAllLapangan(Pageable.unpaged());
            }

            @Override
            protected void done() {
                try {
                    Page<Lapangan> lapangans = get();
                    updateComboboxModel(lapangans);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(FormBooking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
    }

    private void updateComboboxModel(Page<Lapangan> lapangans) {
        combKodeLapangan.setModel(createComboBoxModelFor(lapangans));
        combKodeLapanganFilter.setModel(createComboBoxModelFor(lapangans));
    }

    private TableModel createTableModelFor(Page<Booking> bookings) {
        List<Booking> content = bookings.getContent();
        return new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return content.size();
            }

            @Override
            public int getColumnCount() {
                return bookingColumns.length;
            }

            @Override
            public String getColumnName(int column) {
                return bookingColumns[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Booking booking = content.get(rowIndex);
                final Optional<RegisMember> member = ofNullable(booking.getMember());
                switch (columnIndex) {
                    case 0:
                        return booking.getId();
                    case 1:
                        return booking.getNoBooking();
                    case 2:
                        return booking.getTglSewa();
                    case 3:
                        return member.map(RegisMember::getKode).orElse("");
                    case 4:
                        return booking.getNamaPenyewa();
                    case 5:
                        return booking.getKodeLapangan();
                    case 6:
                        return booking.getJamMulai();
                    case 7:
                        return booking.getJamSelesai();
                    case 8:
                        return booking.getDp();
                    case 9:
                        return booking.getStatusPembayaran();
                    default:
                        return "";
                }
            }
        };
    }

    private ComboBoxModel<String> createComboBoxModelFor(Page<Lapangan> lapangans) {
        final List<String> collect = lapangans.getContent().stream().map(Lapangan::getKode)
                .collect(Collectors.toList());
        collect.add(0, COMB_SILAHKAN_PILIH_STR);
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(collect.toArray(new String[]{}));
        return model;
    }

    private void disableMemberInput() {
        txtfKodeMember.setText("");
        txtfNamaMember.setText("");
        txtfTglHabis.setText("");
        txtfKodeMember.setEnabled(false);
        txtfNamaMember.setEnabled(false);
        selectedMemberId = null;
    }

    private void enableMemberInput() {
        txtfKodeMember.setText("");
        txtfNamaMember.setText("");
        txtfTglHabis.setText("");
        txtfKodeMember.setEnabled(true);
        txtfNamaMember.setEnabled(true);
        selectedMemberId = null;
    }

    private void disableNonMemberInput() {
        txtfNamaPenyewa.setText("");
        txtfNamaPenyewa.setEnabled(false);
    }

    private void enableNonMemberInput() {
        txtfNamaPenyewa.setText("");
        txtfNamaPenyewa.setEnabled(true);
    }
}
