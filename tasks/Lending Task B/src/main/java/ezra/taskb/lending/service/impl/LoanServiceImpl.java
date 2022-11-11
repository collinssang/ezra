package ezra.taskb.lending.service.impl;

import ezra.taskb.lending.model.Loans;
import ezra.taskb.lending.model.UserDefaultLoans;
import ezra.taskb.lending.repository.LoanRepository;
import ezra.taskb.lending.repository.UserDefaultLoansRepository;
import ezra.taskb.lending.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.naming.LimitExceededException;

/**
 * Collins K. Sang
 * 11/11/22 8:54 AM
 * Lending Task B
 * LoanServiceImpl
 * IntelliJ IDEA
 **/
@Service
public class LoanServiceImpl implements LoanService {
    final LoanRepository loanRepository;
    final UserDefaultLoansRepository userDefaultLoansRepository;
    @Value("${loan.limit.amount}")
    private double limit;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, UserDefaultLoansRepository userDefaultLoansRepository) {
        this.loanRepository = loanRepository;
        this.userDefaultLoansRepository = userDefaultLoansRepository;
    }

    @Override
    public Loans save(Loans loans1) throws Exception {
        if (loans1.getLoan_limit() > limit) throw new LimitExceededException("Loan limit exceeded");
        UserDefaultLoans userDefaultLoans = userDefaultLoansRepository.findByUserId(loans1.getUser_id());
        if (userDefaultLoans != null) throw new Exception("You still have loans on default");
        if (!loans1.getUser_id().is_eligible()) throw new Exception("Not Eligible for a loan");
        return loanRepository.save(loans1);
    }
}
