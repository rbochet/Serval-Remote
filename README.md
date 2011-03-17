The dumbest program ever : aims to act as a remote for the Serval Video collection.

It just sends 1 byte using TCP. But does it well.

Use something like `java -jar Serval-Remote <IPv4 address> <port> <byte value>`

Where :

* `port` is probably 6666 (define in the `org.servalproject.svd.ControlService.PORT` constant)
* `byte value` can be given in hexa (`0x11`) or decimal (`17`). The payloads values are described on the [http://developer.servalproject.org/twiki/bin/view/Main/PublicAlphaVideoCollectionCapability#Control](wiki page)
