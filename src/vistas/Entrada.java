/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import utils.Slide;

/**
 *
 * @author Agustin Colongne
 */
public class Entrada extends javax.swing.JFrame {
    FondoPanel panelFondo = new FondoPanel();
    Slide slide;
    int medio;
    private static  String emailDesde = "agusfurini@gmail.com"; 
    private static  String claveEmali = "zgob fksk aalp vdre";
    private String emailHasta;
    private String asunto;
    private String mensaje;
    
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;
    

    /**
     * Creates new form Entrada public Entrada() { this.setContentPane(fondo);
     *
     */
    public Entrada() {
        this.setContentPane(panelFondo);
        initComponents();
        this.setLocationRelativeTo(null);
        medio = panelPrincipal.getX();
        slide = new Slide();
        mProperties = new Properties();
        
    }
    
    private void registrarUsuario(){
        emailHasta = "aguscolongne@gmail.com";
        asunto = "Registro de Usuario";
        mensaje = "Ingrese en la app el codigo";
        
        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailDesde);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");
        
        mSession = Session.getDefaultInstance(mProperties);
        
        mCorreo = new MimeMessage(mSession);
        try {
            mCorreo.setFrom(new InternetAddress(emailDesde));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailHasta));
            mCorreo.setSubject(asunto);
            mCorreo.setText(mensaje);
            
        } catch (AddressException ex) {
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarCorreo(){
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailDesde, claveEmali);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Entrada.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        panelRegistrar = new javax.swing.JPanel();
        jbRegistrarse = new javax.swing.JLabel();
        panelEntrar = new javax.swing.JPanel();
        jbEntrar = new javax.swing.JLabel();
        panelEntrarLogear = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelCancelarLogear = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jtApellido = new javax.swing.JTextField();
        jtMail = new javax.swing.JTextField();
        jtNombreUsuario = new javax.swing.JTextField();
        jtContrasenia = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        panelRegistrarRegistro = new javax.swing.JPanel();
        labelRegistrarseRegistro = new javax.swing.JLabel();
        panelCancelarRegstro = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1500, 750));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPrincipal.setBackground(new java.awt.Color(255, 51, 102,0));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logo viaja sin fondo.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Usuario:");

        jtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña:");

        panelRegistrar.setBackground(new java.awt.Color(60, 147, 214));
        panelRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jbRegistrarse.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 26)); // NOI18N
        jbRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        jbRegistrarse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbRegistrarse.setText("Registrarse");
        jbRegistrarse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbRegistrarseMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRegistrarLayout = new javax.swing.GroupLayout(panelRegistrar);
        panelRegistrar.setLayout(panelRegistrarLayout);
        panelRegistrarLayout.setHorizontalGroup(
            panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelRegistrarLayout.setVerticalGroup(
            panelRegistrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRegistrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelEntrar.setBackground(new java.awt.Color(60, 147, 214));
        panelEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jbEntrar.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 26)); // NOI18N
        jbEntrar.setForeground(new java.awt.Color(255, 255, 255));
        jbEntrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbEntrar.setText("Entrar");
        jbEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbEntrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelEntrarLayout = new javax.swing.GroupLayout(panelEntrar);
        panelEntrar.setLayout(panelEntrarLayout);
        panelEntrarLayout.setHorizontalGroup(
            panelEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelEntrarLayout.setVerticalGroup(
            panelEntrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEntrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelEntrarLogear.setBackground(new java.awt.Color(60, 147, 214));
        panelEntrarLogear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel4.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Entrar");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelEntrarLogearLayout = new javax.swing.GroupLayout(panelEntrarLogear);
        panelEntrarLogear.setLayout(panelEntrarLogearLayout);
        panelEntrarLogearLayout.setHorizontalGroup(
            panelEntrarLogearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        panelEntrarLogearLayout.setVerticalGroup(
            panelEntrarLogearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelCancelarLogear.setBackground(new java.awt.Color(60, 147, 214));
        panelCancelarLogear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel3.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Cancelar");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCancelarLogearLayout = new javax.swing.GroupLayout(panelCancelarLogear);
        panelCancelarLogear.setLayout(panelCancelarLogearLayout);
        panelCancelarLogearLayout.setHorizontalGroup(
            panelCancelarLogearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCancelarLogearLayout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelCancelarLogearLayout.setVerticalGroup(
            panelCancelarLogearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCancelarLogearLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jtNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtNombreUsuarioActionPerformed(evt);
            }
        });

        panelRegistrarRegistro.setBackground(new java.awt.Color(60, 147, 214));
        panelRegistrarRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        labelRegistrarseRegistro.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        labelRegistrarseRegistro.setForeground(new java.awt.Color(255, 255, 255));
        labelRegistrarseRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRegistrarseRegistro.setText("Registrarse");
        labelRegistrarseRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelRegistrarseRegistroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelRegistrarRegistroLayout = new javax.swing.GroupLayout(panelRegistrarRegistro);
        panelRegistrarRegistro.setLayout(panelRegistrarRegistroLayout);
        panelRegistrarRegistroLayout.setHorizontalGroup(
            panelRegistrarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRegistrarseRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        panelRegistrarRegistroLayout.setVerticalGroup(
            panelRegistrarRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelRegistrarseRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        panelCancelarRegstro.setBackground(new java.awt.Color(60, 147, 214));
        panelCancelarRegstro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel11.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Cancelar");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCancelarRegstroLayout = new javax.swing.GroupLayout(panelCancelarRegstro);
        panelCancelarRegstro.setLayout(panelCancelarRegstroLayout);
        panelCancelarRegstroLayout.setHorizontalGroup(
            panelCancelarRegstroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
        );
        panelCancelarRegstroLayout.setVerticalGroup(
            panelCancelarRegstroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Apellido:");

        jLabel6.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mail:");

        jLabel7.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Nombre de Usuario:");

        jLabel8.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Contraseña:");

        jLabel9.setFont(new java.awt.Font("Microsoft Yi Baiti", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Nombre:");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtUsuario)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addComponent(panelEntrarLogear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)
                        .addComponent(panelCancelarLogear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(563, 563, 563)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                        .addComponent(panelEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100)
                        .addComponent(panelRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(754, 754, 754)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelPrincipalLayout.createSequentialGroup()
                            .addComponent(panelRegistrarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelCancelarRegstro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(47, 47, 47))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelEntrarLogear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelCancelarLogear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPrincipalLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(panelEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(panelRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPrincipalLayout.createSequentialGroup()
                                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(panelRegistrarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(panelCancelarRegstro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(75, 75, 75))
        );

        getContentPane().add(panelPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1110, 0, 2620, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbEntrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEntrarMouseClicked
        // TODO add your handling code here:
        if(panelPrincipal.getX() == medio){
             moverDerecha();
        }
    
    }//GEN-LAST:event_jbEntrarMouseClicked

    private void jtNombreUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtNombreUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtNombreUsuarioActionPerformed

    private void jbRegistrarseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbRegistrarseMouseClicked
        // TODO add your handling code here:
        moverIzquierda();
    }//GEN-LAST:event_jbRegistrarseMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        // TODO add your handling code here:

        centrarDesdeDerecha();

    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:

        centrarDesdeIzquierda();


    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:  
        String usuarioLogeado = jtUsuario.getText();
        Menu mv = new Menu();
        mv.setVisible(true);
        mv.recuperarUsuario(usuarioLogeado);
        System.out.println(usuarioLogeado);
        cargarJFrame(mv);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void labelRegistrarseRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelRegistrarseRegistroMouseClicked
        // TODO add your handling code here:
        String nombre = jtNombre.getText();
        String apellido = jtApellido.getText();
        String mailUsuario = jtMail.getText();
        String nombreUsuario = jtUsuario.getText();
        String contrasenia = jtContrasenia.getText();
        
        
        
        
        registrarUsuario();
        enviarCorreo(); 
    }//GEN-LAST:event_labelRegistrarseRegistroMouseClicked

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
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Entrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Entrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jbEntrar;
    private javax.swing.JLabel jbRegistrarse;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtContrasenia;
    private javax.swing.JTextField jtMail;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtNombreUsuario;
    private javax.swing.JTextField jtUsuario;
    private javax.swing.JLabel labelRegistrarseRegistro;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelCancelarLogear;
    private javax.swing.JPanel panelCancelarRegstro;
    private javax.swing.JPanel panelEntrar;
    private javax.swing.JPanel panelEntrarLogear;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRegistrar;
    private javax.swing.JPanel panelRegistrarRegistro;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {

            imagen = new ImageIcon(getClass().getResource("/imagenes/fondoPlaya6.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);

        }

    }

    public void moverDerecha() {
        slide.jPanelXDerecha(panelPrincipal.getX(), -10, 10, 10, panelPrincipal);
    }

    public void moverIzquierda() {
        slide.jPanelXIzquierda(panelPrincipal.getX(), -1100, 10, 10, panelPrincipal);
    }

    public void centrarDesdeIzquierda() {

        slide.jPanelXIzquierda(panelPrincipal.getX(), medio, 10, 10, panelPrincipal);
    }

    public void centrarDesdeDerecha() {
        slide.jPanelXDerecha(panelPrincipal.getX(), medio, 10, 10, panelPrincipal);

    }
    private void cargarJFrame(JFrame panel) {   
        this.dispose();
        
        panel.setVisible(true);
    }
}
