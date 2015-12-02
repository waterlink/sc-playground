case class Edge(a: Int, b: Int)

object P1272 extends App {
  def readEdge(i: Int): Array[Int] = readLine.split(" ").take(2).map(_.toInt)
  def newEdge(x: Array[Int]): Edge = Edge(x(0) - 1, x(1) - 1)
  def readEdges(n: Int): List[Edge] = (0 until n).map(readEdge).map(newEdge).to[List]
  def invertEdge(e: Edge): Edge = Edge(e.b, e.a)

  val n :: k :: m :: _ = readLine.split(" ").map(_.toInt).to[List]
  val tunnel = readEdges(k)
  val bridge = readEdges(m)
  val visited = Array.fill(n) {false}

  val edges = Array.fill(n) { List[Edge]() }

  for (e <- tunnel) {
    edges(e.a) = e :: edges(e.a)
    edges(e.b) = invertEdge(e) :: edges(e.b)
  }

  def dfs(v: Int) {
    visited(v) = true
    for (e <- edges(v)) {
      if (!visited(e.b)) {
        dfs(e.b)
      }
    }
  }

  var result = -1
  for (v <- 0 until n) {
    if (!visited(v)) {
      result = result + 1
      dfs(v)
    }
  }

  println(result)
}
