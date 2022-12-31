package com.service;

import com.domain.Tax;
import com.repository.TaxRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaxService {
    private static TaxRepository taxRepository;

    public TaxService(TaxRepository taxRepository) {
        this.taxRepository = taxRepository;
    }

    @Transactional
    public Tax insert(Tax tax) {
        tax.setBasicSalary(String.valueOf(tax.getBasicSalary()));
        tax.setHouseRent(String.valueOf(tax.getHouseRent()));
        tax.setMedical(String.valueOf(tax.getMedical()));
        tax.setConveyance(String.valueOf(tax.getConveyance()));
        tax.setBonus(String.valueOf(tax.getBonus()));
        tax.setCategory(tax.getCategory());
        return taxRepository.create(tax);
    }

}
