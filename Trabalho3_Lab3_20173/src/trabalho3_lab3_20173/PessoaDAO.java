/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_lab3_20173;
import java.util.List;
/**
 *
 * @author RianAlves
 */
public interface PessoaDAO {
    public void cria(Pessoa p) throws Exception;
    public List<Pessoa> listaTodas() throws Exception;
}
