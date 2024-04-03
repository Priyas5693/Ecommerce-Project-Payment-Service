package org.example.capstoneprojectpaymentservice.Services;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.example.capstoneprojectpaymentservice.DTOS.InitiatePaymentDTOs;
import org.example.capstoneprojectpaymentservice.PaymentGateway.PaymentGateway;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;

    PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String initiatePayment(String orderID, Long amount, String email, String phone)
            throws RazorpayException, StripeException {
        return paymentGateway.generatePaymentLink(orderID, amount, email, phone);
    }
}