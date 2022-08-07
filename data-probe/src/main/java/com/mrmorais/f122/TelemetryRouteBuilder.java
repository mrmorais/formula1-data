package com.mrmorais.f122;

import io.ppatierno.formula1.enums.PacketId;
import io.ppatierno.formula1.packets.Packet;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.kafka.KafkaEndpoint;

public class TelemetryRouteBuilder extends RouteBuilder {
  @Override
  public void configure() throws Exception {
    from("direct:car-telemetry")
        .filter(exchange -> {
          Packet packet = (Packet) exchange.getIn().getBody();
          return packet.getHeader().getPacketId() == PacketId.CAR_TELEMETRY;
        })
        .to("kafka:f1-car-telemetry?brokers=localhost:9092&groupId=camel")
        .routeId("kafka-telemetry");
  }
}
