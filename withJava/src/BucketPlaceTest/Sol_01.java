package BucketPlaceTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Sol_01 {
	public static void main(String[] args) {
		String[] products = new String[] {
			"towel red long thin", "blanket red thick short", "curtain red long wide", "mattress thick", "hat red thin", "pillow red long", "muffler blue thick long"
		};

		String[] purchased = new String[] {
			"blanket", "curtain", "hat", "muffler"
		};

		solution(products, purchased);
	}

	private static String solution(String[] products, String[] purchased) {
		String answer = "";
		List<Product> productList = new ArrayList<>();
		Map<String, Integer> tagMap = new HashMap<>();

		for (String productString : products) {
			String[] productInfo = productString.split(" ");

			productList.add(new Product(productInfo));
		}

		List<Product> able = new ArrayList<>();
		for (Product product : productList) {
			if (Arrays.asList(purchased).contains(product.name)) {
				product.countTags(tagMap);
			} else {
				able.add(product);
			}
		}

		List<Tag> tags = new ArrayList<>();
		for (String tagName : tagMap.keySet()) {
			tags.add(new Tag(tagName, tagMap.get(tagName)));
		}
		Collections.sort(tags, new TagSort());

		Product answerProduct = able.get(0);
		for (int i = 1; i < able.size(); i++) {
			Product compProduct = able.get(i);
			if (compProduct.isPriorThan(answerProduct, tags)) {
				answerProduct = compProduct;
			}
		}

		answer = answerProduct.name;
		System.out.println(answer);
		return answer;
	}
}

class Product {
	public static final int PRODUCT_NAME_INDEX = 0;

	String name;
	List<String> tags = new ArrayList<>();

	public Product(String[] productInfo) {
		this.name = productInfo[PRODUCT_NAME_INDEX];
		for (int i = 1; i < productInfo.length; i++) {
			addTag(productInfo[i]);
		}
	}

	public void addTag(String tag) {
		tags.add(tag);
	}

	public void countTags(Map<String, Integer> tagMap) {
		for (String tag : tags) {
			if (tagMap.get(tag) == null) {
				tagMap.put(tag, 1);
				continue;
			}
			tagMap.put(tag, tagMap.get(tag) + 1);
		}
	}

	public boolean isPriorThan(Product compProduct, List<Tag> sortedTag) {
		for (Tag tag : sortedTag) {
			if (this.tags.contains(tag.name)
				&& compProduct.tags.contains(tag.name)) {
				continue;
			} else if (this.tags.contains(tag.name)) {
				return true;
			} else if (compProduct.tags.contains(tag.name)) {
				return false;
			} else if (!this.tags.contains(tag.name)
				&& !compProduct.tags.contains(tag.name)) {
				continue;
			}
		}

		return true;
	}
}

class Tag implements Comparable<Tag> {
	String name;
	int count;

	public Tag(String name, int count) {
		this.name = name;
		this.count = count;
	}

	@Override
	public int compareTo(Tag o) {
		return 0;
	}
}

class TagSort implements Comparator<Tag> {

	int cmp = 0;

	@Override
	public int compare(Tag t1, Tag t2) {
		if (t1.count < t2.count) {
			cmp = 1;
		} else if (t1.count > t2.count) {
			cmp = -1;
		} else {
			int cmpResult = t1.name.compareTo(t2.name);
			if (cmpResult > 0) {
				cmp = 1;
			} else {
				cmp = -1;
			}
		}

		return cmp;
	}
}