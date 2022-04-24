###
 # @Author: 郝怿
 # @Date: 2022-04-14 23:39:07
 # @LastEditTime: 2022-04-14 23:39:22
 # @LastEditors: 郝怿
 # @Description: 
 # @FilePath: /idcard_reader_plugin/run_pigeon.sh
###


mkdir -p android/src/main/java/com/example/flutter_pigeon_plugin

flutter pub run pigeon \
  --input pigeons/message.dart \
  --dart_out lib/message.dart \
  --objc_header_out ios/Classes/Message.h \
  --objc_source_out ios/Classes/Message.m \
  --java_out android/src/main/java/com/example/flutter_pigeon_plugin/Message.java \
  --java_package "com.example.flutter_pigeon_plugin"