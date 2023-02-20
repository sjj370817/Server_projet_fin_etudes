package jean.jerome.caramazinlease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jean.jerome.caramazinlease.car.CarService;
import jean.jerome.caramazinlease.client.ClientService;
import jean.jerome.caramazinlease.contract.ContractService;
import jean.jerome.caramazinlease.invoice.InvoiceService;


@SpringBootApplication
public class CarsLeaseApplication implements CommandLineRunner{
	@Autowired
	CarService carService;
	
	@Autowired
	ContractService contractService;
	
	@Autowired 
	ClientService clientService;
	
	@Autowired 
	InvoiceService invoiceService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CarsLeaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
	
	
}
