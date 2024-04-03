package org.example.capstoneprojectpaymentservice.PaymentGateway;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentGateway {
  String generatePaymentLink(String orderId, Long amount, String email, String phone) throws RazorpayException, StripeException;

}
