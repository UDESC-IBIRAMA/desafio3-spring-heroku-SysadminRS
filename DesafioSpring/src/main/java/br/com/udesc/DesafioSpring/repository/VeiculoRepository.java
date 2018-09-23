package br.com.udesc.DesafioSpring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.udesc.DesafioSpring.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	
	//List<Veiculo> buscaTipo(@Param("tipo") String tipo);

}
