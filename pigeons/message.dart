import 'package:pigeon/pigeon.dart';

class F2NMessage{
  String? msg;
}

class N2FMessage{
  String? msg2;
}

@HostApi()
abstract class FlutterMessage{
  void flutterSendMessage(F2NMessage msg);
}

@FlutterApi()
abstract class NativeMessage{
  void nativeSendMessage(N2FMessage msg);
}