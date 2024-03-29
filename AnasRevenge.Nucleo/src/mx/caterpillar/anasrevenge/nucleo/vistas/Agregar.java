/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.caterpillar.anasrevenge.nucleo.vistas;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.transaction.Transactional;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import mx.caterpillar.anasrevenge.nucleo.entidades.Alumno;
import mx.caterpillar.anasrevenge.nucleo.entidades.Docente;
import mx.caterpillar.anasrevenge.nucleo.hilos.Hilo;
import mx.caterpillar.anasrevenge.nucleo.implementacion.AlumnoImplementacion;
import mx.caterpillar.anasrevenge.nucleo.implementacion.DocenteImplementacion;
import mx.caterpillar.anasrevenge.nucleo.interfaces.IAlumno;
import mx.caterpillar.anasrevenge.nucleo.interfaces.IDocente;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author jesus
 */
public class Agregar extends javax.swing.JFrame {

    /**
     * Creates new form Agregar
     */
    String uid = "";
    File file = new File("");
    PanamaHitek_Arduino arduino = new PanamaHitek_Arduino();
    IDocente iDocente = new DocenteImplementacion();
    IAlumno iAlumno = new AlumnoImplementacion();
    Docente docente;
    Alumno alumno;
    int tipo = 0;

    public Agregar() throws ArduinoException, SerialPortException {
        initComponents();
        this.setLocationRelativeTo(null);
        arduino.arduinoRX("COM3", 9600, listener);
        this.lblFotografia.setVisible(false);
        this.btnSeleccionar.setVisible(false);
        this.lblArchivo.setVisible(false);

    }

