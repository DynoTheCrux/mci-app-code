AndroidStudio
=============

AndroidStudio ist die offizielle <span acronym-label="IDE"
acronym-form="singular+abbrv">IDE</span> von Google zur Entwicklung von
Apps für auf Android basierte Endgeräte (Smartphones, SmartTVs,
Wearables, In-Car Entertainment, ...). Die Programmiersprache ist
`Java`.

Neues Projekt
=============

Nach dem Start von AndroidStudio erscheint der Wilkommensbildschirm wo
bestehende Projekte geöffnet bzw. ein neues Projekt erstellt werden
kann.

``` menu
Create New Project
```

<figure>
<img src="../assets/img/welcome.png" id="fig:000_welcome" alt="Willkommensbildschirm" /><figcaption aria-hidden="true">Willkommensbildschirm</figcaption>
</figure>

Im nächsten Fenster kann das Projekt mit verschiedenen vordefinierten
Ansichten gestartet werden.

``` menu
Empty Activity
```

<figure>
<img src="../assets/img/new_project.png" id="fig:001_new_project" alt="Dialog &quot;Neues Projekt&quot;" /><figcaption aria-hidden="true">Dialog "Neues Projekt"</figcaption>
</figure>

Abbildung
<a href="#fig:000_001" data-reference-type="ref" data-reference="fig:000_001">[fig:000_001]</a>
zeigt die vorzunehmenden Einstellungen. Der Speicherort kann zwar
prinzipiell frei gewählt werden, aber die Erfahrung zeigt, dass Pfade
ohne Leerzeichen am Besten funktionieren.

```
Location: C:\Android\StudioProjects\AndroidTutorial
```

Im nächsten Fenster wird ausgewählt, auf welchen Produkten das App
später laufen soll. Bei der Auswahl des "Minimum <span
acronym-label="SDK" acronym-form="singular+abbrv">SDK</span>" errechnet
AndroidStudio automatisch auf welchem Prozentsatz der Android Geräte das
App ausgeführt werden kann. Werden spezielle Features der neueren
Android Versionen nicht benötigt, so kann auch eine ältere Version verwendet werden. Für unsere Zwecke ist am Besten eine aktuelle Version geeignet.

``` menu
Minimum SDK: API 29: Android 10.0 (Q)
```

``` menu
Finish
```

<figure>
<img src="../assets/img/main_view.png" id="fig:002_main_view" alt="Hauptfenster von AndroidStudio." /><figcaption aria-hidden="true">Hauptfenster von AndroidStudio.</figcaption>
</figure>

Abbildung
<a href="#fig:002_main_view" data-reference-type="ref" data-reference="fig:002_main_view">3</a>
zeigt die Hauptansicht von AndroidStudio. Rechts befindet sich die
Projektstruktur und im linken Teil befindet sich der geöffnete Editor.
Der Einstiegspunkt der App ist die Datei `MainActivity.java`.

