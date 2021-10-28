package com.model;

import java.util.Objects;

public class Article {

	private String articleId;
	private String articleName;
	private int articlePrice;
		
	public Article() {
	}

	public Article(String articleId, String articleName, int articlePrice) {
		this.articleId = articleId;
		this.articleName = articleName;
		this.articlePrice = articlePrice;
	}

	public String getArticleId() {
		return articleId;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}

	public String getArticleName() {
		return articleName;
	}

	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}

	public int getArticlePrice() {
		return articlePrice;
	}

	public void setArticlePrice(int articlePrice) {
		this.articlePrice = articlePrice;
	}

	@Override
	public int hashCode() {
		return Objects.hash(articleId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Article other = (Article) obj;
		return Objects.equals(articleId, other.articleId);
	}

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", articleName=" + articleName + ", articlePrice=" + articlePrice
				+ "]";
	}
}
