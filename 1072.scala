case class Interface(ip: Int, mask: Int, net: Int)

case class Computer(ifaces: List[Interface]) {
  def edges: List[Edge] = {
    ifaces
      .flatMap(
        i => ifaces.map(j => Edge(i.net, j.net, through: this))
      ).filter(e => e.from != e.to)
  }
}

case class Edge(from: Int, to: Int, through: Computer)

object P1072 extends App {
  def addrToInt(addr: String): Int =
    addr.split(".").map(_.toInt).reduceLeft(_ * 256 + _)

  val n = readLine.toInt

  val computers = (0 until n).map(i => {
    val k = readLine.toInt
    val interfaces = (0 until k).map(j => {
      val ip :: mask :: _ = readLine.split(" ").map(addrToInt).toList
      val net = ip & mask

      Interface(ip, mask, net)
    })

    Computer(interfaces.toList)
  })

  val edges = computers.flatMap(_.edges)
}
