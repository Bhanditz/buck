/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package com.facebook.buck.distributed.thrift;


public enum BuildSlaveEventType implements org.apache.thrift.TEnum {
  UNKNOWN(0),
  CONSOLE_EVENT(1),
  BUILD_RULE_STARTED_EVENT(2),
  BUILD_RULE_FINISHED_EVENT(3),
  ALL_BUILD_RULES_FINISHED_EVENT(4),
  MOST_BUILD_RULES_FINISHED_EVENT(5),
  COORDINATOR_BUILD_PROGRESS_EVENT(6),
  BUILD_RULE_UNLOCKED_EVENT(7);

  private final int value;

  private BuildSlaveEventType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  public static BuildSlaveEventType findByValue(int value) { 
    switch (value) {
      case 0:
        return UNKNOWN;
      case 1:
        return CONSOLE_EVENT;
      case 2:
        return BUILD_RULE_STARTED_EVENT;
      case 3:
        return BUILD_RULE_FINISHED_EVENT;
      case 4:
        return ALL_BUILD_RULES_FINISHED_EVENT;
      case 5:
        return MOST_BUILD_RULES_FINISHED_EVENT;
      case 6:
        return COORDINATOR_BUILD_PROGRESS_EVENT;
      case 7:
        return BUILD_RULE_UNLOCKED_EVENT;
      default:
        return null;
    }
  }
}
