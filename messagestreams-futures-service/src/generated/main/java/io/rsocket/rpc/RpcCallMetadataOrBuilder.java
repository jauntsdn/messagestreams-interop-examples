// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rsocket/call_metadata.proto

package io.rsocket.rpc;

public interface RpcCallMetadataOrBuilder extends
    // @@protoc_insertion_point(interface_extends:io.rsocket.rpc.RpcCallMetadata)
    com.google.protobuf.MessageLiteOrBuilder {

  /**
   * <code>repeated string name_values = 1;</code>
   * @return A list containing the nameValues.
   */
  java.util.List<java.lang.String>
      getNameValuesList();
  /**
   * <code>repeated string name_values = 1;</code>
   * @return The count of nameValues.
   */
  int getNameValuesCount();
  /**
   * <code>repeated string name_values = 1;</code>
   * @param index The index of the element to return.
   * @return The nameValues at the given index.
   */
  java.lang.String getNameValues(int index);
  /**
   * <code>repeated string name_values = 1;</code>
   * @param index The index of the element to return.
   * @return The nameValues at the given index.
   */
  com.google.protobuf.ByteString
      getNameValuesBytes(int index);
}
