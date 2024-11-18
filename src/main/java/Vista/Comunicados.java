/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import Modelo.DatabaseUtils;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MATHIAS
 */
public class Comunicados extends javax.swing.JPanel {

    /**
     * Creates new form Notas
     */
    public Comunicados() {
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonEditar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 27, 72));
        setPreferredSize(new java.awt.Dimension(900, 680));

        scroll.setBackground(new java.awt.Color(1, 138, 190));
        scroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

        table.setBackground(new java.awt.Color(222, 232, 241));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Emisor", "Asunto", "Contenido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(1, 138, 190));
        table.setSelectionBackground(new java.awt.Color(1, 138, 190));
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        scroll.setViewportView(table);

        jPanel1.setBackground(new java.awt.Color(0, 27, 72));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Opciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 27, 72));

        jButtonEditar.setBackground(new java.awt.Color(255, 255, 51));
        jButtonEditar.setForeground(new java.awt.Color(0, 27, 72));
        jButtonEditar.setText("EDITAR");
        jButtonEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEditarMouseClicked(evt);
            }
        });
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonEliminar.setBackground(new java.awt.Color(255, 255, 51));
        jButtonEliminar.setForeground(new java.awt.Color(0, 27, 72));
        jButtonEliminar.setText("ELIMINAR");
        jButtonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonEliminarMouseClicked(evt);
            }
        });

        jButtonSalir.setBackground(new java.awt.Color(255, 255, 51));
        jButtonSalir.setForeground(new java.awt.Color(0, 27, 72));
        jButtonSalir.setText("SALIR");

        jButtonRegistrar.setBackground(new java.awt.Color(255, 255, 51));
        jButtonRegistrar.setForeground(new java.awt.Color(0, 27, 72));
        jButtonRegistrar.setText("Redactar");
        jButtonRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRegistrarMouseClicked(evt);
            }
        });
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(jButtonRegistrar)
                .addGap(77, 77, 77)
                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jButtonEliminar)
                .addGap(77, 77, 77)
                .addComponent(jButtonSalir)
                .addGap(130, 130, 130))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 866, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        //int row = table.getSelectedRow();
        //int column = table.getSelectedColumn();

        //String id = table.getValueAt(row, 0).toString();
        //jTextFieldId.setText(id);

        //String value = table.getValueAt(row, column).toString();
        //jTextFieldNota.setText(value);
        //esto no lo uses
    }//GEN-LAST:event_tableMouseClicked

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRegistrarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRegistrarMouseClicked

    private void jButtonEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarMouseClicked

    private void jButtonEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEditarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEditarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
