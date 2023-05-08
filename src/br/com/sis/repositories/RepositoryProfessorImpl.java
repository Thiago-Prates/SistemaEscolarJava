package br.com.sis.repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.sis.interfaces.IRepository;
import br.com.sis.models.Professor;


public class RepositoryProfessorImpl implements IRepository{
	List<Professor> professores = new ArrayList<Professor>();
	
	public Professor getProfessor(int cpf) {
		
		for (Professor professorFor : professores) {
			if(professorFor.getCpf() == cpf) {
				return professorFor;
			}
		}
		return null;
	}
	
	public void addProfessor(Professor p) {
		professores.add(p);
	}
	
	public void removeProfessor(Professor p) {
		professores.remove(p);
	}
	
	public List<Professor> listALL() {
		return professores;
	}
	
	public int getTotalItens() {
		return professores.size();
	}
	
	public int getIdSequencia() {
		return professores.size() + 1;
	}
}
