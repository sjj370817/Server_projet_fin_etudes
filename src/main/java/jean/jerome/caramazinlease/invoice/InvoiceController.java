package jean.jerome.caramazinlease.invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/invoices")
@CrossOrigin(origins = "http://localhost:3000")
public class InvoiceController  {
	@Autowired
	InvoiceService invoiceService;
	
	@GetMapping("/")
	public ResponseEntity<List<Invoice>> getAllInvoice(){
		List<Invoice> invoices = invoiceService.getAll();
		return new ResponseEntity<>(invoices, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Invoice> getById(@PathVariable("id") long id){
		Invoice invoice = invoiceService.getById(id);
		
		if(invoice != null) 
			return new ResponseEntity<>(invoice, HttpStatus.OK);
		else 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") long id){
		if (invoiceService.deleteById(id) == true)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		else
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("/")
	public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice){
		try {
			Invoice createdInvoice = invoiceService.save(invoice);
			return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	  public ResponseEntity<Invoice> updateInvoice(@PathVariable("id") long id, @RequestBody Invoice invoice) {
	    Invoice existingInvoice= invoiceService.getById(id);

	    if (existingInvoice != null) {
	      Invoice updatedInvoice= new Invoice();
	      updatedInvoice.setId(existingInvoice.getId());
	      updatedInvoice.setDate(invoice.getDate());
	      updatedInvoice.setAmount(invoice.getAmount());
	      return new ResponseEntity<>(invoiceService.save(updatedInvoice), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
}
