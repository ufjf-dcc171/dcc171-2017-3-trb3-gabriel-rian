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

    public TarefaDAOJDBC() throws Exception {
        conexao = config.getConnection();
        operacaoInsere = conexao.prepareStatement("INSERT INTO tarefa(nome, descricao, dataIncial, dataFinal, percentual) VALUES(?,?,?,?,?)");
        operacaoListar = conexao.prepareStatement("SELECT nome FROM tarefa");

    }

    @Override
    public void cria(Tarefa taf){
        try {
            operacaoInsere.clearParameters();
            operacaoInsere.setString(1, taf.getNome());
            operacaoInsere.setString(2, taf.getDescricao());
            operacaoInsere.setDate(3, (Date) taf.getDataInicial());
            operacaoInsere.setDate(4, (Date) taf.getDataFinal());
            operacaoInsere.setFloat(5, taf.getPercentual());
            operacaoInsere.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TarefaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public ArrayList<Tarefa> listaTodas()  {
       try {  
            ArrayList<Tarefa> tarefas = new ArrayList<>();
            operacaoListar.clearParameters();
            ResultSet resultado = operacaoListar.executeQuery();
            while (resultado.next()) {
                Tarefa p = new Tarefa();
                p.setNome(resultado.getString(1));
                tarefas.add(p);
            }
            return tarefas;
        }catch(SQLException ex) {
            Logger.getLogger(TarefaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
}