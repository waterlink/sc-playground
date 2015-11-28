import scala.annotation.tailrec

object P1005 extends App {
  val n = readLine.toInt
  val w = readLine.split(" ").map(_.toInt)

  val shifts = (0 to n).map(1 << _)

  @tailrec
  def diffForRec(sign: Int, i: Int, max: Int, sum: Int): Int =
    if (i == max)
      sum
    else
      diffForRec(sign, i + 1, max,
        if ((sign & shifts(i)) > 0) sum + w(i) else sum - w(i))

  def diffFor(sign: Int) =
    diffForRec(sign, 0, n, 0).abs

  @tailrec
  final def rec(sign: Int, max: Int, best: Int): Int =
    if (sign == max)
      best
    else
      rec(sign + 1, max, math.min(best, diffFor(sign)))

  println(rec(0, shifts(n), w.sum))
}
