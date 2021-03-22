package com.example.demo;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class LargeMessageConsumerRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("fuseAMQComponent:queue:MS.Publication.NZX").streamCaching()
                .setHeader(Exchange.FILE_NAME, simple("${date:now:yyyy.MM.dd-HH.mm.ss.'json'}"))
                .to("file:/tmp/chenjac");
    }
}
