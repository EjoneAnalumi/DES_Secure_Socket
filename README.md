# DES_Secure_Socket


Ky eshte nje projekt i punuar nga Ejone Analumi dhe Edonita Gashi, studente te vitit te dyte te Universitetit "Hasan Prishtina" - Fakulteti i Inxhinierise Elektrike dhe Kompjuterike, ne lenden "Data Security" - Prof. Blerim Rexha dhe Asc. Mergim Hoti.

## Tema e projektit

Perdorimi i DES per te mbeshtjellur network stream. Implementimi i nje cifti klient/server te thjeshte duke komunikuar ne kete menyre.

## Pershkrimi i projektit

Ky projekt simulon komunikimin e sigurt midis dy kompjutereve permes:

- Kriptimit te mesazheve ne klient para se te dergohen.
- Dekriptimit te mesazheve ne server pasi te pranohen.

Te gjitha mesazhet transmetohen permes rrjetit duke u enkriptuar me DES dhe duke u dekriptuar nga ana e serverit.

## Permbajtja e kodit

### Client.java

- Lidh klientin me serverin permes IP-se dhe portit te caktuar.
- Lexon mesazhin nga perdoruesi.
- E kripton mesazhin duke perdorur `DES_Util.encrypt()`.
- E dergon mesazhin e enkriptuar tek serveri.

### Server.java

- Niset dhe pret lidhje nga klienti.
- Pranon mesazhe te kriptuara nga klienti.
- Dekriptohen mesazhet me `DES_Util.decrypt()`.
- Shfaq mesazhet plaintext ne console.

### DES_Util.java

- Implementon logjiken e kriptimit dhe dekriptimit me DES.
- Perdor nje celes privat statik "12345678".

## Teknologjite dhe Veglat e perdorura

- Java SE 17+
- IntelliJ IDEA si mjedis zhvillimi (IDE)
- Serveo.net per te krijuar tunel te jashtem TCP midis kompjutereve te ndryshem
- DES algoritmi per enkriptim

## Si u testua komunikimi

1. Serveri u nis nga Ejona duke ekzekutuar `Server.java` ne kompjuterin e saj.
2. U krijua nje tunel i jashtem permes platformes serveo.net.
3. Adresa dhe porti i tunelit iu derguan Edonites.
4. Klienti u konfigurua nga Edonita duke percaktuar IP-ne dhe portin e marre, ne `Client.java`.
5. Pas ekzekutimit te klientit, Edonita dergonte mesazhe te enkriptuara.
6. Serveri i Ejones pranonte mesazhet, i dekriptonte dhe i shfaqte ne forme plaintext ne console.

## Shembull i rrjedhes se mesazhit


Edonita (Client) -> DES_Util.encrypt(message) -> Network -> Server (Ejona) -> DES_Util.decrypt(message) -> Shfaqje plaintext


## Udhezime per nisje

### Per serverin (Ejona):

1. Run `Server.java`.
2. Krijo tunel me serveo.net:

   
   ssh -R 0:localhost:4000 serveo.net
   

3. Merr IP dhe portin qe e jep serveo.net.

### Per klientin (Edonita):

1. Perdor IP dhe portin e dhene nga Ejona.
2. Run `Client.java`.
3. Fillon komunikimi i enkriptuar.

## Shenime te rendesishme

- Serveri duhet te jete gjithmone i nisur para klientit.
- IP dhe Porti duhen kontrolluar qe te jene korrekt.
- Mos e mbyllni tunelin derisa komunikimi te jete aktiv.

## Perfundim

Projekti eshte realizuar me sukses duke arritur qellimin e komunikimit te sigurt ne rrjet.

