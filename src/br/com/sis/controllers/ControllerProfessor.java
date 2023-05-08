package br.com.sis.controllers;

import javax.swing.JOptionPane;

import br.com.sis.services.ProfessorServiceImpl;

public class ControllerProfessor {
  public static void menu(ProfessorServiceImpl professorService) {
    boolean controle = true;

    do {
      String[] menuPrincipal = { "Cadastrar", "Remover", "Listar", "Pesquisar", "Voltar" };
      int op = JOptionPane.showOptionDialog(null,
          "::  Menu Professores  :: \nProfessores cadastrados: " + professorService.getTotalItens()
              + " \n\n\n\n\n\n\n\n\nDefina sua opção:",
          "Sistema POO", 1, 1, null, menuPrincipal, menuPrincipal[0]);

      switch (op) {
        case 0: {

          break;
        }

        case 1: {

          break;
        }

        // case 2: {
        // String printProfessores = "";

        // for (Aluno aluno : alunoService.getAllAlunos()) {
        // printAlunos += aluno.getNome() + "\n";
        // }

        // JOptionPane.showConfirmDialog(null, printAlunos, "Alunos cadastrados", 1);
        // break;
        // }

        // case 3: {
        // int cpf = Integer
        // .parseInt(JOptionPane.showInputDialog(null, "Digite o CPF que deseja
        // pesquisar: ", "Pesquisar Aluno"));
        // Aluno aluno = alunoService.getAluno(cpf);

        // String messageAluno = aluno != null ? aluno.toString() : "Aluno não
        // encontrado";
        // JOptionPane.showMessageDialog(null, messageAluno, "Pesquisar aluno",
        // JOptionPane.PLAIN_MESSAGE);
        // break;
        // }

        case 4:
        default: {
          controle = false;
          break;
        }

      }

    } while (controle);

  }

}
