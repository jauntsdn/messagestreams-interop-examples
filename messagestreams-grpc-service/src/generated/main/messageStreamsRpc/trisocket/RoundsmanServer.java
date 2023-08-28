// Generated by jauntsdn.com rpc compiler (version 1.5.1)
// source: service.proto

package trisocket;

@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Roundsman.class)
@SuppressWarnings("all")
public final class RoundsmanServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture<Void> onClose = new java.util.concurrent.CompletableFuture<>();
  private final Roundsman service;
  private final java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> messageEncoder;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;
  private final com.jauntsdn.rsocket.RpcInstrumentation.Factory<com.jauntsdn.rsocket.Message> chopInstrumentation;
  private final com.jauntsdn.rsocket.RpcInstrumentation.Factory<com.jauntsdn.rsocket.Message> marinadeInstrumentation;

  private RoundsmanServer(Roundsman service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.messageEncoder = com.jauntsdn.rsocket.generated.ProtobufCodec.encode("RoundsmanServer", allocator, rpcCodec);
    this.service = service;
    this.rpcCodec = rpcCodec;
    if (instrumentation == null) {
      this.chopInstrumentation = null;
      this.marinadeInstrumentation = null;
    } else {
      this.chopInstrumentation = instrumentation.instrument("service", Roundsman.SERVICE, Roundsman.METHOD_CHOP, false);
      this.marinadeInstrumentation = instrumentation.instrument("service", Roundsman.SERVICE, Roundsman.METHOD_MARINADE, false);
    }
  }

  public static RoundsmanServer.Factory create(Roundsman service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    return new RoundsmanServer.Factory(service, instrumentation);
  }

  public static RoundsmanServer.Factory create(Roundsman service) {
    return new RoundsmanServer.Factory(service);
  }

  @Override
  public String service() {
    return Roundsman.SERVICE;
  }

  @Override
  public Class<?> serviceType() {
    return Roundsman.SERVICE_TYPE;
  }

  @Override
  public void fireAndForget(com.jauntsdn.rsocket.Message message, io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> observer) {
    message.release();
    observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: fireAndForget not implemented"));
  }

  @Override
  public void requestResponse(com.jauntsdn.rsocket.Message message, io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> observer) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      if (requestResponseHandler(flags, method, message.data(), metadata, observer)) {
        return;
      }
      observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: requestResponse not implemented"));
    } catch (Throwable t) {
      observer.onError(t);
    } finally {
      message.release();
    }
  }

  @Override
  public void requestStream(com.jauntsdn.rsocket.Message message, io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> observer) {
    message.release();
    observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: requestStream not implemented"));
  }

  @Override
  public io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> requestChannel(io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> observer) {
    observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: unsupported method: requestChannel(Observer<Message>)"));
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
        if (requestResponseHandler(flags, method, message.data(), metadata, observer)) {
          return com.jauntsdn.rsocket.MessageStreamsHandler.noopServerObserver();
        }
      }
      observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: requestChannel unknown method: " + method));
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

  private boolean requestResponseHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata, io.grpc.stub.StreamObserver<com.jauntsdn.rsocket.Message> observer) throws java.io.IOException {
    switch (method) {
      case Roundsman.METHOD_CHOP: {
        if (!Roundsman.METHOD_CHOP_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: idempotent call to non-idempotent method: " + method));
          return true;
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.RpcInstrumentation.Listener<com.jauntsdn.rsocket.Message> instrumentationListener = null;
        if (chopInstrumentation != null) {
          instrumentationListener = chopInstrumentation.create();
        }
        com.jauntsdn.rsocket.Headers chopHeaders = com.jauntsdn.rsocket.generated.ProtobufCodec.decodeHeaders(metadata);
        service.chop(trisocket.Veggie.parseFrom(is), chopHeaders, com.jauntsdn.rsocket.RpcMessageCodec.Stream.Server.encode(observer, messageEncoder, instrumentationListener));
        return true;
      }
      case Roundsman.METHOD_MARINADE: {
        if (!Roundsman.METHOD_MARINADE_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          observer.onError(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: idempotent call to non-idempotent method: " + method));
          return true;
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.RpcInstrumentation.Listener<com.jauntsdn.rsocket.Message> instrumentationListener = null;
        if (marinadeInstrumentation != null) {
          instrumentationListener = marinadeInstrumentation.create();
        }
        com.jauntsdn.rsocket.Headers marinadeHeaders = com.jauntsdn.rsocket.generated.ProtobufCodec.decodeHeaders(metadata);
        service.marinade(trisocket.Meat.parseFrom(is), marinadeHeaders, com.jauntsdn.rsocket.RpcMessageCodec.Stream.Server.encode(observer, messageEncoder, instrumentationListener));
        return true;
      }
      default: {
        return false;
      }
    }
  }

  public static final class Factory extends com.jauntsdn.rsocket.RpcService.ServerFactory<RoundsmanServer> {

    public Factory(Roundsman service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
      super(service, instrumentation);
    }

    public Factory(Roundsman service) {
      super(service);
    }

    @Override
    public RoundsmanServer create(com.jauntsdn.rsocket.RpcInstrumentation rpcInstrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
      return new RoundsmanServer(service(), rpcInstrumentation, allocator, rpcCodec);
    }
  }
}
