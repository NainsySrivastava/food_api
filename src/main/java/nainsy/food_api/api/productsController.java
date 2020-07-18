package nainsy.food_api.api;

import nainsy.food_api.model.Product;
import nainsy.food_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class productsController {
    @Autowired
    private ProductService productService;

    @GetMapping("/api/v1/products")
    public Map<String, Object> productList(){
        Map<String,Object> returnMap=new HashMap<>();

        List<Product> products= productService.getProducts();
        if (products!=null) {
            returnMap.put("success","true");
            returnMap.put("total",products.size());
            returnMap.put("products", products);
        }else
        {
            returnMap.put("success","false");
            returnMap.put("msg","No Valid UserList Received");
        }
        return  returnMap;

    }

    @GetMapping("/api/v1/getproduct/{id}")
    public Map<String,Object> product(@PathVariable int id)
    {
        Map<String,Object> map=new HashMap<>();
        Product gotProduct=productService.getProduct(id);
        if (gotProduct!=null)
        {
            map.put("success","true");
            map.put("product",gotProduct);
        }else
        {
            map.put("success","false");
            map.put("msg","No such User exist with id "+id);
        }

        return map;

    }

    @PostMapping("/api/v1/addproduct")
    public Map<String,Object> addproduct(@RequestBody Product product)
    {

        Map<String,Object> map=new HashMap<>();
        int returnedId= productService.addProduct(product);

        if (returnedId>=1) {
            map.put("success", "true");
            map.put("msg", "Product Added Successfully");
            map.put("product",productService.getProduct(returnedId));
        }else
        {
            map.put("success","false");
            map.put("msg","can not Register User ");
        }
        return map;
    }




}
