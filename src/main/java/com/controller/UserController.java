package com.controller;

import com.domain.Calculation;
import com.domain.Tax;
import com.domain.User;
import com.exception.NotFoundAlertException;
import com.service.CalculationService;
import com.service.TaxService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Controller
@RequestMapping("/tax")
public class UserController {
    private TaxService taxService;
    private CalculationService calculationService;

    public UserController(TaxService taxService) {
        this.taxService = taxService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/tax")
    public ResponseEntity<Tax> tax(@Valid @RequestBody Tax tax) throws URISyntaxException {
        Tax newTax = taxService.insert(tax);
        return ResponseEntity.created(new URI("/calculation"))
                .body(null);
    }

    @PostMapping("/calculation")
    public ResponseEntity<Calculation> calculation(@Valid @RequestBody Calculation calculation) throws URISyntaxException {
        Calculation newCalculation = calculationService.insert(calculation);
        return ResponseEntity.created(new URI("/tax"))
                .body(null);
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<Calculation> getHistory(@PathVariable Long id) {
        Optional<Calculation> calculation = Optional.ofNullable(calculationService.get(id));
        if (calculation.isPresent()) {
            return ResponseEntity.ok().body(calculation.get());
        }
        throw new NotFoundAlertException("Record not found [" + id + "]");
    }

}
