package LibraryManagementSystem;

public class Book {
	private Integer BookId;
	private String BookName;
	private Integer ISBN;
	private Boolean AddToCart;
	private Boolean isCheckedout;
	private Boolean underReview;
	private String reviewUser;
	
	public Book(Integer bookId, String bookName, Integer iSBN, Boolean addToCart, Boolean isCheckedout,
			Boolean underReview, String reviewUser) {
		super();
		BookId = bookId;
		BookName = bookName;
		ISBN = iSBN;
		AddToCart = addToCart;
		this.isCheckedout = isCheckedout;
		this.underReview = underReview;
		this.reviewUser = reviewUser;
	}

	public Integer getBookId() {
		return BookId;
	}

	public void setBookId(Integer bookId) {
		BookId = bookId;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public Integer getISBN() {
		return ISBN;
	}

	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}

	public Boolean getAddToCart() {
		return AddToCart;
	}

	public void setAddToCart(Boolean addToCart) {
		AddToCart = addToCart;
	}

	public Boolean getIsCheckedout() {
		return isCheckedout;
	}

	public void setIsCheckedout(Boolean isCheckedout) {
		this.isCheckedout = isCheckedout;
	}

	public Boolean getUnderReview() {
		return underReview;
	}

	public void setUnderReview(Boolean underReview) {
		this.underReview = underReview;
	}

	public String getReviewUser() {
		return reviewUser;
	}

	public void setReviewUser(String reviewUser) {
		this.reviewUser = reviewUser;
	}
	
	
	
	public void getdetails() {
		System.out.println("-------------Book Details ---------");
		System.out.println("Id : "+this.BookId);
		System.out.println("ISBN : "+this.ISBN);
		System.out.println("AddToCart : "+this.AddToCart);
		System.out.println("isCheckedout : "+this.isCheckedout);
		System.out.println("underReview : "+this.underReview);
		System.out.println("reviewUser : "+this.reviewUser);
	}
	

}
