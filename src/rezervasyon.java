import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sedanur
 */
public class rezervasyon extends javax.swing.JFrame {

    /**
     * Creates new form rezervasyon
     */
    public rezervasyon() {
        initComponents();
        TabloDoldur();
        jTextField1.setVisible(false);
        Statement st;
        try{
            st=baglantiAc();
            res=st.executeQuery("SELECT * FROM rezervasyon");    
        }
        catch(Exception ex){
            JOptionPane.showConfirmDialog(null,"Bağlantı Başarısız","MySQL Bağlantısı",JOptionPane.PLAIN_MESSAGE);
        }
    }
    private Connection conn = null;
    private String url = "jdbc:mysql://127.0.0.1:3306/";
    private String dbName = "otel";
    private String properties= "?useUnicode=true&characterEncoding=utf8";
    private String driver = "com.mysql.jdbc.Driver";
    private String userName = "root";
    private String password = "0000";
    private ResultSet res;
    
    public Statement baglantiAc() throws Exception {
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url + dbName + properties, userName, password);
        return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    }
    public void baglantiKapat() throws Exception {
        conn.close();
    }
    public void TabloDoldur() {
        try 
        {
            Statement st = baglantiAc();
            ResultSet res = st.executeQuery("SELECT * FROM  rezervasyon");
            Tablo model = new Tablo(res);
            jTable2.setModel(model); 
            baglantiKapat();
        } 
        catch (Exception e) 
        {
            JOptionPane.showConfirmDialog(null, "Bağlantı Başarısız", "MySQL Bağlantısı", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void KayitEkle(String radi,String rsoyadi,String rtarih,String rgtarih,String rctarih,String odano) {
        try {
            Statement st = baglantiAc();
            String sql= "INSERT INTO otel.rezervasyon(radi,rsoyadi,rtarih,rgtarih,rctarih,odano) VALUES (" +
            "'" + radi + "', " +
            "'" + rsoyadi + "', " +
            "'" + rtarih +"', "+
            "'" + rgtarih +"', "+
            "'" + rctarih +"', "+             
            "" + odano + ")";
            System.out.println(sql);
            st.executeUpdate(sql); 
            baglantiKapat(); 
            TabloDoldur();
        }
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Eklenemedi", "Rezervasyon Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void KayitSil(String ID) {
        try {
            Statement st = baglantiAc();
            st.executeUpdate("Delete FROM rezervasyon where rid=" + ID);
            baglantiKapat();
            TabloDoldur();  
        } 
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Silinemedi", "Rezervasyon Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void KayitGuncelle(String rid,String radi,String rsoyadi,String rtarih,String rgtarih,String rctarih,String odano) {
        try {
            Statement st = baglantiAc();
            String sql = "UPDATE otel.rezervasyon SET " +
            "radi= '" + radi +
            "', rsoyadi='" + rsoyadi +
            "', rtarih='" + rtarih +
            "', rgtarih='" + rgtarih +
            "', rctarih='" + rctarih +
            "', odano='" +odano +
            "' WHERE rid=" + rid;
            st.executeUpdate(sql);
            baglantiKapat(); 
            TabloDoldur();
        } 
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Güncellenemedi", "Rezervasyon Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }  
     public static void getSkills(int candidateId) {
        String query = "{ call rselectSP() }";
        ResultSet rs;
        try (Connection conn = MySQLJDBCUtil.ConnectDB();
            CallableStatement stmt = conn.prepareCall(query)) {
                rs = stmt.executeQuery();
                while (rs.next()) {
                    System.out.println(String.format(rs.getString("radi") + " "+ rs.getString("rsoyadi")+
                            rs.getString("rtarih")+rs.getString("rgtarih")+rs.getString("rctarih")+rs.getString("odano")));
                }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

     
     public void yaz(){
        try {
            tbradi.setText(res.getString("radi"));
            tbrsoyadi.setText(res.getString("rsoyadi"));
            tbrtarih.setText(res.getString("rtarih"));
            tbrgtarih.setText(res.getString("rgtarih"));
            tbrctarih.setText(res.getString("rctarih"));
            tbrodano.setText(res.getString("odano"));
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, "Bağlantı Başarısız", "MySQL Bağlantısı", JOptionPane.PLAIN_MESSAGE);
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

        jTextField4 = new javax.swing.JTextField();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        tbrctarih = new javax.swing.JFormattedTextField();
        tbrgtarih = new javax.swing.JFormattedTextField();
        tbrtarih = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tbradi = new javax.swing.JTextField();
        tbrsoyadi = new javax.swing.JTextField();
        tbrodano = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnyenikayit = new javax.swing.JButton();
        btnkaydet = new javax.swing.JButton();
        btnduzenle = new javax.swing.JButton();
        btnsil = new javax.swing.JButton();
        btnilk = new javax.swing.JButton();
        btnonceki = new javax.swing.JButton();
        btnsonraki = new javax.swing.JButton();
        btnson = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btneklesp = new javax.swing.JButton();
        btnlistelesp = new javax.swing.JButton();
        btnarasp = new javax.swing.JButton();
        btnduzenlesp = new javax.swing.JButton();
        btnsilsp = new javax.swing.JButton();
        aranan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btngeri = new javax.swing.JButton();
        btncikis = new javax.swing.JButton();

        jTextField4.setText("jTextField4");

        jFormattedTextField4.setText("jFormattedTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OTEL OTOMASYONU");

        jPanel1.setLayout(null);

        try {
            tbrctarih.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(tbrctarih);
        tbrctarih.setBounds(130, 180, 123, 30);

        try {
            tbrgtarih.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(tbrgtarih);
        tbrgtarih.setBounds(130, 140, 123, 30);

        try {
            tbrtarih.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(tbrtarih);
        tbrtarih.setBounds(130, 100, 123, 30);

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel2.setText("Adı:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 30, 50, 15);

        jLabel3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel3.setText("Soyadı:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 70, 60, 15);

        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel4.setText("Rezervasyon Tarihi:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 110, 115, 15);

        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel5.setText("Geliş Tarihi:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 150, 100, 15);

        jLabel6.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel6.setText("Çıkış Tarihi:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 190, 90, 15);

        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel7.setText("Oda No:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 230, 80, 15);
        jPanel1.add(tbradi);
        tbradi.setBounds(130, 20, 123, 30);
        jPanel1.add(tbrsoyadi);
        tbrsoyadi.setBounds(130, 60, 123, 30);

        tbrodano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbrodanoActionPerformed(evt);
            }
        });
        jPanel1.add(tbrodano);
        tbrodano.setBounds(130, 220, 123, 30);

        jTable2.setBackground(new java.awt.Color(234, 191, 147));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable2MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(280, 180, 410, 360);

        jPanel3.setBackground(new java.awt.Color(234, 191, 147));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("İŞLEMLER"));

        btnyenikayit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnyenikayit.setText("YENİ KAYIT");
        btnyenikayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnyenikayitActionPerformed(evt);
            }
        });

        btnkaydet.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnkaydet.setText("KAYDET");
        btnkaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkaydetActionPerformed(evt);
            }
        });

        btnduzenle.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnduzenle.setText("DÜZENLE");
        btnduzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnduzenleActionPerformed(evt);
            }
        });

        btnsil.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnsil.setText("SİL");
        btnsil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsilActionPerformed(evt);
            }
        });

        btnilk.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnilk.setText("İLK");
        btnilk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnilkActionPerformed(evt);
            }
        });

        btnonceki.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnonceki.setText("ÖNCEKİ");
        btnonceki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnoncekiActionPerformed(evt);
            }
        });

        btnsonraki.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnsonraki.setText("SONRAKİ");
        btnsonraki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsonrakiActionPerformed(evt);
            }
        });

        btnson.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnson.setText("SON");
        btnson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnyenikayit))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnkaydet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(btnonceki, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnilk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnduzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsil, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnson, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsonraki, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnyenikayit)
                    .addComponent(btnkaydet)
                    .addComponent(btnduzenle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnilk)
                    .addComponent(btnson))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnonceki)
                    .addComponent(btnsonraki)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(270, 20, 430, 140);

        jPanel2.setBackground(new java.awt.Color(234, 191, 147));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("SAKLI YORDAMLAR"));

        btneklesp.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btneklesp.setText("KAYDET");
        btneklesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneklespActionPerformed(evt);
            }
        });

        btnlistelesp.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnlistelesp.setText("LİSTELE");
        btnlistelesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlistelespActionPerformed(evt);
            }
        });

        btnarasp.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnarasp.setText("ARAMA YAP");
        btnarasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaraspActionPerformed(evt);
            }
        });

        btnduzenlesp.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnduzenlesp.setText("DÜZENLE");
        btnduzenlesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnduzenlespActionPerformed(evt);
            }
        });

        btnsilsp.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnsilsp.setText("SİL");
        btnsilsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsilspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlistelesp, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(aranan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addComponent(btnarasp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsilsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnduzenlesp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btneklesp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnlistelesp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneklesp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnduzenlesp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnsilsp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnarasp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aranan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 270, 260, 270);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/depositphotos_64518047-stock-photo-beautiful-flowers-backgrounds.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 710, 570);

        jTabbedPane1.addTab("REZERVASYON KAYIT", jPanel1);

        jToolBar1.setBackground(new java.awt.Color(234, 191, 147));
        jToolBar1.setRollover(true);

        btngeri.setText("GERİ");
        btngeri.setFocusable(false);
        btngeri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btngeri.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btngeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngeriActionPerformed(evt);
            }
        });
        jToolBar1.add(btngeri);

        btncikis.setText("ÇIKIŞ");
        btncikis.setFocusable(false);
        btncikis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btncikis.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btncikis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncikisActionPerformed(evt);
            }
        });
        jToolBar1.add(btncikis);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 589, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbrodanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbrodanoActionPerformed

    }//GEN-LAST:event_tbrodanoActionPerformed

    private void btngeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngeriActionPerformed
        rezervasyon ana_ekran = new rezervasyon();
        ana_ekran.setVisible(false);
        setVisible(false);
        gecis frame = new gecis();
        frame.setVisible(true);      
    }//GEN-LAST:event_btngeriActionPerformed

    private void btncikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncikisActionPerformed

        this.dispose();
    }//GEN-LAST:event_btncikisActionPerformed

    private void btnkaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkaydetActionPerformed
        String radi =tbradi.getText();
        String rsoyadi =tbrsoyadi.getText();
        String rtarih =tbrtarih.getText();
        String rgtarih =tbrgtarih.getText();
        String rctarih =tbrctarih.getText();
        String odano=tbrodano.getText();
        KayitEkle(radi,rsoyadi,rtarih,rgtarih,rctarih,odano);
    }//GEN-LAST:event_btnkaydetActionPerformed

    private void btnsilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsilActionPerformed
        String ID = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
        KayitSil(ID);
    }//GEN-LAST:event_btnsilActionPerformed

    private void btnduzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnduzenleActionPerformed
        String rid = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
        String radi =tbradi.getText();
        String rsoyadi =tbrsoyadi.getText();
        String rtarih =tbrtarih.getText();
        String rgtarih =tbrgtarih.getText();
        String rctarih =tbrctarih.getText();
        String odano=tbrodano.getText();
        KayitGuncelle(rid,radi,rsoyadi,rtarih,rgtarih,rctarih,odano);  
    }//GEN-LAST:event_btnduzenleActionPerformed

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
        jTextField1.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
        tbradi.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
        tbrsoyadi.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
        tbrtarih.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString());
        tbrgtarih.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString());
        tbrctarih.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString());
        tbrodano.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_jTable2MousePressed

    private void btnilkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnilkActionPerformed
        try {
            Boolean result=res.first();
            System.out.println("Sonuc: "+result);
            if (result==true)            
               yaz();
            else
               JOptionPane.showConfirmDialog(null, "İlk Kayıttasınız", "Rezervasyon Tablosu", JOptionPane.PLAIN_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Rezervasyon Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnilkActionPerformed

    private void btnoncekiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoncekiActionPerformed
        try {
            Boolean result=res.previous();
            if (result==true)            
                yaz();
            else
                JOptionPane.showConfirmDialog(null, "İlk Kayıttasınız", "Rezervasyon Tablosu", JOptionPane.PLAIN_MESSAGE);                
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Rezervasyon Tablosu", JOptionPane.PLAIN_MESSAGE);
        }

    }//GEN-LAST:event_btnoncekiActionPerformed

    private void btnsonrakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsonrakiActionPerformed
          try {
            Boolean result=res.next();
            if (result==true)            
                yaz();
            else
                JOptionPane.showConfirmDialog(null, "Son Kayıttasınız", "Rezervasyon Tablosu", JOptionPane.PLAIN_MESSAGE);                
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Rezervasyon Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnsonrakiActionPerformed

    private void btnsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsonActionPerformed
        try {
            res.last();
            yaz();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Rezervasyon Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnsonActionPerformed

    private void btnyenikayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnyenikayitActionPerformed
        tbradi.setText("");
        tbrsoyadi.setText("");
        tbrtarih.setText("");
        tbrgtarih.setText("");
        tbrctarih.setText("");
        tbrodano.setText("");
    }//GEN-LAST:event_btnyenikayitActionPerformed

    private void btneklespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneklespActionPerformed
        String query = "{ call rinsertSP(?,?,?,?,?,?) }";
        try (Connection conn = MySQLJDBCUtil.ConnectDB();
            CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, tbradi.getText());
            stmt.setString(2, tbrsoyadi .getText());
            stmt.setString(3, tbrtarih .getText());
            stmt.setString(4, tbrgtarih .getText());
            stmt.setString(5, tbrctarih .getText());
            stmt.setString(6, tbrodano.getText());
            stmt.execute();
            TabloDoldur();
            System.out.println("Veri Eklendi");
        }
        catch (SQLException ex) {
            System.out.println("Veri Eklenemedi");
        }
    }//GEN-LAST:event_btneklespActionPerformed

    private void btnlistelespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistelespActionPerformed
        getSkills(1);
    }//GEN-LAST:event_btnlistelespActionPerformed

    private void btnaraspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaraspActionPerformed
        String query = "{ call rsearchSP(?) }";
        ResultSet rs;
        try (Connection conn = MySQLJDBCUtil.ConnectDB();
            CallableStatement stmt = conn.prepareCall(query)) {
                stmt.setString(1, aranan.getText());
                rs = stmt.executeQuery();
                if (rs.next())
                    System.out.println(String.format(rs.getString("radi") + " "+ rs.getString("rsoyadi")+
                            rs.getString("rtarih")+rs.getString("rgtarih")+rs.getString("rctarih")+rs.getString("odano")));
                else
                    System.out.println("Veri Arandi Ama Bulunamadi");

        } catch (SQLException ex) {
            System.out.println("Veri Aranamadi");
        }
    }//GEN-LAST:event_btnaraspActionPerformed

    private void btnsilspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsilspActionPerformed
        String query = "{ call rdeleteSP(?) }";
       try (Connection conn = MySQLJDBCUtil.ConnectDB();
            CallableStatement stmt = conn.prepareCall(query)) {
                stmt.setString(1, jTextField1.getText());
                stmt.executeQuery();
                TabloDoldur();
                System.out.println("Veri silindi.");
        } catch (SQLException ex) {
            System.out.println("Veri Silinmedi");
        }
    }//GEN-LAST:event_btnsilspActionPerformed

    private void btnduzenlespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnduzenlespActionPerformed
        String query = "{ call rupdateSP(?,?,?,?,?,?,?) }";       
        try (Connection conn = MySQLJDBCUtil.ConnectDB();
            CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1,jTextField1.getText());
            stmt.setString(2, tbradi.getText());
            stmt.setString(3, tbrsoyadi .getText());
            stmt.setString(4, tbrtarih .getText());
            stmt.setString(5, tbrgtarih .getText());
            stmt.setString(6, tbrctarih .getText());
            stmt.setString(7, tbrodano.getText());
            stmt.execute();
            TabloDoldur();
            System.out.println("Veri Güncellendi");
        } 
        catch (SQLException ex) {
            System.out.println("Veri Güncellenemedi");
        }                           
    }//GEN-LAST:event_btnduzenlespActionPerformed

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
            java.util.logging.Logger.getLogger(rezervasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rezervasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rezervasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rezervasyon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rezervasyon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aranan;
    private javax.swing.JButton btnarasp;
    private javax.swing.JButton btncikis;
    private javax.swing.JButton btnduzenle;
    private javax.swing.JButton btnduzenlesp;
    private javax.swing.JButton btneklesp;
    private javax.swing.JButton btngeri;
    private javax.swing.JButton btnilk;
    private javax.swing.JButton btnkaydet;
    private javax.swing.JButton btnlistelesp;
    private javax.swing.JButton btnonceki;
    private javax.swing.JButton btnsil;
    private javax.swing.JButton btnsilsp;
    private javax.swing.JButton btnson;
    private javax.swing.JButton btnsonraki;
    private javax.swing.JButton btnyenikayit;
    private javax.swing.JFormattedTextField jFormattedTextField4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField tbradi;
    private javax.swing.JFormattedTextField tbrctarih;
    private javax.swing.JFormattedTextField tbrgtarih;
    private javax.swing.JTextField tbrodano;
    private javax.swing.JTextField tbrsoyadi;
    private javax.swing.JFormattedTextField tbrtarih;
    // End of variables declaration//GEN-END:variables

}
