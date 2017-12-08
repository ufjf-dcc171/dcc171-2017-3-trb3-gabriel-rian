/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3_lab3_20173;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Gabriel
 */
public class TarefaRequisitoDAOJDBC implements TarefaRequisitoDAO{
    private Connection conexao;
    private PreparedStatement operacaoInsereRelacao;

    public TarefaRequisitoDAOJDBC() throws Exception {
        conexao = config.getConnection();
        operacaoInsereRelacao = conexao.prepareStatement("INSERT INTO tarefa_requisito(id_tarefaa, id_tarefar) VALUES(?,?)");        
    }
    
    @Override
    public void tarefaRequisito(int tarefa, int requisito) throws Exception {
        operacaoInsereRelacao.clearParameters();
        operacaoInsereRelacao.setInt(1, tarefa);
        operacaoInsereRelacao.setInt(2, requisito);
    }
    
}
