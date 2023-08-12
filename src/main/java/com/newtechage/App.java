package com.newtechage;

import com.newtechage.entity.Product;
import com.newtechage.services.CrudRepository;
import com.newtechage.services.CrudRepositoryServiceImpl;

public class App{
    public static void main( String[] args ) {

        CrudRepository<Product,Integer> crudRepository =
                new CrudRepositoryServiceImpl<>(Product.class);

        Product product = new Product();
        product.setProductName("Car");
        product.setBasicPrice(6554.5f);
        product.setShippingFees(265.04f);
        product.setTotalPrice(6554.5f * 265.04f);

        product.setNames(new String[]{"hello","world","my","name"});

        crudRepository.save(product);
    }
}