Eine Übersicht über das Programmfenster und die Funktionen bietet die
[offizielle Dokumentation](https://developer.android.com/studio/intro/index.html).

MainActivity und Lifecycle
--------------------------

Ansichten (vgl. Programmfenster) in Android heißen "Activities" und
sind alle direkte oder indirekte Subklassen von `Activity`. In unserem Fall ist die ``MainActivity`` eine direkte Subklasse von ``AppCompatActivity``.

``` java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

Listing
<a href="#lst:mainactivity.java" data-reference-type="ref" data-reference="lst:mainactivity.java">[lst:mainactivity.java]</a>
zeigt die den Programmcode der neu erstellten Hauptansicht
`MainActivity` die eine Subklasse der von Android definierten
`AppCompatActivity` ist. Die Methode `onCreate` ist eine von mehreren
"Lifecycle"-Methoden:

-   `onCreate()`

-   `onStart()`

-   `onResume()`

-   `onRestart()`

-   `onPause()`

-   `onStop()`

-   `onDestroy()`

Über Lifecycle-Methoden wird eine Activity vom Betriebssystem informiert
in welchem Zustand sie sich gerade befindet. Abbildung
<a href="#fig:activity_lifecycle" data-reference-type="ref" data-reference="fig:activity_lifecycle">5</a>
zeigt das Zustandsdiagramm einer Activity mit den jeweiligen
Lifecycle-Methoden.

Die Aufgabe einer App "Stock market" ist beispielsweise die Anzeige von
möglichst aktuellen Aktiendaten. Deshalb stellt die Activity der App
eine Verbindung zu einem Webservice her und aktualisiert die Daten jede
Sekunde. Ungeduldige Banker wollen diese App öffnen und sofort über die
Lage am Aktienmarkt informiert sein. Die Activity muss die Verbindung
zum Webservice also herstellen sobald sie angezeigt wird. Dafür eignet
sich beispielsweise die Lifecycle-Methode `onCreate()`, die sofort nach
dem Start ausgeführt wird. Andererseits sollen die Daten nicht mehr im
Sekundentakt aktualisiert werden wenn sich die App im Hintergrund
befindet. Dafür könnte in der Methode `onStop()` eine Drosselung
implementiert werden.

<figure>
<img src="../assets/img/activity_lifecycle1.png" id="fig:activity_lifecycle" alt="Zustandsdiagramm einer Activity mit Lifecycle-Methoden." /><figcaption aria-hidden="true">Zustandsdiagramm einer Activity mit Lifecycle-Methoden.<span class="citation" data-cites="androidlifecycle"></span></figcaption>
</figure>

`onCreate(...)` in `MainActivity` überschreibt die Methode aus der
Superklasse. Code in `AppCompatActivity.onCreate(...)` würde also nicht
ausgeführt werden. Der Aufruf von `super.onCreate(...)` ruft deshalb
explizit die Methode in der Superklasse auf. **Es ist Konvention beim
Überschreiben von Lifecycle-Methoden auch Code in der Superklasse
mittels** `super.methode()` **aufzurufen**.

Der Aufruf `setContentView(...)` legt das Layout der Ansicht fest. Mehr
dazu später.

Der Emulator
------------

Das erstellte Projekt kann bereits auf die Hardware überspielt und
ausgeführt werden. In der frühen Entwicklungsphase bietet es sich jedoch
an, den Android Emulator zu benutzen. Diese virtualisierte Hardware
verhält sich fast genau wie das reale Pendant und ist ein wichtiges
Werkzeug zum Testen des Programms. Die Tastenkombination

``` menu
Shift + F10
```

oder der Klick auf den grünen Play-Button startet den
Hardware-Auswahldialog, falls noch kein Emulator vorhanden ist. Mit "Create New Emulator" kann ein neuer
Emulator erstellt werden. Abbildung
<a href="#fig:003_new_emulator" data-reference-type="ref" data-reference="fig:003_new_emulator">6</a>
zeigt den Dialog nach Auswahl von Gerät `Pixel 3a` und System
`Android 11 (x86)`.

<figure>
<img src="../assets/img/new_emulator.png" id="fig:003_new_emulator" />
</figure>

<figure>
<img src="../assets/img/hello_world.png" id="fig:004_hello_world" />
</figure>

  

Nun kann der erstellte Emulator als Zielgerät ausgewählt werden und nach
dem Startvorgang erscheint das virtuelle Smartphone mit dem gestarteten
Projekt (Abbildung
<a href="#fig:004_hello_world" data-reference-type="ref" data-reference="fig:004_hello_world">7</a>).

Der Layout Editor
-----------------

Aufmerksame Naturen werden sich bereits über den angezeigten Text "Hello
World" (Abbildung
<a href="#fig:004_hello_world" data-reference-type="ref" data-reference="fig:004_hello_world">7</a>)
gewundert haben, da im Programmcode davon nichts zu finden ist. Ein
wichtiger Design-Grundsatz in Android ist die Trennung von Anzeige und
Programmlogik. Der Code in `MainActivity` (Listing
<a href="#lst:mainactivity.java" data-reference-type="ref" data-reference="lst:mainactivity.java">[lst:mainactivity.java]</a>)
hat (optimalerweise) keinen Einfluss auf das Design und die angezeigten
Elemente.

Für den angezeigten Inhalt ist das Layout zuständig das in der Datei
`activity_main.xml` definiert ist und unter `res\layout` zu finden ist.
Hier findet sich auch das Text-Element "Hello World".

Für eine Einführung in den Layout-Editor wird an dieser Stelle auf die
[Android Dokumentation](https://developer.android.com/studio/write/layout-editor.html) in verwiesen. Abbildung
<a href="#fig:005_layout_editor" data-reference-type="ref" data-reference="fig:005_layout_editor">8</a>
zeigt das fertige Layout für die nächsten Schritte. Dort sind 2 Textfelder sowie 2 Buttons enthalten: 
- txtCounter (TextView)
- txtCounterValue (TextView)
- btnStart (Button)
- btnStop (Button)

<figure>
<img src="../assets/img/layout_editor.png" id="fig:005_layout_editor" alt="Layout für Tutorial." /><figcaption aria-hidden="true">Layout für Tutorial.</figcaption>
</figure>

Verbindung zwischen Layout und Programm
---------------------------------------

Damit das Layout nicht bloß angezeigt sondern auch mit Logik versehen
werden kann, muss eine Verbindung zwischen <span acronym-label="GUI"
acronym-form="singular+abbrv">GUI</span>-Elementen und dem Programmcode
hergestellt werden. Dies geschieht in Android mit Hilfe des
Reflection-Objekts `R`. Dieses wandelt Elemente aus der Layout-Datei im
<span acronym-label="XML"
acronym-form="singular+abbrv">XML</span>-Format in ein Java-Objekt um.
Mit der Funktion `findByViewId(id)` können Elemente aus dem Layout in
den Programmcode geladen und verändert werden. Listing
<a href="#lst:layout_connect" data-reference-type="ref" data-reference="lst:layout_connect">[lst:layout_connect]</a>
veranschaulicht dies.

``` java
public class MainActivity extends AppCompatActivity {

    // define variables representing the layout elements
    Button btnStart, btnStop;
    TextView txtCounterValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // set linked layout
        setContentView(R.layout.activity_main);

        // connect layout elements to program variables
        txtCounterValue = (TextView) findViewById(R.id.txtCounterValue);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);

        // change some properties
        txtCounterValue.setTextColor(Color.RED);
        txtCounterValue.setText("something");
    }
}
```

<figure>
<img src="../assets/img/layout_link_before.png" id="fig:006_layout_link_before" />
</figure>

<figure>
<img src="../assets/img/layout_link_after.png" id="fig:006_layout_link_after" />
</figure>

  

Android Library "rtloop"
========================

``` c
int _value;

