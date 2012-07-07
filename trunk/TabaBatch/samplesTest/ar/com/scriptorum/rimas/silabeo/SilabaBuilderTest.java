package ar.com.scriptorum.rimas.silabeo;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;



public class SilabaBuilderTest {
	@Test
	public final void test() {
		//"ornitorrinco"
		//for(String s:new String[]{"catapultado","catamarqueño","chacabuco","atigrado","llamativo","atolondrado","bandera","abanderado","almeria","alegria", "rosario","rosariazo","rosarigasino","honrado" } ) {
		StringBuffer sb = new StringBuffer()
		.append("Ya que quieres, cruel, que se publique, ")
		.append("de lengua en lengua y de una en otra gente, ")
		.append("del áspero rigor tuyo la fuerza, ")
		.append("haré que el mismo infierno comunique ")
		.append("al triste pecho mío un son doliente, ")
		.append("con que el uso común de mi voz tuerza. ")
		.append("Y al par de mi deseo, que se esfuerza ")
		.append("a decir mi dolor y tus hazañas, ")
		.append("de la espantable voz irá el acento, ")
		.append("y en él mezcladas, por mayor tormento, ")
		.append("pedazos de las míseras entrañas. ")
		.append("Escucha, pues, y presta atento oído, ")
		.append("no al concertado son, sino al rüido ")
		.append("que de lo hondo de mi amargo pecho, ")
		.append("llevado de un forzoso desvarío, ")
		.append("por gusto mío sale y tu despecho. ")
		.append("El rugir del león, del lobo fiero ")
		.append("el temeroso aullido, el silbo horrendo ")
		.append("de escamosa serpiente, el espantable ")
		.append("baladro de algún monstruo, el agorero ")
		.append("graznar de la corneja, y el estruendo ")
		.append("del viento contrastado en mar instable; ")
		.append("del ya vencido toro el implacable ")
		.append("bramido, y de la viuda tortolilla ")
		.append("el sentible arrullar; el triste canto ")
		.append("del envidiado búho, con el llanto ")
		.append("de toda la infernal negra cuadrilla, ")
		.append("salgan con la doliente ánima fuera, ")
		.append("mezclados en un son, de tal manera ")
		.append("que se confundan los sentidos todos, ")
		.append("pues la pena cruel que en mí se halla ")
		.append("para contarla pide nuevos modos. ")
		.append("De tanta confusión no las arenas ")
		.append("del padre Tajo oirán los tristes ecos, ")
		.append("ni del famoso Betis las olivas: ")
		.append("que allí se esparcirán mis duras penas ")
		.append("en altos riscos y en profundos huecos, ")
		.append("con muerta lengua y con palabras vivas; ")
		.append("o ya en oscuros valles, o en esquivas ")
		.append("playas, desnudas de contrato humano, ")
		.append("o adonde el sol jamás mostró su lumbre, ")
		.append("o entre la venenosa muchedumbre ")
		.append("de fieras que alimenta el libio llano; ")
		.append("que, puesto que en los páramos desiertos ")
		.append("los ecos roncos de mi mal, inciertos, ")
		.append("suenen con tu rigor tan sin segundo, ")
		.append("por privilegio de mis cortos hados, ")
		.append("serán llevados por el ancho mundo. ")
		.append("Mata un desdén, atierra la paciencia, ")
		.append("o verdadera o falsa, una sospecha; ")
		.append("matan los celos con rigor más fuerte; ")
		.append("desconcierta la vida larga ausencia; ")
		.append("contra un temor de olvido no aprovecha ")
		.append("firme esperanza de dichosa suerte. ")
		.append("En todo hay cierta, inevitable muerte; ")
		.append("mas yo, ¡milagro nunca visto!, vivo ")
		.append("celoso, ausente, desdeñado y cierto ")
		.append("de las sospechas que me tienen muerto; ")
		.append("y en el olvido en quien mi fuego avivo, ")
		.append("y, entre tantos tormentos, nunca alcanza ")
		.append("mi vista a ver en sombra a la esperanza, ")
		.append("ni yo, desesperado, la procuro; ")
		.append("antes, por extremarme en mi querella, ")
		.append("estar sin ella eternamente juro. ")
		.append("¿Puédese, por ventura, en un instante ")
		.append("esperar y temer, o es bien hacerlo, ")
		.append("siendo las causas del temor más ciertas? ")
		.append("¿Tengo, si el duro celo está delante, ")
		.append("de cerrar estos ojos, si he de vello ")
		.append("por mil heridas en el alma abiertas? ")
		.append("¿Quién no abrirá de par en par las puertas ")
		.append("a la desconfianza, cuando mira ")
		.append("descubierto el desdén, y las sospechas, ")
		.append("¡oh amarga conversión!, verdades hechas, ")
		.append("y la limpia verdad vuelta en mentira? ")
		.append("¡Oh, en el reino de amor fieros tiranos ")
		.append("celos, ponedme un hierro en estas manos! ")
		.append("Dame, desdén, una torcida soga. ")
		.append("Mas, ¡ay de mí!, que, con cruel victoria, ")
		.append("vuestra memoria el sufrimiento ahoga. ")
		.append("Yo muero, en fin; y, porque nunca espere ")
		.append("buen suceso en la muerte ni en la vida, ")
		.append("pertinaz estaré en mi fantasía. ")
		.append("Diré que va acertado el que bien quiere, ")
		.append("y que es más libre el alma más rendida ")
		.append("a la de amor antigua tiranía. ");
		String [] palabras = sb.toString().split(" ");
		for(String s:palabras) {
			s = StringUtils.strip(s, ":,;.¡!¿?");
			Palabra palabra = new Palabra(s);
			palabra = new Silabeador().silabear(palabra);
			System.out.println(palabra.toString());
		}
	}

	
	
}
