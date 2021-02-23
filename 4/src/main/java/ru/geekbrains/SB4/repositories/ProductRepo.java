package ru.geekbrains.SB4.repositories;

import org.springframework.stereotype.Component;
import ru.geekbrains.SB4.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepo implements IProductRepo {


    List<Product> products;

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public int read(String title){
        for (Product p: products  ) {
            if(p.getTitle().equals(title)){
                return p.getId();
            }
        }
        return 0;
    }

    @Override
    public Product readProduct(String title){
        for (Product p: products  ) {
            if(p.getTitle().equals(title)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void write(int id, String title, int cost){
        products.add(new Product(id, title, cost));
        update();
    }

    @Override
    public void write(Product product){
        products.add(product);
        update();
    }


    @Override
    public void update(){
        for (Product p:products ) {
            System.out.printf(" id = %d, title = %s, cost = %d  \n", p.getId(), p.getTitle(), p.getCost());
        }

    }
    @Override
    public void delete(String title) {
        Product temp = null;
        for (Product p: products  ) {
            if(p.getTitle().equals(title)){
                temp = p;
                break;
            }
        }
        products.remove(temp);
        if (temp.equals(null)){
            System.out.println(" Данный товар отсутствует");
        }
        update();
    }

    @PostConstruct
    public void init() {
        products = new ArrayList<>();
        products.add(new Product(1, "Milk", 15));
        products.add(new Product(2, "Bread", 55));
        products.add(new Product(3, "Ham", 100));
    }


}