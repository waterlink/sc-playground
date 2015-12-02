object P2001 extends App {
  val a1 :: b1 :: _ = readLine.split(" ").map(_.toInt).to[List]
  val a2 :: b2 :: _ = readLine.split(" ").map(_.toInt).to[List]
  val a3 :: b3 :: _ = readLine.split(" ").map(_.toInt).to[List]
  val x = a1 - a3
  val y = b1 - b2
  println(x + " " + y)
}
