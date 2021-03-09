package br.com.maria.eduarda.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.maria.eduarda.spring.data.orm.Cargo;
import br.com.maria.eduarda.spring.data.repository.CargoRepository;

@Service
public class CrudCargoService {
	
	private Boolean system = true;
	
private final CargoRepository cargoRepository;
	
	public CrudCargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository ;
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
		System.out.println("Descricao do cargo");
		String Descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(Descricao);
		cargoRepository.save(cargo);
		System.out.println("Registro salvo!");
		
		
	}
	
	public void Atualizar (Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Registro atualizado!");
		
	}
	public void Visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	public void Deletar(Scanner scanner) {
	    System.out.println("Id");
	    int id = scanner.nextInt();
	    cargoRepository.deleteById(id);
	    System.out.println("Deletado!");
	}
	
	
}
