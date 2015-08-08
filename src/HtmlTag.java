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

	public boolean isFormatted() {
		return isFormatted;
	}

	public void setFormatted(boolean isFormatted) {
		this.isFormatted = isFormatted;
		for (HtmlTag childTag : childTagList) {
			childTag.setFormatted(isFormatted);
		}
	}

	
}
