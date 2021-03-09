package br.com.maria.eduarda.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.maria.eduarda.spring.data.orm.Funcionario;
import br.com.maria.eduarda.spring.data.orm.FuncionarioProjecao;
import br.com.maria.eduarda.spring.data.repository.FuncionarioRepository;

@Service
public class RelatorioService {
	private Boolean system = true;
	
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatorioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	public void Inicial(Scanner scanner) {
		while (system) {
			System.out.println("Digite um para pesquisa funcionário salário");
		
	int action = scanner.nextInt();
			
			switch(action) {
			case 1:
				pesquisafuncionarioSalario();
				break;
				
			 default:
					system = false;
					break;
		
		}

}
	

	}
	public void pesquisafuncionarioSalario() {
		List<FuncionarioProjecao> list = funcionarioRepository.findFuncionarioSalario();
		list.forEach(f -> System.out.println("Funcionário id: "+ f.getId() + 
		"|nome" + f.getNome() + "| salario" + f.getSalario()));		
	}
}
