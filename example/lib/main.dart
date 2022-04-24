import 'package:flutter/material.dart';

import 'package:flutter_pigeon_plugin/flutter_pigeon_plugin.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  late FlutterPigeonPlugin _flutterPigeonPlugin;


  @override
  void initState() {
    super.initState();
    _flutterPigeonPlugin = FlutterPigeonPlugin();
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('Plugin example app'),
        ),
        body: Center(
          child: TextButton(
              child: Text("点击这里向native发送消息"),
              onPressed: () {
                _flutterPigeonPlugin.sendMessage();
              }),
        ),
      ),
    );
  }
}
