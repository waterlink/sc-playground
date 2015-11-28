object P1083 extends App {
  val nstr :: exclamations :: _ = readLine.split(" ").to[List]
  val n = nstr.toInt
  val k = exclamations.length
  val remainder = n % k
  val low = if (remainder > 0) remainder else k
  println((low until n + 1 by k).product)
}
