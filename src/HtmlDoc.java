/*
* Developer:         MD. MUZAHIDUL ISLAM
* Email:             CV.MUZAHID@GMAIL.COM
* Environment:       JDK 1.6
* Date:              08-AUG-2015
* */

public class HtmlDoc {

	private static final String DOC_TYPE_HTML4_01 = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">";
	String docType = DOC_TYPE_HTML4_01;
	private HtmlTag htmlTag = new HtmlTag("html");
	private HtmlTag headTag = new HtmlTag("head");
	private HtmlTag bodyTag = new HtmlTag("body");
	
	public HtmlDoc() {
		htmlTag.addChildTag(headTag);
		htmlTag.addChildTag(bodyTag);
	}
	
	public HtmlTag addHeadTag(HtmlTag tag) {
		headTag.addChildTag(tag);
		return tag;
	}
	
	public HtmlTag addHeadTag(String tagName, String content) {
		HtmlTag tag = new HtmlTag(tagName);
		tag.setContent(content);
		return addHeadTag(tag);
	}

	public HtmlTag addBodyTag(HtmlTag tag) {
		bodyTag.addChildTag(tag);
		return tag;
	}

	public HtmlTag addBodyTag(String tagName, String content) {
		HtmlTag tag = new HtmlTag(tagName);
		tag.setContent(content);
		return addBodyTag(tag);
	}

	public String toUnformattedString() {
		return "";
	}
}
