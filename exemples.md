J'ai participé au cours LFSAB1401 et j'ai trouvé stimulante la réalisation des exercices en lignes sur le site du cours ou enore durant mon apprentissage personnel je suis tombé sur des colles que je trouverais intéressant de transformer en exercices pour la postérité.

Cela peut être réalisé en suivant quelques étapes simples.

###Je rédige la question

Par exemple,

*"Ecrivez la signature et le corps d’une methode baptisée afficheMax qui prend deux nombres entiers comme arguments et affiche le plus grand de ces nombres. La spécification de cette méthode est :"*

```java
   /**
    ∗ @pre -
    ∗ @post affiche le maximum entre les nombres entiers a et b
    *
    ∗ /
```

###J'écris la réponse à la question

L'ideal serait que je connaisse tout de même déja la réponse à la question que je souhaite poser :)

Je me sert de blueJ pour écrire le code java qui correspond à la réponse correcte. J'encapsule ma méthode dans une classe nommée MonExoCorr:

```java
package student;

/**
 * Ecrivez la signature et le corps d’une methode baptisée
 * afficheMax qui prend deux nombres entiers comme arguments
 * et affiche le plus grand de ces nombres. 
 * 
 * @auteur (pénom nom) 
 * @version (version 1)
 */
public class MonExoCorr 
{
   /**
    * @pre -
    * @post affiche le maximum entre les nombres entiers a et b
    */
   public void afficheMax(int a, int b)
    {
            System.out.println(Math.max( a,b));
    }
}
```

J'écris aussi une réplique de la classe MonExoCorr nommé MonExoStu qui outre le nom contient exactement le même code:

```java
package student;

/**
 * Ecrivez la signature et le corps d’une methode baptisée
 * afficheMax qui prend deux nombres entiers comme arguments
 * et affiche le plus grand de ces nombres. 
 * 
 * @auteur (votre nom) 
 * @version (numéro de version ou date)
 */
public class MonExoStu
{
   /**
    * @pre -
    * @post affiche le maximum entre les nombres entiers a et b
    */
   public void afficheMax(int a, int b)
    {
            System.out.println(Math.max( b,b));
    }
}
```

###J'écris les classes de tests qui vont permettre de vérifier les résultats.

A force d'écrire des tests des programmeurs en sont venus à la conclusion qu'il serait très utile de créer un outil spécifique pour cela. Je décide de leur faire confiance :)

L'emploi du framework JUnit à été vue en fin de quadrimestre.

La première classe de test que j'écrit ressemble a priori à ceci :

```java

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Ecrivez la signature et le corps d’une methode baptisée
 * afficheMax qui prend deux nombres entiers comme arguments
 * et affiche le plus grand de ces nombres.
 *
 * @auteur  (prénom nom)
 * @version (version 1)
 */
public class MonExoTests extends junit.framework.TestCase
{
    //varibles de classe
    private int a ;
    private int b ;
    private String rep1;
    private String rep2;
 
    private Random gen = new Random();
    private MonExoStu monExoStu;
    private MonExoCorr monExoCorr;
    
    /**
     * Constructeur par défaut de la classe MonExoTests extends juint.framework.TestCase
     */
    public MonExoTests()
    {
        monExoStu = new MonExoStu();
        monExoCorr = new MonExoCorr();
    }

    /**
     * Préparations péallables au test
     *
     * Appelée avant chaque méthode de la classe
     */
    public void setUp()
    {
    }

    /**
     * Opérations pour terminer les tests
     *
     * Appelée après chaque méthode de la classe
     */
    public void tearDown()
    {
    }
    
    /**
     * @pre gen est initilaisé
     * @post -
     */
    public void testCorrectnessWhenAEqualsB()
    {
    }

    /**
     * @pre gen est initilaisé
     * @post -
     */
    public void testCorrectnessWhenAGreaterThanB()
    {
    }
      
    /**
     * @pre gen est initilaisé
     * @post -
     */
    public void testCorrectnessWhenASmallerThanB()
    {
    }
}
```
J'ai écrit le squelette d'un ``TestCase`` avec trois tests qui représentent *indépendamment* trois situations dans lesquelles la question de mon énoncé pourrait être posée.
| Remarque|
|:-----------------------------------------------------------------------:|
| L'un des talents que cela développe d'écrire des tests est *d'imaginer* le comportement d'un bout de code informatique dans différentes situations données et de déterminer lesquelles ce ces situations sont les plus intéressantes à vérifer.|


