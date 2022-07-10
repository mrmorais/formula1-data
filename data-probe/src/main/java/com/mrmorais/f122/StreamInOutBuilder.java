package com.mrmorais.f122;

import org.apache.camel.builder.RouteBuilder;

public class StreamInOutBuilder extends RouteBuilder {

  @Override
  public void configure() {
    from("stream:in").to("stream:out");
  }
}
