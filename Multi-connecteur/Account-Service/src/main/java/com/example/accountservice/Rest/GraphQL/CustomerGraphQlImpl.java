package com.example.accountservice.Rest.GraphQL;

import com.example.accountservice.Model.Customer;

import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.List;
@Service
@Transactional
public class CustomerGraphQlImpl implements CustomerGraphQl {
    private static String path = "http://localhost:8081/graphql";
    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer findById(Long id) {

        HttpGraphQlClient graphQlClient = HttpGraphQlClient.builder()
                .url(path)
                .build();
        var httpRequestDocument = """
                query($id:Int){
                   findByid(id:$id){
                      id,email,nom
                   }
                 }
                """;
        Mono<Customer> customer= graphQlClient.document(httpRequestDocument).variable("id",id).retrieve("findByid").toEntity(Customer.class);
        return customer.block();
    }

    @Override
    public List<Customer> findAll() {
        HttpGraphQlClient graphQlClient = HttpGraphQlClient.builder()
                .url(path)
                .build();
        var httpRequestDocument = """
                query{
                  findAll{
                    id,email,nom
                  }
                }
                """;
        Mono<List<Customer>> customers = graphQlClient.document(httpRequestDocument)
                .retrieve("findall")
                .toEntityList(Customer.class);

        List<Customer> customerList = customers.block();
        return customerList;
    }
}
