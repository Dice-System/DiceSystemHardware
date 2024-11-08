package br.com.DAO;

import br.com.DTO.ManutencaoDTO;
import br.com.views.TelaGerenciaManutencao;
import br.com.views.TelaPrincipal;
import br.com.views.TelaSolicitaManutencao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ManutencaoDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void limparRegistrar() {
        TelaSolicitaManutencao.txtId.setText(null);
        TelaSolicitaManutencao.txtData.setText(null);
        TelaSolicitaManutencao.txtDiagnostico.setText(null);
        TelaSolicitaManutencao.txtResponsavel.setText(null);
    }

    public void limparTudo() {
        TelaGerenciaManutencao.txtId.setText(null);
        TelaGerenciaManutencao.txtIdEquip.setText(null);
        TelaGerenciaManutencao.txtData.setText(null);
        TelaGerenciaManutencao.txtResponsa.setText(null);
        TelaGerenciaManutencao.txtDiagnostico.setText(null);
        TelaGerenciaManutencao.txtSolucao.setText(null);
    }

    public void solicitar(ManutencaoDTO dto) {
        String sql = "insert into manutencao (id_equipamento, data_manutencao, diagnostico, tecnico_responsavel)"
                + " values (?, ?, ?, ?)";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, dto.getIdEquip());
            pst.setString(2, dto.getDataManutencao());
            pst.setString(3, dto.getDiagnostico());
            pst.setString(4, dto.getResponsavel());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "adicionado com sucesso!");
                limparRegistrar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "metodo solicitar: " + e.getMessage());
        }
    }

    public void autoPesquisar() {
        String sql = "select m.id_manutencao as id, e.nome as equi, m.data_manutencao as data, m.diagnostico as dia,"
                + " m.solucao as solu, m.tecnico_responsavel as res"
                + " from manutencao m join equipamento e on m.id_equipamento = e.id_equipamento";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) TelaGerenciaManutencao.tbManu.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id");
                String equi = rs.getString("equi");
                String data = rs.getString("data");
                String dia = rs.getString("dia");
                String solu = rs.getString("solu");
                String res = rs.getString("res");

                model.addRow(new Object[]{id, equi, data, dia, solu, res});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro método autoPesquisar: " + e.getMessage());
        }
    }

    public void criar(ManutencaoDTO dto) {
        String sql = "insert into manutencao (id_manutencao, id_equipamento, data_manutencao,"
                + " diagnostico, solucao, tecnico_responsavel) value (?, ?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, dto.getId());
            pst.setInt(2, dto.getIdEquip());
            pst.setString(3, dto.getDataManutencao());
            pst.setString(4, dto.getDiagnostico());
            pst.setString(5, dto.getSolucao());
            pst.setString(6, dto.getResponsavel());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "adicionado com sucesso!");
                limparTudo();
                autoPesquisar();
            }

        } catch (Exception e) {
            if (e.getMessage().contains("for column 'data_manutencao'")) {
                JOptionPane.showMessageDialog(null, "data invalida");
            } else if (e.getMessage().contains("for key 'manutencao.PRIMARY")) {
                JOptionPane.showMessageDialog(null, "id da manutenção ja em uso");
            } else if (e.getMessage().contains("Cannot add or update a child row: a foreign key constraint fails")) {
                JOptionPane.showMessageDialog(null, "id do equipamento não existe");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage() + " no metodo criar");
            }
        }
    }

    public void pesquisar(ManutencaoDTO dto) {
        String sql = "select * from manutencao where id_manutencao = ?";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, dto.getId());

            rs = pst.executeQuery();

            if (rs.next()) {
                TelaGerenciaManutencao.txtIdEquip.setText(rs.getString(2));
                TelaGerenciaManutencao.txtData.setText(rs.getString(3));
                TelaGerenciaManutencao.txtDiagnostico.setText(rs.getString(4));
                TelaGerenciaManutencao.txtSolucao.setText(rs.getString(5));
                TelaGerenciaManutencao.txtResponsa.setText(rs.getString(6));

            } else {
                JOptionPane.showMessageDialog(null, "manutenção não registrada");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void atualizar(ManutencaoDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "Quer mesmo editar esta manutenção?", null, JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "update manutencao set id_equipamento = ?, data_manutencao = ?, tecnico_responsavel = ?,"
                    + " diagnostico = ?, solucao = ? where id_manutencao = ?";
            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, dto.getIdEquip());
                pst.setString(2, dto.getDataManutencao());
                pst.setString(3, dto.getResponsavel());
                pst.setString(4, dto.getDiagnostico());
                pst.setString(5, dto.getSolucao());
                pst.setInt(6, dto.getId());

                int add = pst.executeUpdate();

                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Editado com sucesso");
                    autoPesquisar();
                    limparTudo();
                }
            } catch (Exception e) {
                if (e.getMessage().contains("for column 'data_manutencao'")) {
                    JOptionPane.showMessageDialog(null, "data invalida");
                } else if (e.getMessage().contains("Cannot add or update a child row: a foreign key constraint fails")) {
                    JOptionPane.showMessageDialog(null, "id do equipamento não existe");
                } else {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }

    public void deletar(ManutencaoDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "Quer mesmo deletar esta manutenção?", null, JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "delete from manutencao where id_manutencao = ?";
            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, dto.getId());

                int add = pst.executeUpdate();

                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso");
                    autoPesquisar();
                    limparTudo();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public void verificaTipoGerenciamento() {
        if (TelaPrincipal.lblTipo.getText().contains("Estagiario")) {
            TelaGerenciaManutencao.btnAtualizar.setEnabled(false);
            TelaGerenciaManutencao.btnCria.setEnabled(false);
            TelaGerenciaManutencao.btnDeletar.setEnabled(false);
            TelaGerenciaManutencao.btnSearch.setEnabled(false);
        } else if (TelaPrincipal.lblTipo.getText().contains("Técnico")){
            TelaGerenciaManutencao.btnDeletar.setEnabled(false);
        } else if (TelaPrincipal.lblTipo.getText().contains("Professor")){
            TelaGerenciaManutencao.btnDeletar.setEnabled(false);
            TelaGerenciaManutencao.btnAtualizar.setEnabled(false);
        }
    }
    
    public void verificaTipoSolicitacao(){
        if (TelaPrincipal.lblTipo.getText().contains("Estagiario")) {
            TelaSolicitaManutencao.btnAdd.setEnabled(false);
        }
    }

}
