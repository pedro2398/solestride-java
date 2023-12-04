package br.com.fiap.solestride;
import br.com.fiap.solestride.domain.entity.pessoa.Comprador;
import br.com.fiap.solestride.domain.entity.pessoa.Fabricante;
import br.com.fiap.solestride.domain.entity.pessoa.Fornecedor;
import br.com.fiap.solestride.domain.entity.Produto;
import br.com.fiap.solestride.domain.entity.Requisicao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
   public static void main(String[] args) {

       EntityManagerFactory factory = Persistence.createEntityManagerFactory( "oracle");
       EntityManager manager = factory.createEntityManager();

       var fornecedor = new Fornecedor();
       fornecedor.setNome("Bedex Distribuicoes");
       fornecedor.setCnpj("35.222.002/0001-00");
       fornecedor.setEmail("bdx@fiap.com.br");
       fornecedor.setSenha("789");
       fornecedor.setModTributario("distribuidor3");

       var fabricante = new Fabricante();
       fabricante.setCnpj("35.111.002/0001-00");
       fabricante.setNome("Faber Castel");
       fabricante.setEmail("faber@gmail.com.br");
       fabricante.setSenha("12345");
       fabricante.setModTributario("Tributario Fabricante");

       var produto = new Produto();
       produto.setNome("Caneta");
       produto.setCodProduto("198fds21");
       produto.setDescricao("Caneta BIC azul");
       produto.setModelo("Esferografica");
       produto.setFabricante(fabricante);
       produto.setFornecedores(fornecedor);

       var requisicao = new Requisicao();
       requisicao.setCodRequisicao("879jhu90");
       requisicao.setQuantidade(3);
       requisicao.setTetoAutomatico(BigDecimal.valueOf(0.99));
       requisicao.setData(LocalDate.now());
       requisicao.setProduto(produto);

       var comprador = new Comprador();
       comprador.setNome("BenezinBusines");
       comprador.setCnpj("93.369.539/0001-01");
       comprador.setEmail("benebusines@fiap.com.br");
       comprador.setSenha("456");
       comprador.setModTributario("tributario1");

       manager.getTransaction().begin();
       manager.persist(fabricante);
       manager.persist(fornecedor);
       manager.persist(produto);
       manager.persist(requisicao);
       manager.persist(comprador);
       manager.getTransaction().commit();

       manager.close();
       factory.close();
   }

}