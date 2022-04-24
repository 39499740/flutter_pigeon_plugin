import Flutter
import UIKit

public class SwiftFlutterPigeonPlugin: NSObject, FlutterPlugin,FlutterMessage {
    public func flutterSendMsg(_ msg: F2NMessage, error: AutoreleasingUnsafeMutablePointer<FlutterError?>) {
        print("收到来自于Flutter的消息"+msg.msg!)
        let message:N2FMessage = N2FMessage.make(withMsg2: "iOS返回的消息")
        nativeMessage.nativeSendMsg(message, completion: {e in})
    }
    public var nativeMessage:NativeMessage!
    public static func register(with registrar: FlutterPluginRegistrar) {
        let messenger: FlutterBinaryMessenger = registrar.messenger()
        let api = SwiftFlutterPigeonPlugin.init()
        FlutterMessageSetup(messenger, api)
        api.nativeMessage = NativeMessage(binaryMessenger: messenger)
    }
}
