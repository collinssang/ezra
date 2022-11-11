package ezra.taskb.lending.controller;

import ezra.taskb.lending.model.Loans;
import ezra.taskb.lending.model.Users;
import ezra.taskb.lending.service.LoanService;
import ezra.taskb.lending.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Collins K. Sang
 * 11/11/22 8:53 AM
 * Lending Task B
 * LoanController
 * IntelliJ IDEA
 **/
@RestController
@RequestMapping(name = "/request")
public class LoanController {

    final LoanService loanService;
    final UserService userService;

    @Autowired
    public LoanController(LoanService loanService, UserService userService) {
        this.loanService = loanService;
        this.userService = userService;
    }

    @PostMapping("/{phone_no}")
    public Loans requestLoans(@RequestBody Loans loans, @PathVariable("phone_no") String phone_no) {
        Users users = userService.findByPhoneNo(phone_no);
        Loans loans1 = new Loans();
        loans1.setUser_id(users);
        loans1.setLoan_amount(loans.getLoan_amount());
        loans1.setLoan_paid_amount(loans.getLoan_paid_amount());
        Loans loans2 = loanService.save(loans1);
        return loans2;
    }
}
