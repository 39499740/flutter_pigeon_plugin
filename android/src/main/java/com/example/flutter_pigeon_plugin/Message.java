// Autogenerated from Pigeon (v3.0.3), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package com.example.flutter_pigeon_plugin;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression"})
public class Message {

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class F2NMessage {
    private @Nullable String msg;
    public @Nullable String getMsg() { return msg; }
    public void setMsg(@Nullable String setterArg) {
      this.msg = setterArg;
    }

    public static final class Builder {
      private @Nullable String msg;
      public @NonNull Builder setMsg(@Nullable String setterArg) {
        this.msg = setterArg;
        return this;
      }
      public @NonNull F2NMessage build() {
        F2NMessage pigeonReturn = new F2NMessage();
        pigeonReturn.setMsg(msg);
        return pigeonReturn;
      }
    }
    @NonNull Map<String, Object> toMap() {
      Map<String, Object> toMapResult = new HashMap<>();
      toMapResult.put("msg", msg);
      return toMapResult;
    }
    static @NonNull F2NMessage fromMap(@NonNull Map<String, Object> map) {
      F2NMessage pigeonResult = new F2NMessage();
      Object msg = map.get("msg");
      pigeonResult.setMsg((String)msg);
      return pigeonResult;
    }
  }

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class N2FMessage {
    private @Nullable String msg2;
    public @Nullable String getMsg2() { return msg2; }
    public void setMsg2(@Nullable String setterArg) {
      this.msg2 = setterArg;
    }

    public static final class Builder {
      private @Nullable String msg2;
      public @NonNull Builder setMsg2(@Nullable String setterArg) {
        this.msg2 = setterArg;
        return this;
      }
      public @NonNull N2FMessage build() {
        N2FMessage pigeonReturn = new N2FMessage();
        pigeonReturn.setMsg2(msg2);
        return pigeonReturn;
      }
    }
    @NonNull Map<String, Object> toMap() {
      Map<String, Object> toMapResult = new HashMap<>();
      toMapResult.put("msg2", msg2);
      return toMapResult;
    }
    static @NonNull N2FMessage fromMap(@NonNull Map<String, Object> map) {
      N2FMessage pigeonResult = new N2FMessage();
      Object msg2 = map.get("msg2");
      pigeonResult.setMsg2((String)msg2);
      return pigeonResult;
    }
  }
  private static class FlutterMessageCodec extends StandardMessageCodec {
    public static final FlutterMessageCodec INSTANCE = new FlutterMessageCodec();
    private FlutterMessageCodec() {}
    @Override
    protected Object readValueOfType(byte type, ByteBuffer buffer) {
      switch (type) {
        case (byte)128:         
          return F2NMessage.fromMap((Map<String, Object>) readValue(buffer));
        
        default:        
          return super.readValueOfType(type, buffer);
        
      }
    }
    @Override
    protected void writeValue(ByteArrayOutputStream stream, Object value)     {
      if (value instanceof F2NMessage) {
        stream.write(128);
        writeValue(stream, ((F2NMessage) value).toMap());
      } else 
{
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter.*/
  public interface FlutterMessage {
    void flutterSendMessage(@NonNull F2NMessage msg);

    /** The codec used by FlutterMessage. */
    static MessageCodec<Object> getCodec() {
      return FlutterMessageCodec.INSTANCE;
    }

    /** Sets up an instance of `FlutterMessage` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, FlutterMessage api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.FlutterMessage.flutterSendMessage", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>)message;
              F2NMessage msgArg = (F2NMessage)args.get(0);
              if (msgArg == null) {
                throw new NullPointerException("msgArg unexpectedly null.");
              }
              api.flutterSendMessage(msgArg);
              wrapped.put("result", null);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
  private static class NativeMessageCodec extends StandardMessageCodec {
    public static final NativeMessageCodec INSTANCE = new NativeMessageCodec();
    private NativeMessageCodec() {}
    @Override
    protected Object readValueOfType(byte type, ByteBuffer buffer) {
      switch (type) {
        case (byte)128:         
          return N2FMessage.fromMap((Map<String, Object>) readValue(buffer));
        
        default:        
          return super.readValueOfType(type, buffer);
        
      }
    }
    @Override
    protected void writeValue(ByteArrayOutputStream stream, Object value)     {
      if (value instanceof N2FMessage) {
        stream.write(128);
        writeValue(stream, ((N2FMessage) value).toMap());
      } else 
{
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated class from Pigeon that represents Flutter messages that can be called from Java.*/
  public static class NativeMessage {
    private final BinaryMessenger binaryMessenger;
    public NativeMessage(BinaryMessenger argBinaryMessenger){
      this.binaryMessenger = argBinaryMessenger;
    }
    public interface Reply<T> {
      void reply(T reply);
    }
    static MessageCodec<Object> getCodec() {
      return NativeMessageCodec.INSTANCE;
    }

    public void nativeSendMessage(@NonNull N2FMessage msgArg, Reply<Void> callback) {
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.NativeMessage.nativeSendMessage", getCodec());
      channel.send(new ArrayList<Object>(Arrays.asList(msgArg)), channelReply -> {
        callback.reply(null);
      });
    }
  }
  private static Map<String, Object> wrapError(Throwable exception) {
    Map<String, Object> errorMap = new HashMap<>();
    errorMap.put("message", exception.toString());
    errorMap.put("code", exception.getClass().getSimpleName());
    errorMap.put("details", "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    return errorMap;
  }
}
