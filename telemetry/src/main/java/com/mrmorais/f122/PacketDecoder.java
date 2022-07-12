package com.mrmorais.f122;

import com.mrmorais.f122.enums.PacketId;
import com.mrmorais.f122.packets.Packet;
import com.mrmorais.f122.packets.PacketHeader;
import io.netty.buffer.ByteBuf;

import java.util.function.Function;

public class PacketDecoder {
  public Packet decode(ByteBuf buffer, Function<PacketId, ? extends Packet> ctor) {
    PacketId packetId = getPacketId(buffer);
    Packet packet = ctor.apply(packetId);
    return packet.fill(buffer);
  }

  public Packet decode(ByteBuf buffer) {
    return decode(buffer, packetId -> {
      switch (packetId) {
        default:
          throw new IllegalArgumentException("PacketId=" + packetId + " not supported");
      }
    });
  }

  private PacketId getPacketId(ByteBuf buffer) {
    return PacketId.valueOf(buffer.getUnsignedByte(PacketHeader.PACKET_ID_OFFSET));
  }
}
