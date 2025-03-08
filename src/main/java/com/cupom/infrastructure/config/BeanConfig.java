package com.cupom.infrastructure.config;

import com.cupom.core.adapters.CupomFiscalElasticServiceIMPL;
import com.cupom.core.adapters.JasperReportServiceIMPL;
import com.cupom.core.ports.interfaces.CupomFiscalElasticPort;
import com.cupom.core.ports.interfaces.JasperPort;
import com.cupom.core.ports.jaspers.JasperReportServicePort;
import com.cupom.infrastructure.adapters.jasper.JasperReportService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    JasperPort jasperPort(JasperReportServicePort jasperReportServicePort) {
        return new JasperReportServiceIMPL((JasperReportService) jasperReportServicePort);
    }

    @Bean
    CupomFiscalElasticPort cupomFiscalElasticPort(CupomFiscalElasticPort cupomFiscalElasticPort) {
        return new CupomFiscalElasticServiceIMPL(cupomFiscalElasticPort);
    }
}
