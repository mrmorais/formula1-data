/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.data.MarshalZone;
import io.ppatierno.formula1.data.WeatherForecastSample;
import io.ppatierno.formula1.enums.Formula;
import io.ppatierno.formula1.enums.SafetyCarStatus;
import io.ppatierno.formula1.enums.SessionType;
import io.ppatierno.formula1.enums.Track;
import io.ppatierno.formula1.enums.Weather;

/**
 * Session Packet
 * <p>
 * The session packet includes details about the current session in progress.
 * Frequency: 2 per second
 */
public class PacketSessionData extends Packet {

  // 632
  public static final int SIZE = PacketHeader.SIZE + MarshalZone.SIZE * PacketConstants.MARSHAL_ZONES + WeatherForecastSample.SIZE * PacketConstants.WEATHER_FORECAST_SAMPLES + 55;

  private Weather weather;
  private short trackTemperature;
  private short airTemperature;
  private short totalLaps;
  private int trackLength;
  private SessionType sessionType;
  private Track trackId;
  private Formula formula;
  private int sessionTimeLeft;
  private int sessionDuration;
  private short pitSpeedLimit;
  private short gamePaused;
  private short isSpectating;
  private short spectatorCarIndex;
  private short sliProNativeSupport;
  private short numMarshalZones;
  private List<MarshalZone> marshalZones = new ArrayList<>(PacketConstants.MARSHAL_ZONES);
  private SafetyCarStatus safetyCarStatus;
  private short networkGame;
  private short numWeatherForecastSamples;
  private List<WeatherForecastSample> weatherForecastSamples = new ArrayList<>(PacketConstants.WEATHER_FORECAST_SAMPLES); // Todo: Move to 56

  private short forecastAccuracy; // Todo: turn it enum
  private short aiDifficulty;
  private long seasonLinkIdentifier;
  private long weekendLinkIdentifier;
  private long sessionLinkIdentifier;
  private short pitStopWindowIdealLap;
  private short pitStopWindowLatestLap;
  private short pitStopRejoinPosition;
  private short steeringAssist;
  private short breakingAssist;
  private short gearboxAssist;
  private short pitAssist;
  private short pitReleaseAssist;
  private short ERSAssist;
  private short DRSAssist;
  private short dynamicRacingLine;
  private short dynamicRacingLineType;
  private short gameMode;
  private short ruleSet;
  private long timeOfDay;
  private short sessionLength;

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
   * @return Total number of laps in this race
   */
  public short getTotalLaps() {
    return totalLaps;
  }

  public void setTotalLaps(short totalLaps) {
    this.totalLaps = totalLaps;
  }

  /**
   * @return Track length in metres
   */
  public int getTrackLength() {
    return trackLength;
  }

  public void setTrackLength(int trackLength) {
    this.trackLength = trackLength;
  }

  /**
   * @return Session type
   * 0 = unknown, 1 = P1, 2 = P2, 3 = P3, 4 = Short P
   * 5 = Q1, 6 = Q2, 7 = Q3, 8 = Short Q, 9 = OSQ
   * 10 = R, 11 = R2, 12 = Time Trial
   */
  public SessionType getSessionType() {
    return sessionType;
  }

  public void setSessionType(SessionType sessionType) {
    this.sessionType = sessionType;
  }

  /**
   * @return Track ID
   * -1 for unknown, 0-21 for tracks, see appendix
   */
  public Track getTrackId() {
    return trackId;
  }

  public void setTrackId(Track trackId) {
    this.trackId = trackId;
  }

  /**
   * @return Formula
   * Formula, 0 = F1 Modern, 1 = F1 Classic, 2 = F2, 3 = F1 Generic
   */
  public Formula getFormula() {
    return formula;
  }

  public void setFormula(Formula formula) {
    this.formula = formula;
  }

  /**
   * @return Time left in session in seconds
   */
  public int getSessionTimeLeft() {
    return sessionTimeLeft;
  }

  public void setSessionTimeLeft(int sessionTimeLeft) {
    this.sessionTimeLeft = sessionTimeLeft;
  }

  /**
   * @return Session duration in seconds
   */
  public int getSessionDuration() {
    return sessionDuration;
  }

  public void setSessionDuration(int sessionDuration) {
    this.sessionDuration = sessionDuration;
  }

  /**
   * @return Pit speed limit in kilometres per hour
   */
  public short getPitSpeedLimit() {
    return pitSpeedLimit;
  }

