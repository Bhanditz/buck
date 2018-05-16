/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.distributed.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)")
public class BuildSlaveEvent implements org.apache.thrift.TBase<BuildSlaveEvent, BuildSlaveEvent._Fields>, java.io.Serializable, Cloneable, Comparable<BuildSlaveEvent> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("BuildSlaveEvent");

  private static final org.apache.thrift.protocol.TField EVENT_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("eventType", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField TIMESTAMP_MILLIS_FIELD_DESC = new org.apache.thrift.protocol.TField("timestampMillis", org.apache.thrift.protocol.TType.I64, (short)4);
  private static final org.apache.thrift.protocol.TField CONSOLE_EVENT_FIELD_DESC = new org.apache.thrift.protocol.TField("consoleEvent", org.apache.thrift.protocol.TType.STRUCT, (short)10);
  private static final org.apache.thrift.protocol.TField BUILD_RULE_STARTED_EVENT_FIELD_DESC = new org.apache.thrift.protocol.TField("buildRuleStartedEvent", org.apache.thrift.protocol.TType.STRUCT, (short)11);
  private static final org.apache.thrift.protocol.TField BUILD_RULE_FINISHED_EVENT_FIELD_DESC = new org.apache.thrift.protocol.TField("buildRuleFinishedEvent", org.apache.thrift.protocol.TType.STRUCT, (short)12);
  private static final org.apache.thrift.protocol.TField COORDINATOR_BUILD_PROGRESS_EVENT_FIELD_DESC = new org.apache.thrift.protocol.TField("coordinatorBuildProgressEvent", org.apache.thrift.protocol.TType.STRUCT, (short)13);
  private static final org.apache.thrift.protocol.TField BUILD_RULE_UNLOCKED_EVENT_FIELD_DESC = new org.apache.thrift.protocol.TField("buildRuleUnlockedEvent", org.apache.thrift.protocol.TType.STRUCT, (short)14);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new BuildSlaveEventStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new BuildSlaveEventTupleSchemeFactory();

  /**
   * 
   * @see BuildSlaveEventType
   */
  public BuildSlaveEventType eventType; // optional
  public long timestampMillis; // optional
  public BuildSlaveConsoleEvent consoleEvent; // optional
  public BuildRuleStartedEvent buildRuleStartedEvent; // optional
  public BuildRuleFinishedEvent buildRuleFinishedEvent; // optional
  public CoordinatorBuildProgressEvent coordinatorBuildProgressEvent; // optional
  public BuildRuleUnlockedEvent buildRuleUnlockedEvent; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    /**
     * 
     * @see BuildSlaveEventType
     */
    EVENT_TYPE((short)1, "eventType"),
    TIMESTAMP_MILLIS((short)4, "timestampMillis"),
    CONSOLE_EVENT((short)10, "consoleEvent"),
    BUILD_RULE_STARTED_EVENT((short)11, "buildRuleStartedEvent"),
    BUILD_RULE_FINISHED_EVENT((short)12, "buildRuleFinishedEvent"),
    COORDINATOR_BUILD_PROGRESS_EVENT((short)13, "coordinatorBuildProgressEvent"),
    BUILD_RULE_UNLOCKED_EVENT((short)14, "buildRuleUnlockedEvent");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // EVENT_TYPE
          return EVENT_TYPE;
        case 4: // TIMESTAMP_MILLIS
          return TIMESTAMP_MILLIS;
        case 10: // CONSOLE_EVENT
          return CONSOLE_EVENT;
        case 11: // BUILD_RULE_STARTED_EVENT
          return BUILD_RULE_STARTED_EVENT;
        case 12: // BUILD_RULE_FINISHED_EVENT
          return BUILD_RULE_FINISHED_EVENT;
        case 13: // COORDINATOR_BUILD_PROGRESS_EVENT
          return COORDINATOR_BUILD_PROGRESS_EVENT;
        case 14: // BUILD_RULE_UNLOCKED_EVENT
          return BUILD_RULE_UNLOCKED_EVENT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TIMESTAMPMILLIS_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.EVENT_TYPE,_Fields.TIMESTAMP_MILLIS,_Fields.CONSOLE_EVENT,_Fields.BUILD_RULE_STARTED_EVENT,_Fields.BUILD_RULE_FINISHED_EVENT,_Fields.COORDINATOR_BUILD_PROGRESS_EVENT,_Fields.BUILD_RULE_UNLOCKED_EVENT};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EVENT_TYPE, new org.apache.thrift.meta_data.FieldMetaData("eventType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, BuildSlaveEventType.class)));
    tmpMap.put(_Fields.TIMESTAMP_MILLIS, new org.apache.thrift.meta_data.FieldMetaData("timestampMillis", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.CONSOLE_EVENT, new org.apache.thrift.meta_data.FieldMetaData("consoleEvent", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "BuildSlaveConsoleEvent")));
    tmpMap.put(_Fields.BUILD_RULE_STARTED_EVENT, new org.apache.thrift.meta_data.FieldMetaData("buildRuleStartedEvent", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "BuildRuleStartedEvent")));
    tmpMap.put(_Fields.BUILD_RULE_FINISHED_EVENT, new org.apache.thrift.meta_data.FieldMetaData("buildRuleFinishedEvent", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "BuildRuleFinishedEvent")));
    tmpMap.put(_Fields.COORDINATOR_BUILD_PROGRESS_EVENT, new org.apache.thrift.meta_data.FieldMetaData("coordinatorBuildProgressEvent", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "CoordinatorBuildProgressEvent")));
    tmpMap.put(_Fields.BUILD_RULE_UNLOCKED_EVENT, new org.apache.thrift.meta_data.FieldMetaData("buildRuleUnlockedEvent", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRUCT        , "BuildRuleUnlockedEvent")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(BuildSlaveEvent.class, metaDataMap);
  }

  public BuildSlaveEvent() {
    this.eventType = com.facebook.buck.distributed.thrift.BuildSlaveEventType.UNKNOWN;

  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public BuildSlaveEvent(BuildSlaveEvent other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetEventType()) {
      this.eventType = other.eventType;
    }
    this.timestampMillis = other.timestampMillis;
    if (other.isSetConsoleEvent()) {
      this.consoleEvent = new BuildSlaveConsoleEvent(other.consoleEvent);
    }
    if (other.isSetBuildRuleStartedEvent()) {
      this.buildRuleStartedEvent = new BuildRuleStartedEvent(other.buildRuleStartedEvent);
    }
    if (other.isSetBuildRuleFinishedEvent()) {
      this.buildRuleFinishedEvent = new BuildRuleFinishedEvent(other.buildRuleFinishedEvent);
    }
    if (other.isSetCoordinatorBuildProgressEvent()) {
      this.coordinatorBuildProgressEvent = new CoordinatorBuildProgressEvent(other.coordinatorBuildProgressEvent);
    }
    if (other.isSetBuildRuleUnlockedEvent()) {
      this.buildRuleUnlockedEvent = new BuildRuleUnlockedEvent(other.buildRuleUnlockedEvent);
    }
  }

  public BuildSlaveEvent deepCopy() {
    return new BuildSlaveEvent(this);
  }

  @Override
  public void clear() {
    this.eventType = com.facebook.buck.distributed.thrift.BuildSlaveEventType.UNKNOWN;

    setTimestampMillisIsSet(false);
    this.timestampMillis = 0;
    this.consoleEvent = null;
    this.buildRuleStartedEvent = null;
    this.buildRuleFinishedEvent = null;
    this.coordinatorBuildProgressEvent = null;
    this.buildRuleUnlockedEvent = null;
  }

  /**
   * 
   * @see BuildSlaveEventType
   */
  public BuildSlaveEventType getEventType() {
    return this.eventType;
  }

  /**
   * 
   * @see BuildSlaveEventType
   */
  public BuildSlaveEvent setEventType(BuildSlaveEventType eventType) {
    this.eventType = eventType;
    return this;
  }

  public void unsetEventType() {
    this.eventType = null;
  }

  /** Returns true if field eventType is set (has been assigned a value) and false otherwise */
  public boolean isSetEventType() {
    return this.eventType != null;
  }

  public void setEventTypeIsSet(boolean value) {
    if (!value) {
      this.eventType = null;
    }
  }

  public long getTimestampMillis() {
    return this.timestampMillis;
  }

  public BuildSlaveEvent setTimestampMillis(long timestampMillis) {
    this.timestampMillis = timestampMillis;
    setTimestampMillisIsSet(true);
    return this;
  }

  public void unsetTimestampMillis() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TIMESTAMPMILLIS_ISSET_ID);
  }

  /** Returns true if field timestampMillis is set (has been assigned a value) and false otherwise */
  public boolean isSetTimestampMillis() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TIMESTAMPMILLIS_ISSET_ID);
  }

  public void setTimestampMillisIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TIMESTAMPMILLIS_ISSET_ID, value);
  }

  public BuildSlaveConsoleEvent getConsoleEvent() {
    return this.consoleEvent;
  }

  public BuildSlaveEvent setConsoleEvent(BuildSlaveConsoleEvent consoleEvent) {
    this.consoleEvent = consoleEvent;
    return this;
  }

  public void unsetConsoleEvent() {
    this.consoleEvent = null;
  }

  /** Returns true if field consoleEvent is set (has been assigned a value) and false otherwise */
  public boolean isSetConsoleEvent() {
    return this.consoleEvent != null;
  }

  public void setConsoleEventIsSet(boolean value) {
    if (!value) {
      this.consoleEvent = null;
    }
  }

  public BuildRuleStartedEvent getBuildRuleStartedEvent() {
    return this.buildRuleStartedEvent;
  }

  public BuildSlaveEvent setBuildRuleStartedEvent(BuildRuleStartedEvent buildRuleStartedEvent) {
    this.buildRuleStartedEvent = buildRuleStartedEvent;
    return this;
  }

  public void unsetBuildRuleStartedEvent() {
    this.buildRuleStartedEvent = null;
  }

  /** Returns true if field buildRuleStartedEvent is set (has been assigned a value) and false otherwise */
  public boolean isSetBuildRuleStartedEvent() {
    return this.buildRuleStartedEvent != null;
  }

  public void setBuildRuleStartedEventIsSet(boolean value) {
    if (!value) {
      this.buildRuleStartedEvent = null;
    }
  }

  public BuildRuleFinishedEvent getBuildRuleFinishedEvent() {
    return this.buildRuleFinishedEvent;
  }

  public BuildSlaveEvent setBuildRuleFinishedEvent(BuildRuleFinishedEvent buildRuleFinishedEvent) {
    this.buildRuleFinishedEvent = buildRuleFinishedEvent;
    return this;
  }

  public void unsetBuildRuleFinishedEvent() {
    this.buildRuleFinishedEvent = null;
  }

  /** Returns true if field buildRuleFinishedEvent is set (has been assigned a value) and false otherwise */
  public boolean isSetBuildRuleFinishedEvent() {
    return this.buildRuleFinishedEvent != null;
  }

  public void setBuildRuleFinishedEventIsSet(boolean value) {
    if (!value) {
      this.buildRuleFinishedEvent = null;
    }
  }

  public CoordinatorBuildProgressEvent getCoordinatorBuildProgressEvent() {
    return this.coordinatorBuildProgressEvent;
  }

  public BuildSlaveEvent setCoordinatorBuildProgressEvent(CoordinatorBuildProgressEvent coordinatorBuildProgressEvent) {
    this.coordinatorBuildProgressEvent = coordinatorBuildProgressEvent;
    return this;
  }

  public void unsetCoordinatorBuildProgressEvent() {
    this.coordinatorBuildProgressEvent = null;
  }

  /** Returns true if field coordinatorBuildProgressEvent is set (has been assigned a value) and false otherwise */
  public boolean isSetCoordinatorBuildProgressEvent() {
    return this.coordinatorBuildProgressEvent != null;
  }

  public void setCoordinatorBuildProgressEventIsSet(boolean value) {
    if (!value) {
      this.coordinatorBuildProgressEvent = null;
    }
  }

  public BuildRuleUnlockedEvent getBuildRuleUnlockedEvent() {
    return this.buildRuleUnlockedEvent;
  }

  public BuildSlaveEvent setBuildRuleUnlockedEvent(BuildRuleUnlockedEvent buildRuleUnlockedEvent) {
    this.buildRuleUnlockedEvent = buildRuleUnlockedEvent;
    return this;
  }

  public void unsetBuildRuleUnlockedEvent() {
    this.buildRuleUnlockedEvent = null;
  }

  /** Returns true if field buildRuleUnlockedEvent is set (has been assigned a value) and false otherwise */
  public boolean isSetBuildRuleUnlockedEvent() {
    return this.buildRuleUnlockedEvent != null;
  }

  public void setBuildRuleUnlockedEventIsSet(boolean value) {
    if (!value) {
      this.buildRuleUnlockedEvent = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case EVENT_TYPE:
      if (value == null) {
        unsetEventType();
      } else {
        setEventType((BuildSlaveEventType)value);
      }
      break;

    case TIMESTAMP_MILLIS:
      if (value == null) {
        unsetTimestampMillis();
      } else {
        setTimestampMillis((java.lang.Long)value);
      }
      break;

    case CONSOLE_EVENT:
      if (value == null) {
        unsetConsoleEvent();
      } else {
        setConsoleEvent((BuildSlaveConsoleEvent)value);
      }
      break;

    case BUILD_RULE_STARTED_EVENT:
      if (value == null) {
        unsetBuildRuleStartedEvent();
      } else {
        setBuildRuleStartedEvent((BuildRuleStartedEvent)value);
      }
      break;

    case BUILD_RULE_FINISHED_EVENT:
      if (value == null) {
        unsetBuildRuleFinishedEvent();
      } else {
        setBuildRuleFinishedEvent((BuildRuleFinishedEvent)value);
      }
      break;

    case COORDINATOR_BUILD_PROGRESS_EVENT:
      if (value == null) {
        unsetCoordinatorBuildProgressEvent();
      } else {
        setCoordinatorBuildProgressEvent((CoordinatorBuildProgressEvent)value);
      }
      break;

    case BUILD_RULE_UNLOCKED_EVENT:
      if (value == null) {
        unsetBuildRuleUnlockedEvent();
      } else {
        setBuildRuleUnlockedEvent((BuildRuleUnlockedEvent)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case EVENT_TYPE:
      return getEventType();

    case TIMESTAMP_MILLIS:
      return getTimestampMillis();

    case CONSOLE_EVENT:
      return getConsoleEvent();

    case BUILD_RULE_STARTED_EVENT:
      return getBuildRuleStartedEvent();

    case BUILD_RULE_FINISHED_EVENT:
      return getBuildRuleFinishedEvent();

    case COORDINATOR_BUILD_PROGRESS_EVENT:
      return getCoordinatorBuildProgressEvent();

    case BUILD_RULE_UNLOCKED_EVENT:
      return getBuildRuleUnlockedEvent();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case EVENT_TYPE:
      return isSetEventType();
    case TIMESTAMP_MILLIS:
      return isSetTimestampMillis();
    case CONSOLE_EVENT:
      return isSetConsoleEvent();
    case BUILD_RULE_STARTED_EVENT:
      return isSetBuildRuleStartedEvent();
    case BUILD_RULE_FINISHED_EVENT:
      return isSetBuildRuleFinishedEvent();
    case COORDINATOR_BUILD_PROGRESS_EVENT:
      return isSetCoordinatorBuildProgressEvent();
    case BUILD_RULE_UNLOCKED_EVENT:
      return isSetBuildRuleUnlockedEvent();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof BuildSlaveEvent)
      return this.equals((BuildSlaveEvent)that);
    return false;
  }

  public boolean equals(BuildSlaveEvent that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_eventType = true && this.isSetEventType();
    boolean that_present_eventType = true && that.isSetEventType();
    if (this_present_eventType || that_present_eventType) {
      if (!(this_present_eventType && that_present_eventType))
        return false;
      if (!this.eventType.equals(that.eventType))
        return false;
    }

    boolean this_present_timestampMillis = true && this.isSetTimestampMillis();
    boolean that_present_timestampMillis = true && that.isSetTimestampMillis();
    if (this_present_timestampMillis || that_present_timestampMillis) {
      if (!(this_present_timestampMillis && that_present_timestampMillis))
        return false;
      if (this.timestampMillis != that.timestampMillis)
        return false;
    }

    boolean this_present_consoleEvent = true && this.isSetConsoleEvent();
    boolean that_present_consoleEvent = true && that.isSetConsoleEvent();
    if (this_present_consoleEvent || that_present_consoleEvent) {
      if (!(this_present_consoleEvent && that_present_consoleEvent))
        return false;
      if (!this.consoleEvent.equals(that.consoleEvent))
        return false;
    }

    boolean this_present_buildRuleStartedEvent = true && this.isSetBuildRuleStartedEvent();
    boolean that_present_buildRuleStartedEvent = true && that.isSetBuildRuleStartedEvent();
    if (this_present_buildRuleStartedEvent || that_present_buildRuleStartedEvent) {
      if (!(this_present_buildRuleStartedEvent && that_present_buildRuleStartedEvent))
        return false;
      if (!this.buildRuleStartedEvent.equals(that.buildRuleStartedEvent))
        return false;
    }

    boolean this_present_buildRuleFinishedEvent = true && this.isSetBuildRuleFinishedEvent();
    boolean that_present_buildRuleFinishedEvent = true && that.isSetBuildRuleFinishedEvent();
    if (this_present_buildRuleFinishedEvent || that_present_buildRuleFinishedEvent) {
      if (!(this_present_buildRuleFinishedEvent && that_present_buildRuleFinishedEvent))
        return false;
      if (!this.buildRuleFinishedEvent.equals(that.buildRuleFinishedEvent))
        return false;
    }

    boolean this_present_coordinatorBuildProgressEvent = true && this.isSetCoordinatorBuildProgressEvent();
    boolean that_present_coordinatorBuildProgressEvent = true && that.isSetCoordinatorBuildProgressEvent();
    if (this_present_coordinatorBuildProgressEvent || that_present_coordinatorBuildProgressEvent) {
      if (!(this_present_coordinatorBuildProgressEvent && that_present_coordinatorBuildProgressEvent))
        return false;
      if (!this.coordinatorBuildProgressEvent.equals(that.coordinatorBuildProgressEvent))
        return false;
    }

    boolean this_present_buildRuleUnlockedEvent = true && this.isSetBuildRuleUnlockedEvent();
    boolean that_present_buildRuleUnlockedEvent = true && that.isSetBuildRuleUnlockedEvent();
    if (this_present_buildRuleUnlockedEvent || that_present_buildRuleUnlockedEvent) {
      if (!(this_present_buildRuleUnlockedEvent && that_present_buildRuleUnlockedEvent))
        return false;
      if (!this.buildRuleUnlockedEvent.equals(that.buildRuleUnlockedEvent))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetEventType()) ? 131071 : 524287);
    if (isSetEventType())
      hashCode = hashCode * 8191 + eventType.getValue();

    hashCode = hashCode * 8191 + ((isSetTimestampMillis()) ? 131071 : 524287);
    if (isSetTimestampMillis())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(timestampMillis);

    hashCode = hashCode * 8191 + ((isSetConsoleEvent()) ? 131071 : 524287);
    if (isSetConsoleEvent())
      hashCode = hashCode * 8191 + consoleEvent.hashCode();

    hashCode = hashCode * 8191 + ((isSetBuildRuleStartedEvent()) ? 131071 : 524287);
    if (isSetBuildRuleStartedEvent())
      hashCode = hashCode * 8191 + buildRuleStartedEvent.hashCode();

    hashCode = hashCode * 8191 + ((isSetBuildRuleFinishedEvent()) ? 131071 : 524287);
    if (isSetBuildRuleFinishedEvent())
      hashCode = hashCode * 8191 + buildRuleFinishedEvent.hashCode();

    hashCode = hashCode * 8191 + ((isSetCoordinatorBuildProgressEvent()) ? 131071 : 524287);
    if (isSetCoordinatorBuildProgressEvent())
      hashCode = hashCode * 8191 + coordinatorBuildProgressEvent.hashCode();

    hashCode = hashCode * 8191 + ((isSetBuildRuleUnlockedEvent()) ? 131071 : 524287);
    if (isSetBuildRuleUnlockedEvent())
      hashCode = hashCode * 8191 + buildRuleUnlockedEvent.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(BuildSlaveEvent other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetEventType()).compareTo(other.isSetEventType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetEventType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.eventType, other.eventType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTimestampMillis()).compareTo(other.isSetTimestampMillis());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimestampMillis()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timestampMillis, other.timestampMillis);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetConsoleEvent()).compareTo(other.isSetConsoleEvent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetConsoleEvent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.consoleEvent, other.consoleEvent);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetBuildRuleStartedEvent()).compareTo(other.isSetBuildRuleStartedEvent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuildRuleStartedEvent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.buildRuleStartedEvent, other.buildRuleStartedEvent);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetBuildRuleFinishedEvent()).compareTo(other.isSetBuildRuleFinishedEvent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuildRuleFinishedEvent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.buildRuleFinishedEvent, other.buildRuleFinishedEvent);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetCoordinatorBuildProgressEvent()).compareTo(other.isSetCoordinatorBuildProgressEvent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetCoordinatorBuildProgressEvent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.coordinatorBuildProgressEvent, other.coordinatorBuildProgressEvent);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetBuildRuleUnlockedEvent()).compareTo(other.isSetBuildRuleUnlockedEvent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuildRuleUnlockedEvent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.buildRuleUnlockedEvent, other.buildRuleUnlockedEvent);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("BuildSlaveEvent(");
    boolean first = true;

    if (isSetEventType()) {
      sb.append("eventType:");
      if (this.eventType == null) {
        sb.append("null");
      } else {
        sb.append(this.eventType);
      }
      first = false;
    }
    if (isSetTimestampMillis()) {
      if (!first) sb.append(", ");
      sb.append("timestampMillis:");
      sb.append(this.timestampMillis);
      first = false;
    }
    if (isSetConsoleEvent()) {
      if (!first) sb.append(", ");
      sb.append("consoleEvent:");
      if (this.consoleEvent == null) {
        sb.append("null");
      } else {
        sb.append(this.consoleEvent);
      }
      first = false;
    }
    if (isSetBuildRuleStartedEvent()) {
      if (!first) sb.append(", ");
      sb.append("buildRuleStartedEvent:");
      if (this.buildRuleStartedEvent == null) {
        sb.append("null");
      } else {
        sb.append(this.buildRuleStartedEvent);
      }
      first = false;
    }
    if (isSetBuildRuleFinishedEvent()) {
      if (!first) sb.append(", ");
      sb.append("buildRuleFinishedEvent:");
      if (this.buildRuleFinishedEvent == null) {
        sb.append("null");
      } else {
        sb.append(this.buildRuleFinishedEvent);
      }
      first = false;
    }
    if (isSetCoordinatorBuildProgressEvent()) {
      if (!first) sb.append(", ");
      sb.append("coordinatorBuildProgressEvent:");
      if (this.coordinatorBuildProgressEvent == null) {
        sb.append("null");
      } else {
        sb.append(this.coordinatorBuildProgressEvent);
      }
      first = false;
    }
    if (isSetBuildRuleUnlockedEvent()) {
      if (!first) sb.append(", ");
      sb.append("buildRuleUnlockedEvent:");
      if (this.buildRuleUnlockedEvent == null) {
        sb.append("null");
      } else {
        sb.append(this.buildRuleUnlockedEvent);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class BuildSlaveEventStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BuildSlaveEventStandardScheme getScheme() {
      return new BuildSlaveEventStandardScheme();
    }
  }

  private static class BuildSlaveEventStandardScheme extends org.apache.thrift.scheme.StandardScheme<BuildSlaveEvent> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, BuildSlaveEvent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EVENT_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.eventType = com.facebook.buck.distributed.thrift.BuildSlaveEventType.findByValue(iprot.readI32());
              struct.setEventTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // TIMESTAMP_MILLIS
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timestampMillis = iprot.readI64();
              struct.setTimestampMillisIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 10: // CONSOLE_EVENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.consoleEvent = new BuildSlaveConsoleEvent();
              struct.consoleEvent.read(iprot);
              struct.setConsoleEventIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 11: // BUILD_RULE_STARTED_EVENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.buildRuleStartedEvent = new BuildRuleStartedEvent();
              struct.buildRuleStartedEvent.read(iprot);
              struct.setBuildRuleStartedEventIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 12: // BUILD_RULE_FINISHED_EVENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.buildRuleFinishedEvent = new BuildRuleFinishedEvent();
              struct.buildRuleFinishedEvent.read(iprot);
              struct.setBuildRuleFinishedEventIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 13: // COORDINATOR_BUILD_PROGRESS_EVENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.coordinatorBuildProgressEvent = new CoordinatorBuildProgressEvent();
              struct.coordinatorBuildProgressEvent.read(iprot);
              struct.setCoordinatorBuildProgressEventIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 14: // BUILD_RULE_UNLOCKED_EVENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.buildRuleUnlockedEvent = new BuildRuleUnlockedEvent();
              struct.buildRuleUnlockedEvent.read(iprot);
              struct.setBuildRuleUnlockedEventIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, BuildSlaveEvent struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.eventType != null) {
        if (struct.isSetEventType()) {
          oprot.writeFieldBegin(EVENT_TYPE_FIELD_DESC);
          oprot.writeI32(struct.eventType.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetTimestampMillis()) {
        oprot.writeFieldBegin(TIMESTAMP_MILLIS_FIELD_DESC);
        oprot.writeI64(struct.timestampMillis);
        oprot.writeFieldEnd();
      }
      if (struct.consoleEvent != null) {
        if (struct.isSetConsoleEvent()) {
          oprot.writeFieldBegin(CONSOLE_EVENT_FIELD_DESC);
          struct.consoleEvent.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.buildRuleStartedEvent != null) {
        if (struct.isSetBuildRuleStartedEvent()) {
          oprot.writeFieldBegin(BUILD_RULE_STARTED_EVENT_FIELD_DESC);
          struct.buildRuleStartedEvent.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.buildRuleFinishedEvent != null) {
        if (struct.isSetBuildRuleFinishedEvent()) {
          oprot.writeFieldBegin(BUILD_RULE_FINISHED_EVENT_FIELD_DESC);
          struct.buildRuleFinishedEvent.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.coordinatorBuildProgressEvent != null) {
        if (struct.isSetCoordinatorBuildProgressEvent()) {
          oprot.writeFieldBegin(COORDINATOR_BUILD_PROGRESS_EVENT_FIELD_DESC);
          struct.coordinatorBuildProgressEvent.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.buildRuleUnlockedEvent != null) {
        if (struct.isSetBuildRuleUnlockedEvent()) {
          oprot.writeFieldBegin(BUILD_RULE_UNLOCKED_EVENT_FIELD_DESC);
          struct.buildRuleUnlockedEvent.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class BuildSlaveEventTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public BuildSlaveEventTupleScheme getScheme() {
      return new BuildSlaveEventTupleScheme();
    }
  }

  private static class BuildSlaveEventTupleScheme extends org.apache.thrift.scheme.TupleScheme<BuildSlaveEvent> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, BuildSlaveEvent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetEventType()) {
        optionals.set(0);
      }
      if (struct.isSetTimestampMillis()) {
        optionals.set(1);
      }
      if (struct.isSetConsoleEvent()) {
        optionals.set(2);
      }
      if (struct.isSetBuildRuleStartedEvent()) {
        optionals.set(3);
      }
      if (struct.isSetBuildRuleFinishedEvent()) {
        optionals.set(4);
      }
      if (struct.isSetCoordinatorBuildProgressEvent()) {
        optionals.set(5);
      }
      if (struct.isSetBuildRuleUnlockedEvent()) {
        optionals.set(6);
      }
      oprot.writeBitSet(optionals, 7);
      if (struct.isSetEventType()) {
        oprot.writeI32(struct.eventType.getValue());
      }
      if (struct.isSetTimestampMillis()) {
        oprot.writeI64(struct.timestampMillis);
      }
      if (struct.isSetConsoleEvent()) {
        struct.consoleEvent.write(oprot);
      }
      if (struct.isSetBuildRuleStartedEvent()) {
        struct.buildRuleStartedEvent.write(oprot);
      }
      if (struct.isSetBuildRuleFinishedEvent()) {
        struct.buildRuleFinishedEvent.write(oprot);
      }
      if (struct.isSetCoordinatorBuildProgressEvent()) {
        struct.coordinatorBuildProgressEvent.write(oprot);
      }
      if (struct.isSetBuildRuleUnlockedEvent()) {
        struct.buildRuleUnlockedEvent.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, BuildSlaveEvent struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(7);
      if (incoming.get(0)) {
        struct.eventType = com.facebook.buck.distributed.thrift.BuildSlaveEventType.findByValue(iprot.readI32());
        struct.setEventTypeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.timestampMillis = iprot.readI64();
        struct.setTimestampMillisIsSet(true);
      }
      if (incoming.get(2)) {
        struct.consoleEvent = new BuildSlaveConsoleEvent();
        struct.consoleEvent.read(iprot);
        struct.setConsoleEventIsSet(true);
      }
      if (incoming.get(3)) {
        struct.buildRuleStartedEvent = new BuildRuleStartedEvent();
        struct.buildRuleStartedEvent.read(iprot);
        struct.setBuildRuleStartedEventIsSet(true);
      }
      if (incoming.get(4)) {
        struct.buildRuleFinishedEvent = new BuildRuleFinishedEvent();
        struct.buildRuleFinishedEvent.read(iprot);
        struct.setBuildRuleFinishedEventIsSet(true);
      }
      if (incoming.get(5)) {
        struct.coordinatorBuildProgressEvent = new CoordinatorBuildProgressEvent();
        struct.coordinatorBuildProgressEvent.read(iprot);
        struct.setCoordinatorBuildProgressEventIsSet(true);
      }
      if (incoming.get(6)) {
        struct.buildRuleUnlockedEvent = new BuildRuleUnlockedEvent();
        struct.buildRuleUnlockedEvent.read(iprot);
        struct.setBuildRuleUnlockedEventIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

