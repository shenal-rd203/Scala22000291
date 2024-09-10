object CaesarCipher {
  def encrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        ((char - base + shift) % 26 + base).toChar
      } else {
        char
      }
    }
  }

  def decrypt(text: String, shift: Int): String = {
    text.map { char =>
      if (char.isLetter) {
        val base = if (char.isUpper) 'A' else 'a'
        ((char - base + shift) % 26 + base).toChar
      } else {
        char
      }
    }
  }

  def cipher(func: (String, Int) => String, text: String, shift: Int): String = {
    func(text, shift)
  }

  def main(args: Array[String]): Unit = {
    val plaintext = "Hello, World!"
    val shift = 1

    val encrypted = cipher(encrypt, plaintext, shift)
    println(s"Encrypted: $encrypted")

    val decrypted = cipher(decrypt, encrypted, shift)
    println(s"Decrypted: $decrypted")
  }
}