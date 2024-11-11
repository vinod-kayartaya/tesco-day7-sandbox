package com.tesco.repository;

import com.tesco.entity.Customer;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerRepository extends CouchbaseRepository<Customer, UUID> {
}