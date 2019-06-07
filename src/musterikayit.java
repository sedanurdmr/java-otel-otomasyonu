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
public class musterikayit extends javax.swing.JFrame {
     
    /**
     * Creates new form musterikayit
     */
    public musterikayit() {
        initComponents();
        TabloDoldur();
        jTextField1.setVisible(false);
        Statement st;
        try{
            st=baglantiAc();
            res=st.executeQuery("SELECT * FROM musterikayit");    
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
            ResultSet res = st.executeQuery("SELECT * FROM  musterikayit");
            Tablo model = new Tablo(res);
            jTable2.setModel(model); 
            baglantiKapat();
        } 
        catch (Exception e) 
        {
            JOptionPane.showConfirmDialog(null, "Bağlantı Başarısız", "MySQL Bağlantısı", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void KayitEkle(String adi,String soyadi,String telefon,String adres,String gtarihi,String ctarihi,String kacgün,
            String fiyat,String odano) {
        try {
            Statement st = baglantiAc();
            String sql= "INSERT INTO otel.musterikayit(adi,soyadi,tel,adres,gtarihi,ctarihi,kacgün,fiyat,odano) VALUES (" +
            "'" + adi + "', " +
            "'" + soyadi + "', " +
            "'" + telefon+"', "+
            "'" + adres+"', "+
            "'" + gtarihi+"', "+       
            "'" + ctarihi+"', "+ 
            "'" + kacgün+"', "+ 
            "'" + fiyat+"', "+        
            "" + odano + ")";
            System.out.println(sql);
            st.executeUpdate(sql); 
            baglantiKapat(); 
            TabloDoldur();
            
        }
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Eklenemedi", "Müşteri Kayıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void KayitSil(String ID) {
        try {
            Statement st = baglantiAc();
            st.executeUpdate("Delete FROM  musterikayit where id=" + ID);
            baglantiKapat();
            TabloDoldur();  
        } 
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Silinemedi", "Müşteri Kayıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void KayitGuncelle(String id,String adi,String soyadi,String tel,String adres,String gtarihi,String ctarihi,
            String kacgün,String fiyat,String odano) {
        try {
            Statement st = baglantiAc();
            String sql = "UPDATE otel.musterikayit SET " +
            "adi= '" + adi +
            "', soyadi='" + soyadi +
            "', tel='" + tel +
            "', adres='" + adres +
            "', gtarihi='" + gtarihi +
            "', ctarihi='" + ctarihi +
            "', kacgün='" + kacgün +
            "', fiyat='" + fiyat +
            "', odano='" +odano +
            "' WHERE id=" + id;
            st.executeUpdate(sql);
            baglantiKapat(); 
            TabloDoldur();
        } 
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Güncellenemedi", "Müşteri Kayıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void yaz(){
        try {
            tbadi.setText(res.getString("adi"));
            tbsoyadi.setText(res.getString("soyadi"));
            tbtel.setText(res.getString("tel"));
            tbadres.setText(res.getString("adres"));
            tbgtarihi.setText(res.getString("gtarihi"));
            tbctarihi.setText(res.getString("ctarihi"));           
            tbkacgun.setText(res.getString("kacgün"));
            tbfiyat.setText(res.getString("fiyat"));
            tbodano.setText(res.getString("odano"));
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, "Bağlantı Başarısız", "MySQL Bağlantısı", JOptionPane.PLAIN_MESSAGE);
        }           
    }
    
     public static void getSkills(int candidateId) {
        String query = "{ call mselectSP() }";
        ResultSet rs;
                try (Connection conn = MySQLJDBCUtil.ConnectDB();
                    CallableStatement stmt = conn.prepareCall(query)) {
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(String.format(rs.getString("adi") + " "+ rs.getString("soyadi")+rs.getString("tel")+
                        rs.getString("adres")+rs.getString("gtarihi")+rs.getString("ctarihi")+rs.getString("kacgün")+
                        rs.getString("fiyat")+rs.getString("odano")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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

        jFrame1 = new javax.swing.JFrame();
        jMenu1 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tbadi = new javax.swing.JTextField();
        tbsoyadi = new javax.swing.JTextField();
        tbodano = new javax.swing.JTextField();
        tbfiyat = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnilk = new javax.swing.JButton();
        btnonceki = new javax.swing.JButton();
        btnsonraki = new javax.swing.JButton();
        btnson = new javax.swing.JButton();
        btnyenikayit = new javax.swing.JButton();
        btnkaydet = new javax.swing.JButton();
        btnduzenle = new javax.swing.JButton();
        btnsil = new javax.swing.JButton();
        tbtel = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        tbkacgun = new javax.swing.JTextField();
        jSlider1 = new javax.swing.JSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbadres = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnkaydetsp = new javax.swing.JButton();
        btnlistelesp = new javax.swing.JButton();
        btnarasp = new javax.swing.JButton();
        bendüzenlesp = new javax.swing.JButton();
        btnsilsp = new javax.swing.JButton();
        aranan = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        tbgtarihi = new javax.swing.JFormattedTextField();
        tbctarihi = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btngeri = new javax.swing.JButton();
        btncikis = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenuItem1.setText("GERİ");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("ÇIKIŞ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OTEL OTOMASYONU");
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        jPanel5.setLayout(null);

        jTabbedPane1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setToolTipText("0");
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel1.setText("Adı:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(12, 16, 60, 15);

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel2.setText("Soyadı:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(12, 42, 60, 15);

        jLabel3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel3.setText("Telefon:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(12, 74, 60, 15);

        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel4.setText("Adres:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(12, 103, 60, 15);

        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel5.setText("Geliş Tarihi:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 165, 80, 30);

        jLabel6.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel6.setText("Çıkış Tarihi:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 215, 70, 20);

        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel7.setText("Kaç Gün:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(20, 245, 60, 30);

        jLabel8.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel8.setText("Oda No:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 335, 70, 20);

        jLabel9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel9.setText("Fiyat:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(20, 285, 50, 30);

        tbadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbadiActionPerformed(evt);
            }
        });
        jPanel1.add(tbadi);
        tbadi.setBounds(80, 10, 110, 30);
        jPanel1.add(tbsoyadi);
        tbsoyadi.setBounds(80, 40, 110, 30);
        jPanel1.add(tbodano);
        tbodano.setBounds(80, 330, 110, 30);
        jPanel1.add(tbfiyat);
        tbfiyat.setBounds(80, 290, 110, 30);

        jPanel3.setBackground(new java.awt.Color(234, 191, 147));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("İŞLEMLER"));
        jPanel3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnonceki, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsonraki, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(btnson, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnkaydet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnduzenle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnsil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnilk, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnyenikayit, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnilk)
                    .addComponent(btnyenikayit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnonceki)
                    .addComponent(btnkaydet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsonraki)
                    .addComponent(btnduzenle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnson)
                    .addComponent(btnsil))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(210, 200, 240, 190);

        try {
            tbtel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0(###)-###-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(tbtel);
        tbtel.setBounds(80, 70, 110, 30);
        jPanel1.add(jLabel12);
        jLabel12.setBounds(417, 65, 0, 0);
        jPanel1.add(tbkacgun);
        tbkacgun.setBounds(80, 250, 40, 30);

        jSlider1.setPaintLabels(true);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jPanel1.add(jSlider1);
        jSlider1.setBounds(130, 250, 57, 26);

        jScrollPane1.setViewportView(tbadres);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(80, 100, 110, 60);

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
        jScrollPane3.setViewportView(jTable2);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(200, 10, 460, 170);

        jPanel2.setBackground(new java.awt.Color(234, 191, 147));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("SAKLI YORDAMLAR"));

        btnkaydetsp.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnkaydetsp.setText("KAYDET");
        btnkaydetsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkaydetspActionPerformed(evt);
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
        btnarasp.setText(" ARAMA YAP");
        btnarasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaraspActionPerformed(evt);
            }
        });

        bendüzenlesp.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        bendüzenlesp.setText("DÜZENLE");
        bendüzenlesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bendüzenlespActionPerformed(evt);
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnlistelesp, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(aranan, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addComponent(bendüzenlesp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnkaydetsp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                        .addComponent(btnsilsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnarasp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnlistelesp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnkaydetsp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bendüzenlesp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsilsp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnarasp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aranan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(470, 200, 170, 240);

        try {
            tbgtarihi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(tbgtarihi);
        tbgtarihi.setBounds(80, 170, 110, 30);

        try {
            tbctarihi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(tbctarihi);
        tbctarihi.setBounds(80, 210, 110, 30);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/depositphotos_64518047-stock-photo-beautiful-flowers-backgrounds.jpg"))); // NOI18N
        jPanel1.add(jLabel14);
        jLabel14.setBounds(0, 0, 670, 450);

        jTabbedPane1.addTab("MÜŞTERİ KAYIT", jPanel1);

        jPanel5.add(jTabbedPane1);
        jTabbedPane1.setBounds(0, 20, 670, 480);

        jToolBar1.setBackground(new java.awt.Color(234, 191, 147));
        jToolBar1.setRollover(true);

        btngeri.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
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

        btncikis.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
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

        jPanel5.add(jToolBar1);
        jToolBar1.setBounds(0, 0, 89, 23);
        jPanel5.add(jLabel13);
        jLabel13.setBounds(0, 0, 680, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btngeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngeriActionPerformed
        musterikayit ana_ekran = new musterikayit();
        ana_ekran.setVisible(false);
        setVisible(false);
        gecis frame = new gecis();
        frame.setVisible(true);       
    }//GEN-LAST:event_btngeriActionPerformed

    private void btncikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncikisActionPerformed
        dispose();
    }//GEN-LAST:event_btncikisActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if(evt.isPopupTrigger()){
            jPopupMenu1.show(this,evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_formMouseReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        musterikayit ana_ekran = new musterikayit();
        ana_ekran.setVisible(false);
        setVisible(false);
        gecis frame = new gecis();
        frame.setVisible(true);       
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void tbadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbadiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbadiActionPerformed

    private void btnilkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnilkActionPerformed

        try {
            Boolean result=res.first();
            System.out.println("Sonuc:"+result);
            if (result==true)
            yaz();
            else
            JOptionPane.showConfirmDialog(null, "İlk Kayıttasınız", "Müşteri Kayıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Müşteri Kayıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnilkActionPerformed

    private void btnoncekiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnoncekiActionPerformed

        try {
            Boolean result=res.previous();
            if (result==true)
            yaz();
            else
            JOptionPane.showConfirmDialog(null, "İlk Kayıttasınız", "Müşteri Kayıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Müşteri Kayıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnoncekiActionPerformed

    private void btnsonrakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsonrakiActionPerformed

        try {
            Boolean result=res.next();
            if (result==true)
            yaz();
            else
            JOptionPane.showConfirmDialog(null, "Son Kayıttasınız", "Müşteri Kayıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Müşteri Kayıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnsonrakiActionPerformed

    private void btnsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsonActionPerformed

        try {
            res.last();
            yaz();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Müşteri Kayıt Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnsonActionPerformed

    private void btnyenikayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnyenikayitActionPerformed
        jTextField1.setText("");
        tbadi.setText("");
        tbsoyadi.setText("");
        tbtel.setText("");
        tbadres.setText("");
        tbgtarihi.setText("");
        tbctarihi.setText("");
        tbkacgun.setText("");
        tbfiyat.setText("");
        tbodano.setText("");
    }//GEN-LAST:event_btnyenikayitActionPerformed

    private void btnkaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkaydetActionPerformed

        String adi =tbadi.getText();
        String soyadi =tbsoyadi.getText();
        String telefon = tbtel.getText();
        String adres=tbadres.getText();
        String gtarihi=tbgtarihi.getText();
        String ctarihi=tbctarihi.getText();
        String kacgün=tbkacgun.getText();
        String fiyat=tbfiyat.getText();
        String odano=tbodano.getText();
        KayitEkle(adi,soyadi,telefon,adres,gtarihi,ctarihi,kacgün,fiyat,odano);
    }//GEN-LAST:event_btnkaydetActionPerformed

    private void btnduzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnduzenleActionPerformed

        String id = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
        String adi =tbadi.getText();
        String soyadi =tbsoyadi.getText();
        String tel = tbtel.getText();
        String adres=tbadres.getText();
        String gtarihi=tbgtarihi.getText();
        String ctarihi=tbctarihi.getText();
        String kacgün=tbkacgun.getText();
        String fiyat=tbfiyat.getText();
        String odano=tbodano.getText();
        KayitGuncelle(id,adi,soyadi,tel,adres,gtarihi,ctarihi,kacgün,fiyat,odano);
    }//GEN-LAST:event_btnduzenleActionPerformed

    private void btnsilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsilActionPerformed
        String ID = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
        KayitSil(ID);
    }//GEN-LAST:event_btnsilActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        tbkacgun.setText(Integer.toString(jSlider1.getValue()));
    }//GEN-LAST:event_jSlider1StateChanged

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
        jTextField1.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
        tbadi.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
        tbsoyadi.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
        tbtel.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString());
        tbadres.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString());
        tbgtarihi.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString());
        tbctarihi.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString());
        tbkacgun.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 7).toString());
        tbfiyat.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 8).toString());
        tbodano.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 9).toString());
    }//GEN-LAST:event_jTable2MousePressed

    private void btnkaydetspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkaydetspActionPerformed
        String query = "{ call minsertSP(?,?,?,?,?,?,?,?,?) }";
        try (Connection conn = MySQLJDBCUtil.ConnectDB();
            CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, tbadi.getText());
            stmt.setString(2, tbsoyadi .getText());
            stmt.setString(3, tbtel.getText());
            stmt.setString(4, tbadres.getText());
            stmt.setString(5, tbgtarihi.getText());
            stmt.setString(6, tbctarihi.getText());
            stmt.setString(7, tbkacgun.getText());
            stmt.setString(8, tbfiyat.getText());
            stmt.setString(9, tbodano.getText());
            stmt.execute();
            TabloDoldur();
            System.out.println("Veri Eklendi");
        }
        catch (SQLException ex) {
            System.out.println("Veri Eklenemedi");
        }
    }//GEN-LAST:event_btnkaydetspActionPerformed

    private void btnlistelespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlistelespActionPerformed
        getSkills(1);
    }//GEN-LAST:event_btnlistelespActionPerformed

    private void btnaraspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaraspActionPerformed
        String query = "{ call msearchSP(?) }";
        ResultSet rs;
        try (Connection conn = MySQLJDBCUtil.ConnectDB();
        CallableStatement stmt = conn.prepareCall(query)) 
        {
            stmt.setString(1, aranan.getText());
            rs = stmt.executeQuery();
            if (rs.next())
                System.out.println(String.format(rs.getString("adi") + " "+ rs.getString("soyadi")+rs.getString("tel")+
                        rs.getString("adres")+rs.getString("gtarihi")+rs.getString("ctarihi")+rs.getString("kacgün")+
                        rs.getString("fiyat")+rs.getString("odano")));
            else
                System.out.println("Veri Arandi Ama Bulunamadi");
        } 
        catch (SQLException ex) {
            System.out.println("Veri Aranamadi");
        }
    }//GEN-LAST:event_btnaraspActionPerformed

    private void bendüzenlespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bendüzenlespActionPerformed
        String query = "{ call mupdateSP(?,?,?,?,?,?,?,?,?,?) }";
        try (Connection conn = MySQLJDBCUtil.ConnectDB();
            CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1,jTextField1.getText());
            stmt.setString(2, tbadi.getText());
            stmt.setString(3, tbsoyadi .getText());
            stmt.setString(4, tbtel.getText());
            stmt.setString(5, tbadres.getText());
            stmt.setString(6, tbgtarihi.getText());
            stmt.setString(7, tbctarihi.getText());
            stmt.setString(8, tbkacgun.getText());
            stmt.setString(9, tbfiyat.getText());
            stmt.setString(10, tbodano.getText());
            stmt.execute();
            TabloDoldur();
            System.out.println("Veri Güncellendi");
        }
        catch (SQLException ex) {
            System.out.println("Veri Güncellenemedi");
        }
    }//GEN-LAST:event_bendüzenlespActionPerformed

    private void btnsilspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsilspActionPerformed
        String query = "{ call mdeleteSP(?) }";
        try (Connection conn = MySQLJDBCUtil.ConnectDB();
        CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, jTextField1.getText());
            stmt.executeQuery();
            TabloDoldur();
            System.out.println("Veri silindi.");        
        } 
        catch (SQLException ex) {
            System.out.println("Veri Silinmedi");
        }
    }//GEN-LAST:event_btnsilspActionPerformed

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
            java.util.logging.Logger.getLogger(musterikayit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(musterikayit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(musterikayit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(musterikayit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new musterikayit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aranan;
    private javax.swing.JButton bendüzenlesp;
    private javax.swing.JButton btnarasp;
    private javax.swing.JButton btncikis;
    private javax.swing.JButton btnduzenle;
    private javax.swing.JButton btngeri;
    private javax.swing.JButton btnilk;
    private javax.swing.JButton btnkaydet;
    private javax.swing.JButton btnkaydetsp;
    private javax.swing.JButton btnlistelesp;
    private javax.swing.JButton btnonceki;
    private javax.swing.JButton btnsil;
    private javax.swing.JButton btnsilsp;
    private javax.swing.JButton btnson;
    private javax.swing.JButton btnsonraki;
    private javax.swing.JButton btnyenikayit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextField tbadi;
    private javax.swing.JTextPane tbadres;
    private javax.swing.JFormattedTextField tbctarihi;
    private javax.swing.JTextField tbfiyat;
    private javax.swing.JFormattedTextField tbgtarihi;
    private javax.swing.JTextField tbkacgun;
    private javax.swing.JTextField tbodano;
    private javax.swing.JTextField tbsoyadi;
    private javax.swing.JFormattedTextField tbtel;
    // End of variables declaration//GEN-END:variables

}