  public void setPitSpeedLimit(short pitSpeedLimit) {
    this.pitSpeedLimit = pitSpeedLimit;
  }

  /**
   * @return Whether the game is paused
   */
  public short getGamePaused() {
    return gamePaused;
  }

  public void setGamePaused(short gamePaused) {
    this.gamePaused = gamePaused;
  }

  /**
   * @return Whether the player is spectating
   */
  public short getIsSpectating() {
    return isSpectating;
  }

  public void setIsSpectating(short isSpectating) {
    this.isSpectating = isSpectating;
  }

  /**
   * @return Index of the car being spectated
   */
  public short getSpectatorCarIndex() {
    return spectatorCarIndex;
  }

  public void setSpectatorCarIndex(short spectatorCarIndex) {
    this.spectatorCarIndex = spectatorCarIndex;
  }

  /**
   * @return SLI Pro support, 0 = inactive, 1 = active
   */
  public short getSliProNativeSupport() {
    return sliProNativeSupport;
  }

  public void setSliProNativeSupport(short sliProNativeSupport) {
    this.sliProNativeSupport = sliProNativeSupport;
  }

  /**
   * @return Number of marshal zones to follow
   */
  public short getNumMarshalZones() {
    return numMarshalZones;
  }

  public void setNumMarshalZones(short numMarshalZones) {
    this.numMarshalZones = numMarshalZones;
  }

  /**
   * @return List of marshal zones – max 21
   */
  public List<MarshalZone> getMarshalZones() {
    return marshalZones;
  }

  public void setMarshalZones(List<MarshalZone> marshalZones) {
    this.marshalZones = marshalZones;
  }

  /**
   * @return Safety car status
   * 0 = no safety car, 1 = full safety car
   * 2 = virtual safety car
   * 0 = offline, 1 = online
   */
  public SafetyCarStatus getSafetyCarStatus() {
    return safetyCarStatus;
  }

  public void setSafetyCarStatus(SafetyCarStatus safetyCarStatus) {
    this.safetyCarStatus = safetyCarStatus;
  }

  /**
   * @return Network game
   * 0 = offline, 1 = online
   */
  public short getNetworkGame() {
    return networkGame;
  }

  public void setNetworkGame(short networkGame) {
    this.networkGame = networkGame;
  }

  /**
   * @return Number of weather samples to follow
   */
  public short getNumWeatherForecastSamples() {
    return numWeatherForecastSamples;
  }

  public void setNumWeatherForecastSamples(short numWeatherForecastSamples) {
    this.numWeatherForecastSamples = numWeatherForecastSamples;
  }

  /**
   * @return List of weather forecast samples
   */
  public List<WeatherForecastSample> getWeatherForecastSamples() {
    return weatherForecastSamples;
  }

  public void setWeatherForecastSamples(List<WeatherForecastSample> weatherForecastSamples) {
    this.weatherForecastSamples = weatherForecastSamples;
  }

  /**
   * @return 0 = Perfect, 1 = Approximate
   */
  public short getForecastAccuracy() {
    return forecastAccuracy;
  }

  public void setForecastAccuracy(short forecastAccuracy) {
    this.forecastAccuracy = forecastAccuracy;
  }

  /**
   * @return AI Difficulty rating – 0-110
   */
  public short getAiDifficulty() {
    return aiDifficulty;
  }

  public void setAiDifficulty(short aiDifficulty) {
    this.aiDifficulty = aiDifficulty;
  }

  /**
   * @return Identifier for season - persists across saves
   */
  public long getSeasonLinkIdentifier() {
    return seasonLinkIdentifier;
  }

  public void setSeasonLinkIdentifier(long seasonLinkIdentifier) {
    this.seasonLinkIdentifier = seasonLinkIdentifier;
  }

  /**
   * @return Identifier for weekend - persists across saves
   */
  public long getWeekendLinkIdentifier() {
    return weekendLinkIdentifier;
  }

  public void setWeekendLinkIdentifier(long weekendLinkIdentifier) {
    this.weekendLinkIdentifier = weekendLinkIdentifier;
  }

  /**
   * @return Identifier for session - persists across saves
   */
  public long getSessionLinkIdentifier() {
    return sessionLinkIdentifier;
  }

  public void setSessionLinkIdentifier(long sessionLinkIdentifier) {
    this.sessionLinkIdentifier = sessionLinkIdentifier;
  }

