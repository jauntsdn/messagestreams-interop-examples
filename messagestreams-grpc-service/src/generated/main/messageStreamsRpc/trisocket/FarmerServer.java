// Generated by jauntsdn.com rpc compiler (version 1.5.1)
// source: service.proto

package trisocket;

@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Farmer.class)
@SuppressWarnings("all")
public final class FarmerServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture<Void> onClose = new java.util.concurrent.CompletableFuture<>();
  private final Farmer service;
  private final java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> messageEncoder;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;
  private final com.jauntsdn.rsocket.RpcInstrumentation.Factory<com.jauntsdn.rsocket.Message> meatInstrumentation;
  private final com.jauntsdn.rsocket.RpcInstrumentation.Factory<com.jauntsdn.rsocket.Message> veggiesInstrumentation;

  private FarmerServer(Farmer service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.messageEncoder = com.jauntsdn.rsocket.generated.ProtobufCodec.encode("FarmerServer", allocator, rpcCodec);
    this.service = service;
    this.rpcCodec = rpcCodec;
    if (instrumentation == null) {
      this.meatInstrumentation = null;
      this.veggiesInstrumentation = null;
    } else {
      this.meatInstrumentation = instrumentation.instrument("service", Farmer.SERVICE, Farmer.METHOD_MEAT, true);
      this.veggiesInstrumentation = instrumentation.instrument("service", Farmer.SERVICE, Farmer.METHOD_VEGGIES, true);
    }
  }

  public static FarmerServer.Factory create(Farmer service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    return new FarmerServer.Factory(service, instrumentation);
  }

  public static FarmerServer.Factory create(Farmer service) {
    return new FarmerServer.Factory(service);
  }

  @Override
  public String service() {
    return Farmer.SERVICE;
  }

  @Override
  public Class<?> serviceType() {
    return Farmer.SERVICE_TYPE;
  }

  @Override
  public void fireAndForget(com.jauntsdn.rsocket.Message message, io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> observer) {
    message.release();
    observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: fireAndForget not implemented"));
  }

  @Override
  public void requestResponse(com.jauntsdn.rsocket.Message message, io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> observer) {
    message.release();
    observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestResponse not implemented"));
  }

  @Override
  public void requestStream(com.jauntsdn.rsocket.Message message, io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> observer) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      if (requestStreamHandler(flags, method, message.data(), metadata, observer)) {
        return;
      }
      observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestStream unknown method: " + method));
    } catch (Throwable t) {
      observer.onError(t);
    } finally {
      message.release();
    }
  }

  @Override
  public io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> requestChannel(io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> observer) {
    observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: unsupported method: requestChannel(Observer<Message>)"));
    return com.jauntsdn.rsocket.MessageStreamsHandler.noopServerObserver();
  }

  @Override
  public io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> requestChannel(com.jauntsdn.rsocket.Message message, io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> observer) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      if (com.jauntsdn.rsocket.Rpc.RpcMetadata.flagForeignCall(flags)) {
        if (requestStreamHandler(flags, method, message.data(), metadata, observer)) {
          return com.jauntsdn.rsocket.MessageStreamsHandler.noopServerObserver();
        }
      }
      observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: requestChannel unknown method: " + method));
      return com.jauntsdn.rsocket.MessageStreamsHandler.noopServerObserver();
    } catch (Throwable t) {
      observer.onError(t);
      return com.jauntsdn.rsocket.MessageStreamsHandler.noopServerObserver();
    } finally {
      message.release();
    }
  }

  @Override
  public void dispose() {
    onClose.complete(null);
  }

  @Override
  public boolean isDisposed() {
    return onClose.isDone();
  }

  @Override
  public java.util.concurrent.CompletionStage<Void> onClose() {
    return onClose;
  }

  private boolean requestStreamHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata, io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> observer) throws java.io.IOException {
    switch (method) {
      case Farmer.METHOD_MEAT: {
        if (!Farmer.METHOD_MEAT_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: idempotent call to non-idempotent method: " + method));
          return true;
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.RpcInstrumentation.Listener<com.jauntsdn.rsocket.Message> instrumentationListener = null;
        if (meatInstrumentation != null) {
          instrumentationListener = meatInstrumentation.create();
        }
        com.jauntsdn.rsocket.Headers meatHeaders = com.jauntsdn.rsocket.generated.ProtobufCodec.decodeHeaders(metadata);
        service.meat(trisocket.Order.parseFrom(is), meatHeaders, com.jauntsdn.rsocket.RpcMessageCodec.Stream.Server.encode(observer, messageEncoder, instrumentationListener));
        return true;
      }
      case Farmer.METHOD_VEGGIES: {
        if (!Farmer.METHOD_VEGGIES_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("FarmerServer: idempotent call to non-idempotent method: " + method));
          return true;
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.RpcInstrumentation.Listener<com.jauntsdn.rsocket.Message> instrumentationListener = null;
        if (veggiesInstrumentation != null) {
          instrumentationListener = veggiesInstrumentation.create();
        }
        com.jauntsdn.rsocket.Headers veggiesHeaders = com.jauntsdn.rsocket.generated.ProtobufCodec.decodeHeaders(metadata);
        service.veggies(trisocket.Order.parseFrom(is), veggiesHeaders, com.jauntsdn.rsocket.RpcMessageCodec.Stream.Server.encode(observer, messageEncoder, instrumentationListener));
        return true;
      }
      default: {
        return false;
      }
    }
  }

  public static final class Factory extends com.jauntsdn.rsocket.RpcService.ServerFactory<FarmerServer> {

    public Factory(Farmer service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
      super(service, instrumentation);
    }

    public Factory(Farmer service) {
      super(service);
    }

    @Override
    public FarmerServer create(com.jauntsdn.rsocket.RpcInstrumentation rpcInstrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
      return new FarmerServer(service(), rpcInstrumentation, allocator, rpcCodec);
    }
  }
}
