/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package conversormonedas;

import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class VentanaConversorTemperatura extends javax.swing.JFrame {
    
    private DefaultComboBoxModel<Temperatura> modelo = new DefaultComboBoxModel();
    private DefaultComboBoxModel<Temperatura> modelo1 = new DefaultComboBoxModel();
    private DecimalFormat formato = new DecimalFormat("#.##");
    private Conversor temperatura;

    /**
     * Creates new form VentanaConversorTemperatura
     */
    public VentanaConversorTemperatura() {
        llenarComboBox();
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        temperatura = new Conversor(obtenerAbreviacion(comboTemperaturaFrom), obtenerAbreviacion(comboTemperaturaTo), 0);
    }
    
    public void llenarComboBox() {
        añadirElementos(new Temperatura("Celsius", "°C"));
        añadirElementos(new Temperatura("Fahrenheit", "°F"));
        añadirElementos(new Temperatura("Kelvin", "K"));
        añadirElementos(new Temperatura("Rankine", "°R"));
    }
    
    public void añadirElementos(Temperatura temperatura) {
        modelo.addElement(temperatura);
        modelo1.addElement(temperatura);
    }
    
    public void obtenerTemperatura() {
        if (!fieldMonto.getText().isEmpty())
        {
            try
            {
                String resultado = formato.format(temperatura.obtenerTemperatura(Double.parseDouble(fieldMonto.getText())));
                fieldResultado.setText(String.valueOf(resultado));
            } catch (NumberFormatException ex)
            {
                mensajeError();
            }
        }
    }
    
    public String obtenerAbreviacion(JComboBox<Temperatura> comboBox) {
        return ((Temperatura) comboBox.getSelectedItem()).getAbreviatura();
    }
    
    public void mensajeError() {
        JOptionPane.showMessageDialog(null, "Solo se aceptan numeros", "Error", JOptionPane.ERROR_MESSAGE, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel = new javax.swing.JPanel();
        labelTitulo = new javax.swing.JLabel();
        labelCantidad = new javax.swing.JLabel();
        fieldMonto = new javax.swing.JTextField();
        labelTipoCambio = new javax.swing.JLabel();
        comboTemperaturaFrom = new javax.swing.JComboBox<>();
        comboTemperaturaTo = new javax.swing.JComboBox<>();
        labelResultado = new javax.swing.JLabel();
        fieldResultado = new javax.swing.JTextField();
        labelFrom = new javax.swing.JLabel();
        labelTo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        itemDivisas = new javax.swing.JMenuItem();
        itemTemperaturas = new javax.swing.JMenuItem();
        itemCerrar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setLayout(new java.awt.GridBagLayout());

        labelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTitulo.setText("CONVERSOR DE TEMPERATURA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(30, 0, 30, 0);
        panel.add(labelTitulo, gridBagConstraints);

        labelCantidad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelCantidad.setText("Cantidad a convertir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(9, 10, 10, 10);
        panel.add(labelCantidad, gridBagConstraints);

        fieldMonto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fieldMonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldMontoKeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 100, 10, 100);
        panel.add(fieldMonto, gridBagConstraints);

        labelTipoCambio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelTipoCambio.setText("Seleccione el tipo de cambio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(9, 10, 10, 10);
        panel.add(labelTipoCambio, gridBagConstraints);

        comboTemperaturaFrom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboTemperaturaFrom.setModel(modelo);
        comboTemperaturaFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTemperaturaFromActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 10, 130);
        panel.add(comboTemperaturaFrom, gridBagConstraints);

        comboTemperaturaTo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboTemperaturaTo.setModel(modelo1);
        comboTemperaturaTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTemperaturaToActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 10, 130);
        panel.add(comboTemperaturaTo, gridBagConstraints);

        labelResultado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        labelResultado.setText("Resultado:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(9, 10, 10, 10);
        panel.add(labelResultado, gridBagConstraints);

        fieldResultado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fieldResultado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 100, 30, 100);
        panel.add(fieldResultado, gridBagConstraints);

        labelFrom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelFrom.setText("De:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 0);
        panel.add(labelFrom, gridBagConstraints);

        labelTo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTo.setText("A:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 0);
        panel.add(labelTo, gridBagConstraints);

        menu.setText("Menu");
        menu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        itemDivisas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemDivisas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cambio-de-divisas.png"))); // NOI18N
        itemDivisas.setText("Conversor de divisas");
        itemDivisas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDivisasActionPerformed(evt);
            }
        });
        menu.add(itemDivisas);

        itemTemperaturas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemTemperaturas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/temperatura.png"))); // NOI18N
        itemTemperaturas.setText("Conversor de temperaturas");
        itemTemperaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemTemperaturasActionPerformed(evt);
            }
        });
        menu.add(itemTemperaturas);

        itemCerrar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        itemCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cerrar.png"))); // NOI18N
        itemCerrar.setText("Cerrar");
        itemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarActionPerformed(evt);
            }
        });
        menu.add(itemCerrar);

        jMenuBar1.add(menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemTemperaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemTemperaturasActionPerformed

    }//GEN-LAST:event_itemTemperaturasActionPerformed

    private void itemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarActionPerformed
        System.exit(0);
    }//GEN-LAST:event_itemCerrarActionPerformed

    private void fieldMontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldMontoKeyReleased
        obtenerTemperatura();
    }//GEN-LAST:event_fieldMontoKeyReleased

    private void comboTemperaturaFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTemperaturaFromActionPerformed
        temperatura.setTipoFrom(obtenerAbreviacion(comboTemperaturaFrom));
        obtenerTemperatura();
    }//GEN-LAST:event_comboTemperaturaFromActionPerformed

    private void comboTemperaturaToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTemperaturaToActionPerformed
        temperatura.setTipoTo(obtenerAbreviacion(comboTemperaturaTo));
        obtenerTemperatura();
    }//GEN-LAST:event_comboTemperaturaToActionPerformed

    private void itemDivisasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDivisasActionPerformed
        dispose();
        VentanaConversorDivisas vd = new VentanaConversorDivisas();
    }//GEN-LAST:event_itemDivisasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(VentanaConversorTemperatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VentanaConversorTemperatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VentanaConversorTemperatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VentanaConversorTemperatura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaConversorTemperatura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Temperatura> comboTemperaturaFrom;
    private javax.swing.JComboBox<Temperatura> comboTemperaturaTo;
    private javax.swing.JTextField fieldMonto;
    private javax.swing.JTextField fieldResultado;
    private javax.swing.JMenuItem itemCerrar;
    private javax.swing.JMenuItem itemDivisas;
    private javax.swing.JMenuItem itemTemperaturas;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelCantidad;
    private javax.swing.JLabel labelFrom;
    private javax.swing.JLabel labelResultado;
    private javax.swing.JLabel labelTipoCambio;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTo;
    private javax.swing.JMenu menu;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
