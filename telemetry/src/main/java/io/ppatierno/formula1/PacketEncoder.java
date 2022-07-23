/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.ppatierno.formula1.packets.Packet;
import io.ppatierno.formula1.packets.PacketCarSetupData;
import io.ppatierno.formula1.packets.PacketCarStatusData;
import io.ppatierno.formula1.packets.PacketCarTelemetryData;
import io.ppatierno.formula1.packets.PacketEventData;
import io.ppatierno.formula1.packets.PacketFinalClassificationData;
import io.ppatierno.formula1.packets.PacketLapData;
import io.ppatierno.formula1.packets.PacketLobbyInfoData;
import io.ppatierno.formula1.packets.PacketMotionData;
import io.ppatierno.formula1.packets.PacketParticipantsData;
import io.ppatierno.formula1.packets.PacketSessionData;

/**
 * Packet encoder
 */
public class PacketEncoder {
    
    /**
     * Encode the input Packet instance in the corresponding raw bytes representation
     * 
     * @param packet Packet instance to encode
     * @return raw bytes representation of the Packet instance
     */
    public ByteBuf encode(Packet packet) {
        ByteBuf bb = null;
        switch (packet.getHeader().getPacketId()) {
            case CAR_SETUPS:
                bb = Unpooled.buffer(PacketCarSetupData.SIZE);
                break;
            case CAR_STATUS:
                bb = Unpooled.buffer(PacketCarStatusData.SIZE);
                break;
            case CAR_TELEMETRY:
                bb = Unpooled.buffer(PacketCarTelemetryData.SIZE);
                break;
            case EVENT:
                bb = Unpooled.buffer(PacketEventData.SIZE);
                break;
            case FINAL_CLASSIFICATION:
                bb = Unpooled.buffer(PacketFinalClassificationData.SIZE);
                break;
            case LAP_DATA:
                bb = Unpooled.buffer(PacketLapData.SIZE);
                break;
            case LOBBY_INFO:
                bb = Unpooled.buffer(PacketLobbyInfoData.SIZE);
                break;
            case MOTION:
                bb = Unpooled.buffer(PacketMotionData.SIZE);
                break;
            case PARTICIPANTS:
                bb = Unpooled.buffer(PacketParticipantsData.SIZE);
                break;
            case SESSION:
                bb = Unpooled.buffer(PacketSessionData.SIZE);
                break;
            default:
                throw new IllegalArgumentException("PacketId=" + packet.getHeader().getPacketId() + " not supported");
        }
        return bb != null ? packet.fillBuffer(bb) : null;
    }
}