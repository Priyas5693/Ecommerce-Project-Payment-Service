package org.example.capstoneprojectpaymentservice.configs;


import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.example.capstoneprojectpaymentservice.PaymentGateway.RazorPayPaymentGateway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class paymentGatewayConfigs {
   @Value("${razorpay.key.id}")
    private String razorpayID;

    @Value("${razorpay.key.secret}")
    private String razorpaySecret;

    @Bean
    public RazorpayClient createrazorPayClient() throws RazorpayException {
        return new RazorpayClient(razorpayID,razorpaySecret);
    }
}
