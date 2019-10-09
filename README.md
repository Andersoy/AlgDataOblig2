# Obligatorisk oppgave 1 i Algoritmer og Datastrukturer

Denne oppgaven er en innlevering i Algoritmer og Datastrukturer. 
Oppgaven er levert av følgende studenter:
* Anders Oeyrehagen, S331398, s331398@oslomet.no
* Anders Magnus Ytterboee, S330474, S330474@oslomet.no
* Tommy Grut, S330473, S330473@oslomet.no
* Tobias Dyre Evju, S331386, S331386@oslomet.no
* Theodor Fredheim Aandal, S331359, S331359@oslomet.no


# Arbeidsfordeling

I oppgaven har vi hatt følgende arbeidsfordeling:
* Anders Oyrehagen har hatt hovedansvar for oppgave 9 og 10 og bidratt på alle oppgaver.
* Anders Magnus Ytterboee har hatt hovedansvar for oppgave 4, 5 og bidratt på oppgave 1 og 2.
* Tommy Grut har hatt hovedansvar for oppgave 0 og 8, og bidratt på oppgave 6. Han hadde problemer med å få github til
* å fungere og har derfor ikke committet.
* Tobias Dyre Evju har hatt hovedansvar for 1, 2 og 3 og bidratt på alle oppgaver.(har hatt problemer med datamaskinen
* og har derfor ikke fått committet.)
* Theodor Fredheim Aandal har hatt hovedansvar for oppgave 6 og 7.
* Vi har i fellesskap jobbet med de fleste oppgavene sammen.

* Da vi misforsto hvordan vi skulle bruke noder tidlig i oppgaven har vi derfor løst oppgaven litt annerledes.
* Alle oppgaver kjører fint, men vi var nødt til å forandre "private DobbeltLenketListeIterator()"-metoden som det sto på
* canvas at ikke skulle forandres. Vi fikk tillatelse av Andre til å gjøre dette.


*resultat av kjøringen av koden:

/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/bin/java -ea -Didea.test.cyclic.buffer.size=1048576 "-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=52605:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath "/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar:/Applications/IntelliJ IDEA CE.app/Contents/plugins/junit/lib/junit-rt.jar:/Applications/IntelliJ IDEA CE.app/Contents/plugins/junit/lib/junit5-rt.jar:/Users/andersoyrehagen/.m2/repository/org/junit/platform/junit-platform-launcher/1.5.2/junit-platform-launcher-1.5.2.jar:/Users/andersoyrehagen/.m2/repository/org/apiguardian/apiguardian-api/1.1.0/apiguardian-api-1.1.0.jar:/Users/andersoyrehagen/.m2/repository/org/junit/platform/junit-platform-engine/1.5.2/junit-platform-engine-1.5.2.jar:/Users/andersoyrehagen/.m2/repository/org/opentest4j/opentest4j/1.2.0/opentest4j-1.2.0.jar:/Users/andersoyrehagen/.m2/repository/org/junit/platform/junit-platform-commons/1.5.2/junit-platform-commons-1.5.2.jar:/Users/andersoyrehagen/.m2/repository/org/junit/jupiter/junit-jupiter-engine/5.5.2/junit-jupiter-engine-5.5.2.jar:/Users/andersoyrehagen/.m2/repository/org/junit/jupiter/junit-jupiter-api/5.5.2/junit-jupiter-api-5.5.2.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/charsets.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/deploy.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/cldrdata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/dnsns.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/jaccess.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/jfxrt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/localedata.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/nashorn.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/sunec.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/sunjce_provider.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/sunpkcs11.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/ext/zipfs.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/javaws.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/jce.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/jfr.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/jfxswt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/jsse.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/management-agent.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/plugin.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/resources.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/jre/lib/rt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/ant-javafx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/dt.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/javafx-mx.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/jconsole.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/packager.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/sa-jdi.jar:/Library/Java/JavaVirtualMachines/jdk1.8.0_171.jdk/Contents/Home/lib/tools.jar:/Users/andersoyrehagen/Downloads/Oblig2/out/production/Oblig2" com.intellij.rt.execution.junit.JUnitStarter -ideVersion5 -junit5 no.oslomet.cs.algdat.DobbeltLenketListeTest
Oppgave 6zg: Ineffektiv kode! Har du kodet den ene fjern-metoden
ved hjelp av den andre? Eller så er en av fjern-metodene dine litt treg.

Process finished with exit code 0

* Oppgave 6zg sin feilmelding kommer kun når koden kjøres på én av maskinene. Feilmelding kommer ikke når koden kjøres
* på datamaskinene til de andre på gruppa. Har derfor valgt å la den stå.



