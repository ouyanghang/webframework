package com.kylin.cdi.payment.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;


import com.kylin.cdi.payment.events.PaymentEvent;
import com.kylin.cdi.payment.qualifiers.Cash;
import com.kylin.cdi.payment.qualifiers.Credit;
import com.kylin.cdi.payment.qualifiers.Debit;

@SessionScoped
public class PaymentHandler implements Serializable,ICreditEventObserver, IDebitEventObserver, ICashEventObserver {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger logger;
	
	List<PaymentEvent> payments=new ArrayList<PaymentEvent>();
	
	@Produces
	@Named
	public List<PaymentEvent> getPayments() {
		return payments;
	}

	public void onCreditPaymentEvent(@Observes @Credit PaymentEvent event){

		logger.info("Processing the credit operation " + event);
		payments.add(event);
	}

	public void onDebitPaymentEvent(@Observes @Debit PaymentEvent event) {
		
		logger.info("Processing the debit operation " + event);
		payments.add(event);
		
	}

	public void onCashPaymentEvent(@Observes @Cash PaymentEvent event) {
		
		logger.info("Processing the cash operation " + event);
		payments.add(event);
	}

}
