package prog.IO

import prog.Model.Flat

import java.io.{FileOutputStream, OutputStreamWriter}
import scala.collection.mutable

object WriteToFile {

  def writeToFile(fileName : String, collection: mutable.ArrayDeque[Flat]) : Unit = {
    val streamWriter = new OutputStreamWriter(new FileOutputStream(fileName))
    streamWriter.write("<file>\n") // Writing to the file
    collection.foreach(x => streamWriter.write(x.toXml.toString()))
    streamWriter.write("\n</file>")
    streamWriter.close()
    println("Data was written to " + fileName)
  }

}
