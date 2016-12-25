package com.asi.www.netty.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Created by Ankur on 25-12-2016.
 */


public class XMLProcessor implements Processor {
    public void process(Exchange exchange) throws Exception {
        exchange.getOut().setBody("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<person user=\"james\">\n" +
                "  <firstName>James</firstName>\n" +
                "  <lastName>Strachan</lastName>\n" +
                "  <city>London</city>\n" +
                "</person>");
    }
}
