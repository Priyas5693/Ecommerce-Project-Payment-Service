package org.example.capstoneprojectpaymentservice.Controllers;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import org.example.capstoneprojectpaymentservice.DTOS.InitiatePaymentDTOs;
import org.example.capstoneprojectpaymentservice.Services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;
    PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }
    @PostMapping("/")
    public String initiatePayment(@RequestBody InitiatePaymentDTOs initiatePaymentDTOs) throws RazorpayException, StripeException {
        return paymentService.initiatePayment(initiatePaymentDTOs.getOrderID(),initiatePaymentDTOs.getAmount(),
                initiatePaymentDTOs.getEmail(),initiatePaymentDTOs.getPhoneNum());
    }

}
