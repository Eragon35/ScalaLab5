package prog.Model

object IdGenerator {
  private var id = 0
  def serId(id: Int): Unit ={
    this.id = id
  }
  def getId: Int = {
    id = id +1
    id
  }
}
