/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
/**
 *
 * @author MATHIAS
 */
public class MenuAdmin extends javax.swing.JPanel {

    private Principal principal;
    
    public void mostrarPanel(JPanel panel) {
        panel.setSize(900, 680);
        panel.setLocation(0, 0);

        Contenido.removeAll();
        Contenido.add(panel, BorderLayout.CENTER);
        Contenido.revalidate();
        Contenido.repaint();
    }
    
    public MenuAdmin(Principal principal) {
        this.principal = principal;
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

        jPanel1 = new javax.swing.JPanel();
        PanelAlumnos = new javax.swing.JPanel();
        TextoAlumnos = new javax.swing.JLabel();
        PanelRegistro = new javax.swing.JPanel();
        TextoRegistro = new javax.swing.JLabel();
        PanelProfesores = new javax.swing.JPanel();
        TextoProfesores = new javax.swing.JLabel();
        PanelSalones = new javax.swing.JPanel();
        TextoSalones = new javax.swing.JLabel();
        PanelNotas = new javax.swing.JPanel();
        TextoNotas = new javax.swing.JLabel();
        PanelPagos = new javax.swing.JPanel();
        TextoPagos = new javax.swing.JLabel();
        PanelSalir = new javax.swing.JPanel();
        TextoSalir = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Contenido = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 680));

        jPanel1.setBackground(new java.awt.Color(0, 68, 129));

        PanelAlumnos.setBackground(new java.awt.Color(0, 68, 129));
        PanelAlumnos.setPreferredSize(new java.awt.Dimension(300, 42));

        TextoAlumnos.setBackground(new java.awt.Color(0, 68, 129));
        TextoAlumnos.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        TextoAlumnos.setForeground(new java.awt.Color(151, 202, 219));
        TextoAlumnos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextoAlumnos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alumnos.png"))); // NOI18N
        TextoAlumnos.setText("ALUMNOS");
        TextoAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TextoAlumnos.setIconTextGap(10);
        TextoAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextoAlumnosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TextoAlumnosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TextoAlumnosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelAlumnosLayout = new javax.swing.GroupLayout(PanelAlumnos);
        PanelAlumnos.setLayout(PanelAlumnosLayout);
        PanelAlumnosLayout.setHorizontalGroup(
            PanelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAlumnosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TextoAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelAlumnosLayout.setVerticalGroup(
            PanelAlumnosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextoAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        PanelRegistro.setBackground(new java.awt.Color(0, 68, 129));

        TextoRegistro.setBackground(new java.awt.Color(0, 68, 129));
        TextoRegistro.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        TextoRegistro.setForeground(new java.awt.Color(151, 202, 219));
        TextoRegistro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/informacion.png"))); // NOI18N
        TextoRegistro.setText("REGISTRO");
        TextoRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TextoRegistro.setIconTextGap(10);
        TextoRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextoRegistroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TextoRegistroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TextoRegistroMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelRegistroLayout = new javax.swing.GroupLayout(PanelRegistro);
        PanelRegistro.setLayout(PanelRegistroLayout);
        PanelRegistroLayout.setHorizontalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRegistroLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(TextoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        PanelRegistroLayout.setVerticalGroup(
            PanelRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextoRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        PanelProfesores.setBackground(new java.awt.Color(0, 68, 129));
        PanelProfesores.setPreferredSize(new java.awt.Dimension(300, 42));

        TextoProfesores.setBackground(new java.awt.Color(0, 68, 129));
        TextoProfesores.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        TextoProfesores.setForeground(new java.awt.Color(151, 202, 219));
        TextoProfesores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextoProfesores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/profesor.png"))); // NOI18N
        TextoProfesores.setText("PROFESORES");
        TextoProfesores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TextoProfesores.setIconTextGap(10);
        TextoProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextoProfesoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TextoProfesoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TextoProfesoresMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelProfesoresLayout = new javax.swing.GroupLayout(PanelProfesores);
        PanelProfesores.setLayout(PanelProfesoresLayout);
        PanelProfesoresLayout.setHorizontalGroup(
            PanelProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelProfesoresLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(TextoProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelProfesoresLayout.setVerticalGroup(
            PanelProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextoProfesores, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        PanelSalones.setBackground(new java.awt.Color(0, 68, 129));
        PanelSalones.setPreferredSize(new java.awt.Dimension(300, 42));

        TextoSalones.setBackground(new java.awt.Color(0, 68, 129));
        TextoSalones.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        TextoSalones.setForeground(new java.awt.Color(151, 202, 219));
        TextoSalones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextoSalones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salon-de-clases.png"))); // NOI18N
        TextoSalones.setText("SALONES");
        TextoSalones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TextoSalones.setIconTextGap(10);
        TextoSalones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextoSalonesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TextoSalonesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TextoSalonesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelSalonesLayout = new javax.swing.GroupLayout(PanelSalones);
        PanelSalones.setLayout(PanelSalonesLayout);
        PanelSalonesLayout.setHorizontalGroup(
            PanelSalonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSalonesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(TextoSalones, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSalonesLayout.setVerticalGroup(
            PanelSalonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextoSalones, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        PanelNotas.setBackground(new java.awt.Color(0, 68, 129));
        PanelNotas.setPreferredSize(new java.awt.Dimension(300, 42));

        TextoNotas.setBackground(new java.awt.Color(0, 68, 129));
        TextoNotas.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        TextoNotas.setForeground(new java.awt.Color(151, 202, 219));
        TextoNotas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextoNotas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/notas.png"))); // NOI18N
        TextoNotas.setText("REPORTE DE NOTAS");
        TextoNotas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TextoNotas.setIconTextGap(10);
        TextoNotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextoNotasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TextoNotasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TextoNotasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelNotasLayout = new javax.swing.GroupLayout(PanelNotas);
        PanelNotas.setLayout(PanelNotasLayout);
        PanelNotasLayout.setHorizontalGroup(
            PanelNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNotasLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(TextoNotas, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelNotasLayout.setVerticalGroup(
            PanelNotasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextoNotas, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        PanelPagos.setBackground(new java.awt.Color(0, 68, 129));
        PanelPagos.setPreferredSize(new java.awt.Dimension(300, 42));

        TextoPagos.setBackground(new java.awt.Color(0, 68, 129));
        TextoPagos.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        TextoPagos.setForeground(new java.awt.Color(151, 202, 219));
        TextoPagos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextoPagos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pagos.png"))); // NOI18N
        TextoPagos.setText("PAGOS");
        TextoPagos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TextoPagos.setIconTextGap(10);
        TextoPagos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextoPagosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TextoPagosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TextoPagosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelPagosLayout = new javax.swing.GroupLayout(PanelPagos);
        PanelPagos.setLayout(PanelPagosLayout);
        PanelPagosLayout.setHorizontalGroup(
            PanelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPagosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(TextoPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelPagosLayout.setVerticalGroup(
            PanelPagosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextoPagos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        PanelSalir.setBackground(new java.awt.Color(0, 68, 129));
        PanelSalir.setPreferredSize(new java.awt.Dimension(300, 42));

        TextoSalir.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        TextoSalir.setForeground(new java.awt.Color(151, 202, 219));
        TextoSalir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TextoSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/exit-door.png"))); // NOI18N
        TextoSalir.setText("SALIR");
        TextoSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TextoSalir.setIconTextGap(10);
        TextoSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TextoSalirMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TextoSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                TextoSalirMouseExited(evt);
            }
        });

        javax.swing.GroupLayout PanelSalirLayout = new javax.swing.GroupLayout(PanelSalir);
        PanelSalir.setLayout(PanelSalirLayout);
        PanelSalirLayout.setHorizontalGroup(
            PanelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSalirLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(TextoSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSalirLayout.setVerticalGroup(
            PanelSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TextoSalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AULA LOGO ofi.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelProfesores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelSalones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelNotas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelPagos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel1))
            .addComponent(PanelRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelSalones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelNotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PanelSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TextoNotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoNotasMouseClicked
        mostrarPanel(new NotasAdmin());
    }//GEN-LAST:event_TextoNotasMouseClicked

    private void TextoNotasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoNotasMouseEntered
        PanelNotas.setBackground(new Color(1, 138, 190));
    }//GEN-LAST:event_TextoNotasMouseEntered

    private void TextoNotasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoNotasMouseExited
        PanelNotas.setBackground(new Color(0, 68, 129));
    }//GEN-LAST:event_TextoNotasMouseExited

    private void TextoSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoSalirMouseClicked
        Principal log = new Principal();
        log.setSize(1200, 680);
        log.setLocationRelativeTo(null);
        log.setVisible(true);

        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        currentFrame.dispose();
    }//GEN-LAST:event_TextoSalirMouseClicked

    private void TextoSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoSalirMouseEntered
        PanelSalir.setBackground(new Color(1, 138, 190));
    }//GEN-LAST:event_TextoSalirMouseEntered

    private void TextoSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoSalirMouseExited
        PanelSalir.setBackground(new Color(0, 68, 129));
    }//GEN-LAST:event_TextoSalirMouseExited

    private void TextoSalonesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoSalonesMouseClicked
        //mostrarPanel(new NotasAdmin());
    }//GEN-LAST:event_TextoSalonesMouseClicked

    private void TextoSalonesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoSalonesMouseEntered
        PanelSalones.setBackground(new Color(1, 138, 190));
    }//GEN-LAST:event_TextoSalonesMouseEntered

    private void TextoSalonesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoSalonesMouseExited
        PanelSalones.setBackground(new Color(0, 68, 129));
    }//GEN-LAST:event_TextoSalonesMouseExited

    private void TextoPagosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoPagosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoPagosMouseClicked

    private void TextoPagosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoPagosMouseEntered
        PanelPagos.setBackground(new Color(1, 138, 190));
    }//GEN-LAST:event_TextoPagosMouseEntered

    private void TextoPagosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoPagosMouseExited
        PanelPagos.setBackground(new Color(0, 68, 129));
    }//GEN-LAST:event_TextoPagosMouseExited

    private void TextoProfesoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoProfesoresMouseClicked
        mostrarPanel(new ListaProfesores());
    }//GEN-LAST:event_TextoProfesoresMouseClicked

    private void TextoProfesoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoProfesoresMouseEntered
        PanelProfesores.setBackground(new Color(1, 138, 190));
    }//GEN-LAST:event_TextoProfesoresMouseEntered

    private void TextoProfesoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoProfesoresMouseExited
        PanelProfesores.setBackground(new Color(0, 68, 129));
    }//GEN-LAST:event_TextoProfesoresMouseExited

    private void TextoRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoRegistroMouseClicked
        mostrarPanel(new Registro());
    }//GEN-LAST:event_TextoRegistroMouseClicked

    private void TextoRegistroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoRegistroMouseEntered
        PanelRegistro.setBackground(new Color(1, 138, 190));
    }//GEN-LAST:event_TextoRegistroMouseEntered

    private void TextoRegistroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoRegistroMouseExited
        PanelRegistro.setBackground(new Color(0, 68, 129));
    }//GEN-LAST:event_TextoRegistroMouseExited

    private void TextoAlumnosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoAlumnosMouseExited
        PanelAlumnos.setBackground(new Color(0, 68, 129));
    }//GEN-LAST:event_TextoAlumnosMouseExited

    private void TextoAlumnosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoAlumnosMouseEntered
        PanelAlumnos.setBackground(new Color(1, 138, 190));
    }//GEN-LAST:event_TextoAlumnosMouseEntered

    private void TextoAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TextoAlumnosMouseClicked
        mostrarPanel(new ListaAlumnos());
    }//GEN-LAST:event_TextoAlumnosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel PanelAlumnos;
    private javax.swing.JPanel PanelNotas;
    private javax.swing.JPanel PanelPagos;
    private javax.swing.JPanel PanelProfesores;
    private javax.swing.JPanel PanelRegistro;
    private javax.swing.JPanel PanelSalir;
    private javax.swing.JPanel PanelSalones;
    private javax.swing.JLabel TextoAlumnos;
    private javax.swing.JLabel TextoNotas;
    private javax.swing.JLabel TextoPagos;
    private javax.swing.JLabel TextoProfesores;
    private javax.swing.JLabel TextoRegistro;
    private javax.swing.JLabel TextoSalir;
    private javax.swing.JLabel TextoSalones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void mostrarFrame(Registro registro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
