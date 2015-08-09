import java.util.Map.Entry;

/*
* Developer:         MD. MUZAHIDUL ISLAM
* Email:             CV.MUZAHID@GMAIL.COM
* Environment:       JDK 1.6
* Date:              08-AUG-2015
* */


/**
 * Object represents an HTML Tag
 * */
public class HtmlTag extends Tag{

	public HtmlTag(String name) {
		super(name);
	}

	private String getParentIndentSpace() {
		StringBuilder parentIndentSpace = new StringBuilder("");
		
		if (isFormatted()) {
			parentIndentSpace.append(NEW_LINE);
			for (int i = 0; i < level; i++){
				parentIndentSpace.append(INDENT_SPACE);
			}
		}
		return parentIndentSpace.toString();
	}
	
	public void setAttribute(String attrName) {
		tagAttributes.put(attrName, null);
	}
	
	public String toString() {
		StringBuilder tag = new StringBuilder();
		String parentIndentSpace = getParentIndentSpace();
		
		tag.append(parentIndentSpace);
		tag.append(LESS_THAN);
		tag.append(tagName);
		
		for (Entry<String, String> e : tagAttributes.entrySet()) {
			tag.append(SPACE);
			tag.append(e.getKey());
			if (e.getValue() != null) {
				tag.append(EQUALS);
				tag.append(DOUBLE_QT);
				tag.append(e.getValue());
				tag.append(DOUBLE_QT);
			}
		}

		if (this.isPairedTag()) {
			tag.append(GREATER_THAN);
			if (!content.isEmpty()) {
				tag.append(parentIndentSpace);
				tag.append(INDENT_SPACE);
				tag.append(content);
			}
			for (Tag childTag : childTagList) {
				tag.append(childTag);
			}
			
			tag.append(parentIndentSpace);
			tag.append(LESS_THAN);
			tag.append(SLASH);
			tag.append(tagName);
			tag.append(GREATER_THAN);
			
		}	
		else {
			tag.append(SPACE);
			tag.append(SLASH);
			tag.append(GREATER_THAN);
		}
		return tag.toString();
	}

}
