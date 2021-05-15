# - Time
* Isabella Bragion Pereira - DEV Team
* Lucas Jose Povinske - Project Owner
* Murani de Moura Gomes - Scrum Master
* Railson Tales de Oliveira - DEV Team
* Vitor Henrique da Silva Pereira - DEV Team

--------------------------
# - Sobre o projeto:
O projeto a ser realizado está relacionado à área de entreterimento, com foco em jogos. Ele será um site que ajudará aos usuários visualizarem, editarem, e personalizarem suas fichas de personagens para o jogo de _Roleplaying-Game Dungeons & Dragons_, baseando-se por contas de usuário para cada personagem.

# - Funcionalidade:
Ao entrar no site, o usuário poderá se cadastrar, ou conectar-se com um usuário existente para visualizar os personagens que possui. Após se conectar, o usuário poderá cadastrar novos personagens ou visualizar os que já possui. Ao cadastrar um novo personagem, o usuário será levado até uma tela que o fará escolher dentre raças, classes, abilidades, perícias, equipamento e o dará a possibilidade de descrever a personalidade de seu personagem. Quando o processo for finalizado e o personagem é salvo, o usuário poderá visualizar a ficha finalizada baseado em suas escolhas.

--------------------------
# - Tecnologias:
As tecnologias iniciais que serão utilizadas são:
## Front-end: 
### HTML:
#### Porque usar?
HTML é a sigla para Hyper Text Markup Language, ou seja, linguagem de marcação de hipertexto. Ela é utilizada como marcação para desenvolver páginas e documentos eletrônicos para a internet. Isso significa que ela garante a formatação ideal para sites, e ainda é o método mais básico ao qual sites se baseiam.

#### Benefícios?
Diversos dispositivos interpretam os documentos desenvolvidos com o HTML, não dependendo do tamanho da tela, resolução, variação de cor. Até mesmo os dispositivos próprios para deficientes visuais e auditivos ou dispositivos móveis e portáteis são capazes de interpretar o documento formatado com essa linguagem.

--------------------------
### CSS:
#### Porque usar?
A linguagem CSS complementa o HTML, que tem como função apenas a estruturação e marcação dos principais componentes das páginas. Com o CSS é podemos otimizar o aspecto visual das páginas, de uma maneira mais organizada e menos complexa na hora realizar manutenção.

#### Benefícios?
- Possibilidade do controle do layout de vários documentos a partir de um único arquivo;
- Aplicação de layouts diferentes de acordo com o dispositivo utilizado, possibilitando o layout responsivo;
- Possibilidade de manter a mesma formatação em diferentes navegadores;
- Aplicação de técnicas mais sofisticadas de desenvolvimento;
- Menor consumo de banda e melhor desempenho devido ao reuso do mesmo código de formatação em várias páginas.

--------------------------
### Javascript:
#### Porque usar?
Devido a sua grande variedade de funcionalidades e sendo que a maioria dos sites atualmente a utiliza, a linguagem foi escolhida pois ela pode ser aplicada tanto em back-end como em front-end se for necessário.

#### Benefícios?
- Alta compatibilidade com plataformas, sistemas e navegadores web.
- Faz com que as páginas na internet sejam mais dinâmicas e interativas, características essenciais do UX.
- Os navegadores interpretam a linguagem por conta própria, tirando a necessidade de usar um compilador.
- Erros de programação são mais fáceis de encontrar e de corrigir.
- Executa comportamentos específicos em uma página, como cliques e efeitos personalizados.

--------------------------
### Vue.js:
#### Porque usar?
Criar componentes com VueJS é muito simples e objetivo. Sua API é intuitiva e simples, e seu sistema de template é previsível e agradável. Possui uma arquitetura enxuta, que requer uma configuração mínima na criação de um projeto e pode ser facilmente integrado com uma aplicação já existente através de uma simples tag script. 

#### Benefícios?
- Redução de complexidade;
- Documentação detalhada;
- Flexibilidade e adaptabilidade;

---------------------------
## Back-end: 
### Java:
#### Porque usar?
Java é uma linguagem orientada a objetos, o que a permite a aplicação do conceito de classes e hierarquias para diferentes pontos do site e do banco de dados, utilizando cada tabela como uma entidade ou classe própria. Usando JPA, é possível programar as relações entre as diferentes entidades, com diferentes identidades.

