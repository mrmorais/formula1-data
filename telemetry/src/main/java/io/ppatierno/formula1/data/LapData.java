/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.data;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.enums.DriverStatus;
import io.ppatierno.formula1.enums.PitStatus;
import io.ppatierno.formula1.enums.ResultStatus;
import io.ppatierno.formula1.enums.Sector;

public class LapData {

    public static final int SIZE = 43;

    private float lastLapTime;
    private float currentLapTime;
    private int sector1TimeInMS;
    private int sector2TimeInMS;
    private float lapDistance;
    private float totalDistance;
    private float safetyCarDelta;
    private short carPosition;
    private short currentLapNum;
    private PitStatus pitStatus;
    private short numPitStops;
    private Sector sector;
    private short currentLapInvalid;
    private short penalties;
    private short warnings;
    private short numUnservedDriveThroughPens;
    private short numUnservedStopGoPens;
    private short gridPosition;
    private DriverStatus driverStatus;
    private ResultStatus resultStatus;
    private short pitLaneTimerActive;
    private int pitLaneTimeInLaneInMS;
    private int pitStopTimerInMS;
    private short pitStopShouldServePen;

    /**
     * Fill the current LapData with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled LapData instance
     */
    public LapData fill(ByteBuf buffer) {
        this.lastLapTime = buffer.readFloatLE();
        this.currentLapTime = buffer.readFloatLE();
        this.sector1TimeInMS = buffer.readUnsignedShortLE();
        this.sector2TimeInMS = buffer.readUnsignedShortLE();
        this.lapDistance = buffer.readFloatLE();
        this.totalDistance = buffer.readFloatLE();
        this.safetyCarDelta = buffer.readFloatLE();
        this.carPosition = buffer.readUnsignedByte();
        this.currentLapNum = buffer.readUnsignedByte();
        this.pitStatus = PitStatus.valueOf(buffer.readUnsignedByte());
        this.numPitStops = buffer.readUnsignedByte();
        this.sector = Sector.valueOf(buffer.readUnsignedByte());
        this.currentLapInvalid = buffer.readUnsignedByte();
        this.penalties = buffer.readUnsignedByte();
        this.warnings = buffer.readUnsignedByte();
        this.numUnservedDriveThroughPens = buffer.readUnsignedByte();
        this.numUnservedStopGoPens = buffer.readUnsignedByte();
        this.gridPosition = buffer.readUnsignedByte();
        this.driverStatus = DriverStatus.valueOf(buffer.readUnsignedByte());
        this.resultStatus = ResultStatus.valueOf(buffer.readUnsignedByte());
        this.pitLaneTimerActive = buffer.readByte();
        this.pitLaneTimeInLaneInMS = buffer.readUnsignedShortLE();
        this.pitStopTimerInMS = buffer.readUnsignedShortLE();
        this.pitStopShouldServePen = buffer.readUnsignedByte();
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current LapData instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeFloatLE(this.lastLapTime);
        buffer.writeFloatLE(this.currentLapTime);
        buffer.writeShortLE(this.sector1TimeInMS);
        buffer.writeShortLE(this.sector2TimeInMS);
        buffer.writeFloatLE(this.lapDistance);
        buffer.writeFloatLE(this.totalDistance);
        buffer.writeFloatLE(this.safetyCarDelta);
        buffer.writeByte(this.carPosition);
        buffer.writeByte(this.currentLapNum);
        buffer.writeByte(this.pitStatus.getValue());
        buffer.writeByte(this.numPitStops);
        buffer.writeByte(this.sector.getValue());
        buffer.writeByte(this.currentLapInvalid);
        buffer.writeByte(this.penalties);
        buffer.writeByte(this.warnings);
        buffer.writeByte(this.numUnservedDriveThroughPens);
        buffer.writeByte(this.numUnservedStopGoPens);
        buffer.writeByte(this.gridPosition);
        buffer.writeByte(this.driverStatus.getValue());
        buffer.writeByte(this.resultStatus.getValue());
        buffer.writeByte(this.pitLaneTimerActive);
        buffer.writeShortLE(this.pitLaneTimeInLaneInMS);
        buffer.writeShortLE(this.pitStopTimerInMS);
        buffer.writeByte(this.pitStopShouldServePen);
        return buffer;
    }

