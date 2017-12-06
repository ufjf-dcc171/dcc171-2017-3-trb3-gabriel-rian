/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trab_lab3_20173;

import java.util.ArrayList;
import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author RianAlves
 */
public class TarefaListModel implements ListModel<Tarefa> {
    private final List<Tarefa> tarefa;
    private final List<ListDataListener> dataListeners; 

    public TarefaListModel(List<Tarefa> tarefas) {
        this.tarefa = tarefas;
        this.dataListeners = new ArrayList<>();
    }
    
    @Override
    public int getSize() {
        return tarefa.size();
    }

    @Override
    public Tarefa getElementAt(int index) {
        return tarefa.get(index);
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
