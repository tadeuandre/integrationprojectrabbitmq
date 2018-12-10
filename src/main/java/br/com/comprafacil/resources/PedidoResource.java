package br.com.comprafacil.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprafacil.model.Pedido;
import br.com.comprafacil.queue.PedidoProducer;
import br.com.comprafacil.services.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	PedidoProducer producer;

	@RequestMapping(value= "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Long id) {
		Optional<Pedido> pedidoEncontrado = pedidoService.findById(id);
		return ResponseEntity.ok().body(pedidoEncontrado);
	}
	
	@GetMapping("/pedidos")
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(pedidoService.findAll());
	}
	
	@GetMapping("/frete")
	public String calculaFrete(@RequestParam("cep") String cep) {
		producer.produceMsg(cep);
		return "Calculando";
	}
	
	@PostMapping("/criar")
	public ResponseEntity<?> save(@RequestBody Pedido pedido) {
		Pedido pedidoGerado = pedidoService.save(pedido);
		return ResponseEntity.ok(pedidoGerado .getId());
	}

}
