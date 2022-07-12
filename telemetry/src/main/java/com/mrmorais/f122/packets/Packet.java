package com.mrmorais.f122.packets;

import io.netty.buffer.ByteBuf;

public abstract class Packet {
  protected PacketHeader header = new PacketHeader();

  public PacketHeader getHeader() {
    return header;
  }

  public void setHeader(PacketHeader header) {
    this.header = header;
  }

  public Packet fill(ByteBuf buffer) {
    this.header.fill(buffer);
    return this;
  }

  public ByteBuf fillBuffer(ByteBuf buffer) {
    this.header.fillBuffer(buffer);
    return buffer;
  }

  @Override
  public String toString() {
    return this.header.toString();
  }
}
