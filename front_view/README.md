# PADRÕES DE PROJETOS / LABORATÓRIO DE BANCO DE DADOS IV
## FATEC SÃO JOSÉ DOS CAMPOS - 2ºSEM/2020
### Professores
• [Emanuel Mineda Carneiro](https://github.com/mineda);<br>
• [Giuliano Araujo Bertoti](https://github.com/giulianobertoti).
### Integrantes
• [Lucas José Povinske](https://github.com/lucas-povinske);<br>
• [Otavio Augusto Raposo Barreto](https://github.com/otavio-raposo);<br>
• Rodrigo César Reis.

## 1. Apresentação
Projeto com back-end em Java e front-end em Vue.js<br>
Este projeto foi feito para as disciplinas de Padrões de Projetos e Laboratório de Banco de Dados IV, aplicando o padrão MVC;<br>

A camada VIEW foi feita em Vue.js utilizando Axios para integração com a camada CONTROLLER que retorna através de protocolo HTTP as informações do banco em MySQL na camada MODEL, estruturada com Jpa / Hibernate.<br>

Este repositório refere-se à camada VIEW do projeto;<br>
O repositório referente às camadas MODEL e CONTROLLER se encontram [neste endereço](https://github.com/rodrigocr16/mvc_model_controller).
___
## 2. Autenticação
![01_auth](https://github.com/rodrigocr16/vue-blank/blob/master/prints/01_invalid_auth.png)

A tentativa de autenticação com um usuário não cadastrado no banco resulta em uma mensagem de erro apresentada imediatamente abaixo do botão de confirmação das credenciais.
```
      login() {        
        axios.get('usuario', {
          params: { "nomeUsuario" : this.nome }, headers: { Accept: 'application/json' },
          auth: { username: this.nome, password: this.senha }
        })
        .then(res => {
          console.log(res);
          this.sucesso();
          this.clearance = res.data;
          if(this.clearance.classificacao > 0) { this.setAdmin(); }
        })
        .catch(error => {
          this.setCodErro('Usuário/senha inválido(s)!');
          console.log(error);
          switch(error.response.status){
            case 400: console.log('Bad request');
              break;
            case 401: console.log('Senha inválida!');
              break;
            case 404: console.log('Usuário não cadastrado!');
              break;
            default: this.sucesso();
            }
            this.nome = '';
            this.senha = '';
        });
      },
```
``this.setCodErro`` é uma mutation que altera a mensagem de erro para que seja exibida a mensagem que informa ao usuário que o login informado não está cadastrado, ou que a senha é inválida.
<br><br>
O usuário possuiu dois tipos de nível de autorização: Usuário ou Administrador. Isto é definido através de ``if(this.clearance.classificacao > 0)``, onde caso aquele registro possua um valor no seu atributo "Classificacao" maior que zero (somente Administradores possuem este atributo) ele é definido como Administrador.
Após o login, a página principal muda caso o usuário a logar seja ou não um administrador:
#### Login com Credenciais de Usuário:
![02_user_auth](https://github.com/rodrigocr16/vue-blank/blob/master/prints/02_user_auth.png)<br>
#### Login com Credenciais de Administrador:
![03_admin_auth](https://github.com/rodrigocr16/vue-blank/blob/master/prints/03_admin_auth.png)<br>
___
## 3. Painel de Usuários
### 3.i) Exibição
![04_usuario](https://github.com/rodrigocr16/vue-blank/blob/master/prints/04_usuario.png)<br>
O Painel de Usuários é inicializado com uma lista que exibe todos os usuários atualmente cadastrados no banco, suas senhas e seus nomes de exibição.<br>
A recuperação desta lista e sua apresentação representa o "R" da sigla CRUD - READ - e é detalhado a seguir:
```
    get(){
      axios.get('usuario', {
        params: { nomeUsuario: this.cad_usuario },
        headers: { Accept: 'application/json' },
        auth: { username: this.getUsuario, password: this.getSenha }
      })
      .then( res => {
        console.log(res);
        this.listas = res.data;
        this.cod_erro = '';
       })
      .catch(error => {
        console.log(error);
        this.erro(error.response.status);
      })
    },
```
### 3.ii) Criação
![05_cadastrar](https://github.com/rodrigocr16/vue-blank/blob/master/prints/05_cadastrar.gif)<br>
No formulário de cadastro existem três campos obrigatórios: nome do usuário, senha e nome de exibição;<br>
Estes três campos abrangem todas as informações obrigatórias para a criação de um novo cadastro no banco. O método abaixo representa o "C" da sigla CRUD - CREATE:
```
    cadastrar() {
      axios.post('/usuario', {
        nomeUsuario: this.cad_usuario,
        senha: this.cad_senha,
        nomeExibicao:this.cad_exibicao
      },
      {
        auth: { username: this.getUsuario, password: this.getSenha }
      })
      .then(res => {
        console.log(res);
        //this.listas.push(res.data);
        this.get();
      })
      .catch(error => console.log(error))
      this.cad_usuario = '';
      this.cad_senha = '';
      this.cad_exibicao = '';
    },
```
### 3.iii) Atualização
#### Atualização de Senha:
![06_alterar_senha](https://github.com/rodrigocr16/vue-blank/blob/master/prints/06_alterar_senha.gif)<br>
#### Atualização de Nome de Exibição:
![07_alterar_exibicao](https://github.com/rodrigocr16/vue-blank/blob/master/prints/07_alterar_exibicao.gif)<br>
Ao clicar no ícone de lápis em qualquer uma das linhas da tabela será feita a atualização do campo correspondente, representada pelo "U" na sigla CRUD - UPDATE;<br>
O ícone presente na célula do campo "Senha" altera a senha daquele usuário, e o ícone no campo "Nome de Exibição", altera seu nome de exibição. Veja como:
```
    atualizar(){
      axios.put('usuario?nomeUsuario=' + this.put_usuario, {
        nomeUsuario: this.put_usuario,
        senha: this.put_senha,
        nomeExibicao: this.put_exibicao
      },
      {
        auth: { username: this.getUsuario, password: this.getSenha }
      })
      .then(res => {
        console.log(res);
        this.get();
      })
      .catch(error => {
        console.log(error);
        this.erro(error.response.status);
      })
      this.put_type = '';
      this.put_senha = '';
      this.put_usuario = '';
      this.put_exibicao = '';
      this.put_show = false;
    },
```
O método ``atualizar()`` trabalha muito com a parte em HTML do código, portanto utiliza-se bastante dos recursos fornecidos pelo Vue.js para simplificação.
### 03.iv) Remover
![08_remover](https://github.com/rodrigocr16/vue-blank/blob/master/prints/08_remover.gif)<br>
A remoção de um registro é feita em duas etapas: primeiro clica-se no ícone da borracha presenta na linha da tabela correspondente à entrada que se deseja remover, e então digitando o nome do usuário a ser deletado no campo de confirmação, para que se evite a remoção acidental de um usuário;<br>
A remoção é representada na sigla CRUD pela letra "D" - DELETE, e é feita da seguinte forma:
```
    deletar(){
      if(this.del_confirm == this.del_usuario){
        axios.delete('usuario', {
          params: { "nomeUsuario" : this.del_usuario },
          headers: { Accept: 'application/json' },
          auth: { username: this.getUsuario, password: this.getSenha }
        })
        .then(res => {
          console.log(res);
          this.get();
          this.del_show = false;
        })
        .catch(error => {
          console.log(error);
          this.erro(error.response.status);
        })
        this.del_usuario = '';
        this.del_confirm = '';
      } else {
        this.cod_erro = "A confirmação não bate com o nome do usuário!";
        this.del_confirm = '';
      }
    },
```
