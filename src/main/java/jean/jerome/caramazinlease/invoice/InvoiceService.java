package jean.jerome.caramazinlease.invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
	@Autowired
	InvoiceRepository invoiceRepository;
	
	public Invoice save(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}
	
	public List<Invoice> getAll(){
		return invoiceRepository.findAll();
	}
	
	public Invoice getById(long id) {
		return invoiceRepository.findById(id).orElse(null);
	}
	
	public boolean deleteById(long id) {
		try {
			invoiceRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
