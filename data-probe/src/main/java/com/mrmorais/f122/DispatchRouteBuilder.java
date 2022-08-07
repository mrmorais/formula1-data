package com.mrmorais.f122;

import io.ppatierno.formula1.packets.PacketCarTelemetryData;
import org.apache.camel.builder.RouteBuilder;

import java.util.Objects;

public class DispatchRouteBuilder extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("netty:udp://0.0.0.0:20777?decoders=#packet-decoder&sync=false")
        .multicast()
        .parallelProcessing()
        .to("direct:car-telemetry")
        .routeId("f1-udp-multicast");
  }
}
