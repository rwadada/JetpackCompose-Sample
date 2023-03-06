# Jetpack ComposeでViewModelは要不要？
### ViewModel不要論の出典
https://twitter.com/JimSproch/status/1561024830786322433?s=20  
> AAC ViewModel is a kludge for Android, I see no reason to proliferate bad patterns. If you have a properly designed data layer, you'll realize you have no use for an AAC ViewModel.

JetpackComposeの開発者であるJimさんが、ViewModelはAndroidの負の遺産だし、使わなくていいなら使わない方がいいということを言ってる（超意訳）

### なぜViewModelは不要なのか？
#### そもそもViewModelの役割とは（ここではAACのものを扱う）
https://developer.android.com/topic/libraries/architecture/viewmodel?hl=ja
> ViewModel クラスは、ビジネス ロジックまたは画面レベルの状態ホルダーです。状態を UI に公開し、関連するビジネス ロジックをカプセル化します。状態がキャッシュに保存され、構成が変更されてもそれが維持されることが主なメリットです。つまり、アクティビティ間を移動するときや、画面の回転などの構成の変更に従うときに、UI でデータを再度取得する必要がありません。

つまり、以下の内容がViewModelの役割とえる
- 状態の保持
  - 画面回転、バックグラウンドからの復帰など
- ビジネスロジックへのアクセス

#### JetpackComposeでのViewModelの役割
- 状態の保持
  - rememberSavableの利用や、Stateと言ったクラスの定義によって不要になっている
- ビジネスロジックへのアクセス
  - これは残っている

つまり、JetpackComposeの場合、ViewModelはビジネスロジックと繋ぐ役割しか持たない。  
Repositoryなどから取得したデータを加工する処理などがあるようにも思えるが、それはStateに持つという対応ができる。  
以上を元にすると、JetpackComposeでのViewModelはただ、さらに奥の処理を呼び出すためだけのクラスとなり、無駄な冗長性が生まれている。

そのため、JetpackComposeではViewModelは不要と考えられる（既存を置き換える場合はこの限りになし）

### どう実装するのか
コードを参照！
