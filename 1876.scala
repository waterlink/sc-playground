object P1876 extends App {
  val a :: b :: _ = readLine.split(" ").map(_.toInt).to[List]
  println((2 * b + 40) max (2 * (a - 1) + 41))
}
