package com.malikov.shopsystem.web.controller;

import com.malikov.shopsystem.dto.ProductDto;
import com.malikov.shopsystem.model.Product;
import com.malikov.shopsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelMap getProductTablePage(@RequestParam("pageNumber") int pageNumber,
                                         @RequestParam("pageCapacity") int pageCapacity) {
        ModelMap modelMap = new ModelMap();
        Page<ProductDto> page = productService.getPage(pageNumber, pageCapacity);
        modelMap.addAttribute("totalElements", page.getTotalElements());
        modelMap.addAttribute("elements", page.getContent());
        return modelMap;
    }
/*

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelMap getByCategoryName(@RequestParam("pageNumber") int pageNumber,
                                       @RequestParam("pageCapacity") int pageCapacity,
                                       @RequestParam("categoryName") String categoryName) {
        ModelMap modelMap = new ModelMap();
        Page<ProductDto> page = productService.getPageByCategoryName(categoryName, pageNumber, pageCapacity);
        modelMap.addAttribute("totalElements", page.getTotalElements());
        modelMap.addAttribute("elements", page.getContent());
        return modelMap;
    }
*/

    @GetMapping(value = "/{id}")
    public Product get(@PathVariable("id") Long id) {
        return productService.get(id);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        productService.delete(id);
    }

    @PutMapping(value = "/{id}")
    public void updateProduct(@PathVariable("id") Long id, ProductDto productDto){
        productDto.setProductId(id);
        productService.update(productDto);
    }
/*
    @PutMapping(value = "/{id}/unlimited-state")
    public void changeUnlimited(@PathVariable("id") Long id, @RequestParam("unlimited") boolean unlimited) {
        productService.enableUnlimited(id, unlimited);
    }

    @PutMapping(value = "/{id}/has-variations-state")
    public void changeHasVariations(@PathVariable("id") Long id, @RequestParam("hasVariations") boolean hasVariations) {
        productService.enableHasVariations(id, hasVariations);
    }*/
}
