AndroidStudioでプロジェクト生成後
コマンドのみでUIテストを実行する方法のまとめ

adb コマンドが使える状態でUSBデバッグできる端末が接続済みの場合

手順

１．app/build.gradleの編集(espressoの導入など)
２．"./gradlew build"実行
３．app/src/main/res/layout/activity_main.xmlの編集(UIテスト用にView追加)
４．app/src/main/java/com/akafune/androidcommandtest/app/MainActivity.javaの編集
	(UIの制御を実装)
５．app/src/androidTest/java/com/akafune/androidcommandtest/app/ApplicationTest.javaの編集
	(UIテストの実装)
６．runTest.shの作成(UIテスト実行に必要なコマンドをまとめる)
７．$ sh runTest.sh
