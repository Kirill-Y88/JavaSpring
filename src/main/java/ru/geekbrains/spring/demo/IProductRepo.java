package ru.geekbrains.spring.demo;

import java.util.List;

public interface IProductRepo {
    public List<Product> getProducts();

    public int read(String title);

    public void write(int id, String title, int cost);

    public void update();

    public void delete(String title);

}
