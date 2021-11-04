package com.oliverB.quickTutorial.repositories;

import com.oliverB.quickTutorial.dataTypes.BlogPost;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

@Qualifier("blogDataRepository")
public interface BlogRepository extends JpaRepository<BlogPost, Long>{
}
