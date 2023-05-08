package br.com.sis;

import javax.swing.JOptionPane;

import br.com.sis.controllers.ControllerAluno;
import br.com.sis.controllers.ControllerProfessor;
import br.com.sis.services.AlunoServiceImpl;
import br.com.sis.services.ProfessorServiceImpl;

public class Aplicacao {

  public static void main(String[] args) {
    boolean controle = true;

    AlunoServiceImpl alunoService = new AlunoServiceImpl();
    ProfessorServiceImpl professorService = new ProfessorServiceImpl();

    do {
      switch (menuPrincipal(alunoService, professorService)) {
        case 0: {
          ControllerAluno.menu(alunoService);
          break;
        }

        case 1: {
          ControllerProfessor.menu(professorService);
          break;
        }

        case 2: {
          alunoService.getResultadoAluno();
          break;
        }

        case 3: {

          break;
        }

        default:
          controle = false;
          break;
      }
    } while (controle);
  }

  public static int menuPrincipal(AlunoServiceImpl alunoService, ProfessorServiceImpl professorService) {
    String[] menuPrincipal = { "Alunos", "Professores", "Situação do aluno", "Salario professor" };
    int op = JOptionPane.showOptionDialog(null,
        "--------------- Menu principal sistema --------------- \n\n Sistema realizado na disciplina de POO \n\nDados: "
            + "\nAlunos cadastrados: " + alunoService.getTotalItens()
            + "\nProfessores cadastrados: " + professorService.getTotalItens()
            + " \n\n\n\n\n\n\n\n\n--------------- Menu principal sistema --------------- ",
        "Sistema POO", 1, 1, null, menuPrincipal, menuPrincipal[0]);

    return op;
  }
}
