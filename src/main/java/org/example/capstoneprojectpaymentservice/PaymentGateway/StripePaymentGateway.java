package org.example.capstoneprojectpaymentservice.PaymentGateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Primary
@Service
public class StripePaymentGateway implements PaymentGateway
{
    @Value("${stripe.key.id}")
    String stripeAPIKey;
    @Override
    public String generatePaymentLink(String orderId, Long amount, String email, String phone) throws StripeException {
        Stripe.apiKey = stripeAPIKey;
//        PaymentLinkCreateParams params =
//                PaymentLinkCreateParams.builder()
//                        .addLineItem(
//                                PaymentLinkCreateParams.LineItem.builder()
//                                        .setPrice("price_1MoC3TLkdIwHu7ixcIbKelAC")
//                                        .setQuantity(1L)
//                                        .build()
//                        )
//                        .build();

        Map<String, Object> priceParams= new HashMap<>();
        priceParams.put("unit_amount",amount);
        priceParams.put("currency", "INR");

        Map<String, Object> productData= new HashMap<>();
        productData.put("name","iphone");
        priceParams.put("product_data",productData);

        Price price= Price.create(priceParams);


        Map<String,Object> lineItem1=new HashMap<>();
        lineItem1.put("price", price.getId());
        lineItem1.put("quantity",5);

        List<Object> lineItem=new ArrayList<>();
        lineItem.add(lineItem1);
        Map<String,Object> params=new HashMap<>();
        params.put("line_items",lineItem);

        PaymentLink paymentLink = PaymentLink.create(params);
        return paymentLink.toString();
    }
}
