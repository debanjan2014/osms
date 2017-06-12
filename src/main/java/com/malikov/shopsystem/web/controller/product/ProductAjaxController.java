package com.malikov.shopsystem.web.controller.product;

import com.malikov.shopsystem.model.Product;
import com.malikov.shopsystem.to.ProductTo;
import com.malikov.shopsystem.util.ProductUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping(value = "/ajax/profile/products")
public class ProductAjaxController extends AbstractProductController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductTo> getAll() {
        return super.getAll();
    }

    @GetMapping(value = "/{id}")
    public Product get(@PathVariable("id") Long id) {
        return super.get(id);
    }


    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        super.delete(id);
    }

    @PostMapping
    public ResponseEntity<String> updateOrCreate(@Valid ProductTo productTo, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            result.getFieldErrors().forEach(fe -> sb.append(fe.getField()).append(" ").append(fe.getDefaultMessage()).append("<br>"));
            return new ResponseEntity<>(sb.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        if (productTo.isNew()) {
            super.create(ProductUtil.createNewFromTo(productTo));
        } else {
            Product product = super.get(productTo.getProductVariationId());
            super.update(ProductUtil.updateFromTo(product, productTo), productTo.getProductVariationId());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductTo> getBetween(
            @RequestParam(value = "startDate", required = false) LocalDate startDate,
            @RequestParam(value = "startTime", required = false) LocalTime startTime,
            @RequestParam(value = "endDate", required = false) LocalDate endDate,
            @RequestParam(value = "endTime", required = false) LocalTime endTime) {
        return super.getBetween(startDate, startTime, endDate, endTime);
    }

    @PostMapping(value = "/{id}/change-unlimited")
    public void changeUnlimited(@PathVariable("id") Long id, @RequestParam("unlimited") boolean unlimited) {
        super.enableUnlimited(id, unlimited);
    }

    @PostMapping(value = "/{id}/change-variations")
    public void changeHasVariations(@PathVariable("id") Long id, @RequestParam("hasVariations") boolean hasVariations) {
        super.enableHasVariations(id, hasVariations);
    }

}