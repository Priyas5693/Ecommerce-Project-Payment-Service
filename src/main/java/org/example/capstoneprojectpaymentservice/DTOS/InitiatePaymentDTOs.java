package org.example.capstoneprojectpaymentservice.DTOS;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class InitiatePaymentDTOs {
    String orderID;
    Long amount;
    String email;
    String phoneNum;

}
