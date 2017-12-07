/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3_lab3_20173;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author gabriel
 */
public class TarefaDAOJDBC implements TarefaDAO{
    private Connection conexao;
    private PreparedStatement operacaoInsere;
    private PreparedStatement operacaoListar;
    private PreparedStatement operacaoAtualizar;
    private PreparedStatement operacaoEdita;
    private PreparedStatement operacaoExcluir;

    public TarefaDAOJDBC() throws Exception {
        conexao = config.getConnection();
        operacaoInsere = conexao.prepareStatement("INSERT INTO tarefa(nome, descricao, dataIncial, dataFinal, percentual, estado) VALUES(?,?,?,?,?,?)");
        operacaoListar = conexao.prepareStatement("SELECT nome, estado FROM tarefa");
        operacaoAtualizar = conexao.prepareStatement("UPDATE tarefa SET estado = ? WHERE nome = ?");
        operacaoEdita = conexao.prepareStatement("UPDATE tarefa SET dataIncial = ?, dataFinal = ?,  percentual = ? WHERE nome = ?");
        operacaoExcluir = conexao.prepareStatement("DELETE FROM tarefa WHERE nome = ?");
    }

    @Override
    public void cria(Tarefa taf) throws Exception {
        operacaoInsere.clearParameters();
        operacaoInsere.setString(1, taf.getNome());
        operacaoInsere.setString(2, taf.getDescricao());
        operacaoInsere.setDate(3, (Date) taf.getDataInicial());
        operacaoInsere.setDate(4, (Date) taf.getDataFinal());
        operacaoInsere.setFloat(5, taf.getPercentual());
        operacaoInsere.setString(6, taf.getEstado());
        operacaoInsere.executeUpdate();
    }

    @Override
    public List<Tarefa> listaTodas() throws Exception {
        List<Tarefa> tarefas = new ArrayList<>();
        operacaoListar.clearParameters();
        ResultSet resultado = operacaoListar.executeQuery();
        while (resultado.next()) {
            Tarefa p = new Tarefa();
            p.setNome(resultado.getString(1));
            p.setEstado(resultado.getString(2));
            tarefas.add(p);
        }
        return tarefas;
    }

    @Override
    public void alteraStatus(String estado, Tarefa f) throws Exception {
       operacaoAtualizar.clearParameters();
       operacaoAtualizar.setString(1, estado);
       operacaoAtualizar.setString(2, f.getNome());
       operacaoAtualizar.executeUpdate();
    }

    @Override
    public void editaTarefa(Tarefa f) throws Exception {
        operacaoEdita.clearParameters();
        operacaoEdita.setDate(1, (Date) f.getDataInicial());
        operacaoEdita.setDate(2, (Date) f.getDataFinal());
        operacaoEdita.setFloat(3, f.getPercentual());
        operacaoEdita.setString(4, f.getNome());
        operacaoEdita.executeUpdate();
    }

    @Override
    public void excluiTarefa(Tarefa f) throws Exception {
        operacaoExcluir.clearParameters();
        operacaoExcluir.setString(1, f.getNome());
        operacaoExcluir.executeUpdate();
    }
    
}