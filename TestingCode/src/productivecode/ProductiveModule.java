package productivecode;

import java.util.Date;

public class ProductiveModule implements ISomeModule {
	
	public Date getDate() {
		return new Date();
	}
}