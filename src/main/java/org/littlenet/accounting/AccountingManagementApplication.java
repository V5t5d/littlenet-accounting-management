package org.littlenet.accounting;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ComponentScan(basePackages = {"org.littlenet"})
public class AccountingManagementApplication {

	public static void main(String[] args) {
		var ct = SpringApplication.run(AccountingManagementApplication.class, args);
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("for shutdown type 'exit'");
			String line = scanner.nextLine();
			if (line.equalsIgnoreCase("exit")) {
				break;
			}
			
		}
		ct.close();
	}
}