  /**
   * @return Ideal lap to pit on for current strategy (player)
   */
  public short getPitStopWindowIdealLap() {
    return pitStopWindowIdealLap;
  }

  public void setPitStopWindowIdealLap(short pitStopWindowIdealLap) {
    this.pitStopWindowIdealLap = pitStopWindowIdealLap;
  }

  /**
   * @return Latest lap to pit on for current strategy (player)
   */
  public short getPitStopWindowLatestLap() {
    return pitStopWindowLatestLap;
  }

  public void setPitStopWindowLatestLap(short pitStopWindowLatestLap) {
    this.pitStopWindowLatestLap = pitStopWindowLatestLap;
  }

  /**
   * @return Predicted position to rejoin at (player)
   */
  public short getPitStopRejoinPosition() {
    return pitStopRejoinPosition;
  }

  public void setPitStopRejoinPosition(short pitStopRejoinPosition) {
    this.pitStopRejoinPosition = pitStopRejoinPosition;
  }

  /**
   * @return 0 = off, 1 = on
   */
  public short getSteeringAssist() {
    return steeringAssist;
  }

  public void setSteeringAssist(short steeringAssist) {
    this.steeringAssist = steeringAssist;
  }

  /**
   * @return 0 = off, 1 = low, 2 = medium, 3 = high
   */
  public short getBreakingAssist() {
    return breakingAssist;
  }

  public void setBreakingAssist(short breakingAssist) {
    this.breakingAssist = breakingAssist;
  }

  /**
   * @return 1 = manual, 2 = manual & suggested gear, 3 = auto
   */
  public short getGearboxAssist() {
    return gearboxAssist;
  }

  public void setGearboxAssist(short gearboxAssist) {
    this.gearboxAssist = gearboxAssist;
  }

  /**
   * @return 0 = off, 1 = on
   */
  public short getPitAssist() {
    return pitAssist;
  }

  public void setPitAssist(short pitAssist) {
    this.pitAssist = pitAssist;
  }

  /**
   * @return 0 = off, 1 = on
   */
  public short getPitReleaseAssist() {
    return pitReleaseAssist;
  }

  public void setPitReleaseAssist(short pitReleaseAssist) {
    this.pitReleaseAssist = pitReleaseAssist;
  }

  /**
   * @return 0 = off, 1 = on
   */
  public short getERSAssist() {
    return ERSAssist;
  }

  public void setERSAssist(short ERSAssist) {
    this.ERSAssist = ERSAssist;
  }

  /**
   * @return 0 = off, 1 = on
   */
  public short getDRSAssist() {
    return DRSAssist;
  }

  public void setDRSAssist(short DRSAssist) {
    this.DRSAssist = DRSAssist;
  }

  /**
   * @return 0 = off, 1 = corners only, 2 = full
   */
  public short getDynamicRacingLine() {
    return dynamicRacingLine;
  }

  public void setDynamicRacingLine(short dynamicRacingLine) {
    this.dynamicRacingLine = dynamicRacingLine;
  }

  /**
   * @return 0 = 2D, 1 = 3D
   */
  public short getDynamicRacingLineType() {
    return dynamicRacingLineType;
  }

  public void setDynamicRacingLineType(short dynamicRacingLineType) {
    this.dynamicRacingLineType = dynamicRacingLineType;
  }

  public short getGameMode() {
    return gameMode;
  }

  public void setGameMode(short gameMode) {
    this.gameMode = gameMode;
  }

  public short getRuleSet() {
    return ruleSet;
  }

  public void setRuleSet(short ruleSet) {
    this.ruleSet = ruleSet;
  }

  /**
   * @return Local time of day - minutes since midnight
   */
  public long getTimeOfDay() {
    return timeOfDay;
  }

  public void setTimeOfDay(long timeOfDay) {
    this.timeOfDay = timeOfDay;
  }

  /**
   * @return 0 = None, 2 = Very Short, 3 = Short, 4 = Medium
   * 5 = Medium Long, 6 = Long, 7 = Full
   */
  public short getSessionLength() {
    return sessionLength;
  }

