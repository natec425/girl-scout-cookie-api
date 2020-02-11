package io.nateclark.girlscoutcookieapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.nateclark.girlscoutcookieapi.data.CookieOrderRepository;
import io.nateclark.girlscoutcookieapi.domain.CookieOrder;

@RestController
@RequestMapping("/cookie_orders")
public class CookieOrderController {

    private CookieOrderRepository cookieOrderRepository;

    @Autowired
    public CookieOrderController(CookieOrderRepository cookieOrderRepository) {
        this.cookieOrderRepository = cookieOrderRepository;
    }

    @PostMapping
    public CookieOrder create(@RequestBody CookieOrder cookieOrder) {
        return cookieOrderRepository.save(cookieOrder);
    }

    @GetMapping
    public Iterable<CookieOrder> all() {
        return cookieOrderRepository.findAll();
    }

    @GetMapping("/{id}")
    public CookieOrder one(@PathVariable Integer id) {
        return cookieOrderRepository.findById(id);
    }

    @PatchMapping("/{id}")
    public CookieOrder partialUpdate(@PathVariable Integer id, @RequestBody CookieOrder cookieOrder) {
        CookieOrder original = cookieOrderRepository.findById(id);
        original.update(cookieOrder);
        return cookieOrderRepository.save(original);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        cookieOrderRepository.delete(id);
    }
}