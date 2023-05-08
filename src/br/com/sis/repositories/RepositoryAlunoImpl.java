package br.com.sis.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.sis.interfaces.IRepository;
import br.com.sis.models.Aluno;

public class RepositoryAlunoImpl implements IRepository {
	List<Aluno> alunos = new ArrayList<Aluno>();

	public Aluno getAluno(int cpf) {

		for (Aluno alunoFor : alunos) {
			if (alunoFor.getCpf() == cpf) {
				return alunoFor;
			}
		}
		return null;
	}

	public void addAluno(Aluno p) {
		alunos.add(p);
	}

	public void removeAluno(Aluno p) {
		alunos.remove(p);
	}

	public List<Aluno> listALL() {
		return alunos;
	}

	public int getTotalItens() {
		return alunos.size();
	}

	public int getIdSequencia() {
		return alunos.size() + 1;
	}
}
