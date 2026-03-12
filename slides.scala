//> using dep "taggy:taggy:1.0.1,url=https://github.com/bjornregnell/taggy/releases/download/v1.0.1/taggy_3-1.0.1.jar"
//> using scala 3.8

//  run this command in terminal to create slidesSwedish in target 
//  scala-cli run .

import taggy.*

def and = "\\&"
def nl = "~\\\\{}"

def wikipediaAI_sv = "https://sv.wikipedia.org/wiki/Artificiell_intelligens"
def wikipediaAI_en = "https://en.wikipedia.org/wiki/Artificial_intelligence"
def wikipediaSAI_en = "https://en.wikipedia.org/wiki/Symbolic_artificial_intelligence"
def bjornImgPath = "../img/br.jpg"

@main def run = 
  slidesSwedish.toPdf(out = "ai-inside-bjorn-regnell-sv")
  slidesEnglish.toPdf(out = "ai-inside-bjorn-regnell-en")

def slidesSwedish = document("Hur funkar AI?", author = "Björn Regnell"):
  frame("Vem är jag?"):
    image(file = bjornImgPath, width = 0.2)
    itemize:
      p("Björn Regnell, professor i programvarusystem")
      p("Institutionen för datavetenskap, LTH, Lunds universitet https://cs.lth.se/bjorn-regnell/")
      p("Forskning: kravhantering, programvarukvalitet")
      p(s"Undervisning: programmering, kravhantering")
      p("Medlem i kommittén för programmeringsspråket Scala: https://docs.scala-lang.org/sips/process-specification.html#the-sip-committee")

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
    p(wikipediaAI_sv)
    p(wikipediaSAI_en)

  frame("Vårt uppdrag"):
    p("Bygg en liten AI som kan")
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
      p("Installera Scala och kör på din egen dator: https://www.scala-lang.org/download/")
      p("Kör koden i din webbläsare här: https://scastie.scala-lang.org/AMRk3JkJQuaFAij6uJ4InQ")
      p("En prototyp som visualiserar nätverket: https://github.com/Eryndir/vscAi")

  frame("Vad skiljer vårt simpla nätverk från ChatGPT?"):
    itemize:
      p("Vårt nätverk")
      itemize:
        p("6 neuroner, 20 parametrar, tränad på 4 datapunkter")
        p("tränad på en vanlig knädator")
      p("ChatGPT 5")
      itemize:
        p("Baserad på en **språkmodell** som tar ord som indata och ger mest sannolika efterföljande ord som utdata.")
        p("En mer avancerad  träningsalgoritm i flera steg.")
        p(s"Ett nätverk med mer än $$10^{12}$$ parametrar (1000 miljarder).")
        p(s"Tränad på **jättemycket** data (hemligt, minst $$10^{13}$$ ord)")
        p(s"På **jättemånga jättesnabba jättedyra** datorer (ca 100 000 GPU:er, minst 200 GWh).")
      p("Vad betyder GPT?")
      itemize:
        p("**Generative**: Genererar ny utdata medan den tar hänsyn till ett existerande sammanhang.")
        p("**Pre-trained**: Har i förväg tränats på jättestora textmängder, inkl. hela Wikipedia, och allmänt tillgängliga internet.")
        p("**Transformer**: Kan hantera sekvenser av ord, värdera kopplingar mellan ord och avgöra vilka ord som är viktigast.")

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

  frame("Tack!"):
    textSize(10,10) 
    itemize:
      p(s"Denna presentation: https://github.com/bjornregnell/AI-inside/")

