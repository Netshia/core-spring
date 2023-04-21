package com.ndivhuho.learnspring.springdata.projectiontype;

import com.ndivhuho.learnspring.springdata.entity.Member;

import java.util.List;

public interface MemberView {

    List<Member> members();
}
