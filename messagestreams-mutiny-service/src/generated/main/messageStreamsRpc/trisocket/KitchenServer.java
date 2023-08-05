// Generated by jauntsdn.com rpc compiler (version 1.5.0)
// source: service.proto

package trisocket;

@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.SERVICE,
    service = Kitchen.class)
@SuppressWarnings("all")
public final class KitchenServer implements com.jauntsdn.rsocket.RpcService {
  private final java.util.concurrent.CompletableFuture<Void> onClose = new java.util.concurrent.CompletableFuture<>();
  private final Kitchen service;
  private final java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message> messageEncoder;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;
  private final java.util.function.Function<io.smallrye.mutiny.Multi<com.jauntsdn.rsocket.Message>, io.smallrye.mutiny.Multi<com.jauntsdn.rsocket.Message>> serveInstrumentation;

  private KitchenServer(Kitchen service, com.jauntsdn.rsocket.RpcInstrumentation instrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
    this.messageEncoder = com.jauntsdn.rsocket.generated_52358.ProtobufCodec.encode("KitchenServer", allocator, rpcCodec);
    this.service = service;
    this.rpcCodec = rpcCodec;
    if (instrumentation == null) {
      this.serveInstrumentation = null;
    } else {
      this.serveInstrumentation = instrumentation.instrumentMulti("service", Kitchen.SERVICE, Kitchen.METHOD_SERVE, true);
    }
  }

  public static KitchenServer.Factory create(Kitchen service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    return new KitchenServer.Factory(service, instrumentation);
  }

  public static KitchenServer.Factory create(Kitchen service) {
    return new KitchenServer.Factory(service);
  }

  @Override
  public String service() {
    return Kitchen.SERVICE;
  }

  @Override
  public Class<?> serviceType() {
    return Kitchen.SERVICE_TYPE;
  }

  @Override
  public io.smallrye.mutiny.Uni<Void> fireAndForget(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.smallrye.mutiny.Uni.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: fireAndForget not implemented"));
  }

  @Override
  public io.smallrye.mutiny.Uni<com.jauntsdn.rsocket.Message> requestResponse(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.smallrye.mutiny.Uni.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: requestResponse not implemented"));
  }

  @Override
  public io.smallrye.mutiny.Multi<com.jauntsdn.rsocket.Message> requestStream(com.jauntsdn.rsocket.Message message) {
    message.release();
    return io.smallrye.mutiny.Multi.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: requestStream not implemented"));
  }

  @Override
  public io.smallrye.mutiny.Multi<com.jauntsdn.rsocket.Message> requestChannel(com.jauntsdn.rsocket.Message message, java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message> publisher) {
    try {
      io.netty.buffer.ByteBuf metadata = message.metadata();
      long header = com.jauntsdn.rsocket.Rpc.RpcMetadata.header(metadata);
      int flags = com.jauntsdn.rsocket.Rpc.RpcMetadata.flags(header);
      String method = rpcCodec.decodeMessageMethod(metadata, header, flags);

      switch (method) {
        case Kitchen.METHOD_SERVE: {
          if (!Kitchen.METHOD_SERVE_IDEMPOTENT && com.jauntsdn.rsocket.Rpc.RpcMetadata.flagIdempotentCall(flags)) {
            message.release();
            return io.smallrye.mutiny.Multi.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: idempotent call to non-idempotent method: " + method));
          }
          io.smallrye.mutiny.Multi<trisocket.Order> messages =
            io.smallrye.mutiny.Multi.createFrom().publisher(publisher).map(com.jauntsdn.rsocket.generated_52358.ProtobufCodec.decode("KitchenServer", trisocket.Order.parser()));
          com.jauntsdn.rsocket.Headers serveHeaders = com.jauntsdn.rsocket.generated_52358.ProtobufCodec.decodeHeaders(metadata);
          io.smallrye.mutiny.Multi<com.jauntsdn.rsocket.Message> serve = service.serve(messages, serveHeaders).map(messageEncoder);
          if (serveInstrumentation != null) {
            return serve.plug(serveInstrumentation);
          }
          return serve;
        }
      }
      message.release();
      return io.smallrye.mutiny.Multi.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: requestChannel unknown method: " + method));
    } catch (Throwable t) {
      io.netty.util.ReferenceCountUtil.safeRelease(message);
      return io.smallrye.mutiny.Multi.createFrom().failure(t);
    }
  }

  @Override
  public io.smallrye.mutiny.Multi<com.jauntsdn.rsocket.Message> requestChannel(java.util.concurrent.Flow.Publisher<com.jauntsdn.rsocket.Message> messages) {
    return io.smallrye.mutiny.Multi.createFrom().failure(new com.jauntsdn.rsocket.exceptions.RpcException("KitchenServer: unsupported method: requestChannel(Publisher<Message>)"));
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
  public io.smallrye.mutiny.Uni<Void> onClose() {
    return io.smallrye.mutiny.Uni.createFrom().completionStage(onClose);
  }

  public static final class Factory extends com.jauntsdn.rsocket.RpcService.ServerFactory<KitchenServer> {

    public Factory(Kitchen service, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
      super(service, instrumentation);
    }

    public Factory(Kitchen service) {
      super(service);
    }

    @Override
    public KitchenServer create(com.jauntsdn.rsocket.RpcInstrumentation rpcInstrumentation, io.netty.buffer.ByteBufAllocator allocator, com.jauntsdn.rsocket.Rpc.Codec rpcCodec) {
      return new KitchenServer(service(), rpcInstrumentation, allocator, rpcCodec);
    }
  }
}
