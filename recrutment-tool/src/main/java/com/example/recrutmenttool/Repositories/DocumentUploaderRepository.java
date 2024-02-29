package com.example.recrutmenttool.Repositories;

import com.example.recrutmenttool.models.Documents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentUploaderRepository extends JpaRepository<Documents,Integer> {
}
