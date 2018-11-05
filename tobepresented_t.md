## Presentation Tim:


### 4.4 Testing for Identity Management

https://www.owasp.org/index.php/Testing_Identity_Management


**Test Role Definitions**  
Kann ich als User auf eine Adminseite zugreifen, oder wird das verhindert?  

Manuell, ein Spideringtool hilft aber.  


**Test User Registration Process**  
Wird die Identität überprüft und wenn ja wie?  
Kann eine Identität sich mehrmals registrieren?  
Kann man sich für Rollen oder Berechtigungen anmelden?  
Wird die Identität überprüft?  
Wie einfach können Daten gefaked werden?  

Manuell


**Test Account Provisioning Process**  
Gibt es eine Verifikation fürs erstellen/ entfernen von Accounts?  
Kann ein Admin oder User Accounts mit Rechten erstellen, die über den eigenen liegen?  
Was passiert mit den Files von entfernten Usern?  

Manuell


**Testing for Account Enumeration and Guessable User Account**  
Eingeben von existentem Username/ passendem Passwort, existentem Usernamen/ flaschem Passwort und nicht existentem Username.  
Die HTTP Responses werden dann untersucht, ob man anhand dieser existente User herrausfinden kann.  
Außerdem können Fehlerseiten, Webpagetitles und URLs Hinweise auf die Existenz der User enthalten.  

Manchmal werden User IDs nach Policies erzeugt.  
Das ermöglicht das automatisierte Testen mit zum Beispiel Perl.  

Der Webscarab hilft die HTTP Responses anzuschauen.


**Testing for Weak or unenforced username policy**  
Gibt es eine Struktur für Usernames?  
Unterschiedliche Fehlermeldungen für gültige und ungültoge Usernames?  

Man kann ein Username Dictionary verwenden.



### 4.5 Authentication Testing

https://www.owasp.org/index.php/Testing_for_authentication

**Testing for Credentials Transported over an Encrypted Channel**  
Hier wird mit einem Webproxy untersucht, ob Username und Password mit in den HTTP Body oder mit in der URL gesendet werden.   

Hierfür können z.B. der Webscarab oder der OWASP ZAP verwendet werden.  

**Testing for default credentials**  
Wenn die verwendete Technologie bekannt ist, kann auf default Credentials getestet werden.  
Außerdem sollte man verbreitete Varianten wie z.B. admin, administrator, root, qa, test, system, guest, operator, oder super testen.  
Als Passwörter bieten sich password, pass123, password123, admin, oder guest an.  

Neue Accounts könnten mit Defaultpasswörtern erstellt werden, die einem bestimmten Muster folgen.  

**Testing for Weak lock out mechanism**  
Ab wie vielen Fehlerhaften Eingaben greift der Lockoutmechanismus und wie lange dauert dieser?  
Wie leicht lässt es sich Bruteforcen?  

**Testing for Bypassing Authentication Schema**  

WebScarab und OWASP ZAP können verwendet werden.

