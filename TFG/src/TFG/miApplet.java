/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TFG;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author luisre
 */
public class miApplet extends javax.swing.JApplet {

    /**
     * Initializes the applet miApplet
     */
    @Override
    public void init() {
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
            java.util.logging.Logger.getLogger(miApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(miApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(miApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(miApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the applet */
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Abrir_button = new javax.swing.JButton();
        Abrir_textField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Abrir_textArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Buscar_button = new javax.swing.JButton();

        Abrir_button.setText("Abrir");
        Abrir_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Abrir_buttonActionPerformed(evt);
            }
        });

        Abrir_textArea.setColumns(20);
        Abrir_textArea.setRows(5);
        jScrollPane2.setViewportView(Abrir_textArea);

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        jLabel10.setText("jLabel10");

        Buscar_button.setText("Buscar");
        Buscar_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Buscar_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Abrir_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Abrir_textField))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(73, 149, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(Buscar_button))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Abrir_textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Buscar_button))
                    .addComponent(Abrir_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addComponent(jScrollPane2))
                .addContainerGap(122, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Abrir_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Abrir_buttonActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
    
        File f = chooser.getSelectedFile();
        String filepath = f.getAbsolutePath();
        
        Abrir_textField.setText(filepath);
        
        Lector_XML xml_file = new Lector_XML();
        xml_file.read_xml(filepath);
        
        Abrir_textArea.setText( "Legislatura: " + xml_file.get_legislatura() +
                                "\nNumero diario: " + xml_file.get_numero_diario() +
                                "\nTipo sesion: " + xml_file.get_tipo_sesion() +
                                "\nOrgano: " + xml_file.get_organo() +
                                "\nPresidente: " + xml_file.get_presidente() +
                                "\nFecha: " + xml_file.get_dia() + "/" + xml_file.get_mes() + "/" + xml_file.get_anio() +
                                "\nTipo epigrafe: " + xml_file.get_tipo_epigrafe() +
                                "\nTipo iniciativa: " + xml_file.get_tipo_iniciativa() +
                                "\nExtracto: " + xml_file.get_extracto() +
                                "\nIntervienen: " + xml_file.get_intervienen() +
                                "\nParrafos: " + xml_file.get_parrafo() );
        
        ArrayList<String> ListaCadenas = new ArrayList<String>();
        ArrayList<String> ListaDiscurso = new ArrayList<String>();
        
        ListaCadenas = xml_file.get_interviniente();
        ListaDiscurso = xml_file.get_parrafo();

        xml_file.listaNombres(ListaCadenas, ListaDiscurso, filepath);
        
        indice_LCN indice = new indice_LCN();
        ArrayList<String> ListaConsulta = new ArrayList<String>();
   
        try{
            indice.crearIndice();
            ListaConsulta = indice.consultarIndice(ListaDiscurso);
        }catch(Exception ex){
            
        }
        
        jLabel1.setForeground(Color.red);
        jLabel1.setText(ListaConsulta.get(0));
        
        jLabel2.setForeground(Color.red);
        jLabel2.setText(ListaConsulta.get(1));
        
        jLabel3.setForeground(Color.red);
        jLabel3.setText(ListaConsulta.get(2));
        
        jLabel4.setForeground(Color.red);
        jLabel4.setText(ListaConsulta.get(3));
        
        jLabel5.setForeground(Color.red);
        jLabel5.setText(ListaConsulta.get(4));
        
        jLabel6.setForeground(Color.red);
        jLabel6.setText(ListaConsulta.get(5));
        
        jLabel7.setForeground(Color.red);
        jLabel7.setText(ListaConsulta.get(6));
        
        jLabel8.setForeground(Color.red);
        jLabel8.setText(ListaConsulta.get(7));
        
        jLabel9.setForeground(Color.red);
        jLabel9.setText(ListaConsulta.get(8));
        
        jLabel10.setForeground(Color.red);
        jLabel10.setText(ListaConsulta.get(9));
    }//GEN-LAST:event_Abrir_buttonActionPerformed

    private void Buscar_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar_buttonActionPerformed
        // TODO add your handling code here:
        String texto = new String();
        ArrayList<String> ListaDiscurso = new ArrayList<String>();
        ArrayList<String> ListaConsulta = new ArrayList<String>();
        indice_LCN indice = new indice_LCN();
        
        texto = Abrir_textField.getText();
        
        ListaDiscurso.add(texto);
        
        try{
            ListaConsulta = indice.consultarIndice(ListaDiscurso);
        }catch(Exception ex){
            
        }
        
        jLabel1.setForeground(Color.red);
        jLabel1.setText(ListaConsulta.get(0));
        
        jLabel2.setForeground(Color.red);
        jLabel2.setText(ListaConsulta.get(1));
        
        jLabel3.setForeground(Color.red);
        jLabel3.setText(ListaConsulta.get(2));
        
        jLabel4.setForeground(Color.red);
        jLabel4.setText(ListaConsulta.get(3));
        
        jLabel5.setForeground(Color.red);
        jLabel5.setText(ListaConsulta.get(4));
        
        jLabel6.setForeground(Color.red);
        jLabel6.setText(ListaConsulta.get(5));
        
        jLabel7.setForeground(Color.red);
        jLabel7.setText(ListaConsulta.get(6));
        
        jLabel8.setForeground(Color.red);
        jLabel8.setText(ListaConsulta.get(7));
        
        jLabel9.setForeground(Color.red);
        jLabel9.setText(ListaConsulta.get(8));
        
        jLabel10.setForeground(Color.red);
        jLabel10.setText(ListaConsulta.get(9));
        
    }//GEN-LAST:event_Buscar_buttonActionPerformed
                                           

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abrir_button;
    private javax.swing.JTextArea Abrir_textArea;
    private javax.swing.JTextField Abrir_textField;
    private javax.swing.JButton Buscar_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
