package com.hayden.dynamicparsestarter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hayden.dynamicparse.decompile.Decompile;
import com.hayden.dynamicparse.decompile.DecompilePrinter;
import com.hayden.dynamicparse.decompile.LoadClass;
import com.hayden.dynamicparse.parse.DynamicParseJson;
import com.hayden.dynamicparse.parse.ReParse;
import org.jd.core.v1.api.loader.Loader;
import org.jd.core.v1.api.printer.Printer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamicParseConfig {

    @Bean
    @ConditionalOnMissingBean
    ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean
    DynamicParseJson dynamicParseJson(ObjectMapper mapper){
        return new DynamicParseJson(
                mapper
        );
    }

    @Bean
    ReParse dynamicParseJson(){
        return new ReParse();
    }

    @Bean
    Decompile decompile(DecompilePrinter decompilePrinter, LoadClass loadClass){
        return new Decompile(decompilePrinter, loadClass);
    }

    @Bean
    @ConditionalOnMissingBean
    DecompilePrinter printer(){
        return new DecompilePrinter();
    }

    @Bean
    @ConditionalOnMissingBean
    LoadClass loader(){
        return new LoadClass();
    }

}
