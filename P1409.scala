object P1409 extends App {
  val a :: b :: _ = readLine.split(" ").map(_.toInt).toList
  val n = a + b - 1
  println(Array(n - a, n - b).mkString(" "))
}
