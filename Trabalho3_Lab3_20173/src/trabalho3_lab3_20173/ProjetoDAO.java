/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3_lab3_20173;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface ProjetoDAO {
    public void criar(Projeto proj, Pessoa p) throws Exception;
    public List<Projeto> listarTodos() throws Exception;
    public Projeto listaProj(int id) throws Exception;
    public int buscaIdColab(Pessoa nome) throws Exception;
}
