package edu.kh.model.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
  private int postNo;
  private String postTitle;
  private String postContent;
  private String postDate;
  private String postDelFl;
  private int memberNo;
}
