package br.com.DAO;

import br.com.DTO.EquipamentoDTO;
import br.com.views.TelaMaquinas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EquipamentoDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void limpar() {
        TelaMaquinas.txtIdLabin.setText(null);
        TelaMaquinas.txtNome.setText(null);
        TelaMaquinas.txtProcess.setText(null);
        TelaMaquinas.txtRam.setText(null);
        TelaMaquinas.txtArmz.setText(null);
        TelaMaquinas.txtNSerie.setText(null);
        TelaMaquinas.txtDataAq.setText(null);
        TelaMaquinas.boxStatus.setSelectedItem("funcionando");

    }

    public void autoPesquisar() {
        String sql = "select e.id_equipamento as id, e.id_laboratorio as idlab, l.nome as nomelab,"
                + " e.nome, e.processador as pros,"
                + " e.memoria_RAM as ram, e.armazenamento as armz, e.numero_serie as ns, e.data_aquisicao as da,"
                + " e.status from equipamento e join laboratorios l on e.id_laboratorio = l.id_laboratorio;";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) TelaMaquinas.tbMaq.getModel();
            model.setNumRows(0);

            while (rs.next()) {
                int id = rs.getInt("id");
                int idLab = rs.getInt("idlab");
                String nomeLab = rs.getString("nomelab");
                String nome = rs.getString("nome");
                String pros = rs.getString("pros");
                String ram = rs.getString("ram");
                String armz = rs.getString("armz");
                String ns = rs.getString("ns");
                String da = rs.getString("da");
                String status = rs.getString("status");

                model.addRow(new Object[]{id, idLab, nomeLab, nome, pros, ram, armz, ns, da, status});
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void criar(EquipamentoDTO dto) {
        String sql = "insert into equipamento (id_equipamento, id_laboratorio, nome, processador, memoria_RAM,"
                + " armazenamento, numero_serie, data_aquisicao, status) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);

            pst.setInt(1, dto.getId());
            pst.setInt(2, dto.getId_laboratorio());
            pst.setString(3, dto.getNome());
            pst.setString(4, dto.getProcessador());
            pst.setString(5, dto.getMemoria_RAM());
            pst.setString(6, dto.getArmazenamento());
            pst.setString(7, dto.getNumero_serie());
            pst.setString(8, dto.getData_aquisicao());
            pst.setString(9, dto.getStatus());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
                autoPesquisar();
                limpar();
            } else {
                JOptionPane.showMessageDialog(null, "erro");
                limpar();
            }

        } catch (Exception e) {

            if (e.getMessage().contains("for column 'data_aquisicao'")) {
                JOptionPane.showMessageDialog(null, "data invalida");
            } else if (e.getMessage().contains("for key 'equipamento.PRIMARY")) {
                JOptionPane.showMessageDialog(null, "id em uso");
            } else if (e.getMessage().contains("Cannot add or update a child row: a foreign key constraint fails")) {
                JOptionPane.showMessageDialog(null, "id do laboratorio não existe");
            } else if (e.getMessage().contains("for key 'equipamento.numero_serie'")) {
                JOptionPane.showMessageDialog(null, " N.º de serie em uso");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }

        }

    }

    public void pesquisar(EquipamentoDTO dto) {

        String sql = "select * from equipamento where id_equipamento = ?";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);

            pst.setInt(1, dto.getId());

            rs = pst.executeQuery();

            if (rs.next()) {
                TelaMaquinas.txtIdLabin.setText(rs.getString(2));
                TelaMaquinas.txtNome.setText(rs.getString(3));
                TelaMaquinas.txtProcess.setText(rs.getString(4));
                TelaMaquinas.txtRam.setText(rs.getString(5));
                TelaMaquinas.txtArmz.setText(rs.getString(6));
                TelaMaquinas.txtNSerie.setText(rs.getString(7));
                TelaMaquinas.txtDataAq.setText(rs.getString(8));

                if (rs.getString(9).contains("funcionando")) {
                    TelaMaquinas.boxStatus.setSelectedItem("funcionando");
                } else if (rs.getString(9).contains("em")) {
                    TelaMaquinas.boxStatus.setSelectedItem("em manutenção");
                } else {
                    TelaMaquinas.boxStatus.setSelectedItem("fora de uso");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Equipamento não cadastrado");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void pesquisarNomeLab(EquipamentoDTO dto) {
        String sql = "select l.nome, l.id_laboratorio as id from laboratorios l join equipamento e on l.id_laboratorio = ?";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, dto.getId_laboratorio());

            rs = pst.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Nome do laboratorio de id " + rs.getString("id") + ": " + rs.getString("nome"));
            } else {
                JOptionPane.showMessageDialog(null, "Laboratorio inexistente");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public void deletar(EquipamentoDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "tem certeza que deseja deletar este equipamento?",
                null, JOptionPane.YES_NO_OPTION);

        if (res == JOptionPane.YES_OPTION) {
            String sql = "delete from equipamento where id_equipamento = ?";
            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, dto.getId());

                int add = pst.executeUpdate();

                if (add > 0) {
                    JOptionPane.showMessageDialog(null, "deletado com sucesso");
                    autoPesquisar();
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "equipamento não registrado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

    }

    public void atualizar(EquipamentoDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "quer mesmo atualizar o equipamento com este ID?", null, JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "update equipamento set id_laboratorio = ?, nome = ?, processador = ?, memoria_RAM = ?,"
                       + " armazenamento = ?, numero_serie = ?, data_aquisicao = ?, status = ? where id_equipamento = ?";
            conexao = ConexaoDAO.connector();
            
            try {
                pst = conexao.prepareStatement(sql);
                
                pst.setInt(1, dto.getId_laboratorio());
                pst.setString(2, dto.getNome());
                pst.setString(3, dto.getProcessador());
                pst.setString(4, dto.getMemoria_RAM());
                pst.setString(5, dto.getArmazenamento());
                pst.setString(6, dto.getNumero_serie());
                pst.setString(7, dto.getData_aquisicao());
                pst.setString(8, dto.getStatus());
                pst.setInt(9, dto.getId());
                
                int add = pst.executeUpdate();
                
                if(add > 0){
                    JOptionPane.showMessageDialog(null, "atualizado com sucesso");
                    autoPesquisar();
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Equipamento não registrado");
                    limpar();
                }
                
            } catch (Exception e) {
                if (e.getMessage().contains("for column 'data_aquisicao'")) {
                JOptionPane.showMessageDialog(null, "data invalida");
            } else if (e.getMessage().contains("for key 'equipamento.PRIMARY")) {
                JOptionPane.showMessageDialog(null, "id em uso");
            } else if (e.getMessage().contains("Cannot add or update a child row: a foreign key constraint fails")) {
                JOptionPane.showMessageDialog(null, "id do laboratorio não existe");
            } else if (e.getMessage().contains("for key 'equipamento.numero_serie'")) {
                JOptionPane.showMessageDialog(null, " N.º de serie em uso");
            } else {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
                
            }
            
        }

    }
}
