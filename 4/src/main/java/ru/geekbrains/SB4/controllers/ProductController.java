package ru.geekbrains.SB4.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.SB4.model.Product;
import ru.geekbrains.SB4.servise.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProducts(Model model) {
        model.addAttribute("frontProducts", productService.getProductRepo().getProducts());
        return "product";
    }

    @GetMapping("/delete/{title}")
    public String deleteProduct(@PathVariable String title) {
        productService.getProductRepo().delete(title);
        return "redirect:/product";
    }


    //не получилось реализовать создание продукта через передачу параметров
    @PostMapping("/add")
    /*public String addProduct(@RequestParam(required = false) int id,
                             @RequestParam(required = false) String title,
                             @RequestParam(required = false) int cost) {*/
    public String addProduct(@ModelAttribute Product product) {
        // productService.productRepo.write(id, title, cost);
        productService.getProductRepo().write(product);

        return "redirect:/product";
    }

    @PostMapping("/find")
    public String findProduct(Model model,
                              @RequestParam(required = false, name = "title") String nameProduct){
    model.addAttribute("findProducts", productService.getProductRepo().readProduct(nameProduct));
    return "/find";
    }




}
