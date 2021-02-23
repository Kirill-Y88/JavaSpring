package ru.geekbrains.SB4.repositories;

import ru.geekbrains.SB4.model.Product;

import java.util.List;

public interface IProductRepo {
    public List<Product> getProducts();

    public int read(String title);

    public Product readProduct(String title);

    public void write(int id, String title, int cost);

    public void write(Product product);

    public void update();

    public void delete(String title);

}