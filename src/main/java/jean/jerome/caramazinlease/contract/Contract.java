package jean.jerome.caramazinlease.contract;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jean.jerome.caramazinlease.car.Car;
import jean.jerome.caramazinlease.client.Client;
import jean.jerome.caramazinlease.invoice.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="contract")
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Temporal(TemporalType.DATE)
	private Date start;
	
	@Temporal(TemporalType.DATE)
	private Date end;
	
	private double totalPrice;
	private double advance;
	private double leftToPay;
	@Column(length = 30)
	private String placeOfReturn;
	
	@ManyToOne
	@JsonProperty(access= Access.WRITE_ONLY)
	private Car car;
	
	@OneToOne
	@JoinColumn(name = "invoice_id", referencedColumnName = "id")
	@JsonProperty(access= Access.WRITE_ONLY)
	private Invoice invoice;
	
	@ManyToOne
	@JsonProperty(access= Access.WRITE_ONLY)
	private Client client;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
