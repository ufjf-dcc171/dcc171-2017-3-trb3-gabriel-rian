Nome: Gabriel dos Santos Nascimento 201376133
      Rian das Dores Alves 201676040

Curso: Sistemas de Informação - UFJF

Implementação de um Sistema de Gerenciamento de Projeto, Tarefa e Pessoal
----------------------------------------------------------------------------------------------------------------------------
Modelagem de dados

    1-Utilizacao de interfaces DAO para tarefas, projetos e pessoa, tarefaRequisito e tarefa_pessoa.
    2-Para comunicaço com usuário foi utilizado JList que retornam o objeto requerido e o mesmo é buscado e/ou tratado no banco de dados para o fim requerido.
    3-Para controle das listas de tarefas, pessoas e projetos foi necessária a implementação de ListModel para tratar e retornaro objeto requerido.
    4-Foi criada uma classe para conexão com o banco de dados que retorna uma instância, informação esta utilizada pelas classes DAOJDBC.
    5-Foi implementada também uma classe responsável por fazer a leitura das informações gravadas no banco de dados, tirando esta responsabilidade do resto da aplicação.    
    6-Utilizacao de classes DAOJDBC para implementação de funcões que se comunicam com o banco de dados e com as ações 
    do usuário. (camada de modelo)
    7-Métodos são buscados através do nome, visto o index do arrayList difere do id (primary key do banco de dados).
----------------------------------------------------------------------------------------------------------------------------    
    Link do MER do Banco de Dados: https://drive.google.com/open?id=1g4VRKjS3zNz3ZMdhbSwxisvGbzNSZhEs
    
-----------------------------------------------------------------------------------------------------------------------------    
 
 Melhorias Futuras
 
    1-Melhoria na interface, visto que a mesma ainda dispõe de um layout fraco do ponto de vista de aplicações que realizam ou tratam esta ideia proposta pelo trabalho.
    2-Otimização das consultas feitas ao banco de dados.
    3-Implementação de rotinas que gerem relatórios a respeito dos dados gravados no banco de dados.
    4-Criação de funções que avisem e gerem mensagens de avisos caso uma tarefa fique fora de prazo.
    5-Mudança de componentes JTextField para JComboBox para otimizar o tempo de criação de tarefas/projetos.
    6-Criação de uma categoria para filtrar tarefas de um determinado tipo
    
    
    
      
