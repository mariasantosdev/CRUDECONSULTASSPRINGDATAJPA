package br.com.maria.eduarda.spring.data.orm;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Funcionario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Nome;
	private long Cpf;
	private double Salario;

	private Date Data_Contratacao;
	@OneToMany(mappedBy= "funcionario")	
	private List<Cargo> cargo;
	
	
	public double getSalario() {
		return Salario;
	}
	public void setSalario(double salario) {
		Salario = salario;
	}
	
	public Cargo getCargo() {
		return (Cargo) cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = (List<Cargo>) cargo;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public long getCpf() {
		return Cpf;
	}
	public void setCpf(long cpf) {
		Cpf = cpf;
	}
	
	public Date getData_Contratacao() {
		return Data_Contratacao;
	}
	public void setData_Contratacao(Date data_Contratacao) {
		Data_Contratacao = data_Contratacao;
	}
	@Override
	public String toString() {
		return "Funcionario [Id=" + Id + ", Nome=" + Nome + ", Salario=" + Salario + "]";
	}


	
	
	

}
