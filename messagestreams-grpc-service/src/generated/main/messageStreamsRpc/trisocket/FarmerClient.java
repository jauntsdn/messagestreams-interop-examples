// Generated by jauntsdn.com rpc compiler (version 1.4.0)
// source: service.proto

package trisocket;

@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Farmer.class)
@SuppressWarnings("all")
public final class FarmerClient implements Farmer {
  private final com.jauntsdn.rsocket.MessageStreams streams;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final com.jauntsdn.rsocket.RpcInstrumentation.Factory<trisocket.Meat> meatInstrumentation;
  private final com.jauntsdn.rsocket.RpcInstrumentation.Factory<trisocket.Veggie> veggiesInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private FarmerClient(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    this.streams = streams;
    this.allocator = streams.allocator().orElse(io.netty.buffer.ByteBufAllocator.DEFAULT);
    com.jauntsdn.rsocket.RpcInstrumentation i = instrumentation == null
      ? streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_INSTRUMENTATION)
      : instrumentation.orElse(null);
    if (i == null) {
      this.meatInstrumentation = null;
      this.veggiesInstrumentation = null;
    } else {
      this.meatInstrumentation = i.instrument("client", Farmer.SERVICE, Farmer.METHOD_MEAT, true);
      this.veggiesInstrumentation = i.instrument("client", Farmer.SERVICE, Farmer.METHOD_VEGGIES, true);
    }
    com.jauntsdn.rsocket.Rpc.Codec codec = streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_CODEC);
    if (codec != null) {
      rpcCodec = codec;
      if (codec.isDisposable()) {
        streams.onClose().thenAccept(ignored -> codec.dispose());
      }
      return;
    }
    throw new IllegalArgumentException("MessageStreams " + streams.getClass() + " does not provide RPC codec");
  }

  public static FarmerClient create(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    java.util.Objects.requireNonNull(streams, "streams");
    java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    return new FarmerClient(streams, instrumentation);
  }

  public static FarmerClient create(com.jauntsdn.rsocket.MessageStreams streams) {
    java.util.Objects.requireNonNull(streams, "streams");
    return new FarmerClient(streams, null);
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Meat.class)
  public void meat(trisocket.Order message, io.netty.buffer.ByteBuf metadata, io.grpc.stub.StreamObserver<trisocket.Meat> observer) {
    int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
    int dataSize = message.getSerializedSize();
    int localHeader = com.jauntsdn.rsocket.MessageMetadata.header(metadata);
    boolean isDefaultService = com.jauntsdn.rsocket.MessageMetadata.defaultService(localHeader);
    String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Farmer.SERVICE;
    com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
    io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, localHeader, service, Farmer.METHOD_MEAT, true, Farmer.METHOD_MEAT_IDEMPOTENT, dataSize, externalMetadataSize);
    encode(content, message);
    com.jauntsdn.rsocket.Message msg = codec.encodeMessage(content, Farmer.METHOD_MEAT_RANK);
    com.jauntsdn.rsocket.RpcInstrumentation.Listener<trisocket.Meat> instrumentationListener = null;
    if (meatInstrumentation != null) {
      instrumentationListener = meatInstrumentation.create();
    }
    streams.requestStream(msg, com.jauntsdn.rsocket.RpcMessageCodec.Stream.Client.decode(observer, decode(trisocket.Meat.parser()), instrumentationListener));
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Veggie.class)
  public void veggies(trisocket.Order message, io.netty.buffer.ByteBuf metadata, io.grpc.stub.StreamObserver<trisocket.Veggie> observer) {
    int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
    int dataSize = message.getSerializedSize();
    int localHeader = com.jauntsdn.rsocket.MessageMetadata.header(metadata);
    boolean isDefaultService = com.jauntsdn.rsocket.MessageMetadata.defaultService(localHeader);
    String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Farmer.SERVICE;
    com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
    io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, localHeader, service, Farmer.METHOD_VEGGIES, true, Farmer.METHOD_VEGGIES_IDEMPOTENT, dataSize, externalMetadataSize);
    encode(content, message);
    com.jauntsdn.rsocket.Message msg = codec.encodeMessage(content, Farmer.METHOD_VEGGIES_RANK);
    com.jauntsdn.rsocket.RpcInstrumentation.Listener<trisocket.Veggie> instrumentationListener = null;
    if (veggiesInstrumentation != null) {
      instrumentationListener = veggiesInstrumentation.create();
    }
    streams.requestStream(msg, com.jauntsdn.rsocket.RpcMessageCodec.Stream.Client.decode(observer, decode(trisocket.Veggie.parser()), instrumentationListener));
  }

  private io.netty.buffer.ByteBuf encode(io.netty.buffer.ByteBuf content, final com.google.protobuf.MessageLite message) {
    int length = message.getSerializedSize();
    try {
      int writerIndex = content.writerIndex();
      message.writeTo(com.google.protobuf.CodedOutputStream.newInstance(content.internalNioBuffer(writerIndex, length)));
      content.writerIndex(writerIndex + length);
      return content;
    } catch (Throwable t) {
      content.release();
      com.jauntsdn.rsocket.exceptions.Exceptions.throwIfJvmFatal(t);
      throw new com.jauntsdn.rsocket.exceptions.SerializationException("FarmerClient: message serialization error", t);
    }
  }

  private static <T> java.util.function.Function<com.jauntsdn.rsocket.Message, T> decode(final com.google.protobuf.Parser<T> parser) {
    return new java.util.function.Function<com.jauntsdn.rsocket.Message, T>() {
      @Override
      public T apply(com.jauntsdn.rsocket.Message message) {
        try {
          io.netty.buffer.ByteBuf messageData = message.data();
          com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(messageData.internalNioBuffer(0, messageData.readableBytes()));
          return parser.parseFrom(is);
        } catch (Throwable t) {
          com.jauntsdn.rsocket.exceptions.Exceptions.throwIfJvmFatal(t);
          throw new com.jauntsdn.rsocket.exceptions.SerializationException("FarmerClient: message deserialization error", t);
        } finally {
          message.release();
        }
      }
    };
  }
}
