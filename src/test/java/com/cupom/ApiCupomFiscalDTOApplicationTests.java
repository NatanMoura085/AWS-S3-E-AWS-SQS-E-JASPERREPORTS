package com.cupom;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "cloud.aws.sqs.enabled=false")
class ApiCupomFiscalDTOApplicationTests {

	@Test
	void contextLoads() {
	}

}
