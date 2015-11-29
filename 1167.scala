object P1167 extends App {
  val inf = 1000000000

  val n :: m :: _ = readLine.split(" ").map(_.toInt).to[List]
  val a = 0 until n map { i => readLine.toInt }
  val pf = Array.fill(n + 1) { inf }
  val f = Array.fill(n + 1) { inf }
  val w = Array.fill(n + 1) { 0 }
  val b = Array.fill(n + 1) { 0 }
  val pu = Array.fill(n + 1) { 1 }
  val u = Array.fill(n + 1) { 1 }
  val v = Array.fill(n + 1) { Array.fill(n + 1) { 0 } }

  for (j <- 1 to n) {
    w(j) = w(j - 1)
    b(j) = b(j - 1)
    if (a(j - 1) == 0)
      w(j) = w(j) + 1
    else
      b(j) = b(j) + 1
  }

  for (j <- 1 to n) {
    for (k <- 0 until j) {
      v(j)(k) = (w(j) - w(k)) * (b(j) - b(k))
    }
  }

  for (j <- 1 to n) {
    pf(j) = v(j)(0)
    f(j) = pf(j)
  }

  for (i <- 2 to m) {
    for (j <- 1 to n) {
      f(j) = inf
      u(j) = 1
      var k0 = u(j - 1) max (i - 1)

      for (k <- k0 until j) {
        val nf = pf(k) + v(j)(k)
        if (f(j) > nf) {
          f(j) = nf
          k0 = k
        }
      }

      u(j) = k0
    }

    for (j <- 0 to n) {
      pf(j) = f(j)
      pu(j) = u(j)
    }
  }

  println(f(n))
}
