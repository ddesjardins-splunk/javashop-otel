package com.shabushabu.javashop.shop.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.shabushabu.javashop.shop.services.dto.ProductDTO;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ProductRepo {

    @Value("${productsUri}")
    private String productsUri;

    @Autowired
    @Qualifier(value = "stdRestTemplate")
    private RestTemplate restTemplate;


    public Map<String, ProductDTO> getProductDTOs() {
        ResponseEntity<List<ProductDTO>> productCatalogueResponse =
                restTemplate.exchange(productsUri + "/products",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductDTO>>() {
                        });
        List<ProductDTO> productDTOs = productCatalogueResponse.getBody();

        return productDTOs.stream()
                .collect(Collectors.toMap(ProductDTO::getId, Function.identity()));
    }
}
