package br.com.maria.eduarda.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.maria.eduarda.spring.data.orm.Funcionario;
import br.com.maria.eduarda.spring.data.orm.FuncionarioProjecao;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer>,
JpaSpecificationExecutor<Funcionario>{

@Query(value = "select f.id, f.nome, f.salario from funcionario f", nativeQuery = true)
List<FuncionarioProjecao> findFuncionarioSalario();



}	

