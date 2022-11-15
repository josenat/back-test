package renfe.com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class AsgWebservicesConfiguration extends WsConfigurerAdapter {


    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/ws/*");
    }

    @Bean(name = "infoServiceUrl")
    public DefaultWsdl11Definition defaultWsdl11Definition(@Qualifier("countriesSchema") XsdSchema infoServiceSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("infoServiceUrlPort");
        wsdl11Definition.setLocationUri("/ws/infoService");
        System.out.println("********infoServiceUrl100");
        wsdl11Definition.setTargetNamespace("http://renfe.com/webservicesoap");
        wsdl11Definition.setSchema(infoServiceSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("infoService.xsd"));
    }

    @Bean(name = "certComplUrl")
    public DefaultWsdl11Definition defaultWsdl11Definition2(@Qualifier("certComplSchema") XsdSchema certComplSchema) {
        DefaultWsdl11Definition wsdl11Definition2 = new DefaultWsdl11Definition();
        wsdl11Definition2.setPortTypeName("certComplUrlPort");
        wsdl11Definition2.setLocationUri("/ws/CertCompl");
        //wsdl11Definition.setRequestSuffix("RQ");
        //wsdl11Definition.setResponseSuffix("RS");
        wsdl11Definition2.setTargetNamespace("http://renfe.com/webservicesoap");
        wsdl11Definition2.setSchema(certComplSchema);
        return wsdl11Definition2;
    }

    @Bean
    public XsdSchema certComplSchema() {
        return new SimpleXsdSchema(new ClassPathResource("certCompl.xsd"));
    }

    @Bean
    @Scope("prototype")
    public Logger produceLogger(InjectionPoint injectionPoint) {
        Class<?> classOnWired = injectionPoint.getMember().getDeclaringClass();
        return LoggerFactory.getLogger(classOnWired);
    }
}
