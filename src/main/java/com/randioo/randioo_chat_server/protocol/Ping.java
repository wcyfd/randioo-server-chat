// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Ping.proto

package com.randioo.randioo_chat_server.protocol;

public final class Ping {
  private Ping() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public static final class PingRequest extends
      com.google.protobuf.GeneratedMessage {
    // Use PingRequest.newBuilder() to construct.
    private PingRequest() {
      initFields();
    }
    private PingRequest(boolean noInit) {}
    
    private static final PingRequest defaultInstance;
    public static PingRequest getDefaultInstance() {
      return defaultInstance;
    }
    
    public PingRequest getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.randioo.randioo_chat_server.protocol.Ping.internal_static_com_randioo_randioo_chat_server_protocol_PingRequest_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.randioo.randioo_chat_server.protocol.Ping.internal_static_com_randioo_randioo_chat_server_protocol_PingRequest_fieldAccessorTable;
    }
    
    // optional int64 clientTimestamp = 1;
    public static final int CLIENTTIMESTAMP_FIELD_NUMBER = 1;
    private boolean hasClientTimestamp;
    private long clientTimestamp_ = 0L;
    public boolean hasClientTimestamp() { return hasClientTimestamp; }
    public long getClientTimestamp() { return clientTimestamp_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasClientTimestamp()) {
        output.writeInt64(1, getClientTimestamp());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasClientTimestamp()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, getClientTimestamp());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.randioo.randioo_chat_server.protocol.Ping.PingRequest parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingRequest parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingRequest parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingRequest parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingRequest parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingRequest parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingRequest parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingRequest parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingRequest parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingRequest parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.randioo.randioo_chat_server.protocol.Ping.PingRequest prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.randioo.randioo_chat_server.protocol.Ping.PingRequest result;
      
