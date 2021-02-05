package prog.Model

object IdGenerator {
  private var id = 0

  def setId (id : Int): Unit = { this.id = id }
  def getId: Int = {
    id = id +1
    id
  }
}
