/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.log.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)")
public class RemoteLogEntry implements org.apache.thrift.TBase<RemoteLogEntry, RemoteLogEntry._Fields>, java.io.Serializable, Cloneable, Comparable<RemoteLogEntry> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("RemoteLogEntry");

  private static final org.apache.thrift.protocol.TField BUILD_UUID_FIELD_DESC = new org.apache.thrift.protocol.TField("buildUuid", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField VERSION_CONTROL_STATS_FIELD_DESC = new org.apache.thrift.protocol.TField("versionControlStats", org.apache.thrift.protocol.TType.STRUCT, (short)2);
  private static final org.apache.thrift.protocol.TField MEMORY_STATS_FIELD_DESC = new org.apache.thrift.protocol.TField("memoryStats", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField PROCESS_STATS_FIELD_DESC = new org.apache.thrift.protocol.TField("processStats", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField TIME_STATS_FIELD_DESC = new org.apache.thrift.protocol.TField("timeStats", org.apache.thrift.protocol.TType.STRUCT, (short)5);
  private static final org.apache.thrift.protocol.TField EXPERIMENT_STATS_FIELD_DESC = new org.apache.thrift.protocol.TField("experimentStats", org.apache.thrift.protocol.TType.STRUCT, (short)6);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new RemoteLogEntryStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new RemoteLogEntryTupleSchemeFactory();

  public java.lang.String buildUuid; // optional
  public VersionControlStatsRemoteLogEntry versionControlStats; // optional
  public MemoryStatsRemoteLogEntry memoryStats; // optional
  public ProcessStatsRemoteLogEntry processStats; // optional
  public TimeStatsRemoteLogEntry timeStats; // optional
  public ExperimentStatsRemoteLogEntry experimentStats; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BUILD_UUID((short)1, "buildUuid"),
    VERSION_CONTROL_STATS((short)2, "versionControlStats"),
    MEMORY_STATS((short)3, "memoryStats"),
    PROCESS_STATS((short)4, "processStats"),
    TIME_STATS((short)5, "timeStats"),
    EXPERIMENT_STATS((short)6, "experimentStats");

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
        case 1: // BUILD_UUID
          return BUILD_UUID;
        case 2: // VERSION_CONTROL_STATS
          return VERSION_CONTROL_STATS;
        case 3: // MEMORY_STATS
          return MEMORY_STATS;
        case 4: // PROCESS_STATS
          return PROCESS_STATS;
        case 5: // TIME_STATS
          return TIME_STATS;
        case 6: // EXPERIMENT_STATS
          return EXPERIMENT_STATS;
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
  private static final _Fields optionals[] = {_Fields.BUILD_UUID,_Fields.VERSION_CONTROL_STATS,_Fields.MEMORY_STATS,_Fields.PROCESS_STATS,_Fields.TIME_STATS,_Fields.EXPERIMENT_STATS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BUILD_UUID, new org.apache.thrift.meta_data.FieldMetaData("buildUuid", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.VERSION_CONTROL_STATS, new org.apache.thrift.meta_data.FieldMetaData("versionControlStats", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, VersionControlStatsRemoteLogEntry.class)));
    tmpMap.put(_Fields.MEMORY_STATS, new org.apache.thrift.meta_data.FieldMetaData("memoryStats", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MemoryStatsRemoteLogEntry.class)));
    tmpMap.put(_Fields.PROCESS_STATS, new org.apache.thrift.meta_data.FieldMetaData("processStats", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ProcessStatsRemoteLogEntry.class)));
    tmpMap.put(_Fields.TIME_STATS, new org.apache.thrift.meta_data.FieldMetaData("timeStats", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TimeStatsRemoteLogEntry.class)));
    tmpMap.put(_Fields.EXPERIMENT_STATS, new org.apache.thrift.meta_data.FieldMetaData("experimentStats", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, ExperimentStatsRemoteLogEntry.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(RemoteLogEntry.class, metaDataMap);
  }

  public RemoteLogEntry() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public RemoteLogEntry(RemoteLogEntry other) {
    if (other.isSetBuildUuid()) {
      this.buildUuid = other.buildUuid;
    }
    if (other.isSetVersionControlStats()) {
      this.versionControlStats = new VersionControlStatsRemoteLogEntry(other.versionControlStats);
    }
    if (other.isSetMemoryStats()) {
      this.memoryStats = new MemoryStatsRemoteLogEntry(other.memoryStats);
    }
    if (other.isSetProcessStats()) {
      this.processStats = new ProcessStatsRemoteLogEntry(other.processStats);
    }
    if (other.isSetTimeStats()) {
      this.timeStats = new TimeStatsRemoteLogEntry(other.timeStats);
    }
    if (other.isSetExperimentStats()) {
      this.experimentStats = new ExperimentStatsRemoteLogEntry(other.experimentStats);
    }
  }

  public RemoteLogEntry deepCopy() {
    return new RemoteLogEntry(this);
  }

  @Override
  public void clear() {
    this.buildUuid = null;
    this.versionControlStats = null;
    this.memoryStats = null;
    this.processStats = null;
    this.timeStats = null;
    this.experimentStats = null;
  }

  public java.lang.String getBuildUuid() {
    return this.buildUuid;
  }

  public RemoteLogEntry setBuildUuid(java.lang.String buildUuid) {
    this.buildUuid = buildUuid;
    return this;
  }

  public void unsetBuildUuid() {
    this.buildUuid = null;
  }

  /** Returns true if field buildUuid is set (has been assigned a value) and false otherwise */
  public boolean isSetBuildUuid() {
    return this.buildUuid != null;
  }

  public void setBuildUuidIsSet(boolean value) {
    if (!value) {
      this.buildUuid = null;
    }
  }

  public VersionControlStatsRemoteLogEntry getVersionControlStats() {
    return this.versionControlStats;
  }

  public RemoteLogEntry setVersionControlStats(VersionControlStatsRemoteLogEntry versionControlStats) {
    this.versionControlStats = versionControlStats;
    return this;
  }

  public void unsetVersionControlStats() {
    this.versionControlStats = null;
  }

  /** Returns true if field versionControlStats is set (has been assigned a value) and false otherwise */
  public boolean isSetVersionControlStats() {
    return this.versionControlStats != null;
  }

  public void setVersionControlStatsIsSet(boolean value) {
    if (!value) {
      this.versionControlStats = null;
    }
  }

  public MemoryStatsRemoteLogEntry getMemoryStats() {
    return this.memoryStats;
  }

  public RemoteLogEntry setMemoryStats(MemoryStatsRemoteLogEntry memoryStats) {
    this.memoryStats = memoryStats;
    return this;
  }

  public void unsetMemoryStats() {
    this.memoryStats = null;
  }

  /** Returns true if field memoryStats is set (has been assigned a value) and false otherwise */
  public boolean isSetMemoryStats() {
    return this.memoryStats != null;
  }

  public void setMemoryStatsIsSet(boolean value) {
    if (!value) {
      this.memoryStats = null;
    }
  }

  public ProcessStatsRemoteLogEntry getProcessStats() {
    return this.processStats;
  }

  public RemoteLogEntry setProcessStats(ProcessStatsRemoteLogEntry processStats) {
    this.processStats = processStats;
    return this;
  }

  public void unsetProcessStats() {
    this.processStats = null;
  }

  /** Returns true if field processStats is set (has been assigned a value) and false otherwise */
  public boolean isSetProcessStats() {
    return this.processStats != null;
  }

  public void setProcessStatsIsSet(boolean value) {
    if (!value) {
      this.processStats = null;
    }
  }

  public TimeStatsRemoteLogEntry getTimeStats() {
    return this.timeStats;
  }

  public RemoteLogEntry setTimeStats(TimeStatsRemoteLogEntry timeStats) {
    this.timeStats = timeStats;
    return this;
  }

  public void unsetTimeStats() {
    this.timeStats = null;
  }

  /** Returns true if field timeStats is set (has been assigned a value) and false otherwise */
  public boolean isSetTimeStats() {
    return this.timeStats != null;
  }

  public void setTimeStatsIsSet(boolean value) {
    if (!value) {
      this.timeStats = null;
    }
  }

  public ExperimentStatsRemoteLogEntry getExperimentStats() {
    return this.experimentStats;
  }

  public RemoteLogEntry setExperimentStats(ExperimentStatsRemoteLogEntry experimentStats) {
    this.experimentStats = experimentStats;
    return this;
  }

  public void unsetExperimentStats() {
    this.experimentStats = null;
  }

  /** Returns true if field experimentStats is set (has been assigned a value) and false otherwise */
  public boolean isSetExperimentStats() {
    return this.experimentStats != null;
  }

  public void setExperimentStatsIsSet(boolean value) {
    if (!value) {
      this.experimentStats = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case BUILD_UUID:
      if (value == null) {
        unsetBuildUuid();
      } else {
        setBuildUuid((java.lang.String)value);
      }
      break;

    case VERSION_CONTROL_STATS:
      if (value == null) {
        unsetVersionControlStats();
      } else {
        setVersionControlStats((VersionControlStatsRemoteLogEntry)value);
      }
      break;

    case MEMORY_STATS:
      if (value == null) {
        unsetMemoryStats();
      } else {
        setMemoryStats((MemoryStatsRemoteLogEntry)value);
      }
      break;

    case PROCESS_STATS:
      if (value == null) {
        unsetProcessStats();
      } else {
        setProcessStats((ProcessStatsRemoteLogEntry)value);
      }
      break;

    case TIME_STATS:
      if (value == null) {
        unsetTimeStats();
      } else {
        setTimeStats((TimeStatsRemoteLogEntry)value);
      }
      break;

    case EXPERIMENT_STATS:
      if (value == null) {
        unsetExperimentStats();
      } else {
        setExperimentStats((ExperimentStatsRemoteLogEntry)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case BUILD_UUID:
      return getBuildUuid();

    case VERSION_CONTROL_STATS:
      return getVersionControlStats();

    case MEMORY_STATS:
      return getMemoryStats();

    case PROCESS_STATS:
      return getProcessStats();

    case TIME_STATS:
      return getTimeStats();

    case EXPERIMENT_STATS:
      return getExperimentStats();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case BUILD_UUID:
      return isSetBuildUuid();
    case VERSION_CONTROL_STATS:
      return isSetVersionControlStats();
    case MEMORY_STATS:
      return isSetMemoryStats();
    case PROCESS_STATS:
      return isSetProcessStats();
    case TIME_STATS:
      return isSetTimeStats();
    case EXPERIMENT_STATS:
      return isSetExperimentStats();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof RemoteLogEntry)
      return this.equals((RemoteLogEntry)that);
    return false;
  }

  public boolean equals(RemoteLogEntry that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_buildUuid = true && this.isSetBuildUuid();
    boolean that_present_buildUuid = true && that.isSetBuildUuid();
    if (this_present_buildUuid || that_present_buildUuid) {
      if (!(this_present_buildUuid && that_present_buildUuid))
        return false;
      if (!this.buildUuid.equals(that.buildUuid))
        return false;
    }

    boolean this_present_versionControlStats = true && this.isSetVersionControlStats();
    boolean that_present_versionControlStats = true && that.isSetVersionControlStats();
    if (this_present_versionControlStats || that_present_versionControlStats) {
      if (!(this_present_versionControlStats && that_present_versionControlStats))
        return false;
      if (!this.versionControlStats.equals(that.versionControlStats))
        return false;
    }

    boolean this_present_memoryStats = true && this.isSetMemoryStats();
    boolean that_present_memoryStats = true && that.isSetMemoryStats();
    if (this_present_memoryStats || that_present_memoryStats) {
      if (!(this_present_memoryStats && that_present_memoryStats))
        return false;
      if (!this.memoryStats.equals(that.memoryStats))
        return false;
    }

    boolean this_present_processStats = true && this.isSetProcessStats();
    boolean that_present_processStats = true && that.isSetProcessStats();
    if (this_present_processStats || that_present_processStats) {
      if (!(this_present_processStats && that_present_processStats))
        return false;
      if (!this.processStats.equals(that.processStats))
        return false;
    }

    boolean this_present_timeStats = true && this.isSetTimeStats();
    boolean that_present_timeStats = true && that.isSetTimeStats();
    if (this_present_timeStats || that_present_timeStats) {
      if (!(this_present_timeStats && that_present_timeStats))
        return false;
      if (!this.timeStats.equals(that.timeStats))
        return false;
    }

    boolean this_present_experimentStats = true && this.isSetExperimentStats();
    boolean that_present_experimentStats = true && that.isSetExperimentStats();
    if (this_present_experimentStats || that_present_experimentStats) {
      if (!(this_present_experimentStats && that_present_experimentStats))
        return false;
      if (!this.experimentStats.equals(that.experimentStats))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetBuildUuid()) ? 131071 : 524287);
    if (isSetBuildUuid())
      hashCode = hashCode * 8191 + buildUuid.hashCode();

    hashCode = hashCode * 8191 + ((isSetVersionControlStats()) ? 131071 : 524287);
    if (isSetVersionControlStats())
      hashCode = hashCode * 8191 + versionControlStats.hashCode();

    hashCode = hashCode * 8191 + ((isSetMemoryStats()) ? 131071 : 524287);
    if (isSetMemoryStats())
      hashCode = hashCode * 8191 + memoryStats.hashCode();

    hashCode = hashCode * 8191 + ((isSetProcessStats()) ? 131071 : 524287);
    if (isSetProcessStats())
      hashCode = hashCode * 8191 + processStats.hashCode();

    hashCode = hashCode * 8191 + ((isSetTimeStats()) ? 131071 : 524287);
    if (isSetTimeStats())
      hashCode = hashCode * 8191 + timeStats.hashCode();

    hashCode = hashCode * 8191 + ((isSetExperimentStats()) ? 131071 : 524287);
    if (isSetExperimentStats())
      hashCode = hashCode * 8191 + experimentStats.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(RemoteLogEntry other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetBuildUuid()).compareTo(other.isSetBuildUuid());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuildUuid()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.buildUuid, other.buildUuid);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetVersionControlStats()).compareTo(other.isSetVersionControlStats());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetVersionControlStats()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.versionControlStats, other.versionControlStats);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetMemoryStats()).compareTo(other.isSetMemoryStats());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMemoryStats()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.memoryStats, other.memoryStats);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetProcessStats()).compareTo(other.isSetProcessStats());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProcessStats()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.processStats, other.processStats);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTimeStats()).compareTo(other.isSetTimeStats());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimeStats()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timeStats, other.timeStats);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetExperimentStats()).compareTo(other.isSetExperimentStats());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExperimentStats()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.experimentStats, other.experimentStats);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("RemoteLogEntry(");
    boolean first = true;

    if (isSetBuildUuid()) {
      sb.append("buildUuid:");
      if (this.buildUuid == null) {
        sb.append("null");
      } else {
        sb.append(this.buildUuid);
      }
      first = false;
    }
    if (isSetVersionControlStats()) {
      if (!first) sb.append(", ");
      sb.append("versionControlStats:");
      if (this.versionControlStats == null) {
        sb.append("null");
      } else {
        sb.append(this.versionControlStats);
      }
      first = false;
    }
    if (isSetMemoryStats()) {
      if (!first) sb.append(", ");
      sb.append("memoryStats:");
      if (this.memoryStats == null) {
        sb.append("null");
      } else {
        sb.append(this.memoryStats);
      }
      first = false;
    }
    if (isSetProcessStats()) {
      if (!first) sb.append(", ");
      sb.append("processStats:");
      if (this.processStats == null) {
        sb.append("null");
      } else {
        sb.append(this.processStats);
      }
      first = false;
    }
    if (isSetTimeStats()) {
      if (!first) sb.append(", ");
      sb.append("timeStats:");
      if (this.timeStats == null) {
        sb.append("null");
      } else {
        sb.append(this.timeStats);
      }
      first = false;
    }
    if (isSetExperimentStats()) {
      if (!first) sb.append(", ");
      sb.append("experimentStats:");
      if (this.experimentStats == null) {
        sb.append("null");
      } else {
        sb.append(this.experimentStats);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (versionControlStats != null) {
      versionControlStats.validate();
    }
    if (memoryStats != null) {
      memoryStats.validate();
    }
    if (processStats != null) {
      processStats.validate();
    }
    if (timeStats != null) {
      timeStats.validate();
    }
    if (experimentStats != null) {
      experimentStats.validate();
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class RemoteLogEntryStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RemoteLogEntryStandardScheme getScheme() {
      return new RemoteLogEntryStandardScheme();
    }
  }

  private static class RemoteLogEntryStandardScheme extends org.apache.thrift.scheme.StandardScheme<RemoteLogEntry> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, RemoteLogEntry struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BUILD_UUID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.buildUuid = iprot.readString();
              struct.setBuildUuidIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // VERSION_CONTROL_STATS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.versionControlStats = new VersionControlStatsRemoteLogEntry();
              struct.versionControlStats.read(iprot);
              struct.setVersionControlStatsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MEMORY_STATS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.memoryStats = new MemoryStatsRemoteLogEntry();
              struct.memoryStats.read(iprot);
              struct.setMemoryStatsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // PROCESS_STATS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.processStats = new ProcessStatsRemoteLogEntry();
              struct.processStats.read(iprot);
              struct.setProcessStatsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // TIME_STATS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.timeStats = new TimeStatsRemoteLogEntry();
              struct.timeStats.read(iprot);
              struct.setTimeStatsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // EXPERIMENT_STATS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.experimentStats = new ExperimentStatsRemoteLogEntry();
              struct.experimentStats.read(iprot);
              struct.setExperimentStatsIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, RemoteLogEntry struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.buildUuid != null) {
        if (struct.isSetBuildUuid()) {
          oprot.writeFieldBegin(BUILD_UUID_FIELD_DESC);
          oprot.writeString(struct.buildUuid);
          oprot.writeFieldEnd();
        }
      }
      if (struct.versionControlStats != null) {
        if (struct.isSetVersionControlStats()) {
          oprot.writeFieldBegin(VERSION_CONTROL_STATS_FIELD_DESC);
          struct.versionControlStats.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.memoryStats != null) {
        if (struct.isSetMemoryStats()) {
          oprot.writeFieldBegin(MEMORY_STATS_FIELD_DESC);
          struct.memoryStats.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.processStats != null) {
        if (struct.isSetProcessStats()) {
          oprot.writeFieldBegin(PROCESS_STATS_FIELD_DESC);
          struct.processStats.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.timeStats != null) {
        if (struct.isSetTimeStats()) {
          oprot.writeFieldBegin(TIME_STATS_FIELD_DESC);
          struct.timeStats.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      if (struct.experimentStats != null) {
        if (struct.isSetExperimentStats()) {
          oprot.writeFieldBegin(EXPERIMENT_STATS_FIELD_DESC);
          struct.experimentStats.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class RemoteLogEntryTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public RemoteLogEntryTupleScheme getScheme() {
      return new RemoteLogEntryTupleScheme();
    }
  }

  private static class RemoteLogEntryTupleScheme extends org.apache.thrift.scheme.TupleScheme<RemoteLogEntry> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, RemoteLogEntry struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetBuildUuid()) {
        optionals.set(0);
      }
      if (struct.isSetVersionControlStats()) {
        optionals.set(1);
      }
      if (struct.isSetMemoryStats()) {
        optionals.set(2);
      }
      if (struct.isSetProcessStats()) {
        optionals.set(3);
      }
      if (struct.isSetTimeStats()) {
        optionals.set(4);
      }
      if (struct.isSetExperimentStats()) {
        optionals.set(5);
      }
      oprot.writeBitSet(optionals, 6);
      if (struct.isSetBuildUuid()) {
        oprot.writeString(struct.buildUuid);
      }
      if (struct.isSetVersionControlStats()) {
        struct.versionControlStats.write(oprot);
      }
      if (struct.isSetMemoryStats()) {
        struct.memoryStats.write(oprot);
      }
      if (struct.isSetProcessStats()) {
        struct.processStats.write(oprot);
      }
      if (struct.isSetTimeStats()) {
        struct.timeStats.write(oprot);
      }
      if (struct.isSetExperimentStats()) {
        struct.experimentStats.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, RemoteLogEntry struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(6);
      if (incoming.get(0)) {
        struct.buildUuid = iprot.readString();
        struct.setBuildUuidIsSet(true);
      }
      if (incoming.get(1)) {
        struct.versionControlStats = new VersionControlStatsRemoteLogEntry();
        struct.versionControlStats.read(iprot);
        struct.setVersionControlStatsIsSet(true);
      }
      if (incoming.get(2)) {
        struct.memoryStats = new MemoryStatsRemoteLogEntry();
        struct.memoryStats.read(iprot);
        struct.setMemoryStatsIsSet(true);
      }
      if (incoming.get(3)) {
        struct.processStats = new ProcessStatsRemoteLogEntry();
        struct.processStats.read(iprot);
        struct.setProcessStatsIsSet(true);
      }
      if (incoming.get(4)) {
        struct.timeStats = new TimeStatsRemoteLogEntry();
        struct.timeStats.read(iprot);
        struct.setTimeStatsIsSet(true);
      }
      if (incoming.get(5)) {
        struct.experimentStats = new ExperimentStatsRemoteLogEntry();
        struct.experimentStats.read(iprot);
        struct.setExperimentStatsIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

