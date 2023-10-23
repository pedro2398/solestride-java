package br.com.fiap.solestride;
import br.com.fiap.solestride.domain.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
   public static void main(String[] args) {

       EntityManagerFactory factory = Persistence.createEntityManagerFactory( "oracle");
       EntityManager manager = factory.createEntityManager();


       var produto = new Produto();
       produto.setCod_produto("123");
       produto.setDescricao("teste");
       produto.setNome("vasco");
       produto.setModelo("sla");
       produto.setFabricante("Fiap");

       manager.getTransaction().begin();
       manager.persist(produto);
       manager.getTransaction().commit();

       manager.close();
       factory.close();

   }
}