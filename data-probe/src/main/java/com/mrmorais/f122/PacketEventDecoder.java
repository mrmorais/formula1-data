package com.mrmorais.f122;

import com.mrmorais.f122.packets.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.util.List;

public class PacketEventDecoder extends MessageToMessageDecoder<DatagramPacket> {
  private PacketDecoder packetDecoder = new PacketDecoder();

  @Override
  protected void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> list) throws Exception {
    ByteBuf buffer = datagramPacket.content();
    Packet packet = packetDecoder.decode(buffer);
    list.add(packet);
  }
}
