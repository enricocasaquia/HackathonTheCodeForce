package br.com.codeforce.planosservicos.empresa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Long>, JpaRepository<Empresa, Long>{

}
