package SKTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sol2_1 {

	public static void main(String[] args) {
		String[] arr = new String[] {"abcdeabcd","cdabe","abce","bcdeab"};
		solution(arr);
	}

	private static String[] solution(String[] goods) {
		String[] answer = {};
		Products products = new Products();

		products.saveProductByGoods(goods);

		int wordLength = 1;
		while (!products.isSearchEnd()) {
			List<Product> productList = products.getProducts();
			for (Product product : productList) {
				product.findOwnSearchWord(goods, wordLength);
			}
			wordLength++;
		}

		answer = products.toArray();

		System.out.println(answer);

		return answer;
	}
}

class Product {
	private static final String LETTER_NULL = " ";

	String productName;
	char[] productLetter;
	String ownSearchWord = "";
	boolean isFind = false;

	public Product(String productName) {
		this.productName = productName;
		this.productLetter = productName.toCharArray();
	}

	public void findOwnSearchWord(String[] goods, int wordLength) {
		if (this.isFind) {
			return;
		}
		String[] words = setWordByLength(wordLength);
		if (words == null) {
			return;
		}

		for (String good : goods) {
			if (isSameProduct(good)) {
				continue;
			}

			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				if (good.contains(word)) {
					words[i] = LETTER_NULL;
				}
			}
		}

		if (isOwnSearchWord(words)) {
			saveToOwnSearchWord(words);
		}

	}

	private String[] setWordByLength(int wordLength) {
		int sizeOfWords = this.productName.length() - wordLength + 1;

		if (sizeOfWords == 0) {
			ownSearchWord = "None";
			isFind = true;

			return null;
		}


		String[] words = new String[sizeOfWords];

		for (int i = 0; i < words.length; i++) {
			String word = "";
			for (int j = i; j < i + wordLength; j++) {
				word += productLetter[j];
			}
			words[i] = word;
		}

		return words;
	}

	private boolean isSameProduct(String productName) {
		return productName.equals(this.productName);
	}

	private boolean isOwnSearchWord(String[] words) {
		int num = 0;
		for (String word : words) {
			if (word == LETTER_NULL) {
				num++;
			}
		}

		if (num == words.length) {
			return false;
		}
		return true;
	}

	private void saveToOwnSearchWord(String[] words) {
		List<String> resultString =
			Arrays.stream(words)
			.distinct()
			.sorted()
			.collect(Collectors.toList());

		for (String word : resultString) {
			if (word != LETTER_NULL) {
				this.ownSearchWord += word + " ";
			}
		}

		this.isFind = true;
		this.ownSearchWord.trim();
	}

}

class Products {
	private List<Product> products = new ArrayList<>();

	public void saveProductByGoods(String[] goods) {
		for (String good : goods) {
			products.add(new Product(good));
		}
	}

	public boolean isSearchEnd() {
		for (Product product : products) {
			if (!product.isFind) {
				return false;
			}
		}

		return true;
	}

	public List<Product> getProducts() {
		return products;
	}

	public String[] toArray() {
		int size = products.size();

		String[] answer = new String[size];
		for (int i = 0; i < size; i++) {
			answer[i] = products.get(i)
				.ownSearchWord.trim();
		}

		return answer;
	}
}