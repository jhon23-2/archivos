package com.mycompany.vista;

import com.mycompany.ecxel.FiltradoDatos;
import java.awt.CardLayout;

public class VistaFrame extends javax.swing.JFrame {

    private CardLayout cambiar;

    public VistaFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Gestion de plantillas");
        cambiar = (CardLayout) panelPantalla.getLayout();
        addPaneles();
        new FiltradoDatos().filtradoDatos(tblDatos_Md);
    }

    private void addPaneles() {
        panelPantalla.add(panelHome, "panelHome");
        panelPantalla.add(panelDatos, "panelDatos");
        panelPantalla.add(panelInformacion, "panelInformacion");
        panelPantalla.add(panelEnvioCorreos, "panelCorreos");
        panelPantalla.add(panelConfiguracion, "panelConfiguracion");
        cambiar.show(panelPantalla, "panelHome");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        labelMis_datos = new javax.swing.JLabel();
        labelHome = new javax.swing.JLabel();
        labelConfiguracion = new javax.swing.JLabel();
        labelInformacion = new javax.swing.JLabel();
        labelEnviaCorreos = new javax.swing.JLabel();
        panelEmcabezado = new javax.swing.JPanel();
        panelPantalla = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelDatos = new javax.swing.JPanel();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos_Md = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCedula_Md = new javax.swing.JTextField();
        btnBuscar_Md = new javax.swing.JButton();
        panelConfiguracion = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelInformacion = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelEnvioCorreos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panelPrincipal.setForeground(new java.awt.Color(255, 255, 255));

        panelMenu.setBackground(new java.awt.Color(153, 153, 153));
        panelMenu.setLayout(null);

        labelMis_datos.setText("MYS DATOS");
        labelMis_datos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelMis_datos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelMis_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelMis_datosMouseClicked(evt);
            }
        });
        panelMenu.add(labelMis_datos);
        labelMis_datos.setBounds(0, 200, 180, 50);

        labelHome.setText("HOME");
        labelHome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                labelHomeMousePressed(evt);
            }
        });
        panelMenu.add(labelHome);
        labelHome.setBounds(0, 150, 180, 50);

        labelConfiguracion.setText("CONFIGURACION");
        labelConfiguracion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelConfiguracionMouseClicked(evt);
            }
        });
        panelMenu.add(labelConfiguracion);
        labelConfiguracion.setBounds(0, 350, 180, 50);

        labelInformacion.setText("INFORMACION");
        labelInformacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelInformacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelInformacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelInformacionMouseClicked(evt);
            }
        });
        panelMenu.add(labelInformacion);
        labelInformacion.setBounds(0, 250, 180, 50);

        labelEnviaCorreos.setText("ENVIAR CORREOS");
        labelEnviaCorreos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelEnviaCorreos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        labelEnviaCorreos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelEnviaCorreosMouseClicked(evt);
            }
        });
        panelMenu.add(labelEnviaCorreos);
        labelEnviaCorreos.setBounds(0, 300, 180, 50);

        panelEmcabezado.setBackground(new java.awt.Color(51, 102, 255));
        panelEmcabezado.setLayout(null);

        panelPantalla.setBackground(new java.awt.Color(255, 255, 255));
        panelPantalla.setLayout(new java.awt.CardLayout());

        jLabel1.setText("PANTALLA DE INICIO");

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        panelPantalla.add(panelHome, "card2");

        panelDatos.setBackground(new java.awt.Color(255, 255, 255));

        tblDatos_Md.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDatos_Md);

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CEDULA");

        btnBuscar_Md.setText("Buscar");

        javax.swing.GroupLayout panelDatosLayout = new javax.swing.GroupLayout(panelDatos);
        panelDatos.setLayout(panelDatosLayout);
        panelDatosLayout.setHorizontalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCedula_Md, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar_Md, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addComponent(panelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelDatosLayout.setVerticalGroup(
            panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosLayout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(panelDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCedula_Md, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar_Md))
                .addGap(384, 384, 384))
            .addComponent(panelTabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelPantalla.add(panelDatos, "card3");

        jLabel3.setText("PANTALLA DE CONFIGURACION");

        javax.swing.GroupLayout panelConfiguracionLayout = new javax.swing.GroupLayout(panelConfiguracion);
        panelConfiguracion.setLayout(panelConfiguracionLayout);
        panelConfiguracionLayout.setHorizontalGroup(
            panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfiguracionLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
        );
        panelConfiguracionLayout.setVerticalGroup(
            panelConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConfiguracionLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        panelPantalla.add(panelConfiguracion, "card4");

        jLabel4.setText("PANTALLA DE  INFORMACION");

        javax.swing.GroupLayout panelInformacionLayout = new javax.swing.GroupLayout(panelInformacion);
        panelInformacion.setLayout(panelInformacionLayout);
        panelInformacionLayout.setHorizontalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
        );
        panelInformacionLayout.setVerticalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        panelPantalla.add(panelInformacion, "card5");

        jLabel5.setText("PANTALLA DE  CORREOS");

        javax.swing.GroupLayout panelEnvioCorreosLayout = new javax.swing.GroupLayout(panelEnvioCorreos);
        panelEnvioCorreos.setLayout(panelEnvioCorreosLayout);
        panelEnvioCorreosLayout.setHorizontalGroup(
            panelEnvioCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnvioCorreosLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
        );
        panelEnvioCorreosLayout.setVerticalGroup(
            panelEnvioCorreosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnvioCorreosLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(264, Short.MAX_VALUE))
        );

        panelPantalla.add(panelEnvioCorreos, "card6");

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEmcabezado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelEmcabezado, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPantalla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelHomeMousePressed
        cambiar.show(panelPantalla, "panelHome");
    }//GEN-LAST:event_labelHomeMousePressed

    private void labelMis_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelMis_datosMouseClicked
        cambiar.show(panelPantalla, "panelDatos");

    }//GEN-LAST:event_labelMis_datosMouseClicked

    private void labelInformacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelInformacionMouseClicked
        cambiar.show(panelPantalla, "panelInformacion");

    }//GEN-LAST:event_labelInformacionMouseClicked

    private void labelEnviaCorreosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelEnviaCorreosMouseClicked
        cambiar.show(panelPantalla, "panelCorreos");

    }//GEN-LAST:event_labelEnviaCorreosMouseClicked

    private void labelConfiguracionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelConfiguracionMouseClicked
        cambiar.show(panelPantalla, "panelConfiguracion");

    }//GEN-LAST:event_labelConfiguracionMouseClicked

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
            java.util.logging.Logger.getLogger(VistaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar_Md;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelConfiguracion;
    private javax.swing.JLabel labelEnviaCorreos;
    private javax.swing.JLabel labelHome;
    private javax.swing.JLabel labelInformacion;
    private javax.swing.JLabel labelMis_datos;
    private javax.swing.JPanel panelConfiguracion;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelEmcabezado;
    private javax.swing.JPanel panelEnvioCorreos;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelPantalla;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tblDatos_Md;
    private javax.swing.JTextField txtCedula_Md;
    // End of variables declaration//GEN-END:variables
}
