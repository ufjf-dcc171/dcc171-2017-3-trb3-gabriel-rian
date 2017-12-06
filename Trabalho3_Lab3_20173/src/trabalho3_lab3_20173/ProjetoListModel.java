/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3_lab3_20173;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
/**
 *
 * @author gabriel
 */
public class ProjetoListModel  implements ListModel<Projeto> {
    private final List<Projeto> projetos;
    private final List<ListDataListener> dataListeners; 

    public ProjetoListModel(List<Projeto> projeto) {
        this.projetos = projeto;
        this.dataListeners = new ArrayList<>();
    }
    
    @Override
    public int getSize() {
        return projetos.size();
    }

    @Override
    public Projeto getElementAt(int index) {
        return projetos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        this.dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        this.dataListeners.remove(l);
    }
}