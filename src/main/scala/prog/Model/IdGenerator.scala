package prog.Model

import prog.Main.collection

object IdGenerator {
  private var id = 0
  def getId: Int = {
    collection.foreach(f => {
      if (f.id_() > id)
        id = f.id_()
    })
    id +1
  }
}
