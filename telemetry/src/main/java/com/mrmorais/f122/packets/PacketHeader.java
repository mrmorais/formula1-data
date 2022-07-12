package com.mrmorais.f122.packets;

import com.mrmorais.f122.PacketUtils;
import com.mrmorais.f122.enums.PacketId;

import java.math.BigInteger;
import io.netty.buffer.ByteBuf;

public class PacketHeader {
  public static final int SIZE = 24; // total bytes

  public static final int PACKET_ID_OFFSET = 5;

  private int packetFormat;
  private short gameMajorVersion;
  private short gameMinorVersion;
  private short packetVersion;
  private PacketId packetId;
  private BigInteger sessionUid;
  private float sessionTime;
  private long frameIdentifier;
  private short playerCarIndex;
  private short secondaryPlayerCarIndex;

  public PacketHeader fill(ByteBuf buffer) {
    this.packetFormat = buffer.readUnsignedShortLE();
    this.gameMajorVersion = buffer.readUnsignedByte();
    this.gameMinorVersion = buffer.readUnsignedByte();
    this.packetVersion = buffer.readUnsignedByte();
    this.packetId = PacketId.valueOf(buffer.readUnsignedByte());
    this.sessionUid = PacketUtils.toUnsignedBigInteger(buffer.readLongLE());
    this.sessionTime = buffer.readFloatLE();
    this.frameIdentifier = buffer.readUnsignedIntLE();
    this.playerCarIndex = buffer.readUnsignedByte();
    this.secondaryPlayerCarIndex = buffer.readUnsignedByte();
    return this;
  }

  public ByteBuf fillBuffer(ByteBuf buffer) {
    buffer.writeShortLE(this.packetFormat);
    buffer.writeByte(this.gameMajorVersion);
    buffer.writeByte(this.gameMinorVersion);
    buffer.writeByte(this.packetVersion);
    buffer.writeByte(this.packetId.getValue());
    buffer.writeLongLE(this.sessionUid.longValue());
    buffer.writeFloatLE(this.sessionTime);
    buffer.writeIntLE((int)this.frameIdentifier);
    buffer.writeByte(this.playerCarIndex);
    buffer.writeByte(this.secondaryPlayerCarIndex);
    return buffer;
  }

  public int getPacketFormat() {
    return packetFormat;
  }

  public void setPacketFormat(int packetFormat) {
    this.packetFormat = packetFormat;
  }

  public short getGameMajorVersion() {
    return gameMajorVersion;
  }

  public void setGameMajorVersion(short gameMajorVersion) {
    this.gameMajorVersion = gameMajorVersion;
  }

  public short getGameMinorVersion() {
    return gameMinorVersion;
  }

  public void setGameMinorVersion(short gameMinorVersion) {
    this.gameMinorVersion = gameMinorVersion;
  }

  public short getPacketVersion() {
    return packetVersion;
  }

  public void setPacketVersion(short packetVersion) {
    this.packetVersion = packetVersion;
  }

  public PacketId getPacketId() {
    return packetId;
  }

  public void setPacketId(PacketId packetId) {
    this.packetId = packetId;
  }

  public BigInteger getSessionUid() {
    return sessionUid;
  }

  public void setSessionUid(BigInteger sessionUid) {
    this.sessionUid = sessionUid;
  }

  public float getSessionTime() {
    return sessionTime;
  }

  public void setSessionTime(float sessionTime) {
    this.sessionTime = sessionTime;
  }

  public long getFrameIdentifier() {
    return frameIdentifier;
  }

  public void setFrameIdentifier(long frameIdentifier) {
    this.frameIdentifier = frameIdentifier;
  }

  public short getPlayerCarIndex() {
    return playerCarIndex;
  }

  public void setPlayerCarIndex(short playerCarIndex) {
    this.playerCarIndex = playerCarIndex;
  }

  public short getSecondaryPlayerCarIndex() {
    return secondaryPlayerCarIndex;
  }

  public void setSecondaryPlayerCarIndex(short secondaryPlayerCarIndex) {
    this.secondaryPlayerCarIndex = secondaryPlayerCarIndex;
  }

  @Override
  public String toString() {
    return "Header[format=" + this.packetFormat +
        ",major=" + this.gameMajorVersion +
        ",minor=" + this.gameMinorVersion +
        ",version=" + this.packetVersion +
        ",id=" + this.packetId +
        ",sessionUid=" + this.sessionUid +
        ",sessionTime=" + this.sessionTime +
        ",frameIdentifier=" + this.frameIdentifier +
        ",playerCarIndex=" + this.playerCarIndex +
        ",secondaryPlayerCarIndex=" + this.secondaryPlayerCarIndex +
        "]";
  }
}