#### Benefícios?
- Orientação a objetos;
- Portabilidade;
- Recursos de Rede;
- Segurança;
- Possui muitas bibliotecas a serem utilizadas;
- Possui facilidades para criação de programas distribuídos e multi-thread;
- Desalocação de memória automática por processo de garbage collector;
- Carga Dinâmica de Código.

--------------------------
### Springboot:
#### Porque usar?
O Spring Boot é um projeto da Spring que veio para facilitar o processo de configuração e publicação de nossas aplicações. A intenção é ter o seu projeto rodando o mais rápido possível e sem complicação.
Ele consegue isso favorecendo a convenção sobre a configuração. Basta que você diga pra ele quais módulos deseja utilizar (WEB, Template, Persistência, Segurança, etc.) que ele vai reconhecer e configurar.

#### Benefícios?
O maior benefício de usar o Spring Boot é conseguir otimizar seu tempo e aumentar sua produtividade, já que ele simplifica o desenvolvimento de aplicações.
Ou seja, não você não precisa temer ter que gastar seu tempo desenvolvendo uma aplicação do zero, você já recebe a maioria dos recursos necessários.

--------------------------
### API:
#### Porque usar?
O acrônimo API que provém do inglês Application Programming Interface (Em português, significa Interface de Programação de Aplicações), trata-se de um conjunto de rotinas e padrões estabelecidos e documentados por uma aplicação A, para que outras aplicações consigam utilizar as funcionalidades desta aplicação A, sem precisar conhecer detalhes da implementação do software.

#### Benefícios?
APIs permitem uma interoperabilidade entre aplicações. Em outras palavras, a comunicação entre aplicações e entre os usuários.

---------------------------
### REST:
#### Porque usar?
REST significa Representational State Transfer. Em português, Transferência de Estado Representacional. Trata-se de uma abstração da arquitetura da Web. Resumidamente, o REST consiste em princípios/regras/constraints que, quando seguidas, permitem a criação de um projeto com interfaces bem definidas. Desta forma, permitindo, por exemplo, que aplicações se comuniquem.

#### Benefícios?
REST é um modelo de arquitetura bem definido para servir aplicações web. Ele já oferece todo o guideline necessário para construirmos um serviço coeso, escalável e performático – e não é difícil. No dia-a-dia nós já utilizamos muitas das recomendações do REST: client-server, cache, stateless, etc. Seguir este modelo de arquitetura nos permite se preparar para o crescimento do serviço sem grandes impactos, além de oferecer aos clientes da aplicação um modelo que é de conhecimento comum, intuitivo até, evitando a necessidade de fazê-lo entender sobre uma nova arquitetura para consumir o serviço.

---------------------------
## Banco de Dados: 
### MySQL:
#### Porque usar?
O MySQL é um sistema gerenciador de banco de dados relacional de código aberto usado na maioria das aplicações gratuitas para gerir suas bases de dados. O serviço utiliza a linguagem SQL (Structure Query Language – Linguagem de Consulta Estruturada), que é a linguagem mais popular para inserir, acessar e gerenciar o conteúdo armazenado num banco de dados.

#### Benefícios?
* O MySQL se tornou o mais popular banco de dados Open Source do mundo. Isso traz muitas consequências diretas e indiretas, como por exemplo, muita disponibilidade de informações produzidas pela própria comunidade em torno de sites e fóruns, o que é fundamental na solução de problemas e mesmo na implementação de soluções, particularmente por parte dos menos experientes;
* Aplicações integradas utilizadas por web designers e desenvolvedores na Internet, como o XAMP (substituído pelo MariaDB em versões recentes) e LAMP, o que facilita a adaptação e mesmo o aprendizado para os iniciantes, já que é fácil e rápida a instalação e o uso em uma estação de trabalho;
* O MySQL funciona e pode ser instalado em uma ampla gama de sistemas operacionais, como Linux, FreeBSD, macOS, Novell Netware, Microsoft Windows, NetBSD, i5/OS, OpenSolaris, OS/2 Warp, QNX, Oracle Solaris, Symbian, SunOS, entre outros;
* A variedade de linguagens de programação que podem ser utilizadas com o MySQL, também é muito ampla e inclui PHP, Python, Perl, Ruby, .NET, ASP, C, C++, Java, Delphi, entre outras;
* Há uma ampla documentação que cobre muitos aspectos de desenvolvimento, disponível no próprio site do MySQL;
* Embora já existam tecnologias de banco de dados que produzem resultados consistentes, para muitos casos o desempenho do MySQL é muito bom, mesmo em sistemas com elevados números de consultas, o que é comprovável em grandes sites que manipulam volumes imensos de dados, como é o caso do Facebook;
* A disponibilidade, apoiada em estabilidade e confiabilidade no armazenamento e manipulação dos dados, assegurando que as aplicações baseadas em dados gerenciados pelo MySQL estarão sempre funcionais;
* Bons mecanismos de segurança, visando assegurar que somente usuários autorizados têm acesso para o servidor de banco de dados, bem como garantir diferentes níveis de privilégios e criptografia dos dados, quando necessário;
* Open Source e gratuito. Mais do que a redução de custos, que dependendo da solução de banco de dados pode ser importante, a certeza de que uma grande comunidade está envolvida na busca de soluções e melhorias. Quando necessário, há a possibilidade de se optar por edições mais específicas e com suporte da Oracle, como o Oracle MySQL, com suporte 24X7;
* Portabilidade ampla, seja pela variedade de sistemas que operam com o MySQL, seja porque no ambiente de Internet, a maioria esmagadora de provedores de hospedagem fornece o serviço de bancos de dados baseados em MySQL e mesmo seu fork, o MariaDB tem compatibilidade.

