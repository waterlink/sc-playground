object P1025 extends App {
  val n = readLine.toInt
  println(readLine.split(" ").map(_.toInt)
    .sorted
    .take((n + 1) / 2)
    .map(_ + 1).map(_ / 2)
    .sum)
}
