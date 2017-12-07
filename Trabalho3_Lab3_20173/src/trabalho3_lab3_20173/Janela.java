/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho3_lab3_20173;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author gabriel
 */
public class Janela extends JFrame {
    
    private ArrayList<Projeto> arrayProjetos = new ArrayList<>();
    private ArrayList<Pessoa> arrayPessoa = new ArrayList<>();
    private ArrayList<Tarefa> arrayTarefa = new ArrayList<>();
    
    private final JList lstProjeto = new JList();
    private final JList lstPessoa = new JList();
    private final JList lstTarefa = new JList();
    
    private final JScrollPane scpTarefa = new JScrollPane(lstTarefa);
    private final JScrollPane scpProjeto = new JScrollPane(lstProjeto);
    private final JScrollPane scpPessoa = new JScrollPane(lstPessoa);
    
    private final JLabel lbPessoa = new JLabel("Pessoas");
    private final JLabel lbProjetos = new JLabel("Projetos");
    private final JLabel lbTarefas = new JLabel("Tarefas");
    
    private final JLabel lbTarefa = new JLabel("Tarefa");
    private final JLabel lbDescricaoTarefa = new JLabel("Descricao");
    private final JLabel lbDataInicialTarefa = new JLabel("Data Abertura (yyyy-mm-dd)");
    private final JLabel lbDataFinalTarefa = new JLabel("Data Final (yyyy-mm-dd)");
    private final JLabel lbPercenturalTarefa = new JLabel("Percentual");
    private final JLabel lbNomeProj = new JLabel("Nome");
    private final JLabel lbDataInicialProj = new JLabel("Data Inicial (yyyy-mm-dd)");
    private final JLabel lbDataFinalProj = new JLabel("Data Final (yyyy-mm-dd)");
    private final JLabel lbStatus = new JLabel("Status");
    private final JLabel lbDescricaoProj = new JLabel("Descricao");
    private final JLabel lbTaf = new JLabel("Gerenciamento de Tarefa");
    private final JLabel lbProj = new JLabel("Gerenciamento de Projeto");
    private final JLabel lbControle = new JLabel("Controle");
    private final JLabel lbBanco = new JLabel("Status - Banco de Dados");
    
    private final JTextField txtNomeTarefa = new JTextField();
    private final JTextField txtBancoDados = new JTextField();
    private final JTextField txtDescricaoTarefa = new JTextField();
    private final JTextField txtDataIncialTarefa = new JTextField();
    private final JTextField txtDataFinalTarefa = new JTextField();
    private final JTextField txtPercentualTarefa = new JTextField();
    
    private final JTextField txtNomeProj = new JTextField();
    private final JTextField txtDataInicialProjeto = new JTextField();
    private final JTextField txtDataFinalProjeto = new JTextField();
    private final JTextField txtDescricaoProjeto = new JTextField();
    private final JTextField txtStatusProjeto = new JTextField();
    
    private final JButton btnAdicionaPessoa = new JButton("Adicionar Pessoa");
    private final JButton btnAdicionaTarefa = new JButton("Adicionar Tarefa");
    private final JButton btnAdicionaProjeto = new JButton("Adicionar Projeto");
    private final JButton btnStatus = new JButton("Alterar Situação Tarefa");
    private final JButton btnEditaTarefa = new JButton("Editar Tarefa");
    
    private final JPanel pnlLista = new JPanel();
    private final JPanel pnlLabels = new JPanel();
    private final JPanel pnlBotoes = new JPanel();
    private final JPanel pnlComponentes = new JPanel();
    private final JPanel pnlComponentesProj = new JPanel();
    private final JPanel pnlPrincipal = new JPanel();
    private final JPanel pnlAcao = new JPanel();
    
    private final carregaDadosBanco dadosBD;
    
