package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tutorials")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Tutorial extends BaseEntity {
	// id | name | author | publish_date | visits | contents | topic_id
	@Column(name = "name")
	@NotBlank(message = "tut name is required")
	private String tutorialName;
	@NotBlank(message = "author is required")
	private String author;
	@Column(name = "publish_date")
	@NotNull(message = "Publish date must be supplied")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate publishDate;
	@NotNull(message = "visits can't be blank")
	private int visits;
	@NotBlank(message = "contents must be supplied")
	private String contents;
	// uni dir asso Tutorial *-->1 Topic
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "topic_id", nullable = false)
	private Topic topic;
	// bi dir asso between Tutorial n Comment
	@OneToMany(mappedBy = "tutorial", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments = new ArrayList<>();
	//add helper methods to add child n remove child
	public void addComment(Comment c)
	{
		//establish bi dir
		comments.add(c);//tut --> comment
		c.setTutorial(this);//comment ---> Tut
	}
	public void removeComment(Comment c)
	{
		//de-link bi dir
		comments.remove(c);//tut ----X----> comment
		c.setTutorial(null);//comment -------------X---------> Tut
	}
}
