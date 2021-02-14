package ru.geekbrains.spring.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {


    public static void main(String[] args) {
        boolean end = false;
        String [] msg;
        Scanner sc = new Scanner(System.in);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = context.getBean("productService", ProductService.class);

        while (!end){

          msg = sc.nextLine().split(" ");
            if(msg[0].equals("write")){
                productService.getProductRepo().write(Integer.parseInt(msg[1]) , msg[2], Integer.parseInt(msg[3]));
            }
            if(msg[0].equals("read")){
                productService.getProductRepo().read(msg[1]);
            }
            if(msg[0].equals("delete")){
                productService.getProductRepo().delete(msg[1]);
            }
            if(msg[0].equals("update")){
                productService.getProductRepo().update();
            }
            if(msg[0].equals("quantityGoods")){
                productService.quantityGoods();
            }
            if(msg[0].equals("averageCost")){
                productService.averageCost();
            }
            if(msg[0].equals("out")){
                end = true;
            }

        }



        context.close();
    }

}
