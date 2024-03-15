package com.springio.test.service;

import com.springio.test.domain.Profile;
import com.springio.test.repository.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    /*
    public Page<Profile> findProfileList(Pageable pageable){
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize());
        return profileRepository.findAll(pageable);
    }
    */

    public Profile findProfileByIdx(Long idx){
        return profileRepository.findById(idx).orElse(new Profile());
    }

    public List<Profile> findProfileListCollections() {
        return profileRepository.findAll();
    }
    public Profile getsoneProfile(Long idx){
        return profileRepository.getOne(idx);
    }

    public Profile saveProfile(Profile profile){
        return profileRepository.save(profile);
    }

    public void deleteByProfileId(Long idx){
        profileRepository.deleteById(idx);
    }

    public void updateProfile(Profile profile, Long idx) {
        Profile persistProfile = profileRepository.getOne(idx);
        persistProfile.updateProfile(profile);
        profileRepository.save(persistProfile);
    }
}
