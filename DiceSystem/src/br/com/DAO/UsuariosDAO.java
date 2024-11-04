package br.com.DAO;

import br.com.DTO.UsuariosDTO;
import br.com.views.TelaPrincipal;
import br.com.views.TelaUsuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UsuariosDAO {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void limpar() {
        TelaUsuarios.txtNome.setText(null);
        TelaUsuarios.txtEmail.setText(null);
        TelaUsuarios.txtLogin.setText(null);
        TelaUsuarios.txtSenha.setText(null);
        TelaUsuarios.txtId.setText(null);

    }

    public int criarELogar(UsuariosDTO dto) {
        String sql = "insert into usuarios(nome, email, login, senha) values(?, ?, ?, ?)";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, dto.getNome());
            pst.setString(2, dto.getEmail());
            pst.setString(3, dto.getLogin());
            pst.setString(4, dto.getSenha());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Conta criada");
                TelaPrincipal pri = new TelaPrincipal();
                pri.setVisible(true);
                TelaPrincipal.lblTipo.setText("Perfil: Estagiario");
                TelaPrincipal.btnEdUsu.setEnabled(false);
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            if (e.getMessage().contains("for key 'usuarios.login_UNIQUE'")) {
                JOptionPane.showMessageDialog(null, "nome de usuario ja em uso");
                return 0;
            } else if (e.getMessage().contains("for key 'usuarios.email_UNIQUE'")) {
                JOptionPane.showMessageDialog(null, "Email ja em uso");
                return 0;
            } else {
                JOptionPane.showMessageDialog(null, "metodo criar " + e);
                return 0;
            }
        }

    }

    public int logar(UsuariosDTO dto) {
        String sql = "select * from usuarios where login = ? and senha = ? and email = ?";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);

            pst.setString(1, dto.getLogin());
            pst.setString(2, dto.getSenha());
            pst.setString(3, dto.getEmail());

            rs = pst.executeQuery();

            if (rs.next()) {
                TelaPrincipal pri = new TelaPrincipal();
                pri.setVisible(true);
                if (rs.getString(6).contains("estagiario")) {
                    TelaPrincipal.lblTipo.setText("Pefil: Estagiario");
                    TelaPrincipal.btnEdUsu.setEnabled(false);
                } else if (rs.getString(6).contains("tecnico")) {
                    TelaPrincipal.lblTipo.setText("Pefil: Técnico");
                    TelaPrincipal.btnEdUsu.setEnabled(false);
                } else if (rs.getString(6).contains("professor")) {
                    TelaPrincipal.lblTipo.setText("Pefil: Professor");
                    TelaPrincipal.btnEdUsu.setEnabled(false);
                }
                return 1;
            } else {
                JOptionPane.showMessageDialog(null, "Nome de usuario, senha ou email incorretos");
                return 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "metodo logar: " + e.getMessage());
            return 0;
        }
    }

    public void criar(UsuariosDTO dto) {
        String sql = "insert into usuarios (id_usuario, nome, email, login, senha, perfil) values(?, ?, ?, ?, ?, ?)";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);

            pst.setInt(1, dto.getId());
            pst.setString(2, dto.getNome());
            pst.setString(3, dto.getEmail());
            pst.setString(4, dto.getLogin());
            pst.setString(5, dto.getSenha());
            pst.setString(6, dto.getTipo());

            int add = pst.executeUpdate();

            if (add > 0) {
                JOptionPane.showMessageDialog(null, "Adicionado com sucesso");
                limpar();
            }
        } catch (Exception e) {
            if (e.getMessage().contains("for key 'usuarios.PRIMARY'")) {
                JOptionPane.showMessageDialog(null, "ID ja em uso");
            } else if (e.getMessage().contains("for key 'usuarios.login_UNIQUE'")) {
                JOptionPane.showMessageDialog(null, "nome de usuario ja em uso");
            } else if (e.getMessage().contains("for key 'tb_usuarios.email_UNIQUE'")) {
                JOptionPane.showMessageDialog(null, "Email ja em uso");
            } else {
                JOptionPane.showMessageDialog(null, "metodo criar " + e);

            }
        }

    }

    public void pesquisar(UsuariosDTO dto) {
        String sql = "select * from usuarios where id_usuario = ?";
        conexao = ConexaoDAO.connector();

        try {
            pst = conexao.prepareStatement(sql);

            pst.setInt(1, dto.getId());

            rs = pst.executeQuery();

            if (rs.next()) {
                TelaUsuarios.txtNome.setText(rs.getString(2));
                TelaUsuarios.txtEmail.setText(rs.getString(3));
                TelaUsuarios.txtSenha.setText(rs.getString(4));
                TelaUsuarios.txtLogin.setText(rs.getString(5));

                if (rs.getString(6).contains("estagiario")) {
                    TelaUsuarios.boxTipo.setSelectedItem("Estagiario");
                } else if (rs.getString(6).contains("administrador")) {
                    TelaUsuarios.boxTipo.setSelectedItem("Administrador");
                } else if (rs.getString(6).contains("tecnico")) {
                    TelaUsuarios.boxTipo.setSelectedItem("Técnico");
                } else if (rs.getString(6).contains("professor")) {
                    TelaUsuarios.boxTipo.setSelectedItem("Professor");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario não cadastrado");
            }

        } catch (Exception e) {

        }
    }

    public void deletar(UsuariosDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "quer mesmo deletar o usuario com este ID?", null, JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "delete from usuarios where id_usuario = ?";
            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);
                pst.setInt(1, dto.getId());

                int go = pst.executeUpdate();

                if (go > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso");
                    limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario não cadastrado");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public void editar(UsuariosDTO dto) {
        int res = JOptionPane.showConfirmDialog(null, "quer mesmo atualizar o usuario com este ID?", null, JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            String sql = "update usuarios set nome = ?, email = ?, login = ?, senha = ?, perfil = ? where id_usuario = ?";
            conexao = ConexaoDAO.connector();

            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, dto.getNome());
                pst.setString(2, dto.getEmail());
                pst.setString(3, dto.getLogin());
                pst.setString(4, dto.getSenha());
                pst.setString(5, dto.getTipo());
                pst.setInt(6, dto.getId());
                
                int add = pst.executeUpdate();
                
                if (add > 0){
                    JOptionPane.showMessageDialog(null, "editado com sucesso");
                    limpar();
                }

            } catch (Exception e) {
                if (e.getMessage().contains("for key 'usuarios.login_UNIQUE'")) {
                JOptionPane.showMessageDialog(null, "nome de usuario / login ja em uso");
            } else if (e.getMessage().contains("for key 'tb_usuarios.email_UNIQUE'")) {
                JOptionPane.showMessageDialog(null, "Email ja em uso");
            } else {
                JOptionPane.showMessageDialog(null, "metodo criar " + e);

            }
            }
        }
    }

}
