package org.littlenet.accounting.service;

import org.littlenet.accounting.model.Account;

public interface AccountingService {
	boolean addAccount(Account account);

	boolean deleteAccount(String username);

	boolean updateAccount(Account account);

	boolean isExists(String username);
}
