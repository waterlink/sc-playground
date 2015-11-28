import io.Source

object P1001 extends App {
  println(
    Source.stdin.getLines().flatMap(
      _.split(" ").filter(!_.isEmpty).map(_.toLong)).toArray
        .reverse.map(t => math.sqrt(t)).mkString("\n"))
}
