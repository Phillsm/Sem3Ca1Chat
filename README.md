Sem3Ca1Chat
===========

Semester 3 Compulsory Assignment 1: Chat Server / Client

Dokumentation
-------------
Vi har i vores CA1 chatprogram taget udgangspunkt i opgaven Echo som vi gennemgik i klassen. Dette virkede som det oplagte valg, da der med et par få justeringer kunne opnås det ønskede resultat. Det samme gælder for http delen, den er byggede op på samme måde som opgaven vi har haft i undervisningen.
Der er blevet brugt observer pattern i opgaven, det hænger igen sammen med det var måde vi lærte det på i Echo server opgaven. Det er problemet med at receive indeholder et blocking call, der så blokere GUI’en indtil vi modtager noget fra serveren.
Vi har lavet et command object som kan bruges til at parse String protokollen og representere den.

Opgave Fordeling
----------------
* Markus: Gui client
* Charles: http Server, html content
* Phillip: implementation af stringprotocol

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
