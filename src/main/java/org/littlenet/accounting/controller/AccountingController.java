package org.littlenet.accounting.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.littlenet.accounting.model.Account;
import org.littlenet.accounting.service.AccountingService;

@RestController
@RequestMapping("accounts")
@Validated // required annotation for additional validation of parameters
public class AccountingController {

	public AccountingController(AccountingService accountingService) {
		this.accountingService = accountingService;
	}

	AccountingService accountingService;

	@PostMapping
	String addAccount(@RequestBody @Valid Account account) {
		String res = String.format("account with username %s already exists", account.username);
		if (accountingService.addAccount(account)) {
			res = String.format("account with username %s has been added", account.username);
		}
		return res;
	}

	@DeleteMapping("/{username}")
	String deleteAccount(@PathVariable @Email String username) {
		String res = String.format("account with username %s doesn't exist", username);
		if (accountingService.deleteAccount(username)) {
			res = String.format("account with username %s has been deleted", username);
		}
		return res;
	}

	@PutMapping
	String updateAccount(@RequestBody @Valid Account account) {
		String res = String.format("account with username %s doesn't exist", account.username);
		if (accountingService.updateAccount(account)) {
			res = String.format("account with username %s has been updated", account.username);
		}
		return res;
	}

	@GetMapping("/{username}")
	String hasAccount(@PathVariable @Email String username) {
		String res = String.format("account with username %s doesn't exist", username);
		if (accountingService.isExists(username)) {
			res = String.format("account with username %s exists", username);
		}
		return res;
	}
	
	@GetMapping("/isalive")
	String isalive() {
		return "yes";
	}

}
