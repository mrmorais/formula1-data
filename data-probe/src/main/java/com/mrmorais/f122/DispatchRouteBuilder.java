package com.mrmorais.f122;

import org.apache.camel.builder.RouteBuilder;

public class DispatchRouteBuilder extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("netty:udp://0.0.0.0:20777?decoders=#packet-decoder&sync=false")
        .multicast()
        .parallelProcessing()
        .to("stream:out")
        .routeId("f1-udp-multicast");
  }
}
