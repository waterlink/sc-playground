object P1293 extends App {
  val n :: a :: b :: _ = readLine.split(" ").map(_.toInt).toList
  println(2 * n * a * b)
}