    /**
     * @return Last lap time in seconds
     */
    public float getLastLapTime() {
        return lastLapTime;
    }

    public void setLastLapTime(float lastLapTime) {
        this.lastLapTime = lastLapTime;
    }

    /**
     * @return Current time around the lap in seconds
     */
    public float getCurrentLapTime() {
        return currentLapTime;
    }

    public void setCurrentLapTime(float currentLapTime) {
        this.currentLapTime = currentLapTime;
    }

    /**
     * @return Sector 1 time in milliseconds
     */
    public int getSector1TimeInMS() {
        return sector1TimeInMS;
    }

    public void setSector1TimeInMS(int sector1TimeInMS) {
        this.sector1TimeInMS = sector1TimeInMS;
    }

    /**
     * @return Sector 2 time in milliseconds
     */
    public int getSector2TimeInMS() {
        return sector2TimeInMS;
    }

    public void setSector2TimeInMS(int sector2TimeInMS) {
        this.sector2TimeInMS = sector2TimeInMS;
    }

    /**
     * @return Distance vehicle is around current lap in metres
     * could be negative if line hasn’t been crossed yet
     */
    public float getLapDistance() {
        return lapDistance;
    }

    public void setLapDistance(float lapDistance) {
        this.lapDistance = lapDistance;
    }

    /**
     * @return Total distance travelled in session in metres
     * could be negative if line hasn’t been crossed yet
     */
    public float getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(float totalDistance) {
        this.totalDistance = totalDistance;
    }

    /**
     * @return Delta in seconds for safety car
     */
    public float getSafetyCarDelta() {
        return safetyCarDelta;
    }

    public void setSafetyCarDelta(float safetyCarDelta) {
        this.safetyCarDelta = safetyCarDelta;
    }

    /**
     * @return Car race position
     */
    public short getCarPosition() {
        return carPosition;
    }

    public void setCarPosition(short carPosition) {
        this.carPosition = carPosition;
    }

    /**
     * @return Current lap number
     */
    public short getCurrentLapNum() {
        return currentLapNum;
    }

    public void setCurrentLapNum(short currentLapNum) {
        this.currentLapNum = currentLapNum;
    }

    /**
     * @return Pit status
     * 0 = none, 1 = pitting, 2 = in pit area
     */
    public PitStatus getPitStatus() {
        return pitStatus;
    }

    public void setPitStatus(PitStatus pitStatus) {
        this.pitStatus = pitStatus;
    }

    /**
     * @return Sector
     * 0 = sector1, 1 = sector2, 2 = sector3
     */
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    /**
     * @return Current lap invalid
     * 0 = valid, 1 = invalid
     */
    public short getCurrentLapInvalid() {
        return currentLapInvalid;
    }

    public void setCurrentLapInvalid(short currentLapInvalid) {
        this.currentLapInvalid = currentLapInvalid;
    }

    /**
     * @return Accumulated time penalties in seconds to be added
     */
    public short getPenalties() {
        return penalties;
    }

    public void setPenalties(short penalties) {
        this.penalties = penalties;
    }

    /**
     * @return Grid position the vehicle started the race in
     */
    public short getGridPosition() {
        return gridPosition;
    }

    public void setGridPosition(short gridPosition) {
        this.gridPosition = gridPosition;
    }

    /**
     * @return Status of driver
     * 0 = in garage, 1 = flying lap
     * 2 = in lap, 3 = out lap, 4 = on track
     */
    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    /**
     * @return Result status
     * 0 = invalid, 1 = inactive, 2 = active
     * 3 = finished, 4 = disqualified, 5 = not classified
     * 6 = retired
     */
    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    /**
     * @return Number of pit stops taken in this race
     */
    public short getNumPitStops() {
        return numPitStops;
    }