int main(int argc, char *argv[])
{ 
    // do some initialization stuff
    
    while(1) { // loop infinitely
    
        // do something with _value
        
    }
}

void interrupt_handler(void)
{
    _value = // get value from some interface
}
```

Listing
<a href="#lst:main.c" data-reference-type="ref" data-reference="lst:main.c">[lst:main.c]</a>
zeigt die typische Struktur eines in `C` geschriebenen Programms für
einen Microcontroller. Aus diesem Aufbau sind unterschiedliche
Strukturen ersichtlich:

-   Einstiegspunkt

-   Setup

-   Endlos-Schleife

-   Asynchrone Events

-   Programmende

Beim Start des Programms (`main`) werden Initialisierungen (Ports,
Schnittstellen, ...) durchgeführt. In der Endlos-Schleife wird die
Hauptaufgabe des Programms (Daten holen/verarbeiten/speichern) zyklisch
ausgeführt. Nebenbei werden durch Events (Button gedrückt, Counter Wert
erreicht, ...) ausgelöste, asynchrone Arbeiten ausgeführt.

Auch PC Programme und sogar der PC selbst läuft prinzipiell nach diesem
Schema ab (Bootvorgang, Betriebssystem ausführen, Asynchrone Eingaben
verarbeiten). Allerdings steigt die Komplexität mit steigender
Abstraktion von der Hardware-Ebene erheblich an. So läuft ein Programm
in einem Betriebssystem nie alleine, darf also nicht einfach eine naive
`while(1)`-Schleife implementieren weil dadurch die gesamte <span
acronym-label="CPU" acronym-form="singular+abbrv">CPU</span>-Zeit von
einem Programm beschlagnahmt werden würde.

In diesem Kurs wird deshalb die Basis für die Ausführung eines Programms
nach dem Schema eines Microcontrollers in Form der Android Library
"rtloop" bereit gestellt. Diese Library beinhaltet alle benötigten
Programmteile um eine "normale" Activity möglichst einfach nach oben
gezeigten Schema implementieren zu können ohne sich mit den Details
befassen zu müssen.

FixedPeriodLooper
-----------------

Die Klasse `FixedPeriodLooper` stellt das Grundgerüst dar. Listing
<a href="#lst:FixedPeriodLooper" data-reference-type="ref" data-reference="lst:FixedPeriodLooper">[lst:FixedPeriodLooper]</a>
zeigt den grundsätzlichen Aufbau der Klasse. Die Ausführungszeit der
Loop wird überwacht und bei Zeitüberschreitung wird eine Warnung
ausgegeben (Soft-Realtime).

``` java
class FixedPeriodLooper {
    int period;
    FixedPeriodLooper(int period) { // set cycle time
        this.period = period;
    }

