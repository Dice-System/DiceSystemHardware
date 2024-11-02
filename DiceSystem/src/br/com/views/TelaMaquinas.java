/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.views;

import br.com.DAO.EquipamentoDAO;
import br.com.DTO.EquipamentoDTO;
import javax.swing.JOptionPane;

/**
 *
 * @author Leon
 */
public class TelaMaquinas extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaMaquinas
     */
    public TelaMaquinas() {
        initComponents();
        EquipamentoDAO dao = new EquipamentoDAO();
        dao.autoPesquisar();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMaq = new javax.swing.JTable();
        txtId = new javax.swing.JTextField();
        txtIdLabin = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtProcess = new javax.swing.JTextField();
        txtRam = new javax.swing.JTextField();
        txtArmz = new javax.swing.JTextField();
        txtNSerie = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        boxStatus = new javax.swing.JComboBox<>();
        txtDataAq = new javax.swing.JFormattedTextField();
        btnCria = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();

        setClosable(true);
        setMaximumSize(new java.awt.Dimension(988, 623));
        setMinimumSize(new java.awt.Dimension(988, 623));
        setPreferredSize(new java.awt.Dimension(988, 623));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("Gerenciamento de maquinas");

        tbMaq.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbMaq.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tbMaq.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id da maquina", "id do laboratorio", "laboratorio", "nome", "processador", "memoria  RAM", "armazenamento", " N.º de serie", "data de aquisição", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbMaq);

        jLabel2.setText("id");

        jLabel3.setText("id do laboratorio");

        jLabel4.setText("nome");

        jLabel5.setText("processador");

        jLabel6.setText("RAM");

        jLabel7.setText("armazenamento");

        jLabel8.setText("numero de serie");

        jLabel9.setText("data de aquisição");

        jLabel10.setText("status");

        boxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "funcionando", "em manutenção", "fora de uso" }));
        boxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxStatusActionPerformed(evt);
            }
        });

        btnCria.setText("criar");
        btnCria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriaActionPerformed(evt);
            }
        });

        btnEditar.setText("editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDeletar.setText("deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnPesquisar.setText("pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(txtNSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(txtRam, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addGap(161, 161, 161)
                .addComponent(jLabel9)
                .addGap(146, 146, 146)
                .addComponent(jLabel5)
                .addGap(161, 161, 161)
                .addComponent(jLabel10))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(txtIdLabin, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(txtDataAq, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(txtProcess, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(boxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(txtArmz, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(btnCria)
                .addGap(27, 27, 27)
                .addComponent(btnPesquisar)
                .addGap(31, 31, 31)
                .addComponent(btnEditar)
                .addGap(29, 29, 29)
                .addComponent(btnDeletar))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 972, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(231, 231, 231)
                        .addComponent(jLabel8)
                        .addGap(153, 153, 153)
                        .addComponent(jLabel4)
                        .addGap(194, 194, 194)
                        .addComponent(jLabel6))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtIdLabin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtDataAq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProcess, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtArmz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCria)
                    .addComponent(btnPesquisar)
                    .addComponent(btnEditar)
                    .addComponent(btnDeletar))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriaActionPerformed
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento do ID");
        } else if (txtIdLabin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento do ID do laboratório");
        } else if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento do nome do equipamento");
        } else if (txtProcess.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento do processador");
        } else if (txtRam.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento da memoria RAM");
        } else if (txtArmz.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento do armazenamento");
        } else if (txtNSerie.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento do numero de serie");
        } else if (txtDataAq.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento da data de aquisição");
        } else {
            EquipamentoDAO dao = new EquipamentoDAO();
            EquipamentoDTO dto = new EquipamentoDTO();

            int id = Integer.parseInt(txtId.getText());
            int idlab = Integer.parseInt(txtIdLabin.getText());
            String nome = txtNome.getText();
            String process = txtProcess.getText();
            String ram = txtRam.getText();
            String arm = txtArmz.getText();
            String nser = txtNSerie.getText();
            String dataA = txtDataAq.getText();
            String status = boxStatus.getSelectedItem().toString();

            dto.setArmazenamento(arm);
            dto.setData_aquisicao(dataA);
            dto.setId(id);
            dto.setId_laboratorio(idlab);
            dto.setMemoria_RAM(ram);
            dto.setNome(nome);
            dto.setNumero_serie(nser);
            dto.setProcessador(process);

            if (status.contains("em")) {
                dto.setStatus("em_manutencao");
            } else if (status.contains("fora")) {
                dto.setStatus("fora_de_uso");
            } else {
                dto.setStatus("funcionando");
            }

            dao.criar(dto);
        }
    }//GEN-LAST:event_btnCriaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (txtId.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento do ID");
        } else if (txtIdLabin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento do ID do laboratório");
        } else if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento do nome do equipamento");
        } else if (txtProcess.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento do processador");
        } else if (txtRam.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento da memoria RAM");
        } else if (txtArmz.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento do armazenamento");
        } else if (txtNSerie.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento do numero de serie");
        } else if (txtDataAq.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Requisitamos o preenchimento da data de aquisição");
        } else {
            EquipamentoDAO dao = new EquipamentoDAO();
            EquipamentoDTO dto = new EquipamentoDTO();

            int id = Integer.parseInt(txtId.getText());
            int idlab = Integer.parseInt(txtIdLabin.getText());
            String nome = txtNome.getText();
            String process = txtProcess.getText();
            String ram = txtRam.getText();
            String arm = txtArmz.getText();
            String nser = txtNSerie.getText();
            String dataA = txtDataAq.getText();
            String status = boxStatus.getSelectedItem().toString();

            dto.setArmazenamento(arm);
            dto.setData_aquisicao(dataA);
            dto.setId(id);
            dto.setId_laboratorio(idlab);
            dto.setMemoria_RAM(ram);
            dto.setNome(nome);
            dto.setNumero_serie(nser);
            dto.setProcessador(process);

            if (status.contains("em")) {
                dto.setStatus("em_manutencao");
            } else if (status.contains("fora")) {
                dto.setStatus("fora_de_uso");
            } else {
                dto.setStatus("funcionando");
            }

            dao.atualizar(dto);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione um id a ser deletado");
            } else {

                EquipamentoDAO dao = new EquipamentoDAO();
                EquipamentoDTO dto = new EquipamentoDTO();

                int id = Integer.parseInt(txtId.getText());
                dto.setId(id);

                dao.deletar(dto);
            }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        String[] esco = {"Equipamento", "Laboratório", "Cancelar"};

        int res = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Título da Caixa", JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, esco, esco[0]);

        if (res == 0) {

            if (txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione um id a ser pesquisado");
            } else {

                EquipamentoDAO dao = new EquipamentoDAO();
                EquipamentoDTO dto = new EquipamentoDTO();

                int id = Integer.parseInt(txtId.getText());
                dto.setId(id);

                dao.pesquisar(dto);
            }
        } else if(res == 1){
            if (txtIdLabin.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Selecione um id de laboratorio a ser pesquisado");
            } else {

                EquipamentoDAO dao = new EquipamentoDAO();
                EquipamentoDTO dto = new EquipamentoDTO();

                int id = Integer.parseInt(txtIdLabin.getText());
                dto.setId_laboratorio(id);

                dao.pesquisarNomeLab(dto);
            }
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void boxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> boxStatus;
    public static javax.swing.JButton btnCria;
    public static javax.swing.JButton btnDeletar;
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tbMaq;
    public static javax.swing.JTextField txtArmz;
    public static javax.swing.JFormattedTextField txtDataAq;
    public static javax.swing.JTextField txtId;
    public static javax.swing.JTextField txtIdLabin;
    public static javax.swing.JTextField txtNSerie;
    public static javax.swing.JTextField txtNome;
    public static javax.swing.JTextField txtProcess;
    public static javax.swing.JTextField txtRam;
    // End of variables declaration//GEN-END:variables
}
