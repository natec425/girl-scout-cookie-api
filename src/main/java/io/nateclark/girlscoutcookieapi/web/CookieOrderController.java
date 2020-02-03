package io.nateclark.girlscoutcookieapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.nateclark.girlscoutcookieapi.data.CookieOrderRepository;
import io.nateclark.girlscoutcookieapi.domain.CookieOrder;

@RestController
public class CookieOrderController {

    private CookieOrderRepository cookieOrderRepository;

    @Autowired
    public CookieOrderController(CookieOrderRepository cookieOrderRepository) {
        this.cookieOrderRepository = cookieOrderRepository;
    }

    @PostMapping
    public CookieOrder submitCookieOrder(@RequestBody CookieOrder cookieOrder) {
        return cookieOrderRepository.save(cookieOrder);
    }

    @GetMapping
    public Iterable<CookieOrder> allCookieOrders() {
        return cookieOrderRepository.findAll();
    }

    @GetMapping("/{id}")
    public CookieOrder getById(@PathVariable Integer id) {
        return cookieOrderRepository.findById(id);
    }
}