    void setup() {
        // perform setup tasks
    }
    
    void loopFixed() {
        // perform repeating tasks with fixed rate
    }
    
    void tearDown(boolean error) {
        if(!error) {
            // Perform cleanup when finished normally
        } else {
            // Perform cleanup/logging/analysis in case of error
        }
    }
}
```

FixedRateLoopActivity
--------------------

Der oberste Grundsatz eines Programms mit <span acronym-label="GUI"
acronym-form="singular+abbrv">GUI</span> ist, dass die UI zu jedem
Zeitpunkt auf Eingaben reagieren muss (engl.: Responsiveness). Den
Effekt, wenn das nicht der Fall ist, kennt man wenn ein Programm
"einfriert". Deshalb ist es wichtig, dass direkt in der Activity kein
Code ausgeführt wird, der durch zu lange Ausführungszeiten die UI
blockieren kann.

Die Activity `FixedRateLoopActivity` ist eine Subklasse von
`AppCompatActivity` (vgl. `MainActivity`) und stellt die Funktionalität
zum Ausführen eines `FixedPeriodLooper`s im Hintergrund bereit, d.h.
ohne Blockieren der UI. Sie stellt Methoden zum Steuern der
Schleifenausführung zur Verfügung:

-   loopStart()

-   loopStop()

-   loopPause()

-   loopResume()

-   loopReset()

und bietet Lifecycle-Methoden an, um auf Statusänderungen (z.B. Abbruch
bei Fehler) reagieren zu können:

-   onLoopCreate()

-   onLoopStart()

-   onLoopPause()

-   onLoopResume()

-   onLoopStop()

Implementierung
---------------

Zuallererst muss das Modul "rtloop" in unser Programm geladen werden. Dazu kann im Menu unter
``` menu
File -> New -> Import Module ...
```
das Modul eingebunden werden (Entpacken nicht vergessen). 

Um die rtloop-Library im Hauptprogramm verwenden zu können muss diese
zuerst verknüpft werden. Unter "Gradle Scripts" befindet sich eine Datei
"build.gradle (Module: app)". In dieser muss bei "dependencies" Zeile 8
ergänzt werden:

```
dependencies {
    implementation 'androidx.appcompat:appcompat:1.2.0'
    implementation 'com.google.android.material:material:1.2.1'
    implementation 'androidx.constraintlayout:constraintlayout:2.0.4'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
    implementation ':rtloop'
}
```

Anschließend muss das Project mit den Menüpunkten

``` menu
Tools -> Android -> Sync Project with Gradle Files
```

und

``` menu
Build -> Make Project (Ctrl + F9)
```

neu kompiliert werden. Nun kann die Library im Hauptprogramm verwendet
werden.

Statt `AppCompatActivity` wird nun `FixedRateLoopActivity` als
Superklasse verwendet:

``` java
public class MainActivity extends FixedRateLoopActivity { // change from AppCompatActivity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
```

Als Nächstes wird Start und Stop der Loop auf die beiden Buttons gelegt.
Dafür werden auf die Buttons sogenannte "Listeners" gesetzt. Listeners
können mit Interrupts verglichen werden und führen bestimmte Methoden
bei Auftreten von definierten Ereignissen (Events) aus. Als Ereignis
bietet sich hier "Button geklickt" an. Der Listener für das Event
`OnClick` wird über die Methode `setOnClickListener()` erstellt. Das
Namensschema dieser Methoden ist immer "setOn*Event*Listener" bzw.
"addOn*Event*Listener" je nachdem ob nur ein oder mehrere Listener
gleichzeitig erlaubt sind.

Unter der Zuweisung der Buttons in `onCreate` werden also die Listener
hinzugefügt und `loopStart()` bzw. `loopStop()` darin aufgerufen:

``` java
protected void onCreate(Bundle savedInstanceState) {
    // ... some more code above

    btnStart = (Button) findViewById(R.id.btnStart);
    btnStop = (Button) findViewById(R.id.btnStop);
    
    // add onClick listeners
    btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // this code will be executed when start is clicked
                loopStart();
            }
        });
    btnStop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // this code will be executed when stop is clicked
            loopStop();
        }
    });
    // ... some more code below
}
```

Um zu sehen ob die Schleife läuft oder steht wird nun noch der Zählwert
`txtCounterValue` in der Titelleiste pro Zyklus aktualisiert. Dafür müssen die beiden Methoden ``loopSetup`` und ``loopIteration`` überschrieben (override) werden.

``` java
@Override
protected void loopSetup() {
    score = 0;
    snakeView.setup(20,30,5,true, 10, 20);
    snakeView.start();
}

