package br.com.sis.services;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.sis.interfaces.IService;
import br.com.sis.models.Aluno;
import br.com.sis.repositories.RepositoryAlunoImpl;

public class AlunoServiceImpl implements IService {

	RepositoryAlunoImpl repositoryAluno = new RepositoryAlunoImpl();

	public void add() {
		JTextField cpf = new JTextField();
		JTextField nota = new JTextField();
		JTextField nome = new JTextField();

		Object[] objAluno = { "CPF: ", cpf, "Nome: ", nome, "Nota: ", nota };
		JOptionPane.showConfirmDialog(null, objAluno, "Cadastrar Aluno", JOptionPane.YES_NO_OPTION);

		if (!cpf.getText().isEmpty() && Integer.parseInt(nota.getText()) > 0
				&& repositoryAluno.getAluno(Integer.parseInt(cpf.getText())) == null) {
			Aluno aluno = new Aluno();

			aluno.setCodigo(repositoryAluno.getIdSequencia());
			aluno.setCpf(Integer.parseInt(cpf.getText()));
			aluno.setNome(nome.getText());
			aluno.setNota(Double.parseDouble(nota.getText()));

			repositoryAluno.addAluno(aluno);
			JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");

		} else if (repositoryAluno.getAluno(Integer.parseInt(cpf.getText())) != null) {
			JOptionPane.showMessageDialog(null, "Aluno j� cadastrado!");
		} else {
			JOptionPane.showMessageDialog(null, "Um erro inesperado aconteceu...");
		}
	}

	public void remove() {
		JTextField cpf = new JTextField();

		Object[] objCpf = { "CPF: ", cpf };
		JOptionPane.showConfirmDialog(null, objCpf, "Remover Aluno", JOptionPane.YES_NO_OPTION);

		Aluno aluno = new Aluno();
		aluno = repositoryAluno.getAluno(Integer.parseInt(cpf.getText()));

		if (aluno != null) {

			repositoryAluno.removeAluno(aluno);
			JOptionPane.showMessageDialog(null, "Aluno removido com sucesso!");
		}
	}

	public int getTotalItens() {
		return repositoryAluno.getTotalItens();
	}

	public Aluno getAluno(int cpf) {
		Aluno aluno = repositoryAluno.getAluno(cpf);

		if (aluno == null) {
			JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
		}

		return aluno;
	}

	public List<Aluno> getAllAlunos() {
		return repositoryAluno.listALL();
	}

	public void getResultadoAluno() {
		int cpf = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o CPF do aluno"));
		String nomeAluno = repositoryAluno.getAluno(cpf).getNome();
		double notaAluno = repositoryAluno.getAluno(cpf).getNota();
		String statusAluno = notaAluno < 40 ? "Reprovado" : notaAluno < 60 ? "Exame Especial" : "Aprovado";

		JOptionPane.showMessageDialog(null,
				"Nota do aluno: " + nomeAluno + "\n\nNota: " + notaAluno + "Status: " + statusAluno);
	}

}