def slidesEnglish = document("How does AI work?", author = "Björn Regnell"):
  frame("Who am I?"):
    image(file = bjornImgPath, width = 0.2)
    itemize:
      p("Björn Regnell, professor in Software Engineering")
      p("Department of Computer Science, LTH, Lund University https://cs.lth.se/bjorn-regnell/")
      p("Research: Requirements Engineering, Software Quality")
      p(s"Teaching: Programming, Requirements Engineering")
      p("Member of the committee for the Scala programming language: https://docs.scala-lang.org/sips/process-specification.html#the-sip-committee")

  frame("How is artificial intelligence (AI) usually explained?"):
    p("AI is often described through its smart properties")
    itemize:
      p(s"Example from BBC: $nl ''What is AI, how does it work and what can it be used for?'' https://www.bbc.com/news/technology-65855333")
      p(s"Example from SVT: ''Generation AI'' $nl  https://www.svtplay.se/generation-ai")
    p("Too rarely is it explained what AI looks like inside...")
    itemize:
      p("This presentation shows how a **tiny AI** works.")
      p("A more advanced AI works in a similar way but is MUCH larger and has been trained on MUCH more data.")

  frame(s"Different types of Artificial Intelligence"):
    itemize:
      p("**Symbolic AI**")
      itemize:
        p("created with ''normal'' code written by humans using ''smart'' algorithms invented by humans")
        p("the code can be inspected and explained")
        p("Examples: rule-based expert systems, automated proofs")
      p("**Machine Learning (ML)**")
      itemize:
        p("a ''learning'' algorithm automatically creates a program by training on a sufficiently large dataset")
        p("difficult to understand and explain the result")
        p("behavior becomes partially random")
        p("often implemented using **neural networks**")
        p("Examples: large language models such as ChatGPT")
    p(wikipediaAI_en)
    p(wikipediaSAI_en)

  frame("Our mission"):
    p("Build a small AI that can")
    itemize:
      p("determine if a person is **male or female**")
      p("based on data about *height and weight*")

  frame("Training data and test data"):
    image(file = "../img/data", width = 1.0)

  frame("A human brain cell"):
    image(file = "../img/neuron", width = 1.0)

  frame("A greatly simplified model of a brain cell"):
    p(s"Inventors: Warren McCulloch $and Walter Pitts (1943)")
    p("Example: 3 input signals, 4 parameters: 3 weights + bias")
    image(file = "../img/artificial-neuron", width = 0.8)
    code("output = S(x1*w1 + x2*w2 + x3*w3 + bias)")

  frame("A small neural network"):
    image(file = "../img/ai-network", width = 1.0)
    p("A network with 3 layers, 6 neurons, 20 parameters")

  frame("How does training work?"):
    enumerate:
      p("Give all parameters a random initial value.")
      p("Feed new training data as input.")
      p("Calculate the **error**: the ''distance'' between output and correct value.")
      p("Select a random neuron and **adjust** its parameters randomly; the change magnitude is controlled by a *learning rate*.")
      p("Calculate the new error after adjustment.")
      p("**If** the error is smaller after adjustment **then** keep the new parameters **otherwise** restore the parameters.")
      p("Repeat from step 2 an appropriate number of times.")

  frame("What does the program code look like?"):
    p("A Scala program with the model and training in approx. 200 lines")
    itemize:
      p("https://github.com/bjornregnell/scai")
      p("Install Scala and run on your own computer: https://www.scala-lang.org/download/")
      p("Run the code in your browser here: https://scastie.scala-lang.org/AMRk3JkJQuaFAij6uJ4InQ")
      p("A prototype that visualizes the network: https://github.com/Eryndir/vscAi")

  frame("What distinguishes our simple network from ChatGPT?"):
    itemize:
      p("Our network")
      itemize:
        p("6 neurons, 20 parameters, trained on 4 data points")
        p("trained on a regular laptop")
      p("ChatGPT 5")
      itemize:
        p("Based on a **language model** that takes words as input and gives the most probable following word as output.")
        p("A more advanced training algorithm in multiple steps.")
        p(s"A network with more than $$10^{12}$$ parameters (1000 billion).")
        p(s"Trained on **enormous amounts** of data (secret, at least $$10^{13}$$ words)")
        p(s"On ** enormously fast and expensive** computers (approx. 100,000 GPUs, at least 200 GWh).")
      p("What does GPT stand for?")
      itemize:
        p("**Generative**: Generates new output while taking an existing context into account.")
        p("**Pre-trained**: Has been pre-trained on enormous amounts of text, incl. all of Wikipedia, and the publicly available internet.")
        p("**Transformer**: Can handle sequences of words, evaluate connections between words and determine which words are most important.")

  frame("No cheap computers..."):
    image(file = "../img/berzelius", width = 1.0)

  frame("AI researchers have refined the training in many steps"):
    image(file = "../img/chatgpt-steps", width = 1.05)

  frame("Some problems with today's machine learning"):
    p("Even though it *seems* smart, it *understands* nothing!")
    p("(Depending on what we mean by *understands*...)")
    itemize:
      p("**Bias**: biased AI.")
      p("**Overfitting**: cannot generalize beyond training data.")
      p("It is not easy to make large models good.")
      p("Can suddenly start ''**hallucinating**'' -- making things up.")
      p("Difficult to prevent inappropriate or outright unacceptable output.")
      p("Cannot itself determine what is reasonable.")
      p("Is very convincing even when completely wrong.")
      p("Difficult to see through how the network works: *explainability*.")
      p("If AI is trained on human behavior it may become easier to **manipulate** us.")

  frame("Thank you!"):
    textSize(10,10)
    itemize:
      p(s"This presentation: https://github.com/bjornregnell/AI-inside/")