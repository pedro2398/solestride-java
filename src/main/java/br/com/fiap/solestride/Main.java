package br.com.fiap.solestride;
import br.com.fiap.solestride.domain.Comprador;
import br.com.fiap.solestride.domain.Fornecedor;
import br.com.fiap.solestride.domain.Produto;
import br.com.fiap.solestride.domain.Requisicao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
   public static void main(String[] args) {

       EntityManagerFactory factory = Persistence.createEntityManagerFactory( "oracle");
       EntityManager manager = factory.createEntityManager();

       List<Fornecedor> fornecedores = findAllFornecedores(manager);

       var fornecedor = new Fornecedor();
       fornecedor.setNome("Bedex Distribuicoes");
       fornecedor.setCNPJ_for("35.222.002/0001-00");
       fornecedor.setEmail("bdx@fiap.com.br");
       fornecedor.setSenha("789");
       fornecedor.setMod_tributario_form("distribuidor3");

       var produto = new Produto();
       produto.setNome("Caneta");
       produto.setCod_produto("198fds21");
       produto.setDescricao("Caneta BIC azul");
       produto.setModelo("Esferografica");
       produto.setFabricante("BIC");

       for (Fornecedor forn : fornecedores) {
           produto.addFornecedor(forn);
       }

       var requisicao = new Requisicao();
       requisicao.setCod_requisicao("879jhu90");
       requisicao.setQuantidade(3);
       requisicao.setTeto_automatico(BigDecimal.valueOf(0.99));
       requisicao.setData(LocalDate.now());
       requisicao.setId_req_produto(produto);

       var comprador = new Comprador();
       comprador.setNome("BenezinBusines");
       comprador.setCNPJ_comp("93.369.539/0001-01");
       comprador.setEmail("benebusines@fiap.com.br");
       comprador.setSenha("456");
       comprador.setMod_tributario_comp("tributario1");

       manager.getTransaction().begin();
       manager.persist(fornecedor);
       manager.persist(produto);
       manager.persist(requisicao);
       manager.persist(comprador);
       manager.getTransaction().commit();

       manager.close();
       factory.close();
   }

    private static List findAllFornecedores(EntityManager manager) {
        String jpql = "FROM Fornecedor";
        return manager.createQuery(jpql).getResultList();
    }
}