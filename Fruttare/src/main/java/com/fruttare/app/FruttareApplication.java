package com.fruttare.app;

import com.fruttare.app.entities.*;
import com.fruttare.app.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class FruttareApplication {

    public static void main(String[] args) {
        SpringApplication.run(FruttareApplication.class, args);
    }

    @Component
    public static class TestPedidoReal implements CommandLineRunner {

        @Autowired
        private ClientRepository clientRepository;

        @Autowired
        private CategoryRepository categoryRepository;

        @Autowired
        private ProductRepository productRepository;

        @Autowired
        private SalesOrderRepository salesOrderRepository;

        @Autowired
        private OrderItemRepository orderItemRepository;

        @Override
        public void run(String... args) {
            try {
                // Criando um cliente
                Client client = new Client();
                client.setName("Pedro Coimbra");
                client.setCpf("02353085365");
                client.setAddress("Rua T");
                client.setPhone("98978654231");
                client.setCep("65987000");
                client.setCity("São Bernardo");
                client.setState("SP");

                // Criando uma categoria
                Category category = new Category();
                category.setName("Categoria do Produto");

                // Criando um produto associado à categoria
                Product product = new Product();
                product.setName("Produto 1");
                product.setDescription("Descrição do Produto 1");
                product.setPrice(BigDecimal.valueOf(10.00));
                product.getCategories().add(category);
                // Criando um pedido
                SalesOrder salesOrder = new SalesOrder();
                salesOrder.setClient(client);
                salesOrder.setDateOfIssue(Instant.now());
                salesOrder.setDeliveryDate(Instant.now().plus(30, ChronoUnit.DAYS));

                // Criando um item de pedido associado ao produto
                OrderItem orderItem = new OrderItem();
                orderItem.setProduct(product);
                orderItem.setSalesOrder(salesOrder);
                orderItem.setQuantity(2.0);
                orderItem.setUnitPrice(BigDecimal.valueOf(19.99));
                orderItem.setDiscount(BigDecimal.ZERO);
                orderItem.setTotalItems(orderItem.getUnitPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));

                // Adicionando o item ao pedido
                salesOrder.getItems().add(orderItem);

                // Calculando o total do pedido
                salesOrder.setTotalOrder(orderItem.getTotalItems());

                // Salvando no banco de dados usando Spring Data JPA repositories
                clientRepository.save(client);
                categoryRepository.save(category);
                productRepository.save(product);
                salesOrderRepository.save(salesOrder);
                orderItemRepository.save(orderItem);

                System.out.println("Pedido realizado com sucesso!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
