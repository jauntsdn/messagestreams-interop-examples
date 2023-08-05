package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.0)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Kitchen.class)
@SuppressWarnings("all")
public final class KitchenClient implements Kitchen {
  private final com.jauntsdn.rsocket.MessageStreams streams;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<trisocket.Dish>, ? extends org.reactivestreams.Publisher<trisocket.Dish>> serveInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private KitchenClient(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    this.streams = streams;
    this.allocator = streams.allocator().orElse(io.netty.buffer.ByteBufAllocator.DEFAULT);
    com.jauntsdn.rsocket.RpcInstrumentation i = instrumentation == null
      ? streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_INSTRUMENTATION)
      : instrumentation.orElse(null);
    if (i == null) {
      this.serveInstrumentation = null;
    } else {
      this.serveInstrumentation = i.instrument("client", Kitchen.SERVICE, Kitchen.METHOD_SERVE, true);
    }
    com.jauntsdn.rsocket.Rpc.Codec codec = streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_CODEC);
    if (codec != null) {
      rpcCodec = codec;
      if (codec.isDisposable()) {
        streams.onClose().subscribe(ignored -> {}, err -> {}, () -> codec.dispose());
      }
      return;
    }
    throw new IllegalArgumentException("MessageStreams " + streams.getClass() + " does not provide RPC codec");
  }

  public static KitchenClient create(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    java.util.Objects.requireNonNull(streams, "streams");
    java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    return new KitchenClient(streams, instrumentation);
  }

  public static KitchenClient create(com.jauntsdn.rsocket.MessageStreams streams) {
    java.util.Objects.requireNonNull(streams, "streams");
    return new KitchenClient(streams, null);
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Dish.class)
  public reactor.core.publisher.Flux<trisocket.Dish> serve(org.reactivestreams.Publisher<trisocket.Order> messages, com.jauntsdn.rsocket.Headers headersMetadata) {
    reactor.core.publisher.Flux<trisocket.Dish> serve = 
      reactor.core.publisher.Flux.defer(new java.util.function.Supplier<org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message>>() {

        @Override
        public org.reactivestreams.Publisher<com.jauntsdn.rsocket.Message> get() {
          return streams.requestChannel(reactor.core.publisher.Flux.from(messages).map(
            new java.util.function.Function<com.google.protobuf.MessageLite, com.jauntsdn.rsocket.Message>() {
              private boolean started;

              @Override
              public com.jauntsdn.rsocket.Message apply(com.google.protobuf.MessageLite message) {
                int dataSize = message.getSerializedSize();
                com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
                if (!started) {
                  started = true;
                  int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
                  boolean isDefaultService = headersMetadata.isDefaultService();
                  String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Kitchen.SERVICE;
                  io.netty.buffer.ByteBuf metadata = com.jauntsdn.rsocket.generated_56739.ProtobufCodec.encodeHeaders(headersMetadata);
                  io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, service, Kitchen.METHOD_SERVE, true, Kitchen.METHOD_SERVE_IDEMPOTENT, dataSize, externalMetadataSize);
                  com.jauntsdn.rsocket.generated_56739.ProtobufCodec.encode("KitchenClient", content, message);
                  return codec.encodeMessage(content, Kitchen.METHOD_SERVE_RANK);
                } else {
                  io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, dataSize);
                  com.jauntsdn.rsocket.generated_56739.ProtobufCodec.encode("KitchenClient", content, message);
                  return codec.encodeMessage(content);
                }
              }
             }));
           }
          }).map(com.jauntsdn.rsocket.generated_56739.ProtobufCodec.decode("KitchenClient", trisocket.Dish.parser()));
          if (serveInstrumentation != null) {
            return serve.transform(serveInstrumentation);
          }
          return serve;
      }
    }
