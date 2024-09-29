//> using dep "taggy:taggy:1.0.1,url=https://github.com/bjornregnell/taggy/releases/download/v1.0.1/taggy_3-1.0.1.jar"
//> using scala "3.5.1"

//  run this command in terminal to create slides in target/out.pdf 
//  scala-cli run .

import taggy.*

def and = "\\&"
def nl = "~\\\\{}"

@main def run = slides.toPdf(out = "ai-inside-bjorn-regnell")

def slides = document("Hur funkar AI?", author = "Björn Regnell"):
  frame("Vem är jag?"):
    image(file = "../img/br.jpg", width = 0.2)
    itemize:
      p("Björn Regnell, professor i programvarusystem")
      p("Institutionen för datavetenskap, LTH, Lunds universitet https://cs.lth.se/bjorn-regnell/")
      p("Forskning: kravhantering, programvarukvalitet")
      p(s"Undervisning: programmering, kravhantering")
      p("Medlem i kommittén för programmeringsspråket Scala: https://www.scala-lang.org/community/#gov-sip")

  frame("Hur brukar man förklara artificiell intelligens (AI)?"):
    p("Ofta beskrivs AI genom dess smarta egenskaper")
    itemize: 
      p(s"Exempel från BBC: $nl ''What is AI, how does it work and what can it be used for?'' https://www.bbc.com/news/technology-65855333")
      p(s"Exempel från SVT: ''Generation AI'' $nl  https://www.svtplay.se/generation-ai")
    p("Alltför sällan förklaras hur AI ser ut inuti...")
    itemize:
      p("Denna presentation visar hur en **pytteliten AI** fungerar.")
      p("En mer avancerad AI fungerar på liknande sätt men är MYCKET större och har tränats på MYCKET mer data.")

  frame(s"Olika typer av Artificiell Intelligens"):
    itemize:
      p("**Symbolisk AI**")
      itemize:
        p("skapad med ''normal'' programkod som människor skrivit som använder ''smarta'' algoritmer som människor uppfunnit")
        p("koden kan granskas och förklaras")
        p("Exempel: regelbaserade expertsystem, automatiska bevis")
      p("**Maskininlärning (ML)**")
      itemize:
        p("en ''lärande'' algoritm skapar automatiskt ett program genom träning på en tillräckligt stor datamängd")
        p("svårt att förstå och förklara resultatet")
        p("beteende blir delvis slumpartat")
        p("implementeras ofta med hjälp av **neurala nätverk**")
        p("Exempel: stora språkmodeller så som ChatGPT")
    p("https://sv.wikipedia.org/wiki/Artificiell_intelligens")

  frame("Vårt uppdrag"):
    p("Bygg en AI i form av ett neuralt nätverk som kan")
    itemize: 
      p("avgöra om en person är en **man eller kvinna**")
      p("baserat på data om *längd och vikt*")

  frame("Träningsdata och testdata"):
    image(file = "../img/data", width = 1.0)

  frame("En mänsklig hjärncell"):
    image(file = "../img/neuron", width = 1.0)

  frame("En starkt förenklad modell av en hjärncell"):
    p(s"Uppfinnare: Warren McCull $and  Walter Pitts (1943)")
    p("Exempel: 3 insignaler, 4 parametrar: 3 vikter + bias")
    image(file = "../img/artificial-neuron", width = 0.8)
    code("output = S(x1*w1 + x2*w2 + x3*w3 + bias)")

  frame("Ett litet neuralt nätverk"):
    image(file = "../img/ai-network", width = 1.0)
    p("Ett nätverk med 3 lager, 6 neuroner, 20 parametrar")

  frame("Hur går träningen till?"):
    enumerate:
      p("Ge alla parametrar ett slumpmässigt startvärde.")
      p("Ge ny träningsdata som input.")
      p("Beräkna **felet**: ''avståndet'' mellan output och korrekt värde.")
      p("Välj en slumpmässig neuron och **justera** dess parametrar slumpmässigt; förändringsstorleken styrs av en *lärfaktor*.")
      p("Beräkna nya felet efter justeringen.")
      p("**Om** felet är mindre efter justering **så** behåll de nya parametrarna **annars** återställ parametrarna.")
      p("Upprepa från punkt 2 lagom många gånger.")


  frame("Hur ser programkoden ut?"):
    p("Ett Scala-program med modellen och träningen på ca 200 rader")
    itemize:
      p("https://github.com/bjornregnell/scai")
      p("Kör koden i din webbläsare här: https://scastie.scala-lang.org/UN0hBkX2RMeHsle1DYLw0Q")

  frame("Vad skiljer vårt simpla nätverk från ChatGPT?"):
    itemize:
      p("Vårt nätverk")
      itemize:
        p("6 neuroner, 20 parametrar, tränad på 4 datapunkter")
        p("tränad på en enda vanlig knädator")
      p("ChatGPT 3.5")
      itemize:
        p(s"175 miljarder parametrar, tränad på **jättemycket** data $nl (ca 300 miljarder ord och ca 10,000 specialdatorer)")
        p("Baserad på en **språkmodell** som tar ord som indata och ger troligaste efterföljande ord som utdata.")
      p("Vad betyder GPT?")
      itemize:
        p("**Generative**: Genererar ny utdata medan den tar hänsyn till ett existerande sammanhang.")
        p("**Pre-trained**: Har i förväg tränats på jättestora textmängder, inkl. hela Wikipedia, och allmänt tillgängliga internet.")
        p("**Transformer**: Kan hantera sekvenser av ord, värdera kopplingar mellan ord och avgöra vilka ord som är viktigast")

  frame("Inga billiga datorer..."):
    image(file = "../img/berzelius", width = 1.0)

  frame("AI-forskare har förfinat träningen i många steg"):
    image(file = "../img/chatgpt-steps", width = 1.05)

  frame("Några problem med dagens maskininlärning"):
    p("Även om den *verkar* smart så *förstår* den inget!")
    p("(Beroende på vad vi menar med *förstår*...)")
    itemize:
      p("**Bias**: fördomsfull AI.")
      p("**Överträning**: kan ej generalisera bortom träningsdata.")
      p("Det är inte lätt att få stora modeller att bli bra.")
      p("Kan plötsligt börja ''**hallucinera**'' -- spotta ur sig hittepå.")
      p("Svårt att förhindra olämplig eller rent oacceptabel utdata.")
      p("Kan inte själv avgöra vad som är rimligt.")
      p("Är väldigt övertygande även när den har helt fel.")
      p("Svårt genomskåda hur nätverket fungerar: *explainability*.")
      p("Om AI tränas på mänskligt beteende kan det bli enklare att **manipulera** oss.")

  frame("Slutsatser"):
    itemize:
      p("Den som **lär sig programmera** kan förstå och skapa AI.")
      p("Vi behöver **demokratisera** tillgången till AI.")
      p("AI behöver **regleras** för att skydda oss från manipulation.")

  frame("Tack!"):
    textSize(10,10) 
    itemize:
      p(s"Denna presentation: https://github.com/bjornregnell/AI-inside/")
      p(s"En längre presentation som också diskuterar konsekvenser för samhälle och högre utbildning: https://github.com/bjornregnell/AI-taking-over")
