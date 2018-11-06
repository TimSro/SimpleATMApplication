# Testting for Identity Management and Authentication Testing:

## 4.4 [Testing for Identity Management](https://www.owasp.org/index.php/Testing_Identity_Management)

### Test Role Definitions  
Kann ich als User auf eine Adminseite zugreifen, oder wird das verhindert?   

### Test User Registration Process  
Wird die Identität überprüft und wenn ja wie?  
Kann eine Identität sich mehrmals registrieren?  
Kann man sich für Rollen oder Berechtigungen anmelden?  
Wird die Identität überprüft?  
Wie einfach können Daten gefaked werden?  

### Test Account Provisioning Process  
Gibt es eine Verifikation fürs erstellen/ entfernen von Accounts?  
Kann ein Admin oder User Accounts mit Rechten erstellen, die über den eigenen liegen?  
Was passiert mit den Files von entfernten Usern?  

### Testing for Account Enumeration and Guessable User Account    
Eingeben von existentem Username/ passendem Passwort, existentem Usernamen/ flaschem Passwort und nicht existentem Username.  
Die HTTP Responses werden dann untersucht, ob man anhand dieser existente User herrausfinden kann.  
Außerdem können Fehlerseiten, Webpagetitles und URLs Hinweise auf die Existenz der User enthalten.  

Manchmal werden User IDs nach Policies erzeugt.  
Das ermöglicht das automatisierte Testen mit zum Beispiel Perl.  

*Tools:* [Webscarab](https://www.owasp.org/index.php/Category:OWASP_WebScarab_Project)

### Testing for Weak or unenforced username policy   
Gibt es eine Struktur für Usernames?  
Unterschiedliche Fehlermeldungen für gültige und ungültoge Usernames?  

Man kann ein Username Dictionary verwenden.



## 4.5 [Authentication Testing](https://www.owasp.org/index.php/Testing_for_authentication)


### Testing for Credentials Transported over an Encrypted Channel   
Hier wird mit einem Webproxy untersucht, ob Username und Password mit in den HTTP Body oder mit in der URL gesendet werden.   

*Tools:* [Webscarab](https://www.owasp.org/index.php/Category:OWASP_WebScarab_Project)
 und [OWASP ZAP](https://www.owasp.org/index.php/OWASP_Zed_Attack_Proxy_Project)    

### Testing for default credentials    
Wenn die verwendete Technologie bekannt ist, kann auf default Credentials getestet werden.  
Außerdem sollte man verbreitete Varianten wie z.B. admin, administrator, root, qa, test, system, guest, operator, oder super testen.  
Als Passwörter bieten sich password, pass123, password123, admin, oder guest an.  

Neue Accounts könnten mit Defaultpasswörtern erstellt werden, die einem bestimmten Muster folgen.  

### Testing for Weak lock out mechanism   
Ab wie vielen Fehlerhaften Eingaben greift der Lockoutmechanismus und wie lange dauert dieser?  
Wie leicht lässt es sich Bruteforcen?  

### Testing for Bypassing Authentication Schema   

*Tools*: [Webscarab](https://www.owasp.org/index.php/Category:OWASP_WebScarab_Project)
 und [OWASP ZAP](https://www.owasp.org/index.php/OWASP_Zed_Attack_Proxy_Project)  

### Testing for Vulnerable Remember Password    
Passwörter in Cookies gespeichert (Klartext oder Gehashed)?  
Welcher Hashalgorithmus (SHA-256/384 bevorzugt)?  
Credentials nur beim Login geschickt und nicht bei jedem Request?  

### Testing for Browser cache weakness   
Jede Seite die sensitive Daten enthält sollte im Browser keine Daten cashen.  
Hier den HTTP response header untersuchen:  
Cache-Control: no-cache, no-store; Expires: 0; Pragma: no-cache  

Gut zusätzlich dazu sind auch noch:  
Cache-Control: must-revalidate, pre-check=0, post-check=0, max-age=0, s-maxage=0  

*Tools:* [OWASP ZAP](https://www.owasp.org/index.php/OWASP_Zed_Attack_Proxy_Project)  

### Testing for Weak password policy  
Wie muss ein Passwort mindestens aussehen, welche Zeichen sind verboten?  
Wann muss das Passwort gewechselt werden? ---> Note: ist häufig nicht eigentlich schlecht, da Passwörter dadurch eher unsicherer werden?  
Wie oft kann das Passwort wiederverwendet werden?  
Wie unterschiedlich muss das neue Passwort vom alten sein?  
Kann der User andere Accountinformationen als Passwort verwenden, wie z.B. seinen Username?  

### Testing for Weak security question/answer  
Können Fragen selbst erstellt werden?  
Kann man die Antwort einfach googlen?  
Hat die Frage nur eine stark begrenzte Anzahl von möglichen Antworten?  
Hat man unbegrenzte Versuche für die Antwort?  
Gibt es einen Lockout, wann greift dieser (sollte auch nicht zu früh greifen! --> DoS)?  

### Testing for weak password change or reset functionalities

**Password Change**  
Muss das alte Passwort auch angegeben werden?  

**Password Reset**  
Welche Daten werden benötigt?  
Wie erhält der User das Passwort?  
Werden die Passwörter zufällig generiert?  
Wird vorher nach einer Bestätigung gefragt(per E-Mail)?  

### Testing for Weaker authentication in alternative channel  
Welche anderen Kanäle gibt es zur Authentifikation?  
Was kann über diese Kanäle gemacht werden?  
Gibt es dort eine schwächere Überprüfung der Konformität?  

| Website        | Mobile          | Callcenter |
| -------------- |:---------------:| ----------:|
| Register       | Yes             | -          |
| Log in         | Yes             | Yes        |
| Log out        | -               | -          |
| Reset password | Yes             | Yes        |
| -              | Change password |-           |

***[Source](https://www.owasp.org/images/1/19/OTGv4.pdf)***
