package edu.kh.model.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Member {
 private int memberNo;
 private String memberId;
 private String memberPw;
 private String memberName;
 private String enrollDate;
 private String memberDelFl;
}
