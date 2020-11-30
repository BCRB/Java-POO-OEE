# Java-POO-OEE

OEEjava
OBJETIVO:  Desenvolver um sistema de gestão da produção

MENU
- Cockpit Operador
- Cockpit Supervisor
- Cockpit Gerente
- Cockpit Diretor

1. Ordem de Produção

PROJETO DESENVOLVIDO NA LINGUAGEM JAVA

Requisto da disciplina POO FBV 2020.2

Regras: 

1. O Projeto deve ser feito utilizando a programação em camadas
2. O projeto deve conter pelo menos:

a 2 clases abstratas
b	4 heranças
c	3 interfaces
d	3 classes modelo
e	3 sobrecargas e 3 sobrescritas de método

3. Todas as classes devem estar em seus respectivos pacotes, seguindo os padrões de programação em camadas (Constants, Controladores, Excecoes, Modelo, Repositorio, Ui).

4. Deverá conter os padrões de projeto Singleton e Facade

5 . Deve ter interação com o usuário via Menu de opções. (pode fazer com entrada e saída via terminal). O menu deverá dar acesso a todas as funcionalidades do sistema, tanto para ler, quanto para inserir dados, além de prover um mecanismo de voltar pro menu inicial.

6. Deverá conter pelo menos 3 CRUD`s(Create, replace, update e delete) (em memória) completos, ou seja, UI -> fachada -> controlador -> repositório

7. Todo o mecanismo de erro entre as camadas deverá ser via exceção.

8. Cada entidade deverá ter seus fluxos de erros mapeados em classes de exceção definidas no sistema.

9. Toda comunicação entre as camadas deverá ser via interface de comunicação.

10. Todos atributos devem usar modificadores de acesso

11. Todas as constantes do sistema devem estar em uma classe chamada Constants.java

12. Métodos em comum devem estar em uma classe utilitária (Util.java)
