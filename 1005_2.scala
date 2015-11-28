object P1005_2 extends App {
  val n = readLine.toInt
  val w = readLine.split(" ").map(_.toInt)

  def diffFor(diff: Int, i: Int): Int =
    if (i == n)
      diff
    else {
      val v = w(i)
      val ni = i + 1
      math.min(
        diffFor((diff + v).abs, ni),
        diffFor((diff - v).abs, ni)
      )
    }

  println(diffFor(0, 0))
}

