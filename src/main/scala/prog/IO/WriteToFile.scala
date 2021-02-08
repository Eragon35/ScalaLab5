package prog.IO

import prog.Model.Flat

import java.io.{File, PrintWriter}
import scala.collection.mutable

object WriteToFile {

  def writeToFile(fileName : String, collection: mutable.ArrayDeque[Flat]) : Unit = {
    val printWriter = new PrintWriter(new File(fileName)) // Passing reference to file to the printWriter
    printWriter.write("<file>\n") // Writing to the file
    collection.foreach(x => printWriter.write(x.toXml.toString()))
    printWriter.write("\n</file>")
    printWriter.close()
    println("Data was written to " + fileName)
  }

}
