/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.data;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.enums.SessionType;
import io.ppatierno.formula1.enums.Weather;

public class WeatherForecastSample {

    public static final int SIZE = 8;

    private SessionType sessionType;
    private short timeOffset;
    private Weather weather;
    private short trackTemperature;
    private short trackTemperatureChange;
    private short airTemperature;
    private short airTemperatureChange;
    private short rainPercentage;

    /**
     * Fill the current WeatherForecastSample with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled WeatherForecastSample instance
     */
    public WeatherForecastSample fill(ByteBuf buffer) {
        this.sessionType = SessionType.valueOf(buffer.readUnsignedByte());
        this.timeOffset = buffer.readUnsignedByte();
        this.weather = Weather.valueOf(buffer.readUnsignedByte());
        this.trackTemperature = buffer.readByte();
        this.trackTemperatureChange = buffer.readByte();
        this.airTemperature = buffer.readByte();
        this.airTemperatureChange = buffer.readByte();
        this.rainPercentage = buffer.readUnsignedByte();
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current WeatherForecastSample instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeByte(this.sessionType.getValue());
        buffer.writeByte(this.timeOffset);
        buffer.writeByte(this.weather.getValue());
        buffer.writeByte(this.trackTemperature);
        buffer.writeByte(this.trackTemperatureChange);
        buffer.writeByte(this.airTemperature);
        buffer.writeByte(this.airTemperatureChange);
        buffer.writeByte(this.rainPercentage);
        return buffer;
    }

    /**
     * @return Session type
     * 0 = unknown, 1 = P1, 2 = P2, 3 = P3, 4 = Short P, 5 = Q1
     * 6 = Q2, 7 = Q3, 8 = Short Q, 9 = OSQ, 10 = R, 11 = R2
     * 12 = Time Trial
     */
    public SessionType getSessionType() {
        return sessionType;
    }

    public void setSessionType(SessionType sessionType) {
        this.sessionType = sessionType;
    }

    /**
     * @return Time in minutes the forecast is for
     */
    public short getTimeOffset() {
        return timeOffset;
    }

    public void setTimeOffset(short timeOffset) {
        this.timeOffset = timeOffset;
    }

    /**
     * @return Weather
     * Weather - 0 = clear, 1 = light cloud, 2 = overcast
     * 3 = light rain, 4 = heavy rain, 5 = storm
     */
    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    /**
     * @return Track temp. in degrees celsius
     */
    public short getTrackTemperature() {
        return trackTemperature;
    }

    public void setTrackTemperature(short trackTemperature) {
        this.trackTemperature = trackTemperature;
    }

    /**
     * @return Air temp. in degrees celsius
     */
    public short getAirTemperature() {
        return airTemperature;
    }

    public void setAirTemperature(short airTemperature) {
        this.airTemperature = airTemperature;
    }

    /**
     * @return Track temp. change – 0 = up, 1 = down, 2 = no change
     */
    public short getTrackTemperatureChange() {
        return trackTemperatureChange;
    }

    public void setTrackTemperatureChange(short trackTemperatureChange) {
        this.trackTemperatureChange = trackTemperatureChange;
    }

    /**
     * @return Air temp. change – 0 = up, 1 = down, 2 = no change
     */
    public short getAirTemperatureChange() {
        return airTemperatureChange;
    }

    public void setAirTemperatureChange(short airTemperatureChange) {
        this.airTemperatureChange = airTemperatureChange;
    }

    /**
     * @return Rain percentage (0-100)
     */
    public short getRainPercentage() {
        return rainPercentage;
    }

    public void setRainPercentage(short rainPercentage) {
        this.rainPercentage = rainPercentage;
    }

    @Override
    public String toString() {
        return "WeatherForecastSample[sessionType=" + this.sessionType +
                ",timeOffset=" + this.timeOffset +
                ",weather=" + this.weather +
                ",trackTemperature=" + this.trackTemperature +
                ",trackTemperatureChange=" + this.trackTemperatureChange +
                ",airTemperature=" + this.airTemperature +
                ",airTemperatureChange=" + this.airTemperatureChange +
                ",rainPercentage=" + this.rainPercentage +
                "]";
    }
}
