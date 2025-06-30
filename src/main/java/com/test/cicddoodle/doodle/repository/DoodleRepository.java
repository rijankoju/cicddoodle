package com.test.cicddoodle.doodle.repository;

import com.test.cicddoodle.doodle.entity.Doodle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoodleRepository extends JpaRepository<Doodle, Long> {
}
