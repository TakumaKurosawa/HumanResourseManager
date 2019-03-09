package jp.ac.ait.oop2.k17053.web.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 暗号化処理
 */
public class Encrypt {

  /**
   * 対応アルゴリズム列挙
   */
  public static enum Algorithm {
    MD2, MD5, SHA1, SHA256, SHA384, SHA512;

    String getName() {
      switch (this) {
        case MD2:
          return "MD2";
        case MD5:
          return "MD5";
        case SHA1:
          return "SHA-1";
        case SHA256:
          return "SHA-256";
        case SHA384:
          return "SHA-384";
        case SHA512:
          return "SHA-512";
        default:
          throw new IllegalStateException();
      }
    }
  }

  /**
   * アルゴリズムを指定してハッシュ関数を実行<br>
   * MD2,MD5,SHA-1,SHA-256,SHA-384,SHA-512 に対応
   *
   * 暗号化文 = Encrypt.toHashValue(Encrypt.Algorithm.SHA256, "暗号化したい文字列"); のように使用します。
   *
   * @param algorithm MD2,MD5,SHA-1,SHA-256,SHA-384,SHA-512から選択
   * @param value ハッシュ化したい文字列
   * @return
   */
  public static String toHashValue(Algorithm algorithm, String value) {
    MessageDigest md = null;
    try {
      md = MessageDigest.getInstance(algorithm.getName());
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
    md.update(value.getBytes());

    StringBuilder sb = new StringBuilder();
    for (byte b : md.digest()) {
      String hex = String.format("%02x", b);
      sb.append(hex);
    }
    return sb.toString();
  }
}
