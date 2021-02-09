package prog.IO

import prog.Main.collection
import prog.Model.{FlatReader, IdGenerator}

import java.io.File
import scala.xml.XML

object ReadFromFile {
  def readXml(fileName : String): Unit = {
//    to be honest i should use BufferedInputStream(new FileInputStream(fileName), but XML.loadFile much easier to use %)
    val xml = XML.loadFile(new File(fileName))
    var maxId = -1
    for (flat <- xml \\ "file" \\ "flat") {
      collection.addOne(FlatReader.fromXml(flat))
      if ((flat \ "id").text.toInt > maxId) maxId = (flat \ "id").text.toInt
    }
    IdGenerator.setId(maxId)
  }

  def readCommands (fileName: String) = {}

}
