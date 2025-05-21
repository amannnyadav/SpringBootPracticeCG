package org.cg.shoppingcart;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/home")
public class ShoppingCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingCartApplication.class, args);
    }
    static List<Product> products=new ArrayList<>();
    static List<Product> cart=new ArrayList<>();

    @GetMapping
    public List<Product> show(){
        return products;
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product){
        products.add(product);
        return "Product added!";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestBody Product product){
        cart.add(product);
        return "Product added to cart!";
    }

    @GetMapping("/showCart")
    public List<Product> showCart(){
        return cart;
    }

    @PutMapping("/edit/{id}")
    public String editCart(@PathVariable String id, @RequestBody Product cart){
        for(Product p: ShoppingCartApplication.cart){
            if(p.getId().equals(id)){
                p.setName(cart.getName());
                p.setPrice(cart.getPrice());
                p.setQuantity(cart.getQuantity());
            }
        }
        return "Product with "+id+" updated.";
    }

    @GetMapping("/total")
    public double cart(){
        double sum=0.0;
        for(Product c: cart){
            sum+=c.getPrice();
        }
        return sum;
    }
}

