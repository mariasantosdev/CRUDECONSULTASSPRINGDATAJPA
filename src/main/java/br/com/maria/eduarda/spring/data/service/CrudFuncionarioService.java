package br.com.maria.eduarda.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.maria.eduarda.spring.data.orm.Cargo;
import br.com.maria.eduarda.spring.data.orm.Funcionario;
import br.com.maria.eduarda.spring.data.repository.CargoRepository;
import br.com.maria.eduarda.spring.data.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {

	private Boolean system = true;
	
	private final FuncionarioRepository funcionarioRepository;
	
	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	} 
	public void Inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual ação de cargo deseja executar");
			System.out.println("Sair - 0");
			System.out.println("Salvar - 1");
			System.out.println("Atualizar - 2");
			System.out.println("Visualizar - 3");
			System.out.println("Deletar - 4");
			
			int action = scanner.nextInt();
			
			switch(action) {
			case 1:
				Salvar(scanner);
				break;
			case 2:
				Atualizar(scanner);
				break;
			case 3:
				Visualizar();
				break;
			case 4:
				Deletar(scanner);
				break;
				
			        default:
					system = false;
					break;
			}
}
		
		
		Salvar(scanner);	
	}
	public void Salvar (Scanner scanner) {
		System.out.println("Digite o nome do funcionário");
		String Nome = scanner.next();
		
		System.out.println("Digite o salário desse funcionário");
		Double Salario = scanner.nextDouble();
		
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(Nome);
		funcionario.setSalario(Salario);
		funcionarioRepository.save(funcionario);
		System.out.println("Registro salvo!");
		
		
	}
	public void Atualizar (Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		System.out.println("Digite o nome do funcionário");
		String Nome = scanner.next();
		
		System.out.println("Digite o salário desse funcionário");
		Double Salario = scanner.nextDouble();
	
		
		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		funcionario.setNome(Nome);
		funcionario.setSalario(Salario);
		funcionarioRepository.save(funcionario);
		System.out.println("Registro atualizado!");
		
	}
	public void Visualizar() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}
	
	public void Deletar(Scanner scanner) {
	    System.out.println("Id");
	    int id = scanner.nextInt();
	    funcionarioRepository.deleteById(id);
	    System.out.println("Deletado!");
	}
	
	
	
	
	
}
