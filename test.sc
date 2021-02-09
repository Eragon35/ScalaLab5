import java.time.format.DateTimeFormatter
import scala.collection.mutable

Math.log(8)/Math.log(2)
java.time.LocalDate.now.format(DateTimeFormatter.ofPattern("dd-MM-YYYY"))

var line = "   remove_by_id   2  pidor "
while (line.contains("  ")) line = line.trim.replaceAll("\\s\\s", " ")
line.split(" ", 2)

val history = new mutable.Queue[String]
history += "lox"
history += "pidor"



