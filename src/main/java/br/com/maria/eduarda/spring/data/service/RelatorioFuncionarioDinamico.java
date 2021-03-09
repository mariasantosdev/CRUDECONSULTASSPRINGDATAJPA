package br.com.maria.eduarda.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.maria.eduarda.spring.data.orm.Funcionario;
import br.com.maria.eduarda.spring.data.repository.FuncionarioRepository;
import br.com.maria.eduarda.spring.data.specification.SpecificationFuncionario;

@Service
public class RelatorioFuncionarioDinamico {
		
	private final FuncionarioRepository funcionarioRepository;
	
	public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {
		System.out.println("Digite o nome");
		String nome = scanner.next();
		
		if(nome.equalsIgnoreCase("NULL")) {
			nome = null;
		}
		
		List<Funcionario> funcionarios = funcionarioRepository.findAll
				(Specification.where(SpecificationFuncionario.nome(nome)));
		funcionarios.forEach(System.out::println);
	}
	
	
	
}

