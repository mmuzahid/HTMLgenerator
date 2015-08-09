/*
* Developer:         MD. MUZAHIDUL ISLAM
* Email:             CV.MUZAHID@GMAIL.COM
* Environment:       JDK 1.6
* Date:              09-AUG-2015
* */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * abstract base class for Markup Tag(e.g. XML, HTML)
 * */
public abstract class Tag {
	protected static final String NEW_LINE = "\n";
	protected static final String INDENT_SPACE = "\t";
	protected static final String SPACE = " ";
	protected static final String EQUALS = "=";
	protected static final String DOUBLE_QT = "\"";
	protected static final String GREATER_THAN = ">";
	protected static final String LESS_THAN = "<";
	protected static final String SLASH = "/";
	
	
	protected int level;
	protected String tagName;
	protected Map<String, String> tagAttributes;
	private boolean isPairedTag = true;
	
	protected String content = "";
	
	protected Tag parentTag;
	protected List<Tag> childTagList = new ArrayList<Tag>();
	
	public boolean isFormatted = true;
	
	public Tag(String name) {
		this.tagName = name;
		tagAttributes = new LinkedHashMap<String, String>();
	}
	
	public String getTagId() {
		return getAttribute("id");
	}

	protected boolean isPairedTag() {
		return isPairedTag;
	}

	protected void setPairedTag(boolean isPairedTag) {
		this.isPairedTag = isPairedTag;
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
	
	private Tag getParentTag() {
		return parentTag;
	}

	private void setParentTag(Tag parentTag) {
		this.parentTag = parentTag;
		this.level = this.getParentTag() == null ? 1 : parentTag.level + 1;
	}

	public boolean hasChildTag() {
		return childTagList.size() > 0;
	}

	public void addChildTag(Tag tag) {
		childTagList.add(tag);
		tag.setParentTag(this);
	}

	public boolean isFormatted() {
		return isFormatted;
	}

	public void setFormatted(boolean isFormatted) {
		this.isFormatted = isFormatted;
		for (Tag childTag : childTagList) {
			childTag.setFormatted(isFormatted);
		}
	}

	/**
	 * implementation depends on Tag type(e.g. XML, HTML)
	 * */
	public abstract String toString();
	
}
