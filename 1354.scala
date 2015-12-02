object P1354 extends App {
  val modulo = 30747419
  val base = 102797

  def byMod(x: Long): Long =
    ((x % modulo) + modulo) % modulo

  val s = readLine.reverse
  val n = s.length
  val bigN = n + 100
  val q = Array.fill[Long](bigN) {1}
  val prefix = Array.fill[Long](n + 1) {0}
  val suffix = Array.fill[Long](n + 2) {0}

  for (i <- 1 until bigN) {
    q(i) = byMod(q(i - 1) * base)
  }

  for (i <- 1 to n) {
    prefix(i) = byMod((prefix(i - 1) + q(bigN - i) * s(i - 1).toLong))
    suffix(n - i) = byMod((suffix(n - i + 1) + q(bigN - i) * s(n - i).toLong))
  }

  def isPalindrom(m: Int): Boolean = {
    val pHash = prefix(m)
    val sHash = byMod((suffix(0) - suffix(m)) * q(n - m))
    sHash == pHash
  }

  val bestPrefix = (1 until n)
    .filter(isPalindrom)
    .reverse
    .headOption
    .getOrElse(0)

  val s2 = s.substring(bestPrefix, n).reverse

  println(s2 + s)
}
