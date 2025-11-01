package com.four.animory.repository.user;

import com.four.animory.domain.user.Member;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
  Member findByUsername(String username);
}
