package todayspanish;

public abstract class AprenderSpanish {
	protected String categoryName;
	
	public AprenderSpanish(String categoryName) {
		super();
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