J'identifie trois situations lorsque une méthode doit calculer le maximum de deux entiers donnés:

- les deux entiers sont égaux
- le premier est plus grand que le second
- le second est plus grand que le premier

Il je ne trouve aucun entier en particulier qui dérroge à cet ensemble de situations.

Losqu'on écrit des tests il est normal d'avoir parfois de longs noms de méthodes car lorsque seules les signatures de méthodes sont affichées à l'utilisateur il faut pouvoir donner un maximum d'informations sur ce que cette méthode a trouvé comme erreur. Mais dans une situation "normale" de programmation cela serait plutôt un piètre choix de conception.

Concernant les variables de classe, l'objet ``Random`` va m'aider à rendre les tests plus "vivants". Une utilité secondiare pourra aussi être d'empècher l'étudiant de deviner les valeurs de test ou (très secondairement) de me faire découvrir des situations spécifiques à tester auquelles je n'avais pas encore pensé.

Les paramètres ``a`` et ``b`` à passer à la méthode à vérifier, les classes ``monExoStu`` ``monExoCorr`` qui contiennent la réponse de l'étudiant et le corrigé de l'exercice ainsi que des variables qui contiendront les valeur renvoyées sont également mis en varibles de classe.


Il va me falloir ensuite mettre un contenu à mes méthodes de test. En simple, ce que je voudrais faire c'est ceci:

```java

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Random;

/**
 * Ecrivez la signature et le corps d’une methode baptisée
 * afficheMax qui prend deux nombres entiers comme arguments
 * et affiche le plus grand de ces nombres.
 *
 * @auteur  (votre nom)
 * @version (la version ou une date)
 */
public class MonExoTests extends junit.framework.TestCase
{
    //varibles de classe
    private int a ;
    private int b ;
    private String rep1;
    private String rep2;
 
    private Random gen = new Random();
    private MonExoStu monExoStu;
    private MonExoCorr monExoCorr;

    private PrintStream old = System.out;
    private ByteArrayOutputStream baos1;
    private ByteArrayOutputStream baos2;
    private PrintStream ps1;
    private PrintStream ps2;

    
    /**
     * Constructeur par défaut de la classe MonExoTests
     */
    public MonExoTests()
    {
        monExoStu = new MonExoStu();
        monExoCorr = new MonExoCorr();
    }

    /**
     * Préparations péallables au test
     *
     * Appelée avant chaque méthode de la classe
     */
    public void setUp()
    {
    }

    /**
     * Opérations pour terminer les tests
     *
     * Appelée après chaque méthode de la classe
     */
    public void tearDown()
    {
    }
    
    /**
     * @pre gen est initilaisé
     * @post -
     */
    public void testCorrectnessWhenAEqualsB()
    {
        //initialisation des valeurs de test
        a = gen.nextInt();
        b = a;
        //lancement d'une routine de test qui vérifie
        //les réponses imprimées en sortie standard
        assertPrintsRightAnswer();
    }

    /**
     * @pre gen est initilaisé
     * @post -
     */
    public void testCorrectnessWhenAGreaterThanB()
    {
        //initialisation des valeurs de test
        a = gen.nextInt();
        while(a <= b){
            b = gen.nextInt();
        }
        //lancement d'une routine de test qui vérifie
        //les réponses imprimées en sortie standard
        assertPrintsRightAnswer();
    }

      
    /**
     * @pre gen est initilaisé
     * @post -
     */
    public void testCorrectnessWhenASmallerThanB()
    {
        //initialisation des valeurs de test
        a = gen.nextInt();
        while(a >= b){
            b = gen.nextInt();
        }
        //lancement d'une routine de test qui vérifie
        //les réponses imprimées en sortie standard
        assertPrintsRightAnswer();
    }
}
```
Je voudrais vérifier que le code de l'étudiant et le code du corrigé impriment bien la même réponse à l'écran en me servant des assertions de JUnit.

