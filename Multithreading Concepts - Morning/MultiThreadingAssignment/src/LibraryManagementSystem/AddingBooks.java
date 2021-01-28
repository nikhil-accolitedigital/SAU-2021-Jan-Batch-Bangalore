package LibraryManagementSystem;

public class AddingBooks implements Runnable {
	
	private Integer[] bookId;
	private Integer[] ISBN;
	private String[] bookName;
	private Boolean[] addToCart;
	private Boolean[] isCheckedout;
	private Boolean[] underReview;
	private String[] reviewUser;
	private BookServices queue;

	
	public AddingBooks(Integer[] bookId,  String[] bookName,Integer[] iSBN, Boolean[] addToCart, Boolean[] isCheckedout,
			Boolean[] underReview, String[] reviewUser, BookServices queue) {
		super();
		this.bookId = bookId;
		ISBN = iSBN;
		this.bookName = bookName;
		this.addToCart = addToCart;
		this.isCheckedout = isCheckedout;
		this.underReview = underReview;
		this.reviewUser = reviewUser;
		this.queue = queue;
	}


	@Override
	public void run() {
		for(int i=0;i<bookId.length;i++) {
			Book b = new Book(this.bookId[i], this.bookName[i],this.ISBN[i], this.addToCart[i], this.isCheckedout[i], this.underReview[i],this.reviewUser[i]);
			try {
				queue.put(b);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
