package br.com.codeforce.planosservicos.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>, JpaRepository<Cliente, Long> {

}
