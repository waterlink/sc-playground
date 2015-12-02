case class Wall(i: Int, sum: Int)

object P1910 extends App {
  def to3(xs: Array[Int]): Iterable[Wall] = {
    val n = xs.length
    for {
      i <- 2 until n
      a = xs(i - 2)
      b = xs(i - 1)
      c = xs(i)
      wall = Wall(i, a + b + c)
    } yield wall
  }

  def best(a: Wall, x: Wall): Wall =
    if (a.sum < x.sum) x else a

  val n = readLine.toInt
  val xs = to3(readLine.split(" ").take(n).map(_.toInt))

  val x = xs.foldLeft(Wall(0, 0))(best)
  println(x.sum + " " + x.i)
}
