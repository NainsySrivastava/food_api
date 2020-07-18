package nainsy.food_api.services;

import nainsy.food_api.database.ProductRepository;
import nainsy.food_api.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public int addProduct(Product product)
    {

        Product product1= productRepository.save(product);
        return product1.getId();
    }

    public List<Product> getProducts()
    {
        ArrayList<Product> products= (ArrayList<Product>) productRepository.findAll();
        return products;
    }
    public Product getProduct(int id)
    {
        return productRepository.findById(id).orElse(null);
    }

}

