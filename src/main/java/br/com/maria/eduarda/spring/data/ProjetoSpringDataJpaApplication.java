package br.com.maria.eduarda.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import br.com.maria.eduarda.spring.data.orm.Cargo;
import br.com.maria.eduarda.spring.data.repository.CargoRepository;
import br.com.maria.eduarda.spring.data.service.CrudCargoService;
import br.com.maria.eduarda.spring.data.service.CrudFuncionarioService;
import br.com.maria.eduarda.spring.data.service.RelatorioService;

@SpringBootApplication
public class ProjetoSpringDataJpaApplication implements CommandLineRunner{

	private boolean system = true;	
	
	private final CrudCargoService cargoService;
	
	private final CrudFuncionarioService funcionarioService;
	
	private final RelatorioService relatorioService;
	
	public ProjetoSpringDataJpaApplication(CrudCargoService cargoService,
			CrudFuncionarioService funcionarioService, RelatorioService relatorioService) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.relatorioService = relatorioService;
	} 
	
	
		
	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual ação você quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 -Funcionário");
			System.out.println("3 - Relatório de Funcionário");
			
			
			int action = scanner.nextInt();
			
			if(action == 1) {
				cargoService.Inicial(scanner);
				
				
			}
			if(action == 2) {
				funcionarioService.Inicial(scanner);
				
				
			}
			
			if(action == 3) {
				relatorioService.Inicial(scanner);
				
				
			}
			
			else {
				system = false;
			}
			
		}
		
		
			
		
	}
	
	

}
