package nainsy.food_api.api;

import nainsy.food_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class productsController {
@Autowired
    private ProductService productService;



}
