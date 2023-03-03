package com.project.TechnicalTest.Repository;

import com.project.TechnicalTest.Models.MasterCurrency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MasterCurrencyRepository extends CrudRepository<MasterCurrency, String> {
}
