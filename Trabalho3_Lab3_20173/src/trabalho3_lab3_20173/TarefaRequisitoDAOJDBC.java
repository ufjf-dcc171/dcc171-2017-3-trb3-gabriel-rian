/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3_lab3_20173;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Gabriel
 */
public class TarefaRequisitoDAOJDBC implements TarefaRequisitoDAO{
    private Connection conexao;
    private PreparedStatement operacaoInsereRelacao;
    private PreparedStatement operacaoBuscaEstado;
    private PreparedStatement operacaoBuscaIdTarefaR;
    private PreparedStatement operacaoBuscaIdTarefa;

    public TarefaRequisitoDAOJDBC() throws Exception {
        conexao = config.getConnection();
        operacaoInsereRelacao = conexao.prepareStatement("INSERT INTO tarefa_requisito(id_tarefaa, id_tarefar) VALUES(?,?)");        
        operacaoBuscaEstado = conexao.prepareStatement("SELECT estado FROM tarefa WHERE id = ?");        
        operacaoBuscaIdTarefaR = conexao.prepareStatement("SELECT id_tarefar FROM tarefa_requisito WHERE id_tarefaa = ?");        
        operacaoBuscaIdTarefa = conexao.prepareStatement("SELECT id FROM tarefa WHERE nome = ?");        
    }
    
    @Override
    public void tarefaRequisito(int tarefa, int requisito) throws Exception {
        operacaoInsereRelacao.clearParameters();
        operacaoInsereRelacao.setInt(1, tarefa);
        operacaoInsereRelacao.setInt(2, requisito);
        operacaoInsereRelacao.executeUpdate();
    }

    @Override
    public boolean tarefaAlteraEstado(Tarefa atual) throws Exception {
        int idTarefaAtual = -1;
        int idTarefaRequisito = -1;
        String estado = " ";
        String estadoEsperado = "Concluida";
        operacaoBuscaIdTarefa.clearParameters();
        operacaoBuscaIdTarefa.setString(1, atual.getNome());
        ResultSet resultado = operacaoBuscaIdTarefa.executeQuery();
        while (resultado.next()) {
            idTarefaAtual = resultado.getInt(1);
        }
        operacaoBuscaIdTarefaR.clearParameters();
        operacaoBuscaIdTarefaR.setInt(1, idTarefaAtual);
        ResultSet resultado2 = operacaoBuscaIdTarefaR.executeQuery();
        while (resultado.next()) {
            idTarefaRequisito = resultado.getInt(1);
        }
        operacaoBuscaEstado.clearParameters();
        operacaoBuscaEstado.setInt(1, idTarefaRequisito);
        ResultSet resultado3 = operacaoBuscaEstado.executeQuery();
        while (resultado.next()) {
            estado = resultado.getString(1);
        }
        if(estado.equals(estadoEsperado)){
            return true;
        }else{
            return false;
        }
    }
    
}
