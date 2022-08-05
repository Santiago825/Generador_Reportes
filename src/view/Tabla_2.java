/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import controller.ReportesController;
import java.awt.BorderLayout;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import model.vo.LiderVo;
import model.vo.ProyectoVo;
import static view.Dashboard.content;

/**
 *
 * @author santi
 */
public class Tabla_2 extends javax.swing.JPanel {

    /**
     * Creates new form tabla_1
     */
    public Tabla_2() {
        initComponents();
        llenarTabla();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_salir = new javax.swing.JPanel();
        regresar = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(119, 167, 215));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reporte de proyectos ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 80));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Proyecto", "Constructora", "Nùmero Habitaciones", "Ciudad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionForeground(new java.awt.Color(51, 204, 0));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 610, 210));

        btn_salir.setBackground(new java.awt.Color(73, 92, 131));

        regresar.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        regresar.setForeground(new java.awt.Color(255, 255, 255));
        regresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        regresar.setText("Salir");
        regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                regresarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout btn_salirLayout = new javax.swing.GroupLayout(btn_salir);
        btn_salir.setLayout(btn_salirLayout);
        btn_salirLayout.setHorizontalGroup(
            btn_salirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(regresar, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        btn_salirLayout.setVerticalGroup(
            btn_salirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(regresar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jPanel1.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 210, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    public void llenarTabla(){
        ReportesController report=new ReportesController();
        
                
        ReportesController controller = new ReportesController();
        try {
            var allProyecto = controller.findAllProyecto();
            DefaultTableModel modelo=(DefaultTableModel) jTable1.getModel();
            
            for (ProyectoVo proyecto : allProyecto) {
              
                String []fila={String.valueOf(proyecto.getId()),proyecto.getConstructora(),proyecto.getNumero_habitantes(),proyecto.getCiudad()};
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
    private void regresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regresarMousePressed
        Menu menu=new Menu();
        menu.setSize(680, 420);
        menu.setLocation(0,0);
        content.removeAll();
        content.add(menu, BorderLayout.CENTER);
        content.revalidate();
        content.repaint(); 
    }//GEN-LAST:event_regresarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel regresar;
    // End of variables declaration//GEN-END:variables
}