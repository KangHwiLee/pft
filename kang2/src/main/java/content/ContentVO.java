package content;

public class ContentVO {

	private String title, content, category_name;
	private int idx, category;
	
	
	@Override
	public String toString() {
		return "ContentVO [title=" + title + ", content=" + content + ", category_name=" + category_name + ", idx="
				+ idx + ", category=" + category + "]";
	}
	
	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	
	
}
