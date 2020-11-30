# Java-POO-OEE
OBJETIVO: Desenvolver um sistema de gestão da produção industrial

MENU

Cockpit Operador
Cockpit Supervisor
Cockpit Gerente
Cockpit Diretor

Ordem de Produção
Linha de produção
Máquinas
e Produção

PROJETO DESENVOLVIDO NA LINGUAGEM JAVA

Requisto da disciplina POO FBV 2020.2

Regras:

O Projeto deve ser feito utilizando a programação em camadas
O projeto deve conter pelo menos:
a 2 clases abstratas b 4 heranças c 3 interfaces d 3 classes modelo e 3 sobrecargas e 3 sobrescritas de método

Todas as classes devem estar em seus respectivos pacotes, seguindo os padrões de programação em camadas (Constants, Controladores, Excecoes, Modelo, Repositorio, Ui).

Deverá conter os padrões de projeto Singleton e Facade

5 . Deve ter interação com o usuário via Menu de opções. (pode fazer com entrada e saída via terminal). O menu deverá dar acesso a todas as funcionalidades do sistema, tanto para ler, quanto para inserir dados, além de prover um mecanismo de voltar pro menu inicial.

Deverá conter pelo menos 3 CRUD`s(Create, replace, update e delete) (em memória) completos, ou seja, UI -> fachada -> controlador -> repositório

Todo o mecanismo de erro entre as camadas deverá ser via exceção.

Cada entidade deverá ter seus fluxos de erros mapeados em classes de exceção definidas no sistema.

Toda comunicação entre as camadas deverá ser via interface de comunicação.

Todos atributos devem usar modificadores de acesso

Todas as constantes do sistema devem estar em uma classe chamada Constants.java

Métodos em comum devem estar em uma classe utilitária (Util.java)