    SerialPortEventListener listener = new SerialPortEventListener() {
        public void serialEvent(SerialPortEvent spe) {
            try {
                if (arduino.isMessageAvailable()) {
                    pnlFotografia.update(pnlFotografia.getGraphics());
                    uid = arduino.printMessage();
                    lblUID.setText(uid);
                    docente = iDocente.getByUID(uid);
                    if (docente == null) {
                        alumno = iAlumno.getByUID(uid);
                    } else {
                        llenarCampos(docente.getNombre(), docente.getApellidoPaterno(), docente.getApellidoMaterno(), docente.getMatricula(), 1);
                        btnRegistar.setText("Editar");
                    }
                    if (alumno != null) {
                        llenarCampos(alumno.getNombre(), alumno.getApellidoPaterno(), alumno.getApellidoMaterno(), alumno.getMatricula(), 0);
                        txtGrupo.setText(alumno.getGrupo());
                        btnRegistar.setText("Editar");
                    }
                    txtNombres.setEditable(true);
                    txtApePat.setEditable(true);
                    txtApeMat.setEditable(true);
                    txtGrupo.setEditable(true);
                    cbxTipo.setEnabled(true);
                    btnSeleccionar.setEnabled(true);
                    btnRegistar.setEnabled(true);
                    txtMatricula.setEditable(true);
                }

            } catch (SerialPortException ex) {
            } catch (ArduinoException ex) {
                Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        pnlFotografia = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblUID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtApePat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApeMat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbxTipo = new javax.swing.JComboBox<>();
        btnRegistar = new javax.swing.JButton();
        lblFotografia = new javax.swing.JLabel();
        btnSeleccionar = new javax.swing.JButton();
        lblArchivo = new javax.swing.JLabel();
        lblGrupo = new javax.swing.JLabel();
        txtGrupo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 500));

        jPanel2.setBackground(new java.awt.Color(75, 136, 162));

        btnSalir.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("X");
        btnSalir.setBorderPainted(false);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setFocusPainted(false);
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalirMouseExited(evt);
            }
        });
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Registro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlFotografia.setBackground(new java.awt.Color(255, 255, 255));
        pnlFotografia.setPreferredSize(new java.awt.Dimension(250, 250));

        javax.swing.GroupLayout pnlFotografiaLayout = new javax.swing.GroupLayout(pnlFotografia);
        pnlFotografia.setLayout(pnlFotografiaLayout);
        pnlFotografiaLayout.setHorizontalGroup(
            pnlFotografiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlFotografiaLayout.setVerticalGroup(
            pnlFotografiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel1.setText("UID:");

        lblUID.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        lblUID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel2.setText("Nombres:");

        txtNombres.setEditable(false);
        txtNombres.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel3.setText("Apellido paterno:");

        txtApePat.setEditable(false);
        txtApePat.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel4.setText("Apellido materno:");

        txtApeMat.setEditable(false);
        txtApeMat.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel5.setText("Tipo de registro:");

        cbxTipo.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N
        cbxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estudiante", "Profesor" }));
        cbxTipo.setEnabled(false);
        cbxTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxTipoItemStateChanged(evt);
            }
        });

        btnRegistar.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        btnRegistar.setText("Registrar");
        btnRegistar.setEnabled(false);
        btnRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarActionPerformed(evt);
            }
        });

        lblFotografia.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        lblFotografia.setText("Fotografia:");

        btnSeleccionar.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setEnabled(false);
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        lblArchivo.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        lblArchivo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblArchivo.setText("Nombre del Archivo");

        lblGrupo.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        lblGrupo.setText("Grupo:");

        txtGrupo.setEditable(false);
        txtGrupo.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        jLabel6.setText("Matricula:");

        txtMatricula.setEditable(false);
        txtMatricula.setFont(new java.awt.Font("Roboto Light", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegistar)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblFotografia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cbxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlFotografia, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApeMat)
                                    .addComponent(txtGrupo)
                                    .addComponent(txtNombres)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 2, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addComponent(txtApePat)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1)
                                            .addComponent(lblGrupo)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel2))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtMatricula))
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlFotografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUID)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(txtApePat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFotografia)
                    .addComponent(lblGrupo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSeleccionar)
                    .addComponent(lblArchivo)
                    .addComponent(txtGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnRegistar)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseEntered
        this.btnSalir.setForeground(new Color(80, 255, 177));
    }//GEN-LAST:event_btnSalirMouseEntered

    private void btnSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseExited
        this.btnSalir.setForeground(Color.WHITE);
    }//GEN-LAST:event_btnSalirMouseExited

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Inicio inicio = null;
        try {
            arduino.killArduinoConnection();
            inicio = new Inicio();
        } catch (ArduinoException ex) {
            Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SerialPortException ex) {
            Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
        }
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarActionPerformed
        if (tipo == 0) {
            if (alumno == null) {
                alumno = new Alumno();
            }
            alumno.setNombre(this.txtNombres.getText());
            alumno.setApellidoPaterno(this.txtApePat.getText());
            alumno.setApellidoMaterno(this.txtApeMat.getText());
            alumno.setUid(uid);
            alumno.setGrupo(this.txtGrupo.getText());
            alumno.setMatricula(this.txtMatricula.getText());
            if (this.btnRegistar.getText() == "Editar") {
                iAlumno.update(alumno);
            } else {
                iAlumno.save(alumno);
            }
            this.btnSalirActionPerformed(evt);
        } else {
            if (docente == null) {
                docente = new Docente();
            }
            docente.setNombre(this.txtNombres.getText());
            docente.setApellidoPaterno(this.txtApePat.getText());
            docente.setApellidoMaterno(this.txtApeMat.getText());
            docente.setUid(uid);
            docente.setMatricula(this.txtMatricula.getText());
            try {
                docente.setFoto(FileUtils.readFileToByteArray(file));
            } catch (IOException ex) {
                Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (this.btnRegistar.getText() == "Editar") {
                iDocente.update(docente);
            } else {
                iDocente.save(docente);
            }
            this.btnSalirActionPerformed(evt);
        }
    }//GEN-LAST:event_btnRegistarActionPerformed

    private void cbxTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxTipoItemStateChanged
        tipo = this.cbxTipo.getSelectedIndex();
        if (tipo == 1) {
            this.lblFotografia.setVisible(true);
            this.btnSeleccionar.setVisible(true);
            this.lblArchivo.setVisible(true);
            this.lblGrupo.setVisible(false);
            this.txtGrupo.setVisible(false);
        } else {
            this.lblFotografia.setVisible(false);
            this.btnSeleccionar.setVisible(false);
            this.lblArchivo.setVisible(false);
            this.lblGrupo.setVisible(true);
            this.txtGrupo.setVisible(true);
        }
    }//GEN-LAST:event_cbxTipoItemStateChanged

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(this);
        file = fc.getSelectedFile();
        this.lblArchivo.setText(file.getName());
        Hilo hilo = new Hilo(this.pnlFotografia, new ImageIcon(file.getPath()));
        hilo.start();
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    public void llenarCampos(String nombres, String apePat, String apeMat, String matricula, int ocupacion) {
        this.txtNombres.setText(nombres);
        this.txtApePat.setText(apePat);
        this.txtApeMat.setText(apeMat);
        this.txtMatricula.setText(matricula);
        this.cbxTipo.setSelectedIndex(ocupacion);
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
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Agregar().setVisible(true);
                } catch (ArduinoException ex) {
                    Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SerialPortException ex) {
                    Logger.getLogger(Agregar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JComboBox<String> cbxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblArchivo;
    private javax.swing.JLabel lblFotografia;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JLabel lblUID;
    private javax.swing.JPanel pnlFotografia;
    private javax.swing.JTextField txtApeMat;
    private javax.swing.JTextField txtApePat;
    private javax.swing.JTextField txtGrupo;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
