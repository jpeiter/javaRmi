## Tecnologia em Análise e Desenvolvimento de Sistemas - UTFPR 
## Desenvolvimento de Aplicações Distribuídas - 2018/2

# Trabalho 3

## Visão Geral
O trabalho consiste da implementação de uma  **Si**stema de **G**erenciamento do **A**tendimento (**SiGA**) usando Java RMI.

O SiGA deve oferecer o controle de filas de atendimento através de emissão de senhas e chamada das mesmas através de painéis.

O sistema deve ser composto por no mínimo 4 objetos(módulos do sistema):
* **Guichê** - Nesse módulo é possível emitir senhas para os serviços e realizar impressão das mesmas. 
* **Atendente** - Deve possuir as funcionalidades para efetuar atendimentos. Este módulo é utilizado pelo(a)s atendentes.
* **Painel** - Este módulo permite o acompanhamento em tempo real pelos usuários das senhas que estão sendo chamadas.
* **Controlador** - Este módulo gerencia os demais, isto é, envia as senhas geradas pelos **guiches** quando solicitadas pelos **atendentes** ao **painel**. Além disso, através desse módulo deve ser permitido solicitar estatisticas de atendimento realizada pelos atendentes, por tipo de serviço atendido.


### Requisitos funcionais e não funcionais obrigatórios:
* Deve ser implementada uma interface gráfica para todos módulos de modo a facilitar a interação com o sistema;
* As filas de atendimento podem conter um ou mais serviços;
* Os atendentes tem permissão para atender todos os serviços; 
* Uma unidades de atendimento pode ter vários painéis;
* Cada painel deve apresentar a senha a atendida (mais destacado) e o histórico das últimas senhas atendidas;
* Deve ser implementado usando Java RMI.

### O que deve ser entregue:
* Código fonte
* Diagrama de classes
* Diagrama de sequencia

# Avaliação e Datas de Entrega
* Entregar via Github Classroom o código fonte do trabalho, conforme cronograma de entregas abaixo:
  - a cada aula destinada ao desenvolvimento do trabalho, deve ser feito um commit
  - usar [tags](https://git-scm.com/book/pt-br/v1/Git-Essencial-Tagging) do git para marcar
os commits feitos;
  - as tags devem identificar claramente o que foi feito no dia;
  - entre um commit e outro deve ter avanços, já que serão destinadas aulas para o desenvolvimento do trabalho;
  - serão destinadas 5 aulas (16, 22, 23, 29 e 30/10) para o desenvolvimento deste trabalho;
  - o trabalho final deve ser entregue até às 20h30min do dia 05/11/2018;
  - o trabalho deverá ser apresentado para a turma nos dias 05 e 06/11/2018;
* o trabalho poderá ser feito individualmente ou em dupla;
* deve ser editado esse arquivo (README.md) e incluir:
  - nome dos integrantes da equipe
  - diagrama de classes
  - diagrama de sequencia
  - explicação do funcionamento geral do sistema
  
* A avaliação será feita levando em consideração:
  - se atende aos requisitos solicitados;
  - estruturação e clareza do código;
  - avaliação individual de cada participante. Todos os integrantes devem saber responder a qualquer questionamento do professor sobre a implementação de tópicos do trabalho.

