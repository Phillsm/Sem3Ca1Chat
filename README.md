Sem3Ca1Chat
===========

Semester 3 Compulsory Assignment 1: Chat Server / Client

Wireshark example
-----------------
![Wireshark](http://i.imgur.com/lYAQzXv.jpg)
Stepthrough:
* 16 to 18: the 3 way tcp handshake
* 19: CONNECT#Phill string is passed on to the server
* 20: Server aknowledges the data
* 21: Server Sends ONLINE#Phill to client
* 22: Client aknowledges the data
* 25: Client sends SEND#*#Hello
* 26: Server Sends MESSAGE#Phill#Hello to client
* 27: Client aknowledges
* 29: (client is manually closed) CLOSE# command is sent to server
* 30: server aknowledges
* 34: Connection is reset ungracefully
