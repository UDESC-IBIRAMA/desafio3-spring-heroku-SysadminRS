package br.com.udesc.Desafio03Robson.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.udesc.Desafio03Robson.model.Veiculo;


public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

}