      // Construct using com.randioo.randioo_chat_server.protocol.Ping.PingRequest.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.randioo.randioo_chat_server.protocol.Ping.PingRequest();
        return builder;
      }
      
      protected com.randioo.randioo_chat_server.protocol.Ping.PingRequest internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.randioo.randioo_chat_server.protocol.Ping.PingRequest();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.randioo.randioo_chat_server.protocol.Ping.PingRequest.getDescriptor();
      }
      
      public com.randioo.randioo_chat_server.protocol.Ping.PingRequest getDefaultInstanceForType() {
        return com.randioo.randioo_chat_server.protocol.Ping.PingRequest.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.randioo.randioo_chat_server.protocol.Ping.PingRequest build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.randioo.randioo_chat_server.protocol.Ping.PingRequest buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.randioo.randioo_chat_server.protocol.Ping.PingRequest buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.randioo.randioo_chat_server.protocol.Ping.PingRequest returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.randioo.randioo_chat_server.protocol.Ping.PingRequest) {
          return mergeFrom((com.randioo.randioo_chat_server.protocol.Ping.PingRequest)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.randioo.randioo_chat_server.protocol.Ping.PingRequest other) {
        if (other == com.randioo.randioo_chat_server.protocol.Ping.PingRequest.getDefaultInstance()) return this;
        if (other.hasClientTimestamp()) {
          setClientTimestamp(other.getClientTimestamp());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 8: {
              setClientTimestamp(input.readInt64());
              break;
            }
          }
        }
      }
      
      
      // optional int64 clientTimestamp = 1;
      public boolean hasClientTimestamp() {
        return result.hasClientTimestamp();
      }
      public long getClientTimestamp() {
        return result.getClientTimestamp();
      }
      public Builder setClientTimestamp(long value) {
        result.hasClientTimestamp = true;
        result.clientTimestamp_ = value;
        return this;
      }
      public Builder clearClientTimestamp() {
        result.hasClientTimestamp = false;
        result.clientTimestamp_ = 0L;
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:com.randioo.randioo_chat_server.protocol.PingRequest)
    }
    
    static {
      defaultInstance = new PingRequest(true);
      com.randioo.randioo_chat_server.protocol.Ping.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.randioo.randioo_chat_server.protocol.PingRequest)
  }
  
  public static final class PingResponse extends
      com.google.protobuf.GeneratedMessage {
    // Use PingResponse.newBuilder() to construct.
    private PingResponse() {
      initFields();
    }
    private PingResponse(boolean noInit) {}
    
    private static final PingResponse defaultInstance;
    public static PingResponse getDefaultInstance() {
      return defaultInstance;
    }
    
    public PingResponse getDefaultInstanceForType() {
      return defaultInstance;
    }
    
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.randioo.randioo_chat_server.protocol.Ping.internal_static_com_randioo_randioo_chat_server_protocol_PingResponse_descriptor;
    }
    
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.randioo.randioo_chat_server.protocol.Ping.internal_static_com_randioo_randioo_chat_server_protocol_PingResponse_fieldAccessorTable;
    }
    
    // optional int64 clientTimestamp = 1;
    public static final int CLIENTTIMESTAMP_FIELD_NUMBER = 1;
    private boolean hasClientTimestamp;
    private long clientTimestamp_ = 0L;
    public boolean hasClientTimestamp() { return hasClientTimestamp; }
    public long getClientTimestamp() { return clientTimestamp_; }
    
    // optional int64 serverTimestamp = 2;
    public static final int SERVERTIMESTAMP_FIELD_NUMBER = 2;
    private boolean hasServerTimestamp;
    private long serverTimestamp_ = 0L;
    public boolean hasServerTimestamp() { return hasServerTimestamp; }
    public long getServerTimestamp() { return serverTimestamp_; }
    
    private void initFields() {
    }
    public final boolean isInitialized() {
      return true;
    }
    
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (hasClientTimestamp()) {
        output.writeInt64(1, getClientTimestamp());
      }
      if (hasServerTimestamp()) {
        output.writeInt64(2, getServerTimestamp());
      }
      getUnknownFields().writeTo(output);
    }
    
    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;
    
      size = 0;
      if (hasClientTimestamp()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, getClientTimestamp());
      }
      if (hasServerTimestamp()) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(2, getServerTimestamp());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }
    
    public static com.randioo.randioo_chat_server.protocol.Ping.PingResponse parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingResponse parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingResponse parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data).buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingResponse parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return newBuilder().mergeFrom(data, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingResponse parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingResponse parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingResponse parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingResponse parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Builder builder = newBuilder();
      if (builder.mergeDelimitedFrom(input, extensionRegistry)) {
        return builder.buildParsed();
      } else {
        return null;
      }
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingResponse parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input).buildParsed();
    }
    public static com.randioo.randioo_chat_server.protocol.Ping.PingResponse parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return newBuilder().mergeFrom(input, extensionRegistry)
               .buildParsed();
    }
    
    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.randioo.randioo_chat_server.protocol.Ping.PingResponse prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }
    
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> {
      private com.randioo.randioo_chat_server.protocol.Ping.PingResponse result;
      
      // Construct using com.randioo.randioo_chat_server.protocol.Ping.PingResponse.newBuilder()
      private Builder() {}
      
      private static Builder create() {
        Builder builder = new Builder();
        builder.result = new com.randioo.randioo_chat_server.protocol.Ping.PingResponse();
        return builder;
      }
      
      protected com.randioo.randioo_chat_server.protocol.Ping.PingResponse internalGetResult() {
        return result;
      }
      
      public Builder clear() {
        if (result == null) {
          throw new IllegalStateException(
            "Cannot call clear() after build().");
        }
        result = new com.randioo.randioo_chat_server.protocol.Ping.PingResponse();
        return this;
      }
      
      public Builder clone() {
        return create().mergeFrom(result);
      }
      
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.randioo.randioo_chat_server.protocol.Ping.PingResponse.getDescriptor();
      }
      
      public com.randioo.randioo_chat_server.protocol.Ping.PingResponse getDefaultInstanceForType() {
        return com.randioo.randioo_chat_server.protocol.Ping.PingResponse.getDefaultInstance();
      }
      
      public boolean isInitialized() {
        return result.isInitialized();
      }
      public com.randioo.randioo_chat_server.protocol.Ping.PingResponse build() {
        if (result != null && !isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return buildPartial();
      }
      
      private com.randioo.randioo_chat_server.protocol.Ping.PingResponse buildParsed()
          throws com.google.protobuf.InvalidProtocolBufferException {
        if (!isInitialized()) {
          throw newUninitializedMessageException(
            result).asInvalidProtocolBufferException();
        }
        return buildPartial();
      }
      
      public com.randioo.randioo_chat_server.protocol.Ping.PingResponse buildPartial() {
        if (result == null) {
          throw new IllegalStateException(
            "build() has already been called on this Builder.");
        }
        com.randioo.randioo_chat_server.protocol.Ping.PingResponse returnMe = result;
        result = null;
        return returnMe;
      }
      
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.randioo.randioo_chat_server.protocol.Ping.PingResponse) {
          return mergeFrom((com.randioo.randioo_chat_server.protocol.Ping.PingResponse)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }
      
      public Builder mergeFrom(com.randioo.randioo_chat_server.protocol.Ping.PingResponse other) {
        if (other == com.randioo.randioo_chat_server.protocol.Ping.PingResponse.getDefaultInstance()) return this;
        if (other.hasClientTimestamp()) {
          setClientTimestamp(other.getClientTimestamp());
        }
        if (other.hasServerTimestamp()) {
          setServerTimestamp(other.getServerTimestamp());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }
      
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder(
            this.getUnknownFields());
        while (true) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              this.setUnknownFields(unknownFields.build());
              return this;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                this.setUnknownFields(unknownFields.build());
                return this;
              }
              break;
            }
            case 8: {
              setClientTimestamp(input.readInt64());
              break;
            }
            case 16: {
              setServerTimestamp(input.readInt64());
              break;
            }
          }
        }
      }
      
      
      // optional int64 clientTimestamp = 1;
      public boolean hasClientTimestamp() {
        return result.hasClientTimestamp();
      }
      public long getClientTimestamp() {
        return result.getClientTimestamp();
      }
      public Builder setClientTimestamp(long value) {
        result.hasClientTimestamp = true;
        result.clientTimestamp_ = value;
        return this;
      }
      public Builder clearClientTimestamp() {
        result.hasClientTimestamp = false;
        result.clientTimestamp_ = 0L;
        return this;
      }
      
      // optional int64 serverTimestamp = 2;
      public boolean hasServerTimestamp() {
        return result.hasServerTimestamp();
      }
      public long getServerTimestamp() {
        return result.getServerTimestamp();
      }
      public Builder setServerTimestamp(long value) {
        result.hasServerTimestamp = true;
        result.serverTimestamp_ = value;
        return this;
      }
      public Builder clearServerTimestamp() {
        result.hasServerTimestamp = false;
        result.serverTimestamp_ = 0L;
        return this;
      }
      
      // @@protoc_insertion_point(builder_scope:com.randioo.randioo_chat_server.protocol.PingResponse)
    }
    
    static {
      defaultInstance = new PingResponse(true);
      com.randioo.randioo_chat_server.protocol.Ping.internalForceInit();
      defaultInstance.initFields();
    }
    
    // @@protoc_insertion_point(class_scope:com.randioo.randioo_chat_server.protocol.PingResponse)
  }
  
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_randioo_randioo_chat_server_protocol_PingRequest_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_randioo_randioo_chat_server_protocol_PingRequest_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_com_randioo_randioo_chat_server_protocol_PingResponse_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_randioo_randioo_chat_server_protocol_PingResponse_fieldAccessorTable;
  
  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nPing.proto\022(com.randioo.randioo_chat_s" +
      "erver.protocol\"&\n\013PingRequest\022\027\n\017clientT" +
      "imestamp\030\001 \001(\003\"@\n\014PingResponse\022\027\n\017client" +
      "Timestamp\030\001 \001(\003\022\027\n\017serverTimestamp\030\002 \001(\003"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_com_randioo_randioo_chat_server_protocol_PingRequest_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_com_randioo_randioo_chat_server_protocol_PingRequest_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_randioo_randioo_chat_server_protocol_PingRequest_descriptor,
              new java.lang.String[] { "ClientTimestamp", },
              com.randioo.randioo_chat_server.protocol.Ping.PingRequest.class,
              com.randioo.randioo_chat_server.protocol.Ping.PingRequest.Builder.class);
          internal_static_com_randioo_randioo_chat_server_protocol_PingResponse_descriptor =
            getDescriptor().getMessageTypes().get(1);
          internal_static_com_randioo_randioo_chat_server_protocol_PingResponse_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_com_randioo_randioo_chat_server_protocol_PingResponse_descriptor,
              new java.lang.String[] { "ClientTimestamp", "ServerTimestamp", },
              com.randioo.randioo_chat_server.protocol.Ping.PingResponse.class,
              com.randioo.randioo_chat_server.protocol.Ping.PingResponse.Builder.class);
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }
  
  public static void internalForceInit() {}
  
  // @@protoc_insertion_point(outer_class_scope)
}
