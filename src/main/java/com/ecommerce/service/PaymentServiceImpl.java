package com.ecommerce.service;

import com.ecommerce.entities.Order;
import com.ecommerce.entities.PaymentEntity;
import com.ecommerce.exception.NotFoundException;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.PaymentRequest;
import com.ecommerce.model.PaymentResponse;
import com.ecommerce.repository.PaymentRepos;
import com.ecommerce.util.DateConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * The type Customer payment service.
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    /**
     * The Customer payment repos.
     */
    @Autowired
    PaymentRepos paymentRepos;

    @Override
    public PaymentResponse payment(PaymentRequest paymentRequest) {
        verifyPaymentRequest(paymentRequest);
        PaymentResponse paymentResponse =  new PaymentResponse();
        return updatePaymentDetails(paymentResponse, paymentRequest);
    }

    @Override
    public Long initiatePayment(Order order) {
        PaymentEntity paymentEntity = PaymentEntity.builder().orderId(order.getId()).orderAmount(order.getTotalOrderPrice()).build();
        Long paymentId = paymentRepos.save(paymentEntity).getId();
        return paymentId;
    }

    private PaymentResponse updatePaymentDetails(PaymentResponse paymentResponse, PaymentRequest paymentRequest) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setOrderAmount(paymentRequest.getOrderAmount());
        paymentEntity.setOrderId(paymentRequest.getOrderId());
        paymentEntity.setPaymentMode(paymentRequest.getPaymentMode());
        paymentEntity.setTxStatus("SUCCESS");
        paymentEntity.setCreatedTimestamp(DateConverterUtil.toLocalDateTimeConvert(LocalDateTime.now()));
        PaymentEntity savedCustomerEntity = paymentRepos.save(paymentEntity);
        if(savedCustomerEntity !=null ){
            paymentResponse.setMsg("Your Payment is successfully done , Its id is "+ savedCustomerEntity.getId());

        }
        return paymentResponse;
    }

    private void verifyPaymentRequest(PaymentRequest paymentRequest) {
        if (paymentRequest.getInitialPaymentRef() == null) {
            throw new NotFoundException("initialPaymentRef attribute is mandatory in payment request!!");
        }
        Optional<PaymentEntity> paymentEntityOptional = paymentRepos.findById(paymentRequest.getInitialPaymentRef());
        if(!paymentEntityOptional.isPresent()){
            throw new ResourceNotFoundException("Provided payment id does not exist in database.");
        }
    }

}
