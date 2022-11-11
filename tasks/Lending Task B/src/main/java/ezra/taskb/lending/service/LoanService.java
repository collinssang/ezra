package ezra.taskb.lending.service;

import ezra.taskb.lending.model.Loans;

import javax.naming.LimitExceededException;

/**
 * Collins K. Sang
 * 11/11/22 8:54 AM
 * Lending Task B
 * LoanService
 * IntelliJ IDEA
 **/
public interface LoanService {
    Loans save(Loans loans1) throws Exception;
}
