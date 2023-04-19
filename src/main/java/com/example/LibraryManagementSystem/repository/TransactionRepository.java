package com.example.LibraryManagementSystem.repository;

import com.example.LibraryManagementSystem.entity.Transactions;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
}
