package trabalho3_lab3_20173;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabriel
 */
public class TarefaPessoaDAOJDBC implements TarefaPessoaDAO{
    private Connection conexao;
    private PreparedStatement operacaoInsereRelacao;

    public TarefaPessoaDAOJDBC() throws Exception {
        conexao = config.getConnection();
        operacaoInsereRelacao = conexao.prepareStatement("INSERT INTO tarefa_pessoa(id_pessoa, id_tarefa) VALUES(?,?)");        
    }

    
    
    @Override
    public void relacionaTP(int f, int p) throws Exception {
        operacaoInsereRelacao.clearParameters();
        operacaoInsereRelacao.setInt(1, p);
        operacaoInsereRelacao.setInt(2, f);
        operacaoInsereRelacao.executeUpdate();
    }
    
}
