package com.app.blog.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="blog_post")
public class BlogPost {

	@Id
	@Column(name="blog_id", unique=true, nullable=false )
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long blogId;
	
	@Column(name="blog_desc", nullable=false)
	private String blogDesc;
	
	@JoinColumn(name="author_id",referencedColumnName="user_id")
	@ManyToOne(targetEntity =User.class)
	private User user;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "blogPost")
	/*@Fetch(FetchMode.SELECT)
    @BatchSize(size = 10)
	@Cascade(CascadeType.ALL)*/
	private Set<BlogComment> comment;

	public Set<BlogComment> getComment() {
		return comment;
	}

	public void setComment(Set<BlogComment> comment) {
		this.comment = comment;
	}

	public long getBlogId() {
		return blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public String getBlogDesc() {
		return blogDesc;
	}

	public void setBlogDesc(String blogDesc) {
		this.blogDesc = blogDesc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
	
	
}
