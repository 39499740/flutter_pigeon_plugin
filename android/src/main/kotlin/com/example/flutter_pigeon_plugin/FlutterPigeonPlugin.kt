package com.example.flutter_pigeon_plugin

import android.util.Log
import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin

/** FlutterPigeonPlugin */
class FlutterPigeonPlugin : FlutterPlugin, Message.FlutterMessage {
    lateinit var nativeMessage: Message.NativeMessage

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        Message.FlutterMessage.setup(flutterPluginBinding.binaryMessenger, this)
        nativeMessage = Message.NativeMessage(flutterPluginBinding.binaryMessenger)
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {

    }

    override fun flutterSendMessage(msg: Message.F2NMessage) {
        Log.d("FlutterPigeonPlugin", msg.msg.toString())
        var respMsg: Message.N2FMessage = Message.N2FMessage()
        respMsg.msg2 = "Android的返回值"
        nativeMessage.nativeSendMessage(respMsg, {})

    }


}
