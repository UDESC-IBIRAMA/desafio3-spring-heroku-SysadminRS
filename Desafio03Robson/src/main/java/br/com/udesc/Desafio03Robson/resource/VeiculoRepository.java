package br.com.udesc.Desafio03Robson.resource;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.udesc.Desafio03Robson.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
	
	//nome da "namedQuery"
    List<Veiculo> tiposDeVeiculo(String tipo);
    
    List<Veiculo> montadora(String montadora);
    
    List<Veiculo> motor(String motor);
    
    List<Veiculo> filtros(String tipo, String montadora, int km);

}
