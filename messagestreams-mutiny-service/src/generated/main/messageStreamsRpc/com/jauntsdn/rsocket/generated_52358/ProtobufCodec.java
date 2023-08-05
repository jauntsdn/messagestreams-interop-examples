// Generated by jauntsdn.com rsocket-rpc compiler (version 1.5.0)
// Should be referenced by generated code only

package com.jauntsdn.rsocket.generated_52358;

public final class ProtobufCodec {
  private ProtobufCodec() {
  }

  public static java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> encode(
    String stubName, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec codec) {
      return new java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message>() {
        @Override
        public com.jauntsdn.rsocket.Message apply(com.google.protobuf.MessageLite message) {
          int length = message.getSerializedSize();
          io.netty.buffer.ByteBuf byteBuf = codec.encodeContent(allocator, length);
          try {
            int writerIndex = byteBuf.writerIndex();
            message.writeTo(com.google.protobuf.CodedOutputStream.newInstance(byteBuf.internalNioBuffer(writerIndex, length)));
            byteBuf.writerIndex(writerIndex + length);
            return codec.encodeMessage(byteBuf);
          } catch (Throwable t) {
            byteBuf.release();
            com.jauntsdn.rsocket.exceptions.Exceptions.throwIfJvmFatal(t);
            throw new com.jauntsdn.rsocket.exceptions.SerializationException(stubName + ": message serialization error", t);
          }
        }
      };
  }

  public static io.netty.buffer.ByteBuf encode(String stubName, io.netty.buffer.ByteBuf content, com.google.protobuf.MessageLite message) {
    int length = message.getSerializedSize();
    try {
      int writerIndex = content.writerIndex();
      message.writeTo(com.google.protobuf.CodedOutputStream.newInstance(content.internalNioBuffer(writerIndex, length)));
      content.writerIndex(writerIndex + length);
      return content;
    } catch (Throwable t) {
      content.release();
      com.jauntsdn.rsocket.exceptions.Exceptions.throwIfJvmFatal(t);
      throw new com.jauntsdn.rsocket.exceptions.SerializationException(stubName + ": message serialization error", t);
    }
  }

  public static <T> java.util.function.Function<com.jauntsdn.rsocket.Message, T> decode(String stubName, final com.google.protobuf.Parser<T> parser) {
    return new java.util.function.Function<com.jauntsdn.rsocket.Message, T>() {
      @Override
      public T apply(com.jauntsdn.rsocket.Message message) {
        try {
          io.netty.buffer.ByteBuf messageData = message.data();
          com.google.protobuf.CodedInputStream is =
            com.google.protobuf.CodedInputStream.newInstance(messageData.internalNioBuffer(0, messageData.readableBytes()));
          return parser.parseFrom(is);
        } catch (Throwable t) {
          com.jauntsdn.rsocket.exceptions.Exceptions.throwIfJvmFatal(t);
          throw new com.jauntsdn.rsocket.exceptions.SerializationException(stubName + ": message deserialization error", t);
        } finally {
          message.release();
        }
      }
    };
  }
  public static io.netty.buffer.ByteBuf encodeHeaders(com.jauntsdn.rsocket.Headers headers) {
    if (headers.isEmpty()) {
      return io.netty.buffer.Unpooled.EMPTY_BUFFER;
    }
    io.netty.buffer.ByteBuf cache = com.jauntsdn.rsocket.Rpc.ProtoMetadata.getCache(headers);
    if (cache != null) {
      return cache;
    }
    cache = io.netty.buffer.Unpooled.wrappedBuffer(io.rsocket.rpc.RpcCallMetadata.newBuilder()
      .addAllNameValues(com.jauntsdn.rsocket.Rpc.ProtoMetadata.getHeaders(headers)).build().toByteArray());
      com.jauntsdn.rsocket.Rpc.ProtoMetadata.setCache(headers, cache);
      return cache;
  }

  public static com.jauntsdn.rsocket.Headers decodeHeaders(io.netty.buffer.ByteBuf metadata) throws java.io.IOException {
    if (metadata.readableBytes() == 0) {
      return com.jauntsdn.rsocket.Headers.create();
    }
    io.rsocket.rpc.RpcCallMetadata rpcCallMetadata = io.rsocket.rpc.RpcCallMetadata
      .parseFrom(metadata.internalNioBuffer(metadata.readerIndex(), metadata.readableBytes()));
    return com.jauntsdn.rsocket.Rpc.ProtoMetadata.createHeaders(rpcCallMetadata.getNameValuesList());
  }
}
