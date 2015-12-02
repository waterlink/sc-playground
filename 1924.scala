object P1924 extends App {
  val n = readLine.toInt
  val ress = Array("black", "grimy")
  val k = ((n + 1) / 2) % 2
  println(ress(k))
}
