import scala.annotation.tailrec

object P1009 extends App {
  val n = readLine.toInt
  val k = readLine.toInt

  @tailrec
  def f(i: Int, n: Int, a: Int, b: Int): Int =
    if (i == n + 1)
      b
    else
      f(i + 1, n, b, (k - 1) * (a + b))

  println(f(2, n, 1, k - 1))
}
