# container-api
docker containerとして動かす為の,  
HelloWorldレベルのSpring Boot Rest API サンプル。

## 背景

Kubernetesの検証の為、サンプル用のapiを作成。  
まずはDockerでコンテナビルドできるところまで

## 動作確認

### 前提

* Java 11.x
* Docker Desktop インストール済み

### コンテナを使わない動作確認

#### アプリケーションのビルド

* コマンド実行

```sh
$ ./gradlew clean build
```

#### ローカル実行

* コマンド実行

```sh
$ ./gradlew bootRun 
```

* 下記URLを開き、「GET: /hello」をtry it outして動作検証
  * http://localhost:9000/swagger-ui/index.html

#### 実行可能アーカイブ（JAR）作成・実行

* 実行可能JAR作成 

```sh
$ ./gradlew clean bootJar
```

* JARの実行

```sh
$ java -jar ./build/libs/container-api-0.0.1-SNAPSHOT.jar
```

### コンテナアプリとしての動作確認

#### コンテナビルド

* コマンド実行

```sh
$ docker build -t demo:app .
```

#### コンテナ実行

* コマンド実行

```sh
$ docker run -p 9000:9000 demo:app
```


* 下記URLを開き、「GET: /hello」をtry it outして動作検証
  * http://localhost:9000/swagger-ui/index.html


### Kubernetes上での実行

#### Kubernetesのインストール

* Docker Desktop据え置きのKubernetesを使用。
  * https://matsuand.github.io/docs.docker.jp.onthefly/desktop/kubernetes/
  * マシンのスペックによっては有効化できないかもしれないので注意。
  * CPU Intel Corei5 メモリ8GBで有効化できたが、かなり重い。。

* Dockerのk8sを動かせない場合はMinikubeやk3sのインストールを試してみよう
  * Minikube
    * https://minikube.sigs.k8s.io/docs/start/
  * k3s
    * https://k3s.io/


#### アプリの起動

* コマンド実行

```sh
$ kubectl apply -f k8s.yaml
```

* 下記URLを開き、「GET: /hello」をtry it outして動作検証
  * http://localhost:5000/swagger-ui/index.html

#### アプリの停止

* コマンド実行

```sh
$ kubectl delete -f k8s.yaml
```