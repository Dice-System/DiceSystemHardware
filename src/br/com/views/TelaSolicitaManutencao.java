/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.views;

import br.com.DAO.ManutencaoDAO;
import br.com.DTO.ManutencaoDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon
 */
public class TelaSolicitaManutencao extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaSolicitaManutencao
     */
    public TelaSolicitaManutencao() {
        initComponents();
        ManutencaoDAO dao = new ManutencaoDAO();
        dao.verificaTipoSolicitacao();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        txtDiagnostico = new javax.swing.JTextField();
        txtResponsavel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnLimpa = new javax.swing.JButton();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(616, 623));
        setMinimumSize(new java.awt.Dimension(616, 623));
        setPreferredSize(new java.awt.Dimension(616, 623));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 49, 0));
        jLabel1.setText("Solicitar manutenção");

        txtId.setBackground(new java.awt.Color(41, 37, 71));
        txtId.setForeground(new java.awt.Color(255, 49, 0));

        txtData.setBackground(new java.awt.Color(41, 37, 71));
        txtData.setForeground(new java.awt.Color(255, 49, 0));

        txtDiagnostico.setEditable(false);
        txtDiagnostico.setBackground(new java.awt.Color(41, 37, 71));
        txtDiagnostico.setForeground(new java.awt.Color(255, 49, 0));
        txtDiagnostico.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtDiagnostico.setToolTipText("");

        txtResponsavel.setBackground(new java.awt.Color(41, 37, 71));
        txtResponsavel.setForeground(new java.awt.Color(255, 49, 0));

        jLabel3.setText("id do equipamento");

        jLabel4.setText("data de registro");

        jLabel5.setText("diagnostico");

        jLabel6.setText("responsavel");

        btnAdd.setBackground(new java.awt.Color(41, 37, 71));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_manu.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnLimpa.setBackground(new java.awt.Color(41, 37, 71));
        btnLimpa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/limpa.png"))); // NOI18N
        btnLimpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(55, 55, 55)
                        .addComponent(btnAdd))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addComponent(btnLimpa))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnAdd)))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)
                        .addGap(6, 6, 6)
                        .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnLimpa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addComponent(txtDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (txtId.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Selecione o id de um equipamento");
        } else if (txtData.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Coloque a data de solicitação");
        } else if (txtDiagnostico.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "descreeva o diagnostico");
        } else if (txtResponsavel.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "insira o nome do responsavel");
        } else {
        ManutencaoDAO dao = new ManutencaoDAO();
        ManutencaoDTO dto = new ManutencaoDTO();
        
        int idEquip = Integer.parseInt(txtId.getText());
        String data = txtData.getText();
        String diagnostico = txtDiagnostico.getText();
        String respo = txtResponsavel.getText();
        
        dto.setIdEquip(idEquip);
        dto.setDataManutencao(data);
        dto.setDiagnostico(diagnostico);
        dto.setResponsavel(respo);
        
        dao.solicitar(dto);
        
        
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnLimpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpaActionPerformed
        ManutencaoDAO dao = new ManutencaoDAO();
        dao.limparRegistrar();
    }//GEN-LAST:event_btnLimpaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnAdd;
    private javax.swing.JButton btnLimpa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JTextField txtData;
    public static javax.swing.JTextField txtDiagnostico;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtResponsavel;
    // End of variables declaration//GEN-END:variables
}
