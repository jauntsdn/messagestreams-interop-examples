package trisocket;

@javax.annotation.Generated(
    value = "jauntsdn.com rpc compiler (version 1.1.4)",
    comments = "source: service.proto")
@com.jauntsdn.rsocket.Rpc.Generated(
    role = com.jauntsdn.rsocket.Rpc.Role.CLIENT,
    service = Farmer.class)
@SuppressWarnings("all")
public final class FarmerClient implements Farmer {

  private FarmerClient(com.jauntsdn.rsocket.MessageStreams streams, java.util.Optional<com.jauntsdn.rsocket.RpcInstrumentation> instrumentation) {
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
}