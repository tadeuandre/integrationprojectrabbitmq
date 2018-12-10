package br.com.comprafacil;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.comprafacil.model.Destinatario;
import br.com.comprafacil.model.Entrega;
import br.com.comprafacil.model.Loja;
import br.com.comprafacil.model.Pedido;
import br.com.comprafacil.model.Produto;
import br.com.comprafacil.objectvalue.SituacaoEntrega;

@SpringBootApplication
public class CompraFacilApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CompraFacilApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pedido pedido = new Pedido();
		pedido.setDataCompra(LocalDateTime.now());
		pedido.setDestinatario(new Destinatario());
		pedido.getDestinatario().setComplemento("BLOCO A APTO 301");
		pedido.getDestinatario().setEndereco("RUA DIAS DA ROCHA");
		pedido.getDestinatario().setNome("ROBERTO GOMES FERREIRA");
		pedido.getDestinatario().setReferencia("SUBWAY");
		
		pedido.setEntrega(new Entrega());
		pedido.getEntrega().setFrete(new BigDecimal(29.9));
		pedido.getEntrega().setStatusEntrega(SituacaoEntrega.EM_TRANSPORTE);
		
		pedido.setLoja(new Loja());
		pedido.getLoja().setCnpj("05.570.714/0001-59");
		pedido.getLoja().setFantasia("KaBuM!");
		pedido.getLoja().setRazaoSocial("KaBuM! Comércio Eletrônico S/A");
		
		pedido.setProduto(new Produto());
		pedido.getProduto().setDescricao("MAC BOOK AIR 128 SSD");
		pedido.getProduto().setQuantidadeEstoque(Long.valueOf(1));
		pedido.getProduto().setValorAtual("R$ 4.299.90");
	}
}