    public void setNumPitStops(short numPitStops) {
        this.numPitStops = numPitStops;
    }

    /**
     * @return Accumulated number of warnings issued
     */
    public short getWarnings() {
        return warnings;
    }

    public void setWarnings(short warnings) {
        this.warnings = warnings;
    }

    /**
     * @return Num drive through pens left to serve
     */
    public short getNumUnservedDriveThroughPens() {
        return numUnservedDriveThroughPens;
    }

    public void setNumUnservedDriveThroughPens(short numUnservedDriveThroughPens) {
        this.numUnservedDriveThroughPens = numUnservedDriveThroughPens;
    }

    /**
     * @return Num stop go pens left to serve
     */
    public short getNumUnservedStopGoPens() {
        return numUnservedStopGoPens;
    }

    public void setNumUnservedStopGoPens(short numUnservedStopGoPens) {
        this.numUnservedStopGoPens = numUnservedStopGoPens;
    }

    /**
     * @return Pit lane timing, 0 = inactive, 1 = active
     */
    public short getPitLaneTimerActive() {
        return pitLaneTimerActive;
    }

    public void setPitLaneTimerActive(short pitLaneTimerActive) {
        this.pitLaneTimerActive = pitLaneTimerActive;
    }

    /**
     * @return If active, the current time spent in the pit lane in ms
     */
    public int getPitLaneTimeInLaneInMS() {
        return pitLaneTimeInLaneInMS;
    }

    public void setPitLaneTimeInLaneInMS(int pitLaneTimeInLaneInMS) {
        this.pitLaneTimeInLaneInMS = pitLaneTimeInLaneInMS;
    }

    /**
     * @return Time of the actual pit stop in ms
     */
    public int getPitStopTimerInMS() {
        return pitStopTimerInMS;
    }

    public void setPitStopTimerInMS(int pitStopTimerInMS) {
        this.pitStopTimerInMS = pitStopTimerInMS;
    }

    /**
     * @return Whether the car should serve a penalty at this stop
     */
    public short getPitStopShouldServePen() {
        return pitStopShouldServePen;
    }

    public void setPitStopShouldServePen(short pitStopShouldServePen) {
        this.pitStopShouldServePen = pitStopShouldServePen;
    }

    @Override
    public String toString() {
        return "LapData[lastLapTime=" + this.lastLapTime +
                ",currentLapTime=" + this.currentLapTime +
                ",sector1TimeInMS=" + this.sector1TimeInMS +
                ",sector2TimeInMS=" + this.sector2TimeInMS +
                ",lapDistance=" + this.lapDistance +
                ",totalDistance=" + this.totalDistance +
                ",safetyCarDelta=" + this.safetyCarDelta +
                ",carPosition=" + this.carPosition +
                ",currentLapNum=" + this.currentLapNum +
                ",pitStatus=" + this.pitStatus +
                ",numPitStops=" + this.numPitStops +
                ",sector=" + this.sector +
                ",currentLapInvalid=" + this.currentLapInvalid +
                ",penalties=" + this.penalties +
                ",warnings=" + this.warnings +
                ",numUnservedDriveThroughPens=" + this.numUnservedDriveThroughPens +
                ",numUnservedStopGoPens=" + this.numUnservedStopGoPens +
                ",gridPosition=" + this.gridPosition +
                ",driverStatus=" + this.driverStatus +
                ",resultStatus=" + this.resultStatus +
                ",pitLaneTimerActive=" + this.pitLaneTimerActive +
                ",pitLaneTimeInLaneInMS=" + this.pitLaneTimeInLaneInMS +
                ",pitStopTimerInMS=" + this.pitStopTimerInMS +
                ",pitStopShouldServePen=" + this.pitStopShouldServePen +
                "]";
    }
}