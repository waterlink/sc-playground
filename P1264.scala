object P1264 extends App {
  val n :: m :: _ = readLine.split(" ").map(_.toInt).to[List]
  println(n * (m + 1))
}
