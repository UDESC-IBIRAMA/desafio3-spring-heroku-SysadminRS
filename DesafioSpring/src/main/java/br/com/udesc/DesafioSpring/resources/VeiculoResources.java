package br.com.udesc.DesafioSpring.resources;


import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.udesc.DesafioSpring.model.Veiculo;
import br.com.udesc.DesafioSpring.repository.VeiculoRepository;

@RestController
@RequestMapping("/veiculos")
public class VeiculoResources {
	
	@Autowired
	private VeiculoRepository vr;
	
//	@GetMapping(produces="application/json")
//	public @ResponseBody Veiculo testeVeiculo() {
//		return new Veiculo(1L, "FORD", "FOCUS", "BRANCO", 5000, "2.0", "CARRO");
//	}
	
	@GetMapping("/lista")
    public @ResponseBody Iterable<Veiculo> listaVeiculos() {
		Iterable<Veiculo> listaVeiculos = vr.findAll();
		return listaVeiculos;
	}
	
//	@GetMapping("/tipo/{tipo}")
//	public @ResponseBody Iterable<Veiculo> buscaTipo(String tipo){
//		Iterable<Veiculo> verifica = vr.buscaTipo(tipo);
//		return verifica;
//	}
	
	@GetMapping("/{id}")
	public Veiculo buscaId(@PathVariable Long id) throws Exception {
     Optional<Veiculo> verifica = vr.findById(id);

	if (!verifica.isPresent())
			throw new Exception("Id - " + id + " Inexistente!");
		
		return verifica.get();
	}
	
	
	@PostMapping("/adiciona")
	public Veiculo cadastraVeiculo(@RequestBody @Valid Veiculo oVeiculo) {
		return vr.save(oVeiculo);
	}
	
	@PutMapping(value="/modifica/{id}")
	public ResponseEntity<Veiculo> modificaVeiculo(@PathVariable("id") Long id, @RequestBody Veiculo oVeiculo) {
		Optional<Veiculo> veiculoInfo = vr.findById(id);
	
		if(veiculoInfo.isPresent()) {
			Veiculo veiculoAtual = veiculoInfo.get();
			veiculoAtual.setId(oVeiculo.getId());
			veiculoAtual.setMontadora(oVeiculo.getMontadora());
			veiculoAtual.setModelo(oVeiculo.getModelo());
			veiculoAtual.setCor(oVeiculo.getCor());
			veiculoAtual.setKm(oVeiculo.getKm());
			veiculoAtual.setMotor(oVeiculo.getMotor());
			veiculoAtual.setTipo(oVeiculo.getTipo());
			
			//altera os dados
			vr.save(veiculoAtual);
			
			return ResponseEntity.ok(veiculoAtual);
		}else {
			return ResponseEntity.notFound().build();
		}
			
		
	}
	
	
	@DeleteMapping("/deleta")
	public Veiculo deletaVeiculo(@RequestBody Veiculo oVeiculo) {
		vr.delete(oVeiculo);
		return oVeiculo;
	}
	
	
}
