/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3_lab3_20173;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class ProjetoDAOJDBC implements ProjetoDAO{
    
    private Connection conexao;
    private PreparedStatement operacaoInsere;
    private PreparedStatement operacaoListar;
    private PreparedStatement operacaoListarTodos;
    private PreparedStatement operacaoBuscaIdPessoa;

    public ProjetoDAOJDBC() throws Exception{
        conexao = config.getConnection();
        operacaoInsere = conexao.prepareStatement("INSERT INTO projeto(nome, id_responsavel, descricao, dataAbertura, dataFinal) VALUES(?,?,?,?,?)");
        operacaoListarTodos = conexao.prepareStatement("SELECT nome, descricao FROM projeto");
        operacaoListar = conexao.prepareStatement("SELECT nome, descricao FROM projeto WHERE id = ?");
        operacaoBuscaIdPessoa = conexao.prepareStatement("SELECT id FROM pessoa WHERE nome = ?");
    }
    
    
    @Override
    public void criar(Projeto proj, Pessoa p) throws Exception {
        operacaoInsere.clearParameters();
        operacaoInsere.setString(1, proj.getNome());
        operacaoInsere.setInt(2, buscaIdColab(p));
        operacaoInsere.setString(3, proj.getDescricao());
        operacaoInsere.setDate(4, (Date) proj.getDataAbertura());
        operacaoInsere.setDate(5, (Date) proj.getDataEncerramento());
        operacaoInsere.executeUpdate();
    }

    @Override
    public List<Projeto> listarTodos() throws Exception {
        List<Projeto> projetos = new ArrayList<>();
        operacaoListarTodos.clearParameters();
        ResultSet resultado = operacaoListarTodos.executeQuery();
        while (resultado.next()) {
            Projeto p = new Projeto();
            p.setNome(resultado.getString(1));
            p.setDescricao(resultado.getString(2));
            projetos.add(p);
        }
        return projetos;
    }

    @Override
    public Projeto listaProj(int id) throws Exception {
        Projeto p = new Projeto();
        operacaoListar.clearParameters();
        operacaoListar.setInt(1, id);
        ResultSet resultado = operacaoListar.executeQuery();
        while(resultado.next()){
            p.setNome(resultado.getString(1));
            p.setDescricao(resultado.getString(2));
        }
        return p;
    }

    @Override
    public int buscaIdColab(Pessoa p) throws Exception {
        int i = 0;
        operacaoBuscaIdPessoa.clearParameters();
        operacaoBuscaIdPessoa.setString(1, p.getNome());
        ResultSet resultado = operacaoBuscaIdPessoa.executeQuery();
        while(resultado.next()){
            i = resultado.getInt(1);
        }
        return i;
    }
    
}
