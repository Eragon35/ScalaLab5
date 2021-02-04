package prog.Model

class Coordinates (x: Long, y: Float) {
  if (x == null) throw new IllegalArgumentException("X can't be null")
  if (y == null) throw new IllegalArgumentException("Y can't be null")
  if (x <= -702) throw  new IllegalArgumentException("X should be more than -702")
  if (y <= -261) throw  new IllegalArgumentException("Y should be more than -261")

  override def toString: String = {
    "Coordinates (" + x + ", " + y + ")"
  }

  def x() = x
  def y() = y
}
