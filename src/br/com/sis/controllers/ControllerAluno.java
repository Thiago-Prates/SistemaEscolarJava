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
          ":: Menu Alunos  :: \nAlunos Cadastrados: " + alunoService.getTotalItens()
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

          JOptionPane.showConfirmDialog(null, printAlunos, "Alunos cadastrados", 1);
          break;
        }

        case 3: {
          int cpf = Integer
              .parseInt(JOptionPane.showInputDialog(null, "Digite o CPF que deseja pesquisar: ", "Pesquisar Aluno"));

          alunoService.getAluno(cpf);
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
