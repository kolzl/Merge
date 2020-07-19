Allgemein:
Ich bin davon ausgegangen, dass die Tuple immer nur Paarweise vorkommen also nur zwei Werte besitzen und
dass der zweite Wert immer der Höhere ist.

Ausführen der Datei:
Im target-Ordner die jar Datei ausführen. (Mit "java -jar MergeTuples-0.0.1-SNAPSHOT.jar").
Darauf achten, dass im Targetordner eine Tuple.txt Datei liegt.
Die jar kann mit mvn package neu packetiert werden, wenn das gewünscht ist. Dabei aber bitte drauf achten,
dass Tuple.txt vorhanden ist.

----------------------------------------------------------------------------------------------------------

Hinzufügen von Tuplen:
Die Liste der Tupel kann über die Datei "Tuples.txt" erweitert werden.
Bitte darauf achten, dass nur Tupel im Format:

Zahl,Zahl

akzeptiert werden.
Auf Leerzeichen oder sonstiges wird nicht überprüft.
Jeder Tupel muss in einer neuen Zeile stehen.

----------------------------------------------------------------------------------------------------------

Wie ist die Laufzeit Ihres Programms ?
O(n^2)

Wie kann die Robustheit sichergestellt werden, vor allem auch mit Hinblick auf sehr große
Eingaben ?
Für sehr sehr hohe Datenmengen muss man mit einer Überforderung des Systems rechnen, da alle Daten (Tuple) in
zwei Listen gehalten werden müssen.

Wie verhält sich der Speicherverbrauch ihres Programms ?
Wird das Programm mit sehr hohen Datenmengen ausgeführt muss man damit rechnen, dass der Speicher vollläuft, da zwei
Listen im Speicher gehalten werden müssen und es sein kann, dass dieser ausläuft.