La méthode ``nextInt()`` est l'une des méthodes rendues disponibles par le générateur pour créer des valeurs entières alétoires. Je génère donc des valeurs jusqu'à ce qu'elles respectent mes spécifications pour ``a`` et ``b``.

Mais ma classe test ne peut pas encore être exécutée car en vrai une méthode assertPrintsRightAnswer() n'existe pas. Toutefois, comme vous aurez pu le remarquer en programmation, tout ce dont on a besin et qui n'existe pas n'attend que d'être crée :

```java
	/**
	 * @pre -
	 * @post -
	 */
	private void assertPrintsRightAnswer() 
	{
	        //initialisations
			baos1 = new ByteArrayOutputStream();
			baos2 = new ByteArrayOutputStream();
			ps1 = new PrintStream(baos1);
			ps2 = new PrintStream(baos2);
			// suaver le flux normal
			PrintStream old = System.out;
			// dire à java qu'il faut utiliser mon flux
			System.setOut(ps1);
			// exécution du code correct
			m3q4corr.afficheMax(a, b);
			//changer à nouveau le flux
			System.out.flush();
			System.setOut(ps2);
			try{
				m3q4stu.afficheMax(a, b);
			}
			catch(Throwable e){
				fail("Vous effectuez une opération "
						+ "illégale dans votre code: "+e.getMessage());
			}
			// Remettre les choses en place 
			System.out.flush();
			System.setOut(old);
			//Récupérerles réponses
			rep1 = baos1.toString();
			rep2 = baos2.toString();
			//effectuer la vérifiaction
			assertTrue("Votre réponse n'est pas la réponse attendue."
					+ "\nVotre réponse: "+rep2+
					"\nLa réponse attendue : "+rep1, rep1.equals(rep2));
		}
```
Cette méthode auxiliaire détourne les Strings que l'exécution du code des deux exercices afficherait à l'écran et les met dans les variables ``rep1`` et ``rep2``. Elle compare ensite à l'aide de la méthode equals le contenu des deux String et lance une exception de type ``AssertionError`` si le contenu n'est pas le même. Vous n'avez pas à comprendre le contenu de cette méthode en détails jusqu'à l'appel de la méthode ``asssertTrue()``. La section **!!!lien!!!** vous parles d'autres méthodes utiles disponibles dans JUnit.

Le rendu final de ma classe est le suivant:

