package com.example.online_shopping.config;
//
//import org.hibernate.boot.MetadataBuilder;
//import org.hibernate.boot.spi.MetadataBuilderContributor;
//import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
//import org.springframework.context.annotation.Configuration;
//import java.util.Map;
//
//@Configuration
//public class HibernateConfig implements HibernatePropertiesCustomizer {
//    
//    @Override
//    public void customize(Map<String, Object> hibernateProperties) {
//        hibernateProperties.put(
//            "hibernate.metadata_builder_contributor",
//            (MetadataBuilderContributor) metadataBuilder -> {
//                metadataBuilder.applyIdGeneratorType(
//                    CustomUserIdGenerator.class, 
//                    GeneratedUserId.class
//                );
//            }
//        );
//    }
//}