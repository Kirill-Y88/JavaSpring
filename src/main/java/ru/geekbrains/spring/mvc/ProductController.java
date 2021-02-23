package ru.geekbrains.spring.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
public class ProductController {
ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("frontProducts", productService.getProductRepo().getProducts());
        return "product";
    }

    @GetMapping("/delete/{title}")
    public String deleteProduct(@PathVariable String title) {
        productService.getProductRepo().delete(title);
        return "redirect:/product/all";
    }




    //не получилось реализовать создание продукта через передачу параметров
    @PostMapping("/add")
    /*public String addProduct(@RequestParam(required = false) int id,
                             @RequestParam(required = false) String title,
                             @RequestParam(required = false) int cost) {*/
    public String addProduct(@ModelAttribute Product product) {
       // productService.productRepo.write(id, title, cost);
        productService.productRepo.write(product);
        return "redirect:/product/all";
    }


}
