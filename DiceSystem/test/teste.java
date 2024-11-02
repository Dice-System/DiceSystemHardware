
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Leon
 */
public class teste {
    
    public static void main(String[] args) {
        
        String[] opcoes = {"Equipamento", "Nome do laboratorio"};
        
        int escolha = JOptionPane.showOptionDialog(null, "Oque quer pesquisar?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.DEFAULT_OPTION, null, opcoes, opcoes[0]);
        
    }
    
}
