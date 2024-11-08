package br.com.DAO;

import br.com.DTO.LaboratorioDTO;
import br.com.views.TelaLaboratorio;
import br.com.views.TelaPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class LaboratorioDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void limpar() {
        TelaLaboratorio.txtId.setText(null);
        TelaLaboratorio.txtNome.setText(null);

    }

    public void autoPesquisar() {
        String sql = "select l.id_laboratorio as id, l.nome,e.nome as lab, e.status from laboratorios"
                + " l join equipamento e on e.id_laboratorio = l.id_laboratorio";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) TelaLaboratorio.tbLabin.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String status = rs.getString("status");
                String lab = rs.getString("lab");

                model.addRow(new Object[]{id, nome, lab, status});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro método autoPesquisar: " + e.getMessage());
        }
    }

    public void criar(LaboratorioDTO dto) {
        String sql = "insert into laboratorios(id_laboratorio, nome) values (?, ?)";

        conexao = ConexaoDAO.connector();
        try {
            pst = conexao.prepareStatement(sql);

            pst.setInt(1, dto.getId());
            pst.setString(2, dto.getNome());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Laboratorio adicionado com sucesso");
                autoPesquisar();
            }
        } catch (Exception e) {
            if (e.getMessage().contains("for key 'laboratorios.PRIMARY'")) {
                JOptionPane.showMessageDialog(null, "ID ja em uso");
            } else {
                JOptionPane.showMessageDialog(null, "erro método adicionar: " + e.getMessage());
            }
        }
    }

    public void pesquisar(LaboratorioDTO dto) {
        String sql = "select l.nome as lab, l.id_laboratorio as id_lab, e.nome as equip, e.status from laboratorios l join"
                + " equipamento e where l.id_laboratorio = ? and e.id_laboratorio = ?";

        conexao = ConexaoDAO.connector();
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, dto.getId());
            pst.setInt(2, dto.getId());

            rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) TelaLaboratorio.tbLabin.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                TelaLaboratorio.txtNome.setText(rs.getString("lab"));
                int id = rs.getInt("id_lab");
                String lab = rs.getString("lab");
                String status = rs.getString("status");
                String equip = rs.getString("equip");

                model.addRow(new Object[]{id, lab, equip, status});

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Método pesquisar" + e.getMessage());
        }
    }

    public void deletar(LaboratorioDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "Quer mesmo deletar este labin?", null, JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "delete from laboratorios where id_laboratorio = ?";
            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, dto.getId());
                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Deletado com sucesso");
                    autoPesquisar();
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Laboratorio não cadastrado");
                    limpar();
                }
            } catch (Exception e) {
                if (e.getMessage().contains("Cannot delete or update a parent row: a foreign key constraint fails")) {
                    JOptionPane.showMessageDialog(null, "laboratorio não pode ser deletado, há equipamentos registrados ainda");
                } else {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }

            }
        }
    }

    public void editar(LaboratorioDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "Quer mesmo editar este labin?", null, JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "update laboratorios set nome = ? where id_laboratorio = ?";
            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);

                pst.setInt(2, dto.getId());
                pst.setString(1, dto.getNome());

                int add = pst.executeUpdate();
                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
                    limpar();
                    autoPesquisar();
                } else {
                    JOptionPane.showMessageDialog(null, "Laboratorio não registrado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro método editar: " + e.getMessage());
            }
        }
    }
    
    public void verificarTipo(){
        if (TelaPrincipal.lblTipo.getText().contains("Estagiario")){
            TelaLaboratorio.btnAdd.setEnabled(false);
            TelaLaboratorio.btnEd.setEnabled(false);
            TelaLaboratorio.btnExcluir.setEnabled(false);
            TelaLaboratorio.btnPesq.setEnabled(false);
        } else if (TelaPrincipal.lblTipo.getText().contains("Técnico")){
            TelaLaboratorio.btnAdd.setEnabled(false);
            TelaLaboratorio.btnEd.setEnabled(false);
            TelaLaboratorio.btnExcluir.setEnabled(false);
        } else if (TelaPrincipal.lblTipo.getText().contains("Professor")){
            TelaLaboratorio.btnAdd.setEnabled(false);
            TelaLaboratorio.btnEd.setEnabled(false);
            TelaLaboratorio.btnExcluir.setEnabled(false);
            TelaLaboratorio.btnPesq.setEnabled(false);
        }
        
    }
    
}
