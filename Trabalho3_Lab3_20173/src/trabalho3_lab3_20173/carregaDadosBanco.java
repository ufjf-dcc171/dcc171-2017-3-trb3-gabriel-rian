/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3_lab3_20173;

import java.util.ArrayList;

/**
 *
 * @author RianAlves
 */
public class carregaDadosBanco {
    private ArrayList<Projeto> listaProjetos = new ArrayList<>();
    private ArrayList<Tarefa> listaTarefa = new ArrayList<>();
    private ArrayList<Pessoa> listaPessoa = new ArrayList<>();

    public carregaDadosBanco() throws Exception {
        ProjetoDAO daoProj = new ProjetoDAOJDBC();
        TarefaDAO daoTarefa = new TarefaDAOJDBC();
        PessoaDAO daoPessoa = new PessoaDAOJDBC();
        
        this.listaPessoa = (ArrayList<Pessoa>) daoPessoa.listaTodas();
        this.listaProjetos = (ArrayList<Projeto>) daoProj.listarTodos();
        this.listaTarefa = daoTarefa.listaTodas();
    }

    public ArrayList<Projeto> getListaProjetos() {
        return listaProjetos;
    }

    public void setListaProjetos(ArrayList<Projeto> listaProjetos) {
        this.listaProjetos = listaProjetos;
    }

    public ArrayList<Tarefa> getListaTarefa() {
        return listaTarefa;
    }

    public void setListaTarefa(ArrayList<Tarefa> listaTarefa) {
        this.listaTarefa = listaTarefa;
    }

    public ArrayList<Pessoa> getListaPessoa() {
        return listaPessoa;
    }

    public void setListaPessoa(ArrayList<Pessoa> listaPessoa) {
        this.listaPessoa = listaPessoa;
    }
    
    
    
    
}
