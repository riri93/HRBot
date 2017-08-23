package com.example.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.entity.NearStation;

@Repository
@RepositoryRestResource
public interface NearStationRepository  extends JpaRepository<NearStation, Serializable> {

}
