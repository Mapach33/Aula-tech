
package Vista;
import java.awt.Color;
/**
 *
 * @author MATHIAS
 */
public class Login extends javax.swing.JPanel {
    
    private Principal principal;

    /**
     * Creates new form Login
     */
    public Login(Principal principal) {
        this.principal = principal;
        initComponents();
        initStyles();
        addRoundedPanel();
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
        jLabel1 = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldUsuario = new javax.swing.JTextField();
        jTextFieldPassword = new javax.swing.JTextField();
        jButtonIngresar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setAutoscrolls(true);
        jPanel1.setPreferredSize(new java.awt.Dimension(620, 400));

        jLabel1.setBackground(new java.awt.Color(153, 255, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 153));
        jLabel1.setText("AULA-TECH");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(255, 204, 51));
        jLabelUsuario.setText("USUARIO");

        jLabelPassword.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelPassword.setForeground(new java.awt.Color(255, 204, 51));
        jLabelPassword.setText("PASSWORD");

        jTextFieldUsuario.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldUsuarioMousePressed(evt);
            }
        });

        jTextFieldPassword.setBackground(new java.awt.Color(204, 204, 204));
        jTextFieldPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextFieldPasswordMousePressed(evt);
            }
        });

        jButtonIngresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonIngresar.setText("INGRESAR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelPassword)
                            .addComponent(jLabelUsuario))
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(242, 242, 242))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jButtonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(122, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldPasswordMousePressed
        // TODO add your handling code here:
        /*
        if (String.valueOf(jTextFieldPassword.getPassword()).equals("*****************")) {
            jTextFieldPassword.setText("");
        }
        if (jTextFieldUsuario.getText().isEmpty()) {
            jTextFieldUsuario.setText("Ingrese su nombre de usuario");
            jTextFieldUsuario.setForeground(new Color(204, 204, 204));
        }*/
    }//GEN-LAST:event_jTextFieldPasswordMousePressed

    private void jTextFieldUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldUsuarioMousePressed
        // TODO add your handling code here:
        /*
        if (jTextFieldUsuario.getText().equals("Ingrese su nombre de usuario")) {
            jTextFieldUsuario.setText("");
        }
        if (String.valueOf(jTextFieldPassword.getPassword()).isEmpty()) {
            jTextFieldPassword.setText("*****************");
            jTextFieldPassword.setForeground(new Color(204, 204, 204));
        }*/
    }//GEN-LAST:event_jTextFieldUsuarioMousePressed
    
    
    private void initStyles(){
        jTextFieldUsuario.putClientProperty( "JComponent.roundRect", true );
        jTextFieldPassword.putClientProperty( "JComponent.roundRect", true );
        jTextFieldUsuario.setColumns(15); // 15 columnas visibles
        jTextFieldPassword.setColumns(15);
        jButtonIngresar.putClientProperty( "JButton.buttonType", "roundRect" );
    }
    
    // Método para agregar el RoundedPanel después de initComponents()
    private void addRoundedPanel() {    
        // Creamos el panel con bordes redondeados y le damos un tamaño fijo
        RoundedPanel roundedPanel = new RoundedPanel(30); // Bordes redondeados con radio de 30
        roundedPanel.setBackground(Color.GRAY); // Fondo gris para el RoundedPanel
        roundedPanel.setPreferredSize(new java.awt.Dimension(620, 400)); // Tamaño preferido
       
        // Usamos GridBagLayout para centrar los componentes dentro del RoundedPanel
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        java.awt.GridBagConstraints gbc = new java.awt.GridBagConstraints();
        roundedPanel.setLayout(layout);

        // Configuramos los constraints para centrar los componentes
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = java.awt.GridBagConstraints.CENTER; // Alinear en el centro
        gbc.insets = new java.awt.Insets(20, 10, 20, 10); // Espacio entre los componentes
        roundedPanel.add(jLabel1, gbc); // Título centrado

        // Agregamos los campos de texto y etiquetas al GridBagLayout
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = java.awt.GridBagConstraints.EAST; // Etiqueta alineada a la derecha
        roundedPanel.add(jLabelUsuario, gbc);

        gbc.gridx = 1;
        gbc.anchor = java.awt.GridBagConstraints.WEST; // Campo de texto alineado a la izquierda
        roundedPanel.add(jTextFieldUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = java.awt.GridBagConstraints.EAST; // Etiqueta alineada a la derecha
        roundedPanel.add(jLabelPassword, gbc);

        gbc.gridx = 1;
        gbc.anchor = java.awt.GridBagConstraints.WEST; // Campo de texto alineado a la izquierda
        roundedPanel.add(jTextFieldPassword, gbc);
        
        // Agregar el botón de ingreso
        jButtonIngresar.setPreferredSize(new java.awt.Dimension(120, 40));
        gbc.gridx = 1; // Mismo layout que los campos de texto, alineado a la izquierda
        gbc.gridy++; // Avanzamos al siguiente row en el layout
        gbc.anchor = java.awt.GridBagConstraints.CENTER; // Alinear el botón al centro
        roundedPanel.add(jButtonIngresar, gbc); // Añadir el botón al panel

        // Ahora ajustamos el layout del jPanel1 para centrar el RoundedPanel
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        // Centramos el RoundedPanel dentro del jPanel1
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(roundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(roundedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        // Revalidar y repintar para actualizar la interfaz
        jPanel1.revalidate();
        jPanel1.repaint();
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldUsuario;
    // End of variables declaration//GEN-END:variables
}