package br.com.sis.models;

public class Professor extends Pessoa {
	private double salario;

	public String toString() {
		return "Professor [codigo=" + super.getCodigo() + ", cpf=" + super.getCpf()
				+ ", cpf=" + super.getCpf()
				+ ", nome=" + super.getNome()
				+ ", salario=" + salario
				+ "]";
	}

	public Professor() {
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
