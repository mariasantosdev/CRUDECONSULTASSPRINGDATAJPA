package br.com.maria.eduarda.spring.data.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.maria.eduarda.spring.data.orm.Funcionario;

public class SpecificationFuncionario {

public static Specification<Funcionario> nome (String nome){
	return (root, criteriaQuery, criteriaBuilder) -> 
	criteriaBuilder.like (root.get("Nome"), "%" + nome + "%");
}

}
