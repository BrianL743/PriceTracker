package dev.lk.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.lk.entities.Product;
import dev.lk.services.ProductService;

@Component
@CrossOrigin("*")
@RestController
public class PriceController {

}
