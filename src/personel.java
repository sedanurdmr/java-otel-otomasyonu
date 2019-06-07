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
public class personel extends javax.swing.JFrame {

    /**
     * Creates new form personel
     */
    public personel() {
        initComponents();
        TabloDoldur();
        jTextField1.setVisible(false);
        Statement st;
        try{
            st=baglantiAc();
            res=st.executeQuery("SELECT * FROM personel");    
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
            ResultSet res = st.executeQuery("SELECT * FROM personel");
            Tablo model = new Tablo(res);
            jTable2.setModel(model); 
            baglantiKapat();
        } 
        catch (Exception e) 
        {
            JOptionPane.showConfirmDialog(null, "Bağlantı Başarısız", "MySQL Bağlantısı", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void KayitEkle(String ptc,String padi,String psoyadi,String pdtarihi,String ptel,String padres,String maas,
            String msaati,String igirist) {
        try {
            Statement st = baglantiAc();
            String sql= "INSERT INTO otel.personel(ptc,padi,psoyadi,pdtarihi,ptel,padres,maas,msaati,igirist) VALUES (" +
            "'" + ptc + "', " +
            "'" + padi + "', " +
            "'" + psoyadi+"', "+
            "'" + pdtarihi+"', "+
            "'" + ptel+"', "+       
            "'" + padres+"', "+ 
            "'" + maas+"', "+ 
            "'" + msaati+"', "+        
            "" + igirist + ")";
            System.out.println(sql);
            st.executeUpdate(sql); 
            baglantiKapat(); 
            TabloDoldur();       
        }
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Eklenemedi", "Personel Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
     public void KayitSil(String ID) {
        try {
            Statement st = baglantiAc();
            st.executeUpdate("Delete FROM personel where pid=" + ID);
            baglantiKapat();
            TabloDoldur();  
        } 
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Silinemedi", "Personel Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }
     
     public void KayitGuncelle(String pid,String ptc,String padi,String psoyadi,String pdtarihi,String ptel,String padres,
             String maas,String msaati,String igirist) {
        try {
            Statement st = baglantiAc();
            String sql = "UPDATE otel.personel SET " +
            "ptc= '" + ptc +
            "', padi='" + padi +
            "', psoyadi='" + psoyadi +
            "', pdtarihi='" + pdtarihi +
            "', ptel='" + ptel +
            "', padres='" + padres +
            "', maas='" + maas +
            "', msaati='" + msaati +
            "', igirist='" +igirist +
            "' WHERE pid=" + pid;
            st.executeUpdate(sql);
            baglantiKapat(); 

        } 
        catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Güncellenemedi", "Personel Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }
    
     
      public static void getSkills(int candidateId) {
        String query = "{ call pselectSP() }";
        ResultSet rs;        
        try (Connection conn = MySQLJDBCUtil.ConnectDB();
                        CallableStatement stmt = conn.prepareCall(query)) {
            
            //stmt.setInt(1, candidateId); 
            rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println(String.format(rs.getString("ptc") + " "+ rs.getString("padi")+rs.getString("psoyadi")+
                        rs.getString("pdtarihi")+rs.getString("ptel")+rs.getString("padres")+rs.getString("maas")+
                        rs.getString("msaati")+rs.getString("igirist")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      public void yaz(){
        try {
            tbptc.setText(res.getString("ptc"));
            tbpadi.setText(res.getString("padi"));
            tbpsoyadi.setText(res.getString("psoyadi"));
            tbpdtarihi.setText(res.getString("pdtarihi"));
            tbptel.setText(res.getString("ptel"));
            tbpadres.setText(res.getString("padres"));
            tbpmaas.setText(res.getString("maas"));
            tbpmsaati.setText(res.getString("msaati"));
            tbigirist.setText(res.getString("igirist"));
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnkaydetsp = new javax.swing.JButton();
        btnlistelesp = new javax.swing.JButton();
        btnarasp = new javax.swing.JButton();
        aranan = new javax.swing.JTextField();
        btndüzenlesp = new javax.swing.JButton();
        btnsilsp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tbptc = new javax.swing.JTextField();
        tbpadi = new javax.swing.JTextField();
        tbpsoyadi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbpadres = new javax.swing.JTextArea();
        tbpmaas = new javax.swing.JTextField();
        tbpmsaati = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnponceki = new javax.swing.JButton();
        btnpyenikayit = new javax.swing.JButton();
        btnpkaydet = new javax.swing.JButton();
        btnpduzenle = new javax.swing.JButton();
        btnpsil = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnpsonraki = new javax.swing.JButton();
        btnpilk = new javax.swing.JButton();
        btnpson = new javax.swing.JButton();
        tbptel = new javax.swing.JFormattedTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        tbpdtarihi = new javax.swing.JFormattedTextField();
        tbigirist = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        btngeri = new javax.swing.JButton();
        btncikis = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OTEL OTOMASYONU");

        jPanel1.setLayout(null);

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
        btnarasp.setText("ARAMA YAP");
        btnarasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaraspActionPerformed(evt);
            }
        });

        btndüzenlesp.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btndüzenlesp.setText("DÜZENLE");
        btndüzenlesp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndüzenlespActionPerformed(evt);
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
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btndüzenlesp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                    .addComponent(btnkaydetsp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnarasp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsilsp, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlistelesp, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aranan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnkaydetsp)
                    .addComponent(btnlistelesp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndüzenlesp)
                    .addComponent(btnsilsp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnarasp)
                    .addComponent(aranan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(260, 380, 440, 160);

        jLabel1.setBackground(new java.awt.Color(233, 217, 161));
        jLabel1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel1.setText("T.C.:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 50, 15);

        jLabel2.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel2.setText("Adı:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 60, 40, 15);

        jLabel3.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel3.setText("Soyadı:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 100, 50, 15);

        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel4.setText("Doğum Tarihi:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 140, 90, 15);

        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel5.setText("Adres:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 170, 50, 15);

        jLabel6.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel6.setText("Telefon:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 250, 50, 15);

        jLabel7.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel7.setText("Maaş:");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 290, 50, 15);

        jLabel8.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel8.setText("Mesai Saati:");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 330, 70, 15);

        jLabel9.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        jLabel9.setText("İşe Giriş Tarihi:");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 370, 90, 15);
        jPanel1.add(tbptc);
        tbptc.setBounds(100, 20, 123, 30);

        tbpadi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbpadiActionPerformed(evt);
            }
        });
        jPanel1.add(tbpadi);
        tbpadi.setBounds(100, 55, 123, 30);
        jPanel1.add(tbpsoyadi);
        tbpsoyadi.setBounds(100, 90, 123, 30);

        tbpadres.setColumns(20);
        tbpadres.setRows(5);
        jScrollPane1.setViewportView(tbpadres);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(100, 170, 120, 66);
        jPanel1.add(tbpmaas);
        tbpmaas.setBounds(100, 280, 123, 30);
        jPanel1.add(tbpmsaati);
        tbpmsaati.setBounds(100, 320, 123, 30);

        jPanel3.setBackground(new java.awt.Color(234, 191, 147));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("İŞLEMLER"));

        btnponceki.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnponceki.setText("ÖNCEKİ");
        btnponceki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponcekiActionPerformed(evt);
            }
        });

        btnpyenikayit.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnpyenikayit.setText("YENİ KAYIT");
        btnpyenikayit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpyenikayitActionPerformed(evt);
            }
        });

        btnpkaydet.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnpkaydet.setText("KAYDET");
        btnpkaydet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpkaydetActionPerformed(evt);
            }
        });

        btnpduzenle.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnpduzenle.setText("DÜZENLE");
        btnpduzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpduzenleActionPerformed(evt);
            }
        });

        btnpsil.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnpsil.setText("SİL");
        btnpsil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpsilActionPerformed(evt);
            }
        });

        btnpsonraki.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnpsonraki.setText("SONRAKİ");
        btnpsonraki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpsonrakiActionPerformed(evt);
            }
        });

        btnpilk.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnpilk.setText("İLK");
        btnpilk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpilkActionPerformed(evt);
            }
        });

        btnpson.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 11)); // NOI18N
        btnpson.setText("SON");
        btnpson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpsonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 57, Short.MAX_VALUE))
                    .addComponent(btnpilk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnpyenikayit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnpkaydet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnpsil, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnpduzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnponceki, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnpsonraki, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnpson, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnponceki)
                    .addComponent(btnpsonraki)
                    .addComponent(btnpilk)
                    .addComponent(btnpson))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnpyenikayit)
                    .addComponent(btnpduzenle))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnpsil)
                            .addComponent(btnpkaydet)))))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(260, 220, 450, 140);

        try {
            tbptel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("0(###)-### - ## - ##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(tbptel);
        tbptel.setBounds(100, 240, 123, 30);

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
        jScrollPane3.setBounds(258, 18, 452, 160);

        try {
            tbpdtarihi.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(tbpdtarihi);
        tbpdtarihi.setBounds(100, 130, 123, 30);

        try {
            tbigirist.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("## / ## / ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel1.add(tbigirist);
        tbigirist.setBounds(100, 360, 123, 30);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/depositphotos_64518047-stock-photo-beautiful-flowers-backgrounds.jpg"))); // NOI18N
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 0, 730, 600);

        jTabbedPane1.addTab("PERSONEL KAYIT", jPanel1);

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnpilkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpilkActionPerformed
         try {
            Boolean result=res.first();
            System.out.println("Sonuc:"+result);
            if (result==true)            
               yaz();
            else
               JOptionPane.showConfirmDialog(null, "İlk Kayıttasınız", "Personel Tablosu", JOptionPane.PLAIN_MESSAGE); 
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Personel Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnpilkActionPerformed

    private void tbpadiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbpadiActionPerformed

    }//GEN-LAST:event_tbpadiActionPerformed

    private void btngeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngeriActionPerformed
        personel ana_ekran = new personel();
        ana_ekran.setVisible(false);
        setVisible(false);
        gecis frame = new gecis();
        frame.setVisible(true);
    }//GEN-LAST:event_btngeriActionPerformed

    private void btncikisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncikisActionPerformed
        dispose();
    }//GEN-LAST:event_btncikisActionPerformed

    private void btnpkaydetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpkaydetActionPerformed
        String ptc =tbptc.getText();
        String padi =tbpadi.getText();
        String psoyadi = tbpsoyadi.getText();
        String pdtarihi = tbpdtarihi.getText();
        String ptel=tbptel.getText();
        String padres=tbpadres.getText();
        String maas=tbpmaas.getText();
        String msaati=tbpmsaati.getText();
        String igirist = tbigirist.getText();
        KayitEkle(ptc,padi,psoyadi,pdtarihi,ptel,padres,maas,msaati,igirist);   
    }//GEN-LAST:event_btnpkaydetActionPerformed

    private void btnpsilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpsilActionPerformed
        String ID = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
        KayitSil(ID);
    }//GEN-LAST:event_btnpsilActionPerformed

    private void btnpduzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpduzenleActionPerformed
        String pid = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
        String ptc =tbptc.getText();
        String padi =tbpadi.getText();
        String psoyadi = tbpsoyadi.getText();
        String pdtarihi = tbpdtarihi.getText();
        String ptel=tbptel.getText();
        String padres=tbpadres.getText();
        String maas=tbpmaas.getText();
        String msaati=tbpmsaati.getText();
        String igirist = tbigirist.getText();
        KayitGuncelle(pid,ptc,padi,psoyadi,pdtarihi,ptel,padres,maas,msaati,igirist);
    }//GEN-LAST:event_btnpduzenleActionPerformed

    private void jTable2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MousePressed
        jTextField1.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString());
        tbptc.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString());
        tbpadi.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString());
        tbpsoyadi.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString());
        tbpdtarihi.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 4).toString());
        tbptel.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 5).toString());
        tbpadres.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 6).toString());
        tbpmaas.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 7).toString());
        tbpmsaati.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 8).toString());
        tbigirist.setText(jTable2.getValueAt(jTable2.getSelectedRow(), 9).toString());     
    }//GEN-LAST:event_jTable2MousePressed

    private void btnponcekiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponcekiActionPerformed
         try {
            Boolean result=res.previous();
            if (result==true)            
                yaz();
            else
                JOptionPane.showConfirmDialog(null, "İlk Kayıttasınız", "Personel Tablosu", JOptionPane.PLAIN_MESSAGE);                
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Personel Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnponcekiActionPerformed

    private void btnpsonrakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpsonrakiActionPerformed
        try {
            Boolean result=res.next();
            if (result==true)            
                yaz();
            else
                JOptionPane.showConfirmDialog(null, "Son Kayıttasınız", "Personel Tablosu", JOptionPane.PLAIN_MESSAGE);                
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Personel Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnpsonrakiActionPerformed

    private void btnpsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpsonActionPerformed
          try {
            res.last();
            yaz();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Kayıt Mevcut Değil", "Personel Tablosu", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_btnpsonActionPerformed

    private void btnpyenikayitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpyenikayitActionPerformed
            jTextField1.setText("");
            tbptc.setText("");
            tbpadi.setText("");
            tbpsoyadi.setText("");
            tbpdtarihi.setText("");
            tbptel.setText("");
            tbpadres.setText("");
            tbpmaas.setText("");
            tbpmsaati.setText("");
            tbigirist.setText("");
    }//GEN-LAST:event_btnpyenikayitActionPerformed

    private void btnkaydetspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkaydetspActionPerformed
        String query = "{ call pinsertSP(?,?,?,?,?,?,?,?,?) }";
        try (Connection conn = MySQLJDBCUtil.ConnectDB();
            CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, tbptc.getText());
            stmt.setString(2, tbpadi .getText());
            stmt.setString(3, tbpsoyadi.getText());
            stmt.setString(4, tbpdtarihi.getText());
            stmt.setString(5, tbptel.getText());
            stmt.setString(6, tbpadres.getText());
            stmt.setString(7, tbpmaas.getText());
            stmt.setString(8, tbpmsaati.getText());
            stmt.setString(9, tbigirist.getText());
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
        String query = "{ call psearchSP(?) }";
        ResultSet rs;
        try (Connection conn = MySQLJDBCUtil.ConnectDB();
            CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1, aranan.getText());
            rs = stmt.executeQuery();
            if (rs.next())
                System.out.println(String.format(rs.getString("ptc") + " "+ rs.getString("padi")+rs.getString("psoyadi")+
                        rs.getString("pdtarihi")+rs.getString("ptel")+rs.getString("padres")+rs.getString("maas")+
                        rs.getString("msaati")+rs.getString("igirist")));
            else
                System.out.println("Veri Arandi Ama Bulunamadi");
        } catch (SQLException ex) {
            System.out.println("Veri Aranamadi");
        }
    }//GEN-LAST:event_btnaraspActionPerformed

    private void btndüzenlespActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndüzenlespActionPerformed
        String query = "{ call pupdateSP(?,?,?,?,?,?,?,?,?,?) }";
        try (Connection conn = MySQLJDBCUtil.ConnectDB();
            CallableStatement stmt = conn.prepareCall(query)) {
            stmt.setString(1,jTextField1.getText());
            stmt.setString(2, tbptc.getText());
            stmt.setString(3, tbpadi .getText());
            stmt.setString(4, tbpsoyadi.getText());
            stmt.setString(5, tbpdtarihi.getText());
            stmt.setString(6, tbptel.getText());
            stmt.setString(7, tbpadres.getText());
            stmt.setString(8, tbpmaas.getText());
            stmt.setString(9, tbpmsaati.getText());
            stmt.setString(10, tbigirist.getText());
            stmt.execute();
            TabloDoldur();
            System.out.println("Veri Güncellendi");
        } 
        catch (SQLException ex) {
            System.out.println("Veri Güncellenemedi");
        }                           
    }//GEN-LAST:event_btndüzenlespActionPerformed

    private void btnsilspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsilspActionPerformed
        String query = "{ call pdeleteSP(?) }";
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
            java.util.logging.Logger.getLogger(personel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(personel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(personel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(personel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new personel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aranan;
    private javax.swing.JButton btnarasp;
    private javax.swing.JButton btncikis;
    private javax.swing.JButton btndüzenlesp;
    private javax.swing.JButton btngeri;
    private javax.swing.JButton btnkaydetsp;
    private javax.swing.JButton btnlistelesp;
    private javax.swing.JButton btnpduzenle;
    private javax.swing.JButton btnpilk;
    private javax.swing.JButton btnpkaydet;
    private javax.swing.JButton btnponceki;
    private javax.swing.JButton btnpsil;
    private javax.swing.JButton btnpson;
    private javax.swing.JButton btnpsonraki;
    private javax.swing.JButton btnpyenikayit;
    private javax.swing.JButton btnsilsp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JFormattedTextField tbigirist;
    private javax.swing.JTextField tbpadi;
    private javax.swing.JTextArea tbpadres;
    private javax.swing.JFormattedTextField tbpdtarihi;
    private javax.swing.JTextField tbpmaas;
    private javax.swing.JTextField tbpmsaati;
    private javax.swing.JTextField tbpsoyadi;
    private javax.swing.JTextField tbptc;
    private javax.swing.JFormattedTextField tbptel;
    // End of variables declaration//GEN-END:variables
}
