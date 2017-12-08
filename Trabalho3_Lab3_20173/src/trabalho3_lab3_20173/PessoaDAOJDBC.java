/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3_lab3_20173;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RianAlves
 */
public class PessoaDAOJDBC implements PessoaDAO{
    private Connection conexao;
    private PreparedStatement operacaoInsere;
    private PreparedStatement operacaoListar;
    private PreparedStatement operacaoListaId;

    public PessoaDAOJDBC() throws Exception{
        conexao = config.getConnection();
        operacaoInsere = conexao.prepareStatement("INSERT INTO pessoa(nome, email) VALUES(?,?)");
        operacaoListar = conexao.prepareStatement("SELECT nome, email FROM pessoa");
        operacaoListaId = conexao.prepareStatement("SELECT id FROM pessoa WHERE nome = ?");
    }

    @Override
    public void cria(Pessoa p) throws Exception {
        operacaoInsere.clearParameters();
        operacaoInsere.setString(1, p.getNome());
        operacaoInsere.setString(2, p.getEmail());
        operacaoInsere.executeUpdate();
    }

    @Override
    public List<Pessoa> listaTodas() throws Exception {
        List<Pessoa> pessoas = new ArrayList<>();
        operacaoListar.clearParameters();
        ResultSet resultado = operacaoListar.executeQuery();
        while (resultado.next()) {
            Pessoa p = new Pessoa();
            p.setNome(resultado.getString(1));
            p.setEmail(resultado.getString(2));
            pessoas.add(p);
        }
        return pessoas;
    }

    @Override
    public int listaId(Pessoa p) throws Exception {
        int id = -1;
        operacaoListaId.clearParameters();
        operacaoListaId.setString(1, p.getNome());
        ResultSet resultado = operacaoListaId.executeQuery();
        while (resultado.next()) {
            id = resultado.getInt(1);
        }  
        System.out.print(id);
        return id;
    }
    
    
}
