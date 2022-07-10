package com.mrmorais.f122;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

public class StreamExample {
  private final static Logger log = LoggerFactory.getLogger(StreamExample.class);

  public static void main(String[] args) throws Exception {
    CamelContext camelContext = new DefaultCamelContext();

    camelContext.addRoutes(new StreamInOutBuilder());

    CountDownLatch latch = new CountDownLatch(1);

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      try {
        camelContext.close();
      } catch (Exception e) {
        log.error("Error closing CamelContext", e);
      } finally {
        latch.countDown();
      }
    }));

    try {
      camelContext.start();
      latch.await();
    } catch (Throwable e) {
      log.error("Error starting CamelContext", e);
      System.exit(1);
    }

    System.exit(0);
  }
}
