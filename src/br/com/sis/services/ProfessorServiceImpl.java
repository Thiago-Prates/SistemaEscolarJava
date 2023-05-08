package br.com.sis.services;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.sis.interfaces.IService;
import br.com.sis.models.Professor;
import br.com.sis.repositories.RepositoryProfessorImpl;

public class ProfessorServiceImpl implements IService {
  RepositoryProfessorImpl repositoryProfessor = new RepositoryProfessorImpl();

  public void add() {
    final double SALARIO = 2380;

    JTextField cpf = new JTextField();
    JTextField nome = new JTextField();

    Object[] objProfessor = { "CPF: ", cpf, "Nome: ", nome };
    JOptionPane.showConfirmDialog(null, objProfessor, "Cadastrar professor", JOptionPane.YES_NO_OPTION);

    if (!cpf.getText().isEmpty() && repositoryProfessor.getProfessor(Integer.parseInt(cpf.getText())) == null) {
      Professor professor = new Professor();

      professor.setCodigo(repositoryProfessor.getIdSequencia());
      professor.setCpf(Integer.parseInt(cpf.getText()));
      professor.setNome(nome.getText());
      professor.setSalario(SALARIO);

      repositoryProfessor.addProfessor(professor);
      JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso!");

    } else if (repositoryProfessor.getProfessor(Integer.parseInt(cpf.getText())) != null) {
      JOptionPane.showMessageDialog(null, "Professor j� cadastrado!");
    } else {
      JOptionPane.showMessageDialog(null, "Um erro inesperado aconteceu...");
    }
  }

  public void remove() {
    JTextField cpf = new JTextField();

    Object[] objCpf = { "CPF: ", cpf };
    JOptionPane.showConfirmDialog(null, objCpf, "Remover Professor", JOptionPane.YES_NO_OPTION);

    Professor professor = new Professor();
    professor = repositoryProfessor.getProfessor(Integer.parseInt(cpf.getText()));

    if (professor != null) {

      repositoryProfessor.removeProfessor(professor);
      JOptionPane.showMessageDialog(null, "Professor removido com sucesso!");
    }
  }

  public int getTotalItens() {
    return repositoryProfessor.getTotalItens();
  }

  public Professor getProfessor(int cpf) {
    Professor professor = repositoryProfessor.getProfessor(cpf);

    if (professor != null) {
      JOptionPane.showMessageDialog(null, "Professor não encontrado!");
    }

    return professor;
  }

  public List<Professor> getAllProfessores() {
    return repositoryProfessor.listALL();
  }

}
