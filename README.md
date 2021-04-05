# Grupo1-Biblioteca

Para iniciar será necessário o Cadastro contendo oscampos, Id, Nome, CPF, Email, Telefone,Login, Senha

O campo login pode conter caracteres que representamcpf, telefone ou apelido com até 20caracteres

Não poderá ser duplicado os campos cpf e login nabase de dados

Para o cadastro deverá ter o seu endereço atravésuma tabela de endereço com os campos:Id, Cep, Logradouro, Numero, Bairro, Localidade, Uf,IBGE.

Será necessário também cadastrar os livros com oscampos: Id, ISBN, Titulo, Valor da Diaria,Número de exemplares do livro e Número dos exemplares reservados.

Para realizar a locação deverá armazenar as informaçõesabaixo: Id, Data Agendamento, DataRetirada, Data Finalizacao,  Valor Total e o StatusLocação(RESERVADA, EFETIVADA,FINALIZADA

Como será possivel retirar mais de um livro em cadaLocação, deverá registrar estes livrosselecionados incluindo os campos: Data Previsao Entrega,Data Entrega, Numero de diarias(data entrega - data retirada), Valor Diaria, ValorLocação(valor diaria * diarias





![WhatsApp Image 2021-04-05 at 14 39 02](https://user-images.githubusercontent.com/77279633/113605254-c8f9d900-961c-11eb-9d56-18dcf3d130c8.jpeg)


### Funcionamento da API

Consiste no aluguél de livros , onde livro é definido como uma entidade e é vinculado à locação e ao cliente, definido na classe de cadastro.
No pacote de "services" na classe LocacaoService, é definido a regra de negócio, assim como o lançamento de exceções para gerir a locação corretamente, o vinculo acontece com
o cadastro quando ele está no banco de dados caso contrário lançará a exceção, essa classe também é responsável pelos cálculos realizados para atribuir valor e status da locação,
e no final adiciona a uma lista a locação juntamente com o Id do cadastro e do livro adicionado a esta.

A classe Endereco, no pacote "model" consome uma API, onde é colocado apenas o CEP do cliente e retorna todos os dados, autopreenchendo os campos, vinculado à classe Cadastro do mesmo pacote.

#### REFERÊNCIAS

https://www.devmedia.com.br/forum/crud-em-java-poo-apenas-sugestoes-de-melhorias/605391

https://www.clubedohardware.com.br/topic/1394643-chamar-metodo-dentro-de-construtor/

https://giuliana-bezerra.medium.com/gerenciando-dependencias-com-o-mavem-em-projetos-java-6703fce91fb6

https://arthur-almeida.medium.com/consumindo-uma-api-de-maneira-simples-com-java-2a386010e4b9

https://www.oracle.com/br/technical-resources/article/java/erros-java-exceptions.html

