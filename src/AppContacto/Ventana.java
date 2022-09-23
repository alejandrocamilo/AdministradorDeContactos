package AppContacto;

import mySQL.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;


import javax.swing.text.MaskFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.text.ParseException;
import javax.swing.table.TableRowSorter;


public class Ventana extends javax.swing.JFrame {

    private ConexionDataBase conexion = new ConexionDataBase();
    private OperacionDataBase operacionDB = new OperacionDataBase();
    private DefaultTableModel dtm = new DefaultTableModel();
    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;
    private Contacto miContacto = null;

    private int id;
    private String nombre;
    private String apellido;
    private String telefono1;
    private String telefono2;
    private String empresa;
    private String correoElectronico;
    
    public Ventana() {
        initComponents();
        setLocationRelativeTo(null);
        insertarValoresTabla();
        campoId.setVisible(false);
        mensajeCampoNombre.setVisible(false);
        mensajeCampoApellido.setVisible(false);
        mensajeCampoTelefono.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mensajeCampoNombre = new javax.swing.JLabel();
        campoId = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        campoApellido = new javax.swing.JTextField();
        campoTelefono1 = new javax.swing.JFormattedTextField();
        campoTelefono2 = new javax.swing.JFormattedTextField();
        campoCorreo = new javax.swing.JTextField();
        campoEmpresa = new javax.swing.JTextField();
        mensajeCampoApellido = new javax.swing.JLabel();
        mensajeCampoTelefono = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        botonCrear = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        menuDesplegable = new javax.swing.JComboBox<>();
        txtFiltro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador De Contactos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Entrada De Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("Nombre(*):");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Telefono 2: ");

        jLabel5.setText("Empresa:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Apellido(*):");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Telefono 1(*):");

        jLabel6.setText("Correo Electronico:");

        mensajeCampoNombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mensajeCampoNombre.setForeground(new java.awt.Color(255, 51, 51));
        mensajeCampoNombre.setText("CAMPO OBLIGATORIO(*)");

        campoId.setEditable(false);
        campoId.setEnabled(false);

        campoNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoNombreFocusLost(evt);
            }
        });
        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoNombreKeyReleased(evt);
            }
        });

        campoApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoApellidoFocusLost(evt);
            }
        });
        campoApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoApellidoKeyReleased(evt);
            }
        });

        campoTelefono1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                campoTelefono1FocusLost(evt);
            }
        });
        campoTelefono1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoTelefono1KeyReleased(evt);
            }
        });

        try{
            MaskFormatter mf = new MaskFormatter("(###) ### - ####");

            campoTelefono2.setFormatterFactory(new DefaultFormatterFactory(mf));
        }
        catch(ParseException e){
            System.out.println(e);
        }

        mensajeCampoApellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mensajeCampoApellido.setForeground(new java.awt.Color(255, 51, 51));
        mensajeCampoApellido.setText("CAMPO OBLIGATORIO(*)");

        mensajeCampoTelefono.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        mensajeCampoTelefono.setForeground(new java.awt.Color(255, 51, 51));
        mensajeCampoTelefono.setText("CAMPO OBLIGATORIO(*)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(mensajeCampoNombre))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mensajeCampoApellido, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(campoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mensajeCampoTelefono, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(220, 220, 220))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mensajeCampoTelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mensajeCampoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(mensajeCampoApellido))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoTelefono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        try{
            MaskFormatter mf = new MaskFormatter("(###) ### - ####");

            campoTelefono1.setFormatterFactory(new DefaultFormatterFactory(mf));
        }
        catch(ParseException e){
            System.out.println(e);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Operaciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jPanel2.setToolTipText("");

        botonCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iconocrear.png"))); // NOI18N
        botonCrear.setText("Crear   ");
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });

        botonModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iconomodificar .png"))); // NOI18N
        botonModificar.setText("Modificar");
        botonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarActionPerformed(evt);
            }
        });

        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iconoeliminar.png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos/iconolimpiar.png"))); // NOI18N
        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        menuDesplegable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar:", "Nombre", "Apellido", "Empresa", "Correo Electronico" }));
        menuDesplegable.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                menuDesplegableItemStateChanged(evt);
            }
        });

        txtFiltro.setEnabled(false);
        txtFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Filtrar por:");

        jLabel8.setText("Filtro:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(botonCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(botonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(menuDesplegable, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botonCrear)
                        .addComponent(botonModificar)
                        .addComponent(botonEliminar)
                        .addComponent(botonLimpiar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(menuDesplegable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Base De Datos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));

        jScrollPane2.setEnabled(false);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Apellido", "Telefono_1", "Telefono_2", "Empresa", "Correo_Electronico"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        accionClickTabla();
    }//GEN-LAST:event_tablaMouseClicked

    private void campoApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoApellidoKeyReleased
        validarCampoApellido();
    }//GEN-LAST:event_campoApellidoKeyReleased

    private void campoApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoApellidoFocusLost
        validarCampoApellido();
    }//GEN-LAST:event_campoApellidoFocusLost

    private void campoNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyReleased
        validarCampoNombre();
    }//GEN-LAST:event_campoNombreKeyReleased

    private void campoNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoNombreFocusLost
        validarCampoNombre();
    }//GEN-LAST:event_campoNombreFocusLost

    private void txtFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroKeyReleased
        filtrar();
    }//GEN-LAST:event_txtFiltroKeyReleased

    private void menuDesplegableItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_menuDesplegableItemStateChanged
        seleccionarTipoFiltro();
        filtrar();
    }//GEN-LAST:event_menuDesplegableItemStateChanged

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        accionBotonEliminar();
        insertarValoresTabla();
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarActionPerformed
        accionBotonModificar();
        insertarValoresTabla();
    }//GEN-LAST:event_botonModificarActionPerformed

    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearActionPerformed
        accionBotonCrear();
        insertarValoresTabla();
    }//GEN-LAST:event_botonCrearActionPerformed

    private void campoTelefono1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoTelefono1KeyReleased
        validarCampoTelefono();
    }//GEN-LAST:event_campoTelefono1KeyReleased

    private void campoTelefono1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_campoTelefono1FocusLost
        validarCampoTelefono();
    }//GEN-LAST:event_campoTelefono1FocusLost

    private void accionBotonCrear() {
           
        if (!campoNombre.getText().trim().isEmpty() && !campoApellido.getText().trim().isEmpty() && !campoTelefono1.getText().equals("(   )     -     ")) {
            
            if(verificarContactoExistente()){
                JOptionPane.showMessageDialog(null, "El Contacto Ya Existe!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            else{
            miContacto = new Contacto(campoNombre.getText(), campoApellido.getText(), campoTelefono1.getText(),
                                      campoTelefono2.getText(), campoEmpresa.getText(), campoCorreo.getText());
        
            operacionDB.insertarRegistro(miContacto);
            }
 
        }
        else{
           JOptionPane.showMessageDialog(null, "Por favor rellene los campos obligatorios!", "Advertencia", JOptionPane.WARNING_MESSAGE);
           validarCampoNombre();
           validarCampoApellido();
           validarCampoTelefono();
        }

} 
    
    private boolean verificarContactoExistente(){
         
        ArrayList<Contacto> listaContactos = new ArrayList();
        listaContactos = operacionDB.consultarRegistro();
        boolean contactoExistente = false;
        
        for(int i = 0; i<listaContactos.size(); i++){
           
            if(listaContactos.get(i).getNombre().equals(campoNombre.getText()) && 
               listaContactos.get(i).getApellido().equals(campoApellido.getText())&&
               listaContactos.get(i).getTelefono1().equals(campoTelefono1.getText())&&
               listaContactos.get(i).getTelefono2().equals(campoTelefono2.getText())&&
               listaContactos.get(i).getEmpresa().equals(campoEmpresa.getText())&&
               listaContactos.get(i).getCorreoElectronico().equals(campoCorreo.getText())){
                
                contactoExistente = true;
            }
        }
        
        return contactoExistente;
    }
    
    private void accionBotonModificar() {

        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            id = Integer.parseInt(campoId.getText());
            nombre = campoNombre.getText();
            apellido = campoApellido.getText();
            telefono1 = campoTelefono1.getText();
            telefono2 = campoTelefono2.getText();
            empresa = campoEmpresa.getText();
            correoElectronico = campoCorreo.getText();

            miContacto = new Contacto(id, nombre, apellido, telefono1, telefono2, empresa, correoElectronico);

            operacionDB.modificarRegistro(miContacto);
        }

    }
    private void accionBotonEliminar() {

        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "No has seleccionado ninguna fila", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            id = Integer.parseInt(campoId.getText());
            nombre = campoNombre.getText();
            apellido = campoApellido.getText();
            telefono1 = campoTelefono1.getText();
            telefono2 = campoTelefono2.getText();
            empresa = campoEmpresa.getText();
            correoElectronico = campoCorreo.getText();

            miContacto = new Contacto(id, nombre, apellido, telefono1, telefono2, empresa, correoElectronico);

            operacionDB.eliminarRegistro(miContacto);
        }
    }
    private void insertarValoresTabla() {

        ArrayList<Contacto> listaContactos = operacionDB.consultarRegistro();
        Object[] contacto = new Object[7];

        dtm = (DefaultTableModel) tabla.getModel();

        limpiarTabla();

        for (int i = 0; i < listaContactos.size(); i++) {

            contacto[0] = listaContactos.get(i).getId();
            contacto[1] = listaContactos.get(i).getNombre();
            contacto[2] = listaContactos.get(i).getApellido();
            contacto[3] = listaContactos.get(i).getTelefono1();
            contacto[4] = listaContactos.get(i).getTelefono2();
            contacto[5] = listaContactos.get(i).getEmpresa();
            contacto[6] = listaContactos.get(i).getCorreoElectronico();

            dtm.addRow(contacto);
        }

        tabla.setModel(dtm);

    }

    private void limpiarTabla() {

        for (int i = 0; i < tabla.getRowCount(); i++) {

            dtm.removeRow(i);
            i = i - 1;
        }
    }

    private void accionClickTabla() {
        
        int filaSeleccionada = tabla.getSelectedRow();

        id = (int) tabla.getValueAt(filaSeleccionada, 0);
        nombre = (String) tabla.getValueAt(filaSeleccionada, 1);
        apellido = (String) tabla.getValueAt(filaSeleccionada, 2);
        telefono1 = (String) tabla.getValueAt(filaSeleccionada, 3);
        telefono2 =  (String) tabla.getValueAt(filaSeleccionada, 4);
        empresa = (String) tabla.getValueAt(filaSeleccionada, 5);
        correoElectronico = (String) tabla.getValueAt(filaSeleccionada, 6);

        campoId.setText("" + id);
        campoNombre.setText(nombre);
        campoApellido.setText(apellido);
        campoTelefono1.setText(""+telefono1);
        campoTelefono2.setText(""+telefono2);
        campoEmpresa.setText(empresa);
        campoCorreo.setText(correoElectronico);
         
           validarCampoNombre();
           validarCampoApellido();
           validarCampoTelefono();

    }

    private void filtrar() {

        TableRowSorter tablaOrdenada = new TableRowSorter(dtm);
        RowFilter filaFiltrada;

        tablaOrdenada = new TableRowSorter(dtm);
        tabla.setRowSorter(tablaOrdenada);

        String filtro = txtFiltro.getText();

        if (menuDesplegable.getSelectedItem().equals("Nombre")) {
            
            filaFiltrada = RowFilter.regexFilter("(?i)" + filtro, 1);
            tablaOrdenada.setRowFilter(filaFiltrada);
        }

        if (menuDesplegable.getSelectedItem().equals("Apellido")) {
            
            filaFiltrada = RowFilter.regexFilter("(?i)" + filtro, 2);
            tablaOrdenada.setRowFilter(filaFiltrada);
        }

        if (menuDesplegable.getSelectedItem().equals("Empresa")) {
            
            filaFiltrada = RowFilter.regexFilter("(?i)" + filtro, 5);
            tablaOrdenada.setRowFilter(filaFiltrada);
        }

        if (menuDesplegable.getSelectedItem().equals("Correo Electronico")) {
            
            filaFiltrada = RowFilter.regexFilter("(?i)" + filtro, 6);
            tablaOrdenada.setRowFilter(filaFiltrada);
        }

    }
    private void seleccionarTipoFiltro() {
        if (menuDesplegable.getSelectedItem().equals("Nombre") || menuDesplegable.getSelectedItem().equals("Apellido")
                || menuDesplegable.getSelectedItem().equals("Empresa") || menuDesplegable.getSelectedItem().equals("Correo Electronico")) {

            txtFiltro.setEnabled(true);
            txtFiltro.setText("");
        } else {
            txtFiltro.setText("");
            txtFiltro.setEnabled(false);
        }
    }
    
    private void validarCampoNombre() {

        
        if (campoNombre.getText().trim().isEmpty()) {
           mensajeCampoNombre.setVisible(true);
            
        } else {
            mensajeCampoNombre.setVisible(false);
        }
    }

    private void validarCampoApellido(){
    
        if (campoApellido.getText().trim().isEmpty()) {
           mensajeCampoApellido.setVisible(true);
            
        } else {
            mensajeCampoApellido.setVisible(false);
        }
}

        private void validarCampoTelefono(){

        if (campoTelefono1.getText().equals("(   )     -     ")) {
           mensajeCampoTelefono.setVisible(true);
        } else {
            mensajeCampoTelefono.setVisible(false);
        }
     
    }

    
    
    private void limpiarCampos(){
        
        if(!campoNombre.getText().trim().isEmpty() || !campoApellido.getText().trim().isEmpty() || !campoTelefono1.getText().equals("(   )     -     ") || 
           !campoTelefono2.getText().equals("(   )     -     ") || !campoEmpresa.getText().trim().isEmpty() || !campoCorreo.getText().trim().isEmpty()){
        
        campoNombre.setText("");
        campoApellido.setText("");
        campoTelefono1.setText("");
        campoTelefono2.setText("");
        campoEmpresa.setText("");
        campoCorreo.setText("");
        
        }
        else{
          JOptionPane.showMessageDialog(null, "Los campos ya estan vacios!", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }

    }
    
    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCrear;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonModificar;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoCorreo;
    private javax.swing.JTextField campoEmpresa;
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JFormattedTextField campoTelefono1;
    private javax.swing.JFormattedTextField campoTelefono2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mensajeCampoApellido;
    private javax.swing.JLabel mensajeCampoNombre;
    private javax.swing.JLabel mensajeCampoTelefono;
    private javax.swing.JComboBox<String> menuDesplegable;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables


}