@Override
protected void loopIteration() {
    score++;
    setWidgetText(txtCounter, String.valueOf(snakeView.getScore()));

    GameState state = snakeView.update();
    if(state == GameState.GameOver) {
        loopStop();
    }
}
```

Die Methode `setWidgetText(TextView,String)` ist eine Methode aus
`FixedRateLoopActivity` und wurde eingeführt, da durch eine Besonderheit
von Android das User Interface nur direkt von der Activity geändert
werden darf. Änderungen z.B. aus Lifecycle-Methoden müssen deshalb den
Umweg über von der Activity bereitgestellte Methoden nehmen.

### Counter Pause/Resume

Um die Lifecycle Methoden der Loop zu demonstrieren, wird eine
Pause-Funktion implementiert: Wenn der Counter gestartet wurde, soll
sich die Beschriftung des Start-Buttons auf "Pause" ändern und ein Klick
soll den Counter pausieren. Sobald der Counter pausiert ist, soll sich
die Beschriftung auf "Resume" ändern und so weiter wie in Abbildung
<a href="#fig:loop_pause_states" data-reference-type="ref" data-reference="fig:loop_pause_states">11</a>
dargestellt.

<figure>
<img src="../assets/img/loop_pause_states.svg" id="fig:loop_pause_states" alt="Zustandsdiagramm mit Button Beschriftung." /><figcaption aria-hidden="true">Zustandsdiagramm mit Button Beschriftung.</figcaption>
</figure>

Im `onClick`-Listener des Start Buttons muss je nach aktuellem Zustand
der Schleife zwischen Start, Pause und Resume unterschieden werden:

``` java
btnStart.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        LoopState state = getLoopState();
        switch(state) {
            case CREATED:
            case STOPPED:
                loopStart(); // start if CREATED or STOPPED
                break;
            case RUNNING:
                loopPause(); // pause if RUNNING
                break;
            case PAUSED:
                loopResume(); // resume if paused
                break;
        }
    }
});
```

Zusätzlich wird die Beschriftung des Start Buttons über die Lifecycle
Methoden geändert:

``` java
public class MainActivity extends FixedRateLoopActivity {
    // ... some more code above
    
    @Override
    protected void onLoopResume() {
        super.onLoopResume();
        setWidgetText(btnStart, "Pause");
    }
    
    @Override
    protected void onLoopStart() {
        super.onLoopStart();
        setWidgetText(btnStart, "Pause");
    }
    
    @Override
    protected void onLoopPause() {
        super.onLoopPause();
        setWidgetText(btnStart, "Resume");
    }
    
    @Override
    protected void onLoopStop() {
        super.onLoopStop();
        setWidgetText(btnStart, "Start");
    }
    
    // ... some more code below
}
```

<figure>
<img src="../assets/img/layout_slider.png" id="fig:007_layout_slider" alt="Layout mit zusätzlicher Seekbar und TextView." /><figcaption aria-hidden="true">Layout mit zusätzlicher Seekbar und TextView.</figcaption>
</figure>

### Periode ändern

Um die Frequenz der Schleifenaufrufe aus der UI steuern zu können wird
im Layout eine `SeekBar` ``skbFreq`` sowie eine weitere ``TextView`` ``txtFreq`` wie in Abbildung
<a href="#fig:007_layout_slider" data-reference-type="ref" data-reference="fig:007_layout_slider">12</a>
erstellt.

``` java
public class MainActivity extends FixedRateLoopActivity {
    // ... some more code above
    
