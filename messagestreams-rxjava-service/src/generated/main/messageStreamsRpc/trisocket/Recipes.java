// Generated by jauntsdn.com rpc compiler (version 1.5.1)
// source: service.proto

package trisocket;

public interface Recipes {
  String SERVICE = "trisocket.Recipes";
  Class<?> SERVICE_TYPE = trisocket.Recipes.class;

  String METHOD_MARINADE = "marinade";
  boolean METHOD_MARINADE_IDEMPOTENT = false;
  int METHOD_MARINADE_RANK = 0;

  io.reactivex.rxjava3.core.Single<trisocket.Recipe> marinade(trisocket.Meat message, com.jauntsdn.rsocket.Headers metadata);

  default io.reactivex.rxjava3.core.Single<trisocket.Recipe> marinade(trisocket.Meat message) {
    return marinade(message, com.jauntsdn.rsocket.Headers.empty());
  }
}
