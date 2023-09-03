# container-api
docker containerとして動かす為の,  
HelloWorldレベルのSpring Boot Rest API サンプル。

## 背景

Kubernetesの検証の為、サンプル用のapiを作成。  
まずはDockerでコンテナビルドできるところまで

## 動作確認

### 前提

* Java 11.x

### アプリケーションのビルド

* コマンド実行

```sh
$ gradlew clean build
```

### ローカル実行

* コマンド実行

```sh
$ gradlew bootRun 
```

* 下記URLを開き、「GET: /hello」をtry it outして動作検証
  * http://localhost:9000/swagger-ui/index.html

### コンテナとしてビルド

TODO