  public void setSessionLength(short sessionLength) {
    this.sessionLength = sessionLength;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Session[");
    sb.append(super.toString());
    sb.append(",weather=" + this.weather);
    sb.append(",trackTemperature=" + this.trackTemperature);
    sb.append(",airTemperature=" + this.airTemperature);
    sb.append(",totalLaps=" + this.totalLaps);
    sb.append(",trackLength=" + this.trackLength);
    sb.append(",sessionType=" + this.sessionType);
    sb.append(",trackId=" + this.trackId);
    sb.append(",formula=" + this.formula);
    sb.append(",sessionTimeLeft=" + this.sessionTimeLeft);
    sb.append(",sessionDuration=" + this.sessionDuration);
    sb.append(",pitSpeedLimit=" + this.pitSpeedLimit);
    sb.append(",gamePaused=" + this.gamePaused);
    sb.append(",isSpectating=" + this.isSpectating);
    sb.append(",spectatorCarIndex" + this.spectatorCarIndex);
    sb.append(",sliProNativeSupport=" + this.sliProNativeSupport);
    sb.append(",numMarshalZones=" + this.numMarshalZones);
    sb.append(",marshalZones=");
    for (MarshalZone mz : marshalZones) {
      sb.append(mz.toString() + ",");
    }
    sb.append("safetyCarStatus=" + this.safetyCarStatus);
    sb.append(",networkGame=" + this.networkGame);
    sb.append(",numWeatherForecastSamples=" + this.numWeatherForecastSamples);
    sb.append(",weatherForecastSamples=");
    for (WeatherForecastSample wfs : weatherForecastSamples) {
      sb.append(wfs.toString() + ",");
    }
    sb.append("aiDifficulty=" + this.aiDifficulty);
    sb.append("seasonLinkIdentifier=" + this.seasonLinkIdentifier);
    sb.append("weekendLinkIdentifier=" + this.weekendLinkIdentifier);
    sb.append("sessionLinkIdentifier=" + this.sessionLinkIdentifier);
    sb.append("pitStopWindowIdealLap=" + this.pitStopWindowIdealLap);
    sb.append("pitStopWindowLatestLap=" + this.pitStopWindowLatestLap);
    sb.append("pitStopRejoinPosition=" + this.pitStopRejoinPosition);
    sb.append("steeringAssist=" + this.steeringAssist);
    sb.append("breakingAssist=" + this.breakingAssist);
    sb.append("gearboxAssist=" + this.gearboxAssist);
    sb.append("pitAssist=" + this.pitAssist);
    sb.append("pitReleaseAssist=" + this.pitReleaseAssist);
    sb.append("ERSAssist=" + this.ERSAssist);
    sb.append("DRSAssist=" + this.DRSAssist);
    sb.append("dynamicRacingLine=" + this.dynamicRacingLine);
    sb.append("dynamicRacingLineType=" + this.dynamicRacingLineType);
    sb.append("gameMode=" + this.gameMode);
    sb.append("ruleSet=" + this.ruleSet);
    sb.append("timeOfDay=" + this.timeOfDay);
    sb.append("sessionLength=" + this.sessionLength);
    sb.replace(sb.length() - 1, sb.length() - 1, "]");
    return sb.toString();
  }

  @Override
  public Packet fill(ByteBuf buffer) {
    super.fill(buffer);
    this.weather = Weather.valueOf(buffer.readUnsignedByte());
    this.trackTemperature = buffer.readByte();
    this.airTemperature = buffer.readByte();
    this.totalLaps = buffer.readUnsignedByte();
    this.trackLength = buffer.readUnsignedShortLE();
    this.sessionType = SessionType.valueOf(buffer.readUnsignedByte());
    this.trackId = Track.valueOf(buffer.readByte());
    this.formula = Formula.valueOf(buffer.readUnsignedByte());
    this.sessionTimeLeft = buffer.readUnsignedShortLE();
    this.sessionDuration = buffer.readUnsignedShortLE();
    this.pitSpeedLimit = buffer.readUnsignedByte();
    this.gamePaused = buffer.readUnsignedByte();
    this.isSpectating = buffer.readUnsignedByte();
    this.spectatorCarIndex = buffer.readUnsignedByte();
    this.sliProNativeSupport = buffer.readUnsignedByte();
    this.numMarshalZones = buffer.readUnsignedByte();
    for (int i = 0; i < PacketConstants.MARSHAL_ZONES; i++) {
      MarshalZone mz = new MarshalZone();
      this.marshalZones.add(mz.fill(buffer));
    }
    this.safetyCarStatus = SafetyCarStatus.valueOf(buffer.readUnsignedByte());
    this.networkGame = buffer.readUnsignedByte();
    this.numWeatherForecastSamples = buffer.readUnsignedByte();
    for (int i = 0; i < PacketConstants.WEATHER_FORECAST_SAMPLES; i++) {
      WeatherForecastSample wfs = new WeatherForecastSample();
      this.weatherForecastSamples.add(wfs.fill(buffer));
    }
    this.forecastAccuracy = buffer.readUnsignedByte();
    this.aiDifficulty = buffer.readUnsignedByte();
    this.seasonLinkIdentifier = buffer.readUnsignedIntLE();
    this.weekendLinkIdentifier = buffer.readUnsignedIntLE();
    this.sessionLinkIdentifier = buffer.readUnsignedIntLE();
    this.pitStopWindowIdealLap = buffer.readUnsignedByte();
    this.pitStopWindowLatestLap = buffer.readUnsignedByte();
    this.pitStopRejoinPosition = buffer.readUnsignedByte();
    this.steeringAssist = buffer.readUnsignedByte();
    this.breakingAssist = buffer.readUnsignedByte();
    this.gearboxAssist = buffer.readUnsignedByte();
    this.pitAssist = buffer.readUnsignedByte();
    this.pitReleaseAssist = buffer.readUnsignedByte();
    this.ERSAssist = buffer.readUnsignedByte();
    this.DRSAssist = buffer.readUnsignedByte();
    this.dynamicRacingLine = buffer.readUnsignedByte();
    this.dynamicRacingLineType = buffer.readUnsignedByte();
    this.gameMode = buffer.readUnsignedByte();
    this.ruleSet = buffer.readUnsignedByte();
    this.timeOfDay = buffer.readUnsignedIntLE();
    this.sessionLength = buffer.readUnsignedByte();
    return this;
  }

  @Override
  public ByteBuf fillBuffer(ByteBuf buffer) {
    super.fillBuffer(buffer);

    buffer.writeByte(this.weather.getValue());
    buffer.writeByte(this.trackTemperature);
    buffer.writeByte(this.airTemperature);
    buffer.writeByte(this.totalLaps);
    buffer.writeShortLE(this.trackLength);
    buffer.writeByte(this.sessionType.getValue());
    buffer.writeByte(this.trackId.getValue());
    buffer.writeByte(this.formula.getValue());
    buffer.writeShortLE(this.sessionTimeLeft);
    buffer.writeShortLE(this.sessionDuration);
    buffer.writeByte(this.pitSpeedLimit);
    buffer.writeByte(this.gamePaused);
    buffer.writeByte(this.isSpectating);
    buffer.writeByte(this.spectatorCarIndex);
    buffer.writeByte(this.sliProNativeSupport);
    buffer.writeByte(this.numMarshalZones);
    for (MarshalZone mz : this.marshalZones) {
      mz.fillBuffer(buffer);
    }
    buffer.writeByte(this.safetyCarStatus.getValue());
    buffer.writeByte(this.networkGame);
    buffer.writeByte(this.numWeatherForecastSamples);
    for (WeatherForecastSample wfs : this.weatherForecastSamples) {
      wfs.fillBuffer(buffer);
    }
    buffer.writeByte(this.forecastAccuracy);
    buffer.writeByte(this.aiDifficulty);
    buffer.writeIntLE((int) this.seasonLinkIdentifier);
    buffer.writeIntLE((int) this.weekendLinkIdentifier);
    buffer.writeIntLE((int) this.sessionLinkIdentifier);
    buffer.writeByte(this.pitStopWindowIdealLap);
    buffer.writeByte(this.pitStopWindowLatestLap);
    buffer.writeByte(this.pitStopRejoinPosition);
    buffer.writeByte(this.steeringAssist);
    buffer.writeByte(this.breakingAssist);
    buffer.writeByte(this.gearboxAssist);
    buffer.writeByte(this.pitAssist);
    buffer.writeByte(this.pitReleaseAssist);
    buffer.writeByte(this.ERSAssist);
    buffer.writeByte(this.DRSAssist);
    buffer.writeByte(this.dynamicRacingLine);
    buffer.writeByte(this.dynamicRacingLineType);
    buffer.writeByte(this.gameMode);
    buffer.writeByte(this.ruleSet);
    buffer.writeIntLE((int) this.timeOfDay);
    buffer.writeByte(this.sessionLength);

    return buffer;
  }
}