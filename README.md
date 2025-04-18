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

