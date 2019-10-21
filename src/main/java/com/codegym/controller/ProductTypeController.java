package com.codegym.controller;

import com.codegym.model.ProductType;
import com.codegym.service.ProductService;
import com.codegym.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductTypeController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductTypeService productTypeService;
    @GetMapping("/productTypes")
    public ModelAndView listNoteType(Pageable pageable){
        Iterable<ProductType> productTypes = productTypeService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("productType/list");
        modelAndView.addObject("productTypes", productTypes);
        return modelAndView;
    }
    @GetMapping("/create-productType")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/productType/create");
        modelAndView.addObject("productType", new ProductType());
        return modelAndView;
    }
    @PostMapping("/create-productType")
    public ModelAndView saveNoteType(@ModelAttribute("productType") ProductType productType){
        productTypeService.save(productType);
        ModelAndView modelAndView = new ModelAndView("redirect:/productTypes");
        modelAndView.addObject("productType", new ProductType());
        modelAndView.addObject("message", "New productType created successfully!");
        return modelAndView;
    }
    @GetMapping("/edit-productType/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        ProductType productType = productTypeService.findById(id);
        if (productType != null) {
            ModelAndView modelAndView = new ModelAndView("/productType/edit");
            modelAndView.addObject("productType", productType);
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-noteType")
    public ModelAndView updateNoteType(@ModelAttribute("productType") ProductType productType){
        productTypeService.save(productType);
        ModelAndView modelAndView = new ModelAndView("redirect:/productTypes");
        modelAndView.addObject("productType", productType);
        modelAndView.addObject("message", "productType updated successfully");
        return modelAndView;
    }
    @GetMapping("/delete-noteType/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        ProductType productType = productTypeService.findById(id);
        if(productType != null) {
            ModelAndView modelAndView = new ModelAndView("/productType/delete");
            modelAndView.addObject("productType", productType);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-noteType/{id}")
    public String deleteNoteType(@PathVariable("id") long id){
        productTypeService.remove(id);
        return "redirect:/productTypes";
    }



}
