package br.com.codeforce.planosservicos.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuarios, Long>, JpaRepository<Usuarios, Long> {
	Usuarios findByLogin(String login);
}