    Button btnStart, btnStop;
    TextView txtCounterValue;
    
     // add new variables for UI elements
    TextView txtFreq;
    SeekBar skbFreq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCounter = findViewById(R.id.txtCounter);
        txtCounter.setText("");

        txtFreq = findViewById(R.id.txtFreq);

        skbFreq = findViewById(R.id.seekBar);
        skbFreq.setOnSeekBarChangeListener(new AbstractOnSeekBarChangeListener() {
            final double minValue = 1;
            final double maxValue = 50;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int freq = (int) (minValue + ((maxValue-minValue)*(progress/100.0)));
                setLoopFrequency(freq);
                setWidgetText(txtFreq, "" + freq + " Hz");
            }
        });
        skbFreq.setProgress(5);
    // ... some more code below
```

Anwendung
=========

Eine weitere Android Library "snake" soll eine einfache Anwendung des
Loopers zeigen. Es handelt sich dabei um eine einfache Version des Nokia
Klassikers "Snake". In das bestehende Layout wird dafür das
benutzerdefinierte Element `SnakeView` eingefügt. Da es sich dabei um
kein Standardelement handelt, kann es auch nicht über den Layout Editor
eingefügt werden. Die Layout Datei "activity\_main.xml" muss im
Textmodus geöffnet werden und im bereits angelegten `FrameLayout` wird
das neue Element hinzugefügt:

``` xml
<FrameLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_weight="1">

    <edu.mci.snake.views.SnakeView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/snakeView" />
</FrameLayout>
```

Im nächsten Schritt müssen die loop-Methoden so angepasst werden,
dass statt des einfachen Zählers das Spiel gesteuert wird.

``` java
// ... more code above
    @Override
    protected void loopSetup() {
        score = 0;
        snakeView.setup(20,30,5,true, 10, 20);
        snakeView.start();
    }

    @Override
    protected void loopIteration() {
        score++;
        setWidgetText(txtCounter, String.valueOf(snakeView.getScore()));

        GameState state = snakeView.update();
        if(state == GameState.GameOver) {
            loopStop();
        }
    }

    @Override
    protected void loopTearDown(boolean error) {
        snakeView.stop();
    }
// ... more code below
```

Mit Klick auf den Start Button wird das Spiel also gestartet. Fehlt nur noch die Steuerung.

Steuerung
====================
Am Ende wird noch die Steuerung per Keyboard für den Emulator implementiert:

``` java
public class MainActivity extends FixedRateLoopActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        snakeView = (SnakeView) findViewById(R.id.snakeView); // add SnakeView
        snakeView.setOnTouchListener(this); // set onTouch listener
    
        // ... some more code
    }


    // This method gets called when keyboard is used
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (getLoopState() == LoopState.RUNNING) { // only react when loop is running
            Direction dir = directionFromKeyEvent(event); // get movement direction
    
            if (dir != Direction.Forward) { // turn snake if other than neutral direction
                snakeView.turnSnake(dir);
                return true; // acknowledge to android that we reacted on the input
            }
        }
        return false; // we did not react on the input in this case
    }
    
    private Direction directionFromKeyEvent(KeyEvent event) {
        Direction dir = Direction.Forward; // neutral direction
    
        if (event.getAction() == KeyEvent.ACTION_DOWN) { // only when first pressed
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_A:
                    dir = Direction.Left;
                    break;
                case KeyEvent.KEYCODE_D:
                    dir = Direction.Right;
                    break;
            }
        }
    
        return dir;
    }
    // ... some more code below
}
```

Im Emulator kann nun kann die Schlange mit den Tasten "A" und "D" nach
links bzw. nach rechts gesteuert werden. Mit Touchscreen bewirkt ein
Tipp auf der rechten linken Seite des Spielfeldes eine Linkskurve und
ein Tipp auf der rechten Seite eine Rechtskurve. Abbildung
<a href="#fig:008_snake_final" data-reference-type="ref" data-reference="fig:008_snake_final">13</a>
zeigt die finale Version der App.

<figure>
<img src="../assets/img/snake_final.png" id="fig:008_snake_final" alt="Fertige Ansicht der Workshop &quot;Snake&quot; App." /><figcaption aria-hidden="true">Fertige Ansicht der Workshop "Snake" App.</figcaption>
</figure>
