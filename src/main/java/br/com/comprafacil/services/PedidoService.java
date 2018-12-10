package br.com.comprafacil.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.comprafacil.model.Pedido;
import br.com.comprafacil.repository.PedidoRepository;

@Service
public class PedidoService {

	private PedidoRepository pedidoRepository;

	@Autowired
	public void setDao(PedidoRepository repository) {
		this.pedidoRepository = repository;
	}

	public Pedido save(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public Optional<Pedido> findById(Long id) {
		return pedidoRepository.findById(id);
	}
	
	public Iterable<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

}
