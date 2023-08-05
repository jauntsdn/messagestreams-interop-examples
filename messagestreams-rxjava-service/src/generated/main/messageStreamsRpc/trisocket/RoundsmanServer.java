// Generated by jauntsdn.com rpc compiler (version 1.5.0)
// source: service.proto

package trisocket;

@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Roundsman.class)
@SuppressWarnings("all")
public final class RoundsmanServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture<Void> onClose = new java.util.concurrent.CompletableFuture<>();
  private final Roundsman service;
  private final io.reactivex.rxjava3.functions.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> messageEncoder;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;
  private final io.reactivex.rxjava3.core.SingleTransformer<com.jauntsdn.rsocket.Message, com.jauntsdn.rsocket.Message> chopInstrumentation;
  private final io.reactivex.rxjava3.core.SingleTransformer<com.jauntsdn.rsocket.Message, com.jauntsdn.rsocket.Message> marinadeInstrumentation;

  private RoundsmanServer(Roundsman service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.messageEncoder = com.jauntsdn.rsocket.generated_72325.ProtobufCodec.encode("RoundsmanServer", allocator, rpcCodec);
    this.service = service;
    this.rpcCodec = rpcCodec;
    if (instrumentation == null) {
      this.chopInstrumentation = null;
      this.marinadeInstrumentation = null;
    } else {
      this.chopInstrumentation = instrumentation.instrumentSingle("service", Roundsman.SERVICE, Roundsman.METHOD_CHOP);
      this.marinadeInstrumentation = instrumentation.instrumentSingle("service", Roundsman.SERVICE, Roundsman.METHOD_MARINADE);
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
  public io.reactivex.rxjava3.core.Completable fireAndForget(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.reactivex.rxjava3.core.Completable.error(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: fireAndForget not implemented"));
  }

  @Override
  public io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> requestResponse(com.jauntsdn.rsocket.Message message) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> handler = requestResponseHandler(flags, method, message.data(), metadata);
      if (handler != null) {
        return handler;
      }
      return io.reactivex.rxjava3.core.Single.error(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: requestResponse not implemented"));
    } catch (Throwable t) {
      return io.reactivex.rxjava3.core.Single.error(t);
    } finally {
      message.release();
    }
  }

  @Override
  public io.reactivex.rxjava3.core.Flowable<com.jauntsdn.rsocket.Message> requestStream(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.reactivex.rxjava3.core.Flowable.error(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: requestStream not implemented"));
  }

  @Override
  public io.reactivex.rxjava3.core.Flowable<com.jauntsdn.rsocket.Message> requestChannel(com.jauntsdn.rsocket.Message message, org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> publisher) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      if (com.jauntsdn.rsocket.Rpc.RpcMetadata.flagForeignCall(flags)) {
        io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> responseHandler = requestResponseHandler(flags, method, message.data(), metadata);
        if (responseHandler != null) {
          message.release();
          return responseHandler.toFlowable();
        }
      }
      message.release();
      return io.reactivex.rxjava3.core.Flowable.error(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: requestChannel unknown method: " + method));
    } catch (Throwable t) {
      io.netty.util.ReferenceCountUtil.safeRelease(message);
      return io.reactivex.rxjava3.core.Flowable.error(t);
    }
  }

  @Override
  public io.reactivex.rxjava3.core.Flowable<com.jauntsdn.rsocket.Message> requestChannel(org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> messages) {
    return io.reactivex.rxjava3.core.Flowable.error(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: requestChannel not implemented"));
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
  public io.reactivex.rxjava3.core.Completable onClose() {
    return io.reactivex.rxjava3.core.Completable.fromCompletionStage(onClose);
  }

  private io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> requestResponseHandler(int flags, String method, io.netty.buffer.ByteBuf data, io.netty.buffer.ByteBuf metadata) throws java.io.IOException {
    switch (method) {
      case Roundsman.METHOD_CHOP: {
        if (!Roundsman.METHOD_CHOP_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          return io.reactivex.rxjava3.core.Single.error(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: idempotent call to non-idempotent method: " + method));
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.Headers chopHeaders = com.jauntsdn.rsocket.generated_72325.ProtobufCodec.decodeHeaders(metadata);
        io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> chop = service.chop(trisocket.Veggie.parseFrom(is), chopHeaders).map(messageEncoder);
        if (chopInstrumentation != null) {
          return chop.compose(chopInstrumentation);
        }
        return chop;
      }
      case Roundsman.METHOD_MARINADE: {
        if (!Roundsman.METHOD_MARINADE_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
          return io.reactivex.rxjava3.core.Single.error(new com.jauntsdn.rsocket.exceptions.RpcException("RoundsmanServer: idempotent call to non-idempotent method: " + method));
        }
        com.google.protobuf.CodedInputStream is = com.google.protobuf.CodedInputStream.newInstance(data.internalNioBuffer(0, data.readableBytes()));
        com.jauntsdn.rsocket.Headers marinadeHeaders = com.jauntsdn.rsocket.generated_72325.ProtobufCodec.decodeHeaders(metadata);
        io.reactivex.rxjava3.core.Single<com.jauntsdn.rsocket.Message> marinade = service.marinade(trisocket.Meat.parseFrom(is), marinadeHeaders).map(messageEncoder);
        if (marinadeInstrumentation != null) {
          return marinade.compose(marinadeInstrumentation);
        }
        return marinade;
      }
      default: {
        return null;
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