---------------------------
## Cloud: 
### Azure:
#### Porque usar?
Ao utilizar da Azure Cloud e Azure DevOps, estaremos garantindo uma organização e estaremos deixando todos os requisitos de acordo com a cultura DevOps

#### Benefícios?
* #### Traz privacidade e segurança
Para que as escolas migrem para o Azure, é importante que elas confiem na privacidade e na segurança das informações que serão fornecidas para a plataforma. Por isso, a Microsoft apresenta o maior número de autenticações de segurança dentre todos os provedores de computação em nuvem disponíveis no mercado.
O Azure cumpre com uma série de regulamentos de acordo internacional e específicas da indústria. Rigorosas auditorias também são realizadas. Assim, os usuários contam com um sistema durável e seguro, com baixos riscos relacionados à segurança da informação.
* #### Tem alta disponibilidade
A Microsoft garante que os serviços do Azure têm disponibilidade de pelo menos 99,9% do tempo de operação. Isso significa menos de cinco horas de inatividade por ano.
Assim, é possível garantir que não haverá perda nem de tempo nem de dinheiro, caso alguma falha aconteça ocasionalmente, pois os riscos de parada dos ambientes, sejam críticos ou não, são baixos.
* #### Permite maior produtividade
O Azure suporta grande diversidade de bancos de dados, linguagens, frameworks e sistemas operacionais — o que aumenta a produtividade dos desenvolvedores. Isso permite a integração de ferramentas, serviços e soluções, possibilitando a geração de aplicações para várias plataformas.
O resultado é um ambiente altamente integrado, aumentando as possibilidades de os desenvolvedores criarem aplicações mais estáveis, robustas e funcionais. O Microsoft Azure elimina muitas tarefas rotineiras e eleva a produtividade da equipe.
* #### Proporciona backup prático
O backup no Azure é rápido e prático, sem a necessidade da rotina diária, semanal e mensal de cópia dos dados. Além disso, o sistema elimina os problemas relacionados ao esquecimento da realização de backup.
O Azure é projetado para ser econômico e oferece flexibilidade para escolher as informações que quer proteger, pelo tempo que desejar — por até 99 anos. Também é possível restaurar arquivos e pastas individuais ou máquinas inteiras, conforme a necessidade do usuário.
* #### É rápido e facilmente escalável
O sistema oferece a possibilidade de aumentar os recursos e depois retroceder conforme a demanda. Em menos de uma hora é possível fazer implementações físicas e lógicas, e ter o ambiente disponível para uso na nuvem.
Assim, não há necessidade de adquirir diversos softwares e integrá-los a diferentes plataformas, pois o  Azure agrupa todos os serviços em um único datacenter.

---------------------------
# - Requisitos:

- Modelagem do banco de dados
- Criação do banco de dados no MySQL
- Desenho das telas no figma
- Construção do site com a busca, conectado ao Banco de Dados;
- Inserção de dados no Banco;
- Configuração da Cloud;
- Testes e anotações de feedback;
- Usuário pode se cadastrar;
- Usuário pode visualizar os seus personagens;
- Administrador pode se cadastrar;
- Administrador pode ver personagem de todos;
- Melhorias e Finalizações.
