/*
* Developer:         MD. MUZAHIDUL ISLAM
* Email:             CV.MUZAHID@GMAIL.COM
* Environment:       JDK 1.6
* Date:              08-AUG-2015
* */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HtmlTag {
	
	private static final String NEW_LINE = "\n";
	private static final String INDENT_SPACE = "\t";
	private static final String SPACE = " ";
	private static final String EQUALS = "=";
	private static final String DOUBLE_QT = "\"";
	private static final String GREATER_THAN = ">";
	private static final String LESS_THAN = "<";
	private static final String SLASH = "/";

	private int level;
	private String tagName;
	private Map<String, String> tagAttributes;
	private boolean isPairedTag = true;
	private String content = "";
	
	private HtmlTag parentTag;
	private List<HtmlTag> childTagList = new ArrayList<HtmlTag>();
	
	public boolean isFormatted = true;
	
	public HtmlTag(String name) {
		this.tagName = name;
		tagAttributes = new LinkedHashMap<String, String>();
	}
	
	public String getTagId() {
		return getAttribute("id");
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setAttribute(String attrName, String attrValue) {
		tagAttributes.put(attrName, attrValue);
	}
	
	public String getAttribute(String attrName) {
		return tagAttributes.get(attrName);
	}
	
	public boolean hasAttribute(String attrName) {
		return tagAttributes.containsKey(attrName);
	}
	
	private HtmlTag getParentTag() {
		return parentTag;
	}

	private void setParentTag(HtmlTag parentTag) {
		this.parentTag = parentTag;
		this.level = this.getParentTag() == null ? 1 : parentTag.level + 1;
	}

	public boolean hasChildTag() {
		return childTagList.size() > 0;
	}

	public void addChildTag(HtmlTag tag) {
		childTagList.add(tag);
		tag.setParentTag(this);
	}

	private String getParentIndentSpace() {
		return  "";
	}

	public boolean isFormatted() {
		return isFormatted;
	}

	public void setFormatted(boolean isFormatted) {
		this.isFormatted = isFormatted;
		for (HtmlTag childTag : childTagList) {
			childTag.setFormatted(isFormatted);
		}
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
			tag.append(EQUALS);
			tag.append(DOUBLE_QT);
			tag.append(e.getValue());
			tag.append(DOUBLE_QT);
		}

		if (isPairedTag) {
			tag.append(GREATER_THAN);
			if (!content.isEmpty()) {
				tag.append(parentIndentSpace);
				tag.append(INDENT_SPACE);
				tag.append(content);
			}
			for (HtmlTag childTag : childTagList) {
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