```java
package student;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Random;

/**
 * Ecrivez la signature et le corps d’une methode baptisée
 * afficheMax qui prend deux nombres entiers comme arguments
 * et affiche le plus grand de ces nombres.
 *
 * @auteur  (prénom nom)
 * @version (version 1)
 */
public class MonExoTests extends junit.framework.TestCase
{
    //varibles de classe
    private int a ;
    private int b ;
    private String rep1;
    private String rep2;
 
    private Random gen = new Random();
    private MonExoStu monExoStu;
    private MonExoCorr monExoCorr;

    private PrintStream old = System.out;
    private ByteArrayOutputStream baos1;
    private ByteArrayOutputStream baos2;
    private PrintStream ps1;
    private PrintStream ps2;

    
    /**
     * Constructeur par défaut de la classe MonExoTests extends juint.framework.TestCase
     */
    public MonExoTests()
    {
        monExoStu = new MonExoStu();
        monExoCorr = new MonExoCorr();
    }

    /**
     * Préparations péallables au test
     *
     * Appelée avant chaque méthode de la classe
     */
    public void setUp()
    {
		baos1 = new ByteArrayOutputStream();
		baos2 = new ByteArrayOutputStream();
		ps1 = new PrintStream(baos1);
		ps2 = new PrintStream(baos2);
    }

    /**
     * Opérations pour terminer les tests
     *
     * Appelée après chaque méthode de la classe
     */
    public void tearDown()
    {
    }
    
    /**
     * @pre gen est initilaisé
     * @post -
     */
    public void testCorrectnessWhenAEqualsB()
    {
        //initialisation des valeurs de test
        a = gen.nextInt();
        b = a;
        //lancement d'une routine de test qui vérifie
        //les réponses imprimées en sortie standard
        assertPrintsRightAnswer();
    }

    /**
     * @pre gen est initilaisé
     * @post -
     */
    public void testCorrectnessWhenAGreaterThanB()
    {
        //initialisation des valeurs de test
        a = gen.nextInt();
        while(a <= b){
            b = gen.nextInt();
        }
        //lancement d'une routine de test qui vérifie
        //les réponses imprimées en sortie standard
        assertPrintsRightAnswer();
    }

      
    /**
     * @pre gen est initilaisé
     * @post -
     */
    public void testCorrectnessWhenASmallerThanB()
    {
        //initialisation des valeurs de test
        a = gen.nextInt();
        while(a >= b){
            b = gen.nextInt();
        }
        //lancement d'une routine de test qui vérifie
        //les réponses imprimées en sortie standard
        assertPrintsRightAnswer();
    }
  
  	/**
	 * @pre -
	 * @post -
	 */
	private void assertPrintsRightAnswer() 
	{
		// suaver le flux normal
		old = System.out;
		// dire à java qu'il faut utiliser mon flux
		System.setOut(ps1);
		// exécution du code correct
		monExoCorr.afficheMax(a, b);
		//changer à nouveau le flux
		System.out.flush();
		System.setOut(ps2);
		try{
			monExoStu.afficheMax(a, b);
		}
		catch(Throwable e){
			fail("Vous effectuez une opération "
					+ "illégale dans votre code: "+e.getMessage());
		}
		// Remettre les choses en place 
		System.out.flush();
		System.setOut(old);
		//Récupérerles réponses
		rep1 = baos1.toString();
		rep2 = baos2.toString();
		//effectuer la vérifiaction
		assertTrue("Votre réponse n'est pas la réponse attendue."
				+ "\nVotre réponse: "+rep2+
				"\nLa réponse attendue : "+rep1, rep1.equals(rep2));
	}
}
```

En utilisant les fonctionalités de BlueJ afin d'écrire ces tests, BlueJ s'est chargé lui-même de mettre en place le reste des classes nécessaires. 

Afin que mes tests deviennent plus portables, la section **!!!lien!!!** vous montre comment écrire le reste des classes requises. La sections **!!!lien!!!** explique les conventions que nous avons utilisées pou cela. Dans mon cas, il faudra juste une classe MonExo qui contiendra la méthode main qui fera tourner les tests et qui récupèrera les résultats:
```java
package student;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Random;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;

/**
 * Ecrivez la signature et le corps d’une methode baptisée
 * afficheMax qui prend deux nombres entiers comme arguments
 * et affiche le plus grand de ces nombres.
 *
 * @auteur  (votre nom)
 * @version (la version ou une date)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({

	/**
	 * Mettre ici la liste des classes tests
	 * qui constituent la TesteSuite.
	 */
	MonExoTests.class
})
public class MonExo
{
	public static void main(String[] args) 
	{
		Result result = JUnitCore.runClasses(MonExoTests.class);
		Iterator<Failure> failures = result.getFailures().iterator();
		Failure f;
		while(failures.hasNext()){
			f = failures.next();
			System.err.println(f.getMessage());
		}
		if(result.wasSuccessful() == true){
			//127 : nombre magique afin de signaler
			// que tout les tests sont passés.
			System.exit(127);
		}
	}
}
```
Vous remarquerez que grace à l'exrension de la classe ``TestCase``,
je n'ai pas besoin de me servir de la classe ``Assert`` ni de mettre entre autres les annotations ``@Test`` au dessus des méthodes.

[Exécution dans BlueJ][]

Un autre exemple de comment écrire un test pour un exercice donné se trouve dans la section **lien**.

