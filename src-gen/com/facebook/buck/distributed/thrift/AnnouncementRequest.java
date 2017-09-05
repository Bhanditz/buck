/**
 * Autogenerated by Thrift Compiler (0.10.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.distributed.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.10.0)", date = "2017-09-01")
public class AnnouncementRequest implements org.apache.thrift.TBase<AnnouncementRequest, AnnouncementRequest._Fields>, java.io.Serializable, Cloneable, Comparable<AnnouncementRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("AnnouncementRequest");

  private static final org.apache.thrift.protocol.TField BUCK_VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("buckVersion", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField REPOSITORY_FIELD_DESC = new org.apache.thrift.protocol.TField("repository", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new AnnouncementRequestStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new AnnouncementRequestTupleSchemeFactory();

  public java.lang.String buckVersion; // optional
  public java.lang.String repository; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    BUCK_VERSION((short)1, "buckVersion"),
    REPOSITORY((short)2, "repository");

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
        case 1: // BUCK_VERSION
          return BUCK_VERSION;
        case 2: // REPOSITORY
          return REPOSITORY;
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
  private static final _Fields optionals[] = {_Fields.BUCK_VERSION,_Fields.REPOSITORY};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.BUCK_VERSION, new org.apache.thrift.meta_data.FieldMetaData("buckVersion", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.REPOSITORY, new org.apache.thrift.meta_data.FieldMetaData("repository", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(AnnouncementRequest.class, metaDataMap);
  }

  public AnnouncementRequest() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public AnnouncementRequest(AnnouncementRequest other) {
    if (other.isSetBuckVersion()) {
      this.buckVersion = other.buckVersion;
    }
    if (other.isSetRepository()) {
      this.repository = other.repository;
    }
  }

  public AnnouncementRequest deepCopy() {
    return new AnnouncementRequest(this);
  }

  @Override
  public void clear() {
    this.buckVersion = null;
    this.repository = null;
  }

  public java.lang.String getBuckVersion() {
    return this.buckVersion;
  }

  public AnnouncementRequest setBuckVersion(java.lang.String buckVersion) {
    this.buckVersion = buckVersion;
    return this;
  }

  public void unsetBuckVersion() {
    this.buckVersion = null;
  }

  /** Returns true if field buckVersion is set (has been assigned a value) and false otherwise */
  public boolean isSetBuckVersion() {
    return this.buckVersion != null;
  }

  public void setBuckVersionIsSet(boolean value) {
    if (!value) {
      this.buckVersion = null;
    }
  }

  public java.lang.String getRepository() {
    return this.repository;
  }

  public AnnouncementRequest setRepository(java.lang.String repository) {
    this.repository = repository;
    return this;
  }

  public void unsetRepository() {
    this.repository = null;
  }

  /** Returns true if field repository is set (has been assigned a value) and false otherwise */
  public boolean isSetRepository() {
    return this.repository != null;
  }

  public void setRepositoryIsSet(boolean value) {
    if (!value) {
      this.repository = null;
    }
  }

  public void setFieldValue(_Fields field, java.lang.Object value) {
    switch (field) {
    case BUCK_VERSION:
      if (value == null) {
        unsetBuckVersion();
      } else {
        setBuckVersion((java.lang.String)value);
      }
      break;

    case REPOSITORY:
      if (value == null) {
        unsetRepository();
      } else {
        setRepository((java.lang.String)value);
      }
      break;

    }
  }

  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case BUCK_VERSION:
      return getBuckVersion();

    case REPOSITORY:
      return getRepository();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case BUCK_VERSION:
      return isSetBuckVersion();
    case REPOSITORY:
      return isSetRepository();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof AnnouncementRequest)
      return this.equals((AnnouncementRequest)that);
    return false;
  }

  public boolean equals(AnnouncementRequest that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_buckVersion = true && this.isSetBuckVersion();
    boolean that_present_buckVersion = true && that.isSetBuckVersion();
    if (this_present_buckVersion || that_present_buckVersion) {
      if (!(this_present_buckVersion && that_present_buckVersion))
        return false;
      if (!this.buckVersion.equals(that.buckVersion))
        return false;
    }

    boolean this_present_repository = true && this.isSetRepository();
    boolean that_present_repository = true && that.isSetRepository();
    if (this_present_repository || that_present_repository) {
      if (!(this_present_repository && that_present_repository))
        return false;
      if (!this.repository.equals(that.repository))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetBuckVersion()) ? 131071 : 524287);
    if (isSetBuckVersion())
      hashCode = hashCode * 8191 + buckVersion.hashCode();

    hashCode = hashCode * 8191 + ((isSetRepository()) ? 131071 : 524287);
    if (isSetRepository())
      hashCode = hashCode * 8191 + repository.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(AnnouncementRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetBuckVersion()).compareTo(other.isSetBuckVersion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetBuckVersion()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.buckVersion, other.buckVersion);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetRepository()).compareTo(other.isSetRepository());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRepository()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.repository, other.repository);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("AnnouncementRequest(");
    boolean first = true;

    if (isSetBuckVersion()) {
      sb.append("buckVersion:");
      if (this.buckVersion == null) {
        sb.append("null");
      } else {
        sb.append(this.buckVersion);
      }
      first = false;
    }
    if (isSetRepository()) {
      if (!first) sb.append(", ");
      sb.append("repository:");
      if (this.repository == null) {
        sb.append("null");
      } else {
        sb.append(this.repository);
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class AnnouncementRequestStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public AnnouncementRequestStandardScheme getScheme() {
      return new AnnouncementRequestStandardScheme();
    }
  }

  private static class AnnouncementRequestStandardScheme extends org.apache.thrift.scheme.StandardScheme<AnnouncementRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, AnnouncementRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // BUCK_VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.buckVersion = iprot.readString();
              struct.setBuckVersionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // REPOSITORY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.repository = iprot.readString();
              struct.setRepositoryIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, AnnouncementRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.buckVersion != null) {
        if (struct.isSetBuckVersion()) {
          oprot.writeFieldBegin(BUCK_VERSION_FIELD_DESC);
          oprot.writeString(struct.buckVersion);
          oprot.writeFieldEnd();
        }
      }
      if (struct.repository != null) {
        if (struct.isSetRepository()) {
          oprot.writeFieldBegin(REPOSITORY_FIELD_DESC);
          oprot.writeString(struct.repository);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class AnnouncementRequestTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public AnnouncementRequestTupleScheme getScheme() {
      return new AnnouncementRequestTupleScheme();
    }
  }

  private static class AnnouncementRequestTupleScheme extends org.apache.thrift.scheme.TupleScheme<AnnouncementRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, AnnouncementRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetBuckVersion()) {
        optionals.set(0);
      }
      if (struct.isSetRepository()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetBuckVersion()) {
        oprot.writeString(struct.buckVersion);
      }
      if (struct.isSetRepository()) {
        oprot.writeString(struct.repository);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, AnnouncementRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.buckVersion = iprot.readString();
        struct.setBuckVersionIsSet(true);
      }
      if (incoming.get(1)) {
        struct.repository = iprot.readString();
        struct.setRepositoryIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

