package com.asi.www.netty.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.ehcache.EhcacheConstants;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Ankur on 25-12-2016.
 */


public class XMLProcessor implements Processor {
    HashMap cacheHeaders = new HashMap();

    public void process(Exchange exchange) throws Exception {
        ProducerTemplate template = exchange.getContext().createProducerTemplate();
        String key = "key"+ ThreadLocalRandom.current().nextInt(1, 2 + 1);
        cacheHeaders.put(EhcacheConstants.KEY,key);
        cacheHeaders.put(EhcacheConstants.VALUE,key);
        cacheHeaders.put(EhcacheConstants.ACTION,EhcacheConstants.ACTION_PUT_IF_ABSENT);

        template.sendBodyAndHeaders("direct-vm:cache-test","Hello world", cacheHeaders);
       /* exchange.getOut().setBody("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<person user=\"james\">\n" +
                "  <firstName>James</firstName>\n" +
                "  <lastName>Strachan</lastName>\n" +
                "  <city>London</city>\n" +
                "</person>");
*/    }
}
