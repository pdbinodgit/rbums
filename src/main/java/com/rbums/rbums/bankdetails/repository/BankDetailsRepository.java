package com.rbums.rbums.bankdetails.repository;

import com.rbums.rbums.bankdetails.model.BankDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankDetailsRepository extends JpaRepository<BankDetails,Long> {
}
