import scala.annotation.tailrec

object P1014 extends App {
  val n = readLine.toInt

  @tailrec
  def rec(n: Int, k: Int, i: Long, x: Long): Long = {
    if (n == 1)
      x
    else if (k == 1)
      -1
    else if (n % k > 0)
      rec(n, k - 1, i, x)
    else
      rec(n / k, k, i * 10, k * i + x)
  }

  val result = if (n == 0)
      10
    else if (n == 1)
      1
    else
      rec(n, 9, 1, 0)

  println(result)
}
