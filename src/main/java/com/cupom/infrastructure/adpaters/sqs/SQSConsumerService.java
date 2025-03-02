package com.cupom.infrastructure.adpaters.sqs;

import com.cupom.infrastructure.entities.CupomFiscalEntity;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Service;

@Service
public class SQSConsumerService {
    @SqsListener("cupons-fila")
    public void listen(CupomFiscalEntity cupomFiscalEntity) {

        System.out.println("received mesage" + cupomFiscalEntity);
    }
}

