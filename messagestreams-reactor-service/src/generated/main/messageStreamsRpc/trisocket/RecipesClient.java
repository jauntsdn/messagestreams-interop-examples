package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.5.1)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Recipes.class)
@SuppressWarnings("all")
public final class RecipesClient implements Recipes {
  private final com.jauntsdn.rsocket.MessageStreams streams;
  private final io.netty.buffer.ByteBufAllocator allocator;
  private final java.util.function.Function<? super org.reactivestreams.Publisher<trisocket.Recipe>, ? extends org.reactivestreams.Publisher<trisocket.Recipe>> marinadeInstrumentation;
  private final com.jauntsdn.rsocket.Rpc.Codec rpcCodec;

  private RecipesClient(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    this.streams = streams;
    this.allocator = streams.allocator().orElse(io.netty.buffer.ByteBufAllocator.DEFAULT);
    com.jauntsdn.rsocket.RpcInstrumentation i = instrumentation == null
      ? streams.attributes().attr(com.jauntsdn.rsocket.Attributes.RPC_INSTRUMENTATION)
      : instrumentation.orElse(null);
    if (i == null) {
      this.marinadeInstrumentation = null;
    } else {
      this.marinadeInstrumentation = i.instrument("client", Recipes.SERVICE, Recipes.METHOD_MARINADE, false);
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

  public static RecipesClient create(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
    java.util.Objects.requireNonNull(streams, "streams");
    java.util.Objects.requireNonNull(instrumentation, "instrumentation");
    return new RecipesClient(streams, instrumentation);
  }

  public static RecipesClient create(com.jauntsdn.rsocket.MessageStreams streams) {
    java.util.Objects.requireNonNull(streams, "streams");
    return new RecipesClient(streams, null);
  }

  @Override
  @com.jauntsdn.rsocket.Rpc.GeneratedMethod(returnType = trisocket.Recipe.class)
  public reactor.core.publisher.Mono<trisocket.Recipe> marinade(trisocket.Meat message, com.jauntsdn.rsocket.Headers headersMetadata) {
    reactor.core.publisher.Mono<trisocket.Recipe> marinade = reactor.core.publisher.Mono.defer(new java.util.function.Supplier<reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message>>() {
      @Override
      public reactor.core.publisher.Mono<com.jauntsdn.rsocket.Message> get() {
        int externalMetadataSize = streams.attributes().intAttr(com.jauntsdn.rsocket.Attributes.EXTERNAL_METADATA_SIZE);
        int dataSize = message.getSerializedSize();
        boolean isDefaultService = headersMetadata.isDefaultService();
        String service = isDefaultService ? com.jauntsdn.rsocket.Rpc.RpcMetadata.defaultService() : Recipes.SERVICE;
        io.netty.buffer.ByteBuf metadata = com.jauntsdn.rsocket.generated.ProtobufCodec.encodeHeaders(headersMetadata);
        com.jauntsdn.rsocket.Rpc.Codec codec = rpcCodec;
        io.netty.buffer.ByteBuf content = codec.encodeContent(allocator, metadata, service, Recipes.METHOD_MARINADE, false, Recipes.METHOD_MARINADE_IDEMPOTENT, dataSize, externalMetadataSize);
        com.jauntsdn.rsocket.generated.ProtobufCodec.encode("RecipesClient", content, message);
        com.jauntsdn.rsocket.Message message = codec.encodeMessage(content, Recipes.METHOD_MARINADE_RANK);
        return streams.requestResponse(message);
      }
    }).map(com.jauntsdn.rsocket.generated.ProtobufCodec.decode("RecipesClient", trisocket.Recipe.parser()));
    if (marinadeInstrumentation != null) {
      return marinade.transform(marinadeInstrumentation);
    }
    return marinade;
  }
}
