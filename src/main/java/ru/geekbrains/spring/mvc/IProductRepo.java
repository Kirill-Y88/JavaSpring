package ru.geekbrains.spring.mvc;

import java.util.List;

public interface IProductRepo {
    public List<Product> getProducts();

    public int read(String title);

    public void write(int id, String title, int cost);

    public void write(Product product);

    public void update();

    public void delete(String title);

}
