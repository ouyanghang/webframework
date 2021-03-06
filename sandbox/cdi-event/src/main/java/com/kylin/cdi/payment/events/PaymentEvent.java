package com.kylin.cdi.payment.events;

import java.math.BigDecimal;
import java.util.Date;


public class PaymentEvent {

	private PaymentTypeEnum type;  //credit, debit or cash
	
	private BigDecimal amount;
	
	private Date datetime;
	
	
	public BigDecimal getAmount() {
		return amount;
	}
	
	public PaymentTypeEnum getType() {
		return type;
	}
	
	public void setType(PaymentTypeEnum type) {
		this.type = type;
	}
	
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	public Date getDatetime() {
		return datetime;
	}
	
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String toString(){
		return "EVT:"+getDatetime()+":$"+getAmount()+":"+getType();
	}
	
	
	
}
