package com.service;

import com.domain.Calculation;
import com.domain.Category;
import com.repository.CalculationRepository;
import com.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CalculationService {

    private static CalculationRepository calculationRepository;

    public CalculationService(CalculationRepository calculationRepository) {
        this.calculationRepository = calculationRepository;
    }

    @Transactional
    public Calculation insert(Calculation calculation) {
        calculation.setTax(calculation.getTax());
        calculation.setTaxable(calculation.getTaxable());
        calculation.setTotalIncome(calculation.getTotalIncome());
        return calculationRepository.create(calculation);
    }

    @Transactional(readOnly = true)
    public Calculation get(Long id) {
        return calculationRepository.get(id);
    }

}
