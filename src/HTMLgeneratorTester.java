
public class HTMLgeneratorTester {

	public static void main(String args[]) {
		HtmlDoc html = new HtmlDoc();
		html.addHeadTag("title", "HTMLgenerator");
		HtmlTag p = html.addBodyTag("p", "My Paragraph");
		p.setAttribute("id", "i11");
		p.setAttribute("value", "attr-val");
		HtmlTag a = new HtmlTag("a");
		a.setAttribute("href", "https://github.com/mmuzahid/HTMLgenerator");
		a.setContent("GITHUB - HTMLgenerator");
		p.addChildTag(a);

		System.out.println(html.toUnformattedString() );
		System.out.println(html.toString() );

	}
}
