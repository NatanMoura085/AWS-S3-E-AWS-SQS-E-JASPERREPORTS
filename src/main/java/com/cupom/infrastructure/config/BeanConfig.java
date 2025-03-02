package com.cupom.infrastructure.config;

import com.cupom.core.adapters.JasperReportServiceIMPL;
import com.cupom.core.ports.interfaces.JasperPort;
import com.cupom.core.ports.jaspers.JasperReportServicePort;
import com.cupom.infrastructure.adpaters.jasper.JasperReportService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    JasperPort jasperPort(JasperReportServicePort jasperReportServicePort) {
        return new JasperReportServiceIMPL((JasperReportService) jasperReportServicePort);
    }
}
