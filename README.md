Nome: Gabriel dos Santos Nascimento 201376133
      Rian das Dores Alves 201676040

Curso: Sistemas de Informação - UFJF

Implementação de um Sistema de Gerenciamento de Projeto, Tarefa e Pessoal
------------------------------------------------------------------------------------------------------------------------------
Modelagem de dados

    Utilizacao de interfaces DAO para tarefas, projetos e pessoa, tarefaRequisito e tarefa_pessoa.
    Para comunicaço com usuário foi utilizado JList que retornam o objeto requerido e o mesmo é buscado e/ou tratado no bando 
    de dados para o fim requerido.
    Para controle das listas de tarefas, pessoas e projetos foi necessária a implementação de ListModel para tratar e retornar
o objeto requerido.
    Foi criada uma classe para conexão com o banco de dados que retorna uma instância, informação esta utilizada pelas classes
DAOJDBC.
    Foi implementada também uma classe responsável por fazer a leitura das informações gravadas no banco de dados, tirando esta
responsabilidade do resto da aplicação.    
    Utilizacao de classes DAOJDBC para implementação de funcões que se comunicam com o banco de dados e com as ações 
    do usuário. (camada de modelo)
    Métodos são buscados através do nome, visto o index do arrayList difere do id (primary key do banco de dados).
    
    Link do MER do Banco de Dados: https://drive.google.com/open?id=1g4VRKjS3zNz3ZMdhbSwxisvGbzNSZhEs
    
------------------------------------------------------------------------------------------------------------------------------    
 
 Melhorias Futuras
 
    Melhoria na interface, visto que a mesma ainda dispõe de um layout fraco do ponto de vista de aplicações que realizam ou 
tratam esta ideia proposta pelo trabalho.
    Otimização das consultas feitas ao banco de dados.
    Implementação de rotinas que gerem relatórios a respeito dos dados gravados no banco de dados.
    Criação de funções que avisem e gerem mensagens de avisos caso uma tarefa fique fora de prazo.
    Mudança de componentes JTextField para JComboBox para otimizar o tempo de criação de tarefas/projetos.
    Criação de uma categoria para filtrar tarefas de um determinado tipo
    
    
    
      
