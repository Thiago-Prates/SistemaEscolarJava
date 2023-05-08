package br.com.sis.models;

public class Aluno extends Pessoa {
	private double nota;

	public String toString() {
		return "Aluno [codigo=" + super.getCodigo() + ", cpf=" + super.getCpf()
				+ ", cpf=" + super.getCpf()
				+ ", nome=" + super.getNome()
				+ ", nota=" + nota
				+ "]";
	}

	public Aluno() {
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

}