    public Janela() throws HeadlessException, Exception{
        setLayout(new BorderLayout());
        //---------------------------------Tela-----------------------------------------------------------------------
        
        lbPessoa.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lbProjetos.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lbTarefas.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lbTaf.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lbProj.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lbControle.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        lbBanco.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        
        pnlLabels.setLayout(new GridLayout(1,3));
        pnlLista.setLayout(new GridLayout(1,3));
        pnlComponentes.setLayout(new GridLayout(11,1));
        pnlComponentesProj.setLayout(new GridLayout(11,1));
        pnlAcao.setLayout(new GridLayout(1,3));
        pnlBotoes.setLayout(new GridLayout(8,1));
        pnlPrincipal.setLayout(new BorderLayout());
        
        
        pnlLabels.add(lbPessoa);
        pnlLabels.add(lbProjetos);
        pnlLabels.add(lbTarefas);
  
        pnlLista.add(scpPessoa);
        pnlLista.add(scpProjeto);
        pnlLista.add(scpTarefa);
        

        pnlComponentes.add(lbTaf);
        pnlComponentes.add(lbTarefa);
        pnlComponentes.add(txtNomeTarefa);
        pnlComponentes.add(lbDescricaoTarefa);
        pnlComponentes.add(txtDescricaoTarefa);
        pnlComponentes.add(lbDataInicialTarefa);
        pnlComponentes.add(txtDataIncialTarefa);
        pnlComponentes.add(lbDataFinalTarefa);
        pnlComponentes.add(txtDataFinalTarefa);
        pnlComponentes.add(lbPercenturalTarefa);
        pnlComponentes.add(txtPercentualTarefa);
        
        pnlBotoes.add(lbControle);
        pnlBotoes.add(btnAdicionaPessoa);
        pnlBotoes.add(btnAdicionaTarefa);
        pnlBotoes.add(btnAdicionaProjeto);
        pnlBotoes.add(btnStatus);
        pnlBotoes.add(btnEditaTarefa);
        pnlBotoes.add(lbBanco);
        pnlBotoes.add(txtBancoDados);
        
        pnlComponentesProj.add(lbProj);
        pnlComponentesProj.add(lbNomeProj);
        pnlComponentesProj.add(txtNomeProj);
        pnlComponentesProj.add(lbDescricaoProj);
        pnlComponentesProj.add(txtDescricaoProjeto);
        pnlComponentesProj.add(lbDataInicialProj);
        pnlComponentesProj.add(txtDataInicialProjeto);
        pnlComponentesProj.add(lbDataFinalProj);
        pnlComponentesProj.add(txtDataFinalProjeto);
        pnlComponentesProj.add(lbStatus);
        pnlComponentesProj.add(txtStatusProjeto);
        
        pnlAcao.add(pnlComponentes);
        pnlAcao.add(pnlBotoes);
        pnlAcao.add(pnlComponentesProj);
        
        pnlPrincipal.add(pnlLabels, BorderLayout.NORTH);
        pnlPrincipal.add(pnlLista, BorderLayout.CENTER);
        pnlPrincipal.add(pnlAcao, BorderLayout.SOUTH);
        add(pnlPrincipal);
        
        if(config.getConnection().isClosed()){
            txtBancoDados.setText("Conexão não estabelecida com o banco de dados. Rever configurações!");
        }else{
            txtBancoDados.setText("Conexão estabelecida com o banco de dados. Tudo Pronto!");
        }
        
        //----------------------Finalizaçao do Layout---------------------------------------------------------------
        
        //----------------------Controle ScrollPane e Arrays---------------------------------------------------------
        
        dadosBD = new carregaDadosBanco();
        arrayPessoa = dadosBD.getListaPessoa();
        arrayProjetos = dadosBD.getListaProjetos();
        arrayTarefa = dadosBD.getListaTarefa();
        
        lstPessoa.setModel(new PessoaListModel(arrayPessoa));
        lstProjeto.setModel(new ProjetoListModel(arrayProjetos));
        lstTarefa.setModel(new TarefaListModel(arrayTarefa));
        
        lstPessoa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstProjeto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstTarefa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //-------------------------------Acoes Botoes----------------------------------------------------------------
        
       btnAdicionaTarefa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TarefaDAO dao = new TarefaDAOJDBC();
                    Tarefa f = new Tarefa();
                    f.setNome(txtNomeTarefa.getText());
                    f.setDescricao(txtDescricaoTarefa.getText());
                    f.setDataInicial(Date.valueOf(txtDataIncialTarefa.getText()));
                    f.setDataFinal(Date.valueOf(txtDataFinalTarefa.getText()));
                    f.setPercentual(Float.parseFloat(txtPercentualTarefa.getText()));
                    f.setEstado("Pendente");
                    arrayTarefa.add(f);
                    lstTarefa.updateUI();
                    dao.cria(f);
                    limpaCampos();
                } catch (Exception ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } );
       
        btnAdicionaProjeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ProjetoDAO dao = new ProjetoDAOJDBC();
                    Projeto p = new Projeto();
                    Pessoa person = (Pessoa) lstPessoa.getSelectedValue();
                    p.setNome(txtNomeProj.getText());
                    p.setDataAbertura(Date.valueOf(txtDataInicialProjeto.getText()));
                    p.setDataEncerramento(Date.valueOf(txtDataFinalProjeto.getText()));
                    p.setDescricao(txtDescricaoProjeto.getText());
                    arrayProjetos.add(p);
                    lstProjeto.updateUI();
                    dao.criar(p, person);
                    limpaCampos();
                } catch (Exception ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnAdicionaPessoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PessoaDAO dao = new PessoaDAOJDBC();
                    Pessoa p = new Pessoa();
                    String nome = JOptionPane.showInputDialog("Nome: ");
                    String email = JOptionPane.showInputDialog("Email: ");
                    if(!nome.isEmpty() && !email.isEmpty()){
                        p.setNome(nome);
                        p.setEmail(email);
                        arrayPessoa.add(p);
                        lstPessoa.updateUI();
                        dao.cria(p);
                        limpaCampos();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btnEditaTarefa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    TarefaDAO dao = new TarefaDAOJDBC();
                    Tarefa taf = (Tarefa) lstTarefa.getSelectedValue();
                    String estado = JOptionPane.showInputDialog("Estado da tarefa (Pendente, Fazendo ou Concluida): ");
                    dao.alteraStatus(estado, taf);
                } catch (Exception ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        btnEditaTarefa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
       //---------------------------------------Fim Acoes Botoes---------------------------------------------------------
       
       //------------------------------------------Incio Controle Listas-------------------------------------------------
       
       lstTarefa.addMouseListener(new MouseAdapter() {    
           @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 1){
                    Tarefa taf = (Tarefa) lstTarefa.getSelectedValue();
                    txtNomeTarefa.setText(taf.getNome());
                    txtNomeTarefa.setEnabled(false);
                    txtDescricaoTarefa.setText(taf.getDescricao());
                    txtDataIncialTarefa.setText(taf.getDataInicial().toString());
                    txtDataFinalTarefa.setText(taf.getDataFinal().toString());
                    txtPercentualTarefa.setText(String.valueOf(taf.getPercentual()));
                }
            }
        });
    }
    
    public void limpaCampos(){
        txtDataFinalProjeto.setText("");
        txtDataFinalTarefa.setText("");;
        txtDataIncialTarefa.setText("");;
        txtDataInicialProjeto.setText("");
        txtDescricaoProjeto.setText("");
        txtDescricaoTarefa.setText("");
        txtNomeProj.setText("");
        txtNomeTarefa.setText("");
        txtPercentualTarefa.setText("");
        txtStatusProjeto.setText("");
    }
}
