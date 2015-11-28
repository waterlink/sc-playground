object P1246 extends App {
  def area(a: (Float, Float), b: (Float, Float)) =
    a._1 * b._2 - a._2 * b._1

  def vec(ax: Float, ay: Float, bx: Float, by: Float) =
    (bx - ax, by - ay)

  val n = readLine.toInt
  val vs = (0 until n).map(i =>
    readLine.split(" ").map(_.toFloat)
  ).view
  val xs = vs.map(_(0))
  val ys = vs.map(_(1))
  val px = xs.sum / xs.length
  val py = ys.sum / ys.length

  val toVec = (i: Int) =>
    vec(px, py, xs(i), ys(i))

  val polyArea = (0 until n)
    .view
    .map(i => (i, (i + 1) % n))
    .map(p => (toVec(p._1), toVec(p._2)))
    .map(p => (area(p._1, p._2)))
    .sum

  println(if (polyArea > 0) "ccw" else "cw")
}
