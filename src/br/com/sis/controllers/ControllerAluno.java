package br.com.sis.controllers;

import javax.swing.JOptionPane;

import br.com.sis.models.Aluno;
import br.com.sis.services.AlunoServiceImpl;

public abstract class ControllerAluno {

  public static void menu(AlunoServiceImpl alunoService) {

    boolean controle = true;

    do {
      String[] menuPrincipal = { "Cadastrar", "Remover", "Listar", "Pesquisar", "Voltar" };
      int op = JOptionPane.showOptionDialog(null,
          ":: Menu Alunos  :: \nAlunos cadastrados: " + alunoService.getTotalItens()
              + " \n\n\n\n\n\n\n\n\nDefina sua opção:",
          "Sistema POO", 1, 1, null, menuPrincipal, menuPrincipal[0]);

      switch (op) {
        case 0: {
          alunoService.add();
          break;
        }

        case 1: {
          alunoService.remove();
          break;
        }

        case 2: {
          String printAlunos = "";

          for (Aluno aluno : alunoService.getAllAlunos()) {
            printAlunos += aluno.getNome() + "\n";
          }

          JOptionPane.showConfirmDialog(null, printAlunos, "Alunos cadastrados", JOptionPane.OK_OPTION);
          break;
        }

        case 3: {
          int cpf = Integer
              .parseInt(JOptionPane.showInputDialog(null, "Digite o CPF que deseja pesquisar: "));
          Aluno aluno = alunoService.getAluno(cpf);

          String messageAluno = (aluno != null) ? aluno.toString() : "Aluno não encontrado";
          JOptionPane.showMessageDialog(null, messageAluno, "Pesquisar aluno", JOptionPane.PLAIN_MESSAGE);
          break;
        }

        case 4:
        default: {
          controle = false;
          break;
        }

      }

    } while (controle);

  }
}
